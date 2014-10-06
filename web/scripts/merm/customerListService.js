var ctxPath;
var proCustomer = new ProCustomer();
var proCustomerType = new ProCustomerType();
var comboCustomer;
var headers="客户名称, 联系人,联系电话";

callOnLoad(init);


function init(){
	ctxPath = $F("ctxPath");
	winHeight = self.innerHeight*0.93; 
	winWidth = self.innerWidth*0.98; 
	setProCustomerPara(proCustomer);
 	switchTitle();
	initGrid();
	resetHeigth();
	initToolbar();
	proCustomerType.makeSelectCustomerType($("customerTypeDiv"),"cusType","132");
		comboCustomerDiv();
		buttonEventFill();
		getCustomerListByCusName();
}
function resetHeigth(){
    $("gridbox").style.height = winHeight* 0.80 +"px";
}
function comboCustomerDiv(){
       		comboCustomer = new dhtmlXCombo("cus_name","alfa2",200);
	  			 comboCustomer.enableFilteringMode(true);

				proCustomer.reset();
				proCustomer.obj.typeId = $("typeId").value;
 			var func = function(xml){
					comboCustomer.clearAll();
					comboCustomer.loadXMLString(xml);
 			}
 			proCustomer.getProCustomersXML(proCustomer.obj,func);
}

function buttonEventFill(){
	var btn_searche = $("search");
	btn_searche.onclick=searchDiv;

}

function setProCustomerPara(obj){
	 obj.className  = "proCustomer";	
	 obj.pageInfo 	= "pageInfo_" + obj.className;
	 obj.pageSize 	= "16";
	 obj.page = new Page(obj.pageInfo,obj.pageSize);	
}

function searchDiv(){
	    
	var customerName = comboCustomer.getComboText();
	$("proCustomerName").value = customerName;
	getCustomerListByCusName();
}
	
function switchTitle(type){
		var s =document.location.href;
		var type = getParamFromUrl(s,"type");
		$("typeId").value = type;
}
	
	
	
function initGrid(){
	 	var imagePath = ctxPath + "image/grid/";
		mygrid = new dhtmlXGridObject('gridbox');
		mygrid.setImagePath(imagePath);
		mygrid.setHeader("客户名称, 联系人,联系电话");
		mygrid.setInitWidthsP("50,25,25")
		mygrid.setColAlign("left,right,right")
		mygrid.setColTypes("ro,ed,ed");
		mygrid.setColSorting("int,str,str")
		mygrid.enableMultiselect(true)
		mygrid.init();
		//mygrid.loadXML("sampleData/customer_grid.xml");
		
		mygrid.setSkin("modern2");
		mygrid.enableAlterCss("even","uneven");
		mygrid.setOnRowDblClickedHandler(rowDblClick);
}
	
function rowDblClick(id){
	     window.location.href=ctxPath +"merm/editCustomer.jsp?id="+id+"&orderTypeId="+$("typeId").value;
}

function initToolbar(){
		var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml"
		var aToolBar=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo"); 
		aToolBar.setOnClickHandler(onButtonClick);

		//aToolBar.addItem(new dhtmlXImageTextButtonObject('dhtmlXToolbar/imgs/iconNewNewsEntry.gif',"新添",100,25,0,'0_new','新添','','','dhtmlXToolbar/imgs/iconNewNewsEntry_dis.gif'));
                //aToolBar.addItem(new dhtmlXToolbarDividerXObject('b_'+(new Date()).valueOf()));		
		
		aToolBar.loadXML(toolbarDataPath,callBack);
		 
		function callBack(){
			aToolBar.hideButtons(); 
	                aToolBar.showButtons("1_new,2_delete,4_search,5_print,6_view,7_export");  
	                aToolBar.showButtons("div_1,div_2,div_4,div_5,div_6,div_7"); 
	                
		}
		
		 aToolBar.showBar();  
 
}
	
function onButtonClick(itemId,itemValue)
	{              
		var tId = getParamFromUrl(document.location.href,"type");
		if(itemId=='1_new')  window.location.href= ctxPath +"merm/editCustomer.jsp?tId="+tId;
		if(itemId=='2_delete') deleteRow();
		if(itemId=='3_save') alert('this method is save');
		if(itemId=='4_search') search();
		if(itemId=='5_print') print();
		if(itemId=='6_view') printView();
		if(itemId=='7_export') printExport();
	}
	
