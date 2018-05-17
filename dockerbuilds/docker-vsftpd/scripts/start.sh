#!/bin/bash
/usr/sbin/vsftpd  -olisten_port=2121 -orun_as_launching_user=true -oxferlog_file=/appScripts/xferlog -obackground=FALSE
