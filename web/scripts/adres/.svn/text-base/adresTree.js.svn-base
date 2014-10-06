
		//tree object
		var tree;
		//default label for new item
		var newItemLabel = "New Item";
		//id for new (unsaved) item
		var newItemId = "-1";
		var gParentId = "0";
		var gFatherNodeType = "0";
		
		var treeXML;
		
        callOnLoad(init);	

		//动作填充 
		function buttonEventFill(){
			
			//保存载体
			var Bt_saveCarrierInfo = $("Bt_saveCarrierInfo");
			Bt_saveCarrierInfo.onclick=button_saveCarrier;
			//删除载体
			var Bt_removeCarrierInfo = $("Bt_removeCarrierInfo");
			Bt_removeCarrierInfo.onclick=button_removeCarrier;	
			
			//载体增加子级
			var Bt_addCarrierChild = $("Bt_addCarrierChild");
			Bt_addCarrierChild.setAttribute("href","javascript:void 0");
			Bt_addCarrierChild.onclick=button_addCarrierChild;
			
			//保存载体
			var Bt_removeResource = $("Bt_removeResource");
			Bt_removeResource.onclick=button_removeResource;
			//删除载体
			var Bt_saveResource = $("Bt_saveResource");
			Bt_saveResource.onclick=button_saveResource;
				
			//载体增加子级
			var Bt_addResourceChild = $("Bt_addResourceChild");
			Bt_addResourceChild.setAttribute("href","javascript:void 0");
			Bt_addResourceChild.onclick=button_addResourceChild;	
			
			//有效信息增加新行
			var Bt_addNewRowWorkspance = $("Bt_addNewRowWorkspance");
			Bt_addNewRowWorkspance.setAttribute("tarObj","workSpanceBody");
			Bt_addNewRowWorkspance.onclick=button_addTrWorkSpance;
			
			//价格信息增加新行
			var Bt_addNewPrice = $("Bt_addNewPrice");
			Bt_addNewPrice.setAttribute("tarObj","priceDetailBody");
			Bt_addNewPrice.onclick=button_addNewPrice;

		}    
		

       function init(){
       	    preLoadImages();
       	    buttonEventFill();
       	    CarrierManager.getCarriersTypeXml(0,getxml);	
       }
       function getxml(treeXML){ loadTree(treeXML); }  	
       		//load tree on page
	   function loadTree(treeXML){
			tree = new dhtmlXTreeObject("treebox","100%","100%",0);
			tree.setImagePath("image/tree/");
			tree.enableThreeStateCheckboxes(true);
			tree.enableDragAndDrop(true);
			tree.setOnClickHandler(doOnSelect);//set function to call on dbl click
			tree.setDragHandler(doOnBeforeDrop);
			tree.loadXMLString(treeXML);	
		}
		
       
      //为后边提供图片数组
       function preLoadImages(){
			var imSrcAr = new Array("line1.gif","line2.gif","line3.gif","line4.gif","minus2.gif","minus3.gif","minus4.gif","plus2.gif","plus3.gif","plus4.gif","book.gif","books_open.gif","books_close.gif","magazines_open.gif","magazines_close.gif","tombs.gif","tombs_mag.gif","book_titel.gif","iconCheckAll.gif")
			var imAr = new Array(0);
				for(var i=0;i<imSrcAr.length;i++){
					imAr[imAr.length] = new Image();
					imAr[imAr.length-1].src = "image/tree/"+imSrcAr[i]
				}
		}   	

 
         //保存载体
		function button_saveCarrier(){
			DWRUtil.getValues(carrier);
			carrier.id = $("carrierId").value;
			CarrierManager.saveCarrier(carrier,carrierSaveFun);
		}
		function carrierSaveFun(newId){
			if (newId) {
				$("carrierId").value = newId;
				//修改数节点信息
				doUpdateItemCarrier(newId);
			}
		}
 		//删除载体
		function button_removeCarrier(){
			if(tree.getSelectedItemId()!=newItemId){//delete node from db
				if(!confirmDelete('Carrier')) return false;
				var id =$("carrierId").value;			
				CarrierManager.removeCarrier(id);
				doDeleteTreeItem('ca'+id);
			}else{//delete unsaved node
				doDeleteTreeItem(newItemId);
			}	
			DWRUtil.setValues(carrier);	
			
			$("carrierId").value = carrier.id;	
		}
		
        //载体增加子级
		function button_addCarrierChild(){

			if(tree.getLevel(newItemId)!=0){//check if unsaved item already exists
				alert("New Item (unsaved) already exists")
				return false;
			}
			
			var selectedId = tree.getSelectedItemId();
		    var nodeType =  getNodeType(selectedId);
		    
		    //只有选择载体类别和载体，才可以增加
            if(nodeType == 1 || nodeType == 2) {
	            if(selectedId!=""){
	            	DWRUtil.setValues(carrier);	
	            	$("carrierId").value = 0;
					//判断谁是新生儿的父亲
					if(nodeType == 1) var parentId = 0;
					if(nodeType == 2) var parentId =  tree.getUserData(selectedId,"carrierId");
					$("parentId").value = parentId;
					$("carrierName").value = newItemLabel;
					$("carrierTypeId").value = tree.getUserData(selectedId,"carrierTypeId");
					$("carrierBody").show();
					$("resourceBody").hide();

					tree.insertNewItem(selectedId,newItemId,newItemLabel,"","book.gif","books_open.gif","books_close.gif","SELECT,CALL",0);	
					//由于要根据类别，来切换界面
					tree.setUserData(newItemId,"type",2);
//					doOnSelect(newItemId);

				}else{
					alert("请选择被增加的节点");
	//				tree.insertNewItem(0,newItemId,newItemLabel,"","","","","SELECT,CALL",0)
				}
            }
		}
		
		
		function button_addResourceChild(){
			if(tree.getLevel(newItemId)!=0){//check if unsaved item already exists
				alert("New Item (unsaved) already exists")
				return false;
			}
			
			var selectedId = tree.getSelectedItemId();
		    var nodeType =  getNodeType(selectedId);
		    
		    //只有选择载体类别和载体，才可以增加
            if(nodeType == 2 || nodeType == 3|| nodeType == 4) {
	            if(selectedId!=""){
	            	DWRUtil.setValues(resource);	
//	            	$("resourceId").value = resource.id;
	            	$("resourceId").value = -1;
					//判断谁是新生儿的父亲
					if(nodeType == 2||nodeType == 3) var parentId = 0;
					if(nodeType == 4) var parentId =  tree.getUserData(selectedId,"resourceId");
					$("parentId").value = parentId;
					$("resourceName").value = newItemLabel;
					$("carrierId").value = tree.getUserData(selectedId,"carrierId");
					
					tree.insertNewItem(selectedId,newItemId,newItemLabel,"","","","","SELECT,CALL",0);	
					tree.setUserData(newItemId,"type",4);
					$("carrierBody").hide();
					$("resourceBody").show();

					DWRUtil.removeAllRows("workSpanceBody");
					DWRUtil.removeAllRows("priceDetailBody");
				}else{
					alert("请选择被增加的节点");
	//				tree.insertNewItem(0,newItemId,newItemLabel,"","","","","SELECT,CALL",0)
				}
            }			
		}

		
		//保存资源信息
		function button_saveResource(event){
			DWRUtil.getValues(resource);
			resource.id = $("resourceId").value;
			ResourceManager.saveResource(resource,resourceSaveFun);
		}
		
		function resourceSaveFun(newId){
			if (newId>-1) {
				//修改数节点信息
				doUpdateItemResource(newId);
				$("resourceId").value = newId;
				
				//判断有效信息是否处于编辑状态,新添有效信息
				var Btn_SaveWorkSpan = $("Btn_SaveWorkSpan");
				
		        if(!isUndefined(Btn_SaveWorkSpan)){
		        	
		        	if (!checkEndTime())return false;

		        	var tr =Btn_SaveWorkSpan.parentNode.parentNode;
			        var paraId = tr.getAttribute("paraId");
		        	DWRUtil.getValues(workspan);
		        	workspan.id=paraId;
                    WorkspanManager.saveWorkspan(workspan,saveWorkSpanFun);
		        }
		        
		        //判断有价格信息是否处于编辑状态,新添有效信息
		        var Btn_savePrices = $("Btn_savePrices");
		        if(!isUndefined(Btn_savePrices)){
		        	var tr =Btn_savePrices.parentNode.parentNode;
			        var paraId = Btn_savePrices.getAttribute("paraId");
		        	DWRUtil.getValues(price);
		        	price.id=paraId;
		        	price.resource.id = $("resourceId").value;
                    PriceManager.savePrice(price,savePriceFun); 
		        }
	
			}
		}
		
		//删除资源信息
		function button_removeResource(){
			if(tree.getSelectedItemId()!=newItemId){//delete node from db
				if(!confirmDelete('Resource')) return false;
				var id =$("resourceId").value;				
				ResourceManager.removeResource(id);
				doDeleteTreeItem('re'+id);
			}else{//delete unsaved node
				doDeleteTreeItem(newItemId);
			}	
			DWRUtil.setValues(resource);	
			$("resourceId").value = resource.id;				
		}
	 	
		//从数据库读取信息装载载体明细
		function loadResourceDetails(id){
			ResourceManager.getResource(fillResource,id);
		}
		function fillResource(resource){
			DWRUtil.setValues(resource);
			
			$("resourceId").value = resource.id;
			var id = resource.id;
			if(id !=''){
				loadWorkSpances(id);
			   
				loadPrices(id);
			}
		}
		
		//从数据库读取信价格信息
		function loadPrices(id){
			
			PriceManager.getPricesByResourceId(fillPriceTab,id);
		}	   	
		
				

        //修改数节点信息
		function doUpdateItemCarrier(id){
			var newId = 'ca'+ id;
			tree.changeItemId(tree.getSelectedItemId(),newId);
            tree.setUserData(newId,"carrierId",id);
            tree.setUserData(newId,"carrierTypeId",$("carrierTypeId").value);
            tree.setUserData(newId,"type",2);
			tree.setItemText(newId,$("carrierName").value);
			tree.setItemColor(newId,"black","white");
		}	
		
        //修改数节点信息
		function doUpdateItemResource(id){
			var newId = 're'+ id;
			tree.changeItemId(tree.getSelectedItemId(),newId);
			tree.setUserData(newId,"carrierId",id);
            tree.setUserData(newId,"resourceId",id);
            tree.setUserData(newId,"type",4);
			tree.setItemText(newId,$("resourceName").value);
			tree.setItemColor(newId,"black","white");
		}				
		
		//从数据库读取信息装载载体明细
		function loadCarrierDetails(id){
			CarrierManager.getCarrier(fillCarrier,id);
		}
		function fillCarrier(carrierInfo){
			DWRUtil.setValues(carrierInfo);
			$("carrierId").value = carrierInfo.id;
		}
		

		//从数删除节点
		function doDeleteTreeItem(id){
			
			var pId = tree.getParentId(id);
			tree.deleteItem(id);
			if(pId!="0")
				tree.selectItem(pId,true);
				
			DWRUtil.setValues(carrier);	
			$("carrierId").value = 0;
		}
		
		//what to do when item selected
		function doOnSelect(itemId){
            var selectNodeType1 =  getNodeType(itemId);
			if(itemId!=newItemId){
				if(tree.getLevel(newItemId)!=0){
					if(confirm("Do you want to save changes?")){//save changes to new item		
					    var selectNodeType2 =  getNodeType(newItemId);
			            tree.selectItem(newItemId,false);
						if(selectNodeType2 == 2) button_saveCarrier(); 
						if(selectNodeType2 == 4) button_saveResource();
						return;
					}
					tree.deleteItem(newItemId);
				}	
			}else{//set color to new item label
				tree.setItemColor(itemId,"red","pink");
			}
			switchDest(selectNodeType1,itemId);
		}
		

		//save moved (droped) item to db. Cancel drop if save failed or item is new
		function doOnBeforeDrop(id,parentId){
			if(id==newItemId||tree.getLevel(newItemId)!=0){
				   if(id!=newItemId){
				   		if(confirm("Do you want to save changes?")){//save changes to new item
						    var selectNodeType2 =  getNodeType(newItemId);
				            tree.selectItem(newItemId,false);
							if(selectNodeType2 == 2) button_saveCarrier(); 
							if(selectNodeType2 == 4) button_saveResource();
							return;
					}
					tree.deleteItem(newItemId);
				   }
				return false;
				
			}else{
				var selectedNodeType =  getNodeType(id);
				var parentNodeType =  getNodeType(parentId);


	            if(selectedNodeType == 1 && (isUndefined(parentNodeType)|| parentNodeType == 0 || parentNodeType == 1|| parentNodeType == 2|| parentNodeType == 3|| parentNodeType == 4)) return false;
				if(selectedNodeType == 2 && (isUndefined(parentNodeType)|| parentNodeType == 0 || parentNodeType == 3 || parentNodeType == 4)) return false;
				if(selectedNodeType == 4 && (isUndefined(parentNodeType)|| parentNodeType == 0 || parentNodeType == 1 )) return false;
				
				//拖动载体
				gParentId = getRealIdByTreeId(parentId,parentNodeType);
				var selectId = getRealIdByTreeId(id,selectedNodeType);
				gFatherNodeType = parentNodeType;
				
//				alert("selectedNodeType:"+selectedNodeType);
				
				//拖动载体
				if(selectedNodeType == 2){
					CarrierManager.getCarrier(resetCarrier,selectId);					
				}
				//拖动资源
				if(selectedNodeType == 4){
					ResourceManager.getResource(resetResource,selectId);					
				}

				return true;
			}
		}
		
		function resetCarrier(carrierObj){
           DWRUtil.setValues(carrierObj);	
           
			if(gFatherNodeType == 1) {
				 carrierObj.carrierTypeId = gParentId;
				 carrierObj.parentId = 0;
				 $("carrierTypeId").value = gParentId;
				 $("parentId").value = 0;
			}
			if(gFatherNodeType == 2){
				  carrierObj.parentId = gParentId;
				  $("parentId").value = gParentId;
			}
			CarrierManager.saveCarrier(carrierObj);
		}
		
		function resetResource(resourceObj){
            DWRUtil.setValues(resourceObj);	
			if(gFatherNodeType == 2||gFatherNodeType == 3) {
				 resourceObj.carrierId = gParentId;
				 resourceObj.parentId = 0;
				 $("carrierId").value = gParentId;
				 $("parentId").value = 0;
			}
			if(gFatherNodeType == 4){
				  resourceObj.parentId = gParentId;
				  $("parentId").value = gParentId;
			}
			ResourceManager.saveResource(resourceObj);
		}		
		
		
       //根据节点类型切换载体 或广告资源
      function switchDest(nodeType,itemId){
      	    //显示载体信息
      	     if(nodeType == 0||nodeType == 1){
      	     	$("carrierBody").hide();
      	     	$("resourceBody").hide();
      	     }
		      if(nodeType == 2){
		      	    $("carrierBody").show();
		      	    $("resourceBody").hide();
//					$("carrierBody").style.cssText="display:block;";
//					$("resourceBody").style.cssText="display:none;";
					$("resourceId").value = "";
					var carrierId = tree.getUserData(itemId,"carrierId");
					
					loadCarrierDetails(carrierId);
				}
				//显示资源信息
				if(nodeType == 4){
					$("carrierBody").hide();
		      	    $("resourceBody").show();
//					$("carrierBody").style.cssText="display:none;";
//					$("resourceBody").style.cssText="display:block;"; 
					var resourceId = tree.getUserData(itemId,"resourceId");
					loadResourceDetails(resourceId)
				}
      }
	
  function booleanConvert(v){
  	  if(!isUndefined){
  	     if (v == "true") return 1;
		 if (v == "false") return 0;
		 if (v == "") return 0;
  	  }else{
  	  	  return 0;
  	  }
	}	
	
  function getNodeType(itemId){
  	
  	 return tree.getUserData(itemId,"type");
  }	
  
 function getRealIdByTreeId(itemId,nodeType){
  	if(nodeType == 1) return tree.getUserData(itemId,"carrierTypeId");
  	if(nodeType == 2) return tree.getUserData(itemId,"carrierId");  
  	if(nodeType == 4) return tree.getUserData(itemId,"resourceId"); 
  }	

  function loadWorkSpances(resourceId){
  	WorkspanManager.getWorkspansByResourceId(fillWorkSpanceTab,resourceId)
  }
  

  var carrier = 
	{
	id:-1,
    carrierName:"",
    aliasName:"",
    parentId:0,
    nodeLevel:0,
    displayNo:"",
    nodePath:"",
    memo:"",
    enable:1,
    carrierTypeId:0,
    channelId:0,
    mediaOrgId:0,
    createBy:0,
    modifyBy:0
  };
  
  
  var resource = 
	{
    id:-1,
	resourceName:"",
    carrierId:0,
    parentId:0,
    resourceType:0,
    propertiyTime:0,
    proResourceId:0,
    proResourceMemo:"",
    displayNo:0,
    isClosed:0,
    isOverweight:0,
    isValidate:0,
    isSeralized:0,
    modifyBy:0,
    isManual:0,
    enable:0,
    createBy:0,
    modifyBy:0,
    version:0,
    memo:""   
  };
  
    
    var workspan = 
	{
	id:-1,
    carrierId:0,
    resourceId:0,
    beginDate:19991231,
    endDate:19991231,
    broadcastStartTime:null,
    broadcastEndTime:null,
    monLength:0,
    tueLength:0,
    thiLength:0,
    friLength:0,
    wenLength:0,
    satLength:0,
    sunLength:0
  };
  
  
  
  
  var price = 
	{
	id:-1,
    name:0,
    resourceType:0,
    resourcePriceType:0,
    isDefault:0,
    isUseRegular:0,
    resource:resource,
    priceType:{priceTypeName:null}
  };
  
  var priceDetail = 
	{
	id:-1,
    length:0,
    price:0,
    priceId:-1
  };



	////////////////////// /以下是对表格的操作/////////////////////////////////
