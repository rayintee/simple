package com.nutz.simple.model;

import java.io.Serializable;
import java.sql.Timestamp;

import org.nutz.dao.entity.annotation.Column;
import org.nutz.dao.entity.annotation.Id;
import org.nutz.dao.entity.annotation.Name;
import org.nutz.dao.entity.annotation.Table;

/**
 * 会员表
 * 
 * @author Rayintee
 * 
 */
@Table("employee")
public class Employee implements Serializable {
	// 生成随机序列数
	private static final long serialVersionUID = 6787349229526265363L;

	@Id
	private int id;// id主键

	@Name
	private String name;// 名字

	@Column("age")
	private int age;// 年龄

	@Column("sex")
	private String sex;// 性别

	@Column("register_time")
	private Timestamp createTime;// 注册时间

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
}
