
function Page(pageInfo,pageSize){
	this.pageInfo = pageInfo;
	this.pageSize = pageSize; 		//每页的记录数
	this.size = 0;     		//总记录数
	this.pageCount = 0;     //总页数
	this.pageHTML;
	this.pageIndex= 1;
	this.start = 0;
	this.data;
	
	return this;
}


//
Page.prototype.getPageCount = function(){
	return Math.ceil(this.size/this.pageSize);
}

// 取该页当前页码,页码从1开始.
Page.prototype.getPageIndex = function(){
	return (this.start / this.pageSize) + 1;
}

//获取任一页第一条数据在数据集的位置.
Page.prototype.getStartOfPage = function(pageIndex){
//	alert("start" + (this.pageIndex - 1) * this.pageSize);
	return (this.pageIndex - 1) * this.pageSize;
}


//该页是否有下一页.
Page.prototype.hasNextPage = function(){
	return this.getPageIndex() < this.getPageCount() - 1;
	 
}

//该页是否有上一页.
Page.prototype.hasPreviousPage = function(){
	return this.getPageIndex() > 1;
	 
}


//function goNextPage(pageIndex,fillObjName,pageInfoName,size,pageSize){
//	var p = new Page();
//	p.goNextPage(pageIndex,fillObjName,pageInfoName,size,pageSize);
//}
	


Page.prototype.MakePageNav = function(pageIndex){
	
	this.pageHTML ="";
	this.pageCount = this.getPageCount();

//	if (this.pageCount > 0){
//        	this.pageHTML +='共<b style="color:green;">'+this.size+'</b>'+'条';
//		this.pageHTML +='&nbsp;&nbsp;';
//		if (this.pageCount > 1){
//        		this.pageHTML +='第<b style="color:green;">'+(pageIndex)+'/'+(this.pageCount)+'</b>页';
//        		this.pageHTML +='&nbsp;&nbsp;';
//        		this.pageHTML +='转'+this.makeGoto(this.pageInfo,this.pageCount,this.pageIndex)+'页&nbsp;&nbsp;';
//        	}
//	}else{
//		this.pageHTML ="没有找到记录";
//	}
	
	if (this.pageCount > 0){
        	this.pageHTML +='共<b style="color:green;">'+this.size+'</b>'+'条';
			this.pageHTML +='&nbsp;&nbsp;';
		if (this.pageCount > 1){
        		this.pageHTML +='第'+this.makeGoto(this.pageInfo,this.pageCount,this.pageIndex)+'/';
        		this.pageHTML +='<b style="color:green;">'+(this.pageCount)+'</b>页';
        		this.pageHTML +='&nbsp;&nbsp;';
        	}
	}else{
		this.pageHTML ="没有找到记录";
	}	
	
 	if (this.pageCount > 1){
 		
		if(this.pageIndex != 1){
			this.pageHTML +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage(1,\'' + this.pageInfo +'\')">首页</a>';  
			this.pageHTML +='&nbsp;&nbsp;';      		
	    	}else{
			this.pageHTML +='<span style="color:black;")">首页</span>';  
			this.pageHTML +='&nbsp;&nbsp;';    
		}
	    
	        if(this.pageIndex > 1){
		        this.pageHTML +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage(\''+ (this.pageIndex*1-1) +'\',\''+ this.pageInfo +'\')">上一页</a>';  
		        this.pageHTML +='&nbsp;&nbsp;';          	
	        }else{
		        this.pageHTML +='<span style="color:black;">上一页</a>';  
		        this.pageHTML +='&nbsp;&nbsp;';  
		}
 
	        if(this.pageIndex < this.pageCount){  
			this.pageHTML +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage(\''+ (this.pageIndex*1+1) +'\',\''+ this.pageInfo +'\')">下一页</a>';  
		        this.pageHTML +='&nbsp;&nbsp;';           	
	        }else{
			this.pageHTML +='<span style="color:black;">下一页</a>';  
		        this.pageHTML +='&nbsp;&nbsp;'; 
		}
        
		if(this.pageIndex != this.pageCount){
	       	    this.pageHTML +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage(\''+ (this.pageCount) +'\',\''+ this.pageInfo +'\')">尾页</a>'; 
	       	    this.pageHTML +='&nbsp;&nbsp;';            	
		}else{
	       	    this.pageHTML +='<span style="color:black;">尾页</a>'; 
	       	    this.pageHTML +='&nbsp;&nbsp;';   
		}   
        
 	}
 	
   $(this.pageInfo).innerHTML = this.pageHTML;
	 
}


//该页是否有上一页.
Page.prototype.goNextPage = function(pageIndex){
	
	this.pageIndex = pageIndex;
	this.start = this.getStartOfPage(pageIndex);

	this.pageCount = this.getPageCount();
	this.MakePageNav(pageIndex);
}


Page.prototype.makeGoto = function(pageInfo,pageCount,pageIndex){
	html = '<select style=\"color:green;CURSOR: pointer;\" name=\"select\" onChange="goNextPage(this.value,\''+ pageInfo +'\','+ pageCount +','+ pageIndex +')">';
	for(var i = 1;i<pageCount+1;i++){
		if(i == pageIndex){
			html += '<option  value='+ i +' selected>'+ i +'</option>';
		}else{
			html += '<option  value='+ i +'>'+ i +'</option>';
		}
	}
	html += '</select>';
	return html;
}

