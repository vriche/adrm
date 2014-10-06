var category = new Category();
var customer = new Customer();

callOnLoad(init);

function init(){
	setCategoryPara(category);
	setCustomerPara(customer);
	resetHeigth();
	
	getCustomerCategoryTree(category);
	buttonEventFill(); 
	
	userId = getParentUserIdByURL();

}
function getParentUserIdByURL(){
	var url = window.location.href;
	var startPos = url.indexOf("=");
	var endPos = url.length;
	var id = null;
	id = url.substring(startPos+1,endPos)*1
	return  id;
}
function setCategoryPara(obj){
	 obj.className ="category";
	 obj.IdPrefix 	= obj.className + "Id";
	 obj.treebox	= obj.className + "Treebox";
	 obj.tree 		= new Tree(obj.treebox); 
	 
}
function setCustomerPara(obj){
	 obj.className ="customer";
	 obj.IdPrefix 	= obj.className + "Id";	 
}
function resetHeigth(){
   var treebox = $("categoryTreebox");
   var Btn_saveUserCustomerRel = $("Btn_saveUserCustomerRel");
   var height = window.innerHeight;
   treebox.style.height = height*0.9  +"px";	
//   treebox.style.height = height - Btn_saveUserCustomerRel.offsetHeight*2  + "px";
} 

function getCustomerCategoryTree(OBJ){
	var obj_tree = OBJ.tree.dhtmlTree;
	obj_tree.enableCheckBoxes(true);
	obj_tree.enableDragAndDrop(false);	
	obj_tree.enableMercyDrag(true);
	obj_tree.enableThreeStateCheckboxes(true);
	//obj_tree.setOnClickHandler(doOnSelect);
	
	
	OBJ.reset();
	function getxml(treeXML){
		obj_tree.loadXMLString(treeXML);			
		loadUserCustomerRel();
	} 
	OBJ.getCategoryTreeXML(OBJ,customer.IdPrefix,getxml);
}
function buttonEventFill(){
	var Btn_saveUsercategoryRel = $("Btn_saveUserCustomerRel");	
	Btn_saveUsercategoryRel.setAttribute("href","javascript:void 0");
	Btn_saveUsercategoryRel.onclick = saveUserCustomerRel;
	
	var Btn_close = $("Btn_close");	
	Btn_close.setAttribute("href","javascript:void 0");
	Btn_close.onclick = closeWin;
	
}
function closeWin(){
	window.top.close();
}
function saveUserCustomerRel(){
   var customerids = category.tree.getAllCheckedBranches(customer.IdPrefix);
   if(customerids == null) customerids = []; 
   var callBackFun = function(){alert("保存成功！");};
   
   if(userId =='' || userId ==null){
   	alert("请先保存用户基本信息，再执行此操作！");
   	return false;
   }
   customer.saveUserCustomerRel(userId,customerids,callBackFun);
}
function loadUserCustomerRel(){
	function callBackFun(ids){
	 	category.tree.loadDataTreeArray1(customer.IdPrefix,ids);
	}
	
	if(userId==""||userId==null){
		category.tree.refreshTree();
		return false;
	}else{
		customer.getCustomerIdByUserId(userId,callBackFun);
	}
}