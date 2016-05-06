#!/usr/bin/env python
# -*- coding:utf-8 -*-

import urllib.request
import json
from cookbook.util.logging import LoggerFactory

logger = LoggerFactory.getLogger(__name__)

def title():

    logger.debug('# Http')

def cook():

    host = 'weather.livedoor.com'
    api = '/forecast/webservice/json/v1?city=130010'

    ## HTTPリクエスト

    with urllib.request.urlopen('http://' + host + api) as res:

        ## HTTPレスポンス解析

        data = json.loads(res.read().decode('utf-8'))

        location = data['location']
        logger.debug("%s, %s" % (location[''], location['city']))

        for forecast in data['forecasts']:
            logger.debug("%s[%s]: %s" % (forecast['dateLabel'], forecast['date'], forecast['telop']))

if __name__ == '__main__':

    title()
    cook()
