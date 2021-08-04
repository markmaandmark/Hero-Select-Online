package dao;

import java.util.List;
import entity.Hero;
/**
 * 属性数据库处理
 * 通过英雄找到对应的属性值，储存到字符串数组中
 * @author markma
 * @date 修改时间:2021年8月4日 上午9:15:23
 */
public class PropertiesDao
{
	public String[] find(List<Hero> heroList,String[] dividedPro)
	{
		/**
		 * 1.初始化字符串数组
		 */
		String pro = dividedPro[0];
		String[] findPro = new String[heroList.size()];
		/**
		 * 2.把每个找到的英雄对应的属性依次放进数组里
		 */
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
		/**
		 * 3.返回这个数组
		 */
		return findPro;
	}
}


