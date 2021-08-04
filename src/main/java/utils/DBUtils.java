package utils;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 数据库管理工具类
 * @author markma
 * @date 修改时间:2021年8月4日 上午9:18:44
 */
public class DBUtils
{
	public static SqlSession getConnection()
	{
		SqlSession session = null;
		try 
		{
			/**
			 * 1.加载连接
			 */
	        SqlSessionFactory factory = new SqlSessionFactoryBuilder()
	                .build(Resources.getResourceAsReader("utils/config.xml"));
	        /**
	         * 2.进行一次会话
	         * 获得了接口的一个具体实现（实例）
	         * mybatis 根据注解创建了接口的实例
	         */
	        session = factory.openSession();
	        

	    } 
		catch (IOException e) 
		{
	        e.printStackTrace();
	    }
		return session;
	}
}
