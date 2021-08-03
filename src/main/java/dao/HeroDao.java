package dao;
import java.util.ArrayList;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import entity.*;
import utils.*;
public class HeroDao
{
	public List<Hero> find(String[] dividedName)
	{
        List<Hero> heroList = new ArrayList<Hero>();
        SqlSession session = DBUtils.getConnection();
        HeroMapper mapper = session.getMapper(HeroMapper.class);
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
		session.commit();
		return heroList;
	}
}
