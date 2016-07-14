

function OrderDetail(){
	//创建对象
	this.obj ={
		id:null,
		parentId:null,
	    createBy:null,
	    createDate:null,
	    modifyBy:null,
	    modifyDate:null,
	    version:null,
	    
		orderId:null,
		contractId:null,
		orderCategoryMain:null,
	    orderCategoryId:null,
	    carrierId:null,
	    resourceType:null, 
	    resourceSortId:null,
	    resourceInfoId:null,
	    compagesId:null,
	    compages:null,
	    
	    resourceWorkspanId:null,
		resourceSpecificId:null,
		matteType:null,
	    matterId:null,
	    matterLength:null,
    
	    industryTypeId:null,
	    publishMemo:null,
		resourcePriceType:null,
		sysPrice:null,
	    execPrice:null,
    
    	memo:null,
    	isSpaceAdver:null,
    	
	    sumTimes:null,
	    moneyBase:null,
	    appRate:null,
	    ageRate:null,
		favourRate:null,
		moneyBalance:null,
		
	    moneyRealpay:null,
	    moneyIn:null,
	    isCkecked:null,
	    publishStartDate:null,	    
		publishEndDate:null,
	    
	    matterMap:null,
		resourceMap:null,
		carrierMap:null,
		specificMap:null,
		monthInfoMap:null,

		resource:null,
		carrier:null,
		specific:(new Specific()).obj,
		carrier:(new Carrier()).obj,
	
	    matter:null,
	    orderDayInfos:[],
	    isNotInSeries:null,
	    needPublish:null
	}

    this.className = null;
	this.tableName = null;	
	this.tBody = null;
	this.checkBoxName = null;
	this.checkBox =null;
	this.IdPrefix = null;
	this.fillObjName = null;
	this.color1 = null;
	this.color2 = null;
	
	this.pageInfo = null;
	this.pageSize = null;
	this.page = null;
	
	this.enableEdit = false;
	this.enableDel = false;
	this.rowNum = 1;
	this.publishStartDate_bak = null;	    
	this.publishEndDate_bak = null;

	return this;
}


//var authFlt2 = document.getElementById("orderDetail_grid_title_flt").appendChild(document.getElementById("pos_flt_box").childNodes[0]);
//
//attachHeaderNew(grid,"#rspan,<div id='orderDetail_grid_title_flt'></div>,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan,#rspan");


OrderDetail.prototype.replace= function(s){
	var index = s.indexOf("^");
	if(index >-1 ) s = s.substring(0,index);
	return s;
}
OrderDetail.prototype.attachHeaderNew = function(grid,htm){
	var h = htm.split(",");
	var z =  grid.hdr.rows[1];
	for(var cin = 0; cin<h.length;cin++){
		if(h[cin].indexOf("#rspan") != 0) {
			var c = z.cells[z._childIndexes?z._childIndexes[parseInt(cin)]:cin];
			c.innerHTML = h[cin];		
		}

	}
}

OrderDetail.prototype.restHeadComnand = function(detail_mygrid,selObjs,callbak){
        
        var old_values = [];

		for(var k=0;k < selObjs.length;k++){
		
		//		var newHeads = detail_mygrid.flds.split(",");
		        var selObj = selObjs[k];
		        old_values[k] = selObj.value;
		        
		    if(k !=0 && k!=2){
				DWRUtil.removeAllOptions(selObj);
				var opt = new Option('',"0");
				selObj.options.add(opt);				
			}

		}

		var usedAuthAr1 = new dhtmlxArray();
		var usedAuthAr2 = new dhtmlxArray();
		var usedAuthAr3 = new dhtmlxArray();
		var usedAuthAr4 = new dhtmlxArray();
		var usedAuthAr5 = new dhtmlxArray();
		var usedAuthAr6 = new dhtmlxArray();
		var usedAuthAr7 = new dhtmlxArray();
		var usedAuthAr8 = new dhtmlxArray();
		
		for(var i=0;i<detail_mygrid.getRowsNum();i++){
			
			var id = detail_mygrid.getRowId(i);
			
			for(var col = 1;col< selObjs.length+1;col++){
				
				switch(col)
				{
					case 1:
//					    var userDataAttr ='resourceInfoId';
//						var authNm = this.replace(detail_mygrid.cells2(i,col).getValue());
//						var authVal  = (userDataAttr != null)? authVal = detail_mygrid.getUserData(id,userDataAttr):this.replace(detail_mygrid.cells2(i,col).getValue());
//						if(usedAuthAr1._dhx_find(authNm)==-1){
//							selObjs[col-1].options.add(new Option(authNm,authVal));
//							usedAuthAr1[usedAuthAr1.length] = authNm;
//						}
						break;
					case 2:
					    var userDataAttr = null;
						var authNm = this.replace(detail_mygrid.cells2(i,col).getValue());
						var authVal  = (userDataAttr != null)? authVal = detail_mygrid.getUserData(id,userDataAttr):this.replace(detail_mygrid.cells2(i,col).getValue());
						if(usedAuthAr2._dhx_find(authNm)==-1 && authNm !=''){
							selObjs[col-1].options.add(new Option(authNm,authVal));
							usedAuthAr2[usedAuthAr2.length] = authNm;
						}
						break;
					case 3:
//					    var userDataAttr = null;
//						var authNm = this.replace(detail_mygrid.cells2(i,col).getValue());
//						var authVal  = (userDataAttr != null)? authVal = detail_mygrid.getUserData(id,userDataAttr):this.replace(detail_mygrid.cells2(i,col).getValue());
//						if(usedAuthAr3._dhx_find(authNm)==-1 && authNm !=''){
//							selObjs[col-1].options.add(new Option(authNm,authVal));
//							usedAuthAr3[usedAuthAr3.length] = authNm;
//						}
						break;
					case 4:
					    var userDataAttr = null;
						var authNm = this.replace(detail_mygrid.cells2(i,col).getValue());
						var authVal  = (userDataAttr != null)? authVal = detail_mygrid.getUserData(id,userDataAttr):this.replace(detail_mygrid.cells2(i,col).getValue());
						if(usedAuthAr4._dhx_find(authNm)==-1 && authNm !=''){
							selObjs[col-1].options.add(new Option(authNm,authVal));
							usedAuthAr4[usedAuthAr4.length] = authNm;
						}
						break;
						
					case 5:
					    var userDataAttr = null;
						var authNm = this.replace(detail_mygrid.cells2(i,col).getValue());
						var authVal  = (userDataAttr != null)? authVal = detail_mygrid.getUserData(id,userDataAttr):this.replace(detail_mygrid.cells2(i,col).getValue());
//						alert(authNm)
						if(usedAuthAr5._dhx_find(authNm)==-1 && authNm !=''){
							selObjs[col-1].options.add(new Option(authNm,authVal));
							usedAuthAr5[usedAuthAr5.length] = authNm;
						}
						break;
						
					case 6:
					    var userDataAttr = null;
						var authNm = this.replace(detail_mygrid.cells2(i,col).getValue());
						var authVal  = (userDataAttr != null)? authVal = detail_mygrid.getUserData(id,userDataAttr):this.replace(detail_mygrid.cells2(i,col).getValue());
						if(usedAuthAr6._dhx_find(authNm)==-1 && authNm !=''){
							selObjs[col-1].options.add(new Option(authNm,authVal));
							usedAuthAr6[usedAuthAr6.length] = authNm;
						}
						break;						
					case 7:
					    var userDataAttr = null;
						var authNm = this.replace(detail_mygrid.cells2(i,col).getValue());
						var authVal  = (userDataAttr != null)? authVal = detail_mygrid.getUserData(id,userDataAttr):this.replace(detail_mygrid.cells2(i,col).getValue());
						if(usedAuthAr7._dhx_find(authNm)==-1 && authNm !=''){
							selObjs[col-1].options.add(new Option(authNm,authVal));
							usedAuthAr7[usedAuthAr7.length] = authNm;
						}
						break;
						
					case 8:
					    var userDataAttr = null;
						var authNm = this.replace(detail_mygrid.cells2(i,col).getValue());
						var authVal  = (userDataAttr != null)? authVal = detail_mygrid.getUserData(id,userDataAttr):this.replace(detail_mygrid.cells2(i,col).getValue());
						if(usedAuthAr8._dhx_find(authNm)==-1  && authNm !=''){
							selObjs[col-1].options.add(new Option(authNm,authVal));
							usedAuthAr8[usedAuthAr8.length] = authNm;
						}
						break;													
					default:userDataAttr ='';
				}
				
				
			}

		}
		
//  		for(var k=0;k<old_values.length;k++){
//	        var selObj = selObjs[k];
//	        selObj.value = old_values[k];
//	        if(k != 0 && k!=2){
//	        	if(old_values[k] != 0) this.filterBy(detail_mygrid,selObjs);
//	        }else{
//	        	if(old_values[k] != '') this.filterBy(detail_mygrid,selObjs);
//	        }
//	        
//		}      		
				if(callbak) callbak();

}

