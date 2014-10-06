

var fusionCharts = new Charts();
var fusionChartObjects;
var fChartObjArray = new Array();
var contPath;
var chartWidth = 0;
var chartHeight = 0;
var relHeader = [];
var parentYAxisP=[];

callOnLoad(init);

function init(){
	
	contPath =  _app_params.ctxPath;	
	
	resetHeigth();
	
	
	$("caption").value = "品牌投播情况表";
	
	//如果 args2="" 则不显示
	var  args2 ="";
	var srcStr = decodeURI(decodeURI(window.location.search));
	
	var headers = getParamFromUrl(srcStr,"headers");
	var displaySumColum =  getParamFromUrl(srcStr,"displaySumColum");
	
	var display = displaySumColum.split('%2C');
	var header = headers.split('%2C');
	
	for(var i =0;i<display.length;i++){
		if(display[i]==1){
			relHeader.push(header[i]);
		}
	}
	  
	args2 =relHeader.join(',');//"投放金额,一套,二套,三套,四套,五套,分配金额,投放时长";
	
	relHeader.unshift("行业");

	for(var i=1;i<relHeader.length-1;i++){
		parentYAxisP.push(i);
	}
	
	fusionCharts.makeColunmCheck("clums","clums2",100,args2,true);
	
	var defChartType = "scrollcombidy2d";
	fusionCharts.makeStyleCommand($("chartTypeDiv"),"chartType",100,defChartType);
	
	var defFontSie = "12";
	fusionCharts.makeFontSizeCommand($("baseFontSizeDiv"),"baseFontSize",50,defFontSie);
    
    //加载时就获得所有数据
	getFusionChartObjects();
	
}

  function putobjsToArray(objs) {
    for(var i =0;i< objs.length;i++){
    	fChartObjArray[objs[i].id] = objs[i];
    }
  }

  function replaceCaption() {
        var caption = window.prompt("请输入新标题如果有子标题请用逗号隔开","");
        $("caption").value = caption;
        renderFromQS();
  }
  
//显示修改历史记录
function showMax(){
	//openHelloWindow();
}

function getFusionChartObjects(){

	function func(objs){
		fusionChartObjects = objs;
		renderFromQS();
		putobjsToArray(objs);
	}

//	var srcStr = decodeURI(window.location.search);
	var srcStr = unescape(window.location.search);

	FusionChartsManager.getIndustryProductChannelChartObjs(srcStr,'chart',func);
 	
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


function renderFromQS(objs,name,divName){
	 var FCharts = new Charts();
	//chart属性
	FCharts.Chart.objs =isUndefined(objs)?fusionChartObjects:objs;
	FCharts.Chart.transparent = "fasle" //true>>transparent false>>Opaque 
	FCharts.Chart.name = isUndefined(name)?"myChart":name;
	FCharts.Chart.chartdiv = isUndefined(divName)?"chartdiv":divName;
	
	//alert(FCharts.Chart.name);alert(FCharts.Chart.chartdiv);
	FCharts.Chart.contPath = contPath;
	FCharts.Chart.chartType = $("chartType").value;
	FCharts.Chart.chartWidth = chartWidth;
	FCharts.Chart.chartHeight = chartHeight;
	FCharts.Chart.imageSave = 1;
	FCharts.Chart.imageSaveURL = contPath+"fusionChartsSave";
	FCharts.Chart.customXML = buildCustomXML(); //自定义风格

	FCharts.Chart.dataDrill = true

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
//	var srcStr = unescape(window.location.search);
//	var type = getParamFromUrl(srcStr,"type");
	
	FCharts.LabelsData.cols =relHeader; //["行业","投放金额","一套","二套","三套","四套","五套","分配金额","投放时长"];
		//parentYAxis=P

	FCharts.LabelsData.parentYAxisP = parentYAxisP;   
	//parentYAxis=S
	FCharts.LabelsData.parentYAxisS =[relHeader.length-1];	    
	
	//显示列
	FCharts.LabelsData.displays = fusionCharts.getDisplay("clums2",FCharts.LabelsData.cols);
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


function myDrill(id){
  var objs = fChartObjArray[id].objs;
  var name ="myChart2"
  var divName = "chartdiv2";
  renderFromQS(objs,name,divName);
  openHelloWindow22($(divName).innerHTML);
}
	
