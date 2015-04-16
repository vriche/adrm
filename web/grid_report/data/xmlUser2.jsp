
<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file = "GenXmlData.jsp" %>
<%
	String ids = request.getParameter("ids"); 
%>
<%
String sql ="SELECT ";
 sql = sql +"RS.ad_resource_info_id as id,";
 sql = sql +"UR.customer_category_id as userId,";
  sql = sql +"RC2.carrier_name as colum1,";
  sql = sql +"RC.carrier_name as colum2, ";
  sql = sql +"RS.memo as colum3,";
  sql = sql +"RS.resource_name as colum4,";
  sql = sql +"UR.category_name as colum5,";
  sql = sql +"RU.rate  as colum6 ";
  sql = sql +"FROM tb_ad_resource_info AS RS ";
  sql = sql +" left outer join tb_ad_resource_carrier RC on RS.ad_resource_carrier_id = RC.ad_resource_carrier_id";
  sql = sql +" left outer join tb_ad_resource_carrier RC2 on RC.parent_id = RC2.ad_resource_carrier_id";
  sql = sql +" left outer join tb_sys_resource_cutcaterate RU on RU.resource_id = RS.ad_resource_info_id";
  sql = sql +" left outer join tb_customer_category UR on UR.customer_category_id = RU.customer_category_id";
  sql = sql +" having colum6>0 and id in("+ ids +")" ;
  
%>
<%
XML_GenOneRecordset(response, sql);
%>