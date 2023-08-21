#!/bin/sh
MQ_PATH=/Users/merickbao/dev/rocketmq-all-5.1.3-source-release/distribution/target/rocketmq-5.1.3/rocketmq-5.1.3/bin
MQ_DASHBOARD_PATH=/Users/merickbao/dev/rocketmq-dashboard-master/target

echo "RocketMQ path=${MQ_PATH}"
echo "RocketMQ dashboard path=${MQ_DASHBOARD_PATH}"

echo "启动namesrv"
nohup sh ${MQ_PATH}/mqnamesrv &

echo "启动broker host=localhost:9876"
nohup sh ${MQ_PATH}/mqbroker -n localhost:9876 --enable-proxy &

echo "启动RocketMQ Dashboard host=localhost:10086"
java -jar ${MQ_DASHBOARD_PATH}/rocketmq-dashboard-1.0.1-SNAPSHOT.jar --server.port=10086 &


