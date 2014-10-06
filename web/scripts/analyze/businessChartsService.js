

var fusionCharts = new Charts();
var fusionChartObjects;
var contPath;
var chartWidth = 0;
var chartHeight = 0;

callOnLoad(init);

function init(){
	

	contPath =  _app_params.ctxPath;	 	
	resetHeigth();
	
	
	$("caption").value = "业务员统计";
	
	//如果 args2="" 则不显示
	var  args2 ="一月,二月,三月,四月,五月,六月,七月,八月,九月,十月,十一月,十二月";
	
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
	
	var startDate = getParamFromUrl(srcStr,"startDate");
	var endDate = getParamFromUrl(srcStr,"endDate");
	var type = getParamFromUrl(srcStr,"type");
	var sortStr = getParamFromUrl(srcStr,"sortStr");
	var putYear = getParamFromUrl(srcStr,"putYear");
	var isPutOnORIncome = getParamFromUrl(srcStr,"isPutOnORIncome");
	var userId = getParamFromUrl(srcStr,"userId");
	var carrierName = getParamFromUrl(srcStr,"carrierName");
	var channelModelParam = getParamFromUrl(srcStr,"channelModelParam");
	var userName = getParamFromUrl(srcStr,"userName");
	var incomPurs = getParamFromUrl(srcStr,"incomPurs");
	var returnValue = getParamFromUrl(srcStr,"returnValue");
	var orgId = getParamFromUrl(srcStr,"orgId");
//	getBusinessChartObjs(String startDate, String endDate, String type, String sortStr, String theUser, String userId, String carrierName, boolean isPutOnORIncome, int channelModelParam, String isPutYear, String returnValue, String incomPurs) {
	FusionChartsManager.getBusinessChartObjs(orgId,startDate,endDate,type,sortStr,userName,userId,carrierName,isPutOnORIncome,channelModelParam,putYear,returnValue,incomPurs,func);
 	
}

//function resetHeigth(){ 
////    var adResCount = $("adResCount");
////    var carrierTypeTreebox = $("carrierTypeTreebox");
//    var chartdiv = $("chartdiv");
//    
////    adResCount.style.height = winH*0.82 +"px";	
////    carrierTypeTreebox.style.height = winH*0.82 +"px";	
//    chartdiv.style.height = winH * 0.85 +"px";		
//    chartWidth = chartdiv.offsetWidth;
//	chartHeight = chartdiv.offsetHeight;
//} 
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
	//列名 一月,二月,三月,四月,五月,六月,七月,八月,九月,十月,十一月,十二月 
	
	FCharts.LabelsData.cols =["业务员","一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"];
	//显示列
	FCharts.LabelsData.displays = fusionCharts.getDisplay("clums2",FCharts.LabelsData.cols);
	//parentYAxis=P
	FCharts.LabelsData.parentYAxisP = [1,2,3,4,5,6,7,8,9,10,11,12];
	//parentYAxis=S
	FCharts.LabelsData.parentYAxisS =[];	

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