function fillWorkSpanceTab(workSpances){
    DWRUtil.removeAllRows("workSpanceBody");
	DWRUtil.addRows("workSpanceBody",workSpances,cellFunctionsWorkSpances,
	{  
	  rowCreator:function(options) {  
		    var row = document.createElement("tr");  
		    var rowIndex = options.rowIndex;
//		    row.setAttribute("paraId",options.rowData.id);
            row.setAttribute("id","workSpanceRow"+options.rowData.id);
		    if(rowIndex%2 == 0) { row.style.cssText="BACKGROUND-COLOR: #ECEFF4"}else{row.style.cssText="BACKGROUND-COLOR: #f5f5f5"};
		    return row;  
	  },  
	  
	  cellCreator:function(options) {  
		    var td = document.createElement("td"); 
//		    td.setAttribute("id","workSpanceCellText");
		    return td;  
	  }  

	});
}

var cellFunctionsWorkSpances = [
  	function(workSpances) { return workSpances.beginDate },
 	function(workSpances) { return workSpances.endDate },
 	function(workSpances) { return workSpances.broadcastStartTime },
    function(workSpances) { return workSpances.monLength },
  	function(workSpances) { return workSpances.tueLength },
    function(workSpances) { return workSpances.wenLength },
    function(workSpances) { return workSpances.thiLength },
    function(workSpances) { return workSpances.friLength },
    function(workSpances) { return workSpances.satLength },
    function(workSpances) { return workSpances.sunLength },
    function(workSpances) { 
    	                    var paraId = workSpances.id;
    	                    var editImg = makeImag("image/edit.png","Btn_editWorkSpan","18","18",paraId,button_editWorkSpan);
    	                    editImg.setAttribute("paraId",paraId);
    	                    return editImg;
    						}, 
    function(workSpances) { 
    	                    var paraId = workSpances.id;
    	                    var deleImg = makeImag("image/button_delete.gif","Btn_deleteWorkSpan","18","18",paraId,button_deleWorkSpan);
    	                    deleImg.setAttribute("paraId",paraId);
    	                    return deleImg;
    						} 
];
	 
