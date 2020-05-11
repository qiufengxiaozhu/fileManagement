package org.java.bean;

public class Position {
	
	private int id; 				//职位id
	private String positionName;	//职位名称
	private int number;				//该部门人数
	private int fk_departmentId;	//部门表id
	
	//空构造函数
	public Position() {
		super();
	}

	//不含id构造函数
	public Position(String positionName, int number, int fk_departmentId) {
		super();
		this.positionName = positionName;
		this.number = number;
		this.fk_departmentId = fk_departmentId;
	}

	//全参构造函数
	public Position(int id, String positionName, int number, int fk_departmentId) {
		super();
		this.id = id;
		this.positionName = positionName;
		this.number = number;
		this.fk_departmentId = fk_departmentId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPositionName() {
		return positionName;
	}

	public void setPositionName(String positionName) {
		this.positionName = positionName;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getFk_departmentId() {
		return fk_departmentId;
	}

	public void setFk_departmentId(int fk_departmentId) {
		this.fk_departmentId = fk_departmentId;
	}
	
	
}
