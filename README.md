# test
考试题

# 数据库配置
数据库配置在test.sql文件中查看详情，使用mysql数据库直接导入即可

# 后端配置
使用maven安装好依赖直接运行即可

# 如何拉取此项目

1.在本地创建一个文件夹
2.在本地文件夹中单击鼠标右键，选择git bash here

3.初始化该文件
git init

4.origin master建立连接
git remote add origin 本项目的git地址

5.把项目分支拉取到本地
git fetch origin dev（dev为远程仓库的分支名）

6.在本地创建分支dev并切换到该分支
git checkout -b dev(本地分支名称) origin/dev(远程分支名称)

7.把某个分支上的内容都拉取到本地
git pull origin dev(远程分支名称)

# 前端在哪儿？
在vue分支 查看vue分支中readme文件运行前端

# swgger

http://localhost:9091/swagger-ui/index.html#/

项目启动成功后访问以上地址即可查看api

# linux测试题也在当前分支下
linux_test_1.sh 
linux_test_2.sh 

