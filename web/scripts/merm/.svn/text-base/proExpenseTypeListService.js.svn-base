var ctxPath;
var proProgramType = new ProProgramType();

callOnLoad(init);


function init(){
		ctxPath = $F("ctxPath");
		
		getServiceDate();
	config_serviceDate = $("config_serviceDate").value;
		getProExpenseTypeTable();
        initGrid();
        initToolbar();
}
	
function initGrid(){
		var imagePath = ctxPath + "image/grid/";
		mygrid = new dhtmlXGridObject('gridbox');
		mygrid.setImagePath(imagePath);
		mygrid.setHeader("费用类别名,显示顺序");
		mygrid.setInitWidthsP("50,50")
		mygrid.setColAlign("left,left")
		mygrid.setColTypes("ed,ed");
		mygrid.setColSorting("str,str")
		mygrid.enableMultiselect(true)
		mygrid.init();
//		mygrid.loadXML("sampleData/programType_grid.xml");
		
		mygrid.setSkin("modern2");
		mygrid.enableAlterCss("even","uneven");
		mygrid.setOnRowDblClickedHandler(rowDblClick);
}
 function getServiceDate(){
 	var fuc = function(d){
 		$("config_serviceDate").value = d;
 	}
 	DWREngine.setAsync(false);
 	DateUtil.getServiceDate(fuc);
 	DWREngine.setAsync(true);
 }
function rowDblClick(id){
	
	$("proExpenseTypeId").value = id;
	     showTreeMenu(false);
	     
	     function func(objs){
		 	
		 		$("proExpenseTypeName").value = objs.name;
		 		$("displayNo").value = objs.displayNo;
		 		

   				    }
   				    
		                proProgramType.getProExpenseTypeById(id,func);
}

function initToolbar(){
	        var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml"
			var aToolBar=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo"); 
			var aToolBar2=new dhtmlXToolbarObject("toolbar_zone2","100%","20","Demo"); 
			aToolBar.setOnClickHandler(onButtonClick);	
			aToolBar.loadXML(toolbarDataPath,callBack);
			aToolBar2.setOnClickHandler(onButtonClick);	
			aToolBar2.loadXML(toolbarDataPath,callBack);
		 
		function callBack(){
			aToolBar.hideButtons(); 
	                aToolBar.showButtons("1_new");  
	                aToolBar.showButtons("div_1"); 
	                
	                
	        aToolBar2.hideButtons(); 
	                aToolBar2.showButtons("1_new,2_delete,3_save");  
	                aToolBar2.showButtons("div_1,div_2,div_3"); 
	                
		}
		
		
		    aToolBar.showBar();  
   			aToolBar2.showBar(); 
                                				

}

function AddNew(){
			showTreeMenu(false);
			$("proExpenseTypeId").value = null;
			$("proExpenseTypeName").value = null;
			$("displayNo").value = null;
}
	
function onButtonClick(itemId,itemValue)
	{              
		if(itemId=='1_new') AddNew();
		if(itemId=='2_delete') deleteRow();
		if(itemId=='3_save') saveProgarmType();
	}
	
	
function deleteRow(){
	    Dialog.confirm("请确认是否删除", {className: "alphacube", width:300, height:80,okLabel: "确定",cancelLabel: "取消",
	     onOk:function(win){               
	             Dialog.closeInfo();
	             var id = $("proExpenseTypeId").value;
	  				proProgramType.removeProExpenseType(id);                
	  				setTimeout("getProExpenseTypeTable()",100);
	         }});
	  
	}
	
function showTreeMenu(bln){
	if(bln){
		$("branchList").show();
		$("branchForm").hide();
	}else{
		$("branchList").hide();
		$("branchForm").show();
	}
}
	
	
function getProExpenseTypeTable()
	{
		showTreeMenu(true);

	 var func = function(xml){
				mygrid.clearAll();
				mygrid.loadXMLString(xml);
				
		 }
	
		proProgramType.getProExpenseTypeXML(null,func);
	}
function isCheck(){
	if ($("proExpenseTypeName").value ==""){alert("节目名不能为空");return false;}

	return true;
}
function saveProgarmType(){ 
	proProgramType.obj.id = $("proExpenseTypeId").value;
	proProgramType.obj.name = $("proExpenseTypeName").value;
	proProgramType.obj.displayNo = $("displayNo").value;
	proProgramType.obj.version = config_serviceDate;

	var func = function(id){
		$("proExpenseTypeId").value = id;
		alert("保存成功");
		getProExpenseTypeTable();
	}
	        if(isCheck()){
			proProgramType.saveProExpenseType(proProgramType.obj,func);
		}

	}