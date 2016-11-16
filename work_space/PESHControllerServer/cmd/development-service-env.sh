#!/bin/sh

#
# Common options need to change: JVM_XMX, JVM_JMX_HOST, JVM_JMX_PORT
#
#
#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#
# common attributes
CONF_FILES=config.ini

#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#
# app arguments: empty means disable or not-available

APP_ARGS=""

#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~#
# jvm arguments: empty means disable or not-available

#auto the heap max size ($MAX_HEAP_SIZE) or leave it's empty  or custom the heap max size
JVM_XMX=1024M
#auto the heap min size ($JVM_XMX) or leave it's empty  or custom the heap min size
JVM_XMS=
#auto the heap new size ($HEAP_NEWSIZE) or leave it's empty  or custom the heap new size
JVM_XMN=
#jmx monitoring: $SYS_IP_ADDR 64999
JVM_JMX_HOST=
JVM_JMX_PORT=
#remote debug: 63999
JVM_JDWP_PORT=
#suspend value: 'y' or 'n'
JVM_JDWP_SUSPEND=n

#jvm extra options
JVM_EXTRA_ARGS=""

