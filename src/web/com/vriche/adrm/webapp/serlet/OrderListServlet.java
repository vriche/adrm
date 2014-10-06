
package com.vriche.adrm.webapp.serlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xerces.dom.DocumentImpl;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.vriche.adrm.model.Order;
import com.vriche.adrm.service.OrderManager;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.TimeUtil;
import com.vriche.adrm.util.UserUtil;



public class OrderListServlet extends HttpServlet
{
	
	protected final Log log = LogFactory.getLog(getClass());
	  
	private static final long serialVersionUID = 6221461807213123121L;
	
	private static final  boolean isWithoutSubmitParam = SysParamUtil.getWithoutSubmitParam();
	
//	private static final  boolean isOrderDisplayIncomeParam = SysParamUtil.getOrderDisplayIncomeParam();
	
//	private OrderManager mgr = (OrderManager) getBean("orderManager");
//	private UserManager mgrUser = (UserManager) getBean("userManager");
	
	 
	public void service(HttpServletRequest request,	HttpServletResponse response) throws IOException, ServletException
	{

		   String tvName = SysParamUtil.getTvNameParam();
		   
		   boolean isOrderDisplayIncomeParam = SysParamUtil.getOrderDisplayIncomeParam();
		  
		    OrderManager mgr = (OrderManager) getBean("orderManager");
		    
		    
//		    System.out.println("search orders>yyyyyyyyyyyyyyyy>>>"+SysParamUtil.getOrderDisplayIncomeParam());
		
		    
		    
//		    OrderManager  mgr = ServiceLocator.getOrderManager();
		    
//	        UserManager mgrUser = (UserManager) getBean("userManager");
	        
		    String strQueryString = request.getQueryString();
		    
		    System.out.println("service>>>>>>>>>>>>strQueryString>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + strQueryString);   

			
	        
	        int posStart =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"posStart"),"0"));
//	        System.out.println(">>>>>>>>>>>>posStart>>>>>>>>>>>111111111111111>>>>>>>>>>>>>>>>>>>>>>>>>" + posStart);   
	        
	        int scrollTop = Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"scrollTop"),"0"));
	        
//	        System.out.println(">>>>>>>>>>>>scrollTop>>>>>>>>>>>2222222222222222>>>>>>>>>>>>>>>>>>>>>>>>>" + scrollTop);   
	        
//	        int count =  Integer.parseInt(StringUtil.getParamFromUrl(strQueryString,"count"));
	        int count =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"count"),"30"));	
	        
	        int  resultSize = 0;
        	resultSize = Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"total_count"),"0")) ;
        	
//        	 System.out.println(">>>>>>>>>>>>fromEdit>>>>>>>>>>>33333333333333333333>>>>>>>>>>>>>>>>>>>>>>>>>" + StringUtil.getParamFromUrl(strQueryString,"fromEdit"));   
        	 int fromEdit =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"fromEdit"),"0"));
        	 
//        	 boolean isDayRealPlay =  Boolean.valueOf(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"isDayRealPlay"),"0")).booleanValue();
        	 
     
        	
//			  int posStart_bak =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"posStart_bak"),"0"));
//			  if(posStart_bak > 0){
//				  int count_bak =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"count_bak"),"0"));	
//				  int total_count_bak =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"total_count_bak"),"0"));	
//				  posStart = posStart_bak;
//				  count = count_bak;
//				  resultSize= total_count_bak;
//			  }
			  


//	        System.out.println(">>>>>>>>>>>>posStart>>>>222222222222222>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + posStart);             
//	        System.out.println(">>>>>>>>>>>>count>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + count);   
//	        System.out.println(">>>>>>>>>>>>total_count>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + resultSize);  
//	        System.out.println(">>>>>>>>>>>>scrollTop>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + scrollTop);  

        
	    
//	        long start2 = System.currentTimeMillis();

	      	Order order =  mgr.buildParamBy(strQueryString);
	      	
//	      	 System.out.println("search orders>xxxxxxxxxxxxxxxxx>>>"+SysParamUtil.getOrderDisplayIncomeParam());
	      	
//	     	 System.out.println(">>>>>>>>>>>>>>>>>>>>loginUser2>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+order.getLoginUser());
	   
	        Order  objSum  = new Order();
	        