function fillPriceTab(price){
    DWRUtil.removeAllRows("priceDetailBody");
	DWRUtil.addRows("priceDetailBody",price,cellFunctionsPrices,
	{  
	  rowCreator:function(options) {  
		    var row = document.createElement("tr");  
		    var rowIndex = options.rowIndex;
		    row.setAttribute("paraId",options.rowData.id);
            row.setAttribute("id","pricesRow"+options.rowData.id);
            row.setAttribute("resourcePriceType",options.rowData.resourcePriceType);
            row.setAttribute("isDefault",options.rowData.isDefault);
            row.setAttribute("isUseRegular",options.rowData.isUseRegular);
		    if(rowIndex%2 == 0) { row.style.cssText="BACKGROUND-COLOR: #ECEFF4"}else{row.style.cssText="BACKGROUND-COLOR: #f5f5f5"};
		    return row;  
	  },  
	  
	  cellCreator:function(options) {  
		    var td = document.createElement("td"); 
//		    td.setAttribute("id","workSpanceCellText");
		    return td;  
	  }  

	});
}

var cellFunctionsPrices = [
    function(price) { if(price.isDefault == 1) return "&nbsp&nbsp&nbsp<img src=\"image/tick.png\">"},
    function(price) { return price.name },
  	function(price) { return price.priceType.priceTypeName},
    function(price) { if(price.isUseRegular == 1) return "&nbsp&nbsp&nbsp<img src=\"image/tick.png\">"},
    function(price) { 
//    	var displayPriceDetailLink = $("Btn_displayPriceDetailLink");
//		displayPriceDetailLink.setAttribute("paraId",id);
    	return "<a href='javascript:void 0' id=\"Btn_displayPriceDetailLink\" onclick=\"button_displayPriceDetail(this)\">显 示</a>"
    	
    	},
    function(price) { 
    	                    var paraId = price.id;
    	                    var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",paraId,"button_editPrices");
    	                    editImg.setAttribute("paraId",paraId);
    	                    
    	                    return editImg;
    						}, 
    function(price) { 
    	                    var paraId = price.id;
    	                    var deleImg = makeImagHtml("image/button_delete.gif","Btn_deletePrices","18","18",paraId,"button_delePrices");
    	                    deleImg.setAttribute("paraId",paraId);
    	                    return deleImg;
    						} 
];




	function button_addTrWorkSpance(event) {
		var e = event || window.event;
		var obj = Event.element(e);
		var tarName = obj.getAttribute("tarObj");
		var tr;
        var rows = $(tarName).getElementsByTagName("tr");
        var rowNum = rows.length;
        
        var Btn_SaveWorkSpan = $("Btn_SaveWorkSpan");
                   

        if(!isUndefined(Btn_SaveWorkSpan)){
        	 alert("编辑状态，不能新添.");
        	 return false;
        }

		tr = DWRUtil._addRowInner(cellFunAddRowWorkSpancesEdit,
		{  
		  rowCreator:function(options) {  
			    var row = document.createElement("tr");  
			    var rowIndex = rowNum;
			    if(rowIndex%2 == 0) { row.style.cssText="BACKGROUND-COLOR: #ECEFF4"}else{row.style.cssText="BACKGROUND-COLOR: #f5f5f5"}
			    return row;  
		  },   
		  cellCreator:function(options) {  
			    var td = document.createElement("td");  
			    return td;  
		  }  
	
		});
		
		 tr.setAttribute("paraId",-1);
		$(tarName).appendChild(tr);
	}
	
	var cellFunAddRowWorkSpancesEdit = [
		function() { return makeDateInputTextHmtl("beginDate","anchorWStart",curDate,"button_showdate_input_edit").innerHTML},
		function() { return makeDateInputTextHmtl("endDate","anchorWEnd",curDate,"button_showdate_input_edit").innerHTML},
		function() { return makeInputText("broadcastStartTime","text","")},
		function() { return makeInputText("monLength","text","")},
		function() { return makeInputText("tueLength","text","")},
		function() { return makeInputText("wenLength","text","")},
		function() { return makeInputText("thiLength","text","")},
		function() { return makeInputText("friLength","text","")},
		function() { return makeInputText("satLength","text","")},
		function() { return makeInputText("sunLength","text","")},
		function() { 
    	              var paraId = -1;
    	              var saveImg = makeImagHtml("image/save.png","Btn_SaveWorkSpan","18","18",paraId,"button_saveWorkSpan_edit");
    	              return saveImg;
		           },
		function() { 
    	              var paraId = -1;
    	              var cancImg = makeImagHtml("image/restore.png","Btn_CanlelWorkSpan","18","18",paraId,"button_cannel_edit");
    	              return cancImg;
		           }
	]	
	
	
	
	
	
	
	
	function button_addNewPrice(event) {
		var e = event || window.event;
		var obj = Event.element(e);
		var tarName = obj.getAttribute("tarObj");
		var tr;
        var rows = $(tarName).getElementsByTagName("tr");
        var rowNum = rows.length;
        
        var Btn_savePrices = $("Btn_savePrices");
                   

        if(!isUndefined(Btn_savePrices)){
        	 alert("编辑状态，不能新添.");
        	 return false;
        }

		tr = DWRUtil._addRowInner(cellFunAddRowPriceEdit,
		{  
		  rowCreator:function(options) {  
			    var row = document.createElement("tr");  
			    var rowIndex = rowNum;
			    if(rowIndex%2 == 0) { row.style.cssText="BACKGROUND-COLOR: #ECEFF4"}else{row.style.cssText="BACKGROUND-COLOR: #f5f5f5"}
			    return row;  
		  },   
		  cellCreator:function(options) {  
			    var td = document.createElement("td");  
			    return td;  
		  }  
	
		});
		
		 tr.setAttribute("paraId",-1);
		$(tarName).appendChild(tr);
		
		$("name").value = $("resourceName").value;
		
//		 $("resourcePriceType").value = resourcePriceType;
	}	
	


	var cellFunAddRowPriceEdit = [
		function() { return makeInputText("isDefault","checkbox","")},
		function() {
			 return makeInputText("name","text","")
			 
			 },
		function() { return $("resourcePriceType")},
		function() { return makeInputText("isUseRegular","checkbox","")},
		function() { return ""},
		function() { 
    	              var paraId = -1;
    	              var saveImg = makeImagHtml("image/save.png","Btn_savePrices","18","18",paraId,"Btn_Price_edit");
//    	              alert(paraId);
//    	              saveImg.setAttribute("paraId",paraId);
    	              return saveImg;
		           },
		function() { 
    	              var paraId = -1;
    	              var cancImg = makeImagHtml("image/restore.png","Btn_cannelPrices","18","18",paraId,"Btn_Price_cannel");
    	              return cancImg;
		           }
	]		
	
	function Btn_Price_edit(obj){

        
		var tr = obj.parentNode.parentNode;
        var rowIndex = tr.rowIndex;
        var paraId = tr.getAttribute("paraId");
        
// 		var Btn_savePrices = $("Btn_savePrices");
// 		alert(paraId);
 
		price.id = paraId;
		DWRUtil.getValues(price);	
//		$("hiddenArea").appendChild($("resourcePriceType"));
		price.resource.id = $("resourceId").value;
//		alert(price.resource.id);
		PriceManager.savePrice(price,savePriceFun);
	
	}
	function savePriceFun(priceId){
//		alert(priceId) ;
		$("pricesId").value = priceId;
		$("hiddenArea").appendChild($("resourcePriceType"));
		loadPrices($("resourceId").value);
	}
	
	function button_delePrices(obj){
		var s =  checkPriceEeitStates();
	    if (!s) return false;
 
	    if (!confirmDelete('Price'))  return false;
		var priceId = obj.getAttribute("paraId");

		PriceManager.removePrice(priceId,removePriceFun);
	}
	function removePriceFun(){
		var resourceId = $("resourceId").value;
		loadPrices(resourceId);		
	}
	
	function Btn_Price_cannel(){
		$("hiddenArea").appendChild($("resourcePriceType"));
		loadPrices($("resourceId").value);	
	}	

    //增加表格
	function button_addTr(event) {
		var e = event || window.event;
		var obj = Event.element(e);
		var tarName = obj.getAttribute("tarObj");
		var sTr = $(tarName).getElementsByTagName("tr")[0];
		var tr =  sTr.cloneNode(true);
		$(tarName).appendChild(tr);
		
	}
	//取消表格编辑
	function button_cannel_remove(event) {
		var e = event || window.event;
		var obj = Event.element(e);
		var tr = obj.parentNode.parentNode;
		tr.remove();
	}	
	function button_cannel_edit(obj) {
		saveWorkSpanFun();
//		var tr = obj.parentNode.parentNode;
//		var inputs = tr.getElementsByTagName("input");
//		var cells = tr.getElementsByTagName("td");
//		
//
//		for (var i=0;i<inputs.length-2;i++){
//			cells[i].innerHTML = inputs[i].value;
//			inputs[i].remove();
//		}

	}	
	
	//保存表格
	function button_saveWorkSpan(event) {
		var e = event || window.event;
		var obj = Event.element(e);
        if (!checkEndTime())return false;
		if($("resourceId").value ==-1){
            DWRUtil.getValues(resource);
			resource.id = $("resourceId").value;
			ResourceManager.saveResource(resource,resourceSaveFun);
		}else{
	        DWRUtil.getValues(workspan);
	        workspan.id=-1;
	        WorkspanManager.saveWorkspan(workspan,saveWorkSpanFun);			
		}
	}	
	
	function button_saveWorkSpan_edit(obj) {
        DWRUtil.getValues(workspan);
        var tr = obj.parentNode.parentNode;
        var rowIndex = tr.rowIndex;
        var paraId = tr.getAttribute("paraId");
        workspan.id=paraId;
        if (!checkEndTime())return false;
        if($("resourceId").value ==-1){
			DWRUtil.getValues(resource);
			resource.id = $("resourceId").value;
			ResourceManager.saveResource(resource,resourceSaveFun);
		}else{
			WorkspanManager.saveWorkspan(workspan,saveWorkSpanFun);
		}    
	}	
	
	function saveWorkSpanFun(){
	
		loadWorkSpances($("resourceId").value);
	}
	
    function button_deleWorkSpan(event){
		   var s =  checkEeitStates();
	       if (!s) return false;
	       if(!confirmDelete('Workspan')) return false;
	       var e = event || window.event;
		   var obj = Event.element(e);	
		   var id = obj.getAttribute("paraId");
		   WorkspanManager.removeWorkspan(id,saveWorkSpanFun);
	}
	
	function checkEeitStates(){
		var Btn_SaveWorkSpan = $("Btn_SaveWorkSpan");
		if(!isUndefined(Btn_SaveWorkSpan)){
	        	 alert("已在编辑状态.");
	        	 return false;
	    }
	    return true;
	}	
	
	function checkPriceEeitStates(){
		var Btn_savePrices = $("Btn_savePrices");
		if(!isUndefined(Btn_savePrices)){
	        	 alert("已在编辑状态.");
	        	 return false;
	    }
	    return true;
	}			
   
	function button_editWorkSpan(event){
		   var s =  checkEeitStates();
	       if (!s) return false;
	       var e = event || window.event;
		   var obj = Event.element(e);	
		   var rows = $("workSpanceBody").getElementsByTagName("tr");
		   var rowNum = rows.length;
		   var id = obj.getAttribute("paraId");
		   var tr1= obj.parentNode.parentNode;
		   var container = document.createElement("span"); 
           
		   var tr2 =  DWRUtil._addRowInner(cellFunAddRowWorkSpancesEdit,
			{  
			  rowCreator:function(options) {  
				    var row = document.createElement("tr");  
				    var rowIndex = rowNum;
//				    if(rowIndex%2 == 0) { row.style.cssText="BACKGROUND-COLOR: #ECEFF4"}else{row.style.cssText="BACKGROUND-COLOR: #f5f5f5"}
                     row.style.cssText = tr1.style.cssText;
				    return row;  
			  },   
			  cellCreator:function(options) {  
				    var td = document.createElement("td");  
				    return td;  
			  }  
			}
		   );
			
		   var inputs = tr2.getElementsByTagName("input");
		   var cells = tr1.getElementsByTagName("td");

			for (var i=0;i<cells.length-2;i++){
				inputs[i].setAttribute("value",cells[i].innerHTML);
			}

            tr2.setAttribute("id","workSpanceRow"+id);
            tr2.setAttribute("paraId",id);
			container.appendChild(tr2);
			new Insertion.After($("workSpanceRow"+id),container.innerHTML);
			tr1.remove();
	}
	
	
	
	
  function checkEndTime(){
  	
  	var save = $("Btn_SaveWorkSpan");
  	var rows = $("workSpanceBody").getElementsByTagName("tr");
  	var tr = save.parentNode.parentNode;
  	var rowNum = rows.length;
  	var curRowIndex = tr.rowIndex;
  	//扫描的列
  	var scanCol = 2;
  	var curRowStartTime = $("beginDate").value;
  	var curRowEndTime = $("endDate").value;
  	
  	for(var i=0;i<rowNum;i++){
  		
  	    var cells = rows[i].getElementsByTagName("td");
  		var endTime = cells[scanCol-1].innerHTML;
  		var startTime = cells[scanCol-2].innerHTML;
  		
  	    //当前行
  		if(curRowEndTime*1 < curRowStartTime*1){
  			alert("开始日期不能大于结束日期");
  			return false
  		}
 
         //当前行之前
         if(i < (curRowIndex-2) ){
	  			if(curRowStartTime*1 <= endTime*1){
	  				 alert("开始日期必须大于第[ " + (i*1+1)+ " ]行的结束日期");
	  				 return false
	  		    }            	
         }
         
   		//当前行之后
  		if( i > (curRowIndex-2) ){
  				 if(curRowEndTime*1 > startTime*1){
  				 alert("结束日期必须小于第[ " + (i*1+1)+ " ]行的开始日期");
  				 return false
  				}
  		}        

  	}

  	return true;

  }
  
            
  //价格信息处理
	function button_editPrices(obj){
		  //检测是否处于编辑状态
		   var s =  checkPriceEeitStates();
	       if (!s) return false;

		   var rows = $("priceDetailBody").getElementsByTagName("tr");
		   var rowNum = rows.length;
		   var id = obj.getAttribute("paraId");
		   var tr1= obj.parentNode.parentNode;
		   var resourcePriceType = tr1.getAttribute("resourcePriceType");
		   var isDefault = tr1.getAttribute("isDefault");
		   var isUseRegular = tr1.getAttribute("isUseRegular");
//		   $("resourcePriceType").value = resourcePriceType;
		   var resPriceType = $("resourcePriceType");
		  
		   $("pricesId").value = id;
		   
		   //如果价格明细存在，则删除
			button_hidenPriceDetail() ; 
		   


		   var container = document.createElement("span"); 
           
		   var tr2 =  DWRUtil._addRowInner(cellFunAddRowPriceEdit,
			{  
			  rowCreator:function(options) {  
				    var row = document.createElement("tr");  
				    var rowIndex = rowNum;
                     row.style.cssText = tr1.style.cssText;
				    return row;  
			  },   
			  cellCreator:function(options) {  
				    var td = document.createElement("td");  
				    return td;  
			  }  
			}
		   );
		   
		   var inputs = tr2.getElementsByTagName("input");
		   var tr2Cell = tr2.getElementsByTagName("td");
		   var cells = tr1.getElementsByTagName("td");

			for (var i=0;i<cells.length-3;i++){
				if(i == 0){
				  inputs[i].setAttribute("value",isDefault);
				  if(isDefault == 1) inputs[i].setAttribute("checked",true);
				}
				if(i == 1) inputs[i].setAttribute("value",cells[i].innerHTML);
				if(i == 2){
//					 $("resourcePriceType").remove();
//					 cells[i].Text = "";
//					alert(cells[i]);
//					alert(cells[i].innerHTML);
//					 cells[i].appendChild("<a>ddd</a>");
//                     Position.clone('resourcePriceType','aaaaa');
//					 resourcePriceType.value = resourcePriceType;
//					var Str = $("resourcePriceType");
//					$("resourcePriceType").value = resourcePriceType;
//					var selectBox =  Str.cloneNode(true);
//					selectBox.selectIndex = resourcePriceType;
//					selectBox.value = resourcePriceType;
//                    alert(resourcePriceType);
//                    Str.value = resourcePriceType;
//                    Str.selectIndex = resourcePriceType;
//                    Str.index = resourcePriceType;
//                    tr2Cell[i].appendChild(Str);

				}
				if(i == 3){
					 inputs[i-1].setAttribute("value",isUseRegular);
				     if(isUseRegular == 1) inputs[i-1].setAttribute("checked",true);
				}
			}
			

            tr2.setAttribute("id","pricesRow"+id);
            tr2.setAttribute("paraId",id);
			container.appendChild(tr2);
			new Insertion.After($("pricesRow"+id),container.innerHTML);
			tr1.remove();
			
			 $("resourcePriceType").value = resourcePriceType;
			 var saveImg = $("Btn_savePrices");
			 saveImg.setAttribute("paraId",id);
	
	}
	
