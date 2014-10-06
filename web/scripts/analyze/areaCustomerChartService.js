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
    xml +="<entityDef><entity internalId='CN.BJ'  newId='BJ' sName='����' lName='������'/><entity internalId='CN.AH'  newId='AH' sName='����' lName='����ʡ'/><entity internalId='CN.CQ'  newId='CQ' sName='����' lName='������'/><entity internalId='CN.GS'  newId='GS' sName='����' lName='����ʡ'/><entity internalId='CN.GD'  newId='GD' sName='�㶫' lName='�㶫ʡ'/><entity internalId='CN.GX'  newId='GX' sName='����' lName='����'/><entity internalId='CN.GZ'  newId='GZ' sName='����' lName='����ʡ'/><entity internalId='CN.HA'  newId='HA' sName='����' lName='����ʡ'/><entity internalId='CN.HB'  newId='HB' sName='�ӱ�' lName='�ӱ�ʡ'/><entity internalId='CN.HE'  newId='HE' sName='����' lName='����ʡ'/><entity internalId='CN.HU'  newId='HU' sName='����' lName='������ʡ'/><entity internalId='CN.HL'  newId='HL' sName='������' lName='������ʡ'/><entity internalId='CN.HN'  newId='HN' sName='����' lName='����ʡ'/><entity internalId='CN.JS'  newId='JS' sName='����' lName='����ʡ'/><entity internalId='CN.JX'  newId='JX' sName='����' lName='����ʡ'/><entity internalId='CN.JL'  newId='JL' sName='����' lName='����ʡ'/><entity internalId='CN.LN'  newId='LN' sName='����' lName='����ʡ'/><entity internalId='CN.NM'  newId='NM' sName='����' lName='����'/><entity internalId='CN.NX'  newId='NX' sName='����' lName='����'/><entity internalId='CN.QH'  newId='QH' sName='�ຣ' lName='�ຣʡ'/><entity internalId='CN.SA'  newId='SA' sName='����' lName='����ʡ'/><entity internalId='CN.SD'  newId='SD' sName='ɽ��' lName='ɽ��ʡ'/><entity internalId='CN.SH'  newId='SH' sName='�Ϻ�' lName='�Ϻ���'/><entity internalId='CN.SX'  newId='SX' sName='ɽ��' lName='ɽ��ʡ'/><entity internalId='CN.SC'  newId='SC' sName='�Ĵ�' lName='�Ĵ�ʡ'/><entity internalId='CN.TJ'  newId='TJ' sName='���' lName='�����'/><entity internalId='CN.XJ'  newId='XJ' sName='�½�' lName='�½�'/><entity internalId='CN.XZ'  newId='XZ' sName='����' lName='����'/><entity internalId='CN.YN'  newId='YN' sName='����' lName='����ʡ'/><entity internalId='CN.ZJ'  newId='ZJ' sName='�㽭' lName='�㽭ʡ'/><entity internalId='CN.MA'  newId='MA' sName='����' lName='����'/><entity internalId='CN.HK'  newId='HK' sName='���' lName='���'/><entity internalId='CN.TA'  newId='TA' sName='̨��' lName='̨��'/><entity internalId='CN.FJ'  newId='FJ' sName='����' lName='����ʡ'/></entityDef>";
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