
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.OrderDayInfo;
import com.vriche.adrm.service.OrderDayInfoManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.OrderDayInfoForm;

/**
 * Action class to handle CRUD on a OrderDayInfo object
 *
 * @struts.action name="orderDayInfoForm" path="/orderDayInfos" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="orderDayInfoForm" path="/editOrderDayInfo" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="orderDayInfoForm" path="/saveOrderDayInfo" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/order/orderDayInfoForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/order/orderDayInfoList.jsp"
 * @struts.action-forward name="search" path="/orderDayInfos.html" redirect="true"
 */
public final class OrderDayInfoAction extends BaseAction {
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
        OrderDayInfoForm orderDayInfoForm = (OrderDayInfoForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OrderDayInfoManager mgr = (OrderDayInfoManager) getBean("orderDayInfoManager");
        mgr.removeOrderDayInfo(orderDayInfoForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("orderDayInfo.deleted"));

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

        OrderDayInfoForm orderDayInfoForm = (OrderDayInfoForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (orderDayInfoForm.getId() != null) {
            OrderDayInfoManager mgr = (OrderDayInfoManager) getBean("orderDayInfoManager");
            OrderDayInfo orderDayInfo = mgr.getOrderDayInfo(orderDayInfoForm.getId());
            orderDayInfoForm = (OrderDayInfoForm) convert(orderDayInfo);
            updateFormBean(mapping, request, orderDayInfoForm);
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
        OrderDayInfoForm orderDayInfoForm = (OrderDayInfoForm) form;
        boolean isNew = ("".equals(orderDayInfoForm.getId()) || orderDayInfoForm.getId() == null);

        OrderDayInfoManager mgr = (OrderDayInfoManager) getBean("orderDayInfoManager");
        OrderDayInfo orderDayInfo = (OrderDayInfo) convert(orderDayInfoForm);
        mgr.saveOrderDayInfo(orderDayInfo);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("orderDayInfo.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("orderDayInfo.updated"));
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

        OrderDayInfoForm orderDayInfoForm = (OrderDayInfoForm) form;
        OrderDayInfo orderDayInfo = (OrderDayInfo) convert(orderDayInfoForm);

        OrderDayInfoManager mgr = (OrderDayInfoManager) getBean("orderDayInfoManager");
        request.setAttribute(Constants.ORDERDAYINFO_LIST, mgr.getOrderDayInfos(orderDayInfo));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
