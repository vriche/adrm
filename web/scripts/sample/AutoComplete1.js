var oldValue="";
  var oSelTD=-1;
  var oTatal=0;
  var oMainObj;
  var pos=0;
  var boolInTD;
  var oMethodName;
  var oChildDIV=document.createElement("DIV");
  var oParentDIV=document.createElement("DIV");
  var oFrame=document.createElement("IFRAME");
  var oAutoCompleteINPUT;
  oParentDIV.style.position="absolute";
  oParentDIV.style.display="none";
  oParentDIV.style.width="150px";
  oParentDIV.style.height="200px";
 
  oFrame.width=oParentDIV.style.width;
  oFrame.height=oParentDIV.style.height;
  oParentDIV.appendChild(oFrame);
 
  oChildDIV.style.display="none";
  oChildDIV.style.position="absolute";
  oChildDIV.style.width=oParentDIV.style.width;
  oChildDIV.style.height=oParentDIV.style.height;
  oChildDIV.style.borderStyle='solid';
  oChildDIV.style.borderWidth='1px';
  oChildDIV.style.fontSize="13";
  oChildDIV.style.backgroundColor ="#f5f5f5";
  function AutoComplete()  
  {  
      if(checkKeyCode())
        return;
      if(oldValue==oMainObj.value)
        return;
      getTextPos();
//      var values=oMainObj.value.split(",");
      var   arrPos   =   getPos(oMainObj);  
      var   oRange   =   document.selection.createRange();
      oChildDIV.style.left=parseInt(oRange.offsetLeft,10)   +   parseInt(arrPos[1],10)-2;
      oChildDIV.style.top=parseInt(oRange.offsetTop,10)   +   parseInt(arrPos[0],10)+18;
           
      oParentDIV.style.left=parseInt(oRange.offsetLeft,10)   +   parseInt(arrPos[1],10)-2;
      oParentDIV.style.top=parseInt(oRange.offsetTop,10)   +   parseInt(arrPos[0],10)+18;
      oldValue=oMainObj.value;
      fillDIV(oAutoCompleteINPUT);
      oMainObj.focus();
  }
  function getTextPos()
  {
       var rang = document.selection.createRange();
       rang.setEndPoint("StartToStart",oMainObj.createTextRange());
       pos=rang.text.split(",").length-1;
       oAutoCompleteINPUT=rang.text.split(",")[pos];
  }
  function   getPos(obj)  
  {  
          var   pos   =   new   Array();  
          var   t=obj.offsetTop;  
          var   l=obj.offsetLeft;  
          while(obj=obj.offsetParent)  
          {  
                  t+=obj.offsetTop;  
                  l+=obj.offsetLeft;  
          }  
          pos[0]   =   t;  
          pos[1]   =   l;  
          return   pos;  
          oMainObj.focus();
  }
  function fillDIV(prefix)
  {
     if(prefix=="")
     {
        HideDIV();
        return;
     }
     document.body.style.cursor='wait';
     eval("var dt="+oMethodName+"(prefix).value;");
     //debugger;
     if(dt==null || dt.Rows.length<=0)
     {
        HideDIV();
        oMainObj.focus();
        document.body.style.cursor='default';
        return;
     }
     var strHTML="";
     strHTML="<table width='100%'>";
     oTatal=dt.Rows.length;
     var oColumnName="";
     var oColumnValue="";
     if(dt.Columns[0])
         oColumnName=dt.Columns[0].Name;
     for(i=0;i<oTatal;i++)
     {
        if(i>=10)
          break;
        if(oColumnName!="")
           eval("oColumnValue=dt.Rows["+i+"]."+oColumnName);
        else
           oColumnValue=dt.Rows[i];
        strHTML+="<tr><td nowrap onclick='TDclick()' onkeydown='TDkeydown()' onmouseout='boolInTD=false;' onmouseover='TDselect()'>"+oColumnValue+"</td></tr>";
     }
     strHTML+="</table>";
     oChildDIV.innerHTML=strHTML;

     oParentDIV.style.display='block';
    
     oChildDIV.style.display='block';
     oParentDIV.style.width=oChildDIV.style.width;
     oFrame.style.width=oChildDIV.style.width;
     oSelTD=-1;
      oMainObj.focus();
    document.body.style.cursor='default';
  }
  function TDclick()
  {
    var values=oldValue.split(",");
    values[pos]=event.srcElement.innerText;
    oMainObj.value="";
    for(i=0;i<values.length;i++)
    {
       if(values[i]!="")
          oMainObj.value+=values[i]+",";
    }
    if(event.keyCode==32)
      oMainObj.value=oMainObj.value.substr(0,oMainObj.value.length-1);
    HideDIV();
    oMainObj.focus();
  }
  function MainFocus(oAjaxMethod)
  {
      if(!oMethodName) oMethodName=oAjaxMethod;
      if(!oMainObj)
      {
          oMainObj=event.srcElement;
          document.body.appendChild(oParentDIV);
          document.body.appendChild(oChildDIV);
          oMainObj.attachEvent("onfocusout",MainFocusOut);
          oMainObj.attachEvent("onkeyup",AutoComplete);
          oMainObj.attachEvent("onclick",MainClick);
          oMainObj.attachEvent("onkeydown",MainKeyDown);
      }
      getTextPos();
      var   arrPos   =   getPos(oMainObj);  
      var   oRange   =   document.selection.createRange();
      oChildDIV.style.left=parseInt(oRange.offsetLeft,10)   +   parseInt(arrPos[1],10)-2;
      oChildDIV.style.top=parseInt(oRange.offsetTop,10)   +   parseInt(arrPos[0],10)+18; 
         
      oParentDIV.style.left=parseInt(oRange.offsetLeft,10)   +   parseInt(arrPos[1],10)-2;
      oParentDIV.style.top=parseInt(oRange.offsetTop,10)   +   parseInt(arrPos[0],10)+18;
      if(oAutoCompleteINPUT!="")
          fillDIV(oAutoCompleteINPUT);
      else
      {
        HideDIV();
      }
  }
  function MainClick()
  {
      getTextPos();
      var   arrPos   =   getPos(oMainObj);  
      var   oRange   =   document.selection.createRange();
      oChildDIV.style.left=parseInt(oRange.offsetLeft,10)   +   parseInt(arrPos[1],10)-2;
      oChildDIV.style.top=parseInt(oRange.offsetTop,10)   +   parseInt(arrPos[0],10)+18; 
          
      oParentDIV.style.left=parseInt(oRange.offsetLeft,10)   +   parseInt(arrPos[1],10)-2;
      oParentDIV.style.top=parseInt(oRange.offsetTop,10)   +   parseInt(arrPos[0],10)+18;
      if(oAutoCompleteINPUT!="")
          fillDIV(oAutoCompleteINPUT);
      else
      {
        HideDIV();
      } 
  }
  function MainFocusOut()
  {
     if(boolInTD)
       return;
    HideDIV();
  }
  function checkKeyCode()
  {
     var boolReturn=false;
     if(oTatal<=0)
        return false;
     if(event.keyCode==38)
     {
        if(oSelTD<=0)
           return true;
        else
           oSelTD-=1;
        oChildDIV.getElementsByTagName("TD")[oSelTD].fireEvent("onmouseover");
        boolReturn=true;
     }
     else
     {
        if(event.keyCode==40)
        {
           if(oSelTD==oTatal-1)
              return true;
           else
              oSelTD+=1;
           oChildDIV.getElementsByTagName("TD")[oSelTD].fireEvent("onmouseover");
           boolReturn=true;
        }
        else
        {
           if(event.keyCode==13 || event.keyCode==188)
           {
              if(oSelTD<0)
                oSelTD=0;
              oChildDIV.getElementsByTagName("TD")[oSelTD].fireEvent("onclick");
              boolReturn=true;
           }
        }
     }
     oMainObj.focus();
     return boolReturn;
  }
  function TDselect()
  {
     var objs=oChildDIV.getElementsByTagName("TD");
     for(i=0;i<objs.length;i++)
     {
        if(objs[i]==event.srcElement)
        {
           oSelTD=i;
        }
        objs[i].style.backgroundColor ="#f5f5f5";
//        objs[i].style.color="#000000";
     }
     event.srcElement.style.backgroundColor ="#dcdcdc";
//     event.srcElement.style.color="#ff0000";
     event.srcElement.style.cursor="default";
     boolInTD=true;
     oMainObj.focus();
  }
  function HideDIV()
  {
    oldValue="";
    oSelTD=-1;
    oTatal=0;
    pos=0;
    oAutoCompleteINPUT="";
    oChildDIV.innerHTML="";
    oChildDIV.style.display="none";
    oParentDIV.style.display="none";
  }
  function MainKeyDown()
  {
     if(event.keyCode==13)
     {
        checkKeyCode();
        event.returnValue=false;
     }
  }