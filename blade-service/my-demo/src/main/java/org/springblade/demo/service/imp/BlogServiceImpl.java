package org.springblade.demo.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springblade.demo.mapper.BlogMapper;
import org.springblade.demo.service.BlogService;
import org.springblade.demo.entity.Blog;
import org.springframework.stereotype.Service;

@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService{

}
