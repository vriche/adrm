<%@ page import="java.io.File"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<%
try{    
        String dir ="download";
        String uploadFolder = request.getRealPath(dir);
        String fileSepa=System.getProperty("file.separator");
        String filePath = uploadFolder + fileSepa +"firefox3.0.6cn.exe";
        
        Process proc = Runtime.getRuntime().exec(filePath);
	//p=rn.exec(filePath);
	//int exitVal = p.waitFor();
	//System.out.println("ExitValue: " + exitVal); 

}catch(Exception e){
	System.out.println("°²×°fireFox³ö´í");
}
%>
