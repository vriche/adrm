<?php
	if ( stristr($_SERVER["HTTP_ACCEPT"],"application/xhtml+xml") ) {
  		header("Content-type: application/xhtml+xml"); } else {
  		header("Content-type: text/xml");
	}
	echo("<?xml version=\"1.0\" encoding=\"iso-8859-1\"?>\n"); 
	if(!isset($_GET["rowsLoaded"])){
		$_GET["rowsLoaded"] = 0;
	}
?>




<%out.print("<?xml version="1.0" encoding="gb2312"?>");%>
<%@ page language="java" %>
<%@ page import="com.mysql.jdbc.Driver" %>
<%@ page import="java.sql.*" %>
<%
response.setContentType("text/xml;charset=GB2312");
String driverName="com.mysql.jdbc.Driver";
String userName="test";
String userPasswd="123456";
String dbName="atteam";
String tableName="address_book";
String url="jdbc:mysql://192.168.1.159/"+dbName;
Class.forName("com.mysql.jdbc.Driver");
Connection connection=DriverManager.getConnection(url,userName,userPasswd);
Statement statement = connection.createStatement();
String sql="SELECT * FROM "+tableName;
ResultSet rs = statement.executeQuery(sql);
out.print("<name> ");
while(rs.next()) {
StringBuffer s=new StringBuffer();

s.append("<fname> ");
s.append("<firstName>");
s.append(rs.getString("family_name"));
s.append("</firstName> ");
s.append("</fname> ");

out.print(s.toString());

}
out.print("</name>");
rs.close();
statement.close();
connection.close();
%> 