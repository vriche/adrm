<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<%
try{
  	String dir ="download";
        String uploadFolder = request.getRealPath(dir);
        String fileSepa=System.getProperty("file.separator");
        String filePath = uploadFolder + fileSepa +"install_flash_player.exe";
        
        Process proc = Runtime.getRuntime().exec(filePath);
	//p=rn.exec(filePath);
	//int exitVal = p.waitFor();
	//System.out.println("ExitValue: " + exitVal); 	
	
}catch(Exception e){
	System.out.println("<script>alert('°²×°flash_player³ö´í')<script>");
}
%>