OrderDetail.prototype.filterBy = function(detail_mygrid,selObjs,callbak){

	    var userDataAttr =null;
		for(var i=0; i< detail_mygrid.getRowsNum();i++){
			var id = detail_mygrid.getRowId(i);
			var isRowHidden  = false;
			for(var col = 1;col<selObjs.length+1;col++){
				var aVal = selObjs[col -1].value;
				var userDataAttr =null;
				if(col != 1 && col != 3){
					if(col == 1) userDataAttr="resourceInfoId";
					
					var aStr = (userDataAttr != null) ? detail_mygrid.getUserData(id,userDataAttr):detail_mygrid.cells2(i,col).getValue().toString();
					
					if(aVal =="0" || aStr == aVal){
						
					}else{
						isRowHidden  = true;
					}	
				}else{
					var aStr = detail_mygrid.cells2(i,col).getValue().toString().toLowerCase();
					if(aVal !='') {
						aVal = aVal.replace(/[ ]/g,""); //替换所有空格
						aStr = aStr.replace(/[ ]/g,""); //替换所有空格
						if(aStr.indexOf(aVal.toLowerCase())==-1){
							isRowHidden  = true;
						}
					}
					
					if(col == 3 && isRowHidden){
						userDataAttr="helpCodeEdit";
						var aStr = (userDataAttr != null) ? detail_mygrid.getUserData(id,userDataAttr):detail_mygrid.cells2(i,col).getValue().toString();
						if(aVal !='') {
							aVal = aVal.replace(/[ ]/g,""); //替换所有空格
							aStr = aStr.replace(/[ ]/g,""); //替换所有空格
							if(aStr.indexOf(aVal.toLowerCase()) > -1){
								isRowHidden  = false;
							}
						}
					}
					
					
				}

				
			}
			
			if(isRowHidden){
				detail_mygrid.setRowHidden(detail_mygrid.getRowId(i),true);
			}else{
				detail_mygrid.setRowHidden(detail_mygrid.getRowId(i),false);
			}
			
			
		}	
		
		
		if(callbak) callbak();
}




