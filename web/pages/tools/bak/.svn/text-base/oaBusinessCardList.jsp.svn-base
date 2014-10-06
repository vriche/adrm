<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaBusinessCardList.title"/></title>
<content tag="heading"><fmt:message key="oaBusinessCardList.heading"/></content>
<meta name="menu" content="OaBusinessCardMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaBusinessCard.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaBusinessCardList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaBusinessCardList" pagesize="25" class="tableDisplay oaBusinessCardList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaBusinessCard.html" paramId="id" paramProperty="id"
        titleKey="oaBusinessCardForm.id"/>
    <display:column property="birthdayDate" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardForm.birthdayDate"/>		<!--birthdayDate--> 
    <display:column property="birthdayMonth" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardForm.birthdayMonth"/>		<!--birthdayMonth--> 
    <display:column property="birthdayYear" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardForm.birthdayYear"/>		<!--birthdayYear--> 
    <display:column property="businessCardTypId" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardForm.businessCardTypId"/>		<!--businessCardTypId--> 
    <display:column property="firstName" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardForm.firstName"/>		<!--firstName--> 
    <display:column property="lastName" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardForm.lastName"/>		<!--lastName--> 
    <display:column property="headship" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardForm.headship"/>		<!--headship--> 
    <display:column property="mob" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardForm.mob"/>		<!--mob--> 
    <display:column property="sex" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardForm.sex"/>		<!--sex--> 
    <display:column property="tel1" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardForm.tel1"/>		<!--tel1--> 
    <display:column property="tel2" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardForm.tel2"/>		<!--tel2--> 
    <display:column property="tel3" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardForm.tel3"/>		<!--tel3--> 
    <display:column property="work" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardForm.work"/>		<!--work--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaBusinessCardForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaBusinessCard"/>
    <display:setProperty name="paging.banner.items_name" value="oaBusinessCards"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaBusinessCardList");
</script>
