
/**
 *
 */
function objectEval(text)
{
    // eval() breaks when we use it to get an object using the { a:42, b:'x' }
    // syntax because it thinks that { and } surround a block and not an object
    // So we wrap it in an array and extract the first element to get around
    // this.
    // The regex = [start of line][whitespace]{[stuff]}[whitespace][end of line]
    text = text.replace(/\n/g, " ");
    text = text.replace(/\r/g, " ");
    if (text.match(/^\s*\{.*\}\s*$/))
    {
        text = "[" + text + "]";
    }

    return eval(text)[0];
}

/**
 *
 */
function callOnLoad(init)
{
	
	
	function init_params(){
			
			try {
				init_app_params(init);
			} catch (e) {
				init();
			} 		
		
		
		
	}
    if (window.addEventListener)
    {
    	window.addEventListener("load", init_params, false);
//        window.addEventListener("load", init, false);
    }
    else if (window.attachEvent)
    {
        window.attachEvent("onload", init_params);
//        window.attachEvent("onload", init);
    }
    else
    {
        window.onload = init_params;
//        window.onload = init;
    }
}

//function callOnFocus(closePopup)
//{
//    if (window.addEventListener)
//    {
//         window.addEventListener("focus", closePopup, false);
//    }
//    else if (window.attachEvent)
//    {
//         window.addEventListener("focus", closePopup, false);
//    }
//    else
//    {
//        window.onfocus = closePopup;
//    }
//}

