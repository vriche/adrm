  <%@   page   contentType="image/jpeg;charset=gb2312"%>    
  <%@   page   import="java.sql.*"   %>    
  <%@   page   import="java.util.*"%>    
  <%@   page   import="java.text.*"%>    
  <%@   page   import="java.io.*"%>    
  <html>    
  <body> 

<%
Class.forName("com.mysql.jdbc.Driver").newInstance();
String url="jdbc:mysql://localhost/adrm?useUnicode=true&amp;characterEncoding=gbk";
Connection con = DriverManager.getConnection(url);
String sql = "select logo from tb_sys_org where sys_org_id=1";
Statement stmt = con.createStatement();
ResultSet rs = stmt.executeQuery(sql);


if(rs.next()) {
	try { 
	out.clear();
	out = pageContext.pushBody();   
	
	//request.setContentType("image/jpeg"); 
	ServletOutputStream op = response.getOutputStream();
	InputStream in = rs.getBinaryStream(1);
	int len;
	byte[] buf=new byte[1024];

	while((len= in.read(buf))!=-1) {
		op.write(buf, 0, len);
	}

	
	
	in.close();
	op.close();
	
	}catch(Exception e){
		out.println(e);
	} 
	
	
	try { 
	  
	  File file = new File("e:/Winter.jpg");
	  if(!file.exists()) file.createNewFile();

	  InputStream in = rs.getBinaryStream(1);
	  FileOutputStream fout = new FileOutputStream(file);
	  int len;byte[] buf=new byte[1024];
	  while((len= in.read(buf))!=-1) {
		fout.write(buf, 0, len);
	  }
	  
	  
	  
	  in.close();
	  fout.close();
	 
	
	}catch(Exception e){
		out.println(e);
	} 
	
	
}

rs.close();
stmt.close();
con.close();   

%>   

 
    </body>    
  </html>   