
function suckerfish(type, tag, parentId)
{
	if (window.attachEvent)
	{
		window.attachEvent("onload", function()
		{
			var sfEls = (parentId==null)?

document.getElementsByTagName(tag):document.getElementById(parentId).getElementsByTagName(tag);
			type(sfEls);
		});
	}
}
sfFocus = function(sfEls)
{
	for (var i=0; i<sfEls.length; i++)
	{
		sfEls[i].onfocus=function()
		{
			this.className+=" sffocus";
			if( this.value == this.defaultValue ) { this.value = ""; }
		}
		sfEls[i].onblur=function()
		{
			this.className=this.className.replace(new RegExp(" sffocus\\b"), "");
			if( this.value == "" ) { this.value = this.defaultValue; }
					}
	}
}
suckerfish(sfFocus, "INPUT");
suckerfish(sfFocus, "TEXTAREA"); 
suckerfish(sfFocus, "Select"); 


var intIndex=0;arrList = new Array();
arrList[intIndex++] = " 1sdfsdf.com";
arrList[intIndex++] = "这里读取数据库";
arrList[intIndex++] = "业务精英";
arrList[intIndex++] = "业务主管";
arrList[intIndex++] = " 4444dsafasdf";
arrList[intIndex++] = " dddsfddsafdsaf";
arrList[intIndex++] = " 121213dsafsdaf";
arrList[intIndex++] = " 43213asdfadsf";
arrList[intIndex++] = " dsa3121dasf3";
arrList[intIndex++] = " a213";
arrList[intIndex++] = " 323313";
arrList[intIndex++] = " 3213";
arrList[intIndex++] = " 32213";
arrList[intIndex++] = " dsfsdddd";
arrList[intIndex++] = " ds11dfsfd";
arrList[intIndex++] = " ffdafd";
arrList[intIndex++] = " afdfd";
arrList[intIndex++] = " afd";
arrList[intIndex++] = " baffad";
arrList[intIndex++] = " 2fda2fd";
arrList[intIndex++] = " dasd";

function smanPromptList(arrList,objInputId){
this.style = "background:#E8F7EB;border: 1px solid #CCCCCC;font-size:14px;cursor: default;"
if (arrList.constructor!=Array){alert('smanPromptList初始化失败:第一个参数非数组!');return ;}
window.onload =function() {
              arrList.sort(function(a,b){
                  if(a.length>b.length)return 1;
                else if(a.length==b.length)return a.localeCompare(b);
                else return -1;
            })
var objouter=document.getElementById("__smanDisp") //显示的DIV对象
var objInput = document.getElementById(objInputId); //文本框对象
var selectedIndex=-1;
var intTmp; //循环用的:)
if (objInput==null) {alert('smanPromptList初始化失败:没有找到"'+objInputId+'"文本框');return ;}
//文本框失去焦点
objInput.onblur=function(){
objouter.style.display='none';
}
window.onfocus=function(){
objouter.style.display='none';
}
//文本框按键抬起
objInput.onkeyup=checkKeyCode;
//文本框得到焦点
objInput.onfocus=checkAndShow;
function checkKeyCode(){
var ie = (document.all)? true:false
if (ie){
var keyCode=event.keyCode
if (keyCode==40||keyCode==38){ //下上
  var isUp=false
  if(keyCode==40) isUp=true ;
  chageSelection(isUp)
}else if (keyCode==13){//回车
  outSelection(selectedIndex);
}else{
  checkAndShow()
}
}else{
checkAndShow()
}
divPosition()
}

function checkAndShow(){
  var strInput = objInput.value
  if (strInput!=""){
  divPosition();
  selectedIndex=-1;
  objouter.innerHTML ="";
  for (intTmp=0;intTmp<arrList.length;intTmp++){
  for(i=0;i<arrList[intTmp].length;i++){ 
if (arrList[intTmp].substr(i, strInput.length).toUpperCase()==strInput.toUpperCase()){
    addOption(arrList[intTmp],strInput);
  }
}
  }
  objouter.style.display='';
  }else{
  objouter.style.display='none';
}
function addOption(value,keyw){
var v=value.replace(keyw,"<b><font color=red>"+keyw+"</font></b>");
  objouter.innerHTML +="<div onmouseover=\"this.className='sman_selectedStyle'\" onmouseout=\"this.className=''\" onmousedown=\"document.getElementById('"+objInputId+"').value='" + value + "';window.focus();\">" + v + "</div>" 
}
}
function chageSelection(isUp){
if (objouter.style.display=='none'){
objouter.style.display='';
}else{
if (isUp)
  selectedIndex++
else
  selectedIndex--
}
var maxIndex = objouter.children.length-1;
if (selectedIndex<0){selectedIndex=0}
if (selectedIndex>maxIndex) {selectedIndex=maxIndex}
for (intTmp=0;intTmp<=maxIndex;intTmp++){

if (intTmp==selectedIndex){
  objouter.children[intTmp].className="sman_selectedStyle";
}else{
  objouter.children[intTmp].className="";
}
}
}
function outSelection(Index){
if(!objouter.children[Index])return;
objInput.value = objouter.children[Index].innerText;
objouter.style.display='none';
}
function divPosition(){
objouter.style.top =getAbsoluteHeight(objInput)+getAbsoluteTop(objInput);
objouter.style.left =getAbsoluteLeft(objInput); 
objouter.style.width=getAbsoluteWidth(objInput)
}
}
document.write("<div id='__smanDisp' style='position:absolute;display:none;" + this.style + "' onbulr> </div>");
document.write("<style>.sman_selectedStyle{background-Color:#102681;color:#FFFFFF}</style>");
function getAbsoluteHeight(ob){
return ob.offsetHeight
}
function getAbsoluteWidth(ob){
return ob.offsetWidth
}
function getAbsoluteLeft(ob){
var s_el=0;el=ob;while(el){s_el=s_el+el.offsetLeft;el=el.offsetParent;}; return s_el
}


function getAbsoluteTop(ob){
var s_el=0;el=ob;while(el){s_el=s_el+el.offsetTop ;el=el.offsetParent;}; return s_el
}
}
smanPromptList(arrList,"inputer")