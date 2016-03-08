#!/usr/bin/env coffee

child_process = require 'child_process'
readline      = require 'readline'
path          = require 'path'
logging       = require './util/logging'

logger = logging.LoggerFactory.getLogger path.basename __filename

title = ->

    logger.debug '# Command'

    return

cook = ->

    commands = ['ls']

    # コマンド実行

    for command in commands

        proc = child_process.spawn command
        # コマンドのpid取得
        pid = proc.pid
        logger.debug "#{command}[##{pid}] started"
        # コマンド実行結果（標準出力）を取得
        pipe = readline.createInterface
            input: proc.stdout
            terminal: false
        pipe.on 'line', (line) ->
            logger.debug line
            return
        proc.on 'close', (code, signal) ->
            logger.debug "#{command}[##{pid}] ended"
            return

    return

module.exports =
    title: title
    cook: cook
