package controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
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
		String undName = new String(request.getParameter("Name").getBytes("iso-8859-1"), "utf-8");
		String undPro = new String(request.getParameter("Pro").getBytes("iso-8859-1"), "utf-8");
		if(undName != null || undPro != null)
		{
			NameProDivider divNamePro = new NameProDivider(undName,undPro);
			divNamePro.divideName();
			divNamePro.dividePro();
			
			HeroDao hd = new HeroDao();
			List<Hero> heroList = hd.find(divNamePro.getDividedName());
			
			PropertiesDao pd = new PropertiesDao();
			String[] printHeroInfo = pd.find(heroList, divNamePro.getDividedProperties());
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/plain");
			
			ReturnWriter returnwriter = new ReturnWriter();
			returnwriter.write(printHeroInfo);
			
			request.getRequestDispatcher("return.jsp").forward(request, response);
		}
	
		
		
		
		
	}

}
