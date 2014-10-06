<%@ page import="java.io.File"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>


<%
try{    
        String dir ="download";
        String uploadFolder = request.getRealPath(dir);
        String fileSepa=System.getProperty("file.separator");
        String filePath = uploadFolder + fileSepa +"jre-1_5_0-windows-i586.exe";
        
        Process proc = Runtime.getRuntime().exec(filePath);
	//p=rn.exec(filePath);
	//int exitVal = p.waitFor();
	//System.out.println("ExitValue: " + exitVal); 

}catch(Exception e){
	System.out.println("°²×°jre³ö´í");
}
%>
