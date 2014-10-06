<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="branchList.title"/></title>


<meta http-equiv="Content-Type" content="text/html; charset=gb2312">

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/theme.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXTree.css'/>" />

<script type='text/javascript' src='<c:url value='/dwr/engine.js'/>'></script>
<script type='text/javascript' src='<c:url value='/dwr/util.js'/>'></script>

        <script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
                <script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>    
    <script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>

  		<script type="text/javascript" src="<c:url value='/dwr/interface/SysParamUtil.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/admin/sysParams.js'/>"></script> 
		
<script type="text/javascript" src="<c:url value='/dwr/interface/UserManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierTypeManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/prototype.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/generic.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/branch.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/sysOrg.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/BranchManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OrgManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/admin/branchListService.js'/>"></script>


		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/ext-all.css'/>" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/button.css'/>" />
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/adapter/ext/ext-base.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-all.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/ext-lang-zh_CN.js'/>" charset="utf-8"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/TreeCheckNodeUI.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/ButtonLite.js'/>"></script>



<table width="99%" border="0">

  <tr>
  
  
	<td width="20%" vAlign="top">
	
		<table width="100%" border="0" id="orgId_td" >
		  <tr>
		  		<td  width="1px"><select id="orgId"/></td>
		     <td >     
		 </tr>
		 </table>
	
	
		<table width="100%" border="0">
		  <tr>
		  	<td >
				<div id="branchTreebox" 
					style="width:100%; 
					height:500px;
					background-color:#f5f5f5;
					border :1px solid Silver;"/>
		    </td>
		    
		     <td >     
		 </tr>
		 </table>	
	
	

				
		
	</td>
	
	
	
	<td vAlign="top">  
	
	
	<div>
	
	<fieldset style="width: 100%" id="branchList"> 
           <legend></legend>	
			<table  id="branchTable" class=ListShort width="100%" cellpadding="0" >
              <thead>
                <TR class=Header>  
                   <!--部门名-->
                  <TH><fmt:message key="branchForm.name"/></TH>
                  <!--显示顺序-->
                  <TH><fmt:message key="branchForm.displayNo"/></TH>
                   <!--部门统计-->
                  <TH>部门统计</TH>   
                                                 
                  <TH id="Image_add" colspan="3"> 
                  		&nbsp;
                  </TH>
                </TR>
                
                <tr > 
                  <td colspan="10">
	                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
	                      <tr> 
	                        <td class=blackLine><IMG src="../image/s.gif"  width=1 height=1></td>
	                      </tr>
	                    </table>
                    </td>
                </tr>
              </thead>
              
              <tbody id="branchBody"/> 
		
	          <tbody> 
	          <tr height="20"><td colspan="7">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
			  				 <tr>
				  				 	 <td colspan="2"><IMG src="../image/s.gif"  width="100%" height="2">
				  				 	 </td>
				  				 </tr>
		                        <tr   colspan="2"> 
		                          <td align="right"> 
		                              <div id="branchPageInfo"></div>
		                          </td>
		                     	</tr>
				  </table>
	          </tr>
	          </tbody>
     </table>  
 </fieldset>
 
 	</div>
 	


<div>
 		
      <fieldset style="width:100%" id="branchForm"> 
      
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
		   <tr> 
		   <td width="70%">	    
		
			<table width="50%" border="0" cellspacing="0" cellpadding="5">
			<tbody> 
			  <tr> 
				    <td width="50%" nowrap="nowrap" class="dataLabel">
				    	<fmt:message key="branchForm.name"/>:       	
			        </td>
			        <td>
				        <input name="text" type="text" id="name">
					</td>
		      </tr>

		
		
		<tr style="display:none;"> <!--部门-->
		         <td width="50%" nowrap="nowrap" class="dataLabel">
				    	<fmt:message key="branchForm.parentId"/>:       	
			   </td>
	            <td align="left">
 						<select name="branchParentIdRN" id="branchParentIdRN"/>
                 </td>
		</tr> 
		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	部门统计:       	
	        </td>
	        <td>
		        <input name="treeLevel" type="checkbox" id="treeLevel">
			</td>
		</tr>
		<tr> 
		    <td width="50%" nowrap="nowrap" class="dataLabel">
		    	<fmt:message key="branchForm.displayNo"/>:       	
	        </td>
	        <td>
		        <input name="text" type="text" id="displayNo">
			</td>
		</tr>
		      
			</tbody>
		 </table>
		
		 </td></tr>
		 </table>
		</fieldset>

 
 
 	</div>		 
	 
<div style="display:none;">

                 
     parentId:<input name="text" type="text" id="parentId">
     categoryId:<input name="text" type="text" id="category_id">
     idd:<input name="id" type="text" id="id">
</div>

<script type="text/javascript">
    highlightTableRows("branchList");
</script>
