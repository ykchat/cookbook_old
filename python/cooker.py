#!/usr/bin/env python
# -*- coding:utf-8 -*-

import threading
import importlib;

def cook(recipes):

    for recipe in recipes:

        recipe_mod = importlib.import_module(recipe)

        print('')
        recipe_mod.title()
        recipe_mod.cook()

if __name__ == '__main__':

    threading.currentThread().name = 'main'

    recipes = [
        'cookbook.recipe_base',
        'cookbook.recipe_loop',
        'cookbook.recipe_thread'
    ]

    cook(recipes)
