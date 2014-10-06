<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="orderDetailList.title"/></title>

<script type="text/javascript" src="<c:url value='/dwr/interface/CarrierManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/ResourceManager.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/PriceTypeManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/resource.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/carrier.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/class/priceType.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/sample/orderService.js'/>"></script>

<content tag="heading"><fmt:message key="oaDocumentFileDetail.heading"/></content>

<table width="50%" border="0" cellpadding="0" cellspacing="0">
					    <tr> 
					      <td nowrap="nowrap" class="dataLabel"><!--�������--> <fmt:message key="orderDetailForm.carrity"/></td>
					      <td><!--�������-->
					           <select name="carrierId" id="carrierId"/>
					       </td>
					    </tr>
                      <tr> 
                        <td class="dataLabel" nowrap="nowrap"><!-- ���λ�� --><fmt:message key="orderDetailForm.posision"/></td> 
                          
                        <td> <select name="resourceInfoId" id="resourceInfoId" ></td>

                      </tr>
                      <tr> 
                        <td class="dataLabel" nowrap="nowrap"><!-- �۸���� --><fmt:message key="orderDetailForm.resourcePriceType"/></td> 
                          
                        <td> <select name="resourcePriceType" id="resourcePriceType" ></td>

                      </tr>     
</table>      