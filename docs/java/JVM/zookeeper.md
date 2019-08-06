# zookeeper 作用
- master节点选举。主节点挂了以后，从节点会接手工作，并且保证这个节点是惟一的，从而保证集群的高可用
- 统一配置文件管理，即只需要部署一台服务器，则可以把相同的配置文件同步更新到所有的服务器，此操作在云计算用的特别多。
- 发布和订阅。类似MQ，dubbo发布者把数据存在znode，订阅者会读取这个数据。
- 提供分布式锁，分布式环境中不同进程之间争夺资源，类似多线程中的锁。
- 集群管理，集群中保证数据的强一致性

# zookeeper 命令行
- ./zkCli.sh 打开zk客户端命令行后台
- ls 与 ls2 查看当前节点数据列表
- get 与 stat 查看当前节点状态
- create [path] [value] 创建永久节点
- create -e [path] [value] 创建临时节点
- create -s [path] [value] 创建顺序节点
- delete [path] ([version])删除节点数据 版本号（乐观锁 可无）

## watcher 命令行
- get path watch 设置watcher
- stat path watch 设置watcher
- ls path watch 设置watcher


