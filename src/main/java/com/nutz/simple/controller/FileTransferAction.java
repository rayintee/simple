package com.nutz.simple.controller;

import java.io.File;

import org.nutz.ioc.annotation.InjectName;
import org.nutz.ioc.loader.annotation.IocBean;
import org.nutz.mvc.annotation.AdaptBy;
import org.nutz.mvc.annotation.At;
import org.nutz.mvc.annotation.Ok;
import org.nutz.mvc.annotation.Param;
import org.nutz.mvc.upload.UploadAdaptor;

@At("/file")
@IocBean
@InjectName
public class FileTransferAction extends BaseAction {
	
	@At("/upload")
	@AdaptBy(type=UploadAdaptor.class)
	public String uploadFile(@Param("userId") String uuid, @Param("subject") String subject,
			@Param("file") File tempFile){
		System.out.println("Get a file --> "+tempFile + " size=" +tempFile.length());
		return "upload 1 file = " + tempFile.getAbsolutePath() + " size=" +tempFile.length();
	}
	
	@At("/uploadPage")
	@Ok("jsp:jsp.upload.upload")
	public void toUpload(){
		//TODO 用来跳转到上传页面
	}
}
