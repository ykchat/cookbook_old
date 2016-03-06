#!/usr/bin/env python
# -*- coding:utf-8 -*-

import datetime
import pytz
from cookbook.util.logging import LoggerFactory

logger = LoggerFactory.getLogger(__name__)

def title():

    logger.debug('# Base')

def cook():

    ## 変数展開

    name = 'Recipe'
    hello = "Hello %s!" % (name)
    logger.debug(hello)

    ## 現在時刻

    now = datetime.datetime.now(tz=pytz.utc)
    logger.debug(now)

    now = datetime.datetime.now(tz=pytz.timezone('Asia/Tokyo'))
    logger.debug(now)

if __name__ == '__main__':

    title()
    cook()
