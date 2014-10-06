
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.OrderCategory;
import com.vriche.adrm.service.OrderCategoryManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.OrderCategoryForm;

/**
 * Action class to handle CRUD on a OrderCategory object
 *
 * @struts.action name="orderCategoryForm" path="/orderCategorys" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="orderCategoryForm" path="/editOrderCategory" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="orderCategoryForm" path="/saveOrderCategory" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/order/orderCategoryForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/order/orderCategoryList.jsp"
 * @struts.action-forward name="search" path="/orderCategorys.html" redirect="true"
 */
public final class OrderCategoryAction extends BaseAction {
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
        OrderCategoryForm orderCategoryForm = (OrderCategoryForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OrderCategoryManager mgr = (OrderCategoryManager) getBean("orderCategoryManager");
        mgr.removeOrderCategory(orderCategoryForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("orderCategory.deleted"));

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

        OrderCategoryForm orderCategoryForm = (OrderCategoryForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (orderCategoryForm.getId() != null) {
            OrderCategoryManager mgr = (OrderCategoryManager) getBean("orderCategoryManager");
            OrderCategory orderCategory = mgr.getOrderCategory(orderCategoryForm.getId());
            orderCategoryForm = (OrderCategoryForm) convert(orderCategory);
            updateFormBean(mapping, request, orderCategoryForm);
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
        OrderCategoryForm orderCategoryForm = (OrderCategoryForm) form;
        boolean isNew = ("".equals(orderCategoryForm.getId()) || orderCategoryForm.getId() == null);

        OrderCategoryManager mgr = (OrderCategoryManager) getBean("orderCategoryManager");
        OrderCategory orderCategory = (OrderCategory) convert(orderCategoryForm);
        mgr.saveOrderCategory(orderCategory);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("orderCategory.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("orderCategory.updated"));
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

        OrderCategoryForm orderCategoryForm = (OrderCategoryForm) form;
        OrderCategory orderCategory = (OrderCategory) convert(orderCategoryForm);

        OrderCategoryManager mgr = (OrderCategoryManager) getBean("orderCategoryManager");
        request.setAttribute(Constants.ORDERCATEGORY_LIST, mgr.getOrderCategorys(orderCategory));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