OrderDetail.prototype.restHeadComnand1 = function(detail_mygrid,selObjs,callbak){
        
		var old_values = [];

		for(var k=1;k < selObjs.length;k++){
				var selObj = selObjs[k];
				old_values[k] = selObj.value;
				DWRUtil.removeAllOptions(selObj);
				var opt = new Option('',"0");
				selObj.options.add(opt);				
		}

				var selObj = selObjs[0];
				DWRUtil.removeAllOptions(selObj);
				selObj.options.add(new Option('',"-1"));				
				selObj.options.add(new Option('否',"0,1,2,4"));			
				selObj.options.add(new Option('是',"3"));			


		var usedAuthAr0 = new dhtmlxArray();
		var usedAuthAr1 = new dhtmlxArray();
		var usedAuthAr2 = new dhtmlxArray();
		var usedAuthAr3 = new dhtmlxArray();
		var usedAuthAr4 = new dhtmlxArray();
		var usedAuthAr5 = new dhtmlxArray();
		var usedAuthAr6 = new dhtmlxArray();
		var usedAuthAr7 = new dhtmlxArray();
		var usedAuthAr8 = new dhtmlxArray();
		var usedAuthAr9 = new dhtmlxArray();
		var usedAuthAr10 = new dhtmlxArray();
//		var usedAuthAr11 = new dhtmlxArray();
		

		
		for(var i=0;i<detail_mygrid.getRowsNum();i++){
			
			var id = detail_mygrid.getRowId(i);
			
			for(var col = 0;col< selObjs.length+1;col++){
				
				switch(col)
				{
					case 0:
//						var authVal  = detail_mygrid.getUserData(id,"checkState")+'';  
//						var authNm = (authVal =="1")?"是":"否";
//						if(usedAuthAr0._dhx_find(authVal)==-1 && authVal !='-1' ){
//							selObjs[col].options.add(new Option(authNm,authVal));
//							usedAuthAr0[usedAuthAr0.length] = authVal;
//						}
						break;
					case 1:
						var authNm = this.replace(detail_mygrid.cells2(i,col).getValue());
						if(usedAuthAr1._dhx_find(authNm)==-1 && authNm !=''){
							selObjs[col].options.add(new Option(authNm,authNm));
							usedAuthAr1[usedAuthAr1.length] = authNm;
						}
						break;
					case 2:
						var authNm = this.replace(detail_mygrid.cells2(i,col).getValue());
						if(usedAuthAr2._dhx_find(authNm)==-1 && authNm !=''){
							selObjs[col].options.add(new Option(authNm,authNm));
							usedAuthAr2[usedAuthAr2.length] = authNm;
						}
						break;
					case 3:
						var authNm = this.replace(detail_mygrid.cells2(i,col).getValue());
						if(usedAuthAr3._dhx_find(authNm)==-1 && authNm !=''){
							selObjs[col].options.add(new Option(authNm,authNm));
							usedAuthAr3[usedAuthAr3.length] = authNm;
						}
						break;
					case 4:
						var authNm = this.replace(detail_mygrid.cells2(i,col).getValue());
						if(usedAuthAr4._dhx_find(authNm)==-1 && authNm !=''){
							selObjs[col].options.add(new Option(authNm,authNm));
							usedAuthAr4[usedAuthAr4.length] = authNm;
						}
						break;
						
					case 5:
						var authNm = this.replace(detail_mygrid.cells2(i,col).getValue());
						if(usedAuthAr5._dhx_find(authNm)==-1 && authNm !=''){
							selObjs[col].options.add(new Option(authNm,authNm));
							usedAuthAr5[usedAuthAr5.length] = authNm;
						}
						break;
						
					case 6:
						var authNm = this.replace(detail_mygrid.cells2(i,col).getValue());
						if(usedAuthAr6._dhx_find(authNm)==-1 && authNm !=''){
							selObjs[col].options.add(new Option(authNm,authNm));
							usedAuthAr6[usedAuthAr6.length] = authNm;
						}
						break;						
					case 7:
						var authNm = this.replace(detail_mygrid.cells2(i,col).getValue());
						if(usedAuthAr7._dhx_find(authNm)==-1 && authNm !=''){
							selObjs[col].options.add(new Option(authNm,authNm));
							usedAuthAr7[usedAuthAr7.length] = authNm;
						}
						break;
						
					case 8:
						var authNm = this.replace(detail_mygrid.cells2(i,col).getValue());
						if(usedAuthAr8._dhx_find(authNm)==-1 && authNm !=''){
							selObjs[col].options.add(new Option(authNm,authNm));
							usedAuthAr8[usedAuthAr8.length] = authNm;
						}
						break;				
						
					case 9:
						var authNm = this.replace(detail_mygrid.cells2(i,col).getValue());
						if(usedAuthAr9._dhx_find(authNm)==-1 && authNm !=''){
							selObjs[col].options.add(new Option(authNm,authNm));
							usedAuthAr9[usedAuthAr9.length] = authNm;
						}
						break;	
						
												
					case 10:
						var authNm = this.replace(detail_mygrid.cells2(i,col).getValue());
						if(usedAuthAr10._dhx_find(authNm)==-1 && authNm !=''){
							selObjs[col].options.add(new Option(authNm,authNm));
							usedAuthAr10[usedAuthAr10.length] = authNm;
						}
						break;					
						
//					case 11:
//						var authNm = this.replace(detail_mygrid.cells2(i,col).getValue());
//						if(usedAuthAr11._dhx_find(authNm)==-1 && authNm !=''){
//							selObjs[col].options.add(new Option(authNm,authNm));
//							usedAuthAr11[usedAuthAr11.length] = authNm;
//						}
//						break;															
					default:userDataAttr ='';
				}
				
				
			}

		}
		
//  	for(var k=0;k<old_values.length;k++){
//	        var selObj = selObjs[k];
//	        selObj.value = old_values[k];
//	        if(old_values[k] != '0') this.filterBy1(detail_mygrid,selObjs,null);
//		}      		
		
		if(callbak) callbak();
		

}

OrderDetail.prototype.filterBy1 = function(detail_mygrid,selObjs,callbak){

	  var changed = false;
		for(var i=0; i< detail_mygrid.getRowsNum();i++){
			var id = detail_mygrid.getRowId(i);
			var isRowHidden  = false;

							for(var col = 0;col<selObjs.length;col++){
				
//											var aVal = selObjs[col].value;
//											var aStr = (col == 0)?detail_mygrid.getUserData(id,"checkState"):this.replace(detail_mygrid.cells2(i,col).getValue());
											if(col == 0){
												var aVal = selObjs[col].value.split(',');
												var aStr = detail_mygrid.getUserData(id,"checkState");
												if(aVal.contains('-1')|| aVal.contains(aStr)){
													
												}else{
													isRowHidden  = true;
												}	
											}else{
												var aVal = selObjs[col].value;
												var aStr = this.replace(detail_mygrid.cells2(i,col).getValue());

												if(aVal =="0"|| aStr == aVal){
													
												}else{

													isRowHidden  = true;
												}	
											}
											

							}
							

							
							if(isRowHidden){
								detail_mygrid.setRowHidden(detail_mygrid.getRowId(i),true);
								changed = true;
							}else{
								detail_mygrid.setRowHidden(detail_mygrid.getRowId(i),false);
							}

			
		}	
		
		
		if(callbak) callbak();
}


OrderDetail.prototype.isChanged = function(bakObj,curObj, sysParam){
//	var same = (bakObj.id == curObj.id);
//	if(same) same = bakObj.categoryId == curObj.categoryId;
//	if(same) same = bakObj.customerId == curObj.customerId;
//	if(same) same = bakObj.paymentId == curObj.paymentId;
//	if(same) same = bakObj.userId == curObj.userId;
//	if(same) same = bakObj.orderMeno == curObj.orderMeno;
//	if(same) same = bakObj.modifyBy == curObj.modifyBy;
// 
//    return !same;
    return true;
}

OrderDetail.prototype.isOnlyChangedMeno = function(bakObj,curObj, sysParam,isCkecked){
//	var same = (bakObj.id == curObj.id);
//	if(same) same = bakObj.categoryId == curObj.categoryId;
//	if(same) same = bakObj.customerId == curObj.customerId;
//	if(same) same = bakObj.paymentId == curObj.paymentId;
//	if(same) same = bakObj.userId == curObj.userId;
//	if(same) same = bakObj.orderMeno == curObj.orderMeno; 
//	if(same) same = bakObj.modifyBy == curObj.modifyBy;
// 
//    return !same;

   if(isCkecked){
     	var same = (bakObj.orderMeno == curObj.orderMeno);
     	if(same) same = (bakObj.publishMemo == curObj.publishMemo);
     	if(same) same = (bakObj.matter.edit == curObj.matter.edit);
   }

   return !same;
}


