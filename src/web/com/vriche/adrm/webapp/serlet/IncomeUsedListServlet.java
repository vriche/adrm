package com.vriche.adrm.webapp.serlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.xerces.dom.DocumentImpl;
import org.apache.xml.serialize.OutputFormat;
import org.apache.xml.serialize.XMLSerializer;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.Customer;
import com.vriche.adrm.model.Matter;
import com.vriche.adrm.model.Order;
import com.vriche.adrm.model.OrderDetail;
import com.vriche.adrm.model.OrderPublic;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.model.ResourceChannel;
import com.vriche.adrm.model.User;
import com.vriche.adrm.service.OrderDetailManager;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.StringUtil;
import com.vriche.adrm.util.SysParamUtil;

public class IncomeUsedListServlet  extends HttpServlet {
	
	public void service(HttpServletRequest request,	HttpServletResponse response) throws IOException, ServletException
	{
		
		 
		 
		OrderDetailManager mgr = (OrderDetailManager) getBean("orderDetailManager");
		
		String tvName = SysParamUtil.getTvNameParam();
		
		String strQueryString = request.getQueryString();
		
		int incomeId =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"incomeId"),"0"));
		int posStart =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"posStart"),"0"));
		int scrollTop = Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"scrollTop"),"0"));
		int count =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"count"),"30"));	
		int  resultSize = 0;
		resultSize = Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"total_count"),"0")) ;
//      	 System.out.println(">>>>>>>>>>>>fromEdit>>>>>>>>>>>33333333333333333333>>>>>>>>>>>>>>>>>>>>>>>>>" + StringUtil.getParamFromUrl(strQueryString,"fromEdit"));   
		int fromEdit =  Integer.parseInt(StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"fromEdit"),"0"));
      	 	
		String allchecked = StringUtil.getNullValue(StringUtil.getParamFromUrl(strQueryString,"allchecked"),"0");
		
//		Map searchMap = StringUtil.convertQueryStringtoMap(strQueryString);
      	
//    if(incomeId > 0) count = 1000;
		
		Map searchMap = mgr.buildsearchMap(strQueryString);


//		System.out.println("PaymentListServlet>>>>>>>> strQueryString>>>>>>>>>>>>>>:"+strQueryString);
	
		
	
		OrderDetail objSum =  new OrderDetail();
		
        if(posStart == 0 || fromEdit > 0){
//        	 System.out.println("search orders>xxxxxxxxx objSum xxxxxxxx>>>"+objSum);
//        	 System.out.println("search orders>xxxxxxxxx objSum xxxxxxxx>>>"+objSum.getId());
        		objSum = mgr.getCountSum(searchMap);
	    	
        }else{
//        	 System.out.println("search orders>xxxxxxxxx resultSize xxxxxxxx>>>"+resultSize);
        	 objSum.setId( new Long(resultSize));
        			}
        
//          System.out.println("search orders>xxxxxxxxx resultSize xxxxxxxx>>>"+resultSize);
//          System.out.println("search orders>xxxxxxxxx incomeId xxxxxxxx>>>"+incomeId);
          List pageList =(List) mgr.getMonthDetailByIncomeId(searchMap,"1",posStart,count);
          
//          List pageList = new ArrayList();
//          if(incomeId > 0){
//        	   pageList = (List) mgr.getMonthDetailByIncomeId(searchMap,"1",0,objSum.getId().intValue());
//          }else{
//        	   pageList = (List) mgr.getMonthDetailByIncomeId(searchMap,"1",posStart,count);
//          					}


//         count = pageList.size();
         
