#!/usr/bin/env python
# -*- coding:utf-8 -*-

import logging

class LoggerFactory(object):

    __loggers = dict()

    @staticmethod
    def getLogger(name):

        if name in LoggerFactory.__loggers:
            return LoggerFactory.__loggers[name]

        handler = logging.StreamHandler()
        handler.setFormatter(logging.Formatter(
            "%(asctime)s [#%(process)-5s - %(threadName)-8s] %(module)s: %(levelname)-5s %(message)s"
        ))

        logger = logging.getLogger(name)
        logger.setLevel(logging.DEBUG)
        logger.addHandler(handler)

        LoggerFactory.__loggers[name] = logger

        return logger
