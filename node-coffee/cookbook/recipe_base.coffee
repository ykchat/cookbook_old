#!/usr/bin/env coffee

moment = require 'moment-timezone'

title = ->

    console.log '# Base'

    return

cook = ->

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

module.exports =
    title: title
    cook: cook
