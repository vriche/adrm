
		//////////////////tree object//////////////////////
		var tree;
		//default label for new item
		var newItemLabel = "New Item";
		//id for new (unsaved) item
		var newItemId = "-1";
		var gParentId = "0";
		var gFatherNodeType = "0";
		var treeXML;
		
		
		
		/////////////////grid//////////////////////////
		var mygrid;
		var timeoutHnd;
		var flAuto = false;
		var gridXML;
//		
//		gridXML ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>";
//		gridXML +="<rows>";
//    	gridXML +="<row id=\"1\">";
//		gridXML +="<cell>-1500</cell>";
//		gridXML +="<cell>A Time to Kill</cell>";
//		gridXML +="<cell>John Grisham</cell>";
//		gridXML +="<cell>12.99</cell>";
//		gridXML +="<cell>1</cell>";
//		gridXML +="<cell>24</cell>";
//		gridXML +="<cell>0</cell>";
//		gridXML +="<cell>05/01/1998</cell>";
//	    gridXML +="</row>";
//        gridXML +="</rows>";
//		
		
        callOnLoad(init);	

		//动作填充 
		function buttonEventFill(){
			//保存载体
			var Btn_build_bro = $("Btn_build_bro");
			Btn_build_bro.onclick=button_build_bro;
			
			var Btn_save_bro = $("Btn_save_bro");
			Btn_save_bro.onclick=removePublishInfo;
			
			var Btn_print_bro = $("Btn_print_bro");
			Btn_print_bro.onclick=button_print_bro;

			var Btn_preView_bro = $("Btn_preView_bro");
			Btn_preView_bro.onclick=button_preView_bro;
						


		}    
		

       function init(){
//       	    Element.show('progressMsg');
       	    $("bro_date").value = curDate;

       	    preLoadImages();
       	    buttonEventFill();
       	    CarrierManager.getCarriersTypeXml(0,getxml);
       	    initGrid();
       }
       
       function getxml(treeXML){ loadTree(treeXML); }  	
       
       function getGridXML(gridXML){ 
       	 if(gridXML !=''&&!isUndefined(gridXML)) {
//       	 	alert(gridXML);
       	 	loadGrid(gridXML); 
       	 }else{
       	 	 mygrid.clearAll();
       	 	alert("这一天无相关的广告数据!");
       	 }
       	}  

       //load tree on page
	   function loadTree(treeXML){
			tree = new dhtmlXTreeObject("treebox","100%","100%",0);
			tree.setImagePath("image/tree/");
			tree.enableCheckBoxes(true);
			tree.setSubChecked(0,true);
			tree.enableThreeStateCheckboxes(true);
			tree.setOnClickHandler(doOnSelect);//set function to call on dbl click
			tree.loadXMLString(treeXML);	
		}
		
	  function initGrid(){

			mygrid = new dhtmlXGridObject('gridbox');
			mygrid.selMultiRows = true;
			mygrid.setImagePath("image/grid/");
			var flds = "序号,磁带号,广告名称,版本,长度,指定,订单号,业务员";
			mygrid.setHeader(flds);
//			mygrid.setStyle('Header','ListShort','','');
			mygrid.setInitWidths("50,150,210,200,80,80,100,80")
//            mygrid.enableColumnAutoSize(true);

            mygrid.enableLightMouseNavigation(true);
			mygrid.setColAlign("center,left,left,left,left,left,left,left")
			mygrid.setColTypes("ed,ed,ed,ed,ed,ed,link,ed");
            mygrid.setColTypes("ro,ro,ro,ro,ro,ro,ro,ro");
		    mygrid.setMultiLine(false);
//			mygrid.enableDragAndDrop(true);
			mygrid.setOnGridReconstructedHandler(setRow_style);
			mygrid.setDragBehavior("complex")
//			mygrid.setDropHandler(doOnDropIn);
//			mygrid.setDropHandler(doOnDropIn)
//			mygrid.setDragInHandler(doOnBeforeDrop);
//			mygrid.setOnRowSelectHandler(doOnBeforeDrop);

			mygrid.init();	  	
	  }
	  
	  function doOnDropIn(id,parentId){

//	  	alert(id);	alert(parentId);
	  	var curResourceId = mygrid.getUserData(id,"rowNum");
	  	var targResourceId = mygrid.getUserData(parentId,"rowNum");
	  	
//	  	alert(curResourceId);	alert(targResourceId);
	  	
//	  	//获得总结行的ID 通过 类型和资源编号
//	  	var type ="0";
//	  	var curSumRowId = getSumRowId(type,curResourceId);
//	  
//	  	var totalTimes = mygrid.getUserData(curSumRowId,"totalTimes");
//	  	var totalUsed = mygrid.getUserData(curSumRowId,"usedTimes");
//        var leaveTimes = mygrid.getUserData(curSumRowId,"leaveTimes");
//	  	
//	  	resetSumRow(curSumRowId,totalTimes,totalUsed);
//	  	
//	  	//如果不在同一资源里调整广告，必须也要修改目标行的广告时间
//	  	if(curResourceId != parentResourceId){
//	  		var targSumRowId = getSumRowId(type,targResourceId);
//	  		var totalUsed = mygrid.getUserData(targSumRowId,"usedTimes");
//            var leaveTimes = mygrid.getUserData(targSumRowId,"leaveTimes");
//	  		resetSumRow(targSumRowId,totalTimes,totalUsed);
//	  	}
	  	
	  }
	  
	function getSumRowId(type,curResourceId){
		var RowsNum = mygrid.getRowsNum();
		var range = $R(0, RowsNum, true);
		
		range.each(function(value, index){
				 var id = mygrid.getRowId(value);
				 var rsid = mygrid.getUserData(id,'resourceId');
				 var type = mygrid.getUserData(id,'type');
				 if(curResourceId == rsid || type =="0"){
				 	 return id;
				 }
			  }
		);			
		
	}
	  
	  
	  
	  function doOnBeforeDrop(id,parentId) {
	  	    //总结行不能调整
	  	    var type = mygrid.getUserData(id,'type');
//           alert(type);
	  	    if(type =="-1" || type =="0"){
//	  	    	 alert(type);
//	  	    	 mygrid.lockRow(id,ture);
//	  	    	 mygrid.editStop();
	  	    	 mygrid.dragAndDropOff = true;
//                 mygrid.setOnCheckHandler()
	  	    	 return false;
	  	    }
	  	 
//	  	    //有指定的不能调整
//			var appPositionCur = mygrid.getUserData(id,'appPosition');
////			alert("appPositionCur"+appPositionCur);
//			if(appPositionCur !='null')return false;
//			
//			var appPositionTarg = mygrid.getUserData(parentId,'appPosition');
////			alert("appPositionTarg"+appPositionTarg);
//			if(appPositionTarg !='null')return false;
//			
//			return true;
	  } 
	  
	  
		//what to do when item selected
		function doOnSelect(itemId){
//			alert(itemId);
//			alert(selectNodeType);
            var selectNodeType =  getNodeType(itemId);
            var checked = tree.isItemChecked(itemId);
            if(selectNodeType == 4 && checked) {
//            	   tree.setItemColor(itemId,"red","pink")
                    var resourceIds = getRealIdByTreeId(itemId,selectNodeType) +",";
//                    alert(resourceIds);
					var dateStr = $("bro_date").value;
					gridXML = '';
					PublishedInfoManager.getPublishedInfosByResourceIdsXML(resourceIds,dateStr,0,getGridXML);
			}

		}	  
	  
	  
	  
	  
	  function loadGrid(gridXML){
//		    mygrid.loadXML("loadGrid.php?un="+Date.parse(new Date()));
//	        mygrid.loadXML("grid.xml",setRow_style);	
//          alert(gridXML);
            mygrid.clearAll();
//            mygrid.setOnLoadingStart(showLoading)
//            alert(gridXML);
            mygrid.loadXMLString(gridXML,setRow_style);
		}	
		
		function reloadGrid(){
			mygrid.clearAll();
			mygrid.loadXML("grid.xml",setRow_style);
//			mygrid.loadXML("respon.jsp",setRow_style);

		}
				
		function showLoading(){
			if(mygrid.setOnLoadingEnd){
                Effect.Fade('progressMsg');
				return;
			}
			Effect.Fade('progressMsg');
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
		
		
   function button_print_bro(){

        var resourceIds = getCheckedresourceIds();
        var publishDate = $("bro_date").value;
        
        var selectId = tree.getSelectedItemId();
        var type = getNodeType(selectId);
//        alert(selectId);  alert(type);
        if (type != 2){
        	alert("请选择载体名称,做为报表的标题.");
        	return false;
        }
        
        if(mygrid.getRowsNum()<2){
        	alert("没有需要打印的数据");
        	return false;
        }

        var carrierName = tree.getSelectedItemText().replace(/ +/g,"");
        
        
        if(resourceIds !='' && publishDate !=''){

	        $("action").value= "print";
	        $("carrierName").value= carrierName;
	        $("resourceIds").value= resourceIds;
	        $("publishDate").value = publishDate;
	        
	        var reportForm = $("ReportForm");
	        reportForm.target = tarForm;
	        reportForm.action="reports/jsp/publish_print.jsp";
//	        reportForm.action="reports/publish.jsp" preView;
	        reportForm.submit();        	
        }

   }
   
   
   function button_preView_bro(event){

     var resourceIds = getCheckedresourceIds();
        var publishDate = $("bro_date").value;
        
        var selectId = tree.getSelectedItemId();
        var type = getNodeType(selectId);
//        alert(selectId);  alert(type);
        if (type != 2){
        	alert("请选择载体名称,做为报表的标题.");
        	return false;
        }
        
        if(mygrid.getRowsNum()<2){
        	alert("没有需要打印的数据");
        	return false;
        }

        var carrierName = tree.getSelectedItemText().replace(/ +/g,"");

        if(resourceIds !='' && publishDate !=''){

	        $("action").value= "preView";
	        $("carrierName").value= carrierName;
	        $("resourceIds").value= resourceIds;
	        $("publishDate").value = publishDate;
	        
	        var reportForm = $("ReportForm");
	        reportForm.target = tarForm;
	        reportForm.action="reports/jsp/publish_preView.jsp";
	        reportForm.submit();        	
        }
   }
		
   function build_bro(count){
		var resourceIds= getCheckedresourceIds();
		var dateStr = $("bro_date").value;
		gridXML = '';
		var model =0;

		if(count>0)	{
				if(confirm("这一天已经编排过，是否重新编排?")){
					model = 0;	
				}else{
					model = 1;	
				}
		}else{
				model = 0;	
		}
		
        PublishedInfoManager.getPublishedInfosByResourceIdsXML(resourceIds,dateStr,model,getGridXML);	
	
	}
	
//建立前先判断是否已经编排过，如果有则提示是否重新编排	
  function button_build_bro(){
		var resourceIds= getCheckedresourceIds();
		var dateStr = $("bro_date").value;
		
		if(resourceIds == ''){
			alert("请选择广告资源!");
			return false;
		}else{
			//建立前先判断是否已经编排过，如果有则提示是否重新编排
			PublishedInfoManager.getPublishedCount(resourceIds,dateStr,build_bro);
		}
	
  }
		
	
	
  function getCheckedresourceIds(){
  	var list = tree.getAllChecked();
  	var resourceIds='';
  	
  	if(list != ''){
  			var ids = list.split(",");
			var size = ids.length;
			for (var i=0;i<size;i++){
				var idStr = ids[i];
				var  intIndex = idStr.search('re');
				if (intIndex > -1){
					 var id = tree.getUserData(idStr,"resourceId");
					 resourceIds += id +",";
				}
			}
			return resourceIds;
  	}else{
  		return '';
  	}
  	
  }
	
	
	
	
	//给行上色
	function setRow_style(){
		var rowCount = mygrid.getRowsNum();
		for (var i=0;i<rowCount;i++){
			var row_id = mygrid.getRowId(i);
			var type = getRowCellData(row_id,0);
			var cssText="";
			if(i%2 == 0) { cssText="BACKGROUND-COLOR: #ECEFF4"}else{cssText="BACKGROUND-COLOR: #f5f5f5"};
//			if(type == "0")  cssText="BACKGROUND-COLOR: #d5f1ff";
            
            //没个段的总结行
			if(type == ''){
				  var leaveTimes = getRowCellData(row_id,5);
				  if (leaveTimes*1 > 0 ) cssText="BACKGROUND-COLOR: #66FF00";
				  if (leaveTimes*1 < 0 ) cssText="BACKGROUND-COLOR: #FFC4D7";
				  if (leaveTimes*1 ==0 ) cssText="BACKGROUND-COLOR: #99CCFF";
			}
			//最后的总结行buttonface D8DFE7
			if(type == "-1"){
				 cssText="BACKGROUND-COLOR: #D8DFE7";
			}			
			mygrid.setRowTextStyle(row_id,cssText);
		}

	}
	
	function resetSumRow(row_id,totalTimes,totalUsed){
		var leaveTimes = totalTimes - totalUsed;
//		alert(totalUsed);alert(leaveTimes);
		resetRowCellData(row_id,4,totalUsed);
		resetRowCellData(row_id,5,leaveTimes);
		
        mygrid.setUserData(row_id,"usedTimes",totalUsed)
        mygrid.setUserData(row_id,"leaveTimes",leaveTimes)
	}
	
	function resetRowCellData(row_id,col,data){
		mygrid.cells(row_id,col).setValue(data);
	}
	
	function getRowCellData(row_id,col){
		return mygrid.cells(row_id,col).getValue();
	}
	
	function countOneResourceUsedTimes(row_id){
		var RowsNum = mygrid.getRowsNum();
		var resourceId = mygrid.getUserData(row_id,"resourceId");
		var range = $R(0, RowsNum, true);
		var usedTimes = 0;
		range.each(function(value, index){
				 var id = mygrid.getRowId(value);
				 var rsid = mygrid.getUserData(id,'resourceId');
				 if(resourceId == rsid && id != row_id){
				 	  usedTimes += mygrid.getUserData(id,'matterLength')*1;
				 }
			  }
		);	
		return usedTimes;
	}
	
	//锁住指定行
	function lockSpecRow(){
		var RowsNum = mygrid.getRowsNum();
		var range = $R(0, RowsNum, true);
		range.each(function(value, index){
				 var row_id = mygrid.getRowId(value);
//				 alert(row_id);
//				 var appPosition = mygrid.getUserData(row_id,'appPosition');
//				 if(!isUndefined(appPosition) && appPosition !='null' && appPosition !=''){
				 	mygrid.lockRow(row_id,true);
//				 }//				alert(appPosition);
//				alert(appPosition =='null');;
			  }
		);
		
	}
	
 function getNodeType(itemId){
  	
  	 return tree.getUserData(itemId,"type");
  }	
  
 function getRealIdByTreeId(itemId,nodeType){
  	if(nodeType == 1) return tree.getUserData(itemId,"carrierTypeId");
  	if(nodeType == 2) return tree.getUserData(itemId,"carrierId");  
  	if(nodeType == 4) return tree.getUserData(itemId,"resourceId"); 
  }		
	
	
	
	var publishedInfo = {
		id:-1,
		publishOrder:0,
		publishDate:19991231,
		orderId:null,
		adverMatterId:null,
		carrierId:null,
		resourceType:null,
		orderDayInfoId:null,
		linkUserId:null,
		customerId:null,
		
		tapeCode:null,
		matterName:null,
		matterEdit:null,
		matterLength:null,
		appPosition:null,
		linkUser:null,
		customerName:null,
		orderCode:null,
		
		adResourceId:null,
		resourceCarrier:null
		
	}

  function removePublishInfo(){
  	var resourceIds= getCheckedresourceIds();
  	var broDate = $("bro_date").value;
  	
 
  	if(resourceIds !=''){
  		PublishedInfoManager.removePublishedInfosByResDate(resourceIds,broDate,savePublishInfo);
  	}


  }	
	
  function savePublishInfo(){
  
  	  	var RowsNum = mygrid.getRowsNum();
		var range = $R(0, RowsNum, true);
		
  		DWREngine.beginBatch(); 		
		
		range.each(function(value, index){
			var row_id = mygrid.getRowId(value);
  			var publish = setGridToObj(row_id);
  			PublishedInfoManager.savePublishedInfo(publish);
  		});	 

  	    DWREngine.endBatch();  

  }

  
  function setGridToObj(row_id){ 
  	    publishedInfo.publishOrder = getRowCellData(row_id,0);
//  	    alert(publishedInfo.publishOrder);
		publishedInfo.publishDate = mygrid.getUserData(row_id,"publishDate");
		publishedInfo.orderId 	   = mygrid.getUserData(row_id,"orderId");
		publishedInfo.adverMatterId = mygrid.getUserData(row_id,"adverMatterId");
		publishedInfo.carrierId = mygrid.getUserData(row_id,"carrierId");
		publishedInfo.resourceType = mygrid.getUserData(row_id,"resourceType");
		publishedInfo.orderDayInfoId = mygrid.getUserData(row_id,"orderDayInfoId");
		publishedInfo.linkUserId = mygrid.getUserData(row_id,"linkUserId");
		publishedInfo.customerId = mygrid.getUserData(row_id,"customerId");
		publishedInfo.tapeCode = mygrid.getUserData(row_id,"tapeCode");
		publishedInfo.matterName = mygrid.getUserData(row_id,"matterName");
		publishedInfo.matterEdit = mygrid.getUserData(row_id,"matterEdit");
		publishedInfo.matterLength = mygrid.getUserData(row_id,"matterLength");
		publishedInfo.appPosition = null2empty(mygrid.getUserData(row_id,"appPosition"));
		publishedInfo.linkUser = mygrid.getUserData(row_id,"linkUser");
		publishedInfo.customerName = mygrid.getUserData(row_id,"customerName");
		publishedInfo.adResourceId = mygrid.getUserData(row_id,"resourceId");
		publishedInfo.resourceCarrier = mygrid.getUserData(row_id,"resourceCarrier");
		publishedInfo.orderCode = mygrid.getUserData(row_id,"orderCode");	

		return publishedInfo;
  }
	
function null2empty(value){
	if (value =='null'){
		 return "";
	}else{
		return value;
	}
	
}
	
	
	
	
	
		
		
		
