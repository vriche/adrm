
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
import com.vriche.adrm.model.OaTeleExpenses;
import com.vriche.adrm.service.OaTeleExpensesManager;
import com.vriche.adrm.webapp.form.OaTeleExpensesForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaTeleExpenses object
 *
 * @struts.action name="oaTeleExpensesForm" path="/oaTeleExpensess" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaTeleExpensesForm" path="/editOaTeleExpenses" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaTeleExpensesForm" path="/saveOaTeleExpenses" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/info/oaTeleExpensesForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/info/oaTeleExpensesList.jsp"
 * @struts.action-forward name="search" path="/oaTeleExpensess.html" redirect="true"
 */
public final class OaTeleExpensesAction extends BaseAction {
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
        OaTeleExpensesForm oaTeleExpensesForm = (OaTeleExpensesForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaTeleExpensesManager mgr = (OaTeleExpensesManager) getBean("oaTeleExpensesManager");
        mgr.removeOaTeleExpenses(oaTeleExpensesForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaTeleExpenses.deleted"));

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

        OaTeleExpensesForm oaTeleExpensesForm = (OaTeleExpensesForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaTeleExpensesForm.getId() != null) {
            OaTeleExpensesManager mgr = (OaTeleExpensesManager) getBean("oaTeleExpensesManager");
            OaTeleExpenses oaTeleExpenses = mgr.getOaTeleExpenses(oaTeleExpensesForm.getId());
            oaTeleExpensesForm = (OaTeleExpensesForm) convert(oaTeleExpenses);
            updateFormBean(mapping, request, oaTeleExpensesForm);
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
        OaTeleExpensesForm oaTeleExpensesForm = (OaTeleExpensesForm) form;
        boolean isNew = ("".equals(oaTeleExpensesForm.getId()) || oaTeleExpensesForm.getId() == null);

        OaTeleExpensesManager mgr = (OaTeleExpensesManager) getBean("oaTeleExpensesManager");
        OaTeleExpenses oaTeleExpenses = (OaTeleExpenses) convert(oaTeleExpensesForm);
        mgr.saveOaTeleExpenses(oaTeleExpenses);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaTeleExpenses.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaTeleExpenses.updated"));
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

        OaTeleExpensesForm oaTeleExpensesForm = (OaTeleExpensesForm) form;
        OaTeleExpenses oaTeleExpenses = (OaTeleExpenses) convert(oaTeleExpensesForm);
        OaTeleExpensesManager mgr = (OaTeleExpensesManager) getBean("oaTeleExpensesManager");
        oaTeleExpenses = null;
        int resultSize = Integer.parseInt(mgr.getOaTeleExpensessCount(oaTeleExpenses));
        Page page = new Page(Constants.OATELEEXPENSES_LIST,request);        
        PaginatedList pageList = mgr.getOaTeleExpensessPage(oaTeleExpenses,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OATELEEXPENSES_LIST, pageList);                    
        //request.setAttribute(Constants.OATELEEXPENSES_LIST, mgr.getOaTeleExpensess(oaTeleExpenses));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
