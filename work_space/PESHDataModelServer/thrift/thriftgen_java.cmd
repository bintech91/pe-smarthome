#!/bin/sh

THRIFT_EXE=thrift
THRIFT_VER=9

#Java
rm -f jzlink-thrift/gen-java/*/*/*/*/*/*
#zlink

$THRIFT_EXE --gen java -o jzlink-thrift zlink_common.thrift
$THRIFT_EXE --gen java -o jzlink-thrift zlink_common.thrift

#-------------------------------------------------------------------------------
#Java build & deploy

PROJECT_NAME=jzlink-thrift
PROJECT_DIR=jzlink-thrift
VERSION=1.0.0.0

#common variables
ZSERVER_DIR=/zserver
JAVA_LIB_DIR=$ZSERVER_DIR/java/lib
DEPLOY_DIR=$JAVA_LIB_DIR/zlink
DEPLOY_JAR="$PROJECT_NAME""$THRIFT_VER"-"$VERSION".jar

#build
ant -f $PROJECT_DIR/build.xml clean
ant -f $PROJECT_DIR/build.xml -Djavac.debug=false -Ddist.jar=dist/$DEPLOY_JAR jar

#deploy to zserver dir
mkdir -p $DEPLOY_DIR
cp -f $PROJECT_DIR/dist/$DEPLOY_JAR $DEPLOY_DIR

#clean
ant -f $PROJECT_DIR/build.xml clean

