package verticle

import io.vertx.core.*
import io.vertx.core.Verticle
import io.vertx.core.eventbus.DeliveryOptions

class VerticleSub : AbstractVerticle() {

    override fun start() {
        var eventBus = vertx.eventBus()


        eventBus.consumer<String>("verticle.publish") { message ->
            println("Received message: ${message.body()}")
            message.reply("Ok Received message: ${message.body()}")
        }


        var myCodec = MyCodec()
        eventBus.registerCodec(myCodec)
        eventBus.consumer<String>("verticle.publish.codec") { message ->
            println("1111111111111111111 Received message: ${message.body()}")
        }

    }
}