//	        System.out.println("search orders>xxxxxxxx posStart xxxxxxxxx>>>"+posStart);
//	        System.out.println("search orders>xxxxxxxxx fromEdit xxxxxxxx>>>"+fromEdit);
	         
	       
	        if(posStart == 0 || fromEdit > 0){
		    	 		objSum = mgr.getCountSum(order);
//		    	 System.out.println("search orders>xxxxxxxxx objSum xxxxxxxx>>>"+objSum);
	        }else{
//	        	 System.out.println("search orders>xxxxxxxxx resultSize xxxxxxxx>>>"+resultSize);
	        	objSum.setId(new Long(resultSize));
	        }
	        
//	        System.out.println("search orders>xxxxxxxxx getLoginUser xxxxxxxx>>>"+order.getLoginUser());
	        
	        objSum.setLoginUser(order.getLoginUser());
	        
//	        System.out.println("getOrdersPageByDayScroll pageList pageList>>>>>>>>>>>>>>>>>>>>start>>>  " );
	        
//	        System.out.println("search orders>ccccccccccccc>>>"+SysParamUtil.getOrderDisplayIncomeParam());
	        
	        List pageList = (List) mgr.getOrdersPageByDayScroll(false,order,posStart,count);
	        
//	        System.out.println("getOrdersPageByDayScroll pageList pageList>>>>>>>>>>>>>>>>>>>posStart>>>>>>>>>>>>>>>>>>>>  " + posStart);
//	        System.out.println("getOrdersPageByDayScroll pageList pageList>>>>>>>>>>>>>>>>>>>count>>>>>>>>>>>>>>>>>>>>>>>  " + objSum.getId());
//	        System.out.println("getOrdersPageByDayScroll pageList pageList>>>>>>>>>>>>>>>>>>>list>>>>>>>>>>>>>>>>>>>>>>>>  " + pageList.size());
//	        System.out.println("search orders>dddddddddddddddddddddddddddddddddddddddddd>>>"+pageList.size());
	        
