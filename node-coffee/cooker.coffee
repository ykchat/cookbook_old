#!/usr/bin/env coffee

logging = require './cookbook/util/logging'

logger = logging.LoggerFactory.getLogger 'cookbook'

cook = (recipes) ->

    for recipe in recipes

        recipe_mod = require recipe

        logger.debug ''
        recipe_mod.title()
        recipe_mod.cook()

    return

recipes = [
    './cookbook/recipe_base',
    './cookbook/recipe_loop'
]

cook recipes
