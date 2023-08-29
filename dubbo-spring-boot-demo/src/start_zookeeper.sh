#!/bin/sh
PATH=/Users/merickbao/projects/github/dubbo-samples

echo "启动ZooKeeper"
echo "ZOOKEEPER_PATH=${PATH}"
${PATH}/mvnw clean compile exec:java -pl ${PATH}/tools/embedded-zookeeper