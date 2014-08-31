package com.nutz.simple.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;

import com.nutz.simple.model.Employee;

@At("/employee")
@IocBean
@InjectName
public class EmployeeAction extends BaseAction{
	
	@At("/list")
	@Ok("jsp:jsp.employee")
	public void listAll(HttpServletRequest req){
		List<Employee> employeeList = basicDao.findAll(Employee.class, "id", "desc");//降序排列
		req.setAttribute("employeeList", employeeList);
		req.setAttribute("statuts", "0");
		req.setAttribute("msg", "获取employee列表成功");
	}
}