//清空对象
OrderDetail.prototype.reset = function(){
	this.obj.id = null;
	this.obj.parentId = null;
  	this.obj.createBy = null;
  	this.obj.createDate = null;
  	this.obj.modifyBy = null;
  	this.obj.modifyDate = null;
  	this.obj.version = null;
	this.obj.contractId = null;
  	this.obj.orderId = null;
  	this.obj.orderCategoryId = null;
  	this.obj.carrierId = null;
  	
  	this.obj.resourceSortId = null;
  	this.obj.resourceType = null;
  	this.obj.resourceInfoId = null;
    this.obj.compagesId = null;
    this.obj.compages = null;
    
	this.obj.resourceWorkspanId = null;
  	this.obj.resourceSpecificId = null;
  	this.obj.matteType = null;
  	this.obj.matterId = null;
  	this.obj.matterLength = null;
	 	
	this.obj.industryTypeId = null;
  	this.obj.publishMemo = null;
  	this.obj.resourcePriceType = null;
  	this.obj.sysPrice = null;
  	this.obj.execPrice = null;
 	
	this.obj.sumTimes = null;
  	this.obj.moneyBase = null;
  	this.obj.appRate = null;
  	this.obj.ageRate = null;
  	this.obj.favourRate = null;
  	this.obj.moneyBalance = null;
  	
  	this.obj.memo = null;
  	this.obj.isSpaceAdver = null;
  	
  	this.obj.moneyRealpay = null;
	this.obj.moneyIn = null;
  	this.obj.isCkecked = null;
  	this.obj.publishStartDate = null;
  	this.obj.publishEndDate = null;
	
  	this.obj.matterMap = null;
  	this.obj.resourceMap = null;
  	this.obj.carrierMap = null;
  	this.obj.specificMap = null;
  	this.obj.monthInfoMap = null;
  	
  	this.obj.resource = null;
  	this.obj.carrier = null;
  	this.obj.specific = (new Specific()).obj;
  	this.obj.carrier = (new Carrier()).obj;
  
  	this.obj.matter = null;
  	this.obj.orderDayInfos =[];
  	this.obj.isNotInSeries = null;
  	this.obj.needPublish = null;
}

OrderDetail.prototype.setObject = function(sourObj){
	this.obj.id = sourObj.id;
	this.obj.parentId = sourObj.parentId;
  	this.obj.createBy = sourObj.createBy;
  	this.obj.createDate = sourObj.createDate;
  	this.obj.modifyBy = sourObj.modifyBy;
  	this.obj.modifyDate = sourObj.modifyDate;
  	this.obj.version = sourObj.version;
	this.obj.contractId = sourObj.contractId;
  	this.obj.orderId = sourObj.orderId;
  	this.obj.orderCategoryId = sourObj.orderCategoryId;
  	this.obj.carrierId = sourObj.carrierId;
  	
  	this.obj.resourceSortId = sourObj.resourceSortId;
  	this.obj.resourceType = sourObj.resourceType;
  	this.obj.resourceInfoId = sourObj.resourceInfoId;
	this.obj.compagesId = sourObj.compagesId;
	this.obj.compages = sourObj.compages;
    
	this.obj.resourceWorkspanId = sourObj.resourceWorkspanId;
  	this.obj.resourceSpecificId = sourObj.resourceSpecificId;
  	this.obj.matteType = sourObj.matteType;
  	this.obj.matterId = sourObj.matterId;
  	this.obj.matterLength = sourObj.matterLength;
//  	this.obj.matter = sourObj.matter;
	 	
	this.obj.industryTypeId = sourObj.industryTypeId;
  	this.obj.publishMemo = sourObj.publishMemo;
  	this.obj.resourcePriceType = sourObj.resourcePriceType;
  	this.obj.sysPrice = sourObj.sysPrice;
  	this.obj.execPrice = sourObj.execPrice;
 	
	this.obj.sumTimes = sourObj.sumTimes;
  	this.obj.moneyBase = sourObj.moneyBase;
  	this.obj.appRate = sourObj.appRate;
  	this.obj.ageRate = sourObj.ageRate;
  	this.obj.favourRate = sourObj.favourRate;
  	this.obj.moneyBalance = sourObj.moneyBalance;
  	
  	this.obj.memo = sourObj.memo;
  	this.obj.isSpaceAdver = sourObj.isSpaceAdver;
  	
  	this.obj.moneyRealpay = sourObj.moneyRealpay;
	this.obj.moneyIn = sourObj.moneyIn;
  	this.obj.isCkecked = sourObj.isCkecked;
  	this.obj.publishStartDate = sourObj.publishStartDate;
  	this.obj.publishEndDate = sourObj.publishEndDate;
	
  	this.obj.matterMap = sourObj.matterMap;
  	this.obj.resourceMap = sourObj.resourceMap;
  	this.obj.carrierMap = sourObj.carrierMap;
  	this.obj.specificMap = sourObj.specificMap;
  	this.obj.monthInfoMap = sourObj.monthInfoMap;
  	
  	this.obj.resource = sourObj.resource;
  	this.obj.carrier = sourObj.carrier;
  	this.obj.specific = sourObj.specific;
  	this.obj.matter = sourObj.matter;
  	this.obj.orderDayInfos =[];
  	this.obj.isNotInSeries = sourObj.isNotInSeries;
  	this.obj.needPublish = sourObj.needPublish;
  	
  	
   	this.obj.orderPublic = (new OrderPublic()).obj;
  	this.obj.orderPublic.moneyBase =  sourObj.orderPublic.moneyBase;
  	this.obj.orderPublic.moneyRealpay =  sourObj.orderPublic.moneyRealpay;
  	this.obj.orderPublic.times =  sourObj.orderPublic.times;
  	this.obj.orderPublic.publishStartDate =  sourObj.orderPublic.publishStartDate;
  	this.obj.orderPublic.publishEndDate =  sourObj.orderPublic.publishEndDate; 	
} 


