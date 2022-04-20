import io.vertx.core.DeploymentOptions
import io.vertx.core.Vertx
import io.vertx.core.VertxOptions
import io.vertx.core.spi.cluster.ClusterManager
import io.vertx.spi.cluster.zookeeper.ZookeeperClusterManager


fun main() {
    val mgr: ClusterManager = ZookeeperClusterManager()
    val options = VertxOptions()
        .setClusterManager(mgr)
        .setHAEnabled(true)
        .setHAGroup("my-group")

    var clusteredVertx = Vertx.clusteredVertx(options)
    clusteredVertx.onSuccess {
        val vertx = it
        var deploy = System.getenv("deploy")
        if (deploy == "1") {
            vertx.deployVerticle("verticle.Verticle", DeploymentOptions().setHa(true))
        }
    }.onFailure {
        println("Failed to deploy verticle")
    }
}
