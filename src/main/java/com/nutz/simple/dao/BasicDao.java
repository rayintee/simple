package com.nutz.simple.dao;

import java.util.List;

import org.nutz.dao.Chain;
import org.nutz.dao.Cnd;
import org.nutz.dao.Condition;
import org.nutz.dao.Dao;
import org.nutz.dao.Sqls;
import org.nutz.dao.entity.Entity;
import org.nutz.dao.sql.Sql;
import org.nutz.ioc.loader.annotation.Inject;
import org.nutz.ioc.loader.annotation.IocBean;

/**
 * 基本数据库操作
 * crud操作
 * @author Rayintee
 *
 */
@IocBean
public class BasicDao {

	@Inject
	protected Dao dao;
	
	/**
	 * 根据ID查询一个对象
	 * @param <T>
	 * @param id 持久化Id
	 * @param c 要查询的表
	 * @return 查询到的对象
	 */
	public <T> T findById(int id, Class<T> c){
		return dao.fetch(c, id);
	}
	
	/**
	 * 查询数据库中的全部数据
	 * @param <T>
	 * @param c 查询的表，对应的model类
	 * @param columnName 要排序的表字段
	 * @param orderby 排序的条件 asc/desc
	 * @return List 返回结果集list
	 */
	public <T> List<T> findAll(Class<T> c, String columnName, String orderby){
		if(orderby != null && orderby == "asc")
			return dao.query(c, Cnd.orderBy().asc(columnName), null);
		else 
			return dao.query(c, Cnd.orderBy().desc(columnName), null);
	}
	
	/**
	 * 根据条件查询数据库中满足条件的数据
	 * @param <T>
	 * @param c
	 * @param condition 查询需要满足的条件
	 * @return List 返回结果集list，一条或者多条数据
	 */
	public <T> List<T> findByCondition(Class<T> c, Condition condition){
		return dao.query(c, condition, null);
	}
	
	/**
	 * 根据sql条件返回需要的数据，一般复杂sql需要用到此方法
	 * @param sql sql语句
	 * @return List 返回结果集list
	 */
	public <T> List<T> findBySql(String sql){
		//Sql sqlObj = Sqls.create(sql);
		return null;
	}
	
	/**
	 * 查询数据库中的数据条数
	 * @param <T>
	 * @param c 查询的数据库表
	 * @return int 返回统计数目整数
	 */
	public <T> int findCount(Class<T> c){
		return dao.count(c);
	}
	
	/**
	 * 修改一条数据
	 * @param <T>
	 * @param t     修改数据库中的数据
	 * @return true 修改成功,false 修改失败
	 */
	public <T> boolean updateOne(T t){
		return dao.updateIgnoreNull(t) == 1;
	}
	
	/**
	 * 根据条件修改指定数据
	 * @param <T>
	 * @param c 数据库表
	 * @param chain 修改的内容
	 * @param condition 选择条件
	 * @return true 成功,false失败
	 */
	public <T> boolean update(Class<T> c, Chain chain, Condition condition){
		return dao.update(c, chain, condition)>0;
	}
	
	/**
	 * 增加一条数据
	 * @param <T>
	 * @param t 实体model类
	 * @return 返回增加到数据库的这条数据
	 */
	public <T> T save(T t){
		return dao.insert(t);
	}
	
	/**
	 * 根据条件增加数据，可能批量
	 * @param table 数据库库表名
	 * @param chain 新增的内容
	 * @return
	 */
	public void save(String table, Chain chain){
		dao.insert(table, chain);
	}
	
	
	/**
	 * 根据Id删除数据
	 * @param <T> 
	 * @param c 对应的数据库表,也即model类
	 * @param id 持久化Id
	 * @return true 成功删除一条数据,false删除失败
	 */
	public <T> boolean delById(int id,Class<T> c){
		return dao.delete(c, id)==1;
	}
	
	/**
	 * 根据多个id删除数据(批量删除)
	 * @param <T>
	 * @param c     要操作的表信息
	 * @param ids   要删除的id,多个用","（逗号）分隔
	 * @return true 成功,false 失败
	 */
	public <T> void deleteByIds(Class<T> c,String ids){
		Entity<T>  entity = dao.getEntity(c);
		String table = entity.getTableName();
		String id = entity.getIdField().getColumnName();
		Sql sql = Sqls.create("delete from "+table+" where "+id+" in("+ids+")");
		dao.execute(sql);
	}
	
}
