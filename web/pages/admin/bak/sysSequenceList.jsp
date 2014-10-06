<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="sysSequenceList.title"/></title>
<content tag="heading"><fmt:message key="sysSequenceList.heading"/></content>
<meta name="menu" content="SysSequenceMenu"/>

<c:set var="buttons">
    <input type="button" style="margin-right: 5px"
        onclick="location.href='<c:url value="/editSysSequence.html"/>'"
        value="<fmt:message key="button.add"/>"/>
</c:set>

<c:out value="${buttons}" escapeXml="false"/>

<display:table name="sysSequenceList" partialList="true" size="resultSize"  cellspacing="2" cellpadding="2"
    id="sysSequenceList" pagesize="25" class="tableDisplay sysSequenceList"
    export="true" requestURI="">

    <display:column property="sequenceID" sortable="true" headerClass="sortable"
        url="/editSysSequence.html" paramId="sequenceID" paramProperty="sequenceID"
        titleKey="sysSequenceForm.sequenceID"/>
    <display:column property="name" sortable="true" headerClass="sortable"
         titleKey="sysSequenceForm.name"/>		<!--name--> 
    <display:column property="prefix" sortable="true" headerClass="sortable"
         titleKey="sysSequenceForm.prefix"/>		<!--prefix--> 
    <display:column property="startNo" sortable="true" headerClass="sortable"
         titleKey="sysSequenceForm.startNo"/>		<!--startNo--> 
    <display:column property="incrementNo" sortable="true" headerClass="sortable"
         titleKey="sysSequenceForm.incrementNo"/>		<!--incrementNo--> 
    <display:column property="format" sortable="true" headerClass="sortable"
         titleKey="sysSequenceForm.format"/>		<!--format--> 
    <display:column property="currentNext" sortable="true" headerClass="sortable"
         titleKey="sysSequenceForm.currentNext"/>		<!--currentNext--> 
    <display:column property="currentNextSys" sortable="true" headerClass="sortable"
         titleKey="sysSequenceForm.currentNextSys"/>		<!--currentNextSys--> 
    <display:column property="suffix" sortable="true" headerClass="sortable"
         titleKey="sysSequenceForm.suffix"/>		<!--suffix--> 
    <display:setProperty name="paging.banner.item_name" value="sysSequence"/>
    <display:setProperty name="paging.banner.items_name" value="sysSequences"/>
</display:table>

<script type="text/javascript">
    highlightTableRows("sysSequenceList");
</script>
