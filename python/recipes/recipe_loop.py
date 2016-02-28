#!/usr/bin/env python
# -*- coding:utf-8 -*-

def title():

    print('# Loop')

def cook():

    nums = range(5)
    def pow(x):
        return x**2

    ## for文

    results = list()
    for num in nums:
        results.append(pow(num))
    print(results)

    ## 内包表記

    results = [pow(num) for num in nums]
    print(results)

    ## map関数

    results = list(map(pow, nums))
    print(results)

if __name__ == '__main__':

    title()
    cook()
