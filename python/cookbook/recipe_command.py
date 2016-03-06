#!/usr/bin/env python
# -*- coding:utf-8 -*-

import sys
from subprocess import Popen, PIPE
from cookbook.util.logging import LoggerFactory

logger = LoggerFactory.getLogger(__name__)

def title():

    logger.debug('# Command')

def cook():

    commands = ['ls']

    # コマンド実行

    for command in commands:

        proc = Popen(command.split(' '), stdout=PIPE)
        # コマンドのpid取得
        pid = proc.pid
        logger.debug("%s[#%s] started" % (command, pid))
        # コマンド実行結果（標準出力）を取得
        pipe = proc.stdout
        for line in pipe.readlines():
            logger.debug(line.rstrip().decode(sys.stdin.encoding))
        pipe.close()
        logger.debug("%s[#%s] ended" % (command, pid))

if __name__ == '__main__':

    title()
    cook()
