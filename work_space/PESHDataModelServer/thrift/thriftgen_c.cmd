#!/bin/sh

THRIFT_EXE=thrift
TFOLDER=thrift

#~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
#xthrift
rm -f ../../inc/zstreamingserver/$TFOLDER/*
rm -f ../../src/zstreamingserver/$TFOLDER/*
rm -f gen-c/*

$THRIFT_EXE --gen c_glib pe_smarthome_shared.thrift

rm -f gen-cpp/*.skeleton.cpp
mv gen-c/*.h ../../inc/zstreamingserver/$TFOLDER/
mv gen-c/*.c ../../src/zstreamingserver/$TFOLDER/
rm -rf gen-c