package origin

import io.vertx.core.Handler
import io.vertx.core.Vertx
import io.vertx.core.http.HttpClient
import io.vertx.core.http.HttpMethod
import io.vertx.ext.web.Router
import io.vertx.ext.web.RoutingContext
import io.vertx.ext.web.proxy.handler.ProxyHandler
import io.vertx.ext.web.proxy.handler.impl.ProxyHandlerImpl
import io.vertx.httpproxy.HttpProxy

fun main(args: Array<String>) {
    var vertx = Vertx.vertx()
//    singleProxy(vertx)
//    mutilProxy(vertx)
    dynamicProxy(vertx)
    backServer(vertx,7070)
    backServer(vertx,6060)
}

private fun mutilProxy(vertx: Vertx) {
    val proxyClient: HttpClient = vertx.createHttpClient()
    var proxyServer = vertx.createHttpServer();

    var proxyRouter = Router.router(vertx);

    val httpProxy1 = HttpProxy.reverseProxy(proxyClient)
    httpProxy1.origin(7070, "localhost")

    val httpProxy2 = HttpProxy.reverseProxy(proxyClient)
    httpProxy2.origin(6060, "localhost")

    proxyRouter
        .route(HttpMethod.GET, "/foo").handler(ProxyHandler.create(httpProxy1))

    proxyRouter
        .route(HttpMethod.GET, "/bar").handler(ProxyHandler.create(httpProxy2))
    proxyServer.requestHandler(proxyRouter);

    proxyServer.listen(8080)
    println("Proxy server started on port 8080");
}

private fun singleProxy(vertx: Vertx) {
    val proxyClient: HttpClient = vertx.createHttpClient()
    var proxyServer = vertx.createHttpServer();

    var proxyRouter = Router.router(vertx);
    val httpProxy = HttpProxy.reverseProxy(proxyClient)

    // 写法一
//    httpProxy.origin(7070, "localhost")
//    proxyRouter
//        .route(HttpMethod.GET, "/foo").handler(ProxyHandler.create(httpProxy))
    //写法二
    proxyRouter
        .route(HttpMethod.GET, "/foo")
        .handler (
            ProxyHandlerImplDiy(vertx)
        )
    proxyServer.requestHandler(proxyRouter);
    proxyServer.listen(8080);
    println("Single Proxy server started on port 8080");
}

private fun dynamicProxy(vertx: Vertx) {
    var proxyServer = vertx.createHttpServer();
    var proxyRouter = Router.router(vertx);
    proxyRouter
        .route(HttpMethod.GET, "/foo")
        .handler (
            ProxyHandlerImplDiy(vertx)
        )
    proxyServer.requestHandler(proxyRouter);
    proxyServer.listen(8080);
    println("Single Proxy server started on port 8080");
}

private fun backServer(vertx: Vertx, port: Int = 7070) {
    val backendServer = vertx.createHttpServer()
    val backendRouter = Router.router(vertx)
    backendRouter.route(HttpMethod.GET, "/foo").handler { rc: RoutingContext ->
        rc.response()
            .putHeader("content-type", "text/html")
            .end("<html><body><h1>I'm the target resource foo!</h1></body></html>")
    }
    backendRouter.route(HttpMethod.GET, "/bar").handler { rc: RoutingContext ->
        rc.response()
            .putHeader("content-type", "text/html")
            .end("<html><body><h1>I'm the target resource bar!</h1></body></html>")
    }
    backendServer.requestHandler(backendRouter).listen(port)
    println("backend server listening on port $port")
}

open class ProxyHandlerImplDiy(vertx: Vertx) : Handler<RoutingContext> {

    private var vertx: Vertx
    private var proxyMap : MutableMap<String, HttpProxy> = mutableMapOf()

    init {
        this.vertx = vertx
    }

    override fun handle(ctx: RoutingContext) {
        var header = ctx.request().getHeader("hosts")
        var httpProxy = proxyMap[header]
        // 如果没有则创建 这里会并发其实可以由etcd一类的注册中心 监听到变化之后 服务器自创建 而不是通过header 不过这里演示从简
        if (httpProxy == null) {
            httpProxy = GetHttpProxy(header,7070)
            proxyMap[header] = httpProxy
        }
        httpProxy.handle(ctx.request())
    }

    fun GetHttpProxy(header: String, port: Int): HttpProxy {
        val proxyClient: HttpClient = vertx.createHttpClient()
        var reverseProxy = HttpProxy.reverseProxy(proxyClient)
        reverseProxy.origin(port,header)
        return reverseProxy
    }

}