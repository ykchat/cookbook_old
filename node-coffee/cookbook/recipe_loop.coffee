#!/usr/bin/env coffee

path = require 'path'
logging = require './util/logging'

logger = logging.LoggerFactory.getLogger path.basename __filename

title = ->

    logger.debug '# Loop'

    return

cook = ->

    nums = [0...5]
    pow = (x) -> 
        return x**2

    ## for文

    results = []
    for num in nums
        results.push pow num
    logger.debug results

    ## 内包表記

    results = (pow num for num in nums)
    logger.debug results

    ## map関数

    results = nums.map (num) -> 
        return pow num
    logger.debug results

    return

module.exports =
    title: title
    cook: cook
