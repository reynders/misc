#!/bin/bash
LIBS=./lib_managed/scala_2.9.0/compile/
CP=$LIBS/casbah-core_2.9.0-1-2.1.5.0.jar:$LIBS/casbah-commons_2.9.0-1-2.1.5.0.jar:$LIBS/casbah-query_2.9.0-1-2.1.5.0.jar:$LIBS/slf4j-api-1.6.0.jar:$LIBS/casbah-gridfs_2.9.0-1-2.1.5.0.jar:$LIBS/joda-time-1.6.jar:$LIBS/mongo-java-driver-2.5.3.jar:$LIBS/scalaj-collection_2.8.0-1.0.jar:$LIBS/slf4j-api-1.6.0.jar
scala -classpath $CP
