#!/usr/bin/env coffee

moment = require 'moment-timezone'
logging = require './util/logging'

logger = logging.LoggerFactory.getLogger 'recipe_base'

title = ->

    logger.debug '# Base'

    return

cook = ->

    ## 変数展開

    name = 'Recipe'
    hello = "Hello #{name}!"
    logger.debug hello

    ## 現在時刻

    now = moment().utc()
    logger.debug now.format()

    now = moment().tz 'Asia/Tokyo'
    logger.debug now.format()

    return

module.exports =
    title: title
    cook: cook
