#!/usr/bin/env coffee

module.exports.title = ->

    console.log '# Loop'

    return

module.exports.cook = ->

    nums = [0...5]
    pow = (x) -> 
        return x**2

    ## for文

    results = []
    for num in nums
        results.push pow num
    console.log results

    ## 内包表記

    results = (pow num for num in nums)
    console.log results

    ## map関数

    results = nums.map (num) -> 
        return pow num
    console.log results

    return
