#!/usr/bin/env coffee

cook = (recipes) ->

    for recipe in recipes

        recipe_mod = require recipe

        console.log ''
        recipe_mod.title()
        recipe_mod.cook()

    return

recipes = [
    './cookbook/recipe_base',
    './cookbook/recipe_loop'
]

cook recipes

