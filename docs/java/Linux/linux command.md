### 刷新资源
source /etc/profile
### 编辑环境变量
vi /etc/profile

###进程
- netstat -anp | grep 27017 
- kill -9 6276

```配置java 环境变量```
> export JAVA_HOME=/opt/java
> export PATH=$JAVA_HOME/bin:$PATH
> export CLASSPATH=.:$JAVA_HOME/lib/dt.jar:$JAVA_HOME/lib/tools.jar

