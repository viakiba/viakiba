package verticle

import io.vertx.core.*
import io.vertx.core.Verticle
import io.vertx.core.buffer.Buffer
import io.vertx.core.eventbus.DeliveryOptions

class VerticleSend : AbstractVerticle() {

    override fun start() {
        var eventBus = vertx.eventBus()
        var myCodec = MyCodec()
        eventBus.registerCodec( myCodec)
        vertx.createHttpServer().requestHandler { req ->
            //只发给一个订阅者
            eventBus.send("verticle.publish", "send Hello from VerticleSub")
            // 所有订阅者都会处理
            eventBus.publish("verticle.publish", "publish Hello from VerticleSub")
            eventBus.request<String>("verticle.publish", "send Hello from VerticleSub"){
                if (it.succeeded()) {
                   println(it.result().body())
                } else {
                    println(it.cause().message)
                }
            }

            val options = DeliveryOptions().setCodecName(myCodec.name())
            eventBus.send("verticle.publish.codec", "codec send Hello from VerticleSub", options)

            req.response().end("Hello from Vert.x-Web!")
        }.listen(8080)
    }
}

class MyCodec : io.vertx.core.eventbus.MessageCodec<String, String> {
    override fun encodeToWire(buffer: Buffer, s: String) {
        buffer.appendString(s)
    }

    override fun decodeFromWire(pos: Int, buffer: Buffer): String {
        return buffer.getString(pos, buffer.length())
    }

    override fun transform(s: String): String {
        return s
    }

    override fun name(): String {
        return "myCodec"
    }

    override fun systemCodecID(): Byte {
        return -1
    }
}