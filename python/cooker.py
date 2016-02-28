#!/usr/bin/env python
# -*- coding:utf-8 -*-

import importlib;

def cook(recipes):

    for recipe in recipes:

        recipe_mod = importlib.import_module(recipe)

        print('')
        recipe_mod.title()
        recipe_mod.cook()

if __name__ == '__main__':

    recipes = [
        'recipes.recipe_base',
        'recipes.recipe_loop'
    ]

    cook(recipes)
