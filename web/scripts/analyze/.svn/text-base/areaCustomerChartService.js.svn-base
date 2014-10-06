var fusionCharts = new Charts();
var fusionChartObjects;
var fChartObjArray = new Array();
var ctxPath;
var chartWidth = 0;
var chartHeight = 0;
callOnLoad(init);

function init(){
	
	ctxPath =  _app_params.ctxPath;
	resetHeigth();
	getFusionChartObjects();
}

function getFusionChartObjects(){

	function func(objs){
		fusionChartObjects = objs;
		buildFusionCharts();
		putobjsToArray(objs);
	}
	var srcStr = unescape(window.location.search);
	
	var beginDate = getParamFromUrl(srcStr,"beginDate");
	var endDate = getParamFromUrl(srcStr,"endDate");
	var userId = getParamFromUrl(srcStr,"userId");
	var carrierIds = getParamFromUrl(srcStr,"carrierIds").split(",");
	var userName = getParamFromUrl(srcStr,"userName");
	var isPrint = getParamFromUrl(srcStr,"isPrint");
	var channelModelParam = getParamFromUrl(srcStr,"channelModelParam");
	
	FusionChartsManager.getAreaCustomerChartObjs(carrierIds,0,beginDate,endDate,userId,userName,isPrint,func);
}

function resetHeigth(){
    var dialogcontent = $("dialogcontentDiv");
    var chartdiv = $("chartdiv");
    chartdiv.style.height = dialogcontent.offsetHeight * 0.85 +"px";	
    chartWidth = chartdiv.offsetWidth;
	chartHeight = chartdiv.offsetHeight;
}

function buildFusionCharts(){
		var chart = new FusionMaps(ctxPath + "scripts/fusionCharts/fresh/FCMap_China2.swf", "Map1Id", "500", "413", "0", "0");
		chart.setDataXML(getDataXML(fusionChartObjects));	
		chart.render($("chartdiv"));		
  }
function getDataXML(objs){
var xml="<map borderColor='005879' fillColor='D7F4FF'  includeValueInLabels='1' labelSepChar=': ' baseFontSize='10' unescapeLinks='0'>";
    xml +="<entityDef><entity internalId='CN.BJ'  newId='BJ' sName='北京' lName='北京市'/><entity internalId='CN.AH'  newId='AH' sName='安徽' lName='安徽省'/><entity internalId='CN.CQ'  newId='CQ' sName='重庆' lName='重庆市'/><entity internalId='CN.GS'  newId='GS' sName='甘肃' lName='甘肃省'/><entity internalId='CN.GD'  newId='GD' sName='广东' lName='广东省'/><entity internalId='CN.GX'  newId='GX' sName='广西' lName='广西'/><entity internalId='CN.GZ'  newId='GZ' sName='贵州' lName='贵州省'/><entity internalId='CN.HA'  newId='HA' sName='海南' lName='海南省'/><entity internalId='CN.HB'  newId='HB' sName='河北' lName='河北省'/><entity internalId='CN.HE'  newId='HE' sName='河南' lName='河南省'/><entity internalId='CN.HU'  newId='HU' sName='湖北' lName='黑龙江省'/><entity internalId='CN.HL'  newId='HL' sName='黑龙江' lName='黑龙江省'/><entity internalId='CN.HN'  newId='HN' sName='湖南' lName='湖南省'/><entity internalId='CN.JS'  newId='JS' sName='江苏' lName='江苏省'/><entity internalId='CN.JX'  newId='JX' sName='江西' lName='江西省'/><entity internalId='CN.JL'  newId='JL' sName='吉林' lName='吉林省'/><entity internalId='CN.LN'  newId='LN' sName='辽宁' lName='辽宁省'/><entity internalId='CN.NM'  newId='NM' sName='内蒙' lName='内蒙'/><entity internalId='CN.NX'  newId='NX' sName='宁夏' lName='宁夏'/><entity internalId='CN.QH'  newId='QH' sName='青海' lName='青海省'/><entity internalId='CN.SA'  newId='SA' sName='陕西' lName='陕西省'/><entity internalId='CN.SD'  newId='SD' sName='山东' lName='山东省'/><entity internalId='CN.SH'  newId='SH' sName='上海' lName='上海市'/><entity internalId='CN.SX'  newId='SX' sName='山西' lName='山西省'/><entity internalId='CN.SC'  newId='SC' sName='四川' lName='四川省'/><entity internalId='CN.TJ'  newId='TJ' sName='天津' lName='天津市'/><entity internalId='CN.XJ'  newId='XJ' sName='新疆' lName='新疆'/><entity internalId='CN.XZ'  newId='XZ' sName='西藏' lName='西藏'/><entity internalId='CN.YN'  newId='YN' sName='云南' lName='云南省'/><entity internalId='CN.ZJ'  newId='ZJ' sName='浙江' lName='浙江省'/><entity internalId='CN.MA'  newId='MA' sName='澳门' lName='澳门'/><entity internalId='CN.HK'  newId='HK' sName='香港' lName='香港'/><entity internalId='CN.TA'  newId='TA' sName='台湾' lName='台湾'/><entity internalId='CN.FJ'  newId='FJ' sName='福建' lName='福建省'/></entityDef>";
    xml +="<data>";
    for(var i=0;i< objs.length;i++){
    	    var id = objs[i].id;
			var lable = objs[i].lable;
			//eval("var value = objs[i].value"+ p);
			var value = objs[i].value1
            xml +="<entity id=\""+ id + "\" value=\""+ value +"\" displayValue='"+lable+"'  link=\"JavaScript:myDrill('"+ id +"');\" />";
           	
    }
	xml +="</data>";
	xml +="<styles><definition><style name='TTipFont' type='font' isHTML='1'  color='FFFFFF' bgColor='666666' size='11'/><style name='HTMLFont' type='font' color='333333' borderColor='CCCCCC' bgColor='FFFFFF'/><style name='myShadow' type='Shadow' distance='1'/></definition><application><apply toObject='MARKERS' styles='myShadow' /> <apply toObject='MARKERLABELS' styles='HTMLFont,myShadow' /><apply toObject='TOOLTIP' styles='TTipFont' /></application></styles>";
	xml +="</map>";	
	return xml;
}

function putobjsToArray(objs) {
    	for(var i =0;i< objs.length;i++){
    		fChartObjArray[objs[i].id] = objs[i];	
    	}
 }


function myDrill(id){

  var objs = fChartObjArray[id].objs;
  var divName = "chartdiv2";
  PieChartChild(objs,divName);
  //openHelloWindow22($(divName).innerHTML);
}
  
function PieChartChild(objs,divName){

		var dataXML = PieChartChildXml(objs);
	
		var chart = new FusionCharts(ctxPath+"scripts/fusionCharts/fresh/Pie2D.swf","ChartId" , "400" , "400", "0", "1" );
//		chart.setTransparent(true);
		chart.setDataXML(dataXML);	
		chart.render("chartdiv2");			
  }
function PieChartChildXml(objs){
var xml="<chart showNames='1' decimalPrecision='0'>";
    for(var i=0;i< objs.length;i++){
	var lable = objs[i].lable;
	//eval("var value = objs[i].value"+ p);
	var value = objs[i].value1
	xml +="<set label='"+lable+"' value='"+value+"'/>";	
    }
    xml +="</chart>";
    return xml;
}