//        System.out.println("PaymentListServlet>>>>>>>> pageList>>>>>>>>>>>>>>:"+pageList.size());


        try {
    
			this.createXML(request,response,pageList,objSum,posStart,count,scrollTop,fromEdit,tvName,allchecked);
		

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
	
	
//	 Get base XML for grid
	public void createXML(HttpServletRequest request,HttpServletResponse response,List pageList,OrderDetail  objSum,int posStart,int count,int scrollTop,int fromEdit,String tvName,String allchecked) throws IOException, ClassNotFoundException, SQLException{

//		boolean isOrderDisplayIncomeParam = SysParamUtil.getOrderDisplayIncomeParam();
		
		Document xmldoc = new DocumentImpl();
		 Element head,afterInit,call,param,param1,param2,row,cell,userdata;
//		 Node n;
		 
	     String strQueryString = request.getQueryString();
//	     System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>aaaaaa>>>>>>>>>>>>>"+ objSum.getId());
		 int  total_count  = Integer.parseInt(objSum.getId().toString());
//		 System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>bbbbb>>>>>>>>>>>>>"+ objSum.getId());
//		 int  total_count  = 15;
		 
		 if(posStart == 0 && pageList.size()>0){
//			 System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>posStart>>>>>>>>>>>>>"+ posStart);
			 strQueryString =  StringUtil.oldReplace(strQueryString,"total_count=0","total_count="+total_count);
//			 System.out.println("strQueryString>root>>>>>>>>>>>>>>>>>>>>>>new>>>>>>>>>>>>>"+ strQueryString);
		 }


		System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>posStart>>>>>>>>>>>>>"+ posStart);
//		System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>total_count>>>>>>>>>>>>>"+ total_count);
//		System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>count>>>>>>>>>>>>>"+ count);
//		System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>scrollTop>>>>>>>>>>>>>"+ scrollTop);
//		System.out.println("getAuthorList2>root>>>>>>>>>>>>>>>>>>>>>>fromEdit>>>>>>>>>>>>>"+ fromEdit);



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
			String  moneyReal = StringUtil.doubleFormat3(objSum.getMoneyRealpay());
			String  moneyIn = StringUtil.doubleFormat3(objSum.getMoneyBalance());
		
			 DecimalFormat df = new DecimalFormat();
			 String style = "##0.##";
	         df.applyPattern(style);
	        
	        String sumTitle ="合计";
	 		long realSum2 =0;
//			double moneyIn2 =0;
			long releave2 =0;

//			moneyIn2 =Double.parseDouble(moneyIn); 
		
//			String realSum2 = StringUtil.doubleFormat2(objSum.getIncomeMoney());
//			String moneyIn2 =StringUtil.doubleFormat2(objSum.getIncomeUsed()); 
//			String releave2 =StringUtil.doubleFormat2(new Double(objSum.getIncomeMoney().doubleValue()-objSum.getIncomeMoney().doubleValue())); 

			head = xmldoc.createElementNS(null,"head");
			root.appendChild(head);
			afterInit = xmldoc.createElementNS(null,"afterInit");
			head.appendChild(afterInit);
			call = xmldoc.createElementNS(null,"call");
//			call.setAttribute("command","attachFooter");
			call.setAttribute("command","attachHeader");
			
			afterInit.appendChild(call);
			
			param = xmldoc.createElementNS(null,"param");
//			param.appendChild(xmldoc.createTextNode(" ,"+ sumTitle +":,"+ total_count +"条 , , , ,"+ df.format(realSum2)  +" ,"+ df.format(moneyIn2)+" ,"+ df.format(releave2)+" , , , ,"));	

//			param.appendChild(xmldoc.createTextNode(sumTitle +":,"+ total_count +"条 , , , ,"+ df.format(realSum2)  +" ,"+ df.format(moneyIn2)+" ,"+ df.format(releave2)+" , , , ,"));	
			param.appendChild(xmldoc.createTextNode("* *"+ sumTitle +":*"+ total_count +"条 * * * * * * * * "+ moneyReal +"*"+moneyIn));	

			call.appendChild(param);
			
			param1 = xmldoc.createElementNS(null,"param");//background-color:lightgrey;
			param1.appendChild(xmldoc.createTextNode("color:black;*color:black;*color:black;*color:black;*color:black;*color:black;*color:black;*color:black;*color:black;*color:black;*color:black;*color:black;text-align:right;font-size: 11px;font-size: 11px;"));			
//			param1.appendChild(xmldoc.createTextNode("color:black;*color:black;*color:black;*color:black;*color:black;*color:black;*color:black;height:20px;text-align:right;font-size: 11px;*color:black;text-align:right;font-size: 11px;*color:black;text-align:right;font-size: 11px;*color:black;text-align:right;font-size: 11px;*color:black;text-align:right;font-size: 12px;*color:black;"));			
			call.appendChild(param1);
		
			param2 = xmldoc.createElementNS(null,"param");
			param2.appendChild(xmldoc.createTextNode("_aFoot"));
			call.appendChild(param2);
		}
		
		

		
	

//		String loginUser = objSum.getLoginUser();


		
//		System.out.println(">>>>>>>>>>>>>>>>>>>>tag_order_submitbtn>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+tag_order_submitbtn);
//		System.out.println(">>>>>>>>>>>>>>>>>>>>tag_orderList_check>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  "+tag_orderList_check);
		
		
		Iterator it = pageList.iterator();
		int k = 1;
		while (it.hasNext()){
			OrderDetail orderDetail =(OrderDetail)it.next();
			Order order = orderDetail.getOrder();
			Customer customer = order.getCustomer();
			Resource resource = orderDetail.getResource();
			Carrier carrier = resource.getCarrier();
			User user = order.getUser();
			Matter matter = orderDetail.getMatter();
			OrderPublic orderPublic = order.getOrderPublic();
			ResourceChannel resourceChannel =carrier.getResourceChannel();
			
			

			
//			System.out.println(">>>>>>>>>>>>>>>>>>>>tag_orderList_check>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  ");
			
//			<resultMap id="resultGetMonthDetailByIncomeId" class="orderDetail">
//			<result property="order.orderPublic.incomeCode" column="income_code"  nullValue=""/> 
//			<result property="order.orderCode" column="order_code"  nullValue=""/>
//			<result property="order.orderPublic.publishStartDate" column="publish_date"/>
//			<result property="order.customer.customerName" column="customer_name" nullValue=""/>
//			<result property="order.user.firstName" column="first_name"  nullValue=""/>
//			<result property="order.user.lastName" column="last_name"  nullValue=""/>
//			<result property="order.orderPublic.channelName" column="channel_name" nullValue=""/>
//			<result property="resource.resourceName" column="resource_name"  nullValue=""/>
//			<result property="resource.memo" column="resource_meno"  nullValue=""/>
//			<result property="matter.name" column="matter_name"  nullValue=""/>
//			<result property="matter.edit" column="matter_edit"  nullValue=""/>
//			<result property="matter.length" column="matter_len" nullValue=""/>
//			<result property="order.orderPublic.moneyIn" column="money_in"  nullValue="0"/>
//			
//			<result property="order.id" column="order_id"  nullValue="0"/>
//			<result property="order.customer.id" column="customer_id" nullValue="0"/>
//			<result property="resource.carrier.resourceChannel.id" column="resource_mediaorg_id"  nullValue="0"/>
//			<result property="resource.carrier.id" column="ad_resource_carrier_id"  nullValue="0"/>
//			<result property="matter.id" column="adver_matter_id"  nullValue="0"/>		
		
//		</resultMap>	
			
			
//System.out.println(">>>>>>>>>>>>>>>>>>>>tag_orderList_check>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  1");
			
			

//			row = xmldoc.createElementNS(null,"row");
//			row.setAttributeNS(null,"id",orderDetail.getId().toString());
			
			row = xmldoc.createElementNS(null,"row");
			row.setAttributeNS(null,"id",String.valueOf((k++)+posStart));
			
//			System.out.println(">>>>>>>>>>>>>>>>>>>>tag_orderList_check>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+k);
			
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.setAttribute("type","ch");
			cell.appendChild(xmldoc.createTextNode(allchecked));
//			cell.setAttribute("checked","1");
			row.appendChild(cell);
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(orderPublic.getIncomeCode())));
			row.appendChild(cell);
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(order.getOrderCode())));
			row.appendChild(cell);
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(DateUtil.SetDateFormat2(StringUtil.null2String(orderPublic.getPublishStartDate()),"yyyy/MM")));
			row.appendChild(cell);	
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(customer.getCustomerName())));
			row.appendChild(cell);	
