#!/usr/bin/env python
# -*- coding:utf-8 -*-

import threading
import importlib;
from cookbook.util.logging import LoggerFactory

logger = LoggerFactory.getLogger(__name__)

def cook(recipes):

    for recipe in recipes:

        recipe_mod = importlib.import_module(recipe)

        logger.debug('')
        recipe_mod.title()
        recipe_mod.cook()

if __name__ == '__main__':

    threading.currentThread().name = 'main'

    recipes = [
        'cookbook.recipe_base',
        'cookbook.recipe_loop',
        'cookbook.recipe_command',
        'cookbook.recipe_thread'
    ]

    cook(recipes)
