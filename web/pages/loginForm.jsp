<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>

<script type="text/javascript" src="<c:url value='/scripts/common/popupWindow.js'/>"></script>
<form method="post" id="loginForm" action="<c:url value="/j_security_check"/>" 
		onsubmit="saveUsername(this);return validateForm(this)">
<p>&nbsp;</p>
<p>&nbsp;</p>
<ul>



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
<table width="750" border="0" align="center" cellpadding="0" cellspacing="0">
	<tr>
		<td>
			<TABLE width=260 height=37 border=0 align="right" cellPadding=0 cellSpacing=0>
				<TBODY>
					<TR> 
						<TD colSpan=21 height=16>
						
						</TD>
					</TR>
					<TR> 
						<TD width=2 height=21><IMG height=21 src="image/login/bgru04.jpg"  width=2></TD>
							<TD vAlign=bottom align=middle width=49 background=image/login/bgru01.jpg>
							<a href="login.jsp">
							
								<fmt:message key="button.login"/>
							
							</a>
						</TD>
										          
						<TD width=8><IMG height=21 src="image/login/bgru02.jpg" width=8></TD>
						<TD vAlign=bottom align=middle width=49 background=image/login/bgru01.jpg>
							<a href="signup.html">
							
								<fmt:message key="button.register"/>
							
							</a>
						</TD>
													
						<TD width=8><IMG height=21 src="image/login/bgru02.jpg" width=10 height=19></TD>
						<TD vAlign=bottom align=middle width=49 background=image/login/bgru01.jpg>
							<a href="login.jsp">
								<fmt:message key="login.passwordfind"/>
							</a>
						</TD>       
										                        
						<TD width=8><IMG height=21 src="image/login/bgru02.jpg" width=8></TD>
						<TD vAlign=bottom align=middle width=49 background=image/login/bgru01.jpg>
							<!-- a href="help/index.jsp" target="_bank" -->
						    <a href="javascript:void 0" onClick="helpPage()">
						    
								<fmt:message key="button.help"/>
							</a>
						</TD>				          	
						<TD width=6><IMG height=21 src="image/login/bgru03.jpg" width=6></TD>
					</TR>
				</TBODY>
			</TABLE>
		</td>
	</tr>
</table>

<table border="0" cellpadding="0" cellspacing="0" height="1" width="750" align="center">
	<tbody><tr><td class="bg02"></td></tr>
	</tbody>
</table>

<table width="750" height="9" border="0" align="center" cellpadding="0" cellspacing="0">
	<tbody><tr><td class="bg02" width="1"></td>
		<td class="bg01" width="748"></td>
		<td class="bg02" width="1"></td></tr>
	</tbody>
</table>

<table width="750" height="9" border="0" align="center" cellpadding="0" cellspacing="0">
	<tbody>
	  	<tr>
	  		<td class="bg02" width="1"></td>
			<td class="bg01" width="748"></td>
			<td class="bg02" width="1"></td>
		</tr>
	</tbody>
</table>

