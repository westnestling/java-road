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


## acl 命令行  
资料 https://www.jianshu.com/p/c96c9f8c2433
- getAcl 查看权限
- setAcl 设置权限 

## zk 四字命令
- conf  3.3.0版本引入的。打印出服务相关配置的详细信息。
- cons	3.3.0版本引入的。列出所有连接到这台服务器的客户端全部连接/会话详细信息。包括"接受/发送"的包数量、会话id、操作延迟、最后的操作执行等等信息。
- crst	3.3.0版本引入的。重置所有连接的连接和会话统计信息。
- dump	列出那些比较重要的会话和临时节点。这个命令只能在leader节点上有用。
- envi	打印出服务环境的详细信息。
- reqs	列出未经处理的请求
- ruok	测试服务是否处于正确状态。如果确实如此，那么服务返回"imok"，否则不做任何相应。
- stat	输出关于性能和连接的客户端的列表。
- srst	重置服务器的统计。
- srvr	3.3.0版本引入的。列出连接服务器的详细信息
- wchs	3.3.0版本引入的。列出服务器watch的详细信息。
- wchc	3.3.0版本引入的。通过session列出服务器watch的详细信息，它的输出是一个与watch相关的会话的列表。
- wchp	3.3.0版本引入的。通过路径列出服务器watch的详细信息。它输出一个与session相关的路径。
- mntr	3.4.0版本引入的。输出可用于检测集群健康状态的变量列表