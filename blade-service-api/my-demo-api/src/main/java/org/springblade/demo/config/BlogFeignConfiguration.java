package org.springblade.demo.config;

import org.springblade.demo.feign.BlogClientFallback;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WYH
 * @date 2024/12/10 20:48
 **/
@Configuration
public class BlogFeignConfiguration {
	@Bean
	public BlogClientFallback blogClientFallback() {
		return new BlogClientFallback();
	}
}
