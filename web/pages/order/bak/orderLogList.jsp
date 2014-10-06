<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="orderLogList.title"/></title>
<content tag="heading"><fmt:message key="orderLogList.heading"/></content>
<meta name="menu" content="OrderLogMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOrderLog.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>



<display:table name="orderLogList" cellspacing="2" cellpadding="2"
    id="orderLogList" pagesize="9" class="tableDisplay orderLogList"
    export="false" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOrderLog.html" paramId="id" paramProperty="id"
        titleKey="orderLogForm.id"/>
        
     <display:column property="clientIp" sortable="true" headerClass="sortable"
         titleKey="orderLogForm.logForm.clientIp"/>       

     <display:column property="orderId" sortable="true" headerClass="sortable"
         titleKey="orderLogForm.orderId"/>   
         
      <display:column property="linkPath" sortable="true" headerClass="sortable"
         titleKey="orderLogForm.logForm.linkPath"/>          

      <display:column property="linkPath" sortable="true" headerClass="sortable"
         titleKey="orderLogForm.logForm.linkPath"/>   
         
      <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="orderLogForm.logForm.modifyBy"/>    
         
       <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="orderLogForm.logForm.modifyDate"/>      
                                       
        <display:column property="operateModel" sortable="true" headerClass="sortable"
         titleKey="orderLogForm.logForm.operateModel"/>  

        <display:column property="operateModelFunction" sortable="true" headerClass="sortable"
         titleKey="orderLogForm.logForm.operateModelFunction"/>  
         
         <display:column property="operateType" sortable="true" headerClass="sortable"
         titleKey="orderLogForm.logForm.operateType"/>          
                         
    <display:setProperty name="paging.banner.item_name" value="orderLog"/>
    <display:setProperty name="paging.banner.items_name" value="orderLogs"/>
</display:table>



<script type="text/javascript">
    highlightTableRows("orderLogList");
</script>
