//  <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/winjs/theme.css'/>" /> 
//  <script type="text/javascript" src="<c:url value='/scripts/winjs/prototype.js'/>"></script>
//  <script type="text/javascript" src="<c:url value='/scripts/winjs/effects.js'/>"></script -->
//  <script type="text/javascript" src="<c:url value='/scripts/winjs/window.js'/>"></script>
//  <script type="text/javascript" src="<c:url value='/scripts/winjs/window_ext.js'/>"></script>
//  <script type="text/javascript" src="<c:url value='/scripts/winjs/window_effects.js'/>"></script>
//  <script type="text/javascript" src="<c:url value='/scripts/winjs/debug.js'/>"></script>

function showWin(urlStr) {
	win = new Window({url: urlStr, className: "spread", title: "Sample4", width:600, height:400, top:70, left:800,destroyOnClose: true, recenterAuto:false});	
        win.showCenter(); 
        WindowCloseKey.init(); 
            
} 
 function openDialog1(urlStr) {
  	Dialog.alert({url: urlStr, options: {method: 'pos'}}, 
            {className: "alphacube", width:540, okLabel: "Close"}); 
        WindowCloseKey.init(); 
            
} 
//<style>
//
//    .popup_effect1 {
//      background:#11455A;
//      opacity: 0.2;
//    }
//    .popup_effect2 {
//      background:#FF0041;
//      border: 3px dashed #000;
// 
//</style>
 function openDialog2(html,urlStr) {
  var effect = new PopupEffect(html, {className: "popup_effect1"});
  	Dialog.alert({url: urlStr, options: {method: 'get'}}, 
            {className: "alphacube", width:540, okLabel: "Close", showEffect:effect.show.bind(effect), hideEffect:effect.hide.bind(effect)});  
            
} 	