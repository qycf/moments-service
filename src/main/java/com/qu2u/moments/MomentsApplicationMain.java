package com.qu2u.moments;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qu2u.moments.mapper")
public class MomentsApplicationMain {
    public static void main(String[] args) {

        SpringApplication.run(MomentsApplicationMain.class, args);

    }
}