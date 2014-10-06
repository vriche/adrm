
package com.vriche.adrm.webapp.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.OrderLog;
import com.vriche.adrm.service.OrderLogManager;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.OrderLogForm;

/**
 * Action class to handle CRUD on a OrderLog object
 *
 * @struts.action name="orderLogForm" path="/orderLogs" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="orderLogForm" path="/editOrderLog" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="orderLogForm" path="/saveOrderLog" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/order/orderLogForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/order/orderLogList.jsp"
 * @struts.action-forward name="search" path="/orderLogs.html" redirect="true"
 */
public final class OrderLogAction extends BaseAction {
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
        OrderLogForm orderLogForm = (OrderLogForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OrderLogManager mgr = (OrderLogManager) getBean("orderLogManager");
        
        if(orderLogForm.getId()==null||"".equals(orderLogForm.getId())){
        	String start_date = request.getParameter("orderForm.orderPublicForm.publishStartDate");
            String end_date = request.getParameter("orderForm.orderPublicForm.publishEndDate");

            DateUtil dateUtil = new DateUtil();
            String y =  dateUtil.getServiceDate().substring(0,4);
            start_date = start_date == null|| start_date.equals("")?y+"0101":start_date;
            end_date = end_date == null||end_date.equals("")?y+"0101":end_date;

//            Date startDate = DateUtil.convertStringToDate(start_date);
//            Date endDate = DateUtil.convertStringToDate(start_date);

            Integer startDate = new Integer(start_date);
            Integer endDate = new Integer(end_date);
            mgr.removeOrderLogList(startDate,endDate);
        }
        else{
            
            mgr.removeOrderLog(orderLogForm.getId());
        }
        

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("orderLog.deleted"));

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

        OrderLogForm orderLogForm = (OrderLogForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (orderLogForm.getId() != null) {
            OrderLogManager mgr = (OrderLogManager) getBean("orderLogManager");
            OrderLog orderLog = mgr.getOrderLog(orderLogForm.getId());
            orderLogForm = (OrderLogForm) convert(orderLog);
            updateFormBean(mapping, request, orderLogForm);
        }

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
        OrderLogForm orderLogForm = (OrderLogForm) form;
        boolean isNew = ("".equals(orderLogForm.getId()) || orderLogForm.getId() == null);

        OrderLogManager mgr = (OrderLogManager) getBean("orderLogManager");
        OrderLog orderLog = (OrderLog) convert(orderLogForm);
        mgr.saveOrderLog(orderLog);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("orderLog.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("orderLog.updated"));
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

        OrderLogForm orderLogForm = (OrderLogForm) form;
        OrderLog orderLog = (OrderLog) convert(orderLogForm);
        
        OrderLogManager mgr = (OrderLogManager) getBean("orderLogManager");
        
        String orderCode = request.getParameter("orderForm.orderCode");
        String modifyBy = request.getParameter("logForm.modifyBy");
 
        String start_date = request.getParameter("orderForm.orderPublicForm.publishStartDate");
        String end_date = request.getParameter("orderForm.orderPublicForm.publishEndDate");
        
        DateUtil dateUtil = new DateUtil();
        String y =  dateUtil.getServiceDate().substring(0,4);
        start_date = start_date == null|| start_date.equals("")?y+"0101":start_date;
        end_date = end_date == null||end_date.equals("")?y+"1231":end_date;

//        Date startDate = DateUtil.convertStringToDate(start_date);
//        Date endDate = DateUtil.convertStringToDate(start_date);
//        
//        System.out.println("start_date33333333333<<<<<<<<<<<<<<<<<<<"+startDate);
//        System.out.println("end_date4444444444444444<<<<<<<<<<<<<<<<<"+endDate);
        Integer startDate = new Integer(start_date);
        Integer endDate = new Integer(end_date);
        
        if(modifyBy != null && !"".equals(modifyBy)){
        	orderLog.getLog().setModifyBy(new Long(modifyBy));
        }
      
        if(orderCode != null && !"".equals(orderCode)){
        	orderLog.getOrder().setOrderCode(orderCode);
//        	System.out.println("orderCode 1111<<<<<<<<<<<<<<<<<<<"+orderCode);
        }
        request.setAttribute(Constants.ORDERLOG_LIST, mgr.getOrderLogLists(orderLog,startDate,endDate));
        
//        request.setAttribute(Constants.ORDERLOG_LIST, mgr.getOrderLogs(orderLog));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
