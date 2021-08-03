package utils;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import entity.Hero;

/**
 * HeroMapper映射SQL接口
 * 包含数据库增删改查
 * save：保存新hero到数据库
 * find：依照名字找到数据库中hero
 * findAll：列出所有hero
 * remove:删除数据库中特定名字的hero
 * update:更新hero的值（未用到，未完成)
 * @author markma
 * @date 修改时间:2021年8月2日 上午11:47:18
 */
public interface HeroMapper 
{

	@Insert("insert into heros(ID,bloodValue,attackValue,name,weaponName,birthday,deathday,introduction) "
			+ "values(#{ID}, #{bloodValue}, #{attackValue},#{name},#{weaponName},#{birthday},#{deathday},#{introduction})")
    void save(Hero b);
	@Select("SELECT * FROM heros WHERE name = #{name}")
	List<Hero> find(@Param("name") String name);
	@Select("SELECT * FROM heros")
    List<Hero> findAll();
	@Delete("DELETE * FROM heros WHERE name = #{name}")
    void remove(String name);
	@Update("")
    void update(Hero b);
}