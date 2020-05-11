/**
 * 
 */
package org.java.bean;

import java.util.Date;

/**
 * @author 邱高强
 *	档案实体类
 */
public class Files {

	
	private int id;				//档案id
	private int userId;			//用户id
	private String userName;	//用户姓名
	private String path;		//档案路径
	private String fileName;	//档案名称
	private Date createTime;	//上传时间
	private int del;			//是否删除的标志
	/**
	 * 
	 */
	public Files() {
		super();
	}
	/**
	 * @param userId
	 * @param userName
	 * @param path
	 * @param fileName
	 * @param createTime
	 * @param del
	 */
	public Files(int userId, String userName, String path, String fileName, Date createTime, int del) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.path = path;
		this.fileName = fileName;
		this.createTime = createTime;
		this.del = del;
	}
	/**
	 * @param id
	 * @param userId
	 * @param userName
	 * @param path
	 * @param fileName
	 * @param createTime
	 * @param del
	 */
	public Files(int id, int userId, String userName, String path, String fileName, Date createTime, int del) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.path = path;
		this.fileName = fileName;
		this.createTime = createTime;
		this.del = del;
	}
	
	/**
	 * @param userId
	 * @param userName
	 * @param path
	 * @param fileName
	 * @param del
	 */
	public Files(int userId, String userName, String path, String fileName, int del) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.path = path;
		this.fileName = fileName;
		this.del = del;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the path
	 */
	public String getPath() {
		return path;
	}
	/**
	 * @param path the path to set
	 */
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * @return the fileName
	 */
	public String getFileName() {
		return fileName;
	}
	/**
	 * @param fileName the fileName to set
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime() {
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/**
	 * @return the del
	 */
	public int getDel() {
		return del;
	}
	/**
	 * @param del the del to set
	 */
	public void setDel(int del) {
		this.del = del;
	}
	@Override
	public String toString() {
		return "Files [id=" + id + ", userId=" + userId + ", userName=" + userName + ", path=" + path + ", fileName="
				+ fileName + ", createTime=" + createTime + ", del=" + del + "]";
	}
	
	
	
	
	
	
}
