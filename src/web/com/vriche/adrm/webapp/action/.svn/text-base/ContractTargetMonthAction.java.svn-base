
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
import com.vriche.adrm.model.ContractTargetMonth;
import com.vriche.adrm.service.ContractTargetMonthManager;
import com.vriche.adrm.webapp.form.ContractTargetMonthForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a ContractTargetMonth object
 *
 * @struts.action name="contractTargetMonthForm" path="/contractTargetMonths" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="contractTargetMonthForm" path="/editContractTargetMonth" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="contractTargetMonthForm" path="/saveContractTargetMonth" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/order/contractTargetMonthForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/order/contractTargetMonthList.jsp"
 * @struts.action-forward name="search" path="/contractTargetMonths.html" redirect="true"
 */
public final class ContractTargetMonthAction extends BaseAction {
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
        ContractTargetMonthForm contractTargetMonthForm = (ContractTargetMonthForm) form;

        // Exceptions are caught by ActionExceptionHandler
        ContractTargetMonthManager mgr = (ContractTargetMonthManager) getBean("contractTargetMonthManager");
        mgr.removeContractTargetMonth(contractTargetMonthForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("contractTargetMonth.deleted"));

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

        ContractTargetMonthForm contractTargetMonthForm = (ContractTargetMonthForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (contractTargetMonthForm.getId() != null) {
            ContractTargetMonthManager mgr = (ContractTargetMonthManager) getBean("contractTargetMonthManager");
            ContractTargetMonth contractTargetMonth = mgr.getContractTargetMonth(contractTargetMonthForm.getId());
            contractTargetMonthForm = (ContractTargetMonthForm) convert(contractTargetMonth);
            updateFormBean(mapping, request, contractTargetMonthForm);
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
        ContractTargetMonthForm contractTargetMonthForm = (ContractTargetMonthForm) form;
        boolean isNew = ("".equals(contractTargetMonthForm.getId()) || contractTargetMonthForm.getId() == null);

        ContractTargetMonthManager mgr = (ContractTargetMonthManager) getBean("contractTargetMonthManager");
        ContractTargetMonth contractTargetMonth = (ContractTargetMonth) convert(contractTargetMonthForm);
        mgr.saveContractTargetMonth(contractTargetMonth);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("contractTargetMonth.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("contractTargetMonth.updated"));
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

        ContractTargetMonthForm contractTargetMonthForm = (ContractTargetMonthForm) form;
        ContractTargetMonth contractTargetMonth = (ContractTargetMonth) convert(contractTargetMonthForm);
        ContractTargetMonthManager mgr = (ContractTargetMonthManager) getBean("contractTargetMonthManager");
        contractTargetMonth = null;
        int resultSize = Integer.parseInt(mgr.getContractTargetMonthsCount(contractTargetMonth));
        Page page = new Page(Constants.CONTRACTTARGETMONTH_LIST,request);        
        PaginatedList pageList = mgr.getContractTargetMonthsPage(contractTargetMonth,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.CONTRACTTARGETMONTH_LIST, pageList);                    
        //request.setAttribute(Constants.CONTRACTTARGETMONTH_LIST, mgr.getContractTargetMonths(contractTargetMonth));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
