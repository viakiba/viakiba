import io.vertx.core.Vertx
import io.vertx.core.VertxOptions
import io.vertx.core.spi.cluster.ClusterManager
import io.vertx.spi.cluster.zookeeper.ZookeeperClusterManager


fun main() {
    val mgr: ClusterManager = ZookeeperClusterManager()
    val options = VertxOptions().setClusterManager(mgr)
    var clusteredVertx = Vertx.clusteredVertx(options)
    clusteredVertx.onSuccess {
        val vertx = it
        vertx.deployVerticle("verticle.Verticle")
    }.onFailure {
        println("Failed to deploy verticle")
    }
}

/*
总结 zk 依赖 问题
  1.https://vertx.io/docs/vertx-zookeeper/java/#_about_zookeeper_version
    根据上述连接的描述以及引入的  implementation 'io.vertx:vertx-zookeeper:4.2.7'  依赖，可以分析出，
    假如我们使用的 zk服务器是 3.4.8 版本，那么我们需要指定 zookeeper 的版本，否则会报错，    implementation 'org.apache.zookeeper:zookeeper:3.4.8'
    记得排除 vertx-zookeeper 的 zk依赖。
  2. 根据文档提到的配置方式
     -Dvertx.zookeeper.config=./config/zookeeper.json  vm参数
     或者使用 系统变量
日志
    日志引入 logback   implementation group: 'ch.qos.logback', name: 'logback-classic', version: '1.2.11
    并引入配置文件  logback.xml
远端 eventbus
    1. 依赖上面的zk集群实现
    2. 参考文档 https://vertx.io/docs/vertx-core/java/#event_bus
    3. 默认编解码是json
    4. 可以自定义就不演示了
HA
    1. 依赖上面的zk集群实现
    2.
 */