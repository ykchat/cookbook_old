#!/usr/bin/env python
# -*- coding:utf-8 -*-

import datetime;
import pytz

def title():

    print('# Base')

def cook():

    ## 変数展開

    name = 'Recipe'
    hello = "Hello %s!" % (name)
    print(hello)

    ## 現在時刻

    now = datetime.datetime.now(tz=pytz.utc)
    print(now)

    now = datetime.datetime.now(tz=pytz.timezone('Asia/Tokyo'))
    print(now)

if __name__ == '__main__':

    title()
    cook()
