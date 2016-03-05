#!/usr/bin/env python
# -*- coding:utf-8 -*-

import logging
import datetime;
import pytz

handler = logging.StreamHandler()
handler.setFormatter(logging.Formatter(
    "%(asctime)s [%(threadName)-10s] %(module)s: %(levelname)s %(message)s"
))

logger = logging.getLogger(__name__)
logger.setLevel(logging.DEBUG)
logger.addHandler(handler)

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
