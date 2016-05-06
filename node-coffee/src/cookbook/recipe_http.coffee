#!/usr/bin/env coffee

http    = require 'http'
path    = require 'path'
logging = require './util/logging'

logger = logging.LoggerFactory.getLogger path.basename __filename

title = ->

    logger.debug '# Http'

    return

cook = -> new Promise (resolve) -> 

    host = 'weather.livedoor.com'
    api = '/forecast/webservice/json/v1?city=130010'

    ## HTTPリクエスト

    http.get 'http://' + host + api, (res) ->

        res.setEncoding('utf8');

        body = ''
        res.on 'data', (chunk) ->
            body += chunk
            return

        res.on 'end', ->

            ## HTTPレスポンス解析

            data = JSON.parse body

            location = data.location
            logger.debug "#{location.prefecture}, #{location.city}"

            for forecast in data.forecasts
                logger.debug "#{forecast.dateLabel}[#{forecast.date}]: #{forecast.telop}"

            resolve()
            return

        return

    return

module.exports =
    title: title
    cook: cook
