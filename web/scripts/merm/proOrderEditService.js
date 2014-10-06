var proProgramType = new ProProgramType();
var proProgram = new ProProgram();
var proOrder = new ProOrder();
var incomeMode=new IncomeMode();
var incomePurpose=new IncomePurpose();
var proFinance=new ProFinance();
var proOrderType = new ProOrderType();
var user = new User();
var proCustomer=new ProCustomer();
var proCustomerType=new ProCustomerType();
var config_serviceDate;
var config_userId;
var ctxPath;
var customer;
var program;
callOnLoad(init);


function init(){
        winHeight = self.innerHeight*0.93; 
	winWidth = self.innerWidth*0.98; 	
	$("orderCode").disabled="true";
	
	var callBackFunny=function(id){
		config_userId=id;
	}
	user.getCurUserId($("config_username").value,callBackFunny);
	getServiceDate();
	config_serviceDate = $("config_serviceDate").value;
	
	type = getParamFromUrl(document.location.href,"type");
	$("proOrderId").value = getParamFromUrl(document.location.href,"id");
	if($("proOrderId").value==""){
       		 get_cur_year();
       		 	proProgram.obj.typeId=type;
	proProgram.getProgramByOrderXML($("program"),"proProgram",proProgram.obj,callBack);
        }else{
        proProgram.obj.typeId=type;
	proProgram.getProgramAllXML($("program"),"proProgram",proProgram.obj,callBack);
}
	ctxPath = $F("ctxPath");
	initToolbar();
	initToolbar1();
	setIncomeModePara(incomeMode);
	setIncomeModePara(incomePurpose);
	setUserPara(user);
	user.makeSelectAnalyze(user,user.selectName,"",setUserSelected);
	//userName = $("config_username").value;

	function callBackFun(){
		switchSelect();
	}
	function callBackWay(){
		switchSelect2();
	}
	function callBack(){	
		selectEventFill();
	}

	proOrderType.getOrderTypesXML($("proOrderTypeDiv"),"proOrderType",140,callBackFun);
    
	proCustomerType.makeSelectCustomerTypeByOrder($("proCustomerTypeDiv"),"proCustomerType",140,callBackWay);
	
	getDate();


	if(type =="1"){
		proCustomer.obj.id=0;
		proCustomer.getAllCustomerXML($("customer"),"proCustomer",proCustomer.obj);
	
	}else{
		customer();
	}
        initGrid();
	resetHeigth();
	buttonEventFill();
	//program();
    
}
function setIncomeModePara(obj){
	 obj.className  = "incomeMode";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}
function setIncomePurposePara(obj){
	 obj.className  = "IncomePurpose";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.selectName = obj.className+"Name";
}


function makeIncomeModeSelectItem(){
		incomeMode.makeSelectItemAnalyze(incomeMode.obj,incomeMode.selectName,"",getIncomeModeCombo);
}

function makeIncomePurposeSelectItem(){
		incomePurpose.makeSelectItemAnalyze(incomePurpose.obj,incomePurpose.selectName,"",getIncomePurposeCombo);
}


function getIncomeModeCombo(){
	var el = $(incomeMode.selectName);
	var inputs = el.getElementsByTagName("option");
	var command = mygrid.getCombo(1);
	command.clear();
	inputs = $A(inputs);
	inputs.each(function(ip){
		if(ip.value!=0){
				command.put(ip.value,el.options[ip.index].text);

		}	
		}
	);
}
function getIncomePurposeCombo(){
	var el = $(incomePurpose.selectName);
	var inputs = el.getElementsByTagName("option");
	var command = mygrid.getCombo(2);
	command.clear();
	inputs = $A(inputs);
	inputs.each(function(ip){
		if(ip.value!=0){
				command.put(ip.value,el.options[ip.index].text);

		}	
		}
	);
}

function resetHeigth(){
    $("gridbox").style.height = winHeight* 0.55 +"px";
     $("gridbox").style.width = winHeight* 1.5 +"px";
} 

function initGrid(){
	var imagePath = ctxPath + "image/grid/";
	mygrid = new dhtmlXGridObject('gridbox');
	mygrid.setImagePath(imagePath);
	mygrid.selMultiRows = true;
	var flds="";
	if(type==1){
	flds = "序号,付款类型,付款用途,应付金额,付款金额,应付日期,付款日期";
	}else{
	flds = "序号,到款类型,到款用途,应收金额,到款金额,应收日期,到款日期";
	}
	mygrid.setHeader(flds);
    mygrid.setInitWidthsP("10,15,15,15,15,15,15");
	mygrid.setColAlign("center,left,left,left,left,left,left");
	mygrid.setColTypes("ro,coro,coro,ed,ed,calendar,calendar");
	mygrid.setDateFormat("y/m/d");
	mygrid.setColSorting("int,str,str,int,int,date,date");
	makeIncomeModeSelectItem();
	makeIncomePurposeSelectItem();
	
	mygrid.enableAlterCss("even","uneven"); 
   	mygrid.setMultiLine(false);
	mygrid.setEditable(true);
   	mygrid.setSkin("modern2");
	mygrid.init();
//	mygrid.setOnRowSelectHandler(onRowSelectd,true);
//	mygrid.setOnRowDblClickedHandler(rowDblClick);
}

	
	
