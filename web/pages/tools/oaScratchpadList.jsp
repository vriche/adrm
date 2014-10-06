<%@ include file="/common/taglibs.jsp"%>

<title><fmt:message key="oaScratchpadList.heading"/></title>

<content tag="heading"><fmt:message key="oaScratchpadList.heading"/></content>
<meta name="menu" content="OaScratchpadMenu"/>

<script type="text/javascript" src="<c:url value='/scripts/common/popupWindow.js'/>"></script>
<script type="text/javascript" src="<c:url value='/scripts/common/autoComplete.js'/>"></script>


<script type="text/javascript" src="<c:url value='/scripts/common/page.js'/>"></script>
<script type="text/javascript" src="<c:url value='/dwr/interface/OaScratchpadManager.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/class/oaScratchpad.js'/>"></script>

<script type="text/javascript" src="<c:url value='/scripts/tools/scratchPadService.js'/>"></script>



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
                    
                    <a class="button" id="Btn_add"> &nbsp;&nbsp;&nbsp;<fmt:message key="button.add"/> &nbsp;&nbsp;&nbsp;</a>
                    
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
          <tr valign="top"> 
            <td background="images/table1/textbox_left.gif" width="14" height="500"></td>
            <td bgcolor="#f4f3f4">


		


	   <table width="20%" border="0" cellspacing="0" cellpadding="0">
	              <thead>
	                <tr class=Header> 
			          
	                  <TH></TH>
	                  <TH></TH>
	                </tr>
                
	              </thead>
	              
	              <tbody id="scratchpadBody"/>
	              
		</table>  


	   <table width="50%" border="0" cellspacing="0" cellpadding="0">
		  				    <tr><td colspan="2"><IMG src="image/s.gif"  width="100%" height="2"></td></tr>
	                        <tr  bgcolor="#D8DFE7"> 
	                          <td align="right"> 
	                              <div id="pageInfo_scratchpad"></div>
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

   	
   	

