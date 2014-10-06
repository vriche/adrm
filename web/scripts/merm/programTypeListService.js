var ctxPath;
var proProgramType = new ProProgramType();

callOnLoad(init);


function init(){
		ctxPath = $F("ctxPath");
		proProgramType.getProgramTypesXML($("programTypeDiv"),"proType","108");
		setProgarmTypePara(proProgramType);
//		resetHeigth();
		getProgarmTypeTree(proProgramType);
		getProgarmTypeTable();
        initGrid();
        initToolbar();
}

function setProgarmTypePara(obj){
	
	 obj.className  = "proProgramType";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 	= new Tree(obj.treebox); 
	
	 obj.checkBoxName = obj.className +"Check";
	 obj.color1 		= "BACKGROUND-COLOR: white";
	 obj.color2 		= "BACKGROUND-COLOR: #eee";
	 obj.enableEdit	= true;
	 obj.enableDel	= true;	 
     obj.selectName ="proType";
}

function resetHeigth(){
   	var dialogcontent = $("dialogcontentDiv");
    var treebox = $("proProgramTypeTreebox");
    treebox.style.height = dialogcontent.offsetHeight -(dialogcontent.offsetTop - treebox.offsetTop) - v +"px";	
    
}
	
function initGrid(){
		var imagePath = ctxPath + "image/grid/";
		mygrid = new dhtmlXGridObject('gridbox');
		mygrid.setImagePath(imagePath);
		mygrid.setHeader("类别ID,节目类别名,显示顺序");
		mygrid.setInitWidthsP("30,30,40")
		mygrid.setColAlign("left,right,right")
		mygrid.setColTypes("ro,ed,ed");
		mygrid.setColSorting("str,int,str")
		mygrid.enableMultiselect(true)
		mygrid.init();
//		mygrid.loadXML("sampleData/programType_grid.xml");
		
		mygrid.setSkin("modern2");
		mygrid.enableAlterCss("even","uneven");
		mygrid.setOnRowDblClickedHandler(rowDblClick);
}

function rowDblClick(id){
	
	$("programTypeId").value = id;
	     showTreeMenu(false);
	     
	     function func(objs){
		 	
		 		$("programTypeName").value = objs.name;
		 		$("displayNo").value = objs.displayNo;
		 		$("proType").value = objs.parentId;
		 		

   				    }
   				    
		                proProgramType.getProProgramTypeById(id,func);
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

function getProgarmTypeTree(obj){

	obj_tree = obj.tree.dhtmlTree;
	obj_tree.enableCheckBoxes(false);
	obj_tree.enableItemEditor(false);
	obj_tree.enableDragAndDrop(true);
	obj_tree.setOnClickHandler(doOnSelectGetRes);
	var imagePath = ctxPath + "image/tree/";
	obj_tree.setImagePath(imagePath);
//	obj_tree.setDragHandler(doOnBeforeDropMenuTree);
	obj.reset();
	obj.obj.parentId = 0;
	
	var func = function(xml){
				obj_tree.loadXMLString(xml);
		 }
	obj.getTreeXML(func);
	
}
function getProProgramTypeMenu(id){
	var callBackFun = function(obj){
		DWRUtil.setValues(obj);
	}
	proProgramType.getProProgramTypeMenu(id,callBackFun);
}
function doOnSelectGetRes(itemId){
	var selectItemId = proProgramType.tree.getSelectedItemId(proProgramType.IdPrefix);
	var selectedNodeType = proProgramType.tree.dhtmlTree.getLevel(itemId);
	var isLeaf = (proProgramType.tree.dhtmlTree.getSubItems(itemId) == null || proProgramType.tree.dhtmlTree.getSubItems(itemId) == '');
      // alert(">>>   "+selectItemId);
        
    selectItemId = (selectItemId ==-1)?0:selectItemId;
  
    var parentId = proProgramType.tree.dhtmlTree.getParentId(proProgramType.IdPrefix + selectItemId);
    var pid = proProgramType.tree.getIdByPrefix(parentId,proProgramType.IdPrefix);
    var parid = (pid == -1)?0:pid;
    
   // var parid = getid(parentId)==-1?0:getid(parentId);
	proProgramType.reset();
	
	 if(isLeaf){
	 	if(selectItemId ==0){
	 		alert("请添加数据");
	 	}else{
	 		showTreeMenu(false);
	     		rowDblClick(selectItemId);
	 	}
	     
    }else{
    	 if(selectedNodeType == null){
		     
		       $("programTypeParentId").value = 0;
		       getProgarmTypeTable();
		       showTreeMenu(true);
		}
	else{
	  
		        $("programTypeParentId").value  = selectItemId;
				getProgarmTypeTable();
				showTreeMenu(true);       
         	}

	}

}

function AddNew(){
			showTreeMenu(false);
			$("programTypeId").value = null;
			$("programTypeName").value = null;
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
	             var id = $("programTypeId").value;
	  				proProgramType.removeProProgramType(id);
					proProgramType.tree.removeNodeFromTree(id,proProgramType.IdPrefix);
					setTimeout("getProgarmTypeTable()",100);
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
	
	
function getProgarmTypeTable()
	{
		showTreeMenu(true);
		var ids = $("programTypeParentId").value ==""?0:$("programTypeParentId").value;
		 proProgramType.obj.parentId = ids;
	 var func = function(xml){
				mygrid.clearAll();
				mygrid.loadXMLString(xml);
				
		 }
	
		proProgramType.getProgarmTypeTableXML(proProgramType.obj,func);
	}
function isCheck(obj){
	if ($("programTypeName").value ==""){alert("节目名不能为空");return false;}

	return true;
}
function saveProgarmType(){  
		DWRUtil.getValues(proProgramType.obj);
	proProgramType.obj.id = $("programTypeId").value;
	proProgramType.obj.name = $("programTypeName").value;
	proProgramType.obj.displayNo = $("displayNo").value;
	proProgramType.obj.parentId = $("proType").value;
	proProgramType.obj.parentId = (proProgramType.obj.parentId==null||proProgramType.obj.parentId=="")?0:proProgramType.obj.parentId;
		
	var isNew = (proProgramType.obj.id ==""|| proProgramType.obj.id ==null);
	if(isNew) proProgramType.obj.id ==null;
	var func = function(id){
		$("programTypeId").value = id;
		var newItemId = proProgramType.IdPrefix + id;
		var newItemLabel = $("programTypeName").value;
		//alert(id);
		if(isNew){
			insertNewItemToTree(newItemId,newItemLabel);
		}else{
			proProgramType.tree.dhtmlTree.setItemText(newItemId,newItemLabel,"");
		}
			proProgramType.getProgramTypesXML($("programTypeDiv"),"proType","108");
		alert("保存成功");
	}
	
		proProgramType.saveProProgramType(proProgramType.obj,func);

	}
function insertNewItemToTree(newItemId,newItemLabel){//newItemLabel为页面的 名字 项
	var tree = proProgramType.tree.dhtmlTree;
	//alert(newItemId+"    sss   "+newItemLabel);
	
	var pid = $("proType").value == 0?-1:$("proType").value;
	var parentId = proProgramType.IdPrefix + pid;
	
	var nodeType = tree.getUserData(parentId,"programTypeId");
	
	var id = proProgramType.tree.getIdByPrefix(newItemId,proProgramType.IdPrefix);
	
	var img = "book.gif";
	var imgopen = "books_open.gif";
	var imgClose = "books_close.gif";
	var rootId = 0;
	
	proProgramType.tree.insertNewItem(parentId,newItemId,newItemLabel,img,imgopen,imgClose,rootId);
	
	
}