//	        long end2 = System.currentTimeMillis();



	        try {
//	        	System.out.println("search orders>eeeeeeeeeeeee>>>"+pageList.size());
				this.createXML(request,response,pageList,objSum,posStart,count,scrollTop,fromEdit,tvName);
//				System.out.println("search orders>ffffffffffffffff>>>"+pageList.size());

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        		
		
	}
	
	private  static String getOrderRowCss(int rowIdx,String choseOrderStates,String orderStates ){

		 String orderDetailRowCss = "";
		 String changColor = "";
		 if(rowIdx%2 == 0){
			 orderDetailRowCss = "uneven";
		 }else{
			 orderDetailRowCss = "even";
		 }		 

		
		
		  if("".equals(choseOrderStates) && !"3".equals(orderStates)){
			  if("0".equals(orderStates)){
				  changColor = "uneven_greed";
			  }else{
				  changColor = "uneven_red";
			  }
			  orderDetailRowCss = orderDetailRowCss.concat(" ").concat(changColor); 
		  }
		  
//		  System.out.println("getOrderRowCss>root>>>>>>>>>>6666666666666666666>>>>>>>>>>>>"+ orderDetailRowCss +">>>>>>>>>>>>>"+ orderStates);
		  
		
		

		return orderDetailRowCss;
	}	
	private  static String getOrderRowCss2(int rowIdx,String choseOrderStates,String orderStates ){

		 String orderDetailRowCss = "";
		 String changColor = "";
		 if(rowIdx%2 == 0){
			 orderDetailRowCss = "uneven";
		 }else{
			 orderDetailRowCss = "even";
		 }		 

		
		  if(!"3".equals(orderStates)){
				  changColor = "uneven_red";
			    orderDetailRowCss = orderDetailRowCss.concat(" ").concat(changColor); 
		  }
		  
//		  System.out.println("getOrderRowCss>root>>>>>>>>>>6666666666666666666>>>>>>>>>>>>"+ orderDetailRowCss +">>>>>>>>>>>>>"+ orderStates);
		  
		
		

		return orderDetailRowCss;
	}	
	//	 Get base XML for grid
	public void createXML(HttpServletRequest request,HttpServletResponse response,List pageList,Order  objSum,int posStart,int count,int scrollTop,int fromEdit,String tvName) throws IOException, ClassNotFoundException, SQLException{
		boolean isWithoutSubmit = SysParamUtil.getWithoutSubmitParam();
		boolean isOrderDisplayRelcode = SysParamUtil.getOrderDisplayRelcodeParam();
		boolean isOrderDisplayIncomeParam = SysParamUtil.getOrderDisplayIncomeParam();
		
		Document xmldoc = new DocumentImpl();
		 Element head,afterInit,call,param,param1,param2,row,cell,userdata;
//		 Node n;
		 
	     String strQueryString = request.getQueryString();
	     
		 int  total_count  = objSum.getId().intValue();
		 
		 if(posStart == 0 && pageList.size()>0){
			 strQueryString =  StringUtil.oldReplace(strQueryString,"total_count=0","total_count="+total_count);
//			 System.out.println("strQueryString>root>>>>>>>>>>>>>>>>>>>>>>new>>>>>>>>>>>>>"+ strQueryString);
		 }
		 
		 String orderStates = StringUtil.getURLDecoderStr(StringUtil.getParamFromUrl(strQueryString,"orderStates"));
//		 int fromEdit =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"fromEdit"),"0"));
		 
		 
//		 String contextPath = request.getContextPath();
		 
		 

//		int posStart = Integer.parseInt( StringUtil.getURLDecoderStr(request.getParameter("posStart")));
//		int count = Integer.parseInt(StringUtil.getURLDecoderStr(request.getParameter("count")));
		 
//			System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>realSum>>>>>>>>>>>>>"+ realSum);
//			System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>moneyIn>>>>>>>>>>>>>"+ moneyIn);

//		System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>posStart>>>>>>>>>>>>>"+ posStart);
//		System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>total_count>>>>>>>>>>>>>"+ total_count);
//		System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>count>>>>>>>>>>>>>"+ count);
//		System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>scrollTop>>>>>>>>>>>>>"+ scrollTop);
//		System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>fromEdit>>>>>>>>>>>>>"+ fromEdit);
//		System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>orderStates>>>>>>>>>>>>>"+ orderStates);


	   response.setContentType("text/xml; charset=UTF-8"); 

	    
	    PrintWriter out = response.getWriter();
	    
	
//	    n = xmldoc.createTextNode("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");

		Element root = xmldoc.createElement("rows");
		root.setAttribute("pos",""+posStart);
		root.setAttribute("total_count",""+total_count);
		root.setAttribute("scrollTop",""+scrollTop);

//		 int coun =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"count"),"0"));	

		
		

		
		if(posStart == 0 && pageList.size()>0 ||fromEdit > 0){
//		if(posStart == 0  ||fromEdit > 0){
			String  realSum = StringUtil.doubleFormat2(objSum.getOrderPublic().getMoneyRealpay());
			String  moneyIn = StringUtil.doubleFormat2(objSum.getOrderPublic().getMoneyIn());
			String  startDate = DateUtil.SetDateFormat(objSum.getOrderPublic().getPublishStartDate().toString(),"yyyy-MM-dd");
			String  endDate   = DateUtil.SetDateFormat(objSum.getOrderPublic().getPublishEndDate().toString(),"yyyy-MM-dd");
			String  useTimeSum  = StringUtil.getNullValue(objSum.getOrderPublic().getUseTime(),"0");
			
//			useTimeSum ="11955";
			
//			System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>useTimeSum 222222222222222222 >>>>>>>>>>>>>"+ useTimeSum);
//			System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>useTimeSum 1111111111111111111 >>>>>>>>>>>>>"+ TimeUtil.stringSecsFormat(Math.round(Double.parseDouble(useTimeSum)*1000)));
			
			useTimeSum = TimeUtil.format2HourMiSe(Math.round(Double.parseDouble(useTimeSum)*1000));
			 if("00:00:00".equals(useTimeSum)) useTimeSum = "";
			
//			useTimeSum = DateUtil.formatTime(Math.round(Double.parseDouble(useTimeSum)*1000),"h m's\"");
//			 if("00'00\"".equals(useTimeSum)) useTimeSum = "";
			
			
//			System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>useTimeSum 222222222222222222 >>>>>>>>>>>>>"+ useTimeSum);
			
			 DecimalFormat df = new DecimalFormat();
			 String style = "##0.##";
	         df.applyPattern(style);
	        
	        String sumTitle ="合计";
	 		String realSum2 ="0";
	 		String moneyIn2 ="0";
//			if(!"catv".equals(tvName)){
//				 sumTitle =sumTitle+"(万)";
//				 realSum2 =Math.round(Double.parseDouble(realSum))/10000;
//				 moneyIn2 =Math.round(Double.parseDouble(moneyIn))/10000;
//			}else{
//				 realSum2 =Math.round(Double.parseDouble(realSum));
//				 moneyIn2 =Math.round(Double.parseDouble(moneyIn));
			 realSum2 = StringUtil.doubleFormat3(new Double(realSum));
			 moneyIn2 = StringUtil.doubleFormat3(new Double(moneyIn));
//			}  

			head = xmldoc.createElementNS(null,"head");
			root.appendChild(head);
			afterInit = xmldoc.createElementNS(null,"afterInit");
			head.appendChild(afterInit);
			call = xmldoc.createElementNS(null,"call");
//			call.setAttribute("command","attachFooter");
			call.setAttribute("command","attachHeader");
			
			afterInit.appendChild(call);
			
			param = xmldoc.createElementNS(null,"param");
			
			if(isOrderDisplayRelcode){ 
				if(isOrderDisplayIncomeParam){
					param.appendChild(xmldoc.createTextNode("*"+ sumTitle +":*"+ total_count +"条 * * * * *"+ startDate +"*"+ endDate +" *"+ realSum2 +" *"+ moneyIn2 +" *"+ useTimeSum +" * *"));
				}else{
					param.appendChild(xmldoc.createTextNode("*"+ sumTitle +":*"+ total_count +"条 * * * * *"+ startDate +"*"+ endDate +" *"+ realSum2 +" * "+ useTimeSum +"* *"));
				}
				
			}else{
				if(isOrderDisplayIncomeParam){
					param.appendChild(xmldoc.createTextNode("*"+ sumTitle +":*"+ total_count +"条 * * * *"+ startDate +"*"+ endDate +" *"+ realSum2 +" *"+ moneyIn2 +" * "+ useTimeSum +"* *"));
				}else{
					param.appendChild(xmldoc.createTextNode("*"+ sumTitle +":*"+ total_count +"条 * * * *"+ startDate +"*"+ endDate +" *"+ realSum2  +" * "+ useTimeSum +"* *"));
				}
				
			}
			
			call.appendChild(param);
			
			param1 = xmldoc.createElementNS(null,"param");//background-color:lightgrey;
			if(isOrderDisplayRelcode){
				if(isOrderDisplayIncomeParam){
					param1.appendChild(xmldoc.createTextNode("color:black;*color:black;*color:black;*color:black;*color:black;*color:black;height:20px;text-align:center;*color:black;height:20px;text-align:center;*color:black;text-align:center;font-size: 11px;*color:black;text-align:center;font-size: 11px;*color:black;text-align:right;font-size: 12px;*color:black;text-align:right;font-size: 12px;*color:black;*color:black;"));
				}else{
					param1.appendChild(xmldoc.createTextNode("color:black;*color:black;*color:black;*color:black;*color:black;*color:black;height:20px;text-align:center;*color:black;height:20px;text-align:center;*color:black;text-align:center;font-size: 11px;*color:black;text-align:center;font-size: 11px;*color:black;text-align:right;font-size: 12px;*color:black;*color:black;"));
				}
				
			}else{
				if(isOrderDisplayIncomeParam){
					param1.appendChild(xmldoc.createTextNode("color:black;*color:black;*color:black;*color:black;*color:black;height:20px;text-align:center;*color:black;height:20px;text-align:center;*color:black;text-align:center;font-size: 11px;*color:black;text-align:center;font-size: 11px;*color:black;text-align:right;font-size: 12px;*color:black;text-align:right;font-size: 12px;*color:black;*color:black;"));
				}else{
					param1.appendChild(xmldoc.createTextNode("color:black;*color:black;*color:black;*color:black;*color:black;height:20px;text-align:center;*color:black;height:20px;text-align:center;*color:black;text-align:center;font-size: 11px;*color:black;text-align:center;font-size: 11px;*color:black;text-align:right;font-size: 12px;*color:black;*color:black;"));
				}
				
			}
			call.appendChild(param1);
		
			param2 = xmldoc.createElementNS(null,"param");
			param2.appendChild(xmldoc.createTextNode("_aFoot"));
			call.appendChild(param2);
		}
		
		

		
	
		
//		call.appendChild(param1);
//		call.appendChild(param2);
	
		
//		String a ="合计,<div id='total_Q' align='left'>大写：</div>,#cspan,#cspan,#cspan,<div id='total_A'>?0.00</div>,#cspan,#cspan,#cspan,#cspan,#cspan,#cspan,#cspan,#cspan,","height:20px;","ftr";
		
		
//	      <head>
//          <column ... >A</column>
//          <column ... >B</column>
//          <column ... >C</column>
//       <afterInit>
//          <call command="attachHeader"><param>A1,B1,C1</param></call>
//          <call command="attachHeader"><param>A2,B2,C2</param></call>
//          <call command="attachFooter"><param>AF,BF,CF</param></call>
//       </afterInit>
//      </head>		
		String loginUser = objSum.getLoginUser();

		boolean tag_order_submitbtn = UserUtil.isGrandedRes(loginUser,"tag_order_submitbtn");

		boolean tag_orderList_check = UserUtil.isGrandedRes(loginUser,"tag_orderList_check");
		
		boolean tag_order_leadmemo = UserUtil.isGrandedRes(loginUser,"tag_order_leadmemo");
		
//		System.out.println(">>>>>>>>>>>>>>>>>>>>tag_order_submitbtn>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+tag_order_submitbtn);
//		System.out.println(">>>>>>>>>>>>>>>>>>>>tag_orderList_check>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+tag_orderList_check);
		
		
		Iterator it = pageList.iterator();
		int k = 0;
		while (it.hasNext()){
			Order order = (Order)it.next();
			
			Long orgId = order.getOrgId();
//			System.out.println("*******************************************orgId********************  "+ orgId);
			
			row = xmldoc.createElementNS(null,"row");
			row.setAttributeNS(null,"id",order.getId().toString());
			
			
			//给不同订单状态上色
			String orderDetailRowCss = "";
			if("hbtv".equals(tvName)){
				 orderDetailRowCss = getOrderRowCss2(k++,orderStates,order.getIsCkecked().toString());
			}else{
				 orderDetailRowCss = getOrderRowCss(k++,orderStates,order.getIsCkecked().toString());
			}

			
			row.setAttributeNS(null,"class",orderDetailRowCss);
		

			cell = xmldoc.createElementNS(null,"cell");
			
			String s = order.getIsCkecked().toString();
			
			if(isWithoutSubmit){
				
				
//				 System.out.println(">>>>>55555555555555555555555555555555555555555555555555555555555>>>>>>" +orderStates);
				
				if( "5".equals(orderStates)||"6".equals(orderStates)||"0".equals(orderStates) ){
					
					 if(tag_orderList_check && ("0".equals(s))){
						 cell.setAttribute("type","ch");
					 }

				}else if("1".equals(orderStates)){
					 if(tag_orderList_check && "0".equals(s)){
						 cell.setAttribute("type","ch");
					 }
					
				}else{
//					cell.appendChild(xmldoc.createTextNode(""+(posStart+(k++))));	
					cell.appendChild(xmldoc.createTextNode(""));	
				}
				
				
				
				
//				if((order.getIsCkecked().longValue() == 0 || order.getIsCkecked().longValue() == 4) && "5".equals(orderStates)){
//					cell.setAttribute("type","ch");
//				}else{
////					cell.appendChild(xmldoc.createTextNode(""+(posStart+(k++))));	
//					cell.appendChild(xmldoc.createTextNode(""));	
//				}
			}else{
				
				
				
				if( "5".equals(orderStates) ){
					
					 if(tag_order_submitbtn && ("0".equals(s)||"4".equals(s))){
						 cell.setAttribute("type","ch");
					 }
					 
					 if(tag_orderList_check && "1".equals(s)){
						 cell.setAttribute("type","ch");
					 }

					 
				}else if(("6".equals(orderStates))){

					 if(tag_order_submitbtn && ("0".equals(s)||"4".equals(s))){
						 cell.setAttribute("type","ch");
					 }

					
				}else if("1".equals(orderStates)){
					
					 if(tag_orderList_check && "1".equals(s)){
						 cell.setAttribute("type","ch");
					 }
					
				}else{
//					cell.appendChild(xmldoc.createTextNode(""+(posStart+(k++))));	
					cell.appendChild(xmldoc.createTextNode(""));	
				}
			}

			
//			else{
//				if(isWithoutSubmitParam){
//					cell.setAttribute("type","link");
//					cell.appendChild(xmldoc.createTextNode("退回^javascript:alert(1);^_self"));	
//				}
//
//			}
			
			row.appendChild(cell);
			
			
			
//		    String deco = "<a href='" +request.getContextPath() +"/editOrder.html?id=" + order.getId() +"&pos="+ posStart +"&orderStates="+ orderStates ;
//		     deco = "&userId="+ userId+"&categoryId="+ orderMeno+"&customerId="+ customerId+"&customerForm.customerName="+ customerName;
//		     deco = "&orderCode="+ orderCode+"&orderPublicForm.matterName="+ matterName+"&orderPublicForm.publishStartDate="+ start_date+"&orderPublicForm.publishEndDate="+ end_date;
//		     deco ="&carrIds="+carrIds+"&relationCode="+relationCode+"&createBy="+createBy+"&carrierType="+carrierType+"&cutCates="+cutCates+"&carrSort="+carrSort+"'>";
//		    	deco += "" + order.getOrderCode() +"</a>";


			Map mp = StringUtil.convertQueryStringtoMap(strQueryString);
			
//			if("sjz".equals(tvName)){
//				mp.put("orgId","1") ;
//			}
			
			
			mp.put("orgId",orgId) ;
			mp.put("id",order.getId());
			strQueryString = StringUtil.map2QueryString(mp);

			String url1 = strQueryString ;
//			String url1 = request.getContextPath()+ "/editOrder.html?"+ strQueryString ;
//			String url1 = "/editOrder.html?"+ strQueryString ;
//			String url1 = request.getContextPath()+ "/editOrder.html?id=" + order.getId() +"&"+ strQueryString ;
			String url2 = "parent.location.href=\""+ request.getContextPath()+ "/editOrder.html?"+ strQueryString +"\"";
			String url3 = "edit_order(\""+ order.getId() +"\")";
//			cell.setAttribute("type","link");
//			cell.appendChild(xmldoc.createTextNode("退回^javascript:alert(1);^_self"));			
			
			
//			sb.append("<userdata name=\"type\">1</userdata>");
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","href");
			userdata.appendChild(xmldoc.createTextNode(url1));
			row.appendChild(userdata);
	
	
			
//			System.out.println("getAuthorList2>root>>>>>>>>"+ url);
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.setAttribute("type","link");
//			cell.setAttributeNS(null,"class",orderDetailRowCss);
//			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(order.getOrderCode())));
//			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(order.getOrderCode())+"^javascript:"+ url2 +";^_self"));
			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(order.getOrderCode())+"^javascript:"+ url3+";^_self"));
			row.appendChild(cell);
			
			
			if(isOrderDisplayRelcode){
				cell = xmldoc.createElementNS(null,"cell");
				cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(order.getRelationCode())));
				row.appendChild(cell);				
			}

			
			
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(order.getContract().getCode())));
			row.appendChild(cell);
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(order.getCustomer().getCustomerName())));
			row.appendChild(cell);
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(order.getOrderPublic().getMatterName())));
			row.appendChild(cell);	
			
			cell = xmldoc.createElementNS(null,"cell");
			String memo = StringUtil.getNullValue(order.getOrderMeno(),"");
			if(tag_order_leadmemo){
				String memoMasterUser = StringUtil.getNullValue(order.getPublishMemo(),"").trim();
				if(!"".equals(memoMasterUser)) memoMasterUser = memoMasterUser+"&nbsp;&nbsp;";
				memo = memoMasterUser  +memo;
			}
			cell.appendChild(xmldoc.createTextNode(memo));
