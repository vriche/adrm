<%@ include file="/common/taglibs.jsp"%>
<title><fmt:message key="financeTargetAnalyze"/></title>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<script type="text/javascript" src="<c:url value='/scripts/common/print.js'/>"></script>   
		<script type="text/javascript" src="<c:url value='/scripts/ext/3.2.0/plus/Ext.ux.plugins.js'/>"></script>

<script>

callOnLoad(init);

function init(){

   var myprint =new MyPrint();
   
   myprint.buildButtons(this,"printReportDiv",[0,1,2,6],80);
   
	var config_serviceDate = _app_params.serviceDate.def;
	
	 _make_org_select("orgId",120,"onChangeOrg");	
	 
	 orgId = $("orgId").value;

	var year = getDayPar(config_serviceDate,'y');
	setSelectByValue($("target_year"),year );
	
	var btn_targetYear = $("target_year");
	btn_targetYear.onchange = getTable;
	
	var Btn_add_row=$("Btn_add_row");
	Btn_add_row.onclick = add;	
	
	var Btn_save=$("Btn_save");
	Btn_save.onclick = save;

	var Btn_delete_row=$("Btn_delete_row");
	Btn_delete_row.onclick = del;	
	
	_make_adrm_sys_year_select("target_year",_app_params.serviceDate.adrmSysYear, _app_params.serviceDate.year);
	
	$("tarForm").src = 'selectPopup/financeTarget.html?year='+ year +'&orgId=' +orgId;
	//getTable();
	
	resetHeigth();
	

	
}


function onChangeOrg(){
	getTable();
	tarForm.makeCarrierSelectItem();

}



function printReport(mode){
//	 var s=['view','print','excel'];
	 
	if(mode =="view"){
		tarForm.button_view_target();
	}
	if(mode =="print"){
		tarForm.button_print_target();
	}
	if(mode =="excel"){
		button_export_target();
	}
	
	if(mode =="chart"){
		tarForm.getTargetChartObjs();
	}	
	
	   
}

function resetHeigth(){
   	//var dialogcontent = $("dialogcontentDiv");
   	var dialogcontent = parent.document.getElementById("dialogcontentDiv");
   	$("tarForm").style.height = dialogcontent.offsetHeight*0.8+"px";
} 

function getTable(){
		var year = $("target_year").value;
		tarForm.getCarrierCombo(false);
		tarForm.getFinanceTargetList(year);
		//$("tarForm").src = 'selectPopup/financeTarget.html?year='+ year;
}


function add(){
	tarForm.btnAddRow();
}
function save(){
	tarForm.btnSave();
}
function del(){
	tarForm.btnDeleteRow();
}


</script>

<content tag="heading">年度指标</content>

<table width="100%" border="0" cellpadding="0" cellspacing="0" >
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                  
                   <td width="1px" id="orgId_td"> <select id="orgId"/></td>		
                   
                    <td width="1px">
			               
			
							
							
							<td width="1px"><select id="target_year"  style="CURSOR: pointer;" /></td>	
                    </td>
                    
                    <td width="1px"><input  type="button"   class="button"  name="Btn_add_row" id="Btn_add_row" value='&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;'> </td>        
					<td width="1px"><input  type="button"   class="button"  name="Btn_save" id="Btn_save" value='&nbsp;&nbsp;<fmt:message key="button.save"/>&nbsp;&nbsp;'>  </td> 
					<td width="1px"><input  type="button"   class="button"  name="Btn_delete_row" id="Btn_delete_row" value='&nbsp;&nbsp;<fmt:message key="button.delete"/>&nbsp;&nbsp;'>  </td> 

					 <td width="1px" ><div id="printReportDiv" name="printReportDiv"/></td>
					 
					 <td>&nbsp;</td>			
						
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
            <!--   table start onload="this.height=tarForm.document.gridbox.scrollHeight" -->
		<iframe src=''   scrolling="no"   frameborder="0" height="300" width="100%" name="tarForm" id="tarForm"></iframe>
    <!--   table end -->
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