function button_hidenPriceDetail(){
	
	    var hidenLink = $("Btn_hidenPriceDetailLink");	 
// 	    alert(hidenLink);
 	    if(!isUndefined(hidenLink)){
// 	    	alert(1);
 		  	var displayLink = "<a href='javascript:void 0' id=\"Btn_displayPriceDetailLink\" onclick=\"button_displayPriceDetail(this)\">显 示</a>";
			hidenLink.parentNode.innerHTML = displayLink;		    	
 	    }
 	    
	
 	    var priceDetail_row = $("priceDetail_row");
 	    if(!isUndefined(priceDetail_row)){
//  	    	priceDetail_row.remove();
            $("priceDetail_row").remove();
//  	    	$("priceDetail_row_cell").remove();	
 	    }	

}
	
function button_displayPriceDetail(obj){
		var tr = obj.parentNode.parentNode;
        var rowIndex = tr.rowIndex;
        var id = tr.getAttribute("paraId");
        $("pricesId").value = id;
        
	    button_hidenPriceDetail();  
	    
	    var hidenLink = "<a href='javascript:void 0' id=\"Btn_hidenPriceDetailLink\" onclick=\"button_hidenPriceDetail(this)\">隐 藏</a>";
	    obj.parentNode.innerHTML = hidenLink;

        var container = document.createElement("span"); 
        
 	    var tr2 =   document.createElement("tr"); 
 	    var td2 =   document.createElement("td"); 
 	    tr2.setAttribute("id","priceDetail_row"); 
        td2.setAttribute("id","priceDetail_row_cell"); 
        td2.setAttribute("colspan","7"); 
        td2.setAttribute("align","right"); 
        td2.setAttribute("width","100%"); 
        tr2.style.cssText = tr.style.cssText
        tr2.appendChild(td2);
        container.appendChild(tr2);	 
           
        new Insertion.After($("pricesRow"+id),container.innerHTML); 	    
  
        loadPrice_Details(id);
        

}

