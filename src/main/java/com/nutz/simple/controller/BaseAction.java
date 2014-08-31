package com.nutz.simple.controller;

import org.nutz.ioc.loader.annotation.Inject;

import com.nutz.simple.dao.BasicDao;

public class BaseAction {
	@Inject
	protected BasicDao basicDao;

	public void setBasicDao(BasicDao basicDao) {
		this.basicDao = basicDao;
	}
}
