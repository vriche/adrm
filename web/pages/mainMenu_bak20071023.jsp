<%@ include file="/common/taglibs.jsp"%>

<head>
    <title><fmt:message key="mainMenu.title"/></title>
    <content tag="heading"><fmt:message key="mainMenu.heading"/></content>
    <meta name="menu" content="MainMenu"/>
    
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/scripts/calendar/skins/theme.css'/>" />
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/calendar-setup.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/calendar/lang/calendar-zh-gbk.js'/>"></script>   
<script type="text/javascript" src="<c:url value='/scripts/admin/mainMenu.js'/>"></script>
    
</head> 
<!-- p><fmt:message key="mainMenu.message"/></p -->









<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                    <td><span class="tile1"></span>
                    </td>
                  </tr>
                </tbody>
              </table></td>
            <td width="115"><img src="images/table1/textbox_top_right.jpg" height="27"></td>
          </tr>
        </tbody>
      </table></td>
  </tr>
  <tr>
    <td><table border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td background="images/table1/textbox_left.gif" width="14"></td>
            <td bgcolor="#f4f3f4">
            
            <!--   table start -->
 


<table width="100%" height="633">
  <tr> 
    <td width="80%" height="20">&nbsp;</td>
    <td>&nbsp;</td>
  </tr>
  <tr> 
    <td width="75%"  valign="top"> <table width="100%">
        <tr> 
          <td width="45%"><table width="100%" bordercolor="#000000" bgcolor="#CCCCCC">
              <tr> 
                <td width="10%"><img src="image/main/customer.png" width="25" height="25"></td>
                <td><!-- �ͻ���ϵ --><fmt:message key="customerDetail.heading"/></td>
              </tr>
            </table></td>
          <td width="2%">&nbsp;</td>
          <td width="45%"><table width="100%" bordercolor="#000000" bgcolor="#CCCCCC">
              <tr> 
                <td width="10%"><img src="image/main/adres.png" width="25" height="25"></td>
                <td><!-- �����Դ --><fmt:message key="publishedInfoForm.adResourceId"/></td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td width="45%"> <table width="100%" bgcolor="#FFFFFF">
              <tr> 
                <td width="10%">&nbsp;</td>
                <td><a href="customers.html"><!-- �ͻ���Ϣ --><fmt:message key="customer.info"/></a></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
                <td><a href="linkMans.html"><!-- ��ϵ�� --><fmt:message key="orgForm.linkMan"/></a></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
                <td><a href="feedbackInfos.html"><!-- �ͻ���� --><fmt:message key="customerForm.tabs.feedback"/></a></td>
              </tr>
            </table></td>
          <td width="2%">&nbsp;</td>
          <td><table width="100%" bgcolor="#FFFFFF">
              <tr> 
                <td width="10%">&nbsp;</td>
                <td><a href="resources.html"><!-- ��Դ���� --><fmt:message key="resourceForm.manage"/></a></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
                <td><a href="resourceChannels.html"><!-- Ƶ����Ŀ --><fmt:message key="carrierForm.channel"/></a></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
                <td><a href="specifics.html"><!-- ָ����Ϣ --><fmt:message key="specificList.heading"/></a></td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td width="45%"> <table width="100%" bordercolor="#000000" bgcolor="#CCCCCC">
              <tr> 
                <td width="10%"><img src="image/main/order.png" width="25" height="25"></td>
                <td><!-- �������� --><fmt:message key="orderDayInfoDetail.title"/></td>
              </tr>
            </table></td>
          <td width="2%">&nbsp;</td>
          <td><table width="100%" bordercolor="#000000" bgcolor="#CCCCCC">
              <tr> 
                <td width="10%"><img src="image/main/matter.png" width="25" height="25"></td>
                <td><!-- ������� --><fmt:message key="publishedInfoForm.adContent"/></td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td width="45%"> <table width="100%" bgcolor="#FFFFFF">
              <tr> 
                <td width="10%">&nbsp;</td>
                <td><a href="contracts.html?type=1"><!-- ��ͬ��Ϣ --><fmt:message key="contractTargetDetail.heading"/></a></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
                <td><a href="orders.html"><!-- ���۶��� --><fmt:message key="customerForm.tabs.orders"/></a></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
                <td><a href="queryAdres.html"><!-- ��Դ��ѯ --><fmt:message key="compagesForm.resourcesSelect"/></a></td>
              </tr>
            </table></td>
          <td width="2%">&nbsp;</td>
          <td><table width="100%" bgcolor="#FFFFFF">
              <tr> 
                <td width="10%">&nbsp;</td>
                <td><a href="brands.html"><!-- ��ƷƷ�� --><fmt:message key="oaProductUsedForm.productTradeMark"/></a></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
                <td><a href="productCategorys.html"><!-- ��Ʒ���� --><fmt:message key="oaProductUsedForm.productAssort"/></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
                <td><a href="matters.html"><!-- ����ز� --><fmt:message key="mainMenu.adMaterial"/></a></td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td width="45%"> <table width="100%" bordercolor="#000000" bgcolor="#CCCCCC">
              <tr> 
                <td width="10%"><img src="image/main/finace.png" width="25" height="25"></td>
                <td><!-- ������� --><fmt:message key="mainMenu.incomeManager"/></td>
              </tr>
            </table></td>
          <td width="2%">&nbsp;</td>
          <td><table width="100%" bordercolor="#000000" bgcolor="#CCCCCC">
              <tr> 
                <td width="10%"><img src="image/main/colligate.png" width="25" height="25"></td>
                <td><!-- �ۺϹ��� --><fmt:message key="mainMenu.allManager"/></td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td width="45%"> <table width="100%" bgcolor="#FFFFFF">
              <tr> 
                <td width="10%">&nbsp;</td>
                <td><a href="incomes.html"><!-- ������¼ --><fmt:message key="mainMenu.incomeIn"/></a></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
                <td><a href="incomePulls.html"><!-- ������� --><fmt:message key="incomeUsedDetail.heading"/></a></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
                <td><a href="incomes.html"><!-- Ƿ��ͳ�� --><fmt:message key="mainMenu.moneyRecord"/></a></td>
              </tr>
            </table></td>
          <td width="2%">&nbsp;</td>
          <td><table width="100%" bgcolor="#FFFFFF">
              <tr> 
                <td width="10%">&nbsp;</td>
                <td><a href="oaInfos.html"><!-- ����֪ͨ --><fmt:message key="mainMenu.notice"/></a></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
                <td><a href="oaProductInfos.html"><!-- �ɹ��Ǽ� --><fmt:message key="mainMenu.buyRecord"/></a></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
                <td><a href="editOaAssets.html"><!-- �ʲ��Ǽ� --><fmt:message key="mainMenu.monRecord"/></a></td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td width="45%"> <table width="100%" bordercolor="#000000" bgcolor="#CCCCCC">
              <tr> 
                <td width="10%"><img src="image/main/publish.png" width="25" height="25"></td>
                <td><!-- �������� --><fmt:message key="mainMenu.viewManager"/></td>
              </tr>
            </table></td>
          <td width="2%">&nbsp;</td>
          <td><table width="100%" bordercolor="#000000" bgcolor="#CCCCCC">
              <tr> 
                <td width="10%"><img src="image/main/documents.png" width="25" height="25"></td>
                <td><!-- �ĵ����� --><fmt:message key="mainMenu.documentManager"/></a></td>
              </tr>
            </table></td>
        </tr>
        <tr>
          <td><table width="100%" bgcolor="#FFFFFF">
              <tr> 
                <td width="10%">&nbsp;</td>
                <td><a href="publishedInfos.html"><!-- ������ --><fmt:message key="mainMenu.adverEdit"/></a></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
                <td><a href="appendTree.html"><!-- ��Ƭ��� --><fmt:message key="mainMenu.adver"/></a></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
                <td><a href="a.html"><!-- ��Ƭ��ѯ --><fmt:message key="mainMenu.select"/></a></td>
              </tr>
            </table></td>
          <td width="2%">&nbsp;</td>
          <td><table width="100%" bgcolor="#FFFFFF">
              <tr> 
                <td width="10%">&nbsp;</td>
                <td><a href="oaDocumentCatalogs.html"><!-- Ŀ¼���� --><fmt:message key="mainMenu.catelogManager"/></a></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
                <td><a href="oaDocuments.html"><!-- �ĵ���� --><fmt:message key="mainMenu.oaDocumentCatelog"/></a></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
                <td><a href="editOaDocument.html"><!-- �����ĵ� --><fmt:message key="mainMenu.oaDocument"/></a></td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td><table width="100%" bordercolor="#000000" bgcolor="#CCCCCC">
              <tr> 
                <td width="10%"><img src="image/main/workflow.png" width="25" height="25"></td>
                <td><!-- �������� --><fmt:message key="mainMenu.workFlow"/></td>
              </tr>
            </table></td>
          <td width="2%">&nbsp;</td>
          <td><table width="100%" bordercolor="#000000" bgcolor="#CCCCCC">
              <tr> 
                <td width="10%"><img src="image/main/analyze.png" width="25" height="25"></td>
                <td><!-- ͳ�Ʒ��� --><fmt:message key="mainMenu.record"/></td>
              </tr>
            </table></td>
        </tr>
        <tr> 
          <td width="45%"><table width="100%" bgcolor="#FFFFFF">
              <tr> 
                <td width="10%">&nbsp;</td>
                <td><a href="oaWorkFlows.html"><!-- ���̹��� --><fmt:message key="mainMenu.workFlowManager"/></a></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
                <td><a href="oaApplyInfos.html"><!-- �칫���� --><fmt:message key="mainMenu.workOffer"/></a></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
                <td><a href="oaWorkFlowChecks.html"><!-- �칫���� --><fmt:message key="mainMenu.workFlowCheck"/></a></td>
              </tr>
            </table> </td>
          <td width="2%">&nbsp;</td>
          <td><table width="100%" bgcolor="#FFFFFF">
              <tr> 
                <td width="10%">&nbsp;</td>
                <td><a href="mainMenu.html"><!-- �ձ��� --><fmt:message key="mainMenu.dayTable"/></a></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
                <td><a href="mainMenu.html"><!-- �±��� --><fmt:message key="mainMenu.monthTable"/></a></td>
              </tr>
              <tr> 
                <td>&nbsp;</td>
                <td><a href="mainMenu.html"><!-- �걨�� --><fmt:message key="mainMenu.yearTable"/></a></td>
              </tr>
            </table></td>
        </tr>
      </table></td>
    <td valign="top"><table width="100%" >
        <!-- tr> 
          <td>&nbsp;</td>
          <td><table width="100%" bordercolor="#000000" bgcolor="#999999">
              <tr> 
                <td><!-- ʱ�� --><strong><font color="#FFFFFF"><fmt:message key="mainMenu.clock"/></font></strong></td>
              </tr>
            </table></td>
          <td>&nbsp;</td>
        </tr -->
        <tr> 
          <td>&nbsp;</td>
          <td><table width="100%"  bgcolor="buttonface">

              <tr> 
                <td>
				<div id="clock"> 
				</td>
              </tr>

            </table></td>
          <td>&nbsp;</td>
        </tr>
        <tr> 
          <td>&nbsp;</td>
          <td><table width="100%" bordercolor="#000000" bgcolor="#999999">
              <tr> 
                <td><!-- ���� --><strong><font color="#FFFFFF"><fmt:message key="mainMenu.date"/></font></strong></td>
              </tr>
            </table></td>
          <td>&nbsp;</td>
        </tr>
        <tr> 
          <td>&nbsp;</td>
          <td><table width="100%" bgcolor="buttonface">
              <tr> 
                <td>
	            <div id="display" style="float: right; clear: both; width:100%;"></div>
	            <div id="preview" style="font-size: 80%; text-align: center; padding: 2px; width:100%;">&nbsp;</div>
				</td>
              </tr>
            </table></td>
          <td>&nbsp;</td>
        </tr>
        <tr>
          <td>&nbsp;</td>
          <td><table width="100%" bordercolor="#000000" bgcolor="#999999">
              <tr> 
                <td><!-- ���� --><strong><font color="#FFFFFF"><fmt:message key="mainMenu.mytools"/></font></strong></td>
              </tr>
            </table></td>
          <td>&nbsp;</td>
        </tr>
        <tr> 
          <td>&nbsp;</td>
          <td>
			 <table width="100%" border="1" cellpadding="0" cellspacing="0">
			  <tr>
			    <td>
			          <table width="100%" border="0"  background="image/main/normal-bg.gif">
			              <tr  bgcolor="#DDDDDD"> 
			                <td width="10%"><img src="image/main/calendarEvent.gif" width="25" height="25"></td>
			                <td><a href="oaCalendarEvents.html"><!-- �ճ̰��� --><fmt:message key="mainMenu.arrange"/></a></td>
			              </tr>
			              <tr> 
			                <td><img src="image/main/businessCard.gif" width="25" height="25"></td>
			                <td><a href="oaBusinessCards.html"><!-- ��Ƭ���� --><fmt:message key="mainMenu.card"/></a></td>
			              </tr>
			              <tr  bgcolor="#DDDDDD">
			                <td><img src="image/main/pc.gif" width="25" height="25"></td>
			                <td><a href="oaAreaPcs.html"><!-- �ʱ����� --><fmt:message key="mainMenu.zipAreaCode"/></a></td>
			              </tr>
			              <tr> 
			                <td><img src="image/main/city.gif" width="25" height="25"></td>
			                <td><a href="oaAreaCitys.html"><!-- ������Ϣ --><fmt:message key="mainMenu.cityInfo"/></a></td>
			              </tr>
			              <tr  bgcolor="#DDDDDD"> 
			                <td><img src="image/main/calculator.gif" width="25" height="25"></td>
			                <td><a href="calculator.html"><!-- ������ --><fmt:message key="mainMenu.calculator"/></td>
			              </tr>
			              <tr> 
			                <td><img src="image/main/scratchpad.gif" width="25" height="25"></td>
			                <td><a href="oaScratchpads.html"><!-- �ҵı�� --><fmt:message key="mainMenu.memo"/></a></td>
			              </tr>
			            </table>
				</td>
			  </tr>
			</table>           
            

            </td>
          <td>&nbsp;</td>
        </tr>
      </table></td>
  </tr>
</table>
           
            <!--   table end -->
            
            
            
            
            </td>
            <td width="14" background="images/table1/textbox_right.gif"></td>
          </tr>
        </tbody>
      </table></td>
  </tr>
  <tr> 
    <td><table width="100%" border="0" cellpadding="0" cellspacing="0">
        <tbody>
          <tr> 
            <td width="14"><img src="images/table1/textbox_bottom_left.gif" height="19" width="14"></td>
            <td width="100%" background="images/table1/textbox_bottom.gif"></td>
            <td width="14"><img src="images/table1/textbox_bottom_right.gif" height="19" width="14"></td>
          </tr>
        </tbody>
      </table></td>
  </tr>
</table>























