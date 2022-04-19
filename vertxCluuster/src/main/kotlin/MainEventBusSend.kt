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
        vertx.deployVerticle("verticle.VerticleSend")
    }.onFailure {
        println("Failed to deploy verticle")
    }
}
