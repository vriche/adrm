<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="mainMenu.title"/></title>
    <content tag="heading"><fmt:message key="mainMenu.heading"/></content>
    <meta name="menu" content="MainMenu"/>
</head>

<p><fmt:message key="mainMenu.message"/></p>

<div class="separator"></div>

<table border="0">
  <tr> 
    <td class="textbold"><div align="right"><font color="#FF0000"><!-- ����֪ͨ --><fmt:message key="mainMenu.notice"/></font></div></td>
    <td class="textbold maxwidth" >&nbsp;</td>
    <td class="textbold" style="white-space: nowrap;"></td>
  </tr>
  <tr> 
    <td  width="50%" valign="top" class="textbold"> <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td width="30"><img src="../image/arrow.png" width="19" height="16"></td>
          <td><strong><!-- ������Ϣ --><fmt:message key="mainMenu.info"/></strong> </td>
        </tr>
      </table>
      <hr width="90%"> <table width="90%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td align="center">*</td>
          <td align="left"><!-- �������û��ʲô����.... --><fmt:message key="mainMenu.noplay"/></td>
        </tr>
        <tr> 
          <td align="center">*</td>
          <td align="left"></td>
        </tr>
        <tr> 
          <td width="10%" align="center">&nbsp;</td>
          <td align="left"><div align="right"><font color="#FF0000"><a href="<c:url value="/mainMenu.html"/>"><!-- ���� --><fmt:message key="mainMenu.more"/></a></font></div></td>
        </tr>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td width="30"><img src="../image/arrow.png" width="19" height="16"></td>
          <td><strong><!-- ��Դ��̬ --><fmt:message key="mainMenu.resourceInfo"/></strong> </td>
        </tr>
      </table>
      <hr width="90%"></td>
    <td align="center" valign="top" class="textbold maxwidth" > <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td width="30"><img src="../image/arrow.png" width="19" height="16"></td>
          <td><strong><!-- �����ճ� --><fmt:message key="mainMenu.todayPlay"/></strong></td>
          <td align="center"> <a href="<c:url value="/mainMenu.html"/>"><!-- ���� --><fmt:message key="mainMenu.comein"/></a></td>
        </tr>
      </table>
      <hr width="80%"> <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td>&nbsp;</td>
          <td><!-- �������û��ʲô����.... --><fmt:message key="mainMenu.noplay"/></td>
        </tr>
        <tr> 
          <td width="10%">&nbsp;</td>
          <td>&nbsp;</td>
        </tr>
      </table>
      <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td width="30"><img src="../image/arrow.png" width="19" height="16"></td>
          <td><strong><!-- ���˹��� --><fmt:message key="mainMenu.mytools"/></strong></td>
        </tr>
      </table>
      <hr width="80%">
      
       <table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tr> 
          <td width="10%">&nbsp;</td>
          	<tr>
          		<td width="50%" align="center">
		          	<a href="<c:url value="/oaCalendarEvents.html"/>"><img src="image/main/calendarEvent.gif" border="0"><br>
		          			<!-- �ճ̰��� --><fmt:message key="mainMenu.arrange"/></a>
          		</td>
          		<td width="50%" align="center">&nbsp;&nbsp;</td>          		
          	</tr>
          	<td width="50%" align="center">&nbsp;&nbsp;</td>
          	<tr>
          		<td width="50%" align="center">
		          	<a href="<c:url value="/oaBusinessCards.html"/>"><img src="image/main/businessCard.gif" border="0"><br>
		          			<!-- ��Ƭ���� --><fmt:message key="mainMenu.card"/></a>
          		</td>
          		<td width="50%" align="center">&nbsp;&nbsp;</td>
          	</tr>
          	<td width="50%" align="center">&nbsp;&nbsp;</td>
          	<tr>
          		<td width="50%" align="center">
		          	<a href="<c:url value="/oaAreaPcs.html"/>"><img src="image/main/unpublish_f2.png" border="0"><br>
		            		<!-- �ʱ����� --><fmt:message key="mainMenu.zipAreaCode"/></a>
          		</td>
          		<td width="50%" align="center">&nbsp;&nbsp;</td>
          	</tr>
          	<td width="50%" align="center">&nbsp;&nbsp;</td>
          	<tr>
          		<td width="50%" align="center">
		          	<a href="<c:url value="/oaScratchpads.html"/>"><img src="image/main/scratchpad.gif" border="0"><br>
		            		<!-- �ҵı�� --><fmt:message key="mainMenu.memo"/></a>
          		</td>
          		<td width="50%" align="center">&nbsp;&nbsp;</td>
          	</tr>
          	<td width="50%" align="center">&nbsp;&nbsp;</td>
          	<tr>
          		<td width="50%" align="center">
		          	<a href="<c:url value="/oaAreaCitys.html"/>"><img src="image/main/pc.gif" border="0"><br>
		            		<!-- ������Ϣ --><fmt:message key="mainMenu.cityInfo"/></a>
          		</td>
          		<td width="50%" align="center">&nbsp;&nbsp;</td>
          	</tr>
          	<td width="50%" align="center">&nbsp;&nbsp;</td>
          	<tr>
          		<td width="50%" align="center">
		          	<a href="<c:url value="/mainMenu.html"/>"><img src="image/main/calculator.gif" border="0"><br>
		          			<!-- ������ --><fmt:message key="mainMenu.calculator"/></a>
		          		<a href="<c:url value="/oaWorkFlowChecks.html"/>"><img src="image/main/calculator.gif" border="0">	
		          			
		          			
          		</td>
          		<td width="50%" align="center">&nbsp;&nbsp;</td>
          	</tr>      
         </tr>
      </table>                  
      
      </td>
    <td class="textbold" style="white-space: nowrap;"></td>
  </tr>
</table>
