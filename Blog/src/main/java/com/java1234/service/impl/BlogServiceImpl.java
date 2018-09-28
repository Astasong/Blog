package com.java1234.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.java1234.dao.BlogDao;
import com.java1234.entity.Blog;
import com.java1234.service.BlogService;

/**
 * ����Serviceʵ����
 * @author Administrator
 *
 */
@Service("blogService")
public class BlogServiceImpl implements BlogService{

	@Resource
	private BlogDao blogDao;
	
	public List<Blog> countList() {
		return blogDao.countList();
	}

	/* ��ҳ��ѯ����
	 * (non-Javadoc)
	 * @see com.java1234.service.BlogService#find(java.util.Map)
	 */
	@Override
	public List<Blog> find(Map<String, Object> map) {
		return blogDao.find(map);
	}

	/* ��ѯ��¼��
	 * (non-Javadoc)
	 * @see com.java1234.service.BlogService#getTotal(java.util.Map)
	 */
	@Override
	public Long getTotal(Map<String, Object> map) {
		return blogDao.getTotal(map);
	}
}
