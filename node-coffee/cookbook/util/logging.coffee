#!/usr/bin/env coffee

class LoggerFactory

    @__log4js = require 'log4js'
    @__log4js.clearAppenders()

    @__loggers = {}

    @__appenderConfig =
        type: 'console'
        layout:
            type: 'pattern'
            pattern: "%d{ISO8601_WITH_TZ_OFFSET} [#%z] %c; %-5p %m"

    @getLogger = (name) ->

        if name of @__loggers
            return @__loggers[name]

        appender = @__log4js.appenderMakers['console'] @__appenderConfig
        @__log4js.addAppender(appender, name)

        logger = @__log4js.getLogger name
        @__loggers[name] = logger

        return logger

module.exports =
    LoggerFactory: LoggerFactory
