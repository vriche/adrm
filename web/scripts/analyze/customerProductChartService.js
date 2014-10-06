var fusionCharts = new Charts();
var fusionChartObjects;
var fChartObjArray = new Array();
var contPath;
var chartWidth = 0;
var chartHeight = 0;

callOnLoad(init);

function init(){
	
	contPath = _app_params.ctxPath;	
	
	resetHeigth();
	
	
	$("caption").value = "�ͻ�Ʒ��Ͷ����ͳ��";
	
	//��� args2="" ����ʾ
	var  args2 ="Ͷ�Ž��,������,Ͷ��ʱ��";
	fusionCharts.makeColunmCheck("clums","clums2",100,args2,true);
	
	var defChartType = "scrollcombidy2d";
	fusionCharts.makeStyleCommand($("chartTypeDiv"),"chartType",100,defChartType);
	
	var defFontSie = "12";
	fusionCharts.makeFontSizeCommand($("baseFontSizeDiv"),"baseFontSize",50,defFontSie);
    
    //����ʱ�ͻ����������
	getFusionChartObjects();
	
}

	function putobjsToArray(objs) {
    	for(var i =0;i< objs.length;i++){
    	fChartObjArray[objs[i].id] = objs[i];
    	}
 	 }

  function replaceCaption() {
        var caption = window.prompt("�������±���������ӱ������ö��Ÿ���","");
        $("caption").value = caption;
        renderFromQS();
  }
  
//��ʾ�޸���ʷ��¼
function showMax(){
	openHelloWindow22($("chartdiv").innerHTML);
}

function getFusionChartObjects(){

	function func(objs){
		fusionChartObjects = objs;
		renderFromQS();
		putobjsToArray(objs);
	}

//	var srcStr = decodeURI(window.location.search);
	var srcStr = unescape(window.location.search);
	
	var beginDate = getParamFromUrl(srcStr,"beginDate");
	var endDate = getParamFromUrl(srcStr,"endDate");
	var userId = getParamFromUrl(srcStr,"userId");
	var carrierIds = getParamFromUrl(srcStr,"carrierIds").split(",");
	var userName = getParamFromUrl(srcStr,"userName");
	var channelModelParam = getParamFromUrl(srcStr,"channelModelParam");
	var isPrint = getParamFromUrl(srcStr,"isPrint");
	
	FusionChartsManager.getCustomerProductChartObjs(carrierIds,channelModelParam,beginDate,endDate,userId,userName,isPrint,func);
 	
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
	//chart����
	FCharts.Chart.objs =isUndefined(objs)?fusionChartObjects:objs;
	FCharts.Chart.transparent = "fasle" //true>>transparent false>>Opaque 
	FCharts.Chart.name = isUndefined(name)?"myChart":name;
	FCharts.Chart.chartdiv = isUndefined(divName)?"chartdiv":divName;
	FCharts.Chart.contPath = contPath;
	FCharts.Chart.chartType = $("chartType").value;
	FCharts.Chart.chartWidth = chartWidth;
	FCharts.Chart.chartHeight = chartHeight;
	FCharts.Chart.imageSave = 1;
	FCharts.Chart.imageSaveURL = contPath+"fusionChartsSave";
	FCharts.Chart.customXML = buildCustomXML(); //�Զ�����
	FCharts.Chart.dataDrill = true; // �к��ӵ�ʱ��ΪTRUE

	//chart����
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
	
    
	
	//Data �� lable 
	//����
	FCharts.LabelsData.cols =["�ͻ�����","Ͷ�Ž��","������","Ͷ��ʱ��"];
	//��ʾ��
	FCharts.LabelsData.displays = fusionCharts.getDisplay("clums2",FCharts.LabelsData.cols);
	//parentYAxis=P
	FCharts.LabelsData.parentYAxisP = [1,2];
	//parentYAxis=S
	FCharts.LabelsData.parentYAxisS =[3];	

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
