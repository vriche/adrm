var ProAudienceRat = Class.create({
  initialize: function() {
  	//��������
    this.id = null;
	this.carrierId = null;
    this.audienceDate = null;
	this.audienceTime = null;
	this.version = null;
	this.carrier = {id:null,carrierName:null,aliasName:null};
	
	//ҳ����
	this.pageInfo = null;
	this.pageSize = null;
	this.page = null;
		   
    return this;
  },
  
  
  reset: function() {
	this.initialize();
  },
  
  getProAudienceRatsPageXML: function(obj,callBackFun) {
	    var obj = obj;
	    var page = this.page;
			
	    if (page.pageSize > 0){
	    		function getCountFun(size){ 
				page.size = size;
				page.MakePageNav(page.pageIndex,page.pageInfo);
				ProAudienceRatManager.getProAudienceRatsPageXML(callBackFun,obj,page.pageIndex-1,page.pageSize);
			}
	    	
			ProAudienceRatManager.getProAudienceRatsCount(getCountFun,obj);	
	    }else{
	  
			ProAudienceRatManager.getProAudienceRats(callBackFun,obj);	
	    }

  },
  
  
   removeProAudienceRat: function(id,callBackFun) {
			ProAudienceRatManager.removeProAudienceRat(callBackFun,id);	
  },
  
  
  
  
});