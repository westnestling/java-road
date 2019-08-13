# mongoDB 命令
- mongod --fork --logpath /var/log/mongodb.log  --logappend --dbpath /usr/data 后台运行常用指令
- netstat -anp | grep 27017 常用查询占用端口指令
- kill -9 xxx 杀死进程
- 连接客户端并中止MongoDB
> mongo
> use admin
> db.shutdownServer()