package com.beton.vertx.tutorials;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.Future;
import io.vertx.core.Vertx;

/**
 * Hello world!
 *
 */
public class ApplicationVerticle extends AbstractVerticle
{
	
	@Override
	public void start(Future<Void> startFuture) throws Exception {
		
		
		System.out.println("Application verticle is starting...");
		
		
		vertx.createHttpServer()
		.requestHandler(r -> {
			
			r.response().end("<h1> My first vertx application... running on port 7777</h1>");
			
			
		})
		.listen(7777, resp -> {
			
			if(resp.succeeded()){
				startFuture.complete();
			}else{
				startFuture.fail("Http server did not start..."); 
			}
			
		});
		
	}
	
	public static void main(String[] args) {
		
		Vertx vertx = Vertx.vertx();
		
		vertx.deployVerticle(new ApplicationVerticle()); 
		
	}
	
    
}