//			cell.appendChild(xmldoc.createTextNode(""));
			row.appendChild(cell);				
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(DateUtil.SetDateFormat(order.getOrderPublic().getPublishStartDate().toString(),"yyyy-MM-dd")));
			row.appendChild(cell);	
			

			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(DateUtil.SetDateFormat(order.getOrderPublic().getPublishEndDate().toString(),"yyyy-MM-dd")));
			row.appendChild(cell);	
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.doubleFormat3(order.getOrderPublic().getMoneyRealpay())));
			row.appendChild(cell);	
			
			if(isOrderDisplayIncomeParam){
				cell = xmldoc.createElementNS(null,"cell");
				cell.appendChild(xmldoc.createTextNode(StringUtil.doubleFormat3(order.getOrderPublic().getMoneyIn())));
				row.appendChild(cell);					
			}

			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(order.getUser().getFullName())));
			row.appendChild(cell);	
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(order.getOrderState().getName())));
			row.appendChild(cell);				

			
			root.appendChild(row);				
		}
	

		xmldoc.appendChild(root);
		
	    OutputFormat format = new OutputFormat(xmldoc);
	    format.setIndenting(true); 
	    XMLSerializer serializer = new XMLSerializer(out,format);
	    
//	    System.out.println(">>>>>>>>>>>>>>xmldoc>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+xmldoc);
		
	    

        try {
			serializer.asDOMSerializer();
			serializer.serialize(xmldoc);
		} catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return;
	}

    public Object getBean(String name) {
        ApplicationContext ctx =  WebApplicationContextUtils.getRequiredWebApplicationContext(this.getServletContext());
        return ctx.getBean(name);
    }
}