#!/bin/bash

# 显示当前硬盘负载
echo "硬盘负载："
iostat -d -x

# 显示当前内存使用负载
echo "内存使用负载："
vmstat -s

# 显示当前CPU负载
echo "CPU负载："
uptime
