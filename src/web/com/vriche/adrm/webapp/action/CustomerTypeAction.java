
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.CustomerType;
import com.vriche.adrm.service.CustomerTypeManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.CustomerTypeForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a CustomerType object
 *
 * @struts.action name="customerTypeForm" path="/customerTypes" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="customerTypeForm" path="/editCustomerType" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="customerTypeForm" path="/saveCustomerType" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/crm/customerTypeForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/crm/customerTypeList.jsp"
 * @struts.action-forward name="search" path="/customerTypes.html" redirect="true"
 */
public final class CustomerTypeAction extends BaseAction {
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
        CustomerTypeForm customerTypeForm = (CustomerTypeForm) form;

        // Exceptions are caught by ActionExceptionHandler
        CustomerTypeManager mgr = (CustomerTypeManager) getBean("customerTypeManager");
        mgr.removeCustomerType(customerTypeForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("customerType.deleted"));

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

        CustomerTypeForm customerTypeForm = (CustomerTypeForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (customerTypeForm.getId() != null) {
            CustomerTypeManager mgr = (CustomerTypeManager) getBean("customerTypeManager");
            CustomerType customerType = mgr.getCustomerType(customerTypeForm.getId());
            customerTypeForm = (CustomerTypeForm) convert(customerType);
            updateFormBean(mapping, request, customerTypeForm);
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
        CustomerTypeForm customerTypeForm = (CustomerTypeForm) form;
        boolean isNew = ("".equals(customerTypeForm.getId()) || customerTypeForm.getId() == null);

        CustomerTypeManager mgr = (CustomerTypeManager) getBean("customerTypeManager");
        CustomerType customerType = (CustomerType) convert(customerTypeForm);
        mgr.saveCustomerType(customerType);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("customerType.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("customerType.updated"));
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

        CustomerTypeForm customerTypeForm = (CustomerTypeForm) form;
        CustomerType customerType = (CustomerType) convert(customerTypeForm);

        CustomerTypeManager mgr = (CustomerTypeManager) getBean("customerTypeManager");
        request.setAttribute(Constants.CUSTOMERTYPE_LIST, mgr.getCustomerTypes(customerType));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
