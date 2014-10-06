<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=gb2312">
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/styles/${appConfig["theme"]}/global.css'/>" />

</head>

<body>
<table width="99%" border="0" cellspacing="0" bordercolor="#CCCCCC">
<tr>
 <td colspan="3"></td>
</tr>

</table>


<TABLE border="0" cellspacing="0" cellpadding="0" style="margin-left:100px">
  <TR> 
    <TD width="535"><TABLE width="526" border="0" cellpadding="10" cellspacing="0" background="<c:url value='/image/merm/013.gif'/>">
        <TR> 
          <TD height="25" colspan="3" background="<c:url value='/image/merm/011.gif'/>"></TD>
        </TR>
        
        <TR> 
          <TD colspan="3" align="left" valign="top" ><table width="100%" border="0" cellspacing="0" bordercolor="#CCCCCC">
              <tr> 
                <td width="17%" rowspan="3"><div align="center"><strong>客户管理</strong></div></td>
                <td width="21%" > 
                  <div align="left">添加客户</div></td>
                <td width="62%" >维护客户基本信息。</td>
              </tr>
              <tr> 
                <td>
<div align="left">供应商</div></td>
                <td bordercolor="#FFFFFF">节目的提供单位。</td>
              </tr>
              <tr> 
                <td>
<div align="left">购买客户</div></td>
                <td bordercolor="#FFFFFF">节目二次发行的购买单位。</td>
              </tr>
              <tr> 
                <td colspan="3" ><div align="center"> 
                    <table width="100%" border="0" style=" border-top:dotted 1px #666666">
                      <tr> 
                        <td height="0"></td>
                      </tr>
                    </table>
                  </div></td>
              </tr>
              <tr> 
                <td rowspan="3"><div align="center"><strong>节目管理</strong></div></td>
                <td><div align="left">节目添加</div></td>
                <td><dl>
                    <dt> 
                      <div align="left">用于综合管理我台计划采购和销售的节目。</div>
                    </dt>
                  </dl></td>
              </tr>
              <tr> 
                <td><div align="left">节目搜索</div></td>
                <td><div align="left">可以根据我台的需要搜索出相应得节目信息，方便我台对已有节目的管理。</div></td>
              </tr>
              <tr> 
                <td><div align="left">播出计划</div></td>
                <td><div align="left">选择节目所要播出的位置，和时间</div></td>
              </tr>
              <tr> 
                <td colspan="3"><table width="100%" border="0" style=" border-top:dotted 1px #666666">
                    <tr> 
                      <td height="0"></td>
                    </tr>
                  </table></td>
              </tr>
              <tr> 
                <td rowspan="2"><div align="center"><strong>订单管理</strong></div></td>
                <td><div align="left">采购订单</div></td>
                <td><div align="left">我台与供应商所签订的订单</div></td>
              </tr>
              <tr> 
                <td><div align="left">销售订单</div></td>
                <td><div align="left">我台与购买客户所签订的订单</div></td>
              </tr>
              <tr> 
                <td colspan="3"><table width="100%" border="0" style=" border-top:dotted 1px #666666">
                    <tr> 
                      <td height="0"></td>
                    </tr>
                  </table></td>
              </tr>
              <tr> 
                <td rowspan="2"><div align="center"><strong>财务结算</strong></div></td>
                <td><div align="left">到款分配</div></td>
                <td><div align="left">平掉我台购买所需的钱或我台销售所卖掉的钱，为欠款查询作数据统计</div></td>
              </tr>
              <tr> 
                <td><div align="left">欠款查询</div></td>
                <td><div align="left">可以查看我台所欠的钱和购买客户欠我台的钱</div></td>
              </tr>
              <tr> 
                <td colspan="3"><table width="100%" border="0" style=" border-top:dotted 1px #666666">
                    <tr> 
                      <td height="0"></td>
                    </tr>
                  </table></td>
              </tr>
              <tr> 
                <td rowspan="4"><div align="center"><strong>统计分析</strong></div></td>
                <td><div align="left">节目成本分析</div></td>
                <td><div align="left">统计某个节目购买时成本</div></td>
              </tr>
              <tr> 
                <td><div align="left">节目收入分析</div></td>
                <td><div align="left">统计某个节目总的收入</div></td>
              </tr>
              <tr> 
                <td><div align="left">节目收视分析</div></td>
                <td><div align="left">统计节目的收视情况</div></td>
              </tr>
              <tr> 
                <td><div align="left">节目综合分析</div></td>
                <td><div align="left">对节目收视率，成本和收入的综合统计</div></td>
              </tr>
              <tr valign="top"> 
                <td colspan="3"><table width="100%" border="0" style=" border-top:dotted 1px #666666">
                    <tr> 
                      <td height="0"></td>
                    </tr>
                  </table></td>
              </tr>
              <tr> 
                <td rowspan="2"><div align="center"><strong>系统维护</strong></div></td>
                <td><div align="left">节目分类</div></td>
                <td><div align="left">在这里我们可以将我台所有节目进行分类，方便统计</div></td>
              </tr>
              <tr> 
                <td><div align="left">上传收视率</div></td>
                <td><div align="left">将外来的数据导入到本系统中，方便我们对节目收视率，成本和收入的综合统计</div></td>
              </tr>
            </table></TD>
        </TR>
        <TR> 
          <TD colspan="3" background="<c:url value='/image/merm/012.gif'/>" height="4"></TD>
        </TR>
      </TABLE>
	  </TD>
    
  </TR>
</TABLE>


<p align="center"><font color="#000033" size="2"> Copyrigt &#169; 2006 VRiche.com 
  Co.,Ltd.</font></p>
</body>
</html>
