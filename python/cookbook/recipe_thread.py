#!/usr/bin/env python
# -*- coding:utf-8 -*-

import logging
import threading
import time

handler = logging.StreamHandler()
handler.setFormatter(logging.Formatter(
    "%(asctime)s [#%(process)-5s - %(threadName)-8s] %(module)s: %(levelname)-5s %(message)s"
))

logger = logging.getLogger(__name__)
logger.setLevel(logging.DEBUG)
logger.addHandler(handler)

def title():

    logger.debug('# Thread')

def cook():

    secs = [1.0, 2.0, 3.0]

    threads = list()

    count = 0
    for sec in secs:
        count += 1
        threads.append(threading.Thread(target=__sleep, name="thread-%s" % (count), args=(sec,)))

    for thread in threads:
        thread.start()

    for thread in threads:
        if thread.isAlive(): thread.join()

    logger.debug('all ended')

def __sleep(sec):

    logger.debug("sleep(%s) started" % (sec))

    time.sleep(sec)

    logger.debug("sleep(%s) ended" % (sec))

if __name__ == '__main__':

    title()
    cook()
