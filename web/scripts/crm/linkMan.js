

function button_addLinkMan(){
	
	var s =  checkEeitStates();
	if (!s) return false;

	
	var tddo = document.createElement("td");
	var mytr = linkManBody.firstChild;
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
    var td6   = document.createElement('TD');

    
    var inp1  = document.createElement('INPUT'); inp1.setAttribute("id","linkmanName");
    var inp2  = document.createElement('INPUT'); inp2.setAttribute("id","homeTel");
    var inp3  = document.createElement('INPUT'); inp3.setAttribute("id","officeTel");
    var inp4  = document.createElement('INPUT'); inp4.setAttribute("id","mobile");
    var inp5  = document.createElement('INPUT'); inp5.setAttribute("id","favorEmail");    

    var editImg = makeImagHtml("image/save.png","Btn_Save_ID","18","18",0,"button_save_linkMan"); 
    var cannelImg = makeImagHtml("image/restore.png","Btn_Cannel_ID","18","18",0,"button_cannel_linkMan"); 
    
    cannelImg.onclick = function(){
    	tr.remove(); 
    	setColors(linkManBody,color1,color2);
    }
	tddo.appendChild(editImg);tddo.appendChild(cannelImg);   

    linkManBody.appendChild(tr);
    
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tr.appendChild(td4);
    tr.appendChild(td5);
    tr.appendChild(td6);    
   
    td1.appendChild(inp1);
    td2.appendChild(inp2);
    td3.appendChild(inp3);
    td4.appendChild(inp4);		
    td5.appendChild(inp5);       
    td6.appendChild(tddo);

    setColors(linkManBody,color1,color2);
}


function button_save_linkMan(obj) {
	 var customerId = $("customerId").value;
	 
	 if(customerId != ''&& customerId != "-1" && customerId != "null" ){
		 saveLinkMan(); 	 
	 }else{
	 	alert("请先保存客户的基本信息");
	 }
 	
}
function saveLinkMan(){
	var obj = DWRUtil.getValues(linkMan);
	obj.id = -1;
	LinkManManager.saveLinkMan(obj,getLinkMan);
}

function button_del_linkMan(obj){
	if (confirmDelete('LinkMan')){ 
		var id = obj.getAttribute("paraId");
		LinkManManager.removeLinkMan(id,getLinkMan);	   	
	}
}

function getLinkMan(){
	var customerId = $("customerId").value;
	if(customerId != ''){
		resetLinkMan();
		linkMan.customerId = customerId;
		LinkManManager.getLinkMans(fillTableLinkMan,linkMan);
	}
}

function fillTableLinkMan(linkManList) {
	DWRUtil.removeAllRows("linkManBody");
	DWRUtil.addRows("linkManBody",linkManList,cellFunctions_linkMan);
	setColors(linkManBody,color1,color2);
}



/***********************obj start*****************/
  var linkMan = 
	{
	id:null,
	customerId:null,
    linkmanName:null,
    homeTel:null,
    officeTel:null,
    mobile:null,
    favorEmail:null
  };
  
  
  function resetLinkMan(){
  	linkMan.id = null;
  	linkMan.customerId = null;
  	linkMan.linkmanName = null;
  	linkMan.homeTel = null;
  	linkMan.officeTel = null;
  	linkMan.mobile = null;
  	linkMan.favorEmail = null;
  }

  
/***********************obj end*******************/
var cellFunctions_linkMan = [
  	function(linkMan) { return "<a href='editLinkMan.html?id=" +linkMan.id +"'>" + linkMan.linkmanName +"</a>"},
 	function(linkMan) { return linkMan.homeTel },
 	function(linkMan) { return linkMan.officeTel },
    function(linkMan) { return linkMan.mobile },
  	function(linkMan) { return linkMan.favorEmail },
    function(linkMan) { 
    	var delImg = makeImagHtml("image/button_delete.gif","Bt_dellinkMan_id","18","18",linkMan.id,"button_del_linkMan"); 
    	var span = document.createElement('span');
    	span.appendChild(delImg);
    	return span.innerHTML;
    } 
];

