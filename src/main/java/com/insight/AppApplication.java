package com.insight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author 宣炳刚
 * @date 2017/9/15
 * @remark 应用入口程序
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
public class AppApplication {

    /**
     * 应用入口方法
     *
     * @param args 启动参数
     */
    public static void main(String[] args) {
        SpringApplication.run(AppApplication.class, args);
    }
}
