package org.java.bean;

import java.util.Date;

public class User {
	
	private int id;		//用户id
	private String userNum;		//用户编号
	private String userName;	//用户姓名
	private String userPassword; //登录密码
	private String userSex;		//用户性别
	private Date userBirthday;		//出生年月
	private String userTel;		//电话号码
	private String userMail;	//电子邮箱
	private int userType;		//用户类型
	private int fk_positionId;	//职位id
		
	//空构造函数
	public User() {
		super();
	}

	//不含用户id的构造函数
	public User(String userNum, String userName, String userPassword, String userSex, Date userBirthday, String userTel,
			String userMail, int userType, int fk_positionId) {
		super();
		this.userNum = userNum;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userSex = userSex;
		this.userBirthday = userBirthday;
		this.userTel = userTel;
		this.userMail = userMail;
		this.userType = userType;
		this.fk_positionId = fk_positionId;
	}

	//全参构造函数
	public User(int id, String userNum, String userName, String userPassword, String userSex, Date userBirthday,
			String userTel, String userMail, int userType, int fk_positionId) {
		super();
		this.id = id;
		this.userNum = userNum;
		this.userName = userName;
		this.userPassword = userPassword;
		this.userSex = userSex;
		this.userBirthday = userBirthday;
		this.userTel = userTel;
		this.userMail = userMail;
		this.userType = userType;
		this.fk_positionId = fk_positionId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserNum() {
		return userNum;
	}

	public void setUserNum(String userNum) {
		this.userNum = userNum;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserTel() {
		return userTel;
	}

	public void setUserTel(String userTel) {
		this.userTel = userTel;
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public int getUserType() {
		return userType;
	}

	public void setUserType(int userType) {
		this.userType = userType;
	}

	public int getFk_positionId() {
		return fk_positionId;
	}

	public void setFk_positionId(int fk_positionId) {
		this.fk_positionId = fk_positionId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userNum=" + userNum + ", userName=" + userName + ", userPassword=" + userPassword
				+ ", userSex=" + userSex + ", userBirthday=" + userBirthday + ", userTel=" + userTel + ", userMail="
				+ userMail + ", userType=" + userType + ", fk_positionId=" + fk_positionId + "]";
	}

	
}
