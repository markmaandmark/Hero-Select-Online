package utils;

import java.io.FileWriter;
import java.io.IOException;

public class ReturnWriter
{
	public void write(String [] out) throws IOException
	{
		FileWriter fileWriterClear = new FileWriter("D:\\eclipse-workspace\\Hero-Select-Online\\src\\main\\webapp\\return.jsp");
		fileWriterClear.close();
		
		FileWriter fileWriter = new FileWriter("D:\\eclipse-workspace\\Hero-Select-Online\\src\\main\\webapp\\return.jsp",true);
		fileWriter.write("<%@ page language=\"java\" contentType=\"text/html; charset=UTF-8\" pageEncoding=\"UTF-8\"%>\n"
				+"<html>\n<body>\n");
		for(String s:out)
		{
			fileWriter.write("<p>"+s+"</p>\n");
		}
		
		fileWriter.write("<p>"+"共找到"+ out.length + "条结果"  +"</p>\n");
		fileWriter.write("</body>\n</html>\n");
		fileWriter.close();
	}
}
