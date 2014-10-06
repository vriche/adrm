//inject news headline
var responsecont;
var xmlhttpRequstObj;
var moreProvidersLinks;
var moreProvidersClass;
var moreProvidersDisplay;
var moreLocalNewsProviders;
var localNewsPageLink;
function getnews()
{
   var now=new Date();
   var num=now.getMilliseconds();
   var url = 'http://news.fc510.com/v1/news/modules/news_index/category.aspx?v='+num;
   // Initialize Mozilla XMLHttpRequest object
   if (window.XMLHttpRequest) 
   {
       xmlhttpRequstObj = new XMLHttpRequest();
       xmlhttpRequstObj.onreadystatechange = processRequestChange;
       xmlhttpRequstObj.open("GET", url, true);
       xmlhttpRequstObj.send(null);
   } 
   // Initialize for IE/Windows ActiveX version
   else if (window.ActiveXObject) 
   {
       xmlhttpRequstObj = new ActiveXObject("Microsoft.XMLHTTP");
       if (xmlhttpRequstObj) 
       {
           xmlhttpRequstObj.onreadystatechange = processRequestChange;
           xmlhttpRequstObj.open("GET", url, true);
           xmlhttpRequstObj.send();
       }
   }
}

function processRequestChange() 
{
   // only if xmlhttpRequstObj shows "complete"
   if (xmlhttpRequstObj.readyState == 4) 
   {
      // only http 200 to process
      if (xmlhttpRequstObj.status == 200) 
      {
         var newsstring = xmlhttpRequstObj.responseText;
         //inject centent to tab-pane
         if (newsstring.length > 200)
         {
            shownews(newsstring);
         }
      }
   }
}

function shownews(newsstring){
//<![CDATA[
    responsecont = document.createElement('div');
    responsecont.innerHTML = newsstring;

    var mstrresponse = responsecont.innerHTML;
    var homecont = document.getElementById('tabcontainer');
    
    homecont.innerHTML= mstrresponse;
    
    //cycle through containers and fix tabs
    var homecontarr = homecont.getElementsByTagName('div');
		
		//resort tab-pane
		setupAllTabs();
//]]>
}


function makexmlo(){
    if(window.ActiveXObject){
        //IE 
        var xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
    }else if(window.XMLHttpRequest){
        //Firefox
        var xmlhttp = new XMLHttpRequest();    
    }
    return xmlhttp;
}

/**
 * Get an element by ID regardless of browser type.
 *
 * id value of "id" attribute of element
 */
function getElement(id) { 
     var element = null;
     try {
         element = document.getElementById(id);
     }
     catch (ex) {
         element = document.all[id];
     }
     return element;
}
//-----------------------------------------------------------------------------
//Inject news preview
var pv_evt, pv_head, pv_path, req, pv_x, pv_y, pv_ok = false, pv_async = true;

function cancelPreview()
{
	try	{
        pv_ok = false;
        tt_Hide();
	}
	catch (ex) {
		//ignore ie error
	}
}

function showPreview(event, headline, path)
{
    pv_evt = event;
    pv_head = headline;
    pv_path = path;
    pv_ok   = true;

    try {
	    pv_x = tt_EvX(event);
      pv_y = tt_EvY(event);
//    alert("event at " + pv_x + ", " + pv_y);
      if (!pv_async){
            tt_go(event, pv_head, req.responseText);
        }else{
            window.setTimeout('getOOTB()', 700);
        }
    }
    catch (ex) {
		// skip if ie error
    }
}

function onPreviewLoaded()
{
    if (pv_async && req.readyState == 4 && req.status == 200 && pv_ok)
    {
       tt_go(pv_evt, pv_head, req.responseText, pv_x, pv_y);
    }
}

function getOOTB(){
	if (!pv_ok)
	return true;
	path = pv_path;
	url = "http://news.fc510.com/v1/news/function/getpreview.aspx?newsid=" + path;
	//Initialize for native XMLHttpRequest object
	if (window.XMLHttpRequest) {
        req = new XMLHttpRequest();
        req.onreadystatechange = onPreviewLoaded;
        req.open("GET", url, pv_async);
        req.send(null);
	} else if (window.ActiveXObject) {
        req = new ActiveXObject("Microsoft.XMLHTTP");
        if (req) {
            req.onreadystatechange = onPreviewLoaded;
            req.open("GET", url, pv_async);
            req.send();
        }
    }
}