OrderDetail.prototype.backupObject = function(sourObj,targObj){
	targObj.id = sourObj.id;
	targObj.parentId = sourObj.parentId;
  	targObj.createBy = sourObj.createBy;
  	targObj.createDate = sourObj.createDate;
  	targObj.modifyBy = sourObj.modifyBy;
  	targObj.modifyDate = sourObj.modifyDate;
  	targObj.version = sourObj.version;
	targObj.contractId = sourObj.contractId;
  	targObj.orderId = sourObj.orderId;
  	targObj.orderCategoryId = sourObj.orderCategoryId;
  	targObj.carrierId = sourObj.carrierId;
  	
  	targObj.resourceSortId = sourObj.resourceSortId;
  	targObj.resourceType = sourObj.resourceType;
  	targObj.resourceInfoId = sourObj.resourceInfoId;

	targObj.compagesId = sourObj.compagesId;
	targObj.compages = sourObj.compages;
    
	targObj.resourceWorkspanId = sourObj.resourceWorkspanId;
  	targObj.resourceSpecificId = sourObj.resourceSpecificId;
  	
  	//alert(sourObj.resourceSpecificId);
  	targObj.matteType = sourObj.matteType;
  	targObj.matterId = sourObj.matterId;
  	targObj.matterLength = sourObj.matterLength;
//  	targObj.matter = sourObj.matter;
	 	
	targObj.industryTypeId = sourObj.industryTypeId;
  	targObj.publishMemo = sourObj.publishMemo;
  	targObj.resourcePriceType = sourObj.resourcePriceType;
  	targObj.sysPrice = sourObj.sysPrice;
  	targObj.execPrice = sourObj.execPrice;
 	
	targObj.sumTimes = sourObj.sumTimes;
  	targObj.moneyBase = sourObj.moneyBase;
  	targObj.appRate = sourObj.appRate;
  	targObj.ageRate = sourObj.ageRate;
  	targObj.favourRate = sourObj.favourRate;
  	targObj.moneyBalance = sourObj.moneyBalance;
  	
  	targObj.memo = sourObj.memo;
  	targObj.isSpaceAdver = sourObj.isSpaceAdver;
  	
  	targObj.moneyRealpay = sourObj.moneyRealpay;
	targObj.moneyIn = sourObj.moneyIn;
  	targObj.isCkecked = sourObj.isCkecked;
  	targObj.publishStartDate = sourObj.publishStartDate;
  	targObj.publishEndDate = sourObj.publishEndDate;
	
  	targObj.matterMap = sourObj.matterMap;
  	targObj.resourceMap = sourObj.resourceMap;
  	targObj.carrierMap = sourObj.carrierMap;
  	targObj.specificMap = sourObj.specificMap;
  	targObj.monthInfoMap = sourObj.monthInfoMap;
  	
//  	targObj.resource = sourObj.resource;
//  	targObj.carrier = sourObj.carrier;
//  	targObj.specific = sourObj.specific;
//  	targObj.matter = sourObj.matter;
  	targObj.orderDayInfos =[];
  	targObj.isNotInSeries = sourObj.isNotInSeries;
  	targObj.needPublish = sourObj.needPublish;
  	
  	
   	targObj.orderPublic = (new OrderPublic()).obj;
  	targObj.orderPublic.moneyBase =  sourObj.orderPublic.moneyBase;
  	targObj.orderPublic.moneyRealpay =  sourObj.orderPublic.moneyRealpay;
  	targObj.orderPublic.times =  sourObj.orderPublic.times;
  	targObj.orderPublic.publishStartDate =  sourObj.orderPublic.publishStartDate;
  	targObj.orderPublic.publishEndDate =  sourObj.orderPublic.publishEndDate; 
  	
  	return 	targObj;
} 

 
/*******************************************
*			对象的基本操作方法                
*******************************************/
OrderDetail.prototype.getOrderDetail = function(id,func){
//	var obj;
	
//	DWREngine.setAsync(false);
	OrderDetailManager.getOrderDetail(id,func);
//	DWREngine.setAsync(true);
//		
//	function setValueFun(o){
//		this.obj = o;
//		obj = o;
//	}
//	return obj;
}
/* 获得列表
 * obj 对象参数
 * fillObjName 界面 TBODY 的ID名
 */
OrderDetail.prototype.getOrderDetails = function(o){
	var OBJ    = o;
	var obj    = o.obj;
	var page   = o.page;
	var tBody  = o.tBody;
		
		
    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		DWREngine.setAsync(false);
		OrderDetailManager.getOrderDetailsPage(OBJ.fillTalbe,obj,page.pageIndex-1,page.pageSize);
		DWREngine.setAsync(true);
    }else{
		OrderDetailManager.getOrderDetails(OBJ.fillTalbe,obj);	
    }
}



OrderDetail.prototype.getOrderDetails = function(o,callBackFun){
	var OBJ    = o;
	var obj    = o.obj;
	var page   = o.page;
	var tBody  = o.tBody;
		
		
    if (page.pageSize > 0){
		var size = this.getCount(obj);
		page.size = size;
		page.MakePageNav(page.pageIndex,page.pageInfo);
		OrderDetailManager.getOrderDetailsPage(callBackFun,obj,page.pageIndex-1,page.pageSize);
	
    }else{
		OrderDetailManager.getOrderDetails(callBackFun,obj);	
    }
}


OrderDetail.prototype.getOrderDetails2 = function(callBackFun){
	
    var page = this.page;
    var obj = this.obj;
		
    if (page.pageSize > 0){
    		function getCountFun(size){ 
			page.size = size;
			page.MakePageNav(page.pageIndex,page.pageInfo);
			OrderDetailManager.getOrderDetailsPage(callBackFun,obj,page.pageIndex-1,page.pageSize);
		}
    	
		OrderDetailManager.getOrderDetailsCount(getCountFun,obj);	
		

	
    }else{
  
		OrderDetailManager.getOrderDetails(callBackFun,obj);	
    }
}

