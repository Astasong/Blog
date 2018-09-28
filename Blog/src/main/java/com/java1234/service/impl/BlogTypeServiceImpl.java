package com.java1234.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.dao.BlogTypeDao;
import com.java1234.entity.BlogType;
import com.java1234.service.BlogTypeService;

/**
 * 博客类型Service实现类
 * @author Administrator
 *
 */
@Service("blogTypeService")
public class BlogTypeServiceImpl implements BlogTypeService{

	@Resource
	private BlogTypeDao blogTypeDao;
	
	public List<BlogType> countList() {
		return blogTypeDao.countList();
	}

	
}