function loadPrice_Details(priceId){
	 PriceManager.getPriceDetailByPriceId(fillPriceDetailTab,priceId);
}



function fillPriceDetailTab(data){
	    var cont = document.createElement("span");
	    var priceDetail_row_cell = $("priceDetail_row_cell");
	    
	    var priceDetail_row_tab_4 = $("priceDetail_row_tab_4");
	    if(!isUndefined(priceDetail_row_tab_4)){
	    	priceDetail_row_tab_4.remove();
	    }
	    
	    
	    var tb = document.createElement("table"); 
	    var tr1 = document.createElement("tr");
	    var tr2 = document.createElement("tr");
	    var tr3 = document.createElement("tr");
	    var tr4 = document.createElement("tr");
	    tb.setAttribute("id","priceDetail_row_tab_4"); 
	    tb.setAttribute("width","90%"); 
//	    tb.setAttribute("border","1");
	    tb.setAttribute("class","FieldLabl1");
	    tr1.setAttribute("class","FieldLabl1");
	    tr2.setAttribute("class","FieldLable2");
	    tr3.setAttribute("class","FieldLable2");
	    tr4.setAttribute("class","FieldLable2");


        var cell1 =  makeInputTextTd("priceDetailId","hidden","10px","");
        var cell2 =  makeInputTextTd("priceDetailLength","text","5","");
        var cell3 =  makeInputTextTd("priceDetailPrice","text","5","");
        var cell4 = makeInputButtonTd("add_price_detail","button","10px","新添","add_price_detail_fun");
        var cell5 = makeInputButtonTd("mod_price_detail","button","10px","修改","mod_price_detail_fun");
        
	    var size = data.length;
	    for (var i = 0;i<size;i++){
	    	priceDetail = data[i];
	    	var leng =   makeTh(priceDetail.length);
	    	leng.setAttribute("id","priceDetail_length" + priceDetail.id);
	    	leng.setAttribute("value",priceDetail.length);
	    	leng.setAttribute("width","5px");
			var price =  makeTextTd(priceDetail.price);
			price.setAttribute("id","priceDetail_price"+priceDetail.id);
			price.setAttribute("value",priceDetail.price);
		    var editImg = makeImagHtml("image/edit.png","Btn_editPriceDetail_ID","18","18",priceDetail.id,"button_priceDetail_edit"); 
            var deleteImg = makeImagHtml("image/button_delete.gif","Btn_deletePriceDetail_ID","18","18",priceDetail.id,"button_priceDetail_delete"); 
	    	tr1.appendChild(leng);
	    	tr2.appendChild(price);	
	    	var tddo = document.createElement("td");
	    	tddo.appendChild(editImg);tddo.appendChild(deleteImg);
	    	tr3.appendChild(tddo);
	    }
       
       var td = document.createElement("td");
       td.setAttribute("colspan",size*1+1);
       td.setAttribute("align","right");
       td.innerHTML =    cell1.innerHTML + "长度:"+ cell2.innerHTML + "价格:"+ cell3.innerHTML + cell4.innerHTML+ cell5.innerHTML
       tr4.appendChild(td);

       tb.appendChild(tr1);
       tb.appendChild(tr2);
       tb.appendChild(tr3);
       tb.appendChild(tr4);
       priceDetail_row_cell.appendChild(tb);
}	