function buttonEventFill(){
	var btn_orderMeno = $("orderMeno");
	btn_orderMeno.onclick=displayDiv;
	
	var btn_textareaOrderMeno = $("textareaOrderMeno");
	btn_textareaOrderMeno.onblur=closeDiv;
	btn_textareaOrderMeno.onkeypress = displayOrderMeno;
}
function displayDiv(ev){
	var oDiv = $("theDivOrderMeno");	
	oDiv.style.visibility = "visible";
	oDiv.style.width = $("orderMeno").offsetWidth*2.6 +"px";
	$("textareaOrderMeno").style.width = oDiv.style.width;
	oDiv.style.heigth = $("textareaOrderMeno").style.height +"px";
	
	$("textareaOrderMeno").focus();	
	//$("orderMeno").disabled= true;
	$("textareaOrderMeno").value = $("orderMeno").value;
}

function closeDiv(ev){
	var oDiv = $("theDivOrderMeno");	
	oDiv.style.visibility = "hidden";
	$("orderMeno").value = 	$("textareaOrderMeno").value;
} 

function displayOrderMeno(ev){
	if(ev.keyCode == 13){
		$("orderMeno").value = 	$("textareaOrderMeno").value;
	}
} 
function get_cur_year(){
		var year=getDayPar(config_serviceDate,'y');
		var html="";
		html += "<select name='orderYear' id='orderYear'>";	
		html +="<option  value='"+ year +"'>" + year +"</option>";
		html +="<option  value='"+ ++year +"'>" + year +"</option>";			
		html += "</select>";
		$("order_year").innerHTML=html;

}
 function getServiceDate(){
 	var fuc = function(d){
 		$("config_serviceDate").value = d;
 	}
 	DWREngine.setAsync(false);
 	DateUtil.getServiceDate(fuc);
 	DWREngine.setAsync(true);
 }
function selectEventFill(){
	var proProgram=$("proProgram");
	proProgram.onchange=getSelectedCustomer;
}
function getSelectedCustomer(){
	var id=$("proProgram").value;

	if(type==1){
	if(id!=0){
	proProgram.getCustomerXML($("customer"),"proCustomer",id);
        }else{
        		proCustomer.obj.id=0;
		proCustomer.getAllCustomerXML($("customer"),"proCustomer",proCustomer.obj);
}
	}
}
function customer(){
	    customer=new dhtmlXCombo("customer","customer",140); 
		customer.enableFilteringMode(true);

		if(type==1){
			proCustomer.obj.typeId=1;
		}else{
			proCustomer.obj.typeId=2;
		}	
		proCustomer.getProCustomersXML(proCustomer.obj,getFun);
        function getFun(xml){
        	customer.clearAll();
    	customer.loadXMLString(xml); 
   }	
}

function program(){
	    program=new dhtmlXCombo("program","program",140); 
		program.enableFilteringMode(true); 
		proProgram.obj.typeId=type;
       proProgram.getProgramNameByOrderXML(proProgram.obj,getFun);
        function getFun(xml){
        	program.clearAll();
    	program.loadXMLString(xml); 
   }	
}

function getDate(){
	
	Calendar.setup({
		inputField  : "orderDate",	  // id of the input field
		//ifFormat	: "%Y%m%d",	  // the date format
		singleClick	  : true,
		button	  : "orderDate"	// id of the button
	});
	
	$("orderDate").value = getFormatDay(config_serviceDate,'y/m/d');
}
function setUserPara(obj){
	 obj.className ="user";
	 obj.selectName =  "userName"; 
}

function setUserSelected(){
	
$("userName").setAttribute("style","margin-left:-100px;width:140px;height:20px");

}

