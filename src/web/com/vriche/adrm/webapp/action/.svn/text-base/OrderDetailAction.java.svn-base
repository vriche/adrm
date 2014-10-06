
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.OrderDetail;
import com.vriche.adrm.service.OrderDetailManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.OrderDetailForm;

/**
 * Action class to handle CRUD on a OrderDetail object
 *
 * @struts.action name="orderDetailForm" path="/orderDetails" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="orderDetailForm" path="/editOrderDetail" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="orderDetailForm" path="/saveOrderDetail" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/order/orderDetailForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/order/orderDetailList.jsp"
 * @struts.action-forward name="search" path="/orderDetails.html" redirect="true"
 */
public final class OrderDetailAction extends BaseAction {
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
        OrderDetailForm orderDetailForm = (OrderDetailForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OrderDetailManager mgr = (OrderDetailManager) getBean("orderDetailManager");
        
//        mgr.removeOrderDetail(orderDetailForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("orderDetail.deleted"));

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
        response.setContentType("text/xml; charset=UTF-8");
        OrderDetailForm orderDetailForm = (OrderDetailForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (orderDetailForm.getId() != null) {
            OrderDetailManager mgr = (OrderDetailManager) getBean("orderDetailManager");
            OrderDetail orderDetail = mgr.getOrderDetail(orderDetailForm.getId());
            String orderDetailXML = mgr.getOrderDetailForXML(orderDetailForm.getId());
            orderDetailXML=orderDetailXML.substring(38);
//            System.out.print("-------------------"+orderDetailXML);
            request.setAttribute("aa",orderDetailXML);
            orderDetailForm = (OrderDetailForm) convert(orderDetail);
            updateFormBean(mapping, request, orderDetailForm);
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
        OrderDetailForm orderDetailForm = (OrderDetailForm) form;
        boolean isNew = ("".equals(orderDetailForm.getId()) || orderDetailForm.getId() == null);

        OrderDetailManager mgr = (OrderDetailManager) getBean("orderDetailManager");
        OrderDetail orderDetail = (OrderDetail) convert(orderDetailForm);
        mgr.saveOrderDetail(orderDetail);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("orderDetail.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("orderDetail.updated"));
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

        OrderDetailForm orderDetailForm = (OrderDetailForm) form;
        OrderDetail orderDetail = (OrderDetail) convert(orderDetailForm);

        OrderDetailManager mgr = (OrderDetailManager) getBean("orderDetailManager");
        request.setAttribute(Constants.ORDERDETAIL_LIST, mgr.getOrderDetails(orderDetail));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
