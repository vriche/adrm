var matter = new Matter();
var customer = new Customer();

var industry = new Industry(); 
var brand = new Brand();
var orgId = 1;


callOnLoad(init);	

function init(){ 	
	
	ctxPath =  _app_params.ctxPath;	
	config_industryLevelParam =  _app_params.sysParam.industryLevelParam;
	config_adverCodeModelParam =  _app_params.sysParam.adverCodeModelParam;
	loginUser =  _app_params.user.username;
	_make_org_select("org_Id",145,"onOrgChange");
	
	 var srcStr= window.location.href;
 	 model  = getParamFromUrl(srcStr,"model");	
	
	if(model=='new'){
		 orgId = getParamFromUrl(srcStr,"orgId");	
	}else{
	  	 orgId = $("orgId").value;
	}

	
	if(orgId > 0) $("org_Id").value = orgId;
	 	 
	setMatterPara(matter);
	

	
	if(!isUndefined($("save2"))){
		$("save2").hide();
	}
	var id = getIdByURL();

//	if(id!="0"){
//		$("length").disabled = true;
//	}
	
	initBrand();
	
	initIndustry();
	

	
 	buttonEventFill();
 	
 	getcustomerCmd(true);
 	

 	if(config_adverCodeModelParam == '1'){
// 		$("tapeCode").readonly= true;	 
 		$("tapeCode").setAttribute("readonly",true);
 		$("tapeCode").setAttribute("class","dataLabel");
 	}
}

function onOrgChange(){

	 $("orgId").value = $("org_Id").value;
	 $("id").value = null;

	 $("name").value = null;
	 $("edit").value = null;
	 $("length").value = 5;
	 $("memo").value = null;
	 $("tapeCode").value = null;

	 
	getcustomerCmd(false);
}
 	function setCustomerSelected(){
// 	   $("customerCmd").remove(0);
	   $("customerCmd").value =  $("customerId").value;

	}
	function oncustomerCmdchange(){
	
		$("customerId").value = $("customerCmd").value;
	}
function getcustomerCmd(isSetValue){
	
 	customer.obj.orgId = $("orgId").value;
	customer.obj.loginUser = loginUser;

	if(!isSetValue){
		customer.makeSelectAnalyzeWidth(customer.obj,"customerCmd","oncustomerCmdchange","145",function(){});	
	}else{
		customer.makeSelectAnalyzeWidth(customer.obj,"customerCmd","oncustomerCmdchange","145",setCustomerSelected);	
	}

}
function setMatterPara(obj){
	 
	 obj.enableEdit	= true;
	 obj.enableDel	= true;
		
	 obj.className   = "matter";	
	 obj.IdPrefix 	 = obj.className + "Id";
}

function getIdByURL(){
	var id = $("id").value;
	id = (id == ""||id==null)?0:id;
	return id;
}

function buttonEventFill(){	
	var btn_search2 = $("save");
	if(!isUndefined(btn_search2)){
		btn_search2.onclick = displaySave;
	}
	
	var btn_search = $("save2");
	if(!isUndefined(btn_search)){
		btn_search.onclick = saveMatterForm;
	}
	
	var lengthText = $("length");
	lengthText.onblur = onblurText;

	
}

function onblurText(){
	var isd = isDigit($("length").value);
	if(!isd){
		alert("必须数字!");	
		$("length").value="";
	}
}


function displaySave(){
	$("save").hide();
	$("save1").hide();
	$("delete").hide();
	$("length").disabled = true;
//	$("tapeCode").disabled = true;
	$("save2").show();
	if(config_adverCodeModelParam == '1'){ 
 		$("tapeCode").removeAttribute("readonly");
 	}
}


  function checkTapeCode(){
  	
   isBug = true;
   

   if(industry.treecombo.passField.value ==''){
		alert("行业类别必填!");	
		isBug = false;
   }
   
	var isd = isDigit($("length").value);
	if(!isd){
		$("length").value="";
		alert("必须数字!");	
		isBug = false;
	}
	if($("length").value ==""){
		alert("长度必填!");
		isBug = false;
	}
   
   if(config_adverCodeModelParam == '0'){
		 
	var curtapeCode = $("tapeCode").value;
	curtapeCode = curtapeCode == ""?null:curtapeCode;
	
	matter.reset();
	matter.obj.name = $("name").value;
	matter.obj.edit = $("edit").value;
	matter.obj.length = $("length").value;
	matter.obj.orgId = $("orgId").value;
	

	
	if(curtapeCode != null){
			
			matter.reset();
			matter.obj.tapeCode = curtapeCode;
			matter.obj.orgId = $("orgId").value;
			
			var object =  matter.getMatterByTapeCode(matter.obj);
			
			if(object != null){
				object.tapeCode = object.tapeCode == ""?null:object.tapeCode;
				if(curtapeCode == object.tapeCode){
					alert("磁带号有冲突,请重新输入新的磁带号!");
					isBug = false;
				    
				}
			}
		}
	}
	
	
	return isBug;
}

