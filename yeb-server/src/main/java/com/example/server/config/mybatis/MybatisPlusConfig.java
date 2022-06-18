package com.example.server.config.mybatis;

import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Mybatis 分页配置
 *
 * @author zhanglishen
 *
 */

@Configuration
public class MybatisPlusConfig {

	@Bean
	public PaginationInnerInterceptor paginationInterceptor(){
		return new PaginationInnerInterceptor();
	}
}
