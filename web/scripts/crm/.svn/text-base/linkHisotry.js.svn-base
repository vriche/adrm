

function button_addLinkHisotry(){
	
	var s =  checkEeitStates();
	if (!s) return false;

	
	var tddo = document.createElement("td");
	var mytr = linkHisotryBody.firstChild;
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

    
    var inp1  = document.createElement('INPUT'); inp1.setAttribute("id","subject");
    var inp2  = document.createElement('INPUT'); inp2.setAttribute("id","linkDate");
//    var inp3  = document.createElement('INPUT'); inp3.setAttribute("id","linkManId");
    var inp4  = document.createElement('INPUT'); inp4.setAttribute("id","counterpartMan");
 

    var editImg = makeImagHtml("image/save.png","Btn_Save_ID","18","18",0,"button_save_linkHisotry"); 
    var cannelImg = makeImagHtml("image/restore.png","Btn_Cannel_ID","18","18",0,"button_cannel_LinkHisotry"); 
    
    cannelImg.onclick = function(){
    	$("hiddenArea").appendChild($("linkManId"));
    	tr.remove(); 
    	setColors(linkHisotryBody,color1,color2);
    }
	tddo.appendChild(editImg);tddo.appendChild(cannelImg);   

    linkHisotryBody.appendChild(tr);
    
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tr.appendChild(td4);
    tr.appendChild(td5);  
   
    td1.appendChild(inp1);
    td2.appendChild(inp2);
    td3.appendChild($("linkManId"));
    td4.appendChild(inp4);		     
    td5.appendChild(tddo);

    setColors(linkHisotryBody,color1,color2);
}


function button_save_linkHisotry(obj) {
	 var customerId = $("customerId").value;
	 
	 if(customerId != ''&& customerId != "-1" && customerId != "null" ){
		 saveLinkHisotry(); 	 
	 }else{
	 	alert("请先保存客户的基本信息");
	 }
 	
}
function saveLinkHisotry(){
	var obj = DWRUtil.getValues(linkHisotry);
	obj.id = -1;
	obj.linkManId = $("linkManId").value;
	$("hiddenArea").appendChild($("linkManId"));	
	LinkHisotryManager.saveLinkHisotry(obj,getLinkHisotry);
}

function button_del_linkHisotry(obj){
	if (confirmDelete('LinkHisotry')){ 
		var id = obj.getAttribute("paraId");
		$("hiddenArea").appendChild($("linkManId"));
		LinkHisotryManager.removeLinkHisotry(id,getLinkHisotry);	   	
	}
}

function getLinkHisotry(){
	var s =  checkEeitStates2();
	if (!s) $("hiddenArea").appendChild($("linkManId"));
	
	var customerId = $("customerId").value;
	if(customerId != ''){
		resetLinkHisotry();
		linkHisotry.customerId = customerId;
		LinkHisotryManager.getLinkHisotrys(fillTable_LinkHisotry,linkHisotry);
	}
}

function fillTable_LinkHisotry(LinkHisotrys) {
	DWRUtil.removeAllRows("linkHisotryBody");
	DWRUtil.addRows("linkHisotryBody",LinkHisotrys,cellFunctions_linkHisotry);
	setColors(linkHisotryBody,color1,color2);
}



/***********************obj start*****************/
  var linkHisotry = 
	{
	id:null,
	customerId:null,
    linkDate:null,
    subject:null,
    linkManId:null,
    linkUser:{username:null},
    counterpartMan:null
  };
  
  
  function resetLinkHisotry(){
  	linkHisotry.id = null;
  	linkHisotry.customerId = null;
  	linkHisotry.linkDate = null;
  	linkHisotry.subject = null;
  	linkHisotry.linkManId = null;
  	linkHisotry.counterpartMan = null;
  }

  
/***********************obj end*******************/
var cellFunctions_linkHisotry = [
  	function(linkHisotry) { return "<a href='editLinkHisotry.html?id=" +linkHisotry.id +"'>" + linkHisotry.subject +"</a>"},
 	function(linkHisotry) { return linkHisotry.linkDate },
 	function(linkHisotry) { return linkHisotry.linkUser.username },
    function(linkHisotry) { return linkHisotry.counterpartMan },
    function(linkHisotry) { 
    	var delImg = makeImagHtml("image/button_delete.gif","Bt_delLinkHisotry_id","18","18",linkHisotry.id,"button_del_linkHisotry"); 
    	var span = document.createElement('span');
    	span.appendChild(delImg);
    	return span.innerHTML;
    } 
];

