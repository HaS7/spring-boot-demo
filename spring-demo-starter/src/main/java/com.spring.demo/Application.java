package com.spring.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@EnableRabbit
public class Application{
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args){
        logger.info("应用开始启动 ...");
        try {
            SpringApplication.run(Application.class, args);
        } catch (Error error) {
            logger.error("应用启动失败！", error);
        }
        logger.info("应用启动成功");
    }
}