/**
 * 
 */
package org.java.dao;

import java.util.List;

import org.java.bean.Files;

/**
 * @author 邱高强
 *	对员工档案进行增删改查操作
 */
public interface FilesDao {

	/**
	 * 新增档案
	 * @param files
	 * @return
	 */
	public int addFiles(Files files);
	
	/**
	 * 通过id删除档案
	 * @param id
	 * @return
	 */
	public int delFiles(int id);
	
	/**
	 * 查询全部档案
	 * @return
	 */
	public List<Files> selectAll();
	
	/**
	 * 通过id查找档案
	 * @param id
	 * @return
	 */
	public Files selectById(int id);
}
