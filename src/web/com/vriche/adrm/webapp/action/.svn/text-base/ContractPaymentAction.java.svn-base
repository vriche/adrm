
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.ContractPayment;
import com.vriche.adrm.service.ContractPaymentManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.ContractPaymentForm;

/**
 * Action class to handle CRUD on a ContractPayment object
 *
 * @struts.action name="contractPaymentForm" path="/contractPayments" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="contractPaymentForm" path="/editContractPayment" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="contractPaymentForm" path="/saveContractPayment" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/order/contractPaymentForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/order/contractPaymentList.jsp"
 * @struts.action-forward name="search" path="/contractPayments.html" redirect="true"
 */
public final class ContractPaymentAction extends BaseAction {
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
        ContractPaymentForm contractPaymentForm = (ContractPaymentForm) form;

        // Exceptions are caught by ActionExceptionHandler
        ContractPaymentManager mgr = (ContractPaymentManager) getBean("contractPaymentManager");
        mgr.removeContractPayment(contractPaymentForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("contractPayment.deleted"));

        // save messages in session, so they'll survive the redirect
        saveMessages(request.getSession(), messages);
        
//        return mapping.findForward("search");
        
        response.sendRedirect("editContract.html?id=" + contractPaymentForm.getContractId());
        return null;

    }

    public ActionForward edit(ActionMapping mapping, ActionForm form,
                              HttpServletRequest request,
                              HttpServletResponse response)
    throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'edit' method");
        }

        ContractPaymentForm contractPaymentForm = (ContractPaymentForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (contractPaymentForm.getId() != null) {
            ContractPaymentManager mgr = (ContractPaymentManager) getBean("contractPaymentManager");
            ContractPayment contractPayment = mgr.getContractPayment(contractPaymentForm.getId());
            contractPaymentForm = (ContractPaymentForm) convert(contractPayment);
            updateFormBean(mapping, request, contractPaymentForm);
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
        ContractPaymentForm contractPaymentForm = (ContractPaymentForm) form;
        boolean isNew = ("".equals(contractPaymentForm.getId()) || contractPaymentForm.getId() == null);
        
        String contractID ="0";

        
        ContractPaymentManager mgr = (ContractPaymentManager) getBean("contractPaymentManager");
        ContractPayment contractPayment = (ContractPayment) convert(contractPaymentForm);
        if (isNew) { 
            contractID = request.getParameter("contractId");
            contractPayment.setContractId(new Long(contractID));
        }
        mgr.saveContractPayment(contractPayment);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("contractPayment.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);
//            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("contractPayment.updated"));
            
            contractID = contractPayment.getContractId().toString();
            
            saveMessages(request, messages);

//            return mapping.findForward("edit");
        }
        
  
        response.sendRedirect("editContract.html?id=" + contractID);
        return null;
    }

    public ActionForward search(ActionMapping mapping, ActionForm form,
                                HttpServletRequest request,
                                HttpServletResponse response)
    throws Exception {
        if (log.isDebugEnabled()) {
            log.debug("Entering 'search' method");
        }

        ContractPaymentForm contractPaymentForm = (ContractPaymentForm) form;
        ContractPayment contractPayment = (ContractPayment) convert(contractPaymentForm);

        ContractPaymentManager mgr = (ContractPaymentManager) getBean("contractPaymentManager");
        request.setAttribute(Constants.CONTRACTPAYMENT_LIST, mgr.getContractPayments(contractPayment));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
