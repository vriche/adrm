package com.vriche.adrm.webapp.util;

import javax.servlet.http.HttpServletRequest;

import org.displaytag.decorator.TableDecorator;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.Income;
import com.vriche.adrm.util.Page;
import com.vriche.adrm.util.UserUtil;


public class IncomTableDecorator extends TableDecorator {
	
	  private final String sOrgs;
	  
	  public IncomTableDecorator(){ sOrgs = UserUtil.getUserOrgs(null);}
	  
	

	  public String getCreateBy()
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
//				      String orgId = request.getParameter("orgId");
				      String orgId = row.getOrgId().toString();
				      
				
				      
//				      if(orgId == null) orgId = "1";
				      
				        if(orgId == null){
//				        	 String sOrgs = SysParamUtil.getUserOrgs(null);
//				        	  System.out.println(">>>>>>>>>>>>sOrgs>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + sOrgs);
				        	 orgId = sOrgs.split(",")[0];
				        }
				        
				      
				      if(startDate == null) startDate = "";
				      if(endDate == null) endDate = "";
//				      System.out.println("startDate>>>>>>>>>>>>>   "+ startDate);
//				      System.out.println("endDate>>>>>>>>>>>>>   "+ endDate);
				      
			          int id = row.getId().intValue();
			          String incomeCode = row.getCreateBy().toString();
			          if(incomeCode == null) incomeCode = "";
//					  String deco = "<a href='" +request.getContextPath() +"/incomes.html?id=" + id +"&"+ page.getPageIndexName() +"="+ (page.getPageIndex().intValue()+1) +"&userId="+ userId+"&customerId="+ customerId+"&customerForm.customerName="+ customerName+"&orderCode="+ orderCode+"&orderPublicForm.publishStartDate="+ start_date+"&orderPublicForm.publishEndDate="+ end_date+"'>";
					  deco = "<a href='" +request.getContextPath() +"/editIncome.html?id=" + id +"&"+ page.getPageIndexName() +"="+ (page.getPageIndex().intValue()+1)+"&startDate="+startDate+"&endDate="+endDate+ "&customerId="+customerId+ "&resourceCarrierId="+resourceCarrierId+ "&customerName="+customerName+ "&orgId="+orgId +"'>";
					  deco += incomeCode +"</a>";  
		          }

	          }

			    
	          return deco; 
	  } 
	  
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
//				      String orgId = request.getParameter("orgId");
				      
				      String orgId = row.getOrgId().toString();
				      
//				      if(orgId == null) orgId = "1";
				        if(orgId == null){
//				        	 String sOrgs = SysParamUtil.getUserOrgs(null);
//				        	  System.out.println(">>>>>>>>>>>>sOrgs>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + sOrgs);
				        	 orgId = sOrgs.split(",")[0];
				        }
				        			      
				      
				      if(startDate == null) startDate = "";
				      if(endDate == null) endDate = "";
//				      System.out.println("startDate>>>>>>>>>>>>>   "+ startDate);
//				      System.out.println("endDate>>>>>>>>>>>>>   "+ endDate);
				      
			          int id = row.getId().intValue();
			          String incomeCode = row.getIncomeCode();
			          if(incomeCode == null) incomeCode = "";
//					  String deco = "<a href='" +request.getContextPath() +"/incomes.html?id=" + id +"&"+ page.getPageIndexName() +"="+ (page.getPageIndex().intValue()+1) +"&userId="+ userId+"&customerId="+ customerId+"&customerForm.customerName="+ customerName+"&orderCode="+ orderCode+"&orderPublicForm.publishStartDate="+ start_date+"&orderPublicForm.publishEndDate="+ end_date+"'>";
					  deco = "<a href='" +request.getContextPath() +"/editIncome.html?id=" + id +"&"+ page.getPageIndexName() +"="+ (page.getPageIndex().intValue()+1)+"&startDate="+startDate+"&endDate="+endDate+ "&customerId="+customerId+ "&resourceCarrierId="+resourceCarrierId+ "&customerName="+customerName+ "&orgId="+orgId+"'>";
					  deco += incomeCode +"</a>";  
		          }

	          }

			    
	          return deco; 
	  } 
	    
}