<table width="750" border="0" align="center" cellpadding="0" cellspacing="0" background="image/main/normal-bg.gif">
  <tbody>
  	<TR>
      <td width="1" height="371" class="bg02"></td>
      <td class="bg01" width="8"></td>
        
      <TD width="732" align="center" valign="top" >
        <TABLE cellSpacing=0 cellPadding=0 width=100% align=center border=0 >
          <TBODY>
          
            <TR> 
              <TD><table border="0" cellpadding="0" cellspacing="2" height="40" width="100%">
                  <tbody>
                    <tr> 
                      <td align="right" width="20"><img src="image/login/reg_ico_01.gif" height="12" width="12"></td>
                      <td class="f14">
        					<fmt:message key="button.loginsystem"/>
    					</td>
                      <td class="f14" align="right"><b></b></td>
                    </tr>
                  </tbody>
                </table></TD>
            </TR>
            
            <TR> 
              <TD >
              	<table border="0" cellpadding="0" cellspacing="2" width="100%" >
                  <tbody>
                    <tr> 
                      <td background="image/login/reg_s_04.gif" height="1"></td>
                    </tr>
                    
                    <tr> 
                      <td>
   							   <c:if test="${param.error != null}">
								    
								        <img src="<c:url value="/images/iconWarning.gif"/>"
								            alt="<fmt:message key="icon.warning"/>" class="icon" />
								        <fmt:message key="errors.password.mismatch"/>
								        <!--<c:out value="${sessionScope.ACEGI_SECURITY_LAST_EXCEPTION.message}"/>-->
								    
								</c:if>                       
                      </td>
                    </tr>                                                  
 
                  </tbody>
                </table>
                
                <TABLE bgColor=#ffffff cellSpacing=0 cellPadding=4 width="100%" border=0>
                  <TBODY>
                  
                    <TR > 
                      <TD width="60%"   align="center">&nbsp;</TD>
					  <TD width="40%"  >&nbsp;</TD>
                    </TR>
                    
                     <TR > 
                      <TD width="60%"   align="center">&nbsp;</TD>
					  <TD width="40%"  >&nbsp;</TD>
                    </TR>
                    
                    <TR> 
                      <TD align=right>
							
       							<label for="j_username" >
            						<fmt:message key="label.username"/> :
        						</label>
       							<input class="text medium" name="j_username" id="j_username" tabindex="1" />
    						
					  </TD>
					  <td> </td>
                      
                    </TR>
                    
                    <TR> 
                      <TD align=right>
						
         					<label for="j_password" >
            					<fmt:message key="label.password"/> :
        					</label>
        					<input type="password" class="text medium" name="j_password" id="j_password" tabindex="2" />
    				 					
					  </TD>
					  <td></td>
                      
                    </TR>
                    
                    <!--TR> 
                      <TD align=right>
						
         					<label for="j_password" >
            					<fmt:message key="label.password"/> :
        					</label>
        					<select name="dateSource" id="dateSource" onChange="dateSourceFun()">
        					<option>dataSource</option>
        					<option>dataSource1</option>
    				 		</select>	
					  </TD>
					  <td></td>
                      
                    </TR-->
                    
                    <TR> 
                      <!-- TD align=right>
						
         					<label for="registword" >
            					<fmt:message key="label.regist.word"/>
        					</label>
        					<input type="registword" class="text medium" name="registword" id="registword"  />
    					
					  </TD -->
					  
                      <TD vAlign=top> 
                        <TABLE cellSpacing=0 cellPadding=0 border=0>
                          <TBODY>
                          
                            <TR> 
                              <TD vAlign=top align=middle width=70>
                                <TABLE cellSpacing=0 cellPadding=0 border=0>
                                  <TBODY>
                                    <TR> 
                                      <TD vAlign=center align=middle width=44  height=25> 
                                        <!-- SCRIPT language=javascript>document.write("<img src=/cgi_bin/RndValidCode.asp?time=" + Math.random() + " width=40,height=16>");</SCRIPT -->
                                      </TD>
                                    </TR>
                                  </TBODY>
                                </TABLE>
                             </TD>
                           </TR>                                                      
                         </TBODY>                         
                      </TABLE>                    
                    </TD>
                    
                    
                 </TR>
                 
                 
             </TBODY>
            </TABLE>
          </TD>
        </TR>
            <TR> 
              <TD ><table border="0" cellpadding="0" cellspacing="2" width="100%">
                  <tbody>
                    <tr> 
                      <td background="image/login/reg_s_04.gif" height="1"></td>
                    </tr>
                  </tbody>
                </table></TD>
            </TR>
            <TR> 
              <TD align=middle > <div align="center">
                  <input type="submit" style="CURSOR: pointer;" name="login" value="<fmt:message key="button.login"/>" tabindex="3"/>
				  
					 <input type="checkbox" class="checkbox" name="rememberMe" id="rememberMe" tabindex="4"/>
					 <label for="rememberMe" class="choice"><fmt:message key="login.rememberMe"/></label>
				
              </div></TD>
            </TR>
        </TABLE>
    </td>
    <td class="bg01" width="8"></td>
	<td class="bg02" width="1"></td></tr>
</tbody>
</table>

<table align="center" border="0" cellpadding="0" cellspacing="0" height="9" width="750">
	<tbody><tr><td class="bg02" width="1"></td>
		<td class="bg01" width="748"></td>
		<td class="bg02" width="1"></td></tr>
	</tbody>
</table>

</ul>
</form>

<iframe scrolling="no" height="0" width="0" name="tarForm" id="tarForm"></iframe>
<form name="DateSourceForm" id="DateSourceForm" method="post">
	<input type="hidden" name="dateSourceValue" id="dateSourceValue" value="">
	
</form>


<%@ include file="/scripts/login.js"%>


