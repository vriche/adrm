<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="contractDetail.title"/></title>
<content tag="heading"><fmt:message key="contractDetail.heading"/></content>

<html:form action="saveContract" method="post" styleId="contractForm" onsubmit="return validateContractForm(this)">
<ul>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.code"/>
        <html:errors property="code"/>
        <html:text property="code" styleId="code" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.contractSort"/>
        <html:errors property="contractSort"/>
        <html:text property="contractSort" styleId="contractSort" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.contractType"/>
        <html:errors property="contractType"/>
        <html:text property="contractType" styleId="contractType" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.createBy"/>
        <html:errors property="createBy"/>
        <html:text property="createBy" styleId="createBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.createDate"/>
        <html:errors property="createDate"/>
        <html:text property="createDate" styleId="createDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.csignDate"/>
        <html:errors property="csignDate"/>
        <html:text property="csignDate" styleId="csignDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.customerId"/>
        <html:errors property="customerId"/>
        <html:text property="customerId" styleId="customerId" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.endDate"/>
        <html:errors property="endDate"/>
        <html:text property="endDate" styleId="endDate" styleClass="text medium"/>

    </li>

<html:hidden property="id"/>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.isLimitOrder"/>
        <html:errors property="isLimitOrder"/>
        <html:text property="isLimitOrder" styleId="isLimitOrder" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.memo"/>
        <html:errors property="memo"/>
        <html:text property="memo" styleId="memo" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.memoRenew"/>
        <html:errors property="memoRenew"/>
        <html:text property="memoRenew" styleId="memoRenew" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.modifyBy"/>
        <html:errors property="modifyBy"/>
        <html:text property="modifyBy" styleId="modifyBy" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.modifyDate"/>
        <html:errors property="modifyDate"/>
        <html:text property="modifyDate" styleId="modifyDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.moneyExec"/>
        <html:errors property="moneyExec"/>
        <html:text property="moneyExec" styleId="moneyExec" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.moneyIn"/>
        <html:errors property="moneyIn"/>
        <html:text property="moneyIn" styleId="moneyIn" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.moneySum"/>
        <html:errors property="moneySum"/>
        <html:text property="moneySum" styleId="moneySum"  styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.notifyDays"/>
        <html:errors property="notifyDays"/>
        <html:text property="notifyDays" styleId="notifyDays" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.osignDate"/>
        <html:errors property="osignDate"/>
        <html:text property="osignDate" styleId="osignDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.owner"/>
        <html:errors property="owner"/>
        <html:text property="owner" styleId="owner" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.signHeadship"/>
        <html:errors property="signHeadship"/>
        <html:text property="signHeadship" styleId="signHeadship" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.signUser"/>
        <html:errors property="signUser"/>
        <html:text property="signUser" styleId="signUser" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.startDate"/>
        <html:errors property="startDate"/>
        <html:text property="startDate" styleId="startDate" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.state"/>
        <html:errors property="state"/>
        <html:text property="state" styleId="state" styleClass="text medium"/>

    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.userId"/>
        <html:errors property="userId"/>
        <html:text property="userId" styleId="userId" styleClass="text medium"/>

    </li>

<html:hidden property="version"/>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.contractPayments"/>
        <html:errors property="contractPayments"/>
        <html:text property="contractPayments" styleId="contractPayments" styleClass="text medium"/>
        <c:forEach var="payment" items="${ContractPaymentForm}" >
            payNumber:<c:out value="${payment.payNumber}"/><br>
        </c:forEach>
    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.orders"/>
        <html:errors property="orders"/>
        <html:text property="orders" styleId="orders" styleClass="text medium"/>
        
        <display:table name="contractForm.orders" cellspacing="0" cellpadding="0" requestURI="" 
		    defaultsort="1" id="orders" pagesize="25" class="table" >
		    <display:column property="orderCode" sortable="true" titleKey="userForm.email" style="width: 25%" autolink="true" media="html"/>
		    <display:column property="relationCode" sortable="true" titleKey="userForm.email" style="width: 25%" autolink="true" media="html"/>
		    
		    <display:setProperty name="paging.banner.item_name" value="order"/>
		    <display:setProperty name="paging.banner.items_name" value="orders"/>
		
		    <display:setProperty name="export.excel.filename" value="User List.xls"/>
		    <display:setProperty name="export.csv.filename" value="User List.csv"/>
		    <display:setProperty name="export.pdf.filename" value="User List.pdf"/>
		</display:table>
		
		<c:forEach var="order" items="${contractForm.orders}" >
            <c:out value="${order.orderCode}"/>
        </c:forEach>
        
        
<br>
        <c:forEach var="order" items="${contractForm.contractOrders}" >
            <c:out value="${order.orderCode}"/>
        </c:forEach>
        
        
    </li>

    <li>
        <adrm_order:label styleClass="desc" key="contractForm.customerId"/>
        <html:errors property="customer"/>

        <input Id="customer" class="text medium" type="text" value=
        <c:forEach var="customer" items="${contractForm.customer}" >
            <c:out value="${customer.customerName}"/>
        </c:forEach>
        />
	
    </li>


    <li class="buttonBar bottom">
        <html:submit styleClass="button" property="method.save" onclick="bCancel=false">
            <fmt:message key="button.save"/>
        </html:submit>

        <html:submit styleClass="button" property="method.delete" onclick="bCancel=true; return confirmDelete('Contract')">
            <fmt:message key="button.delete"/>
        </html:submit>

        <html:cancel styleClass="button" onclick="bCancel=true">
            <fmt:message key="button.cancel"/>
        </html:cancel>
    </li>
</ul>
</html:form>

<script type="text/javascript">
    Form.focusFirstElement($("contractForm"));
</script>

<html:javascript formName="contractForm" cdata="false" dynamicJavascript="true" staticJavascript="false"/>
<script type="text/javascript" src="<html:rewrite page="/scripts/validator.jsp"/>"></script>
