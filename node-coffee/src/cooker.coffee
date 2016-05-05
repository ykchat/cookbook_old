#!/usr/bin/env coffee

co = require 'co'
path    = require 'path'
logging = require './cookbook/util/logging'

logger = logging.LoggerFactory.getLogger path.basename __filename 

cook = co.wrap (recipes) -> 

    for recipe in recipes

        recipe_mod = require recipe

        logger.debug ''
        recipe_mod.title()
        yield recipe_mod.cook()

    return

recipes = [
    './cookbook/recipe_base'
    './cookbook/recipe_loop'
    './cookbook/recipe_file'
    './cookbook/recipe_command'
]

cook recipes
