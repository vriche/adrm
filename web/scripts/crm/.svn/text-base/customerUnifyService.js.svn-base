var customer = new Customer();
var customer2 = new Customer();

callOnLoad(init);	

function resetHeigth(){
	var dialogcontent = $("dialogcontentDiv");
	
	var treebox = $("customerTreebox");
	var treebox2 = $("customer2Treebox");
	treebox.style.height = dialogcontent.offsetHeight*0.82+"px";	 
	treebox2.style.height = dialogcontent.offsetHeight*0.82+"px";	   	  	
	$("customerName").style.width =treebox.offsetWidth*0.74 +"px";
	
} 

function init(){ 
	resetHeigth();	
	buttonEventFill();
	setCustomerPara(customer);
	setCustomerPara2(customer2);
 	//customer.getCustomerAutoComplet(customerAutoComplete,customer.obj);
 	//initGrid_order();
 	//getCustomerTree();
}

function getCustomerTree(fnct){
	var obj_tree = customer.tree.dhtmlTree;
//	obj_tree.setOnClickHandler(doOnSelectedTree);
	obj_tree.enableDragAndDrop(false);	
	obj_tree.enableMercyDrag(true);
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableThreeStateCheckboxes(true);

	function getxml(treeXML){
		obj_tree.deleteChildItems(0);	
		obj_tree.loadXMLString(treeXML);
		if(fnct) fnct();
	} 
	
	customer.reset();
	customer.obj.customerName = $("customerName").value;
	customer.getTreeXML(getxml);
}

function getCustomerTree2(){
	var obj_tree = customer2.tree.dhtmlTree;
	obj_tree.setOnClickHandler(doOnSelectedTree);
	obj_tree.enableDragAndDrop(false);	
	obj_tree.enableMercyDrag(true);
	

	function getxml(treeXML){
		if(obj_tree.getSubItems(0) == 'root'){
			obj_tree.deleteChildItems(0);	
		}
		obj_tree.loadXMLString(treeXML);
	} 
	
	customer2.reset();
	customer2.obj.customerName = $("customerName").value;
	customer2.getTreeXML(getxml);
}


function buttonEventFill(){
	
//	var btn_search = $("search");
//	btn_search.onclick = getCustomerTree;
	
	var btn_unify = $("unify");
	btn_unify.onclick = unify;	

	var Btn_customerName = $("customerName");
	Btn_customerName.onclick = resetText;
	//Btn_customerName.onkeypress = getCustomerTree;
	Btn_customerName.onkeypress = onCustomerNameChange;
	
}
function onCustomerNameChange(ev){
	if(ev.keyCode == 13){
		get2CustomerTree()
	}
}


function get2CustomerTree(){
	getCustomerTree();
	getCustomerTree2();
	
}

	
function resetText(ev){
	 $("customerName").value = null;
	 $("customerId").value = null;
	 $("customerName2").value= null;
}
function unify(ev){
	 var sourId = $("customerId").value;
	 if(sourId == '') return false;
	  
	 var targIds = customer.tree.getAllCheckedBranches(customer.IdPrefix);
	 if(targIds.length == 1) targIds +=",";
	 customer.obj.id = sourId;
	 customer.obj.helpCode = targIds+'';
	 
	function saveFun(){
	 	get2CustomerTree();
	} 
	 
	var ans = confirm("请最后确认是否都统一成《"+ $("customerName2").value +"》");
	if (ans)  customer.saveCustomerUnify(saveFun);

}
function doOnSelectedTree(selectItemId){
	if(selectItemId == 'root') return false;
	
	$("customerId").value =customer2.tree.getIdByPrefix(selectItemId,customer2.IdPrefix);
	$("customerName2").value= customer2.tree.dhtmlTree.getItemText(selectItemId);
		
	var itemId = customer.IdPrefix + $("customerId").value;
	


	
	function removeFun(){
		
		customer.tree.dhtmlTree.deleteItem(itemId);
	} 
	getCustomerTree(removeFun);
	
	
}






function setCustomerPara(obj){
	 obj.className  = "customer";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 		= new Tree(obj.treebox);
}
function setCustomerPara2(obj){
	 obj.className  = "customer2";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 	= new Tree(obj.treebox);
}

