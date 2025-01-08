package com.plotnii.pashok;

import io.vertx.core.AbstractVerticle;

public class MainVerticle extends AbstractVerticle {

    public static int PORT = 8080;

    @Override
    public void start() {
        vertx.createHttpServer().requestHandler(event -> {
                    event.response().end("Hello plotnii Pashok!");
                })
                .listen(PORT);
    }
}
