#!/usr/bin/env coffee

fs = require 'fs'
readline = require 'readline'
path    = require 'path'
logging = require './util/logging'

logger = logging.LoggerFactory.getLogger path.basename __filename

title = ->

    logger.debug '# File'

    return

cook = -> new Promise (resolve) -> 

    name = path.resolve 'cooker.js'

    ## 基本情報

    logger.debug "dir=#{path.dirname name}"
    logger.debug "file=#{path.basename name}"
    logger.debug "size=#{fs.statSync(name)['size']}"

    ## 行数カウント

    reader = readline.createInterface
        input: fs.createReadStream name
    counter = 0
    reader.on 'line', (line) -> 
        counter += 1
        return
    reader.on 'close', -> 
        logger.debug "lc=#{counter}"
        resolve()
        return

    return

module.exports =
    title: title
    cook: cook
