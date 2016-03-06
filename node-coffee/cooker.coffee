#!/usr/bin/env coffee

path = require 'path'
logging = require './cookbook/util/logging'

logger = logging.LoggerFactory.getLogger path.basename __filename 

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
