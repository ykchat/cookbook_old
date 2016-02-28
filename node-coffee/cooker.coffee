#!/usr/bin/env coffee

cook = (recipes) ->

    for recipe in recipes

        recipe_mod = require recipe

        console.log ''
        recipe_mod.title()
        recipe_mod.cook()

    return

recipes = [
    './recipes/recipe_base'
]

cook recipes

