package com.java1234.dao;

import java.util.List;

import com.java1234.entity.BlogType;

/**
 * 博客类型Dao接口
 * @author Administrator
 *
 */
public interface BlogTypeDao {

	/**
	 * 查询所有博客类型，以及对应的博客数量
	 * @return
	 */
	public List<BlogType> countList();
	
	
	/**根据id查找指定的博客类型实体
	 * @param id
	 * @return
	 */
	public BlogType findById(Integer id);
}
