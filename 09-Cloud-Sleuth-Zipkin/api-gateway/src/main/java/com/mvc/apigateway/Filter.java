package com.mvc.apigateway;
//
//import org.slf4j.Logger;
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.cloud.gateway.server.mvc.filter.FilterFunctions;
//import org.springframework.http.HttpRequest;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.web.server.ServerWebExchange;
//import org.springframework.web.servlet.function.HandlerFilterFunction;
//import org.springframework.web.servlet.function.HandlerFunction;
//import org.springframework.web.servlet.function.ServerRequest;
//import reactor.core.publisher.Mono;
//
//import java.net.http.HttpResponse;
//
public class Filter{

} //implements HandlerFilterFunction<HttpRequest, HttpResponse> {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//        System.out.println(exchange.getRequest().toString());
//        ServerHttpRequest request= (ServerHttpRequest) exchange.getRequest();
//        System.out.println(request.getHeaders().getFirst("Authorization"));
//
//        return chain.filter(exchange)
//                .then(Mono.fromRunnable(()->{
//                    ServerHttpResponse response= (ServerHttpResponse) exchange.getResponse();
//                    System.out.println(" We have response "+response.toString());
//                }));
//    }
//
//    @Override
//    public HttpResponse filter(ServerRequest request, HandlerFunction<HttpRequest> next) throws Exception {
//        return null;
//    }
//
//    @Override
//    public HandlerFilterFunction<HttpRequest, HttpResponse> andThen(HandlerFilterFunction<HttpRequest, HttpRequest> after) {
//        return HandlerFilterFunction.super.andThen(after);
//    }
//
//    @Override
//    public HandlerFunction<HttpResponse> apply(HandlerFunction<HttpRequest> handler) {
//        return HandlerFilterFunction.super.apply(handler);
//    }
//}
