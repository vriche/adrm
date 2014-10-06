<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="contractList.title"/></title>
<content tag="heading"><fmt:message key="contractList.heading"/></content>
<meta name="menu" content="ContractMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editContract.html"/>'"
        value="<fmt:message key="button.add"/>"/>

    <input type="button" onclick="location.href='<html:rewrite forward="mainMenu"/>'"
        value="<fmt:message key="button.done"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="contractList" cellspacing="1" cellpadding="0"
    id="contractList" pagesize="9" class="tableDisplay contractList"
    partialList="true" size="resultSize" 
    export="false" requestURI="contracts.html">
    
     <display:column property="code" sortable="true" headerClass="sortable"
        url="/editContract.html" paramId="id" paramProperty="id"
        titleKey="contractForm.code"/>       					 <!--��ͬ���-->
         
    <display:column  titleKey="contractForm.customerId"  sortable="true" headerClass="sortable" >
		     <c:forEach var="cut" items="${contractList.customer}">
						<a href="editCustomer.html?id=<c:out value="${contractList.customerId}"/>" > <c:out value="${cut.customerName}"/>   </a>  <!--�ͻ�����-->
			 </c:forEach>
	</display:column>          
         
         
    <display:column property="moneySum" sortable="true" headerClass="sortable"
         format="{0,number,##,###.00}" 
         titleKey="contractForm.moneySum"/>						<!--ԤͶ���ܽ��-->
                  
    <display:column property="moneyExec" sortable="true" headerClass="sortable"
         format="{0,number,##,###.00}" 
         titleKey="contractForm.moneyExec"/>					<!--��Ͷ�Ž��-->
         
    <display:column property="moneyIn" sortable="true" headerClass="sortable"
         format="{0,number,##,###.00}" 
         titleKey="contractForm.moneyIn"/>						<!--�ѷ�����-->         
         
    <display:column property="startDate" sortable="true" headerClass="sortable"
         decorator="com.vriche.adrm.webapp.util.ConvertNum2DateWrapper"
         titleKey="contractForm.startDate"/>					<!--��ʼ����-->
         
    <display:column property="endDate" sortable="true" headerClass="sortable"
         decorator="com.vriche.adrm.webapp.util.ConvertNum2DateWrapper"
         titleKey="contractForm.endDate"/>						<!--��������-->
         
    <display:column property="state" sortable="true" headerClass="sortable"
         titleKey="contractForm.state"/>						<!--��ͬ״̬-->        

    <display:setProperty name="paging.banner.item_name" value="contract"/>
    <display:setProperty name="paging.banner.items_name" value="contracts"/>
    <display:setProperty name="paging.banner.group_size" value="6"/>
</display:table>




<script type="text/javascript">
    highlightTableRows("contractList");
</script>
