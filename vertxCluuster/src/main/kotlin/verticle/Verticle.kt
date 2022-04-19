package verticle

import io.vertx.core.*

class Verticle : AbstractVerticle() {

    override fun start() {
        vertx.createHttpServer().requestHandler { req ->
            req.response().end("Hello from Vert.x-Web!")
        }.listen(8080)
    }
}