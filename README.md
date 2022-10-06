# Bumblebot

[![License: Hippocratic 3.0](https://img.shields.io/badge/License-Hippocratic_3.0-lightgrey.svg)](https://firstdonoharm.dev/version/3/0/full.html)

*NOTE: BumbleBot has been temporarily deactivated. It will return after some maintenance and added functionality in the near future.*

## Overview
[BumbleBot](https://twitter.com/beegenerator) is a Twitter bot created using [Node.js](https://nodejs.org/) and [Processing](http://processing.org/) to post procedurally generated bumblebees.

Originally written as a standalone Processing sketch to explore insect anatomy, it continues to generate accurate bee structures (its bumblebees have slight anatomical variations based on gender; see the antennae, hind legs and abdomen segments for example).

Future enhancements will include interactivity and procedurally generated names based on colour, gender, etc., as well as generating other types of bee (i.e. honey and solitary bees).

## Inspiration
Although not affiliated with any organisation, BumbleBot has been inspired by the work of the [Bumblebee Conservation Trust](http://bumblebeeconservation.org/), [IBRA](http://www.ibrabee.org.uk/) and Buglife's [Urban Buzz](https://www.buglife.org.uk/urban-buzz/) project, as well as [@mothgenerator](https://twitter.com/mothgenerator) by Katie Rose Pipkin and Loren Schmidt.

## Usage
BumbleBot requires the [twit](https://www.npmjs.com/package/twit) Node package to be installed in the `node_modules` subdirectory to communicate with Twitter.

The bot can be run using the following command:
```
$ node bot.js
```

API keys are required to interact with Twitter. These should be saved in the file `config.js` (not contained in this repo for obvious security reasons). Use the following formats:

#### config.js
```javascript
module.exports = {
  consumer_key:         'YOUR-KEY-HERE',
  consumer_secret:      'YOUR-KEY-HERE',
  access_token:         'YOUR-KEY-HERE',
  access_token_secret:  'YOUR-KEY-HERE',
  timeout_ms:           60*1000
}
```

## Disclaimer
This file only provides basic usage information and it is outside of the scope of this repo to provide additional support. I highly recommend following Daniel Shiffman's [Twitter Bot Tutorial](https://www.youtube.com/playlist?list=PLRqwX-V7Uu6atTSxoRiVnSuOn6JHnq2yV) series to learn more.

## License
BumbleBot is ethical open source software, offered under the Hippocratic License 3.0, a permissive license that enforces the licensee to comply with human rights principles and laws.

Other software packages and libraries used fall under their own respective licenses.
