#!/usr/bin/env python
# -*- coding:utf-8 -*-

import logging
import threading
import time

handler = logging.StreamHandler()
handler.setFormatter(logging.Formatter(
    "%(asctime)s [%(threadName)-10s] %(module)s: %(levelname)s %(message)s"
))

logger = logging.getLogger(__name__)
logger.setLevel(logging.DEBUG)
logger.addHandler(handler)

def title():

    logger.debug('# Thread')

def cook():

    threads = [
        threading.Thread(target=__sleep, args=(1.0,)),
        threading.Thread(target=__sleep, args=(2.0,)),
        threading.Thread(target=__sleep, args=(3.0,))
    ]

    for thread in threads:
        thread.start()

    for thread in threads:
        if thread.isAlive(): thread.join()

    logger.debug("all ended")

def __sleep(secs):

    logger.debug("sleep(%f) started" % (secs))

    time.sleep(secs)

    logger.debug("sleep(%f) ended" % (secs))

if __name__ == '__main__':

    title()
    cook()
