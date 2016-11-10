console.log('Bumblebot is starting...');

var Twit = require('twit');

// Twitter auth keys in config.js
var config = require('./config');
var T = new Twit(config);
