#!/usr/bin/env coffee

moment = require 'moment-timezone'

module.exports.title = ->

    console.log '# Base'

    return

module.exports.cook = ->

    ## 変数展開

    name = 'Recipe'
    hello = "Hello #{name}!"
    console.log hello

    ## 現在時刻

    now = moment().utc()
    console.log now.format()

    now = moment().tz 'Asia/Tokyo'
    console.log now.format()

    return
