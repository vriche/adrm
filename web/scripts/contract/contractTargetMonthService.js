
var contractTargetMonth = new ContractTargetMonth();

var targetId = 0;

callOnLoad(init);

function init(){
	setContractTargetMonthPara(contractTargetMonth);
	
	var url = window.location.href;
	var startPos = url.indexOf("=");
	var endPos = url.length;

    targetId = url.substring(startPos+1,endPos)*1;
	getResultInfo();
} 

function setContractTargetMonthPara(obj){
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
	 obj.className  = "contractTargetMonth";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.fillObjName = obj.className + "Body";
	 obj.tableName =  "contractTargetMonthList";
	 obj.tBody 		= $(obj.fillObjName);
	 obj.color1 		= "BACKGROUND-COLOR: #f5f5f5";
	 obj.color2 		= "BACKGROUND-COLOR: #ECEFF4";
	 obj.pageInfo 	= "pageInfo" + obj.className;
	 obj.pageSize 	= "12";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);
}

function getResultInfo(){

	 var func = function(objs){
	 	contractTargetMonth.fillTalbe(objs);
	 }
	 contractTargetMonth.reset();
	 contractTargetMonth.obj.contractTargetId = targetId;
	 contractTargetMonth.getContractTargetMonths(contractTargetMonth.obj,func);
}

function button_add_new_obj(type){
	if(type == 0){
		contractTargetMonth.addNewRow('new',null);
	}
}

function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == contractTargetMonth.pageInfo){
		var page = new Page(contractTargetMonth.pageInfo,contractTargetMonth.pageSize);
		page.goNextPage(pageIndex);
		contractTargetMonth.page = page;
		getResultInfo();
	}
}
function saveContractTargetMonth(event){
		var e = event || window.event;
		var saveImgTd = Event.element(e);		
		var mode = saveImgTd.getAttribute("mode");
		var contractTargetMonthId = saveImgTd.getAttribute("paraId");
		
		contractTargetMonth.obj.id = contractTargetMonthId;
		
		contractTargetMonth.obj.contractTargetId = targetId;
		contractTargetMonth.saveContractTargetMonth(contractTargetMonth.obj,mode);
		
		getResultInfo();
}

function cannelContractTargetMonth(){
	$("hiddenArea").appendChild($("monthDate"));
	$("hiddenArea").appendChild($("yearDate"));
	getResultInfo();
}