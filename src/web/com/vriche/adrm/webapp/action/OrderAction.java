
package com.vriche.adrm.webapp.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.Order;
import com.vriche.adrm.service.OrderManager;
import com.vriche.adrm.service.UserManager;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.util.Page;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.util.UserUtil;
import com.vriche.adrm.webapp.form.OrderForm;
/**
 * Action class to handle CRUD on a Order object
 *
 * @struts.action name="orderForm" path="/orders" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="orderForm" path="/editOrder" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="orderForm" path="/saveOrder" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/order/orderForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/order/orderListNew.jsp"
 * @struts.action-forward name="search" path="/orders.html" redirect="true"
 */
public final class OrderAction extends BaseAction {
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
        OrderForm orderForm = (OrderForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OrderManager mgr = (OrderManager) getBean("orderManager");
        mgr.removeOrder(orderForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("order.deleted"));

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

//        HttpSession session = request.getSession();
//        session.getServletContext();
        
//        OrderForm orderForm = (OrderForm) form;
//
//        // if an id is passed in, look up the user - otherwise
//        // don't do anything - user is doing an add
//        if (orderForm.getId() != null) {
//            OrderManager mgr = (OrderManager) getBean("orderManager");
//            Order order = mgr.getOrder(orderForm.getId());
//            orderForm = (OrderForm) convert(order);
//            updateFormBean(mapping, request, orderForm);
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
        OrderForm orderForm = (OrderForm) form;
        boolean isNew = ("".equals(orderForm.getId()) || orderForm.getId() == null);

        OrderManager mgr = (OrderManager) getBean("orderManager");
        Order order = (Order) convert(orderForm);
        
        mgr.saveOrder(order);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("order.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);
            
            request.getSession().setAttribute("orderPageList",null);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("order.updated"));
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

			return mapping.findForward("list");
     }

//    public ActionForward search(ActionMapping mapping, ActionForm form,
//                                HttpServletRequest request,
//                                HttpServletResponse response)
//    throws Exception {
//        if (log.isDebugEnabled()) {
//            log.debug("Entering 'search' method");
//        }
//
////        OrderForm orderForm = (OrderForm) form;
//        
////        long start1 = System.currentTimeMillis();
////        Order order = (Order) convert(orderForm);
//        Order order = new Order();
//        
////        long end1 = System.currentTimeMillis();
////        System.out.println("resultSize2>>>>>>>>   "+ (end1 -start1) +"秒");
////        System.out.println("resultSize2>>>>>>>>   "+ (end1 -start1)/1000 +"秒");
//        
//        OrderManager mgr = (OrderManager) getBean("orderManager");
//        UserManager mgrUser = (UserManager) getBean("userManager");
//        
//        String customerName = request.getParameter("customerForm.customerName");
//        String orderCode = request.getParameter("orderCode");
//        
//        String contractCode = request.getParameter("contractForm.code");
//        
//        String start_date = request.getParameter("orderPublicForm.publishStartDate");
//        String end_date = request.getParameter("orderPublicForm.publishEndDate");
//        
////        String start_date = order.getOrderPublic().getPublishStartDate();
////        String end_date = order.getOrderPublic().getPublishEndDate();
//
//        DateUtil dateUtil = new DateUtil();
//        String y =  dateUtil.getServiceDate().substring(0,4);
//        start_date = start_date == null|| start_date.equals("")?y+"0101":start_date;
//        end_date = end_date == null||end_date.equals("")?y+"1231":end_date;
//        
////        start_date = start_date.equals("")?"0":start_date;
////        end_date = end_date.equals("")?"0":end_date;
//        
//        Integer startDate = new Integer(start_date);
//        Integer endDate = new Integer(end_date);
//        
//        
//        String matterName = request.getParameter("orderPublicForm.matterName");
//        String category = request.getParameter("categoryId");
//        String matterId = request.getParameter("matterId");
////        String carrierId = request.getParameter("carrierId");
//        String carrIds = request.getParameter("carrIds");
//        String relationCode = request.getParameter("relationCode");
////        String stateId = request.getParameter("stateId");
//        String orderStates = request.getParameter("orderStates");
//        String userId = request.getParameter("userId");
//        String createBy = request.getParameter("createBy");
//        String cutCates = request.getParameter("cutCates");
//        String carrierType = request.getParameter("carrierType");
//        String carrSort = request.getParameter("carrSort");
//        
//        
//        if(carrSort == null){
//       	    String sOrgs = SysParamUtil.getUserOrgs(null);
////       	    System.out.println(">>>>>>>>>>>>sOrgs>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + sOrgs);
//        	carrSort = sOrgs.split(",")[0];
//       }
//       
//        
//        
////        System.out.println("carrIds<<<<<<<<!22222222222<<<<<<<<<<<<"+carrIds);
//        
//          
//        String selectImportOrder = request.getParameter("publishMemo");//福州台的导入数据查询使用
//        order.setPublishMemo(selectImportOrder);
//        
//        if(createBy != null && !"".equals(createBy)) order.setCreateBy(new Long(createBy));
//       
//        if(userId != null && !"".equals(userId))order.setUserId(new Long(userId));
//        
////        System.out.println("userId  >>>>>>>>   "+  userId);
////        System.out.println("orderStates  >>>>>>>>   "+  orderStates);
//        
////        System.out.println("carrierId  >>>>>>>>   "+  carrierId);
////        System.out.println(carrierId==null);
////        carrierId = carrierId==null?null:carrierId;
//        
////        System.out.println("carrierId2 >>>>>>>>   "+  carrierId);
//
//
//        String moneyS = request.getParameter("orderPublicForm.moneyState");
//        moneyS = moneyS == null||"".equals(moneyS)?"0":moneyS;
//        Integer moneyState = new Integer(moneyS);
//        
//        String moneyR = request.getParameter("orderPublicForm.moneyRealpay");
//        
//        moneyR = moneyR == null||"".equals(moneyR)?"0":moneyR;
//        Double moneyRealpay = new Double(moneyR);
//        
//        order.getCustomer().setCustomerName(customerName);
//        order.getOrderPublic().setMatterName(matterName);
//        order.setOrderCode(orderCode);
////        System.out.println("contractCode<<<<<<<<!111111111111<<<<<<<<<<<<"+contractCode);
//        order.getContract().setCode(contractCode);
//        order.setRelationCode(relationCode);
//        
//     
//        order.getOrderPublic().setPublishStartDate(startDate);
//        order.getOrderPublic().setPublishEndDate(endDate);
//        
// 
//        
////        if(carrierId!=null&&!"".equals(carrierId)){
////        	order.setCarrierId(new Long(carrierId));
////        }else{
////        	order.setCarrierId(new Long(0));
////        }
//        
//        
//        if(carrIds!=null &&!"".equals(carrIds)){
//        	order.setCarrIds(carrIds);
//        }else{
//        	order.setCarrIds("0");
//        }
////        System.out.println("carrIds<<<<<<<<!111111111111<<<<<<<<<<<<"+carrIds);
//        
////        
//        
//        order.setMatterId(matterId);
//        order.getOrderPublic().setMoneyState(moneyState);
//        order.getOrderPublic().setMoneyRealpay(moneyRealpay);
//        order.setOrderCategorys(category);
//        order.setOrderStates(orderStates);
//        
//        
//    	if(SysParamUtil.isXMTVParam(null)){
//    		   order.setCutCates(cutCates);
//    		   if(carrierType ==null || "".equals(carrierType)) carrierType ="P";
//    		   order.setCarrierType(carrierType);
//    	}
//    	
//    	if(SysParamUtil.useMoreCarrierSortParam()){
//    		order.setCarrSort(carrSort);
//    	}
//    	
//    		
//    		
//    	 
//    	    
//     
//        
//        
////        order.setOrderStates(category);
//   
//        
//       
////        long start1 = System.currentTimeMillis();
//        
//
////        Map userRelsMap = (Map)request.getSession().getServletContext().getAttribute(Constants.AVAILABLE_USER_RELS);
////        order.setUsers(mgrUser.getOwnerUsersList(userRelsMap));
//        
////        long end1 = System.currentTimeMillis();
////        System.out.println("1111111111>>>>>>>>   "+ (end1 -start1) +"秒");
////        System.out.println("resultSize2>>>>>>>>   "+ (end1 -start1)/1000 +"秒"); 
//        
//
//        Page page = new Page(Constants.ORDER_LIST,request);
//        page.setPageSize(new Integer("18"));
//        
//        List pageList = new ArrayList();
//    
//        long start2 = System.currentTimeMillis();
////        order.setPage(page);
//    	int pageIndex = page.getPageIndex().intValue();
//    	int pageSize = page.getPageSize().intValue();
//        pageList = mgr.getOrdersPageByUsersCount2(order,pageIndex,pageSize);
//        
//        
//        
//        int  resultSize = Integer.parseInt(String.valueOf(pageList.size()));
////        boolean ii = page.getIsLastPage();
////        System.out.println("pageList resultSize>>>>>>>>>>>  " + resultSize);
////        System.out.println("page.getIsLastPage>>>>>>>>>>>  " + ii);
//        
//        page.setSize(new Integer(resultSize));
//        
////        int  resultSize = Integer.parseInt(mgr.getOrdersPageByUsersCount(order));
//        
////        System.out.println("resultSize>>>>>>>>>>>  " + resultSize);
//        
//        long end2 = System.currentTimeMillis();
//        System.out.println("search orders>>>>>>>>   "+ (end2 -start2) +"秒");
//       
////        int lastPage = resultSize/page.getPageSize().intValue()+1;
////        boolean isLastSumPage = (lastPage == page.getPageIndex().intValue()+1);
// 
////
////        long start3 = System.currentTimeMillis();
////        if(isLastSumPage) pageList = mgr.getOrdersPageByUserSum(isLastSumPage,order,page.getPageIndex().toString(),page.getPageSize().toString());
////        long end3 = System.currentTimeMillis();
////        System.out.println("33333333333333 >>>>>>>>   "+ (end3 -start3) +"秒");
////        System.out.println("getPageIndex>>>>>>>>>>>  " + page.getPageIndex().toString());
//        
////    	System.out.println("resultSize>>>>>>>>>>>  " + resultSize);
////    	System.out.println("lastPage>>>>>>>>>>>  " + lastPage);
////    	System.out.println("page.getPageIndex().intValue()+1>>>>>>>>>>>  " + page.getPageIndex().intValue()+1);
////    	System.out.println("isLastSumPage>>>>>>>>>>>  " + isLastSumPage);
//       
//        int startNo = page.getPageIndex().intValue()*page.getPageSize().intValue();
//        int endNo = startNo+page.getPageSize().intValue();
//        if(endNo>resultSize) endNo = resultSize;
////        System.out.println("startNo>>>>>>>>>>>  " + startNo);
////        System.out.println("endNo>>>>>>>>>>>  " + endNo);
//        pageList = pageList.subList(startNo,endNo);
//        
//        if( page.getPageIndex().intValue() < resultSize/pageSize+1)  resultSize++;
//        
////        System.out.println("pageList resultSize>>>>>>>>>>>  " + page.getPageIndex().intValue() );
////        System.out.println("page.getIsLastPage>>>>>>>>>>>  " + resultSize/pageSize);
////        System.out.println("startNo>>>>>>>>>>>  " + startNo);
////        System.out.println("endNo>>>>>>>>>>>  " + endNo);
//        
////        resultSize++;
//    
//        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize)); 
//        request.setAttribute(Constants.ORDER_LIST, pageList);
//
//        return mapping.findForward("list");
//    }
    
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
