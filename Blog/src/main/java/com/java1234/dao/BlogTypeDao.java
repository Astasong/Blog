package com.java1234.dao;

import java.util.List;

import com.java1234.entity.BlogType;

/**
 * ��������Dao�ӿ�
 * @author Administrator
 *
 */
public interface BlogTypeDao {

	/**
	 * ��ѯ���в������ͣ��Լ���Ӧ�Ĳ�������
	 * @return
	 */
	public List<BlogType> countList();
	
	
	/**����id����ָ���Ĳ�������ʵ��
	 * @param id
	 * @return
	 */
	public BlogType findById(Integer id);
}