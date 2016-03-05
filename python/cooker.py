#!/usr/bin/env python
# -*- coding:utf-8 -*-

import logging
import threading
import importlib;

handler = logging.StreamHandler()
handler.setFormatter(logging.Formatter(
    "%(asctime)s [#%(process)-5s - %(threadName)-8s] %(module)s: %(levelname)-5s %(message)s"
))

logger = logging.getLogger(__name__)
logger.setLevel(logging.DEBUG)
logger.addHandler(handler)

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
        'cookbook.recipe_thread'
    ]

    cook(recipes)
