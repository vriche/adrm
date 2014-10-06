<jsp:useBean id="TheBean" scope="page" class="com.vriche.adrm.webapp.serlet.ImportExcelServlet" /> 

<% 
TheBean.doUpload2(1,request); 
%> 

<%=request.getParameter("filename") %>  
<%=request.getParameter("filename22") %>  