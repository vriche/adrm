
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
import com.vriche.adrm.model.Contract;
import com.vriche.adrm.service.ContractManager;
import com.vriche.adrm.util.Page;
import com.vriche.adrm.webapp.form.ContractForm;

/**
 * Action class to handle CRUD on a Contract object
 *
 * @struts.action name="contractForm" path="/contracts" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="contractForm" path="/editContract" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="contractForm" path="/saveContract" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/order/contractForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/order/contractList.jsp"
 * @struts.action-forward name="search" path="/contracts.html" redirect="true"
 */
public final class ContractAction extends BaseAction {
	

    
	    
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
        ContractForm contractForm = (ContractForm) form;

        // Exceptions are caught by ActionExceptionHandler
        ContractManager mgr = (ContractManager) getBean("contractManager");
        mgr.removeContract(contractForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("contract.deleted"));

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

        ContractForm contractForm = (ContractForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (contractForm.getId() != null) {
            ContractManager mgr = (ContractManager) getBean("contractManager");
            Contract contract = mgr.getContract(contractForm.getId());
            contractForm = (ContractForm) convert(contract);
            updateFormBean(mapping, request, contractForm);
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
        ContractForm contractForm = (ContractForm) form;
        boolean isNew = ("".equals(contractForm.getId()) || contractForm.getId() == null);

        ContractManager mgr = (ContractManager) getBean("contractManager");
      
       
        Contract contract = (Contract) convert(contractForm);
        
        if(isNew) contract.setState(new Long(0));

        mgr.saveContract(contract);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("contract.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("contract.updated"));
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

//        ContractForm contractForm = (ContractForm) form;
//        Contract contract = (Contract) convert(contractForm);
//        ContractManager mgr = (ContractManager) getBean("contractManager");
//        
//        contract = null;
//        
//        int  resultSize = Integer.parseInt(mgr.getContractsCount(contract));
//        Page page = new Page(Constants.CONTRACT_LIST,request);
//        
//        List pageList = mgr.getContractsPage(contract,page.getPageIndex().toString(),page.getPageSize().toString());
////        pageList.gotoPage(page.getPageIndex().intValue());   
//        
//        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));             
//        request.setAttribute(Constants.CONTRACT_LIST, pageList);

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
