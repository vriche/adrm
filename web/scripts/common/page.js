
function Page(pageInfo,pageSize){
	this.pageInfo = pageInfo;
	this.pageSize = pageSize; 		//ÿҳ�ļ�¼��
	this.size = 0;     		//�ܼ�¼��
	this.pageCount = 0;     //��ҳ��
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

// ȡ��ҳ��ǰҳ��,ҳ���1��ʼ.
Page.prototype.getPageIndex = function(){
	return (this.start / this.pageSize) + 1;
}

//��ȡ��һҳ��һ�����������ݼ���λ��.
Page.prototype.getStartOfPage = function(pageIndex){
//	alert("start" + (this.pageIndex - 1) * this.pageSize);
	return (this.pageIndex - 1) * this.pageSize;
}


//��ҳ�Ƿ�����һҳ.
Page.prototype.hasNextPage = function(){
	return this.getPageIndex() < this.getPageCount() - 1;
	 
}

//��ҳ�Ƿ�����һҳ.
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
//        	this.pageHTML +='��<b style="color:green;">'+this.size+'</b>'+'��';
//		this.pageHTML +='&nbsp;&nbsp;';
//		if (this.pageCount > 1){
//        		this.pageHTML +='��<b style="color:green;">'+(pageIndex)+'/'+(this.pageCount)+'</b>ҳ';
//        		this.pageHTML +='&nbsp;&nbsp;';
//        		this.pageHTML +='ת'+this.makeGoto(this.pageInfo,this.pageCount,this.pageIndex)+'ҳ&nbsp;&nbsp;';
//        	}
//	}else{
//		this.pageHTML ="û���ҵ���¼";
//	}
	
	if (this.pageCount > 0){
        	this.pageHTML +='��<b style="color:green;">'+this.size+'</b>'+'��';
			this.pageHTML +='&nbsp;&nbsp;';
		if (this.pageCount > 1){
        		this.pageHTML +='��'+this.makeGoto(this.pageInfo,this.pageCount,this.pageIndex)+'/';
        		this.pageHTML +='<b style="color:green;">'+(this.pageCount)+'</b>ҳ';
        		this.pageHTML +='&nbsp;&nbsp;';
        	}
	}else{
		this.pageHTML ="û���ҵ���¼";
	}	
	
 	if (this.pageCount > 1){
 		
		if(this.pageIndex != 1){
			this.pageHTML +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage(1,\'' + this.pageInfo +'\')">��ҳ</a>';  
			this.pageHTML +='&nbsp;&nbsp;';      		
	    	}else{
			this.pageHTML +='<span style="color:black;")">��ҳ</span>';  
			this.pageHTML +='&nbsp;&nbsp;';    
		}
	    
	        if(this.pageIndex > 1){
		        this.pageHTML +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage(\''+ (this.pageIndex*1-1) +'\',\''+ this.pageInfo +'\')">��һҳ</a>';  
		        this.pageHTML +='&nbsp;&nbsp;';          	
	        }else{
		        this.pageHTML +='<span style="color:black;">��һҳ</a>';  
		        this.pageHTML +='&nbsp;&nbsp;';  
		}
 
	        if(this.pageIndex < this.pageCount){  
			this.pageHTML +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage(\''+ (this.pageIndex*1+1) +'\',\''+ this.pageInfo +'\')">��һҳ</a>';  
		        this.pageHTML +='&nbsp;&nbsp;';           	
	        }else{
			this.pageHTML +='<span style="color:black;">��һҳ</a>';  
		        this.pageHTML +='&nbsp;&nbsp;'; 
		}
        
		if(this.pageIndex != this.pageCount){
	       	    this.pageHTML +='<a href="javascript:void 0" style="color:black;" onClick="goNextPage(\''+ (this.pageCount) +'\',\''+ this.pageInfo +'\')">βҳ</a>'; 
	       	    this.pageHTML +='&nbsp;&nbsp;';            	
		}else{
	       	    this.pageHTML +='<span style="color:black;">βҳ</a>'; 
	       	    this.pageHTML +='&nbsp;&nbsp;';   
		}   
        
 	}
 	
   $(this.pageInfo).innerHTML = this.pageHTML;
	 
}


//��ҳ�Ƿ�����һҳ.
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

