package verticle

import io.vertx.core.*
import kotlin.random.Random

class Verticle : AbstractVerticle() {

    override fun start() {
        var nextInt = Random.nextInt(8000, 9000)
        println(nextInt)
        vertx.createHttpServer().requestHandler { req ->
            req.response().end("$nextInt Hello from Vert.x-Web!")
        }.listen(nextInt)
    }
}