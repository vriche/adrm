<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.soft4j.httpupload4j.SmartUpload"%>
<%@ page import="com.soft4j.bo.PhotoMgr"%><%
	String pageErrorInfo = null;
	SmartUpload su = null;
	try{
		su = new SmartUpload();
		su.initialize(pageContext);
		su.upload();
		pageErrorInfo = PhotoMgr.fileUpload(su,pageContext);
		if(pageErrorInfo==null){
			out.print("successed");
		}
	}catch(Exception e){
		pageErrorInfo = e.getMessage();
	}finally{
		su = null;
		if(pageErrorInfo!=null){
			out.print(pageErrorInfo);
		}
	}
%>

