/*====================*/	
	
	function button_addTarget(){
		//检测是否处于编辑状态
		var s =  checkTargetEeitStates();
		if(!s) return false;	
		
		var tddo = document.createElement("td");
	
		var mytr = targetBody.firstChild;
		
		if(mytr != "undefined" && mytr != null && mytr !=""){
			var myclass = mytr.getAttribute("class");
			if(myclass =="empty") mytr.remove();		
		}
	
		var tr = document.createElement('TR');
	
	    var td1   = document.createElement('TD');
	    var td2  = document.createElement('TD');
	    var td3   = document.createElement('TD');
	    var td4   = document.createElement('TD');
	

	    var inp3  = document.createElement('INPUT');  inp3.setAttribute("id","target");  
	    inp3.style.cssText = "width:100%;aling:center;border:5px;text-align:left;cursor:hand;";   
	    
	    
	    var saveImg = makeImagHtml("image/save.png","Btn_SaveTarget","18","18",0,"button_save_target");
	    var deleImg = makeImagHtml("image/restore.png","Btn_Cannel_ID","18","18",0,"button_del_target"); 
	    var cannelImg = makeImagHtml("image/restore.png","Btn_Cannel_ID","18","18",0,"button_cannel_edit");
	    var editImg = makeImagHtml("mage/edit.png","Btn_Edit_ID","18","18",0,"button_edit_target");
	    
	    cannelImg.onclick = function(){
		$("hiddenArea").appendChild($("carrierId"));
		$("hiddenArea").appendChild($("industryTypeId"));
	    tr.remove(); 
	    setColors(mytablebody,color1,color2);
	}
	    
	    
	    tddo.appendChild(saveImg);
	    tddo.appendChild(cannelImg);
	        
	    targetBody.appendChild(tr);
	    
	    tr.appendChild(td1);
	    tr.appendChild(td2);
	    tr.appendChild(td3);
		tr.appendChild(td4);
	    
	    td1.appendChild($("carrierId"));	   
	    td2.appendChild($("industryTypeId"));
	    td3.appendChild(inp3);    
	    
	    td4.appendChild(tddo);
	    setColors(targetBody,color1,color2);	
	}


	function button_save_target(obj) {
		 var contractId = $("contractId").value;
		 var id = obj.getAttribute("paraId");
	
		 if(contractId != ''&& contractId != "-1" && contractId != "null" ){
			 saveTarget(id); 	 
		 }else{
		 	alert("请先保存合同基本信息");
		 } 	
	}
	
	function saveTarget(id){
		var obj = DWRUtil.getValues(Target);
		obj.id = id;
		obj.carrierId = $("carrierId").value;
		obj.industryTypeId = $("industryTypeId").value;
	
		$("hiddenArea").appendChild($("carrierId"));
		$("hiddenArea").appendChild($("industryTypeId"));	
		ContractTargetManager.saveContractTarget(obj,getTarget);
	}

 	function button_cannel_edit(){
 		$("hiddenArea").appendChild($("carrierId"));
		$("hiddenArea").appendChild($("industryTypeId"));
		
		getTarget();
	}
	
	function checkTargetEeitStates(){
		var Btn_SaveTarget = $("Btn_SaveTarget");
		if(!isUndefined(Btn_SaveTarget)){
	        	 alert("已在编辑状态.");
	        	 return false;
	    }
	    return true;
	}	
	
	function button_edit_target(event){
		//检测是否处于编辑状态
		   var s =  checkTargetEeitStates();
	       if (!s) return false;
	       
	       var e = event || window.event;
		   var obj = Event.element(e);
		   var rows = $("targetBody").getElementsByTagName("tr");
		   var rowNum = rows.length;
		   
		   var id = obj.getAttribute("paraId");
		   var tr1= obj.parentNode.parentNode.parentNode;
		   
		   var carrierId; 
		   var industryTypeId;
		   var target = tr1.getAttribute("target");


		   var container = document.createElement("span"); 

		   var tr2 =  DWRUtil._addRowInner(cellFunAddRowTargetEdit,
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
		   	var cells = tr1.getElementsByTagName("td");
			inputs[0].setAttribute("value",target);
			
            tr2.setAttribute("id","targetRow"+id);
            tr2.setAttribute("paraId",id);
			tr2.setAttribute("industryTypeId",tr1.getAttribute("carrierId"));
	        tr2.setAttribute("target",tr1.getAttribute("industryTypeId"));
	           
			container.appendChild(tr2);
			  
			new Insertion.After($("targetRow"+id),container.innerHTML);
			tr1.remove();
			
			
			$("carrierId").value = tr1.getAttribute("carrierId");
			$("industryTypeId").value = tr1.getAttribute("industryTypeId");


			var saveImg = $("Btn_SaveTarget");
			saveImg.setAttribute("paraId",id);
			
			
	}
	
	var cellFunAddRowTargetEdit = [
		function() { return $("carrierId")},
		function() { return $("industryTypeId")},
		function() { return makeInputText("target","text","")},
		function() { 
    	              var paraId = -1;
    	              var saveImg = makeImagHtml("image/save.png","Btn_SaveTarget","18","18",paraId,"button_save_target");
    	              return saveImg;
		           },
		function() { 
    	              var paraId = -1;
    	              var cannelImg = makeImagHtml("image/restore.png","Btn_CanlelTarget","18","18",paraId,"button_cannel_edit");
    	              return cannelImg;
		           }
	]	


	function button_del_target(){
		//检测是否处于编辑状态
		var s =  checkTargetEeitStates();
		if(!s) return false;
		
		if (confirmDelete('target')){ 
			var id = this.getAttribute("paraId");
			ContractTargetManager.removeContractTarget(id,getTarget);
		}	
	}

	
	function getTarget(){
		var pageIndex_target = DWRUtil.getValue("pageIndex_target")*1;
		var contractId = $("contractId").value;
		if(contractId != ''){
			resetTarget();
			Target.contractId = contractId;
			ContractTargetManager.getContractTargetsPage(fillTable_Target,Target,pageIndex_target,pageSize);
		}
	}

	function fillTable_Target(Target) {
		var pageIndex_target = DWRUtil.getValue("pageIndex_target")*1;
		rowNum =(pageIndex_target-1)*pageSize+1;
			
		DWRUtil.removeAllRows("targetBody");
		DWRUtil.addRows("targetBody",Target,cellFunctions_Target,
		{  
		  rowCreator:function(options) {  
			   var row = document.createElement("tr");  
			   var rowIndex = options.rowIndex;
	           row.setAttribute("id","targetRow"+options.rowData.id);
	           row.setAttribute("carrierId",options.rowData.carrierId);
	           row.setAttribute("industryTypeId",options.rowData.industryTypeId);
	           row.setAttribute("target",options.rowData.target);
			   return row;  
		  },  
		  
		  cellCreator:function(options) {  
			    var td = document.createElement("td"); 
			    return td;  
		  }  
	
		});		
		

		setColors($("targetBody"),color1,color2);

		getTargetCount_Target();
		
			

		
	}




/***********************obj start*****************/
	
	
	var Target=
	{ 
		id:null,
		carrier:{carrierName:null},
		industry:{name:null},
		carrierId:null,
		contractId:null,
		industryTypeId:null,
		target:null
	};

	function resetTarget(){
		Target.id = null;
		Target.carrier.carrierName = null;
		//Target.contract.code = null;
		Target.industry.name = null;
		Target.carrierId=null;
		Target.contractId=null;
		Target.industryTypeId=null;
		Target.target=null;
	}

	var cellFunctions_Target = [
		function(Target){return Target.carrier.carrierName},
		function(Target){return Target.industry.name},
		function(Target){return Target.target},
	    function(Target) { 
	    	 var paraId = Target.id;
	    	 var editImg = makeImag("image/edit.png","Btn_editTarget","18","18",paraId,button_edit_target);
	    	 var deleImg = makeImag("image/button_delete.gif","Btn_deleteTarget","18","18",paraId,button_del_target);
	    	 editImg.setAttribute("paraId",paraId);
	    	 deleImg.setAttribute("paraId",paraId);
	 		 var td = document.createElement("td"); 
	 		 td.appendChild(editImg);
	 		 td.appendChild(deleImg);
	    	 return td;
	   }
	];





/*******************************/



	function getTargetCount_Target(){
	
		var contractId = $("contractId").value;
		resetTarget();
		Target.contractId = contractId;
	
		ContractTargetManager.getContractTargetsCount(showPage_Target,Target);
	
	}	


	function showPage_Target(size){
		var tmp ="";
		var curSize = DWRUtil.getValue("totalRecords_target")*1;
	    var trs = targetBody.getElementsByTagName("tr");
	    var curRows = trs.length;  
		var pageIndex_target = DWRUtil.getValue("pageIndex_target")*1;
	    var pageCount = Math.ceil(size/pageSize);  
	    
	    DWRUtil.setValue("totalRecords_target",size);	
			
	    if( size > curSize && size > pageSize*pageIndex_target && curSize > 0 && curRows == pageSize && pageIndex_target > 0){
	    	    	
	    	 pageIndex_target = pageCount;
	    	 DWRUtil.setValue("pageIndex_target",pageIndex_target);
	    	 goNextPage_Target(pageIndex_target);	
	
	    	 return false;
	    }
	    
	    if( size < curSize && curSize > 0 && curRows == 0 && pageIndex_target > 1){
	    		
	    	 pageIndex_target = pageIndex_target*1 - 1;
	    	 DWRUtil.setValue("pageIndex_target",pageIndex_target);
	    	 goNextPage_Target(pageIndex_target);	
	    	 return false;
	    }    
	    
		
		if (pageCount == 0){
			tmp ="没有找到记录";
		}
		if (pageCount > 0){
	        tmp +='第<b style="color:green;">'+(pageIndex_target)+'</b>页 共<b>'+(pageCount)+'</b>页';
	        tmp +='&nbsp;&nbsp;&nbsp;';
		}
		        
	    if (pageCount > 1){
	    	if(pageIndex_target != 1){
		 	   tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Target(1)">首页</a>';  
			   tmp +='&nbsp;&nbsp;&nbsp;';      		
	    	}
	     	
	        if(pageIndex_target > 1){
		       tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Target('+ (pageIndex_target*1-1) +')">上一页</a>';  
		       tmp +='&nbsp;&nbsp;&nbsp;';          	
	        }
	 
	        if(pageIndex_target < pageCount){  
		       tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Target('+ (pageIndex_target*1+1) +')">下一页</a>';  
		       tmp +='&nbsp;&nbsp;&nbsp;';           	
	        }
	   	
	        if(pageIndex_target != pageCount){
	       	   tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Target('+ (pageCount) +')">尾页</a>'; 
	       	   tmp +='&nbsp;&nbsp;&nbsp;';            	
	        }
	    	
	     }        
	
	
		$("pageInfo_target").innerHTML = tmp;
	}

	function goNextPage_Target(pageIndex_target){
		var contractId = $("contractId").value;
		DWRUtil.setValue("pageIndex_target",pageIndex_target);
		resetTarget();
		Target.contractId = contractId;
		if(contractId != ''){ContractTargetManager.getContractTargetsPage(fillTable_Target,Target,pageIndex_target,pageSize);}
	
	}