function button_priceDetail_edit(obj){
    var id = obj.getAttribute("paraId");	
	$("priceDetailId").value = id;
	$("priceDetailLength").value = $("priceDetail_length"+id).getAttribute("value");
	$("priceDetailPrice").value = $("priceDetail_price"+id).getAttribute("value");
}

function add_price_detail_fun(obj){
	priceDetail.priceId = $("pricesId").value;
	priceDetail.id = -1;
	priceDetail.length = $("priceDetailLength").value;
	priceDetail.price = $("priceDetailPrice").value;
	PriceDetailManager.savePriceDetail(priceDetail,savePriceDetailFun);
	
}
function mod_price_detail_fun(obj){
	priceDetail.id = $("priceDetailId").value;
	if(priceDetail.id == '') return false;
	priceDetail.length = $("priceDetailLength").value;
	priceDetail.price = $("priceDetailPrice").value;	
	PriceDetailManager.savePriceDetail(priceDetail,savePriceDetailFun);
}

function button_priceDetail_delete(obj){
	 if (!confirmDelete('PriceDetail')) return false;
	 var id = obj.getAttribute("paraId");
	 PriceDetailManager.removePriceDetail(id,savePriceDetailFun);
}

function savePriceDetailFun(){
	var pricesId = $("pricesId").value
	loadPrice_Details(pricesId);
//	alert("ok");
	
}
