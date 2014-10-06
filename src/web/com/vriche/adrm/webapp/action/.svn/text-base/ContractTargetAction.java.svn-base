
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.Constants;
import com.vriche.adrm.model.ContractTarget;
import com.vriche.adrm.service.ContractTargetManager;
import com.vriche.adrm.webapp.form.ContractTargetForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a ContractTarget object
 *
 * @struts.action name="contractTargetForm" path="/contractTargets" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="contractTargetForm" path="/editContractTarget" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="contractTargetForm" path="/saveContractTarget" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/order/contractTargetForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/order/contractTargetList.jsp"
 * @struts.action-forward name="search" path="/contractTargets.html" redirect="true"
 */
public final class ContractTargetAction extends BaseAction {
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
        ContractTargetForm contractTargetForm = (ContractTargetForm) form;

        // Exceptions are caught by ActionExceptionHandler
        ContractTargetManager mgr = (ContractTargetManager) getBean("contractTargetManager");
        mgr.removeContractTarget(contractTargetForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("contractTarget.deleted"));

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

        ContractTargetForm contractTargetForm = (ContractTargetForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (contractTargetForm.getId() != null) {
            ContractTargetManager mgr = (ContractTargetManager) getBean("contractTargetManager");
            ContractTarget contractTarget = mgr.getContractTarget(contractTargetForm.getId());
            contractTargetForm = (ContractTargetForm) convert(contractTarget);
            updateFormBean(mapping, request, contractTargetForm);
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
        ContractTargetForm contractTargetForm = (ContractTargetForm) form;
        boolean isNew = ("".equals(contractTargetForm.getId()) || contractTargetForm.getId() == null);

        ContractTargetManager mgr = (ContractTargetManager) getBean("contractTargetManager");
        ContractTarget contractTarget = (ContractTarget) convert(contractTargetForm);
        mgr.saveContractTarget(contractTarget);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("contractTarget.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("contractTarget.updated"));
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

        ContractTargetForm contractTargetForm = (ContractTargetForm) form;
        ContractTarget contractTarget = (ContractTarget) convert(contractTargetForm);
        ContractTargetManager mgr = (ContractTargetManager) getBean("contractTargetManager");
        contractTarget = null;
        int resultSize = Integer.parseInt(mgr.getContractTargetsCount(contractTarget));
        Page page = new Page(Constants.CONTRACTTARGET_LIST,request);        
        PaginatedList pageList = mgr.getContractTargetsPage(contractTarget,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.CONTRACTTARGET_LIST, pageList);                    
        //request.setAttribute(Constants.CONTRACTTARGET_LIST, mgr.getContractTargets(contractTarget));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