OrderDetail.prototype.getOrderDetails3 = function(callBackFun){
	
    var page = this.page;
    var obj = this.obj;
		
    if (page.pageSize > 0){
    		function getCountFun(size){ 
			page.size = size;
			page.MakePageNav(page.pageIndex,page.pageInfo);
			OrderDetailManager.getOrderDetailsPageXML(callBackFun,obj,page.pageIndex-1,page.pageSize);
		}
    	
		OrderDetailManager.getOrderDetailByOrderIdCount(getCountFun,obj.orderId);
    }
}
OrderDetail.prototype.getOrderDetailsForFztv = function(callBackFun){
    var obj = this.obj;
	OrderDetailManager.getOrderDetailsPageXML(obj,0,10000,callBackFun);    
}



   
//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
OrderDetail.prototype.fillTalbe = function(objs){
	var OBJ = orderDetail;
	var obj = OBJ.obj;
	var tBody  = orderDetail.tBody;
	var color1 = orderDetail.color1;
	var color2 = orderDetail.color2;
	OBJ.rowNum =(OBJ.page.pageIndex-1)*OBJ.page.pageSize*1+1;
	
	
	 //把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("publishMemo", rowData.publishMemo);
	 	row.setAttribute("resourceInfoId", rowData.resourceInfoId);
	 	row.setAttribute("version", rowData.version);
	 	row.setAttribute("matterLength", rowData.matterLength);
	 	row.setAttribute("publishStartDate", rowData.publishStartDate);
	 	row.setAttribute("publishEndDate", rowData.publishEndDate);
	 	row.setAttribute("sumTimes", rowData.sumTimes);
	 	
	 	row.setAttribute("rowData", rowData);
	 	row.rowData = rowData;
	 }	
	 
	//编辑图标的触发的事件
	function edit(event){
		var e = event || window.event;
		var editImg = Event.element(e);
		var id = editImg.getAttribute("paraId"); 
		
		var editRow = $(OBJ.IdPrefix + id);
		OBJ.addNewRow("edit",editRow);
	}
	//删除图标的触发的事件
	function del(event){
		var e = event || window.event;
		var deleImg = Event.element(e);
		var id = deleImg.getAttribute("paraId"); 
		var delRow = deleImg.parentNode.parentNode;
		OBJ.removeOrderDetail(id,delRow);
	}
	

	
	function formatDate(s){
		s =s+"";
//		var year = s.substring(0,4);
		var month = s.substring(4,6);
		var day = s.substring(6,8);
		s =  month +"/" + day;
//		s = year+ "/" + month +"/" + day;
		return s;
	}
	
	 
	 
	
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){return orderDetail.rowNum++;},
					function(obj){
						var compagesId  = obj.compagesId;
						var resourceSortId  = obj.resourceSortId;
						compagesId = (compagesId ==null || compagesId =="") ? 0 :compagesId;
						var pos = "";
						if(resourceSortId ==1) pos = obj.resource.memo;
//						if(resourceSortId ==1) pos = obj.resource.resourceName;
						if(resourceSortId ==2) pos = '<a href="javascript:void 0" onClick="getCompagesDetailPage(\''+compagesId+ '\',\'' + obj.id + '\')">' +obj.compages.name+"</a>";	
						
						return pos;
//						return obj.resource.resourceName'<a href="javascript:void 0" onClick="editDayInfo(\'' + getId(i,objs) + '\',\'' + getCurTime(i) + '\')">'+ i + ":00" + "</a>";
						},
					function(obj){
									var edit =  obj.matter.edit;
									edit = edit.substring(0,9);
									return edit;
									},
					function(obj){return obj.matterLength},
//					function(obj){return obj.publishStartDate},
//					function(obj){return obj.publishEndDate},
//					function(obj){ return obj.orderPublic.publishStartDate;},
//					function(obj){ return obj.orderPublic.publishEndDate;},
					function(obj){ return formatDate(obj.orderPublic.publishStartDate)},
					function(obj){ return formatDate(obj.orderPublic.publishEndDate)},
					function(obj){ return obj.orderPublic.times;},
//					function(obj){return obj.sumTimes},
//				    function(obj) {
//				    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"");
//				    	if(OBJ.enableEdit) editImg.onclick = edit;
//				    	return editImg;}, 
				    function(obj) {
						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deleteOrderDetail","18","18",obj.id,"deleteOrderDetail");
						if(!OBJ.enableDel) deleImg.onclick = function(){return false};
				    	return deleImg;} 
			];	
	
	//先删除 tbody		
	DWRUtil.removeAllRows(tBody);
	//再重新构造新的表
	DWRUtil.addRows(tBody,objs,cellTable,{
				rowCreator:function(options) {  
						   var row = document.createElement("tr");
						   var rowIndex = options.rowIndex;			
						     
						   row.setAttribute("detailRowId",options.rowData.id);
//						   row.setAttribute("onclick","javascript:"getOrderDetail(this)");
						   row.setAttribute("onclick","javascript:getOrderDetail("+ options.rowData.id +")");
//						   row.setAttribute("ondblclick","javascript:getOrderDetailCompages(this)");
//					       row.onmousedown = OBJ.orderDetailMouseDown;							    
				           putRowDataInHidden(row,options.rowData);  
						   return row;  
					  },  
					  
				cellCreator:function(options) {  
						    var td = document.createElement("td"); 
						    td.style.cssText = "cursor: pointer;";	 
						    return td;  
					  }  
				});
				
	//给表格每一行上颜色，调用 global.js 中的setColors函数
	setColors(tBody, color1, color2);
}

OrderDetail.prototype.saveOrderDetailReturnObj = function(obj,saveFun){

	OrderDetailManager.saveOrderDetailReturnObj(obj,saveFun);
}

/* 删除
 * 根据id删除对象
 */
OrderDetail.prototype.removeOrderDetail = function(O,delRow){
	var OBJ = O;
	var page = OBJ.page;
	var curRow = OBJ.tBody.rows.length;
	var obj = OBJ.obj;
//	var del = true;
	
//	if (!checkEeitState('btn_SaveImgTd')) return false;
	
//	if(!confirmDelete(OBJ.className)) {
//		return false;
//	}else{
		delRow.remove();  //ie不能用 delRow.remove();
		curRow--;
		DWREngine.setAsync(false);
		OrderDetailManager.removeOrderDetail(removeFun,obj);	
		DWREngine.setAsync(true);
//		return true;
//	}

	function removeFun(){
		OBJ.reset();
		if(curRow == 0 && page.pageIndex > 1) page.pageIndex--;
//		OBJ.getOrderDetails(OBJ);
   }
   
}


OrderDetail.prototype.removeOrderDetail3 = function(removeFun){
		OrderDetailManager.removeOrderDetail(this.obj,removeFun);	
}

OrderDetail.prototype.removeOrderDetail2= function(removeFun,obj){
	OrderDetailManager.removeOrderDetail(obj.id,removeFun);	
}
/* 总记录数
 * 
 */
OrderDetail.prototype.getCount = function(obj){
	var count;
	
	DWREngine.setAsync(false);
	OrderDetailManager.getOrderDetailsCount(getCountFun,obj);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}

