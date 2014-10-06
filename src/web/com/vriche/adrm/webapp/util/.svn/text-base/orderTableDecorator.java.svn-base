package com.vriche.adrm.webapp.util;

import javax.servlet.http.HttpServletRequest;

import org.displaytag.decorator.TableDecorator;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.Income;
import com.vriche.adrm.model.Order;
import com.vriche.adrm.util.Page;
import com.vriche.adrm.util.UserUtil;


public class orderTableDecorator extends TableDecorator {
	  private final String sOrgs;
	  public orderTableDecorator(){
		   sOrgs = UserUtil.getUserOrgs(null);
		   System.out.println(">>>>>>>>>>>>sOrgs>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + sOrgs);
	  }
	  

	  
	  public String getCkecked()
	    {
	        Object obj = this.getCurrentRowObject();
	        Order row = (Order)obj;
	  	    HttpServletRequest request = (HttpServletRequest)this.getPageContext().getRequest();
		    Page page = new Page(Constants.ORDER_LIST,request);
//	        String pageIndex = this.getPageContext().getRequest().getParameter(pageIndexName);
//	        String deco = "<html-el:checkbox name=\"orderList\" property=\"isCkecked\"/>"+ row.get("userId");
		    int lIndex= getListIndex();
	        String deco = "<input type=checkbox name=ckecked value="+  row.getIsCkecked() +">" + page.getPageIndex();
	        return deco;
	   }
	    
	
	  public String getOpernation(){
	        Object obj = this.getCurrentRowObject();
	        Order row = (Order)obj;
		    StringBuffer sb = new StringBuffer();
		    HttpServletRequest request = (HttpServletRequest)this.getPageContext().getRequest();
		    String contextPath = request.getContextPath();
		    String orderStates =  (String)request.getParameter("orderStates");
		    String userId =  (String)request.getParameter("userId");
		    String customerName = request.getParameter("customerForm.customerName");
		    String orderCode = request.getParameter("orderCode");
		    String matterName = request.getParameter("orderPublicForm.matterName");
	        String start_date = request.getParameter("orderPublicForm.publishStartDate");
	        String end_date = request.getParameter("orderPublicForm.publishEndDate");
	        String carrierId = request.getParameter("carrierId");
	        String carrIds = request.getParameter("carrIds");
	        String createBy =  request.getParameter("createBy");
	        
	        String carrierType = request.getParameter("carrierType");
	        if(carrierType ==null || "".equals(carrierType)) carrierType ="P";
	        String cutCates = request.getParameter("cutCates");
	        if(cutCates ==null || "".equals(cutCates)) cutCates ="1";
	        String carrSort = request.getParameter("carrSort");
	        
	        if(carrSort ==null || "".equals(carrSort)){
//	          	  String sOrgs = SysParamUtil.getUserOrgs(null);
//	          	  System.out.println(">>>>>>>>>>>>sOrgs>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + sOrgs);
	              carrSort = sOrgs.split(",")[0];
	        }else{
		         carrSort = carrSort.split("_")[0];
	        }
	        

	        
	        
	        
	        
	        if(customerName == null) customerName = "";
	        if(orderCode == null) orderCode = "";
	        if(matterName == null) matterName = "";
	        if(start_date == null) start_date = "";
	        if(end_date == null) end_date = "";
	        carrIds = carrIds==null?"":carrIds;
	        carrierId = carrierId==null?"":carrierId;
	        
		    orderStates = (orderStates == null)?"":orderStates;
		    userId = (userId == null) ?"":userId;
		    createBy = (createBy == createBy) ?"":createBy;
		    
		 
		    
		    
//		    String cidstr =  (String)request.getParameter("orderMeno");
		    String orderMeno =  (String)request.getParameter("categoryId");
//		    String orderMeno1 =  (String)request.getParameter("orderMeno");
//		    if(cidstr==null){
//		    	orderMeno=null;
//		    }else{
//		    	orderMeno = cidstr.substring(1,cidstr.length()-1);
//		    
//		    }
//		    System.out.println(">>>>>>>>>"+orderMeno);

		    orderMeno = (orderMeno==null||orderMeno.equals("0"))?"":orderMeno;
		    
		    
		    Page page = new Page(Constants.ORDER_LIST,request);
		    
		    sb.append("<TABLE WIDTH=\"100%\"  onClick=\"window.location='" + contextPath +"/editOrder.html?id=" + row.getId() +"&"+ page.getPageIndexName() +"="+ (page.getPageIndex().intValue()+1) +"&orderStates="+ orderStates +"&userId="+ userId+"&categoryId="+ orderMeno+"&customerForm.customerName="+ customerName+"&orderCode="+ orderCode+"&orderPublicForm.matterName="+ matterName+"&orderPublicForm.publishStartDate="+ start_date+"&orderPublicForm.publishEndDate="+ end_date+"&carrIds="+carrIds+"&createBy="+createBy+"&carrierType="+carrierType+"&cutCates="+cutCates+"&carrSort="+carrSort+"'\"><TR>");
//		    sb.append("<TD WIDTH=\"40%\" onClick=\"javascript:if(confirmDelete('OrderDetail')){ window.location='" + contextPath +"/orders.html?id="+ row.getId() +"&method=delete'}\" ><img src=\"image/button_delete.gif\" ></TD>");
//		    sb.append("<TD WIDTH=\"20%\">&nbsp</TD>");
		    sb.append("<TD WIDTH=\"100%\" onClick=\"window.location='" + contextPath +"/editOrder.html?id=" + row.getId() +"&"+ page.getPageIndexName() +"="+ (page.getPageIndex().intValue()+1) +"&orderStates="+ orderStates +"&userId="+ userId+"&categoryId="+ orderMeno+"&customerForm.customerName="+ customerName+"&orderCode="+ orderCode+"&orderPublicForm.matterName="+ matterName+"&orderPublicForm.publishStartDate="+ start_date+"&orderPublicForm.publishEndDate="+ end_date+"&carrIds="+carrIds+"&createBy="+createBy+"&carrierType="+carrierType+"&cutCates="+cutCates+"&carrSort="+carrSort+"'\"><img  style=\"cursor:hand\"  src=\"image/EDIT.GIF\"></TD>");
		    sb.append("</TR></TABLE>");
		    
		    
		    int lIndex= getListIndex();
		    
//		    System.out.println(">>>>>>>>>"+lIndex);


		    return sb.toString();
	  }
	  
	  
	  public String getOrderCode()
	    {
	        Object obj = this.getCurrentRowObject();
	        Order row = (Order)obj;
	  	    HttpServletRequest request = (HttpServletRequest)this.getPageContext().getRequest();
		    String orderStates =  (String)request.getParameter("orderStates");
		    String userId =  (String)request.getParameter("userId");
		    String customerId =  (String)request.getParameter("customerId");
		    String customerName = request.getParameter("customerForm.customerName");
		    String orderCode = request.getParameter("orderCode");
		    String relationCode = request.getParameter("relationCode");
		    String matterName = request.getParameter("orderPublicForm.matterName");
	        String start_date = request.getParameter("orderPublicForm.publishStartDate");
	        String end_date = request.getParameter("orderPublicForm.publishEndDate");
	        String carrierId = request.getParameter("carrierId");
	        String carrIds = request.getParameter("carrIds");
	        String createBy =  request.getParameter("createBy");
	        String version =  request.getParameter("version");
	        
	        String carrierType = request.getParameter("carrierType");
	        if(carrierType ==null || "".equals(carrierType)) carrierType ="P";
	        String cutCates = request.getParameter("cutCates");
	        if(cutCates ==null || "".equals(cutCates)) cutCates ="1";
	        String carrSort = request.getParameter("carrSort");
	        if(carrSort ==null || "".equals(carrSort)){
//	          	  String sOrgs = SysParamUtil.getUserOrgs(null);
//	          	  System.out.println(">>>>>>>>>>>>sOrgs>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + sOrgs);
	              carrSort = sOrgs.split(",")[0];
	        }else{
		        	carrSort = carrSort.split("_")[0];
		        	
	        }
	        
	        
	        
	        if(customerName == null) customerName = "";
	        if(orderCode == null) orderCode = "";
	        if(relationCode == null) relationCode = "";
	        if(matterName == null) matterName = "";
	        if(start_date == null) start_date = "";
	        if(end_date == null) end_date = "";
	        carrIds = carrIds==null?"":carrIds;	
	        carrierId = carrierId==null?"":carrierId;	
		    
//		    System.out.println("customerName   "+customerName);
//		    System.out.println("orderCode   "+orderCode);
		    Page page = new Page(Constants.ORDER_LIST,request);
		    orderStates = (orderStates == null)?"":orderStates;
		    userId = (userId == null) ?"":userId;
		    createBy = (createBy == createBy) ?"":createBy;
		    
//		    String cidstr =  (String)request.getParameter("orderMeno");
		    String orderMeno = (String)request.getParameter("categoryId");
//		    if(cidstr==null){
//		    	orderMeno=null;
//		    }else{
//		    	orderMeno = cidstr.substring(1,cidstr.length()-1);		    
//		    }
//		    System.out.println("orderMeno   "+orderMeno);
		    orderMeno = (orderMeno==null||orderMeno.equals("0"))?"":orderMeno;
		    
//		    String deco = "<a href='" +request.getContextPath() +"/editOrder.html?id=" + row.getId() +"&pageIndex=" +page.getPageIndex() +"&orderStates="+ orderStates +"&userId="+ userId+"'>"; 
		    String deco = "<a href='" +request.getContextPath() +"/editOrder.html?id=" + row.getId() +"&"+ page.getPageIndexName() +"="+ (page.getPageIndex().intValue()+1)+"&version="+ version +"&orderStates="+ orderStates +"&userId="+ userId+"&categoryId="+ orderMeno+"&customerId="+ customerId+"&customerForm.customerName="+ customerName+"&orderCode="+ orderCode+"&orderPublicForm.matterName="+ matterName+"&orderPublicForm.publishStartDate="+ start_date+"&orderPublicForm.publishEndDate="+ end_date+"&carrIds="+carrIds+"&relationCode="+relationCode+"&createBy="+createBy+"&carrierType="+carrierType+"&cutCates="+cutCates+"&carrSort="+carrSort+"'>";
		    deco += "" + row.getOrderCode() +"</a>";
//	        String deco = "<input type=checkbox name=ckecked value="+  row.getIsCkecked() +">" + page.getPageIndex();
	        return deco;
	   }		  
	  
	  
	  
//	  public String getOrderCode()
//	    {
//	        Object obj = this.getCurrentRowObject();
//	        Order row = (Order)obj;
//	  	    HttpServletRequest request = (HttpServletRequest)this.getPageContext().getRequest();
//		    Page page = new Page(Constants.ORDER_LIST,request);
//		    String deco = "<a href='" +request.getContextPath() +"/editOrder.html?id=" + row.getId() +"&pageIndex=" +page.getPageIndex() +"'>";
//		    deco += "" + row.getOrderCode() +"</a>";
////	        String deco = "<input type=checkbox name=ckecked value="+  row.getIsCkecked() +">" + page.getPageIndex();
//	        return deco;
//	   }	  
	  
	  public String getIncomeCode()
	  {
	          Object obj = this.getCurrentRowObject();
	          String deco ="";
	          
	          if(obj != null){
		          Income row = (Income)obj;
		          Object objId = row.getId();
		          if(objId != null){
				      HttpServletRequest request = (HttpServletRequest)this.getPageContext().getRequest();
				      Page page = new Page(Constants.INCOME_LIST,request);
				      String startDate = request.getParameter("startDate");
				      String endDate = request.getParameter("endDate");
				      String customerId = request.getParameter("customerId");
				      String resourceCarrierId = request.getParameter("resourceCarrierId");
				      String customerName = request.getParameter("customerName");
				      
				      if(startDate == null) startDate = "";
				      if(endDate == null) endDate = "";
//				      System.out.println("startDate>>>>>>>>>>>>>   "+ startDate);
//				      System.out.println("endDate>>>>>>>>>>>>>   "+ endDate);
				      
			          int id = row.getId().intValue();
			          String incomeCode = row.getIncomeCode();
			          if(incomeCode == null) incomeCode = "";
//					  String deco = "<a href='" +request.getContextPath() +"/incomes.html?id=" + id +"&"+ page.getPageIndexName() +"="+ (page.getPageIndex().intValue()+1) +"&userId="+ userId+"&customerId="+ customerId+"&customerForm.customerName="+ customerName+"&orderCode="+ orderCode+"&orderPublicForm.publishStartDate="+ start_date+"&orderPublicForm.publishEndDate="+ end_date+"'>";
					  deco = "<a href='" +request.getContextPath() +"/editIncome.html?id=" + id +"&"+ page.getPageIndexName() +"="+ (page.getPageIndex().intValue()+1)+"&startDate="+startDate+"&endDate="+endDate+ "&customerId="+customerId+ "&resourceCarrierId="+resourceCarrierId+ "&customerName="+customerName+ "'>";
					  deco += incomeCode +"</a>";  
					
		          }

	          }

			    
	          return deco; 
	  } 
	    
}
