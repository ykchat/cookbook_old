#!/usr/bin/env python
# -*- coding:utf-8 -*-

import os
from cookbook.util.logging import LoggerFactory

logger = LoggerFactory.getLogger(__name__)

def title():

    logger.debug('# File')

def cook():

    name = os.path.abspath('cooker.py')

    # 基本情報

    logger.debug("dir=%s" % (os.path.dirname(name)))
    logger.debug("file=%s" % (os.path.basename(name)))
    logger.debug("size=%d" % (os.path.getsize(name)))

    # 行数カウント

    lc = 0
    with open(name, 'r') as file:
        lc = sum(1 for line in file)
    logger.debug("lc=%d" % (lc))

    lc = 0
    with open(name, 'r') as file:
        lc = len(file.readlines())
    logger.debug("lc=%d" % (lc))

    lc = 0
    with open(name, 'r') as file:
        for line in file:
            lc += 1
    logger.debug("lc=%d" % (lc))

if __name__ == '__main__':

    title()
    cook()
