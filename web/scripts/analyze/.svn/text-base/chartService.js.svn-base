

var fusionCharts = new Charts();

var fusionChartObjects;
var chartWidth = 0;
var chartHeight = 0;

callOnLoad(init);

function init(){
	
	var srcStr = decodeURIComponent(window.location.search);
	contPath = _app_params.ctxPath;	
	caption_title = getParamFromUrl(srcStr,"title");
	
	chart_type = getParamFromUrl(srcStr,"chartType");
	defChartType = getParamFromUrl(srcStr,"defChartType");
	defFontSie = getParamFromUrl(srcStr,"defFontSie");
	defcolunmCheck = getParamFromUrl(srcStr,"defcolunmCheck");

	
	FCharts_LabelsData_cols =  getParamFromUrl(srcStr,"FCharts_LabelsData_cols").split(',');
	FCharts_LabelsData_parentYAxisP =  getParamFromUrl(srcStr,"FCharts_LabelsData_parentYAxisP").split(',');
	FCharts_LabelsData_parentYAxisS =  getParamFromUrl(srcStr,"FCharts_LabelsData_parentYAxisS").split(',');
	
	
	topToolbar =  parent.module_chart_service_win.getTopToolbar();
	footerToolbar =  parent.module_chart_service_win.getFooterToolbar();

	add_topToolbar();
	
	resetHeigth();
	
	
	$("caption").value = caption_title;
	

    
    //加载时就获得所有数据
	getFusionChartObjects();
	
}

function add_topToolbar(){


	var chartTypeCommand = fusionCharts.makeStyleCommand(null,"chartType",120,defChartType,1,true);
	var colunmCheckCommand = fusionCharts.makeColunmCheck(null,"clums2",120,defcolunmCheck,true,true);	
	var fontSizeCommand = fusionCharts.makeFontSizeCommand(null,"baseFontSize",80,defFontSie,1,true);	
	var changeCap = {text: '换标题',handler: function(){replaceCaption();} };	
	var showValues = {xtype:"checkbox", id:"showValues",boxLabel:"值显示 ",handler: function(e,v){renderFromQS();}};
	
	 
	 
 	var btnClose = {text: '关闭',handler: function(){parent.module_chart_service_win.destroy();} };	

 	topToolbar.add(['样式:',chartTypeCommand,"-",'字体:',fontSizeCommand,"-",showValues,"-",colunmCheckCommand,"-",changeCap]);
 	footerToolbar.add(['->',btnClose]);
 	topToolbar.doLayout();
    footerToolbar.doLayout();
    
    var colunmCheckCmd = topToolbar.getComponent("clums2");
  
	colunmCheckCmd.selectAll();
	colunmCheckCmd.setRawValue("请选择列...");
//	colunmCheckCmd.on("select" , function(box) {renderFromQS();} );   
 	
}




  function replaceCaption() {
        var caption = window.prompt("请输入新标题如果有子标题请用逗号隔开","");
        $("caption").value = caption;
        renderFromQS();
  }
  
//显示修改历史记录
function showMax(){
	openHelloWindow22($("chartdiv").innerHTML);
}	
	



function getFusionChartObjects(){

	function func(objs){
		fusionChartObjects = objs;
		renderFromQS();
	}

	var param =  $H(parent._gobal_query_param).toQueryString();
	FusionChartsManager.getChartObjs(param,3,func);
}

function resetHeigth(){
	chartWidth = parent.module_chart_service_win.getInnerWidth()-10;
	chartHeight = parent.module_chart_service_win.getInnerHeight()-10;
    var chartdiv = $("chartdiv");
    chartdiv.style.width = chartWidth +"px";	
    chartdiv.style.height = chartHeight +"px";	

} 


function buildCustomXML(){
	var customXML ="";
	
   customXML ="<styles>"
      customXML +="<definition>";
         customXML +="<style name='myFont' type='font' isHTML='1' bold='1' size='15' color='333333' />";
         customXML +="<style name='myShadow' type='shadow' color='333333' angle='45' strength='2'/>";
      customXML +="</definition>";
      customXML +="<application>";
         //customXML +="<apply toObject='YAxisValues' styles='myFont,myShadow' />";
         //customXML +="<apply toObject='DataLabels' styles='myFont,myShadow' />";
        // customXML +="<apply toObject='DataValues' styles='myFont,myShadow' />";
         customXML +="<apply toObject='Caption' styles='myFont,myShadow' />";
      customXML +="</application>";
   customXML +="</styles>";
   
	return customXML;
}


function renderFromQS(){
	var FCharts = new Charts();
	//chart属性
	FCharts.Chart.objs = fusionChartObjects;
	FCharts.Chart.transparent = "fasle" //true>>transparent false>>Opaque 
	FCharts.Chart.name = "myChart";
	FCharts.Chart.chartdiv = "chartdiv";
	FCharts.Chart.contPath = contPath;
	FCharts.Chart.chartType = topToolbar.getComponent("chartType").getValue();
	FCharts.Chart.chartWidth = chartWidth;
	FCharts.Chart.chartHeight = chartHeight;
	FCharts.Chart.imageSave = 1;
	FCharts.Chart.imageSaveURL = contPath+"fusionChartsSave";
	FCharts.Chart.customXML = buildCustomXML(); //自定义风格

	//chart参数
	//labelDisplay='WRAP'
	//labelDisplay='ROTATE'
	//labelDisplay='Rotate' slantLabels='1'
	//labelDisplay='Stagger' staggerLines='n' caption
	var captions =  ($("caption").value).split(",");
	var caption ="";var subCation ="";
	if(!isUndefined(captions[0])) caption = captions[0];
	if(captions.length >1) subCation = captions[1];
	
	FCharts.ChartParams.caption = caption; 
	FCharts.ChartParams.subCaption = subCation;
	FCharts.ChartParams.labelDisplay = "WRAP";
	FCharts.ChartParams.slantLabels = 5;
	FCharts.ChartParams.baseFontSize =  topToolbar.getComponent("baseFontSize").getValue();
	FCharts.ChartParams.showValues = topToolbar.getComponent("showValues").checked == true?1:0;
//	FCharts.ChartParams.bgColor = "FFFFFF";
	

 

	//Data 及 lable 
	//列名
	FCharts.LabelsData.cols = FCharts_LabelsData_cols;
	//显示列
	FCharts.LabelsData.displays = fusionCharts.getDisplay2(topToolbar.getComponent("clums2"),FCharts.LabelsData.cols);
	//alert(z.getSelectedValue());
	//parentYAxis=P
	FCharts.LabelsData.parentYAxisP =  FCharts_LabelsData_parentYAxisP;
	//parentYAxis=S
	FCharts.LabelsData.parentYAxisS = FCharts_LabelsData_parentYAxisS;	

	FCharts.buildFusionCharts();
}

	function saveChart(){
         //Get chart from its ID
         var chartToPrint = getChartFromId("myChart");
         chartToPrint.saveAsImage();
      }


	function printChart(){
		//Get chart from its ID
		var chartToPrint = getChartFromId("chart1Id");
		chartToPrint.print();
	}
	

	
function showHidden(){
	var oDiv = topToolbar.getComponent("clums2").getValue();
	
	var display = !(oDiv.style.visibility == "hidden")
	oDiv.style.visibility = display?"hidden":"visible";
	
}



