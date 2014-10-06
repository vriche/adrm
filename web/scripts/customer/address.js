

function button_addAddress(){
	
	var s =  checkEeitStates();
	if (!s) return false;

	
	var tddo = document.createElement("td");
	var mytr = addressBody.firstChild;
	if(mytr != "undefined" && mytr != null && mytr !=""){
		var myclass = mytr.getAttribute("class");
		if(myclass =="empty") mytr.remove();		
	}

	var tr = document.createElement('TR');
   
    var td1   = document.createElement('TD');
    var td2   = document.createElement('TD');
    var td3   = document.createElement('TD');
    var td4   = document.createElement('TD');
    var td5   = document.createElement('TD');
    var td6   = document.createElement('TD');
    var td7   = document.createElement('TD');
    
    var inp1  = document.createElement('INPUT'); inp1.setAttribute("id","addressType");
    var inp2  = document.createElement('INPUT'); inp2.setAttribute("id","address");
    var inp3  = document.createElement('INPUT'); inp3.setAttribute("id","city");
    var inp5  = document.createElement('INPUT'); inp5.setAttribute("id","postalCode");
    var inp6  = document.createElement('INPUT'); inp6.setAttribute("id","province");    
    
    var editImg = makeImagHtml("image/save.png","Btn_Save_ID","18","18",0,"button_save_address"); 
    var cannelImg = makeImagHtml("image/restore.png","Btn_Cannel_ID","18","18",0,"button_cannel_address"); 
    
    cannelImg.onclick = function(){
    	$("hiddenArea").appendChild($("country"));
    	tr.remove(); 
    	setColors(addressBody,color1,color2);
    }
	tddo.appendChild(editImg);tddo.appendChild(cannelImg);   

    addressBody.appendChild(tr);
    
    tr.appendChild(td1);
    tr.appendChild(td2);
    tr.appendChild(td3);
    tr.appendChild(td4);
    tr.appendChild(td5);
    tr.appendChild(td6);    
    tr.appendChild(td7);  
   
    td1.appendChild(inp1);
    td2.appendChild(inp2);
    td3.appendChild(inp3);
    td4.appendChild($("country"));		
    td5.appendChild(inp5);
    td6.appendChild(inp6);       
    td7.appendChild(tddo);

    setColors(addressBody,color1,color2);
}


function button_save_address(obj) {
	 var customerId = $("customerId").value;
	 
	 if(customerId != ''&& customerId != "-1" && customerId != "null" ){
		 saveAddress(); 	 
	 }else{
	 	alert("请先保存客户的基本信息");
	 }
 	
}
function saveAddress(){
	var obj = DWRUtil.getValues(address);
	obj.id = -1;
	obj.country = $("country").value;
	$("hiddenArea").appendChild($("country"));	
	
	CustomerAddressManager.saveCustomerAddress(obj,getAddress);
}

function button_del_address(obj){
	if (confirmDelete('CustomerAddress')){ 
		var id = obj.getAttribute("paraId");
		$("hiddenArea").appendChild($("country"));
		CustomerAddressManager.removeCustomerAddress(id,getAddress);	   	
	}
}

function getAddress(){
	var s =  checkEeitStates2();
	if (!s) $("hiddenArea").appendChild($("country"));
	
	var customerId = $("customerId").value;
	if(customerId != ''){
		resetAddress();
		address.customerId = customerId;
		CustomerAddressManager.getCustomerAddresss(fillTableAddress,address);
	}
}

function fillTableAddress(addressList) {
	DWRUtil.removeAllRows("addressBody");
	DWRUtil.addRows("addressBody",addressList,cellFunctions_address);
	setColors(addressBody,color1,color2);
}



/***********************obj start*****************/
  var address = 
	{
	id:null,
    addressType:null,
    customerId:null,
    address:null,
    city:null,
    province:null,
    country:null,
    postalCode:null
  };
  
  
  function resetAddress(){
  	address.id = null;
  	address.addressType = null;
  	address.customerId = null;
  	address.address = null;
  	address.city = null;
  	address.province = null;
  	address.country = null;
  	address.postalCode = null;
  }

  
/***********************obj end*******************/
var cellFunctions_address = [
  	function(address) { return address.addressType },
 	function(address) { return address.address },
 	function(address) { return address.city },
    function(address) { return address.country },
  	function(address) { return address.postalCode },
  	function(address) { return address.province },
    function(address) { 
    	var delImg = makeImagHtml("image/button_delete.gif","Bt_deladdress_id","18","18",address.id,"button_del_address"); 
    	var span = document.createElement('span');
    	span.appendChild(delImg);
    	return span.innerHTML;
    } 
];


