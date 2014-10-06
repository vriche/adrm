<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaScratchpadList.title"/></title>
<content tag="heading"><fmt:message key="oaScratchpadList.heading"/></content>
<meta name="menu" content="OaScratchpadMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editOaScratchpad.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="oaScratchpadList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="oaScratchpadList" pagesize="25" class="tableDisplay oaScratchpadList"
    export="true" requestURI="">

    <display:column property="id" sortable="true" headerClass="sortable"
        url="/editOaScratchpad.html" paramId="id" paramProperty="id"
        titleKey="oaScratchpadForm.id"/>
    <display:column property="content" sortable="true" headerClass="sortable"
         titleKey="oaScratchpadForm.content"/>		<!--content--> 
    <display:column property="createBy" sortable="true" headerClass="sortable"
         titleKey="oaScratchpadForm.createBy"/>		<!--createBy--> 
    <display:column property="createDate" sortable="true" headerClass="sortable"
         titleKey="oaScratchpadForm.createDate"/>		<!--createDate--> 
    <display:column property="modifyBy" sortable="true" headerClass="sortable"
         titleKey="oaScratchpadForm.modifyBy"/>		<!--modifyBy--> 
    <display:column property="modifyDate" sortable="true" headerClass="sortable"
         titleKey="oaScratchpadForm.modifyDate"/>		<!--modifyDate--> 
    <display:setProperty name="paging.banner.item_name" value="oaScratchpad"/>
    <display:setProperty name="paging.banner.items_name" value="oaScratchpads"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("oaScratchpadList");
</script>
