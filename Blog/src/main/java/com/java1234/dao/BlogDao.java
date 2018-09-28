package com.java1234.dao;

import java.util.List;
import java.util.Map;

import com.java1234.entity.Blog;

/**
 * 博客Dao接口
 * @author Administrator
 *
 */
public interface BlogDao {

	/**
	 * 根据日期分月分组查询
	 * @return
	 */
	public List<Blog> countList();
	
	/**分页查询博客
	 * @param map
	 * @return
	 */
	public List<Blog> find(Map<String, Object> map);
	
	/**查询总记录
	 * @param map
	 * @return
	 */
	public Long	getTotal(Map<String, Object> map);
	
}