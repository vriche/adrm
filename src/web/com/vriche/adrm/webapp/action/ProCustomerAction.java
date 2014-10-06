
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import java.util.List;

import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.Constants;
import com.vriche.adrm.model.ProCustomer;
import com.vriche.adrm.service.ProCustomerManager;
import com.vriche.adrm.webapp.form.ProCustomerForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a ProCustomer object
 *
 * @struts.action name="proCustomerForm" path="/proCustomers" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="proCustomerForm" path="/editProCustomer" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="proCustomerForm" path="/saveProCustomer" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/merm/proCustomerForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/merm/proCustomerList.jsp"
 * @struts.action-forward name="search" path="/proCustomers.html" redirect="true"
 */
public final class ProCustomerAction extends BaseAction {
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
        ProCustomerForm proCustomerForm = (ProCustomerForm) form;

        // Exceptions are caught by ActionExceptionHandler
        ProCustomerManager mgr = (ProCustomerManager) getBean("proCustomerManager");
        mgr.removeProCustomer(proCustomerForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("proCustomer.deleted"));

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

        ProCustomerForm proCustomerForm = (ProCustomerForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (proCustomerForm.getId() != null) {
            ProCustomerManager mgr = (ProCustomerManager) getBean("proCustomerManager");
            ProCustomer proCustomer = mgr.getProCustomer(proCustomerForm.getId());
            proCustomerForm = (ProCustomerForm) convert(proCustomer);
            updateFormBean(mapping, request, proCustomerForm);
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
        ProCustomerForm proCustomerForm = (ProCustomerForm) form;
        boolean isNew = ("".equals(proCustomerForm.getId()) || proCustomerForm.getId() == null);

        ProCustomerManager mgr = (ProCustomerManager) getBean("proCustomerManager");
        ProCustomer proCustomer = (ProCustomer) convert(proCustomerForm);
        mgr.saveProCustomer(proCustomer);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("proCustomer.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("proCustomer.updated"));
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

        ProCustomerForm proCustomerForm = (ProCustomerForm) form;
        ProCustomer proCustomer = (ProCustomer) convert(proCustomerForm);
        ProCustomerManager mgr = (ProCustomerManager) getBean("proCustomerManager");
        proCustomer = null;
        int resultSize = Integer.parseInt(mgr.getProCustomersCount(proCustomer));
        Page page = new Page(Constants.PROCUSTOMER_LIST,request);        
        List list = mgr.getProCustomersPage(proCustomer,page.getPageIndex().toString(),page.getPageSize().toString());

        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.PROCUSTOMER_LIST, list);                    
        //request.setAttribute(Constants.PROCUSTOMER_LIST, mgr.getProCustomers(proCustomer));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
