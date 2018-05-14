package com.netease.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/**
 * Description:
 *
 * @author goujunyi
 * Date:2018-03-13 19:25
 */
@SpringBootApplication
public class Application {

    /*@Bean
    public ApplicationContextInit applicationContextInit() {
        return new ApplicationContextInit();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
