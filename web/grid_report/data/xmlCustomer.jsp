
<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
XML_GenOneRecordset(response, "select * from Customers order by Region,City");
%> 