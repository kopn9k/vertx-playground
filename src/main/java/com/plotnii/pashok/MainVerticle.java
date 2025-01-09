package com.plotnii.pashok;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

public class MainVerticle extends AbstractVerticle {

    public static int PORT = 8080;
    public static String NAME_PARAM = "name";

    @Override
    public void start() {
        Router router = Router.router(vertx);
        router.route("/api/v1/greeting").handler(this::greeting);
        router.route("/api/v1/greeting/:" + NAME_PARAM).handler(this::greetingWithName);
        vertx.createHttpServer().requestHandler(router).listen(PORT);
    }

    void greeting(RoutingContext context) {
        context.request().response().end("Hello plotnii Pashok!");
    }

    void greetingWithName(RoutingContext context) {
        String name = context.pathParam(NAME_PARAM);
        context.request().response().end(String.format("Hello plotnii Pashok and %s!", name));
    }
}
