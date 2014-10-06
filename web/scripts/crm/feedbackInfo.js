var rowNum = 1;
var pageSize = 9;

function button_addFeedbackInfo(){
	var s =  checkEeitStates();
	if (!s) return false;
	
	location.href="editFeedbackInfo.html";
}

function getFeedbackInfo(){
	var pageIndex_feedbackInfo = DWRUtil.getValue("pageIndex_feedbackInfo")*1;
	var customerId = $("customerId").value;
	if(customerId != ''){
		resetFeedbackInfo();
		FeedbackInfo.customerId = customerId;
		FeedbackInfoManager.getFeedbackInfosPage(fillTable_FeedbackInfo,FeedbackInfo,pageIndex_feedbackInfo,pageSize);
	}
}

function fillTable_FeedbackInfo(FeedbackInfoList) {
	var pageIndex_feedbackInfo = DWRUtil.getValue("pageIndex_feedbackInfo")*1;
	rowNum =(pageIndex_feedbackInfo-1)*pageSize+1;
	
	DWRUtil.removeAllRows("feedbackInfoBody");
	DWRUtil.addRows("feedbackInfoBody",FeedbackInfoList,cellFunctions_FeedbackInfo);
	setColors(feedbackInfoBody,color1,color2);
	
	getPageCount_FeedbackInfo();
}



/***********************obj start*****************/
  var FeedbackInfo = 
	{
	id:null,
	customerId:null,
    feeder:null,
    departmentId:null,
    feedType:null,
    submitDate:null,
    feedContent:null,
    dealDate:null,
    satisfactoryDegree:null,
    memo:null
  };
  

 
  
  function resetFeedbackInfo(){
  	FeedbackInfo.id = null;
  	FeedbackInfo.customerId = null;
  	FeedbackInfo.feeder = null;
  	FeedbackInfo.departmentId = null;
  	FeedbackInfo.feedType = null;
  	FeedbackInfo.submitDate = null;
  	FeedbackInfo.feedContent = null;
  	FeedbackInfo.dealDate = null;
  	FeedbackInfo.satisfactoryDegree = null;
  	FeedbackInfo.memo = null;
  }

/***********************obj end*******************/

var cellFunctions_FeedbackInfo = [
  	function(FeedbackInfo) { return "<a href='editFeedbackInfo.html?id=" +FeedbackInfo.id +"'>" + FeedbackInfo.id +"</a>"},
  	function(FeedbackInfo) { return FeedbackInfo.feeder },
  	function(FeedbackInfo) { return FeedbackInfo.submitDate },
  	function(FeedbackInfo) { return FeedbackInfo.feedContent },
  	function(FeedbackInfo) { return FeedbackInfo.dealDate },
  	function(FeedbackInfo) { return FeedbackInfo.satisfactoryDegree },
  	function(FeedbackInfo) { return "" }
];






/*******************************
 * 分页处理
 *******************************/



	
	
function getPageCount_FeedbackInfo(){
	var customerId = $("customerId").value;
	resetFeedbackInfo();
	FeedbackInfo.customerId = customerId;
	FeedbackInfoManager.getFeedbackInfosCount(showPage_FeedbackInfo,FeedbackInfo);
}	


function showPage_FeedbackInfo(size){
	var tmp ="";
	var curSize = DWRUtil.getValue("totalRecords_feedbackInfo")*1;
    var trs = feedbackInfoBody.getElementsByTagName("tr");
    var curRows = trs.length;  
	var pageIndex_feedbackInfo = DWRUtil.getValue("pageIndex_feedbackInfo")*1;
    var pageCount = Math.ceil(size/pageSize);  
    
    DWRUtil.setValue("totalRecords_feedbackInfo",size);	

	
    if( size > curSize && size > pageSize*pageIndex_feedbackInfo && curSize > 0 && curRows == pageSize && pageIndex_feedbackInfo > 0){
    	 pageIndex_feedbackInfo = pageCount;
    	 DWRUtil.setValue("pageIndex_feedbackInfo",pageIndex_feedbackInfo);
    	 goNextPage_FeedbackInfo(pageIndex_feedbackInfo);	
    	 return false;
    }
    
    if( size < curSize && curSize > 0 && curRows == 0 && pageIndex_feedbackInfo > 1){
    	 pageIndex_feedbackInfo = pageIndex_feedbackInfo*1 - 1;
    	 DWRUtil.setValue("pageIndex_feedbackInfo",pageIndex_feedbackInfo);
    	 goNextPage_FeedbackInfo(pageIndex_feedbackInfo);	
    	 return false;
    }    
    
	
	if (pageCount == 0){
		tmp ="没有找到记录";
	}
	if (pageCount > 0){
        tmp +='第<b style="color:green;">'+(pageIndex_feedbackInfo)+'</b>页 共<b>'+(pageCount)+'</b>页';
        tmp +='&nbsp;&nbsp;&nbsp;';
	}
	        
    if (pageCount > 1){
    	
    	if(pageIndex_feedbackInfo != 1){
	 	   tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_FeedbackInfo(1)">首页</a>';  
		   tmp +='&nbsp;&nbsp;&nbsp;';      		
    	}
     	
        if(pageIndex_feedbackInfo > 1){
	       tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_FeedbackInfo('+ (pageIndex_feedbackInfo*1-1) +')">上一页</a>';  
	       tmp +='&nbsp;&nbsp;&nbsp;';          	
        }
 
        if(pageIndex_feedbackInfo < pageCount){  
	       tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_FeedbackInfo('+ (pageIndex_feedbackInfo*1+1) +')">下一页</a>';  
	       tmp +='&nbsp;&nbsp;&nbsp;';           	
        }
   	
        if(pageIndex_feedbackInfo != pageCount){
       	   tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_FeedbackInfo('+ (pageCount) +')">尾页</a>'; 
       	   tmp +='&nbsp;&nbsp;&nbsp;';            	
        }
    	
     }        


	$("pageInfo_feedbackInfo").innerHTML = tmp;
}

function goNextPage_FeedbackInfo(pageIndex_feedbackInfo){
	var customerId = $("customerId").value;
	DWRUtil.setValue("pageIndex_feedbackInfo",pageIndex_feedbackInfo);
	resetFeedbackInfo();
	FeedbackInfo.customerId = customerId;
	if(customerId != ''){FeedbackInfoManager.getFeedbackInfosPage(fillTable_FeedbackInfo,FeedbackInfo,pageIndex_feedbackInfo,pageSize);}
}
	

