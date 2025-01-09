package com.plotnii.pashok;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;

public class MainVerticle extends AbstractVerticle {

    public static int PORT = 8080;
    public static String NAME_PARAM = "name";

    @Override
    public void start() {
        Router router = Router.router(vertx);
        router.route("/api/v1/greeting").handler(context -> {
            context.request().response().end("Hello plotnii Pashok!");
        });
        router.route("/api/v1/greeting/:" + NAME_PARAM).handler(context -> {
            String name = context.pathParam(NAME_PARAM);
            context.request().response().end(String.format("Hello plotnii Pashok and %s!", name));
        });
        vertx.createHttpServer().requestHandler(router).listen(PORT);
    }
}
