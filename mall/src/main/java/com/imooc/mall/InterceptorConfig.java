package com.imooc.mall;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by 廖师兄
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new UserLoginInterceptor())
				.addPathPatterns("/**")
				.excludePathPatterns("/error", "/user/login", "/user/register", "/categories", "/products", "/products/*");
	}
}
