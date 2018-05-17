#!/bin/bash
cd /tmp
/usr/sbin/vsftpd  -olisten_port=2121 -orun_as_launching_user=true -oxferlog_file=/appScripts/xferlog -obackground=FALSE -opasv_enable=yes -opasv_min_port=21100 -opasv_max_port=21100 -opasv_address=127.0.0.1 
