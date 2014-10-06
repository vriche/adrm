
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.CustomerAddress;
import com.vriche.adrm.service.CustomerAddressManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.CustomerAddressForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a CustomerAddress object
 *
 * @struts.action name="customerAddressForm" path="/customerAddresss" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="customerAddressForm" path="/editCustomerAddress" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="customerAddressForm" path="/saveCustomerAddress" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/crm/customerAddressForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/crm/customerAddressList.jsp"
 * @struts.action-forward name="search" path="/customerAddresss.html" redirect="true"
 */
public final class CustomerAddressAction extends BaseAction {
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
        CustomerAddressForm customerAddressForm = (CustomerAddressForm) form;

        // Exceptions are caught by ActionExceptionHandler
        CustomerAddressManager mgr = (CustomerAddressManager) getBean("customerAddressManager");
        mgr.removeCustomerAddress(customerAddressForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("customerAddress.deleted"));

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

        CustomerAddressForm customerAddressForm = (CustomerAddressForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (customerAddressForm.getId() != null) {
            CustomerAddressManager mgr = (CustomerAddressManager) getBean("customerAddressManager");
            CustomerAddress customerAddress = mgr.getCustomerAddress(customerAddressForm.getId());
            customerAddressForm = (CustomerAddressForm) convert(customerAddress);
            updateFormBean(mapping, request, customerAddressForm);
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
        CustomerAddressForm customerAddressForm = (CustomerAddressForm) form;
        boolean isNew = ("".equals(customerAddressForm.getId()) || customerAddressForm.getId() == null);

        CustomerAddressManager mgr = (CustomerAddressManager) getBean("customerAddressManager");
        CustomerAddress customerAddress = (CustomerAddress) convert(customerAddressForm);
        mgr.saveCustomerAddress(customerAddress);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("customerAddress.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("customerAddress.updated"));
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

        CustomerAddressForm customerAddressForm = (CustomerAddressForm) form;
        CustomerAddress customerAddress = (CustomerAddress) convert(customerAddressForm);

        CustomerAddressManager mgr = (CustomerAddressManager) getBean("customerAddressManager");
        request.setAttribute(Constants.CUSTOMERADDRESS_LIST, mgr.getCustomerAddresss(customerAddress));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
