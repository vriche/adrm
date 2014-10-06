  <%@ include file="/common/taglibs.jsp"%>
  <%@   page   import="java.sql.*"   %>    
  <%@   page   import="java.util.*"%>    
  <%@   page   import="java.text.*"%>    
  <%@   page   import="java.io.*"%>   

  
  
<title><fmt:message key="sysResourceList.title"/></title>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />

<content tag="heading"><fmt:message key="sysResourceList.heading"/></content>
<meta name="menu" content="SysResourceMenu"/>

   
  <%Class.forName("com.mysql.jdbc.Driver").newInstance();    
  String   url="jdbc:mysql://localhost/adrm?useUnicode=true&amp;characterEncoding=gbk";    
  //其中mysql为你数据库的名字，user为你连接数据库的用户，password为你连接数据库用户的密码，可自己改    
  Connection   conn=   DriverManager.getConnection(url);        
  String   filename = request.getParameter("content"); 
  
  out.println(" filename>>>>" + filename); 
  File file = new File(filename);
  FileInputStream photoStream = new FileInputStream(file);
  //out.println(" filename>>>>" + photoStream); 

  String   sql="UPDATE  tb_sys_org SET logo=? WHERE sys_org_id=1";    
  PreparedStatement   pstmt=conn.prepareStatement(sql);       
  pstmt.setBinaryStream(1, photoStream, (int) file.length());
  pstmt.executeUpdate();
  
  pstmt.close();
  conn.close();     
  
  response.sendRedirect("readImage.jsp");   
  %>    
   
  