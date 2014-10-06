var ctxPath;
var proCustomer = new ProCustomer();
var proCustomerType = new ProCustomerType();
var proProgram = new ProProgram();
var proOrder = new ProOrder();
var orderTypeId;

callOnLoad(init);

function init(){
	orderTypeId=getParamFromUrl(document.location.href,"orderTypeId");
	ctxPath = $F("ctxPath");
	function callBackFun(){
		$("cusType").onchange=changeCusType;
	}
	
	proCustomerType.makeSelectCustomerTypeByOrder($("customerTypeDiv"),"cusType","132",callBackFun);
	editMode = getParamFromUrl(document.location.href,"id")*1>0?true:false;

	initTabbar();
	initToolbar();
	   
}

function changeCusType(){
	
	var id=getParamFromUrl(document.location.href,"id");
	if(id!=null){
	if(orderTypeId==1){

		document.location.href=ctxPath +"merm/editCustomer.jsp?id="+id+"&orderTypeId=2";
		
		
	}else{

	        document.location.href=ctxPath +"merm/editCustomer.jsp?id="+id+"&orderTypeId=1";
	        
       }
	}
}	
	    
function initTabbar(){
	
			var imagePath = ctxPath + "image/dhtmlXTabbar/";

            tabbar=new dhtmlXTabBar("a_tabbar","top");
            tabbar.setImagePath(imagePath);
            tabbar.setStyle("silver");
            //tabbar.setOffset(3);     
            tabbar.enableContentZone(false);
            //tabbar.loadXML("tabs7.xml");
      
            tabbar.addTab("Program","节目信息",100);
	    	tabbar.addTab("OrderCus","订单信息",100);
	    	tabbar.addTab("Finance","财务信息",100);

 	    	tabbar.setOnSelectHandler(function(id){
 	    	              //alert(id)
			 var cusId = $("proCustomerId").value==null||$("proCustomerId").value==""?0:$("proCustomerId").value;
				window.frames.details.document.location.href=$F("ctxPath")+"merm/"+"pro"+id+"List.jsp?cusId="+ cusId;
				return true;
			});
			
	     	setTimeout( function() {tabbar.setTabActive("Program",true);},5);
	}	    
	    
function initToolbar(){
		var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml"
		
		aToolBar=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo"); 
		aToolBar.setOnClickHandler(onButtonClick);

		//aToolBar.addItem(new dhtmlXImageTextButtonObject('dhtmlXToolbar/imgs/iconNewNewsEntry.gif',"新添",100,25,0,'0_new','新添','','','dhtmlXToolbar/imgs/iconNewNewsEntry_dis.gif'));
                //aToolBar.addItem(new dhtmlXToolbarDividerXObject('b_'+(new Date()).valueOf()));		
		
		aToolBar.loadXML(toolbarDataPath,callBack);
		
		function callBack(){
			aToolBar.hideButtons(); 
			
			if(editMode){
				$("proCustomerId").value = getParamFromUrl(document.location.href,"id");
	         		aToolBar.showButtons("1_new,2_delete,3_save");  
		                aToolBar.showButtons("div_1,div_2,div_3"); 
		                
		                getAllValueById();
		                           
		               
			}else{
				$("cusType").value = getParamFromUrl(document.location.href,"tId");
				aToolBar.showButtons("1_new,3_save");  
		                aToolBar.showButtons("div_1,div_3"); 
		                
			}
	       aToolBar.setBarAlign("right");
		}
  
                aToolBar.showBar();   
	}
	
function getAllValueById()
	{
		 function func(objs){
		 	
		 		$("cusName").value = objs.customerName;
		 		$("helpCode").value = objs.helpCode;
		 		$("cusType").value = objs.typeId;
		 		$("telphone").value = objs.telephone;
		 		$("linkMen").value = objs.linkmanName;
		 		$("accAddress").value = objs.accountAddress;
		 		
		 		 if(orderTypeId==1){
		                setSelectByValue($("cusType"),"1");
		                }else{
		                setSelectByValue($("cusType"),"2");
		                
		        }	
		        	     
   				    }
   				
		                proCustomer.getProCustomer($("proCustomerId").value,func);
	}
	
function onButtonClick(itemId,itemValue)
	{              
		if(itemId=='1_new') newAdd();
		if(itemId=='2_delete') btnDelete();
		if(itemId=='3_save') saveCustomer();
		if(itemId=='4_search') alert('this method is 3_save');
		if(itemId=='5_print') alert('this method is 5_print');
		if(itemId=='6_view') alert('this method is 6_view');
		if(itemId=='7_export') alert('this method is 7_export');
	}
	
function newAdd(){
//	$("proCustomerId").value = null;
//	$("cusName").value = null;
//	$("helpCode").value = null;
//	$("telphone").value = null;
//	$("linkMen").value = null;
//	$("accAddress").value = null;
	
	 window.location.href=ctxPath +"merm/editCustomer.jsp?orderTypeId="+$("cusType").value;

}

function btnDelete(){  
		var id = $("proCustomerId").value 
	  
	   if(id > 0){
		var msg = "请确认是否删除这条记录 ?";
		
		ans = confirm(msg);
	    if (ans) {
		proCustomer.removeProCustomer(id);
		var cusTypeId = $("cusType").value;
		window.location.href= ctxPath +"merm/customerList.jsp?type="+cusTypeId; 
	    } 
	}
	   
}

function saveCustomer()
	{  
	proCustomer.reset();
	proCustomer.id = $("proCustomerId").value;
	proCustomer.customerName = $("cusName").value;
	proCustomer.helpCode = $("helpCode").value;
	proCustomer.typeId = $("cusType").value;
	proCustomer.telephone = $("telphone").value;
	proCustomer.linkmanName = $("linkMen").value;
	proCustomer.accountAddress = $("accAddress").value;
		
		var func = function(xml){
			alert("保存成功");
			if($("proCustomerId").value=="" || $("proCustomerId").value==null){
			window.location.href=ctxPath +"merm/customerList.jsp?type="+ $("cusType").value;
		}
			
			}
		
		proCustomer.saveProCustomer(proCustomer,func);
	 
	}