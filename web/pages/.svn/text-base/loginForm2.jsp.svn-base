<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<STYLE type=text/css>BODY {
	BACKGROUND: #46547b; MARGIN: 0px
}
BODY {
	FONT-SIZE: 13px
}
TABLE {
	FONT-SIZE: 13px
}
TR {
	FONT-SIZE: 13px
}
TD {
	FONT-SIZE: 13px
}
#main {
	BACKGROUND-IMAGE: url(images/login/index_main_bg.jpg); WIDTH: 99.9%; BACKGROUND-REPEAT: repeat-x; HEIGHT: 99.7%;border:#46547b 1px solid;
}
#logo {
	PADDING-RIGHT: 0px; PADDING-LEFT: 120px; PADDING-BOTTOM: 0px; MARGIN: 75px 0px 0px 13%; PADDING-TOP: 0px; HEIGHT: 79px; z-index:1;
}
#logoTxt {
	position:absolute; top:170px; z-index:2;filter:Alpha(opacity=30);
}


#box {
	BACKGROUND-IMAGE: url(images/login/index_box_bg.jpg); MARGIN: 0px 0px 0px 27%; WIDTH: 485px; BACKGROUND-REPEAT: no-repeat; HEIGHT: 230px
}
#form_table {
	MARGIN: 23px 0px 0px; LINE-HEIGHT: 35px
}
#form_table .text_input {
	BORDER-RIGHT: #456d91 1px solid; BORDER-TOP: #456d91 1px solid; BACKGROUND: url(images/login/index_input_bg.gif) repeat-x; BORDER-LEFT: #456d91 1px solid; WIDTH: 150px; BORDER-BOTTOM: #456d91 1px solid; HEIGHT: 20px
}
#form_table .text_input1 {
	BORDER-RIGHT: #456d91 1px solid; BORDER-TOP: #456d91 1px solid; BACKGROUND: url(images/login/index_input_bg.gif) repeat-x; BORDER-LEFT: #456d91 1px solid; WIDTH: 80px; BORDER-BOTTOM: #456d91 1px solid; HEIGHT: 20px
}
.text {
	TEXT-ALIGN: right
}
</STYLE>

<script> 
var popupcenter = new Popupcenter();

checkBrowserType();

    //callOnLoad(init);	
    

  function init(){
	   helpPage();
	   dateSourceFun();
	}  
	
	
 function checkBrowserType(){
 	var popupcenter = new Popupcenter();
    
	var browser = new popupcenter.browser();
	var insFireFoxed = false;
	
	if(!browser.isNS){
	   var urlStr ="<c:url value='/download/install_firefox.jsp'/>";
		    var msg = "系统要求使用fireFox浏览器才可正常使用\n\n";
		        msg +="请确认你的计算机上是否已安装fireFox\n\n";
		        msg +="安装点确定，不安装点取消!\n"
		    var ans = window.confirm(msg);
		    if(ans) {
		       window.location = urlStr;
		    }  
		    
		     insFireFoxed = true;
         }
         
         if(!insFireFoxed) checkJreInstalled();

    }


 function checkJreInstalled(){
	var finedApplet = false;
		for(var i=0; i<navigator.mimeTypes.length;i++){
		var b=navigator.mimeTypes[i].type;
		if(b.indexOf("x-java-applet")>-1){finedApplet = true;}
	}
	
	if(!finedApplet){
		    var msg = "系统报表打印需要安装jre插件，否则无法正常预览及打印\n\n";
		        msg +="安装完成后请关闭fireFox，再重新打开，插件才能生效\n\n"
		        msg +="安装点确定，不安装点取消!\n\n"
		    var ans = window.confirm(msg);
		    if(ans) {
			var urlStr = "<c:url value='/download/install_jre.jsp'/>";
			window.location = urlStr;
		    } 
	}
 
 }		
	
	

function dateSourceFun(){
	//$("dateSourceValue").value = $("dateSource").value ;
	$("dateSourceValue").value = dataSource;
	//var dateSourceValue = $("dateSourceValue").value;
	
	var tarForm =  $("tarForm");
	var dateSourceForm = $("DateSourceForm");

	
	dateSourceForm.target = tarForm;
	dateSourceForm.action="dateSourceChange";
	dateSourceForm.submit(); 	
}
	
 function helpPage(){
	popupcenter.url = "help/index.jsp";
	//popupcenter.model = 11;
	popupcenter.popupcenter(popupcenter);
}
</script>

