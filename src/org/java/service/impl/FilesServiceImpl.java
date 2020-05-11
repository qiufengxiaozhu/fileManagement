/**
 * 
 */
package org.java.service.impl;

import java.util.List;

import org.java.bean.Files;
import org.java.dao.FilesDao;
import org.java.dao.impl.FilesDaoImpl;
import org.java.service.FilesService;

/**
 * @author 邱高强
 * 对员工档案进行增删改查操作
 */
public class FilesServiceImpl implements FilesService {

	private FilesDao dao = new FilesDaoImpl();
	
	/**
	 * 新增档案
	 * @param files
	 * @return
	 */
	@Override
	public int addFiles(Files files) {
		// TODO Auto-generated method stub
		
		int rows = dao.addFiles(files);
		
		return rows;
	}

	/**
	 * 通过id删除档案
	 * @param id
	 * @return
	 */
	@Override
	public int delFiles(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 * 查询全部档案
	 * @return
	 */
	@Override
	public List<Files> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 通过id查找档案
	 * @param id
	 * @return
	 */
	@Override
	public Files selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
