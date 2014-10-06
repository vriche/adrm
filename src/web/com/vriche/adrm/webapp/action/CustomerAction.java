
package com.vriche.adrm.webapp.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.Customer;
import com.vriche.adrm.service.CustomerManager;
import com.vriche.adrm.util.Page;
import com.vriche.adrm.webapp.form.CustomerForm;


/**
 * Action class to handle CRUD on a Customer object
 *
 * @struts.action name="customerForm" path="/customers" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="customerForm" path="/customersTabList" scope="request"
 *  validate="false" parameter="method" input="listTabs"
 * @struts.action name="customerForm" path="/editCustomer" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="customerForm" path="/saveCustomer" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/crm/customerForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/crm/customerList.jsp"
 * @struts.action-forward name="search" path="/customers.html" redirect="true"
 * @struts.action-forward name="listTabs" path="/WEB-INF/pages/crm/customerFormTab.jsp"
 * 
 */
public final class CustomerAction extends BaseAction {
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
        CustomerForm customerForm = (CustomerForm) form;

        // Exceptions are caught by ActionExceptionHandler
        CustomerManager mgr = (CustomerManager) getBean("customerManager");
        mgr.removeCustomer(customerForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("customer.deleted"));

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

        CustomerForm customerForm = (CustomerForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (customerForm.getId() != null) {
            CustomerManager mgr = (CustomerManager) getBean("customerManager");
            Customer customer = mgr.getCustomer(customerForm.getId());
            customerForm = (CustomerForm) convert(customer);
            updateFormBean(mapping, request, customerForm);
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
        CustomerForm customerForm = (CustomerForm) form;
        boolean isNew = ("".equals(customerForm.getId()) || customerForm.getId() == null);

        CustomerManager mgr = (CustomerManager) getBean("customerManager");
        Customer customer = (Customer) convert(customerForm);
        customer.setParentId("0");
        mgr.saveCustomerForm(customer);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("customer.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("customer.updated"));
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

//        CustomerForm customerForm = (CustomerForm) form;
//        Customer customer = (Customer) convert(customerForm);
//        CustomerManager mgr = (CustomerManager) getBean("customerManager");
//        
//        customer = null;
//        int resultSize = Integer.parseInt(mgr.getCustomersCount(customer));
//        Page page = new Page(Constants.CUSTOMER_LIST,request);
//
//        List pageList = mgr.getCustomersPage(customer,page.getPageIndex().toString(),page.getPageSize().toString());
////        pageList.gotoPage(page.getPageIndex().intValue());      
//
//        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
//        request.setAttribute(Constants.CUSTOMER_LIST, pageList);

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