OrderDetail.prototype.getCount = function(obj){
	var count;
	
	DWREngine.setAsync(false);
	OrderDetailManager.getOrderDetailsCount(getCountFun,obj);	
    DWREngine.setAsync(true);
	function getCountFun(size){ count =  size;}
    return count;
}
/* 添加新行 编辑或删除 
 * 
 */
OrderDetail.prototype.addNewRow = function(mode,editRow){
    var OBJ = this;
	var page = this.page;
	var tBody = this.tBody;
	var obj = this.obj;
	
	if (!checkEeitState('btn_SaveImgTd')) return false;
	
	function getRowDataInObj(editRow){
	 	obj.id = editRow.getAttribute("paraId");
	 	obj.publishMemo = editRow.getAttribute("publishMemo");
	 	obj.resourceInfoId = editRow.getAttribute("resourceInfoId");
	 	obj.version = editRow.getAttribute("version");
	 	obj.matterLength = editRow.getAttribute("matterLength");
	 	obj.publishStartDate = editRow.getAttribute("publishStartDate");
	 	obj.publishEndDate = editRow.getAttribute("publishEndDate");
	 	obj.sumTimes = editRow.getAttribute("sumTimes");
	 }	 
	 
	function save(event){
		var e = event || window.event;
		var saveImgTd = Event.element(e);		
		var mode = saveImgTd.getAttribute("mode");
		var id = saveImgTd.getAttribute("paraId");
		DWRUtil.getValues(obj);
		obj.id = id;
		OBJ.saveOrderDetail(obj,mode);
	}	 
	
	function cannel(event){
		 OBJ.reset();
		 OBJ.getOrderDetails();
	}	 	
	 
	//从编辑行中获得数据，来添对象
	if(mode =='edit'){ 
		getRowDataInObj(editRow);
	}


//////////////////构造新行 start //////////////////
	
	var container = document.createElement("span");
	var newRow = document.createElement("tr");
	//给新行设置ID属性
	newRow.setAttribute("id",obj.id);
		
	var cell = []; var j = 0;
		
	var saveImgTd = makeImagTd("image/save.png","btn_SaveImgTd","18","18",obj.id,"");
	var cannelImgTd =makeImagTd("image/restore.png","btn_CannelImgTd","18","18",0,"");

        
	cell[j++] =  makeInputTextTd("publishMemo","text","10px",obj.publishMemo,"");
	cell[j++] =  makeInputTextTd("resourceInfoId","text","10px",obj.resourceInfoId,"");
	cell[j++] =  makeInputTextTd("version","text","10px",obj.version,"");
	cell[j++] =  makeInputTextTd("matterLength","text","10px",obj.matterLength,"");
	cell[j++] =  makeDateInputTextTd("publishStartDate","anchorWStart",obj.publishStartDate,"button_showdate_input");
	cell[j++] =  makeDateInputTextTd("publishEndDate","anchorWEnd",obj.publishEndDate,"button_showdate_input");
	cell[j++] =  makeInputTextTd("sumTimes","text","10px",obj.sumTimes,"");
//	cell[j++] =  saveImgTd;
//	cell[j++] =  cannelImgTd;


	for (var i = 0;i < cell.length;i++ ){
		newRow.appendChild(cell[i]);
	}
	container.appendChild(newRow);
	
//////////////////构造新行 end ///////////////////

	
	//编辑状态：追加新行，删除旧行	
	if(mode =='edit'){
		new Insertion.After(editRow,container.innerHTML);
		editRow.remove();	
	}else{
	//新添状态，直接追加新行
		if(tBody.rows.length == page.pageSize) DWRUtil.removeAllRows(tBody);
		tBody.appendChild(newRow);
	}
		
	//只能在新行添完后，才能给对象添加事件
	var btn_SaveImgTd = $("btn_SaveImgTd"); btn_SaveImgTd.onclick = save;
	var btn_CannelImgTd = $("btn_CannelImgTd"); btn_CannelImgTd.onclick = cannel;	
	
	if(mode =='edit'){
		btn_SaveImgTd.setAttribute("mode","edit")
	}else{
		btn_SaveImgTd.setAttribute("mode","new")
	}

	setColors(tBody,this.color1,this.color2);
}

OrderDetail.prototype.getSumTimes = function(orderId,fun){
	OrderDetailManager.getSumTimes(orderId,fun);
}

OrderDetail.prototype.getMonthInfos = function(o,fun){
	OrderDetailManager.getMonthInfos(o,fun);
}

OrderDetail.prototype.getMonthInfosForFree = function(o,fun){
	OrderDetailManager.getMonthInfosForFree(o,fun); 
}

OrderDetail.prototype.saveContractPayMent = function(fnc,model,sumMoney,contractId,orderId,paymentId,resourceType){
	OrderDetailManager.saveContractPayMent(model,sumMoney,contractId,orderId,paymentId,resourceType,fnc);
}