function getAllValueById()
	{
		 function func(objs){
		 	    var payDate=getFormatDay(objs.payDate,'y/m/d');
                var paidDate=getFormatDay(objs.paidDate==""?"":objs.paidDate,'y/m/d');

                var html="";
		html += "<select name='orderYear' id='orderYear'>";	
		html +="<option  value='"+ objs.version +"'>" + objs.version +"</option>";		
		html += "</select>";	
		$("order_year").innerHTML = html;
		 		$("orderCode").value = objs.orderCode;
		 		$("proProgram").value = objs.programId;
		 		$("relationCode").value = objs.relationCode;
				if(type==1){
					getSelectedCustomer();
				}else{
					customer.setComboText(objs.program.proCustomer.customerName);
				}
		 		$("userName").value = objs.userId;
		 		$("proOrderType").value = objs.orderTypeId;
		 		$("proCustomerType").value = objs.program.proCustomer.typeId;
		 		$("orderMeno").value = objs.orderMeno;
		 		$("orderDate").value = getFormatDay(objs.payDate,'y/m/d');
		 		$("proProgram").disabled=true;
		 		$("userName").disabled=true;
		 		$("orderDate").disabled=true;
   				    }
   				     	proOrder.getProOrder($("proOrderId").value,func);
   				     	var funct = function(xml){
						mygrid.clearAll();
						mygrid.loadXMLString(xml);
					  }
				      proFinance.getProFinanceXML($("proOrderId").value,funct);
                     	
	}
function switchSelect(){
		if(type =="1"){
	
		 setSelectByValue($("proOrderType"),"1");
		}else{		
		 setSelectByValue($("proOrderType"),"2"); 
		}
		$("proOrderType").disabled="true";
}

function switchSelect2(){
	
		if(type =="1"){

		 setSelectByValue($("proCustomerType"),"1");		 
		}else{		
		 setSelectByValue($("proCustomerType"),"2");
		}
	   $("proCustomerType").disabled="true";
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
			if($("proOrderId").value!=""){
				aToolBar.showButtons("1_new,2_delete,3_save");  
	                	aToolBar.showButtons("div_1,div_2,div_3"); 
	                	getAllValueById();
				}
			else{
				aToolBar.showButtons("1_new,3_save");  
	               		 aToolBar.showButtons("div_1,div_3"); 
			}
	                
	     aToolBar.setBarAlign("right");           
		}
		
		
		 aToolBar.showBar();  
}
function initToolbar1(){
	var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml" ;
	var aToolBar=new dhtmlXToolbarObject("toolbar_zone1","100%","20","Demo"); 
	aToolBar.setOnClickHandler(onButtonClick1);
	aToolBar.loadXML(toolbarDataPath,callBack);
	 
	function callBack(){
		aToolBar.hideButtons(); 
        aToolBar.showButtons("1_new,2_delete");   
	}
	aToolBar.showBar();  
}

function deleteProOrder()
{  
	   var id =$("proOrderId").value;
	   if(id!=null&&id!=""){
	   var ans = confirm("请确认是否删除这条记录？");
	   if (ans)  proOrder.removeProOrder(id,callBackFun);
	   }
	   function callBackFun(){
		if(type =="1"){
		document.location.href=ctxPath+"merm/proOrderList.jsp?type=1"; 
		}else{
		document.location.href=ctxPath+"merm/proOrderList.jsp?type=2";
		}
	}
}
function onButtonClick(itemId,itemValue)
	{              
		if(itemId=='1_new') newAdd();
		if(itemId=='2_delete') deleteProOrder();
		if(itemId=='3_save') saveProOrder();
	}

function onButtonClick1(itemId,itemValue)
	{              
		if(itemId=='1_new') newAdd1();
		if(itemId=='2_delete') deleteFinance();
	}
function deleteFinance()
{ var id = mygrid.getSelectedId();
      if(id!=null){
	if(id > 0){
		var msg = "请确认是否删除这条记录 ?";
		
		ans = confirm(msg);
		if(ans){
	  	proFinance.removeProFinance(id);
	         mygrid.deleteSelectedItem(); 
	  }
	}else{
	alert("一次只能删除一条");
        }
}else{
	alert("请选中一条记录！");
}
}
function saveProOrder1(objs){
		rowId = mygrid.getSelectedId();

		if(rowId > 0){
			
			proFinance.reset();
			proFinance.obj.id = rowId;
			proFinance.obj.orderId = objs.id;
			proFinance.obj.incomeModeId = getCellValue(rowId,1);
			proFinance.obj.incomePurposeId = getCellValue(rowId,2);
			proFinance.obj.payMoney = getCellValue(rowId,3);
			proFinance.obj.paidMoney = getCellValue(rowId,4);
			proFinance.obj.payDate = getFormatDate(getCellValue(rowId,5),'ymd');
			proFinance.obj.paidDate = getFormatDate(getCellValue(rowId,6),'ymd');
			proFinance.obj.version=objs.version;
			

				var func = function(id){
				mygrid.changeRowId(rowId,id);
				
			        }
				proFinance.saveProFinance(proFinance.obj,func);

	    	
		}else{
			alert("请选择要保存的数据");
		}
}

function getCellValue(rowId,col){ 
	return mygrid.cells(rowId,col).getValue();
}

