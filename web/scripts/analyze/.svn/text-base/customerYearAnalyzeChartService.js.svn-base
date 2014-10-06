var fusionCharts = new Charts();
var fusionChartObjects;
var fChartObjArray = new Array();
var contPath;
var chartWidth = 0;
var chartHeight = 0;
var financeTarget = new FinanceTarget();

callOnLoad(init);

function init(){
	
	contPath = _app_params.ctxPath;	 	
	
	resetHeigth();
	
	
	$("caption").value = "客户年度对比统计";
	
	financeTarget.getCustomerYearRelPut(financeTarget,BackFun);
}

function BackFun(objs){
 		    size = objs.tarMonths.length;
 		    
 		    financeTarget.heads = "";
 		   
 		    for(var i = 0 ;i < size;i++){
 		    	financeTarget.heads +=objs.tarMonths[i];
 		    	if(i< size-1){
 		    		 financeTarget.heads +=",";
 		    		 
 		    		}
 		    }
 
 
	
	fusionCharts.makeColunmCheck("clums","clums2",100,financeTarget.heads,true);
		
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
//		putobjsToArray(objs);
	}

//	var srcStr = decodeURI(window.location.search);
	var srcStr = unescape(window.location.search);
	
	var type = getParamFromUrl(srcStr,"type");
	var customerId = getParamFromUrl(srcStr,"customerId");
	var size = getParamFromUrl(srcStr,"size");
	var isPutYear = getParamFromUrl(srcStr,"isPutYear");
	var channelModelParam = getParamFromUrl(srcStr,"channelModelParam");
	var userName = getParamFromUrl(srcStr,"theUser");
	var purpose = getParamFromUrl(srcStr,"incomPurs");
	var isNotReturnValue = getParamFromUrl(srcStr,"returnValue");
	
	FusionChartsManager.getCustomerYearChartObjs(channelModelParam,size,type,isPutYear,isNotReturnValue,customerId,userName,purpose,func);
 	
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
	FCharts.Chart.dataDrill = true; //
	

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
	
	FCharts.LabelsData.parentYAxisP = new Array();
	FCharts.LabelsData.cols = new Array();
	var heads = financeTarget.heads.split(",");
	FCharts.LabelsData.cols.push("客户名称");
	for(var i = 0;i<heads.length;i++){
		//parentYAxis=P
		FCharts.LabelsData.parentYAxisP.push(i+1);
		FCharts.LabelsData.cols.push(heads[i]);
		
	}
    
	//显示列
	FCharts.LabelsData.displays = fusionCharts.getDisplay("clums2",FCharts.LabelsData.cols);
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


function myDrill(id){
  var objs = fChartObjArray[id].objs;
  var name ="myChart2"
  var divName = "chartdiv2";
  renderFromQS(objs,name,divName);
  openHelloWindow22($(divName).innerHTML);
}
	
