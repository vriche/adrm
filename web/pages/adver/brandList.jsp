<%@ include file="/common/taglibs.jsp"%>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="gbk" contentType="text/html;charset=gbk" %>
<title><fmt:message key="brandList.title"/></title>
<content tag="heading"><fmt:message key="brandList.heading"/></content>
<meta name="menu" content="BrandMenu"/>


<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/brand.js'/>"></script>

<script type="text/javascript" src="<c:url value='/dwr/interface/BrandManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/adver/brandService.js'/>"></script>

<table width="100%" border="0" cellpadding="0" cellspacing="0">
  <tr>
    <td><table background="images/table1/textbox_top.gif" border="0" cellpadding="0" cellspacing="0" width="100%">
        <tbody>
          <tr> 
            <td width="50"><img src="images/table1/textbox_top_left.gif" height="27" width="50"></td>
            <td valign="bottom"><table border="0" cellpadding="0" cellspacing="1" width="100%">
                <tbody>
                  <tr> 
                    <td><span class="tile1">
					   
						<a href="editBrand.html" class="button">&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="button.add"/>&nbsp;&nbsp;&nbsp;&nbsp;</a>
						
						名称：<input name="name" id="name" type=text >
						<input type="button"   class="button" id="btnSearche" value='<fmt:message key="publishArrangeDownload.query"/>'>
					
                    </span>
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


				<table width="100%" border="0" cellpadding="0" cellspacing="0">
			        <tr> 
			          <td> 
			          	<table class=ListShort width="100%" cellpadding="0" >
				             <thead>
				                <tr class=Header> 
					                  <!--品牌名称-->
					                  <TH><fmt:message key="brandForm.name"/></TH>
					                  <!--备注-->
					                  <TH>助记码</TH>
					                  <!--有效-->
					                  <TH><fmt:message key="brandForm.enable"/></TH>
			          			</tr>	
			          			
			          			<tbody id="brandBody"/>
			          		</thead>
			          		<tbody>
					          <tr><td colspan="3">
									<table width="100%" border="0" cellspacing="0" cellpadding="0">
							  				 <tr>
							  				 	 <td colspan="2"><IMG src="image/s.gif"  width="100%" height="2">
							  				 	 </td>
							  				 </tr>
					                        <tr  bgcolor="#D8DFE7">
					                          <td align="right"> 
					                              <div id="pageInfo_brand"></div>
					                          </td>
					                     	</tr>
								  </table>
								  </td>
					          </tr>
				          </tbody>
				       </table>
				          
		          </td>
		         </tr>
		    </table>      

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

