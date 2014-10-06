	
callOnLoad(init);	
 
 
 function init(){	
 	
//	resetDialogcontentHeigth();			
	
	window.onresize = function(){
	   var fnc = function(){
//	   	   location.reload();

			try {
				resetDialogcontentHeigth();	
			 	if(!isUndefined(resetHeigth)) resetHeigth();
			 	if(!isUndefined(resetHeigth1)) resetHeigth1();
			} catch (e) {
//				alert(e.name + " : " + e.message); 
			} 
           
	   }
	   setTimeout(fnc,0);
	}
	
	var Btn_logout = $("main_body_close_id");
	Btn_logout.setAttribute("href","javascript:void 0");
	Btn_logout.onclick = function(){
		
		Ext.MessageBox.confirm('系统提示', '请确认是否退出系统？', function(btn) {
 			  if (btn == 'yes') {
 				 var ctxPath = getCtxPath();
 				 window.location.href = ctxPath + 'logout.jsp';
              }
		 });		

	};
	
			
 }
 

function resetDialogcontentHeigth(){
 //self.moveTo(0,0)
//self.resizeTo(screen.availWidth,screen.availHeight)

var dialogcontent = $("dialogcontentDiv");
var hdiff,wdiff;
if(self.innerHeight){ 
 hdiff = screen.availHeight - self.innerHeight; 
 wdiff = screen.availWidth - self.innerWidth; 
} else { 
 hdiff = screen.availHeight - document.documentElement.offsetHeight; 
 wdiff = screen.availWidth - document.documentElement.offsetWidth; 
} 

var r = getAbsolutePos(dialogcontent);

//var y = screen.availHeight - hdiff - r.y;
var y = screen.availHeight - hdiff - r.y*1.8;

//alert(window.innerHeight);
//alert(document.documentElement.offsetHeight);

//dialogcontent.style.height =  document.documentElement.offsetHeight +"px"; 
dialogcontent.style.height =  y +"px"; 

}  
