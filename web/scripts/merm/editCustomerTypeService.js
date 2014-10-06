var ctxPath;
var proCustomerType = new ProCustomerType();
callOnLoad(init);


function init(){
		ctxPath = $F("ctxPath");
		editMode = getParamFromUrl(document.location.href,"id")*1>0?true:false;
        	initToolbar();
}    

	    
function initToolbar(){
			var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml"
			var aToolBar=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo"); 
				aToolBar.setOnClickHandler(onButtonClick);	
				aToolBar.loadXML(toolbarDataPath,callBack);
		
			function callBack(){
				aToolBar.hideButtons(); 
			
			if(editMode){
	         		aToolBar.showButtons("1_new,2_delete,3_save");  
		                aToolBar.showButtons("div_1,div_2,div_3"); 
		                $("cusTypeId").value = getParamFromUrl(document.location.href,"id");
		      		getAllValueById();
			}else{
				aToolBar.showButtons("1_new,3_save");  
		                aToolBar.showButtons("div_1,div_3"); 
			}
	       
		}
  
                aToolBar.showBar();   
	}
	
function getAllValueById()
	{
		 function func(objs){
		 		$("cusType").value = objs.name;
   				    }
   				    
		                proCustomerType.getProCustomerType($("cusTypeId").value,func);
	}
	
function onButtonClick(itemId,itemValue)
	{              
		if(itemId=='1_new'); window.location.href="editCustomerType.jsp";
		if(itemId=='2_delete') deleteType();
		if(itemId=='3_save') saveType();
	}
	
function deleteType()
	{  
	   var Id =$("cusTypeId").value;
	   proCustomerType.removeProCustomerType(Id);
	}
	
function saveType()
	{  
	proCustomerType.reset();
	proCustomerType.name = $("cusType").value;
	proCustomerType.id = $("cusTypeId").value;
	function func(xml){
		 		alert("±£´æ³É¹¦!");
		 		
   				    }
				 proCustomerType.saveProCustomerType(proCustomerType,func);
	 
	}
	
	