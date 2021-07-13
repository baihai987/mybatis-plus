package com.mybts.pls.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author BaiHaiyang
 * @version 1.0.0
 * @Description
 * @createTime 2021年07月13日 15:18:00
 */
@Configuration
@MapperScan("com.mybts.pls.mypls.mapper")
public class Myconfig {
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
}
