
package com.vriche.adrm.webapp.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.Income;
import com.vriche.adrm.service.IncomeManager;
import com.vriche.adrm.util.CarrierUtil;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.Page;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;
import com.vriche.adrm.webapp.form.IncomeForm;

/**
 * Action class to handle CRUD on a Income object
 *
 * @struts.action name="incomeForm" path="/incomes" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="incomeForm" path="/editIncome" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="incomeForm" path="/saveIncome" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/finance/incomeForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/finance/incomeList.jsp"
 * @struts.action-forward name="search" path="/incomes.html" redirect="true"
 */
public final class IncomeAction extends BaseAction {
    public ActionForward cancel(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response)
    throws Exception {
        return mapping.findForward("search");
    }

    public ActionForward delete(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response)
    throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'delete' method");
        }

        ActionMessages messages = new ActionMessages();
        IncomeForm incomeForm = (IncomeForm) form;

        // Exceptions are caught by ActionExceptionHandler
        IncomeManager mgr = (IncomeManager) getBean("incomeManager");
        mgr.removeIncome(incomeForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("income.deleted"));

        // save messages in session, so they'll survive the redirect
        saveMessages(request.getSession(), messages);

        return mapping.findForward("search");
    }

    public ActionForward edit(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request,
                              HttpServletResponse response)
    throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'edit' method");
        }

//        IncomeForm incomeForm = (IncomeForm) form;
//
//        // if an id is passed in, look up the user - otherwise
//        // don't do anything - user is doing an add
//        if (incomeForm.getId() != null) {
//            IncomeManager mgr = (IncomeManager) getBean("incomeManager");
//            Income income = mgr.getIncome(incomeForm.getId());
//            incomeForm = (IncomeForm) convert(income);
//            updateFormBean(mapping, request, incomeForm);
//        }

        return mapping.findForward("edit");
    }

    public ActionForward save(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request,
                              HttpServletResponse response)
    throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'save' method");
        }

        // Extract attributes and parameters we will need
        ActionMessages messages = new ActionMessages();
        IncomeForm incomeForm = (IncomeForm) form;
        boolean isNew = ("".equals(incomeForm.getId()) || incomeForm.getId() == null);

        IncomeManager mgr = (IncomeManager) getBean("incomeManager");
        Income income = (Income) convert(incomeForm);
        mgr.saveIncome(income);
        
        

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("income.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("income.updated"));
            saveMessages(request, messages);

            return mapping.findForward("edit");
        }
    }

    public ActionForward search(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response)
    throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'search' method");
        }

        IncomeForm incomeForm = (IncomeForm) form;
        
     
        

        String start_date = request.getParameter("startDate");
        String end_date = request.getParameter("endDate");
        String startDatePull = request.getParameter("incomeModeName");   
        String endDatePull = request.getParameter("incomePurposeName");
        String resCarrierId = request.getParameter("resourceCarrierId");
        String orgId = request.getParameter("orgId");
        String incomeCode = request.getParameter("incomeCode");
        
        if("".equals(incomeCode)) incomeCode= null;
        
        String pullByCarrier = SysParamUtil.getWithResourceSort()?"0":"1";
       
        
        
//        System.out.println(">>>>>>>>>>>>start_date>>>>>>>>" + start_date);
//        System.out.println(">>>>>>>>>>>>end_date>>>>>>>>" + end_date);
//        System.out.println(">>>>>>>>>>>>resCarrierId>>>>>>>>" + resCarrierId);
        
        if(resCarrierId !=null && !"null".equals(resCarrierId) && !"".equals(resCarrierId)){
        	incomeForm.setResourceCarrierId(resCarrierId);
        }
        
        String resourceCarrierId = incomeForm.getResourceCarrierId();
        
        
        
        String customerName = incomeForm.getCustomerName();
        String incomePullDate = incomeForm.getIncomePullDate();

        if(incomePullDate!=null){
        	incomePullDate = incomePullDate.length()<6?null:incomePullDate;   
        }

