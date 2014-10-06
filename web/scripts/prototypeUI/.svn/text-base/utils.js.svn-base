 function runTest() {
 	UI.defaultWM.options.blurredWindowsDontReceiveEvents = true;
//    CSS.preloadImages();
//    openMacWindow();
  } 
            
  function openMacWindow() {      
    new UI.Window({theme: "mac_os_x", shadow: true, width:75, height:100, title: "Hello, PWC!" }).show();
  }                                    
  
  function openHelloWindow()
  {
	var win = new UI.Window({className: "hello", title: "Sample", width:200, height:150, destroyOnClose: true, recenterAuto:false}); 
	win.setPosition(100, 10);
	win.setContent("<h2>Hello, WRT world !!</h2>"); 
	win.show();
  }
  
  function openHelloWindow22(html)
  {
    	var win = new UI.Window({className: "hello", title: "Sample", width:200, height:150, destroyOnClose: true, recenterAuto:false}); 
		win.setContent(html);  
		win.show()
		win.activate();
    	win.maximize();
  } 

  


    	
  function openWindow(id,url,width,height,title,theme,draggable,minimize,maximize,close,resizable) {
      var win = new UI.URLWindow({
      	id:id,
        width: width, 
        height: height,
        shadow: true,
        draggable: draggable,
        minimize: minimize,
        maximize: maximize,
        close: close,
        resizable: resizable,
        activeOnClick: false,
        theme: theme,
        url: url || '../../fixtures/url_content.html' });  
        
	win.setHeader('<strong>'+ title + '</strong>');
	win.center();
 	win.show(true).focus();  
// 	win.observe("hidden", function() {top -= 20; left -= 20})
         //UI.defaultWM.getWindow(win).close();  
  } 
  
    function openWindowDetail(id,url,width,height,title,theme,draggable,minimize,maximize,close,resizable) {
      var win = new UI.URLWindow({
      	id:id,
        width: width, 
        height: height,
        shadow: true,
        draggable: draggable,
        minimize: minimize,
        maximize: maximize,
        close: close,
        resizable: resizable,
        activeOnClick: false,
        theme: theme,
        url: url || '../../fixtures/url_content.html' });  
        
	win.setHeader('<strong>'+ title + '</strong>');
	win.center;
 	win.show(true).focus();  
 	win.observe("hidden", function() {top -= 30;})
         //UI.defaultWM.getWindow(win).close();  
  } 
  
  
  function ajax_test() {
  // Request will take 2 seconds to complete
  Ajax.Request.prototype.originalInitialize = Ajax.Request.prototype.initialize;
  Ajax.Request.prototype.initialize = function(url, options) {
      options.onComplete = options.onComplete.wrap(function(proceed, req) {
        proceed.curry(req).delay(2);
      });
      this.originalInitialize(url, options);
  }

  new UI.Window().show().setAjaxContent('../../fixtures/ajax_content.html', {
    method: "GET", 
    onCreate: function() {   
      this.setContent('<div class="message">Please wait...</div><div class="spinner"></div>');   
    }
  });                 
}
  
  
  function openTableWindow() {
    var w = new UI.Window({width: 200, height: 250, top: 40, left: 10, minWidth: 100, minHeight: 80, maxWidth: 300, maxHeight: 400}).show();  
//    w.content.update("min size: 100x80<br>max size: 300x400")
	
	var cart = new Object();
	cart.items = [ ];
	//putting some sample items in the cart
	cart.items.push({product: 'Book 123', price: 24.50, quantity: 1});
	cart.items.push({product: 'Set of Pens', price: 5.44, quantity: 3});
	cart.items.push({product: 'Gift Card', price: 10.00, quantity: 4});
	
	//here we create our template for formatting each item
	var itemFormat = new Template(
			'<tr> <td>#{product}</td> <td>#{quantity} </td> <td>$#{price} </td>'
			);
	var formatted = '<table border=1> <th>Product</th> <th>Quantity</th> <th>Price</th>';
	
	for(var i=0; i<cart.items.length; i++){
		var cartItem = cart.items[i];
		formatted += itemFormat.evaluate(cartItem) + '\n';
	}
	
	formatted += '</table>';
	
	w.content.update(formatted);
  }  
  
	Event.observe(window, "load", runTest);