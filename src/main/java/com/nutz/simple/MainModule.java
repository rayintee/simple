package com.nutz.simple;

import org.nutz.mvc.annotation.Encoding;
import org.nutz.mvc.annotation.IocBy;
import org.nutz.mvc.annotation.Modules;
import org.nutz.mvc.ioc.provider.ComboIocProvider;

/**
 * nutz主模块
 * 复杂ioc加载器ComboIocProvider调用其他加载器
 * 自动扫描com.nutz.simple包下面的文件
 * 输入输出采用UTF-8格式编码
 * @author Rayintee
 *
 */
@IocBy(type=ComboIocProvider.class, args={
	"*org.nutz.ioc.loader.json.JsonLoader","config/ioc/module.js",
	"*org.nutz.ioc.loader.annotation.AnnotationIocLoader","com.nutz.simple"})
@Modules(scanPackage=true)
@Encoding(input="UTF-8",output="UTF-8")
public class MainModule {

}
