package com.netease.demo;

import com.netease.demo.conf.EsConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/**
 * Description:
 *
 * @author goujunyi
 * Date:2018-03-13 19:25
 */
@SpringBootApplication
@ImportAutoConfiguration(EsConfig.class)
public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }


}