//System.out.println(">>>>>>>>>>>>>>>>>>>>tag_orderList_check>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  2");		

			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(user.getFullName())));
			row.appendChild(cell);	
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(orderPublic.getChannelName())));
			row.appendChild(cell);			
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(resource.getResourceName()+" "+resource.getMemo())));
			row.appendChild(cell);			
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(matter.getName())));
			row.appendChild(cell);			
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(matter.getEdit())));
			row.appendChild(cell);	
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.null2String(matter.getLength())));
			row.appendChild(cell);			
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.doubleFormat3(orderPublic.getMoneyRealpay())));
			row.appendChild(cell);				
			
			cell = xmldoc.createElementNS(null,"cell");
			cell.appendChild(xmldoc.createTextNode(StringUtil.doubleFormat3(orderPublic.getMoneyIn())));
			row.appendChild(cell);		
			
			
//			System.out.println(">>>>>>>>>>>>>>>>>>>>tag_orderList_check>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>  ");
			
			//给不同订单状态上色
//			String orderDetailRowCss = getOrderRowCss(k++,orderStates,order.getIsCkecked().toString());
//			row.setAttributeNS(null,"class",orderDetailRowCss);


//			Map mp = StringUtil.convertQueryStringtoMap(strQueryString);

			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","orderId");
			userdata.appendChild(xmldoc.createTextNode(order.getId().toString()));
			row.appendChild(userdata);			
			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","customerId");
			userdata.appendChild(xmldoc.createTextNode(customer.getId().toString()));
			row.appendChild(userdata);		