function getFormatDate(shortDate,format){
	var m =  shortDate.substring(0,2);
	var d =  shortDate.substring(3,5);
	var y =  shortDate.substring(6,10);
	shortDate = y + m + d;
	return shortDate;
}

function newAdd1(){
	var rows = mygrid.getRowsNum() + 1;
	
		mygrid.addRow((new Date()).valueOf(),[rows],mygrid.getRowsNum()+1);
}		
function newAdd(){
                    get_cur_year();
                        function callBack(){	
				selectEventFill();
			}
                    proProgram.obj.typeId=type;
		    proProgram.getProgramByOrderXML($("program"),"proProgram",proProgram.obj,callBack);
	            $("proOrderId").value=null;
	            $("orderCode").value = null;
		 		$("proProgram").value=0;
		 		$("relationCode").value = null;
				if(type==1){
				    proCustomer.obj.id=0;
		                    proCustomer.getAllCustomerXML($("customer"),"proCustomer",proCustomer.obj);
					$("proCustomer").value = 0;	
				}else{
					customer.setComboText(null);
				}
		 		$("userName").value = 0;
		 		$("orderMeno").value = null;
		 		$("orderDate").value = getFormatDay(config_serviceDate,'y/m/d');
		 		$("proProgram").disabled=false;
		 		$("userName").disabled=false;
		 		$("orderDate").disabled=false;
		 		mygrid.clearAll();
}

function saveProOrder()
	{  
	
	var ischecked=saveProOrderCheck();
	if(ischecked) return false;
	
	proOrder.reset();
	
	if(type==1){
		
	proOrder.customerId = $("proCustomer").value;
	
	}
    proOrder.id=$("proOrderId").value==""?null:$("proOrderId").value;
	proOrder.orderCode = $("orderCode").value;
	proOrder.relationCode = $("relationCode").value;
	proOrder.programId = $("proProgram").value;
	proOrder.orderMeno = $("orderMeno").value;
	proOrder.payMoney = 0;
	proOrder.payDate = getFormatDay($("orderDate").value,'ymd');
	proOrder.paidMoney = 0;
	
	proOrder.paidDate = 0;
	proOrder.lessMoney = 0;
	proOrder.moreMoney = 0;
	proOrder.orderTypeId=$("proOrderType").value;
	proOrder.userId=$("userName").value;
	proOrder.createBy=config_userId;
	var id =$("proOrderId").value;
	if(id==""){
	proOrder.version=$("orderYear").value;
	}
	if(type!=1){
		var programs ={proCustomer:{customerName:customer.getComboText(),typeId:$("proCustomerType").value}};	
	        proOrder.program = programs;	        
	        proOrder.saveProOrders(proOrder,setFun);
	}else{
	        proOrder.saveProOrder(proOrder,setFun);
	}

		function setFun(objs){
			       $("orderCode").value=objs.orderCode;
			      saveProOrder1(objs);
					alert("保存成功");				
                    var id =$("proOrderId").value;
                                       
					if(id==null||id==""){
						if(type==1){
							window.location.href=ctxPath+"merm/proOrderList.jsp?type=1"; 
					    }else{
							window.location.href=ctxPath+"merm/proOrderList.jsp?type=2"; 
				        }
						
			        }
		}

	 
}
function saveProOrderCheck(){
	
	var programName = $("proProgram").value;
	if(programName == 0){alert('节目名称不能为空!');return true;}	
	
	if(type!=1){
		var customerName = customer.getComboText();
		if(customerName == ""){alert('客户名称不能为空!');return true;}	
	}else{
		var customerName = $("proCustomer").value;
		if(customerName == ""){alert('客户名称不能为空!');return true;}
	}
	var userId =  $("userName").value;
	if(userId == 0){alert('请选择业务员!');return true;}
	
	if(mygrid.getSelectedId() == null){alert('请添加财务信息!');return true;}
	if(type==1){
	if(getCellValue(mygrid.getSelectedId(),2)==""){alert('到款类型不能为空');return true;}
	if(getCellValue(mygrid.getSelectedId(),3)==""){alert('到款用途不能为空');return true;}
	if(getCellValue(mygrid.getSelectedId(),4)==""){alert('应付金额不能为空');return true;}
	if(getCellValue(mygrid.getSelectedId(),6)==""){alert('应付日期不能为空');return true;}
 	}else{
 	if(getCellValue(mygrid.getSelectedId(),2)==""){alert('付款类型不能为空');return true;}
	if(getCellValue(mygrid.getSelectedId(),3)==""){alert('付款用途不能为空');return true;}
	if(getCellValue(mygrid.getSelectedId(),4)==""){alert('应收金额不能为空');return true;}
	if(getCellValue(mygrid.getSelectedId(),6)==""){alert('应收日期不能为空');return true;}
}
	return false;
}