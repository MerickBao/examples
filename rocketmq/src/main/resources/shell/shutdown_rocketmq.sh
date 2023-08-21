#!/bin/sh
MQ_PATH=/Users/merickbao/dev/rocketmq-all-5.1.3-source-release/distribution/target/rocketmq-5.1.3/rocketmq-5.1.3/bin
MQ_DASHBOARD_PATH=/Users/merickbao/dev/rocketmq-dashboard-master/target

echo "RocketMQ path=${MQ_PATH}"
echo "RocketMQ dashboard path=${MQ_DASHBOARD_PATH}"

echo "关闭broker"
sh ${MQ_PATH}/mqshutdown broker

echo "关闭namesrv"
sh ${MQ_PATH}/mqshutdown namesrv

echo "关闭RocketMQ dashboard"
kill $(ps aux | grep rocketmq-dashboard-1.0.1-SNAPSHOT.jar | grep -v grep |  tr -s ' ' | cut -d ' ' -f 2)
echo "关闭成功"