<div class="main" id="main">

 	<table width="100%" border="0" cellspacing="0" cellpadding="0" style="position:absolute; top:45px; z-index:2;">
	  <tr>
	    <td ALIGN="LEFT"><strong><font color="#CCCCCC" size="4"><c:out value='${appConfig["LOGO_ORG_NAME"]}'/>-广告经营管理系统</font>
	    <font color="#FF0000" size="3">V(<c:out value='${appConfig["SOFT_VERSION"]}'/>.1)</font>
	    
	    </strong></td>
	  </tr>

	</table>  
	
  <div class="logo" id="logo"><img  width="1px" HEIGHT: 1px; src="images/login/index_logo2.jpg" /></div>
  
  
  <div class="box" id="box">
<form method="post" id="loginForm" action="<c:url value="/j_security_check"/>" 
		onsubmit="saveUsername(this);return validateForm(this)">
		
      <table id="form_table" cellspacing="1" cellpadding="1" width="100%" border="0">
        <tbody>
        
          <tr>
            <td width="20%">&nbsp;</td>
            <td width="33%">&nbsp;</td>
            <td width="47%">&nbsp;</td>
          </tr>
          <tr>
           	<td></td><td class="text">	
           <c:if test="${param.error != null}">
	<img src="<c:url value="/images/iconWarning.gif"/>" alt="<fmt:message key="icon.warning"/>" class="icon" />
								            
								   <fmt:message key="errors.password.mismatch"/>							    
								   
								      
								    
</c:if> 
           	
           	
           					 
           	</td>	  
        </tr>
          <tr>
            <td class="text">
                <label for="j_username" >
            	  <fmt:message key="label.username"/> :
        	</label>
        	</td>
        	<td>
        	<input name="j_username" class="text_input" id="j_username" />
           </td>
            <td>&nbsp;</td>
          </tr>
        <tr>
            <td class="text"><label for="j_password" >
            					<fmt:message key="label.password"/> :
        					</label></td>
            <td><input name="j_password" type="password" class="text_input" id="j_password" /></td>
   <!--        <td><img height="22" src="images/login/lock.jpg" width="38" /> <a 
      href="#">忘记密码</a></td>-->
          </tr>
<!--            <tr>
            <td class="text">验证码:</td>
            <td><table border="0" cellspacing="0" cellpadding="0">
              <tr>
                <td width="85"><FONT color=#ffffff>
                  <INPUT name=code 
            type=text class="text_input1"  id=code 
            size="6">
                  </FONT><font color="#0000FF"><strong>
                  <input name="ycode" type="hidden" id="ycode" value=<?=$_SESSION["yzcode"]?>
                </strong></font></td>
                <td><table border="0" cellpadding="2" cellspacing="1" bgcolor="#F2F2F2">
                    <tr>
                      <td><b><font color="#ff6600">
                        <?=$_SESSION['yzcode']?>
                      </font></b></td>
                    </tr>
                </table></td>
              </tr>
            </table></td>
            <td>&nbsp;</td>
          </tr>-->
          <tr>
            <td>&nbsp;</td>
            <td colspan="2"><table cellspacing="0" cellpadding="0">
              <tbody>
                <tr>
                  <td width="100"><input id="imageField" 
            style="BORDER-TOP-WIDTH: 0px; BORDER-LEFT-WIDTH: 0px; BORDER-BOTTOM-WIDTH: 0px; WIDTH: 80px; HEIGHT: 22px; BORDER-RIGHT-WIDTH: 0px" 
            type="image" src="images/login/index_submit.jpg" border="0" 
            name="imageField" />                  </td>
                  <td><!--<a href="http://localhost:8080/adrm/help/index.jsp" 
            target="_blank">--><!-- img src="<c:url value="/images/login/index_help.jpg"/>"/ --><!--</a>--> </td>
                </tr>
              </tbody>
            </table></td>
          </tr>
        </tbody>
      </table>
    </form>
  </div>
  <div id="copyright"><br />
      <font class="copyright_set"  face="Arial, Helvetica, sans-serif">
      <div align="center">&copy;2006-2012 <c:out value='${appConfig["LOGO_ORG_NAME"]}'/>&nbsp;&nbsp;&nbsp;北京博瑞科技&nbsp;&nbsp;&nbsp;联合开发</div>
      </font></div>
</div>


<%@ include file="/scripts/login.js"%>