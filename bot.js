console.log("BumbleBot is starting...");

// Ensure NPM packages are installed
var Twit = require("twit");
var config = require("./config");
var exec = require("child_process").exec;
var fs = require("fs");

var T = new Twit(config);

loop();

function loop() {
  var now = new Date();
  if ((now.getHours() % 2 === 0) && now.getMinutes() === 0) {
    tweetIt();
  }
  now = new Date(); // allow for time passing
  var delay = 60000 - (now % 60000); // exact ms to next minute interval
  setTimeout(loop, delay);
}

function tweetIt() {
  // Path to Processing sketch
  var cmd = "bumblebot/bumblebot";
  exec(cmd, processing);

  function processing() {
    var imgFilename = "bumblebot/output.png"; // Path to image file output from Processing
    var imgParams = {
      encoding: "base64"
    }
    var imgBee = fs.readFileSync(imgFilename, imgParams); // Read image

    // var txtFilename = "bumblebot/output.txt"; // Path to text file output from Processing
    // var txtParams = {
    //   encoding: "utf8"
    // }
    // var txtBee = fs.readFileSync(txtFilename, txtParams); // Read text


    T.post("media/upload", { media_data: imgBee }, uploaded); // Upload image before tweeting

    function uploaded(err, data, response) {
      var id = data.media_id_string; // Read uploaded image
      var tweet = {
        status:     "", // Tweet text content
        media_ids:  [id] // Tweet image content
      }
      T.post("statuses/update", tweet, tweeted); // Send tweet
    }

    function tweeted(err, data, response) {
      if (err) {
        console.log("Error! Tweet not sent.");
      } else {
        console.log("Success! Tweet sent.");
      }
    }
  }
}
