package utils;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

//controller层调用 service层， service层在调用dao层；dao层处理完数据返回 service层， service层在返回controller层，controller层最终返回前端。
public class DBUtils
{
	public static SqlSession getConnection()
	{
		SqlSession session = null;
		try 
		{
	        SqlSessionFactory factory = new SqlSessionFactoryBuilder()
	                .build(Resources.getResourceAsReader("utils/config.xml"));

	        // 一次会话
	        // Connection
	        session = factory.openSession();
	        
	        // 获得了接口的一个具体实现（实例）
	        // mybatis 根据注解创建了接口的实例

	    } 
		catch (IOException e) 
		{
	        e.printStackTrace();
	    }
		return session;
	}
}
