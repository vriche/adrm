
//var curPopupWindow = null;
function Popupcenter(){
	this.url = null;
	this.winName = null;
	this.width = null;
	this.height = null;
	this.model = null;
	this.curPopupWindow = null;
	this.returnValues = null;
}
Popupcenter.prototype.browser = function() 
{
  var ua, s, i;

  this.isIE    = false;
  this.isNS    = false;
  this.isOP    = false;
  this.name    = navigator.appName;
  this.version = null;

  ua = navigator.userAgent;
  //alert(navigator.vendor);

  // Firefox:
  // Mozilla/5.0 (Windows; U; Windows NT 5.1; en-US; rv:1.7.10) Gecko/20050716 Firefox/1.0.6

  // Explorer:
  // Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)

  // Opera:
  // Mozilla/4.0 (compatibile; MSIE 6.0; Windows NT 5.1; en) Opera 8.50

  if ((navigator.userAgent).indexOf("Opera")!=-1)
  {
    this.isOP = true;
  } else
  if (navigator.appName=="Netscape")
  {
    this.isNS = true;
    //s = "Netscape6/";
    //this.version = parseFloat(ua.substr(i + s.length));
  } else
  if ( (navigator.appName).indexOf("Microsoft") != -1 )
  {
    this.isIE = true;
    //s = "MSIE";
    //this.version = parseFloat(ua.substr(i + s.length));
  }

  return;
}   
//Popupcenter.prototype.popupcenter = function( url, winName, width, height) 
Popupcenter.prototype.popupcenter = function(o) 
	{
		xposition=0; yposition=0;
		if ((parseInt(navigator.appVersion) >= 4 ))
		{
		xposition = (screen.width - o.width) / 2;
		yposition = (screen.height - o.height) / 2+10;
		}
		theproperty= "width=" + o.width + "," 
		+ "height=" + o.height + "," 
		+ "location=0," 
		+ "menubar=0,"
		+ "resizable=1,"
		+ "scrollbars=1,"
		+ "status=0," 
		+ "titlebar=1,"
		+ "toolbar=0,"
		+ "hotkeys=0,"
		+ "screenx=" + xposition + "," //仅适用于Netscape
		+ "screeny=" + yposition + "," //仅适用于Netscape
		+ "left=" + xposition + "," //IE
		+ "top=" + yposition; //IE 
		o.curPopupWindow=window.open( o.url,o.winName,theproperty );
		o.curPopupWindow.focus();
}

//Popupcenter.prototype.popupcenterwithbar = function( url, winName, width, height) 	
Popupcenter.prototype.popupcenterwithbar = function(o) 
	{
		xposition=0; yposition=0;
		if ((parseInt(navigator.appVersion) >= 4 ))
		{
		xposition = (screen.width - o.width) / 2;
		yposition = (screen.height - o.height) / 2 -30 ;
		}
		theproperty= "width=" + o.width + "," 
		+ "height=" + (o.height-yposition*2) + "," 
		+ "location=0," 
		+ "menubar=1,"
		+ "resizable=1,"
		+ "scrollbars=1,"
		+ "status=1," 
		+ "titlebar=1,"
		+ "toolbar=1,"
		+ "hotkeys=0,"
		+ "screenx=" + xposition + "," //仅适用于Netscape
		+ "screeny=" + yposition + "," //仅适用于Netscape
		+ "left=" + xposition + "," //IE
		+ "top=" + yposition; //IE 
		o.curPopupWindow=window.open( o.url,o.winName,theproperty );
		o.curPopupWindow.focus();
	}
  
  
//Popupcenter.prototype.popupcenter = function(url,model)   
Popupcenter.prototype.popupcenter = function(o) 
	{
		
		this.closePopup(o);
		
		winName = 'showdialog';
		
		switch(o.model){ 
			case 1: 
				width = 100;Height =50;
				break; 
			case 2: 
				width = 200;Height =100;
				break; 
			case 3: 
				width = 300;Height =200;
				break; 
			case 4: 
				width = 400;Height =200;
				break; 				
			case 5: 
				width = 500;Height = 300;
				break; 
			case 6: 
				width = 600;Height = 400;
				break; 	
			case 7: 
				width = 700;Height = 500;
				break; 				
			case 8: 
				width = 800;Height = 600;
				break; 	
			case 9: 			
				width = 900;Height = 700;
				break; 	
			case 10: 			
				width = 1000;Height = 800;
				break; 	
			case 11: 			
				width = 1000;Height = 600;
				break; 										
			default :
				width = screen.width;Height = screen.height;
		}
		
		
		xposition=0; yposition=0;
		if ((parseInt(navigator.appVersion) >= 4 ))
		{
		xposition = (screen.width - width) / 2;
		yposition = (screen.height - Height) / 2+10;
		}
		
		theproperty= "width=" + width + "," 
		
		+ "height=" + Height + "," 
		+ "location=0," 
		+ "menubar=0,"
		+ "resizable=1,"
		+ "scrollbars=1,"
		+ "status=0," 
		+ "titlebar=1,"
		+ "toolbar=0,"
		+ "hotkeys=0,"
		+ "screenx=" + xposition + "," //仅适用于Netscape
		+ "screeny=" + yposition + "," //仅适用于Netscape
		+ "left=" + xposition + "," //IE
		+ "top=" + yposition; //IE 
		o.curPopupWindow=window.open( o.url,winName,theproperty );
		o.curPopupWindow.focus();
		
	}
	
Popupcenter.prototype.closePopup = function(o) {

	
	if (o.curPopupWindow != null) {
		if (!o.curPopupWindow.closed) {
		   o.curPopupWindow.close();
		}
	    o.curPopupWindow = null;
	}

}


	