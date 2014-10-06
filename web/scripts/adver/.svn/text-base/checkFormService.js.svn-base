var order=new Order();

 var winW;
 var winH;
 callOnLoad(init);	
  
	function init(){
		var srcStr = window.location.href;
		var dateStr = getParamFromUrl(srcStr,"dateStr");
		var resourceIds = getParamFromUrl(srcStr,"resourceIds");
		orgId = getParamFromUrl(srcStr,"orgId");
		winW = getParamFromUrl(srcStr,"winW");
		winH = getParamFromUrl(srcStr,"winH");
		if(winW == null) winW = 1200;
		if(winH == null) winH = 400;
		
		resetHeigth();
	
  	getNoCheckOrders(dateStr,resourceIds,orgId);
  }
  
  function resetHeigth(){
         var gridbox = $("gridbox");
         gridbox.style.width = winW*0.9 +"px";	
         gridbox.style.height = winH*0.82 +"px";
  } 

 function getNoCheckOrders(dateStr,resourceIds,orgId){
	var callback = function(obj){
		var html='<div id="pTime" align="left">';
		html+='<fieldset>';
		html+='<legend></legend>';
		html+='<table><tbody>';
		for(var i=0;i<obj.length;i++){
			html+='<tr><td><a target=_blank href="../editOrder.html?id='+obj[i].id+'&orgId='+orgId+'">'+obj[i].orderCode+'</a></td><td>'+obj[i].orderMeno+obj[i].publishMemo+'</td></tr>';
		}
		html+='</tbody></table></fieldset></div>';
		
		$("gridbox").innerHTML=html;  
	}
	var resourceId=resourceIds.split(',');
	           
  	order.getOrderCodeByCheckState1(3,dateStr,resourceId,callback);
 }
