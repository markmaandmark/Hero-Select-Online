package dao;

import java.util.List;
import entity.Hero;
public class PropertiesDao
{
	public String[] find(List<Hero> heroList,String[] dividedPro)
	{
		String pro = dividedPro[0];
		String[] findPro = new String[heroList.size()];
		int j = 0;
		if(pro.equals("-a"))
		{
			for (Hero i : heroList) 
			{
				findPro[j] = i.toString();
				j++;
		    }
		}
		else
		{
			for (Hero i : heroList) 
			{
				findPro[j] = i.partToString(dividedPro);
				j++;
		    }
		}
		return findPro;
	}
}


