<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="sysMenuList.title"/></title>
<content tag="heading"><fmt:message key="sysMenuList.heading"/></content>
<meta name="menu" content="SysMenuMenu"/>

<link rel="stylesheet" type="text/css" media="all" href="/adrm/styles/adrmworkspance/dhtmlXTree.css" />

<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXCommon.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/dhtmlxTree/dhtmlXTree_ed.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/common/tree.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/sysMenu.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/SysMenuManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/admin/sysMenuService.js'/>"></script>



<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                    <td><span class="tile1">
                    	 <!--a href="editSysMenu.html" class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;&nbsp;&nbsp;</a-->
                    	 <a id="Btn_add" class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
                    	  <a id="Btn_load_default" class="button"><fmt:message key="sysMenuForm.loadDefMenu"/></a>
                      </span>
                    </td>
                  </tr>
                </tbody>
              </table></td>
            <td width="115"><img src="images/table1/textbox_top_right.jpg" height="27"></td>
          </tr>
        </tbody>
      </table></td>
  </tr>


<tr>
    <td><table border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td background="images/table1/textbox_left.gif" width="14"></td>
            <td bgcolor="#f4f3f4">

<table width="100%" border="1">
  <tr>
  
  
  
	<td width="20%" vAlign="top">
			<div id="sysMenuTreebox" 
				 style="width:100%; 
				 height:500px;
				 background-color:#f5f5f5;
				 border :1px solid Silver;"/>
				 								
	</td>
	
	
	
	<td vAlign="top">  
	
	 <fieldset style="width: 97%" id="sysMenuList"> 
           <legend></legend>	
			<table  id="sysMenuTable" class=ListShort width="100%" cellpadding="0" >
              <thead>
                <TR class=Header>  
                   <!--父节点-->
                  <TH><fmt:message key="sysMenuForm.name"/></TH>
                  <!--文档编号-->
                  <TH><fmt:message key="sysMenuForm.altImage"/></TH>
                  <!--名字-->
                  <TH><fmt:message key="sysMenuForm.action"/></TH>
                  <!--创建人-->
                  <TH><fmt:message key="sysMenuForm.title"/></TH>
                  
                  <TH><fmt:message key="sysMenuForm.displayNo"/></TH>
                  <!--创建人-->
                 
                  
                                   
                  <TH id="Image_add" colspan="4"> 
                  		<img src="image/CRM_ADD.GIF" border="0"> 
                  </TH>
                </TR>
                
                <tr > 
                  <td colspan="10">
	                   <table width="100%" border="0" cellspacing="0" cellpadding="0">
	                      <tr> 
	                        <td class=blackLine><IMG src="image/s.gif"  width=1 height=1></td>
	                      </tr>
	                    </table>
                    </td>
                </tr>
              </thead>
              
              <tbody id="sysMenuBody"/> 
		
	          <tbody>
	          <tr height="20"><td colspan="7">
					<table width="100%" border="0" cellspacing="0" cellpadding="0">
			  				 <tr>
				  				 	 <td colspan="2"><IMG src="image/s.gif"  width="100%" height="2">
				  				 	 </td>
				  				 </tr>
		                        <tr  bgcolor="#D8DFE7" colspan="2"> 
		                          <td align="right"> 
		                              <div id="sysMenuPageInfo"></div>
		                          </td>
		                     	</tr>
				  </table>
	          </tr>
	          </tbody>
     </table>  
	 </fieldset>
		
	 <fieldset style="width: 97%" id="sysMenuForm"> 
           <legend></legend>
        <fieldset>
		<table width="100%" border="0" cellpadding="0" cellspacing="0">
		   <tr> 
		   <td width="70%">	    
		
			<table width="50%" border="0" cellspacing="0" cellpadding="5">
			<tbody> 
			    <tr> 
			    	<td nowrap="nowrap" class="requiredInput">
				    	<fmt:message key="sysMenuForm.name"/>:       	
			        </td>
			        <td><input name="text" type="text" id="name"></td>
			         
				    <td nowrap="nowrap" class="requiredInput">
				    	<fmt:message key="sysMenuForm.image"/>:       	
			        </td>
			        <td><input name="text" type="text" id="image"></td>
			        
			         <td nowrap="nowrap" class="requiredInput">
				    	<fmt:message key="sysMenuForm.action"/>:       	
			        </td>
			        <td><input name="text" type="text" id="action"></td>
			        
			        
			        <td nowrap="nowrap" class="requiredInput">
				    	<fmt:message key="sysMenuForm.target"/>:       	
			        </td>
			        <td><input name="text" type="text" id="target"></td>
			        
			        	        
				</tr>
				
				<tr>
				    <td nowrap="nowrap" class="requiredInput">
				    	<fmt:message key="sysMenuForm.title"/>:       	
			        </td>
			        <td><input name="text" type="text" id="title"></td>
				
				
			        <td nowrap="nowrap" class="requiredInput">
				    	<fmt:message key="sysMenuForm.displayNo"/>:       	
			        </td>
			        <td><input name="text" type="text" id="displayNo"></td>
			        
			         <td nowrap="nowrap" class="requiredInput">
				    	<fmt:message key="sysMenuForm.isDisplay"/>:       	
			        </td>
			        <td><input name="isDisplay" type="checkbox" id="isDisplay"></td>	
			        
			        
				    <td nowrap="nowrap" class="requiredInput">
				     	
			        </td>
			        <td></td>			         		        		        

			    </tr>
			    
			</tbody>
		 </table>
		  <div style="display:none;">
			   
			       
				
				</div>
		 </td></tr>
		 </table>
		</fieldset>
		&nbsp;&nbsp;
		<fieldset>
		<table width="26%" border="0" cellspacing="0" cellpadding="0">
			 <tr>
				<td align="center">
				        
						<input type="button" id="Btn_save_sysMenu" value="<fmt:message key="button.save"/>" >
						<input type="button" id="Btn_cancel_Edit" value="<fmt:message key="button.cancel"/>">
		
				 </td>
			</tr>
		</table>
		</fieldset>
 	</fieldset>
 
	<div style="display:none;">
	 				image:<input name="createBy" type="text" id="image">
			        
				    treeLevel:<input name="treeLevel" type="text" id="treeLevel">
			        
			    	<!--createDate:<input name="createDate" type="text" id="createDate"-->
			    	
				    description:<input name="description" type="text" id="description">
				    
			        forward:<input name="forward" type="text" id="forward">
			        
					height:<input name="height" type="text" id="height">
			        
			        width:<input name="width" type="text" id="width">
			        
			        location:<input name="location" type="text" id="location">
			        
					modifyBy:<input name="modifyBy" type="text" id="modifyBy">
			        
			       <!--modifyDate:<input name="modifyDate" type="text" id="modifyDate"-->
			        
			       pageNum:<input name="pageNum" type="text" id="pageNum">
			       
				   onmouseout:<input name="onmouseout" type="text" id="onmouseout">

			       onmouseover:<input name="onmouseover" type="text" id="onmouseover">
			        
			       roles:<input name="roles" type="text" id="roles">
			       
				   target:<input name="target" type="text" id="target">
			        
			       tooltip:<input name="tooltip" type="text" id="tooltip">
			       
				   version:<input name="version" type="text" id="version">
			        
			       onclick:<input name="text" type="text" id="onclick">


				  parentId:<input name="parentId" type="text" id="parentId">
	
	<br>
	
	idd:<input name="id" type="text" id="id">
	 
	</div>   
           
	</td>
  </tr>
</table>


            </td>
            <td width="14" background="images/table1/textbox_right.gif"></td>
          </tr>
        </tbody>
      </table></td>
  </tr>
  <tr> 
    <td><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tbody>
          <tr> 
            <td width="14"><img src="images/table1/textbox_bottom_left.gif" height="19" width="14"></td>
            <td width="100%" background="images/table1/textbox_bottom.gif"></td>
            <td width="14"><img src="images/table1/textbox_bottom_right.gif" height="19" width="14"></td>
          </tr>
        </tbody>
      </table></td>
  </tr>
</table>
