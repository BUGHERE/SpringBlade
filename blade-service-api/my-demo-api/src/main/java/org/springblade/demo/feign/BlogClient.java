package org.springblade.demo.feign;

import org.springblade.common.constant.CommonConstant;
import org.springblade.core.tool.api.R;
import org.springblade.demo.entity.Blog;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author WYH
 * @date 2024/12/10 11:56
 **/
@FeignClient(
	value = CommonConstant.APPLICATION_DEMO_NAME,
	fallback = BlogClientFallback.class
)
public interface BlogClient {
	/**
	 * 接口前缀
	 */
	String API_PREFIX = "/api/blog";

	/**
	 * 获取详情
	 *
	 * @param id 主键
	 * @return
	 */
	@GetMapping(API_PREFIX + "/detail")
	R<Blog> detail(@RequestParam("id") Integer id);
}
