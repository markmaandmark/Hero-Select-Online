package utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * 写html工具类
 * 将查询结果写入网页
 * @author markma
 * @date 修改时间:2021年8月4日 上午9:20:27
 */
public class ReturnWriter
{
	public void write(String [] out) throws IOException
	{
		File file = new File("D:\\eclipse-workspace\\Hero-Select-Online\\src\\main\\webapp\\return.jsp");
		FileWriter fileWriterClear = new FileWriter(file);
		fileWriterClear.close();
		
		FileWriter fileWriter = new FileWriter(file,true);
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
