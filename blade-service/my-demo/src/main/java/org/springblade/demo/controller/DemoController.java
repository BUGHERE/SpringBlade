package org.springblade.demo.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springblade.core.mp.support.Condition;
import org.springblade.core.mp.support.Query;
import org.springblade.core.secure.annotation.PreAuth;
import org.springblade.core.tool.api.R;
import org.springblade.core.tool.utils.Func;
import org.springblade.demo.entity.Blog;
import org.springblade.demo.service.BlogService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author WYH
 * @date 2024/12/06 22:49
 **/
@RestController
@RequestMapping("api")
@Slf4j
@AllArgsConstructor
public class DemoController {
	@GetMapping("info")
//	@PreAuth("hasRole('test')")  // Cannot invoke "org.springblade.core.secure.BladeUser.getRoleName()" because the return value of "org.springblade.core.secure.utils.SecureUtil.getUser()" is null
	@Cacheable(cacheNames = "demo-info", key = "#name")
	public R<String> info(String name) {
		log.info("本条信息没有从缓存获取");
		return R.data("Hello, My Name Is: " + name);
	}
	@GetMapping("remove-info")
	@CacheEvict(cacheNames = "demo-info", key = "#name")
	public R<String> removeInfo(String name) {
		return R.data("Remove Cache Success");
	}
	@GetMapping("count")
	@PreAuth("permitAll()")
	public R<Integer> count(Integer cnt) {
		return R.data(cnt * 10);
	}

	private BlogService blogService;
	/**
	 * 新增
	 */
	@PostMapping("save")
	public R save(@RequestBody Blog blog) {
		return R.status(blogService.save(blog));
	}
	/**
	 * 更新
	 */
	@PostMapping("update")
	public R update(@RequestBody Blog blog) {
		return R.status(blogService.updateById(blog));
	}
	/**
	 * 删除多个，用逗号隔开
	 */
	@PostMapping("remove")
	public R remove(@RequestParam String ids) {
		return R.status(blogService.removeByIds(Func.toIntList(ids)));
	}
	/**
	 * 查询单条
	 */
	@GetMapping("detail")
	public R detail(Integer id) {
		Blog detail = blogService.getById(id);
		return R.data(detail);
	}
	/**
	 * 查询多条
	 */
	@GetMapping("list")
	public R<List<Blog>> list() {
		List<Blog> list = blogService.list();
		return R.data(list);
	}
	/**
	 * 模糊查询
	 */
	@GetMapping("list2")
	public R<List<Blog>> list2(Blog blog) {
		List<Blog> list = blogService.list(Wrappers.query(blog));
		return R.data(list);
	}
	/**
	 * QueryWrapper有更多的用法，比如我们可以将他转换为lambda模式，并且按时间倒序排序
	 */
	@GetMapping("list3")
	public R<List<Blog>> list3(@RequestParam Map<String, Object> blog) {
		List<Blog> list = blogService.list(Condition.getQueryWrapper(blog, Blog.class).lambda().orderByDesc(Blog::getBlogDate));
		return R.data(list);
	}
	/**
	 * 分页查询
	 */
	@GetMapping("page")
	public R<IPage<Blog>> page(@RequestParam Map<String, Object> blog, Query query) {
		IPage<Blog> pages = blogService.page(Condition.getPage(query), Condition.getQueryWrapper(blog, Blog.class));
		return R.data(pages);
	}
}
