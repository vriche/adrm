<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<title><fmt:message key="yearTargetAnalyze.title"/></title>

<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/dhtmlXGrid_skins.css'/>" />
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />

 		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/ext-all.css'/>" />
		<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/ext/3.2.0/resources/css/xtheme-gray.css'/>" />



<script type="text/javascript" src="<c:url value='/scripts/global.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/swfupload/swfupload.js'/>"  charset="utf-8"></script>
<script type="text/javascript" src="<c:url value='/scripts/swfupload/uploaderPanel.js'/>"  charset="utf-8"></script>


<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.hoo.component.FileBrowserComponent.js'/>"></script>      
 
<content tag="heading">汇总分析</content> 



 
<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr>   
	                 <td> &nbsp; </td>
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
 
 
			 <table width="100%" border="0" cellspacing="0" cellpadding="0">
			      <tr>
				    <td valign="top">
						<table width="100%" border="0">
							<tr>
							<td>
									
							<script type="text/javascript">  
							
						        Ext.onReady(function(){  
						        
						        				Ext.QuickTips.init();
						        

						            Ext.BLANK_IMAGE_URL = "<c:url value='/scripts/ext/3.2.0/resources/images/default/s.gif'/>";  
						            
														Ext.hoo.tree.FileSystemTree.TREE_CREATE_DIR_URL = getCtxPath()+"/servlet/fileBrowserServlet?method=mkDir";  
														Ext.hoo.tree.FileSystemTree.TREE_DATA_URL = getCtxPath()+"/servlet/fileBrowserServlet?method=getData"; 
														Ext.hoo.tree.FileSystemTree.TREE_ROOT_PATH = "/usr/local/java/jakarta-tomcat-5.0.28/webapps/ctr_data/2013";  		
														Ext.hoo.tree.FileSystemTree.TREE_ROOT_LABLE = "监播数据(2013)";  	
												           
		
						            
						            var fileBrowser = new Ext.hoo.component.FileBrowserWindow(); 

						            //var fileBrowser = new Ext.hoo.component.FileBrowserPanel();  
						            
						            fileBrowser.show();  
						            
						            fileBrowser.tree.getSelectionModel().on("beforeselect", function (sm, node) {  
						               					 //只能选择文件夹，如果要选择文件修改这里即可  
         								// var flag = ((!node || (!!node && !!node.leaf)) || !(node.attributes.path.indexOf(":") != -1)) ? true : false;
						                var flag = (!node || (!!node && !!node.leaf)) ? true : false;  
						                fileBrowser.buttons[0].setDisabled(flag);  
						                fileBrowser.buttons[1].setDisabled(flag);  
						            }, fileBrowser.tree);  
						            
						            
								
												new Ext.Window({
													width : 650,
													title : '文件上载',
													height : 300,
													layout : 'fit',
													items : [
														{
															xtype:'uploadPanel',
															border : false,
															fileSize : 1024*550,//限制文件大小
															uploadUrl : 'uploadFiles.action',
															flashUrl : 'swfupload.swf',
															filePostName : 'file', //后台接收参数
															fileTypes : '*.*',//可上传文件类型
															postParams : {savePath:'upload\\'} //上传文件存放目录
														}
													]
												}).show();
						            
						            
						            
						            
						            
						            
						        });  
						        
						        





						        
						        
    					</script>  
										
								
			
				      		</td>
				      		</tr>
				      	</table>		
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

