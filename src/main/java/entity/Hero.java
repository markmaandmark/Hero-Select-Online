package entity;
/**
 * hero类
 * 包含hero的各项属性
 * 包含这些属性的get、set方法
 * 包含toString重写，输出全属性hero
 * 包含partToString()，输出只有部分属性的hero
 * @author markma
 * @date 修改时间:2021年8月2日 上午11:44:07
 */
public class Hero {

	final String COLORCODE = "31";
	private int ID = 0,
			bloodValue = 0,
			attackValue = 0;
	private String name = "",
			   weaponName = "",
			   birthday = "",
			   deathday = "",
			   introduction = "";
    
    // create table books(id int primary key auto_increment,title varchar(40),author varchar(40),price int);

    public Hero() 
    {
    }

    public Hero(int ID,
			int bloodValue,
			int attackValue,
			String name,
			String weaponName,
			String birthday,
			String deathday,
			String introduction) 
    {
        super();
        this.ID = ID;
		this.bloodValue = bloodValue;
		this.attackValue = attackValue;
		this.name = name;
		this.weaponName = weaponName;
		this.birthday = birthday;
		this.deathday = deathday;
		this.introduction = introduction;
    }

    public int getID()
	{
		return ID;
	}

	public void setID(int iD)
	{
		ID = iD;
	}

	public int getBloodValue()
	{
		return bloodValue;
	}

	public void setBloodValue(int bloodValue)
	{
		this.bloodValue = bloodValue;
	}

	public int getAttackValue()
	{
		return attackValue;
	}

	public void setAttackValue(int attackValue)
	{
		this.attackValue = attackValue;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getWeaponName()
	{
		return weaponName;
	}

	public void setWeaponName(String weaponName)
	{
		this.weaponName = weaponName;
	}

	public String getBirthday()
	{
		return birthday;
	}

	public void setBirthday(String birthday)
	{
		this.birthday = birthday;
	}

	public String getDeathday()
	{
		return deathday;
	}

	public void setDeathday(String deathday)
	{
		this.deathday = deathday;
	}

	public String getIntroduction()
	{
		return introduction;
	}

	public void setIntroduction(String introduction)
	{
		this.introduction = introduction;
	}

	@Override
    public String toString() 
    {
        return "Hero [ID=" + ID 
        		+ ", bloodValue=" + bloodValue 
        		+ ", attackValue=" + attackValue
        		+ ", name=" + name
        		+ ", weaponName=" + weaponName
        		+ ", birthday=" + birthday
        		+ ", deathday=" + deathday
        		+ ", introduction=" + introduction
        		+ "]";
    }
	public String partToString(String dividedPro[])
	{
		String printString = "Hero [";
		printString += "name=";
		printString += name;
		printString += ",";
		//String pro:dividedPro
		for(int i = 0;i<dividedPro.length;i++)
		{
			String pro = dividedPro[i];
			if(pro.equals("weaponName"))
			{
				printString += "weaponName=";
				printString += weaponName;
			}
			if(pro.equals("birthday"))
			{
				printString += "birthday=";
				printString += birthday;
			}
			if(pro.equals("deathday"))
			{
				printString += "deathday=";
				printString += deathday;
			}
			if(pro.equals("introduction"))
			{
				printString += "introduction=";
				printString += introduction;
			}
			if(pro.equals("ID"))
			{
				printString += "ID=";
				printString += ID;
			}
			if(pro.equals("bloodValue"))
			{
				printString += "bloodValue=";
				printString += bloodValue;
			}
			if(pro.equals("attackValue"))
			{
				printString += "attackValue=";
				printString += attackValue;
			}
			if(i != dividedPro.length-1)
			{
				printString += ",";
			}
				
		}
		printString += "]";
		return printString;
	}
}