//        request.getParameter("customerName"); 
        DateUtil dateUtil = new DateUtil();
        String y =  dateUtil.getServiceDate().substring(0,4);
        start_date = start_date == null||"".endsWith(start_date)?y+"0101":start_date;
        end_date = end_date == null||"".endsWith(end_date)?y+"1231":end_date;
        startDatePull = startDatePull == null||"".endsWith(startDatePull)?y+"0101":startDatePull;
        endDatePull = endDatePull == null||"".endsWith(endDatePull)?y+"1231":endDatePull;
        
//        orgId = orgId == null?"1":orgId;
        System.out.println(">>>>>>>>>1111111111111111111111111111>>>orgId>>>>>>>>" + orgId);
        if(orgId == null){
        	 String sOrgs = UserUtil.getUserOrgs(null);
//        	  System.out.println(">>>>>>>>>>>>sOrgs>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + sOrgs);
        	 orgId = sOrgs.split(",")[0];
        }
        
        
 
        
        incomeForm.setIncomePullDate(incomePullDate);
        incomeForm.setStartDate(start_date);
        incomeForm.setEndDate(end_date);
        incomeForm.setIncomeModeName(startDatePull);
        incomeForm.setIncomePurposeName(endDatePull);
        incomeForm.setOrgId(orgId);
        incomeForm.setIncomeCode(incomeCode);
        
        
//        System.out.println(">>>>>>>>>222222222222222222222222>>>incomePullDate>>>>>>>>" + incomePullDate);
//        System.out.println(">>>>>>>>>222222222222222222222222>>>start_date>>>>>>>>" + start_date);
//        System.out.println(">>>>>>>>>222222222222222222222222>>>end_date>>>>>>>>" + end_date);
//        System.out.println(">>>>>>>>>222222222222222222222222>>>startDatePull>>>>>>>>" + startDatePull);
//        System.out.println(">>>>>>>>>222222222222222222222222>>>endDatePull>>>>>>>>" + endDatePull);
//        System.out.println(">>>>>>>>>222222222222222222222222>>>incomeCode>>>>>>>>" + incomeCode);
//        System.out.println(">>>>>>>>>222222222222222222222222>>>customerId>>>>>>>>" + incomeForm.getCustomerId());
//        System.out.println(">>>>>>>>>222222222222222222222222>>>customerName>>>>>>>>" + customerName);
        
        if (resourceCarrierId == null || "".equals(resourceCarrierId)||"null".equals(resourceCarrierId))incomeForm.setResourceCarrierId("0");

   
        
      
        
        if (customerName != null){
        	 if(customerName.equals("==¿Í»§Ãû³Æ==")||customerName.equals("")||customerName.equals("null")) incomeForm.setCustomerName(null);
        }      
        
        

        
        
        Income income = (Income) convert(incomeForm);
        String carrierId = incomeForm.getResourceCarrierId();
        
        
        String tvname = SysParamUtil.getTvNameParam();
        boolean xmtv = SysParamUtil.isXMTVParam(tvname);
        boolean qztv = SysParamUtil.isQZTVParam(tvname);
        boolean hbtv = SysParamUtil.isHBTVParam(tvname);
        boolean sxtv = SysParamUtil.isSXTVParam(tvname);
        
        System.out.println(">>>>>>>>>222222222222222222222222>>>getResourceCarrierId>>>>>>>>" + carrierId);
        
        if("0".equals(carrierId)){
//        	 carrierId="-100";
        	   income.setResourceCarrierId(new Long(-100));
        }
     
        
        if(xmtv || qztv||hbtv || sxtv){
        	income.setCarrierIdList(null);
//        	income.setResourceCarrierId(null);
        }else{
        	boolean channelPull =  SysParamUtil.getChannelModelPara(); 
            List carrierIdList = CarrierUtil.getCarrierIds(carrierId,"1",null);
//            System.out.println(">>>>>>>>>>>>>>>>carrierId>>>>" + carrierId);
            if("-100".equals(carrierId)||"-1".equals(carrierId)){
            	carrierIdList.add("0"); 
            }
            if("-2".equals(carrierId) ||!channelPull) carrierIdList = new ArrayList();
        	income.setCarrierIdList(carrierIdList);
        	
//        	 System.out.println(">>>>>>>>>>>>carrierIdList>>>>>>>>" + carrierIdList);
        	
//        	income.setResourceCarrierId(null);
        }

        income.setOrgId(new Long(orgId));
        income.setPullByCarrier(pullByCarrier);

        System.out.println(">>>>>>>>>>>>orgId>>>>>>>>" + orgId);
        System.out.println(">>>>>>>>>>>>pullByCarrier>>>>>>>>" + pullByCarrier);
