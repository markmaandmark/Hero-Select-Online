<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>查询界面</title>
</head>
<body>
	<p>三国查询系统1.0</p>
	<p>属性:properties名称:姓名name,武器weaponName,生日birthday,卒日deathday,介绍introduction,ID ID,血量bloodValue,攻击力attackValue</p>
	<p>查找多个人名，属性用英文逗号连接</p>
	<p>例：刘备,曹操 ID,bloodValue</p>
	<p>by markma</p>
	<form action="SelectServlet" method="post">
		查询对象：<input type="text" id="heroId" name="Name" placeholder="输入对象姓名" /><br>
		查询属性：<input type="text" id="proId" name="Pro" placeholder="输入查询属性" /><br>
		<button type="submit">查询</button><br>
	</form>
</body>
</html>
