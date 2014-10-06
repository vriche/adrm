<%@ include file="/common/taglibs.jsp"%>
<script type="text/javascript" src="<c:url value='/dwr/interface/ImportExcelServlet.js'/>"></script>

<content tag="heading"><fmt:message key="resourceList.heading"/></content>
<meta name="menu" content="ResourceMenu"/>

<script type="text/javascript">

    ImportExcelServlet.test(1,callBack);
    

    //ImportExcelServlet.service();
    
    //ImportExcelServlet.setAttribute("aa","1"); 
    
    //ImportExcelServlet.getAttribute("aa",callBack); 
     
     function callBack(rt){
         alert(rt);
    }
   
</script>