//        System.out.println(">>>>>>>>>>>>income>>>>>>>>" + income);
    	 System.out.println(">>>>>>>>>>>>getCarrierIdList>>>>>>>>" + income.getCarrierIdList());
//    	 income.setCarrierIdList(new ArrayList());
    	 
//        System.out.println(">>>>>>>>>>>>carrierId1>>>>>>>>" + income.getResourceCarrierId().longValue());

        IncomeManager mgr = (IncomeManager) getBean("incomeManager");
    
//        income = null;
        
		boolean financialAuditSwitch = SysParamUtil.getFinancialAuditSwitch();
		
		if(financialAuditSwitch){
			String version = income.getStartDate();
			if(!"".equals(version) && !"0".equals(version) && version != null){
				version = version.substring(0,4);
				List fitterList  = SysParamUtil.getFitterIncomePours(String.valueOf(version));
//				System.out.println("getIncomeCount 123>>>>>>>>>>>>fitterOrderSubCatesList>>>>>>>>" + fitterOrderSubCatesList);
				income.setFitterOrderSubCatesList(fitterList);
			}
		}    
        
        
        
        int  resultSize = Integer.parseInt(mgr.getIncomeCount(income));
        
//        System.out.println(">>>>>>>>>>>>resultSize>>>>>>>>" + resultSize);
        
        Page page = new Page(Constants.INCOME_LIST,request);
//        String pageSize = request.getParameter("pageSize");
//        System.out.println(">>>>>>>>>>>>pageSize>>>>>>>>" + pageSize);
        
        page.setPageSize(new Integer("18"));
        int lastPage = resultSize/page.getPageSize().intValue()+1;
        boolean isLastSumPage = (lastPage == page.getPageIndex().intValue()+1);
        
//		System.out.println(">>>>>>>>>>>>lastPage>>>>>>>>" + lastPage);
//		System.out.println(">>>>>>>>>>>>resultSize>>>>>>>>" + resultSize);
//		System.out.println(">>>>>>>>>>>>PageIndex>>>>>>>>" + page.getPageIndex().toString());
//		System.out.println(">>>>>>>>>>>>isLastSumPage>>>>>>>>" + isLastSumPage);
//		System.out.println(">>>>>>>>>>>>getQueryString>>>>>>>>" + request.getQueryString());
//		System.out.println(">>>>>>>>>>>>getServletPath>>>>>>>>" + request.getServletPath());
//		System.out.println(">>>>>>>>>>>>getContextPath>>>>>>>>" + request.getContextPath());
//		System.out.println(">>>>>>>>>>>>getRequestURI>>>>>>>>" + request.getRequestURI());
//        long start = System.currentTimeMillis();
        
        List pageList = mgr.getIncomesPage2(income,page.getPageIndex().toString(),page.getPageSize().toString(),isLastSumPage);
        resultSize++;
        
//      long end = System.currentTimeMillis();
//      System.out.println("resultSize2>>>>>>>>   "+ (end -start)/1000 +"Ãë");
        
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize)); 
        request.setAttribute(Constants.INCOME_LIST, pageList);   
        
//        String queryString = request.getQueryString();
//        String path = mapping.findForward("list").getPath();
//        String path = request.getServletPath();
//        if(queryString != null)path =path+"?" + queryString;
//        System.out.println(">>>>>>>>>>>>path>>>>>>>>" + path);
        
//        path = path + "?r="+type+"&userid="+userid;
//        ActionForward forward= new ActionForward(path);
//        forward.setRedirect(true);
//        return forward; 


        return mapping.findForward("list");
    }
    
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
    
    
    
    
}
