//ʵ��������
var user = new User(); 

callOnLoad(init);	

function init(){	
		                 //�¼�
		var srcStr = window.location.href;
		var userNameNow = getParamFromUrl(srcStr,"userName");
		winW = getParamFromUrl(srcStr,"winW");
		winH = getParamFromUrl(srcStr,"winH");
		if(winW == null) winW = 1200;
		if(winH == null) winH = 400;
		
		
		setUserPara(user); 					//���ó���	
		buttonEventFill(); 
		
		
}

function setUserPara(obj){
	 obj.className ="user";
	 obj.IdPrefix 	= obj.className +"Id";
}

function buttonEventFill(){
	var btn_btn_mody = $("btn_mody");
	btn_btn_mody.onclick = update;	

//	var Btn_btn_close = $("btn_close");
//	Btn_btn_close.onclick = closePopup;	
}

function update(){
	var oldPassword =  $("oldPassword").value;
	var username = $("username").value;
	var newPassword = $("newPassword").value;
	var confirmPassword = $("confirmPassword").value; 
	
	if(newPassword==''){
		alert("���벻��Ϊ��,����������!");
		return false;
	}	
	if(newPassword != confirmPassword){
		alert("ȷ����������,����������!");
		$("confirmPassword").value ="";
		$("confirmPassword").focus();
		return false;
	}	
	
	

	function fnct(btn){
		if(!btn){
			alert("�û������벻��ȷ!");
		}else{
			var callBackFun = function(s){
				  alert("�޸ĳɹ�!");
				  closePopup();
			} 
			user.updateUserPassword(username,newPassword,callBackFun);
		}
	} 
	user.getUserByNamePwd(username,oldPassword,fnct);
 
}


function closePopup(){
// 	window.top.close();
 	window.parent.myLytebox.end();return false;
}

	

