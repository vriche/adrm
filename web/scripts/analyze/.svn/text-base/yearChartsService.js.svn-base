

var fusionCharts = new Charts();
var fusionChartObjects;
var contPath;
var chartWidth = 0;
var chartHeight = 0;

callOnLoad(init);

function init(){
	
	contPath =  _app_params.ctxPath;	
	
	resetHeigth();
	
	
	$("caption").value = "客户全年统计";
	
	//如果 args2="" 则不显示
	var  args2 ="到账金额,投放金额,分配金额,欠款,时间";

    fusionCharts.makeColunmCheck("clums","clums2",100,args2,true);
	
	var defChartType = "scrollcombidy2d";
	fusionCharts.makeStyleCommand($("chartTypeDiv"),"chartType",100,defChartType);
	
	var defFontSie = "12";
	fusionCharts.makeFontSizeCommand($("baseFontSizeDiv"),"baseFontSize",50,defFontSie);
    
    //加载时就获得所有数据
	getFusionChartObjects();
	
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

//	var srcStr = decodeURI(window.location.search);
	var srcStr = unescape(window.location.search);
	
	var year = getParamFromUrl(srcStr,"year");
	var type = getParamFromUrl(srcStr,"type");
	var sortStr = getParamFromUrl(srcStr,"sortStr");
	var putYear = getParamFromUrl(srcStr,"putYear");
	var userId = getParamFromUrl(srcStr,"userId");
	var carrierName = getParamFromUrl(srcStr,"carrierName");
	var customerId = getParamFromUrl(srcStr,"customerId").split(",");
	var channelModelParam = getParamFromUrl(srcStr,"channelModelParam");
	var theUser = getParamFromUrl(srcStr,"theUser");
	var incomPurs = getParamFromUrl(srcStr,"incomPurs");
	var returnValue = getParamFromUrl(srcStr,"returnValue");
	var resourceTypeId = getParamFromUrl(srcStr,"resourceTypeId");
	var orgId = getParamFromUrl(srcStr,"orgId");

	
	FusionChartsManager.getYearChartObjs(orgId,resourceTypeId,year,type,sortStr,putYear,userId,carrierName,customerId,channelModelParam,theUser,incomPurs,returnValue,func);
 	
}

function resetHeigth(){
    var dialogcontent = $("dialogcontentDiv");
    var chartdiv = $("chartdiv");
    chartdiv.style.height = dialogcontent.offsetHeight * 0.85 +"px";	
    chartWidth = chartdiv.offsetWidth;
	chartHeight = chartdiv.offsetHeight;
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
	FCharts.Chart.chartType = $("chartType").value;
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
	FCharts.ChartParams.baseFontSize = $("baseFontSize").value; 
	FCharts.ChartParams.showValues = $("showValues").checked == true?1:0;
	
    
	
	//Data 及 lable 
	//列名
	FCharts.LabelsData.cols =["客户名称","到账金额","投放金额","分配金额","欠款","时间"];
	//显示列
	FCharts.LabelsData.displays = fusionCharts.getDisplay("clums2",FCharts.LabelsData.cols);
	//parentYAxis=P
	FCharts.LabelsData.parentYAxisP = [1,2,3,4];
	//parentYAxis=S
	FCharts.LabelsData.parentYAxisS =[5];	

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
	var oDiv = $("clums2");	
	var display = !(oDiv.style.visibility == "hidden")
	oDiv.style.visibility = display?"hidden":"visible";
	
}
