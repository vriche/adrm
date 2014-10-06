var ctxPath;
var typeID;
var proCustomerType = new ProCustomerType();
callOnLoad(init);

function init(){
		ctxPath = $F("ctxPath");
        initGrid();
        initToolbar();
        getCustomerTypeList();
}
	
function initGrid(){
		var imagePath = ctxPath + "image/grid/";
		mygrid = new dhtmlXGridObject('gridbox');
		mygrid.setImagePath("dhtmlxGrid/imgs/");
		mygrid.setHeader("序号,类别ID,类别名称");
		mygrid.setInitWidthsP("40,30,30")
		mygrid.setColAlign("left,right,right")
		mygrid.setColTypes("ro,ed,ed");
		mygrid.setColSorting("str,int,str")
		mygrid.enableMultiselect(true)
		mygrid.init();
//		mygrid.loadXML("sampleData/customerType_grid.xml");
		
		mygrid.setSkin("modern2");
		mygrid.enableAlterCss("even","uneven");
		mygrid.setOnRowDblClickedHandler(rowDblClick);
}
	
function rowDblClick(id){
			window.location.href="editCustomerType.jsp?id="+id;
}

function initToolbar(){
		var toolbarDataPath = ctxPath+"merm/toolbarData/_toolbar.xml"
		var aToolBar=new dhtmlXToolbarObject("toolbar_zone","100%","20","Demo"); 
			aToolBar.setOnClickHandler(onButtonClick);	
			aToolBar.loadXML(toolbarDataPath,callBack);
		 
		function callBack(){
			aToolBar.hideButtons(); 
	        aToolBar.showButtons("1_new,2_delete");  
	        aToolBar.showButtons("div_1,div_2"); 
	                
		}

			aToolBar.showBar();  

}
	
function onButtonClick(itemId,itemValue)
	{              
		if(itemId=='1_new') window.location.href="editCustomerType.jsp";
		if(itemId=='2_delete') deleteType();
	}
	
function deleteType()
	{  
		 Dialog.confirm("请确认是否删除", {className: "alphacube", width:300, height:80,okLabel: "确定",cancelLabel: "取消",
	     onOk:function(win){               
	             Dialog.closeInfo();
	             var id = mygrid.getSelectedId();
	  				 proCustomerType.removeProCustomerType(id);
	  				 mygrid.deleteSelectedItem();  
	         }});
		
		
		
	}
	
function getCustomerTypeList(){
	 
	 var func = function(xml){
				mygrid.clearAll();
				mygrid.loadXMLString(xml);
				
		 }
	
		proCustomerType.getProCustomerTypeXML(func);
}
