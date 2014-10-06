

function button_addAgentInfo(){
	
	var s =  checkEeitStates();
	if (!s) return false;

	
//	var tddo = document.createElement("td");
	var mytable = $("agentInfoList");
	var mytablebody = mytable.getElementsByTagName("tbody")[0];
	var mytr = mytablebody.firstChild;
	if(mytr != "undefined" && mytr != null && mytr !=""){
		var myclass = mytr.getAttribute("class");
		if(myclass =="empty") mytr.remove();		
	}

	var tr = document.createElement('TR');

    var td1   = document.createElement('TD');
    var td2   = document.createElement('TD');
    var td3   = document.createElement('TD');
    var td4   = document.createElement('TD');
    var td5   = document.createElement('TD');
//    var td6   = document.createElement('TD');
    var inp2  = document.createElement('INPUT');
    inp2.setAttribute("id","agentRate");
    
    var editImg = makeImagHtml("image/save.png","Btn_Save_ID","18","18",0,"button_save_agentInfo"); 
    var cannelImg = makeImagHtml("image/restore.png","Btn_Cannel_ID","18","18",0,"button_cannel_agentInfo"); 
    
    cannelImg.onclick = function(){
    	$("hiddenArea").appendChild($("dtIndustryTypeId"));
    	tr.remove(); 
    	setColors(mytablebody,color1,color2);
    }
//	tddo.appendChild(editImg);tddo.appendChild(cannelImg);   
   
    
    $("agentInfoBody").appendChild(tr);
    
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tr.appendChild(td4);
    tr.appendChild(td5);
//    tr.appendChild(td6);    

    td1.appendChild($("dtIndustryTypeId"));			   
    td2.appendChild(inp2);
//    td3.innerHTML = "<input type=\"text\"  id=\"beginDate\"  readonly=\"true\" onclick=\"button_showdate_input_edit('beginDate','anchorBeginDate')\"/> " +
//                    "<span id=\"anchorBeginDate\" name=\"anchorBeginDate\"></span>";
//    
//    td4.innerHTML = "<input type=\"text\"  id=\"endDate\"  readonly=\"true\" onclick=\"button_showdate_input_edit('endDate','anchorEndDate')\"/> " +
//                    "<span id=\"anchorEndDate\" name=\"anchorEndDate\"></span>";  


    td3.innerHTML = makeDateInputTextHmtl("beginDate","anchorWStart",curDate,"button_showdate_input_edit").innerHTML;
    
    td4.innerHTML = makeDateInputTextHmtl("endDate","anchorWEnd",curDate,"button_showdate_input_edit").innerHTML;  
                                                                     
                    
//    td6.appendChild(tddo);

    setColors(mytablebody,color1,color2);
}




function button_save_agentInfo(obj) {
	 var customerId = $("customerId").value;

	 if(customerId != ''&& customerId != "-1" && customerId != "null" ){
		 saveAgentInfo(); 	 
	 }else{
	 	alert("请先保存客户的基本信息");
	 }
 	
}

function button_del_agentInfo(obj){
	if (confirmDelete('AgentInfo')){ 
		var id = obj.getAttribute("paraId");
		$("hiddenArea").appendChild($("dtIndustryTypeId"));
		AgentInfoManager.removeAgentInfo(id,getAgentInfo);	   	
	}

}


function getAgentInfo(){
	var s =  checkEeitStates2();
	if (!s) $("hiddenArea").appendChild($("dtIndustryTypeId"));
	
	var customerId = $("customerId").value;

	if(customerId != ''){
		resetAgentInfo();
		agentInfo.customerId = customerId;
		AgentInfoManager.getAgentInfos(fillTable_agentInfo,agentInfo);
	}
	
	
}

function fillTable_agentInfo(agentInfos) {
	DWRUtil.removeAllRows("agentInfoBody");
	DWRUtil.addRows("agentInfoBody",agentInfos,cellFunctions_agentInfo);
	setColors($("agentInfoBody"),color1,color2);
}

function saveAgentInfo(){
	var obj = DWRUtil.getValues(agentInfo);
	obj.id = -1;
	obj.industryTypeId = $("dtIndustryTypeId").value;
	$("hiddenArea").appendChild($("dtIndustryTypeId"));	
	AgentInfoManager.saveAgentInfo(obj,getAgentInfo);
}



/***********************obj start*****************/
  var agentInfo = 
	{
	id:-1,
    customerId:-1,
    agenetType:-1,
    resourcePriceTypeId:-1,
    industryTypeId:-1,
    industry:{name:null},
    agentRate:0.0,
    beginDate:"19991231",
    endDate:"19991231",
    state:1
  };
  
  function resetAgentInfo(){
  	agentInfo.id = "";
    agentInfo.customerId = "";
    agentInfo.agenetType = "";
    agentInfo.resourcePriceTypeId = "";
    agentInfo.industryTypeId = "";
    agentInfo.industry.name = "";
    agentInfo.agentRate = "";
    agentInfo.beginDate = "";
    agentInfo.endDate = "";
    agentInfo.state = "";	
  }
  
/***********************obj end*******************/

var cellFunctions_agentInfo = [
  	function(agentInfo) { return agentInfo.industry.name },
 	function(agentInfo) { return ForDight(agentInfo.agentRate*100,0) +"%" },
 	function(agentInfo) { return agentInfo.beginDate },
    function(agentInfo) { return agentInfo.endDate },
  	function(agentInfo) { return agentInfo.state },
//    function(agentInfo) { 
//    	var delImg = makeImagHtml("image/button_delete.gif","Bt_delAgentInfo_id","18","18",agentInfo.id,"button_del_agentInfo"); 
//    	var span = document.createElement('span');
//    	span.appendChild(delImg);
//    	return span.innerHTML;
//    } 
];














