package com.loga.gatewayserver.vendor.config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
public class App {

    private static final Logger log = LoggerFactory.getLogger(App.class);

    @Bean
    public CommandLineRunner init() {
        return  args -> {
            log.info("LoGA Gateway Server Initialization ---");
        };
    }

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(p -> p
                        .path("/get")
                        .filters(f-> f
                                .addRequestHeader("MyHeader","MyURI")
                                .addRequestParameter("Param", "MyValue"))
                        .uri("http://httpbin.org:80"))
                .route(p -> p
                        .path("/authentication-service/**")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec
                                .addResponseHeader("Access-Control-Allow-Origin","*")
                                .addResponseHeader("Access-Control-Allow-Headers","Accept, Content-Type"))
                        .uri("lb://authentication-service"))
                .route(p -> p
                        .path("/customer-service/**")
                        .filters(gatewayFilterSpec -> gatewayFilterSpec
                                .addResponseHeader("Access-Control-Allow-Origin","*")
                                .addResponseHeader("Access-Control-Allow-Headers","Accept, Content-Type"))
                        .uri("lb://customer-service"))
                .route(p -> p
                        .path("/maintenance-service/**")
                        .uri("lb://maintenance-service"))
                .route(p -> p
                        .path("/intelligent-service/**")
                        .uri("lb://intelligent-service"))
                .route(p -> p
                        .path("/monitoring-service/**")
                        .uri("lb://monitoring-service"))
                .route(p -> p
                        .path("/report-service/**")
                        .uri("lb://report-service"))
                .build();
    }

    @Bean
    public CorsWebFilter corsFilter(){
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.setAllowCredentials(true);
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS", "HEAD"));
        corsConfiguration.addAllowedHeader("Content-Type, Accept");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsWebFilter(source);
    }
}
