package zk;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

/**
 * @author Daniel
 */
public class ZKReconnect implements Watcher {
    final static Logger log = LoggerFactory.getLogger(ZKReconnect.class);

    public static final String zkServerPath = "121.196.211.187:2181";

    public static final Integer timeout = 5000;

    public static void main(String[] args) throws IOException, InterruptedException {
        ZooKeeper zk = new ZooKeeper(zkServerPath,timeout,new ZKReconnect());
        long seddionId = zk.getSessionId();
        byte[] sessionPassword = zk.getSessionPasswd();

        log.info("客户端开始链结zkf服务器。。。");
        log.info("连接状态 {}",zk.getState());

        Thread.sleep(1000);
        log.info("连接状态 {}",zk.getState());
        log.info("开始会话重连",zk.getState());

        ZooKeeper zkSession = new ZooKeeper(zkServerPath,timeout,new ZKReconnect(),seddionId,sessionPassword);
        log.info("重连接状态 {}",zkSession.getState());

        Thread.sleep(1000);
        log.info("重连接状态 {}",zkSession.getState());
    }

    @Override
    public void process(WatchedEvent watchedEvent) {
        log.debug("receive watcher {}",watchedEvent);
    }
}
