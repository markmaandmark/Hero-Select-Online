package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;
import entity.Hero;
import utils.*;
/**
 * Servlet implementation class SelectServlet
 */

/**
 * service层（业务层）：封装通用的业务逻辑，操作；与数据层的交互。(本例省略）
 * dao层（数据层）：主要做数据持久层的工作，封装负责与数据库进行操作的代码。
 * entity ：实体类。
 * utils ：封装工具类。
 * 前端->controller->dao->controller->前端
 * @author markma
 * @date 修改时间:2021年8月4日 上午9:01:56
 */
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public SelectServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		/**
		 * 1.获取前端输入，转为UTF-8
		 */
		String undName = new String(request.getParameter("Name").getBytes("iso-8859-1"), "utf-8");
		String undPro = new String(request.getParameter("Pro").getBytes("iso-8859-1"), "utf-8");
		
		if(undName != null || undPro != null)
		{
			/**
			 * 2.拆分传入的Name和Properties
			 */
			NameProDivider divNamePro = new NameProDivider(undName,undPro);
			divNamePro.divideName();
			divNamePro.dividePro();
			/**
			 * 3.根据拆分后的Name找对应的hero
			 */
			HeroDao hd = new HeroDao();
			List<Hero> heroList = hd.find(divNamePro.getDividedName());
			/**
			 * 4.对找到的hero,显示出用户要求的properties
			 */
			
			PropertiesDao pd = new PropertiesDao();
			String[] printHeroInfo = pd.find(heroList, divNamePro.getDividedProperties());
			/**
			 * 5.将要显示的字符串写到返回网页里面
			 */
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/plain");
			ReturnWriter returnwriter = new ReturnWriter();
			returnwriter.write(printHeroInfo);
			
			/**
			 * 6.返回查询网页
			 */
			request.getRequestDispatcher("return.jsp").forward(request, response);
		}
	
		
		
		
		
	}

}
