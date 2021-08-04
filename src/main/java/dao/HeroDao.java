package dao;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import entity.*;
import utils.*;
/**
 * 英雄数据库处理
 * 通过名字在数据库找到相应的英雄
 * @author markma
 * @date 修改时间:2021年8月4日 上午9:13:16
 */
public class HeroDao
{
	
	public List<Hero> find(String[] dividedName)
	{
		/**
		 * 1.列表初始化
		 */
        List<Hero> heroList = new ArrayList<Hero>();
        /**
         * 2.数据库连接
         */
        SqlSession session = DBUtils.getConnection();
        HeroMapper mapper = session.getMapper(HeroMapper.class);
        /**
         * 3.查找
         */
		for(String name:dividedName)
		{
			if(name.equals("-a"))
			{
				heroList = mapper.findAll();
				break;
			}
			else
			{
				if(mapper.find(name) != null)
				{
					heroList.addAll(mapper.find(name));
				}
			}
		}
        /**
         * 4.提交请求，返回查找值
         */
		session.commit();
		return heroList;
	}
}
