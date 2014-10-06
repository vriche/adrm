var rowNum = 1;
var pageSize = 9;

function button_addMatter(){
	var s =  checkEeitStates();
	if (!s) return false;
	
	location.href="editMatter.html";
}

function getMatter(){
	var pageIndex_matter = DWRUtil.getValue("pageIndex_matter")*1;
	var customerId = $("customerId").value;
	if(customerId != ''){
		resetMatter();
		Matter.customerId = customerId;
		MatterManager.getMattersPage(fillTable_Matter,Matter,pageIndex_matter,pageSize);
	}
}

function fillTable_Matter(MatterList) {
	var pageIndex_matter = DWRUtil.getValue("pageIndex_matter")*1;
	rowNum =(pageIndex_matter-1)*pageSize+1;
	
	DWRUtil.removeAllRows("matterBody");
	DWRUtil.addRows("matterBody",MatterList,cellFunctions_Matter);
	setColors(matterBody,color1,color2);
	
	getPageCount_Matter();
}



/***********************obj start*****************/
  var Matter = 
	{
	id:null,
	customerId:null,
    name:null,
    edit:null,
    length:null,
    tapeCode:null
  };
  
 
  
  function resetMatter(){
  	Matter.id = null;
  	Matter.customerId = null;
  	Matter.name = null;
  	Matter.edit = null;
  	Matter.length = null;
  	Matter.tapeCode = null;
  }

/***********************obj end*******************/

var cellFunctions_Matter = [
  	function(Matter) { return "<a href='editMatter.html?id=" +Matter.id +"'>" + Matter.name +"</a>"},
  	function(Matter) { return Matter.edit },
  	function(Matter) { return Matter.length },
  	function(Matter) { return Matter.tapeCode },
    function(Matter) { return "" }
];






/*******************************
 * 分页处理
 *******************************/

	
function getPageCount_Matter(){
	var customerId = $("customerId").value;
	resetMatter();
	Matter.customerId = customerId;
	MatterManager.getMattersCount(showPage_Matter,Matter);
}	


function showPage_Matter(size){
	var tmp ="";
	var curSize = DWRUtil.getValue("totalRecords_matter")*1;
    var trs = matterBody.getElementsByTagName("tr");
    var curRows = trs.length;  
	var pageIndex_matter = DWRUtil.getValue("pageIndex_matter")*1;
    var pageCount = Math.ceil(size/pageSize);  
    
    DWRUtil.setValue("totalRecords_matter",size);	
    
	
    if( size > curSize && size > pageSize*pageIndex_matter && curSize > 0 && curRows == pageSize && pageIndex_matter > 0){
    	 pageIndex_matter = pageCount;
    	 DWRUtil.setValue("pageIndex_matter",pageIndex_matter);
    	 goNextPage_Matter(pageIndex_matter);	
    	 return false;
    }
    
    if( size < curSize && curSize > 0 && curRows == 0 && pageIndex_matter > 1){
    	 pageIndex_matter = pageIndex_matter*1 - 1;
    	 DWRUtil.setValue("pageIndex_matter",pageIndex_matter);
    	 goNextPage_Matter(pageIndex_matter);	
    	 return false;
    }    
    

	
	if (pageCount == 0){
		tmp ="没有找到记录";
	}
	if (pageCount > 0){
        tmp +='第<b style="color:green;">'+(pageIndex_matter)+'</b>页 共<b>'+(pageCount)+'</b>页';
        tmp +='&nbsp;&nbsp;&nbsp;';
	}
	        
    if (pageCount > 1){
    	
    	if(pageIndex_matter != 1){
	 	   tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Matter(1)">首页</a>';  
		   tmp +='&nbsp;&nbsp;&nbsp;';      		
    	}
     	
        if(pageIndex_matter > 1){
	       tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Matter('+ (pageIndex_matter*1-1) +')">上一页</a>';  
	       tmp +='&nbsp;&nbsp;&nbsp;';          	
        }
 
        if(pageIndex_matter < pageCount){  
	       tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Matter('+ (pageIndex_matter*1+1) +')">下一页</a>';  
	       tmp +='&nbsp;&nbsp;&nbsp;';           	
        }
   	
        if(pageIndex_matter != pageCount){
       	   tmp +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage_Matter('+ (pageCount) +')">尾页</a>'; 
       	   tmp +='&nbsp;&nbsp;&nbsp;';            	
        }
    	
     }        


	$("pageInfo_matter").innerHTML = tmp;
}

function goNextPage_Matter(pageIndex_matter){
	var customerId = $("customerId").value;
	DWRUtil.setValue("pageIndex_matter",pageIndex_matter);
	resetMatter();
	Matter.customerId = customerId;
	if(customerId != ''){MatterManager.getMattersPage(fillTable_Matter,Matter,pageIndex_matter,pageSize);}
}
	