//组织列表 objs 是返回的对象数组，被DWRUtil.addRows凋用
OrderDetail.prototype.fillCompagesTable = function(objs){
	var OBJ = orderDetail;
	var obj = OBJ.obj;
	var tBody  = orderDetail.tBody;
	var color1 = orderDetail.color1;
	var color2 = orderDetail.color2;
	
	OBJ.rowNum =(OBJ.page.pageIndex-1)*OBJ.page.pageSize*1+1;
	
	
	 //把行的数据放到行的属性里
	 //row 是创建的行对象  options是行数据
	 function putRowDataInHidden(row,rowData){
	 	row.setAttribute("id",OBJ.IdPrefix + rowData.id);
	 	row.setAttribute("paraId", rowData.id);
	 	row.setAttribute("publishMemo", rowData.publishMemo);
	 	row.setAttribute("resourceInfoId", rowData.resourceInfoId);
	 	row.setAttribute("version", rowData.version);
	 	row.setAttribute("matterLength", rowData.matterLength);
	 	row.setAttribute("publishStartDate", rowData.publishStartDate);
	 	row.setAttribute("publishEndDate", rowData.publishEndDate);
	 	row.setAttribute("sumTimes", rowData.sumTimes);
	 	
	 	row.setAttribute("rowData", rowData);
	 	row.rowData = rowData;
	 }	
	 
	//编辑图标的触发的事件
	function edit(event){
		var e = event || window.event;
		var editImg = Event.element(e);
		var id = editImg.getAttribute("paraId"); 
		
		var editRow = $(OBJ.IdPrefix + id);
		OBJ.addNewRow("edit",editRow);
	}
	//删除图标的触发的事件
	function del(event){
		var e = event || window.event;
		var deleImg = Event.element(e);
		var id = deleImg.getAttribute("paraId"); 
		var delRow = deleImg.parentNode.parentNode;
		OBJ.removeOrderDetail(id,delRow);
	}
	
	//一行中，各单元格返回的内容
	var cellTable=[
					function(obj){return orderDetail.rowNum++;},
					function(obj){
						var compagesId  = obj.compagesId;
						var resourceSortId  = obj.resourceSortId;
						compagesId = (compagesId ==null || compagesId =="") ? 0 :compagesId;
						var pos = "";
//						if(resourceSortId ==1) pos = obj.resource.resourceName;
						if(resourceSortId ==1) pos = obj.resource.memo;
						if(resourceSortId ==2) pos = obj.compages.name;	
						return pos;
						},
					function(obj){return obj.matter.edit},
					function(obj){return obj.matterLength},
					function(obj){ return obj.orderPublic.publishStartDate},
					function(obj){ return obj.orderPublic.publishEndDate},
					function(obj){ return obj.orderPublic.times},
//				    function(obj) {
//				    	var editImg = makeImagHtml("image/edit.png","Btn_editPrices","18","18",obj.id,"");
//				    	if(OBJ.enableEdit) editImg.onclick = edit;
//				    	return editImg;}, 
//				    function(obj) {
//						var deleImg = makeImagHtml("image/button_delete.gif","Btn_deleteOrderDetail","18","18",obj.id,"deleteOrderDetail");
////						if(OBJ.enableDel) deleImg.onclick = del;
//				    	return deleImg;} 
			];	
	
	//先删除 tbody		
	DWRUtil.removeAllRows(tBody);
	//再重新构造新的表
	DWRUtil.addRows(tBody,objs,cellTable,{
				rowCreator:function(options) {  
						   var row = document.createElement("tr");
						   var rowIndex = options.rowIndex;			
						     
						   row.setAttribute("detailRowId",options.rowData.id);
//						   row.setAttribute("onclick","javascript:"getOrderDetail(this)");
						   row.setAttribute("onclick","javascript:getOrderDetail("+ options.rowData.id +")");
//						   row.setAttribute("ondblclick","javascript:getOrderDetailCompages(this)");
//					       row.onmousedown = OBJ.orderDetailMouseDown;							    
				           putRowDataInHidden(row,options.rowData);
						   return row;  
					  },  
					  
				cellCreator:function(options) {  
						    var td = document.createElement("td"); 
						    td.style.cssText = "cursor: pointer;";	 
						    return td;  
					  }  
				});
				
	//给表格每一行上颜色，调用 global.js 中的setColors函数
	setColors(tBody, color1, color2);
}


OrderDetail.prototype.saveOrderLog = function(oldOrderDetail,curOrderDetail,callBackFun){
	OrderDetailManager.saveOrderLog(oldOrderDetail,curOrderDetail,callBackFun);	
}

OrderDetail.prototype.getOrderDayInfoId = function(orderDetailId){
	var orderDayInfoId;
	DWREngine.setAsync(false);
	OrderDayInfoManager.getOrderDayInfoId(setValueFun,orderDetailId);
	DWREngine.setAsync(true);
	
	function setValueFun(objs){
		orderDayInfoId=objs[0];
	}
	
	return orderDayInfoId;	
}

OrderDetail.prototype.getOrderDetailId = function(obj){
	var orderDetailId;
	DWREngine.setAsync(false);
	OrderDetailManager.getOrderDetails(setValueFun,obj);
	DWREngine.setAsync(true);
	
	function setValueFun(objs){
		if(objs.length!=0)
		orderDetailId=objs[0].id;
	}
	
	return orderDetailId;	
}
OrderDetail.prototype.getSumTimesByOrderDetailId = function(orderDetailId){
	var sumTimes;
	DWREngine.setAsync(false);
	OrderDetailManager.getOrderDetail(setValueFun,orderDetailId);
	DWREngine.setAsync(true);
	
	function setValueFun(obj){
		sumTimes=obj.orderPublic.times;
	}
	
	return sumTimes;	
}
//OrderDetail.prototype.saveOrderDetails = function(obj){
//	var orderDetailId;
//	DWREngine.setAsync(false);
//	OrderDetailManager.saveOrderDetail(obj,saveFun);
//	DWREngine.setAsync(true);
//	
//	function saveFun(id){
//		orderDetailId=id;
//	}
//	return orderDetailId;
//}

//OrderDetail.prototype.saveOrderDetails = function(obj,saveOrderDetailFun){
//	OrderDetailManager.saveOrderDetails(obj,saveOrderDetailFun);
//}
/* 保存
 * obj 组装好数据的对象
 * mode 保存模式  状态为 new 时必须设置 id = null
 */
OrderDetail.prototype.saveOrderDetail = function(obj,isPackeg,saveFun){
    if(isPackeg){
    	OrderDetailManager.saveOrderDetails(obj,saveFun);
    }else{
    	OrderDetailManager.saveOrderDetail(obj,saveFun);
    }

}


OrderDetail.prototype.saveOrderDetailss = function(obj,callBack){
	OrderDetailManager.saveOrderDetailss(obj,callBack);
}
OrderDetail.prototype.getOrderDetailsAnalyze = function(obj,callBack){
	OrderDetailManager.getOrderDetailsAnalyze(obj,callBack);
}
OrderDetail.prototype.saveOrderDetailM = function(isRes,obj,objs,callBack){
	OrderDetailManager.saveOrderDetailMMM(isRes,obj,objs,callBack);
}

OrderDetail.prototype.getMonthDetailByIncomeId = function(incomeId,callBack){
	OrderDetailManager.getMonthDetailByIncomeId(incomeId,callBack);
}
OrderDetail.prototype.getOrderDetailMonthXml = function(queryStr,callBackFun){
	function setFun(xml){ callBackFun(xml);} 
	OrderDetailManager.getOrderDetailMonthXml(queryStr,setFun);
}


OrderDetail.prototype.saveOrderDetailMore = function(queryStr,orderDetail_objs,callBackFun){
	function callbakFun(s){ callBackFun(s);} 
	OrderDetailManager.saveOrderDetailMore(queryStr,orderDetail_objs,callbakFun);
}

OrderDetail.prototype.getDayInfosLockedByResourceIds = function(resIds, startDate, endDates,callBackFun){
	function callbakFun(s){ callBackFun(s);} 
	OrderDetailManager.getDayInfosLockedByResourceIds(resIds,startDate,endDates,callbakFun);
}


