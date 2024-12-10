package org.springblade.demo.feign;

import org.springblade.core.tool.api.R;
import org.springblade.demo.entity.Blog;

import java.time.LocalDateTime;


public class BlogClientFallback implements BlogClient {

	@Override
	public R<Blog> detail(Integer id) {
		Blog blog = new Blog();
		blog.setBlogTitle("Hystrix");
		blog.setBlogContent("FallBack Success");
		blog.setBlogDate(LocalDateTime.now());
		blog.setIsDeleted(0);
		return R.data(blog);
	}

}
