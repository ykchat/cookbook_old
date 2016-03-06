#!/usr/bin/env python
# -*- coding:utf-8 -*-

from cookbook.util.logging import LoggerFactory

logger = LoggerFactory.getLogger(__name__)

def title():

    logger.debug('# Loop')

def cook():

    nums = range(5)
    def pow(x):
        return x**2

    ## for文

    results = list()
    for num in nums:
        results.append(pow(num))
    logger.debug(results)

    ## 内包表記

    results = [pow(num) for num in nums]
    logger.debug(results)

    ## map関数

    results = list(map(pow, nums))
    logger.debug(results)

if __name__ == '__main__':

    title()
    cook()