function print(){
		//window.location.href=getReportURL('print')	
		var title ="";
		var urlStr = getReportURL('print');
		openNewWin(title,urlStr);			
}	
function printView(){
		//window.location.href=getReportURL('view')
		var title ="";
		var urlStr = getReportURL('view');
		 openNewWin(title,urlStr);					
}
function printExport(){
		window.location.href=getReportURL('export');
}

function openNewWin(title,urlStr,w,h) {
   
   w = w > 0?w:winWidth;
   h = h > 0?w:winHeight;

   var parameters ={
   	title:"<strong>" + title +"</strong>",
   	className:"alphacube",
	width:w,
	height:h,
	draggable:false,
	minimizable:false,
	maximizable:false,
	closable:true
   	// parameters.effectOptions = {className: "popup_effect1"};
   };

	myWin = new Window(parameters);
	myWin.setURL(urlStr);
	myWin.showCenter(true);
	
}
function getReportURL(model,isChart){
	
        var url = ctxPath;
        var s =document.location.href;
		var type = getParamFromUrl(s,"type");
		var a = {
			 	model: model,
                reportType: "proCustomer_report",
                headers:headers,
                displaySumColum:"0,0,0",
                isSum:true,
                isVertical:true,
		        helpCode:$("proHelpCode").value,
		        typeId:type,
		        telephone:$("proTelephone").value,
		        linkmanName:$("proLinkmanName").value,
		        accountAddress:$("proAccountAddress").value,
                customerName: $("proCustomerName").value
		};		
		var h = $H(a);	
		if(isChart){
			url = ctxPath +"/merm/proCustomerChart.jsp?"+ encodeURI(h.toQueryString());
		}else{
			url = ctxPath +"/reports/printServlet?"+ encodeURI(h.toQueryString());	
		}

		return url;
}

function deleteRow(){  
		var id = mygrid.getSelectedId();
	   if(id!=null){
	             
	              Dialog.confirm("请确认是否删除", {className: "alphacube", width:300, height:80,okLabel: "确定",cancelLabel: "取消",
	    		onOk:function(win){               
	             	Dialog.closeInfo();
	             	proCustomer.removeProCustomer(id);
	  	     	mygrid.deleteSelectedItem();	 
	         }});
	             		
	   }else{
	             	alert("请选择要删除的数据!");
	             	return false;
	   }
	   
}
	

function search() {
		Dialog.confirm($('login').innerHTML,
		 {className:"alphacube", width:450, okLabel: "确定", cancelLabel: "取消",
		
		         onOk:function(win){      
		         		$("proCustomerName").value = $("cusName").value;
		         		$("proHelpCode").value = $("helpCode").value;
						$("typeId").value = $("cusType").value;
						$("proTelephone").value = $("telphone").value;
						$("proLinkmanName").value = $("linkMen").value;
						$("proAccountAddress").value = $("accAddress").value;
						
		           			  getCustomerListByCusName();         
		             Dialog.closeInfo();
		             return true;
		         }
	         }
	                                        
	         );
	}	

function getCustomerListByCusName(){
		proCustomer.reset();
		proCustomer.customerName = $("proCustomerName").value;
		proCustomer.helpCode = $("proHelpCode").value;
		
		if($("typeId").value!=""){
			proCustomer.typeId = $("typeId").value;
		}
		
		proCustomer.telephone = $("proTelephone").value;
		proCustomer.linkmanName = $("proLinkmanName").value;
		proCustomer.accountAddress = $("proAccountAddress").value;

	 var func = function(xml){
				mygrid.clearAll();
				mygrid.loadXMLString(xml);
				
		 }
	
		proCustomer.getProCustomersPageXML(proCustomer,func);
}

//翻页处理
function goNextPage(pageIndex,pageInfoName){
	if(pageInfoName == proCustomer.pageInfo){
		var page = new Page(proCustomer.pageInfo,proCustomer.pageSize);
		page.goNextPage(pageIndex);
		proCustomer.page = page;

		getCustomerListByCusName();
	}

}	