function saveMatterForm(){
	
	var isd = isDigit($("length").value);
	if(!isd){
		$("length").value="";
		alert("必须数字!");	
	}
	if($("length").value ==""){
		alert("长度必填!");
	}
	
	
//	alert(industry.treecombo.passField.value)
	
	
	
	
//	 var brandId = industry.treecombo.passField.value;

	var callBack = function(obj){
//		console.log(obj)

		if(obj!=null){
            
			if(obj.id != getIdByURL() && obj.id>0){
				alert("此条广告已存在！");
				return false;		
			}else{
				DWRUtil.getValues(matter.obj);
				
				matter.obj.id= getIdByURL();
				matter.obj.orgId = $("org_Id").value;
				matter.obj.save2dayang = "1";
//				matter.obj.brandId = brandId;
				
//				alert(matter.obj.brandId);
//				alert(matter.obj.brandId2);
				
				var func = function(){
					alert("保存成功！");
				}
			matter.saveMatterForm(matter.obj,func);
			}		
		}else{
			DWRUtil.getValues(matter.obj);
			matter.obj.id= getIdByURL();
			matter.obj.orgId = $("org_Id").value;
			matter.obj.save2dayang = "1";

			
//			matter.obj.brandId = brandId;
			var func = function(){
				alert("保存成功！");
			}
			
			matter.saveMatterForm(matter.obj,func);
		}
	}
	
	var func1 = function(obj){
		
		if(obj!=null && obj.id >0){
			if(obj.id!=getIdByURL()){	
				alert("此条磁带号已存在！");
				return false;	
			}else{
				matter.reset();
				matter.obj.orgId = $("org_Id").value;
				matter.obj.name = $("name").value;
				matter.obj.edit = $("edit").value;
				matter.obj.length = $("length").value;
				matter.CheckMatter(matter.obj,callBack)
			}
		}else{
				matter.reset();
				matter.obj.orgId = $("org_Id").value;
				matter.obj.name = $("name").value;
				matter.obj.edit = $("edit").value;
				matter.obj.length = $("length").value;
				matter.CheckMatter(matter.obj,callBack)
		}
	}
	
 
		
	matter.reset();
	matter.obj.tapeCode = $("tapeCode").value;
	matter.obj.orgId = $("org_Id").value;
//	matter.obj.brandId = brandId;
//	alert(matter.obj.tapeCode);
	matter.getMatterByTapCode(matter.obj,func1);
	
	
//	alert("sss"+getIdByURL());
}

function inti_set_industry(){

	   function func1(obj){
	   	    var o = obj.industry;
	        var id = obj.industryType;
	        var name = o.name;
	        
//	        alert(obj.brandId);
//	        alert(obj.brandId2);

		    if(!industry.treecombo){
		    	initIndustry();
		    }
		    

		   	industry.treecombo.setValue(name);
		   	industry.treecombo.passField.value = id; 	 
		   	
		   	
		    var brandId2 = obj.brandId2;
			Ext.getCmp('search_brand').setValue(brandId2);
	   }

	    matter.reset();
		matter.obj.id = $("id").value;
		matter.getMatterByTapCode(matter.obj,func1)		    
	    
}


function initBrand(){
	function callbak(){
		 var brandId2 = $("brandId2").value;
		 Ext.getCmp('search_brand').setValue(brandId2);
	}
	var brandCmd = brand.getBrandCmd(brand.obj,'extBrandIdDiv','search_brand',null,120,'品牌...',callbak);
	
	function setValue(cmd){
		$("brandId2").value = brandCmd.getValue();
	}
	
//	function callbak(cmd){
//		alert(99)
//	}
	
	brandCmd.on("select",setValue,this);
//	brandCmd.on("load",callbak,this);	
	
//	brandCmd.getStore().on('load',function(store,records){
//		alert(99)
//	});
	
//	brandCmd.store.on('load', function(){ alert(777) });
//	brandCmd.on('selected', function(){ alert(777) });
//	alert(brandCmd.listeners);
//	brandCmd.listeners={select:callbak};

}

function initIndustry(){
	
	         var brandId = $("brandId").value;

			 var id ="industryTree"
	     	 industry.obj.parentId = 0;
	     	 var params = [{}]; //tree dataIn。;
	     	 var tree = industry.getTree(id,params,false);
	     	 
	     	if(!industry.treecombo){
				industry.treecombo = new ComboBoxTree({
					        id:"industryCmd",
					         fieldLabel : '',
					         renderTo : 'initIndustryComboBoxTree',
			               width : 143,
			              // xtype : 'combotree',
			               passName : 'typeId',
			               autoScroll:true,
			               allowUnLeafClick : false,
			               treeHeight:300,
			               tree :tree,
			               allowBlank : false        
				});
	     	}
	     	
	     	function onTreeSelected(node){
//	     		  industry.treecombo.setValue(node.id);  	
//                  industry.treecombo.relId = node.id;
               
               	var name  ='';
               	if(config_industryLevelParam == '1'){
               		    var parentNode = node.parentNode;
               		    name = parentNode.text + '/' +node.text;
               	}else{
               		 name = node.text;  	
               	}
                industry.treecombo.passField.value = node.id;
                industry.treecombo.setValue(name);  
                
                $("brandId").value	= node.id;
	     	
	     	}

           industry.treecombo.on('treeselected',onTreeSelected,industry.treecombo); 
           
           
         
           
           if( $("id").value > 0) {
        	   inti_set_industry();
           }
 
           
         
           


//           industry.treecombo.tree.on('load', function(node){if(brandId>0){
//           	
//           	   
//           	
//           	    alert(brandId);
//           	  
//	  			var name  ='';
//               	if(config_industryLevelParam == '1'){
//               		    var parentNode = node.parentNode;
//               		    name = parentNode.text + '/' +node.text;
//               	}else{
//               		 name = node.text;  	
//               	}
//                industry.treecombo.passField.value = node.id;
//                industry.treecombo.setValue(name);  
//           	
//           };}); 
//            var store =  industry.treecombo.store;
//            store.load();
            
//            var store =  industry.treecombo.tree.loader.load(tree.root);
            
//            industry.treecombo.tree.getLoader().load(tree.root);
           
           
    
             
}