//			System.out.println(">>>>>>>>>>>>>>>>>>>>tag_orderList_check>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>3  ");
			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","userId");
			userdata.appendChild(xmldoc.createTextNode(user.getId().toString()));
			row.appendChild(userdata);		
//			System.out.println(">>>>>>>>>>>>>>>>>>>>tag_orderList_check>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>4  ");
			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","matterId");
			userdata.appendChild(xmldoc.createTextNode(matter.getId().toString()));
			row.appendChild(userdata);				
			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","userId");
			userdata.appendChild(xmldoc.createTextNode(carrier.getResourceChannel().getId().toString()));
			row.appendChild(userdata);		
			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","carrierId");
			userdata.appendChild(xmldoc.createTextNode(carrier.getId().toString()));
			row.appendChild(userdata);		
			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","channelId");
			userdata.appendChild(xmldoc.createTextNode(resourceChannel.getId().toString()));
			row.appendChild(userdata);
			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","publish_month");
			userdata.appendChild(xmldoc.createTextNode(orderPublic.getPublishStartDate().toString()));
			row.appendChild(userdata);	
			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","moneyIn");
			userdata.appendChild(xmldoc.createTextNode(StringUtil.getNullValue(orderPublic.getMoneyIn(),"0")));
			row.appendChild(userdata);					
			
			
			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","incomeId");
			userdata.appendChild(xmldoc.createTextNode(StringUtil.getNullValue(orderPublic.getIncomeId(),"0")));
			row.appendChild(userdata);					
			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","incomePullId");
			userdata.appendChild(xmldoc.createTextNode(StringUtil.getNullValue(orderPublic.getIncomePullId(),"0")));
			row.appendChild(userdata);						
			
			userdata = xmldoc.createElementNS(null,"userdata");
			userdata.setAttribute("name","resourceInfoId");
			userdata.appendChild(xmldoc.createTextNode(StringUtil.getNullValue(orderDetail.getResourceInfoId(),"0")));
			row.appendChild(userdata);				
			
			
//			System.out.println(">>>>>>>>>>>>>>>>>>>>tag_orderList_check>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>5  ");
			
//			System.out.println(">>>>>>>>>>>>>>>>>>>>tag_orderList_check>>>>>>>>>"+ income.getId().toString() +">>>>>>>>>>>>>>"+StringUtil.getNullValue(incomePull.getId(),"0"));
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
