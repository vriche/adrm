
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
import com.vriche.adrm.model.OaWorkFlowCheckResult;
import com.vriche.adrm.service.OaWorkFlowCheckResultManager;
import com.vriche.adrm.webapp.form.OaWorkFlowCheckResultForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaWorkFlowCheckResult object
 *
 * @struts.action name="oaWorkFlowCheckResultForm" path="/oaWorkFlowCheckResults" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaWorkFlowCheckResultForm" path="/editOaWorkFlowCheckResult" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaWorkFlowCheckResultForm" path="/saveOaWorkFlowCheckResult" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/workFlow/oaWorkFlowCheckResultForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/workFlow/oaWorkFlowCheckResultList.jsp"
 * @struts.action-forward name="search" path="/oaWorkFlowCheckResults.html" redirect="true"
 */
public final class OaWorkFlowCheckResultAction extends BaseAction {
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
        OaWorkFlowCheckResultForm oaWorkFlowCheckResultForm = (OaWorkFlowCheckResultForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaWorkFlowCheckResultManager mgr = (OaWorkFlowCheckResultManager) getBean("oaWorkFlowCheckResultManager");
        mgr.removeOaWorkFlowCheckResult(oaWorkFlowCheckResultForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaWorkFlowCheckResult.deleted"));

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

        OaWorkFlowCheckResultForm oaWorkFlowCheckResultForm = (OaWorkFlowCheckResultForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaWorkFlowCheckResultForm.getId() != null) {
            OaWorkFlowCheckResultManager mgr = (OaWorkFlowCheckResultManager) getBean("oaWorkFlowCheckResultManager");
            OaWorkFlowCheckResult oaWorkFlowCheckResult = mgr.getOaWorkFlowCheckResult(oaWorkFlowCheckResultForm.getId());
            oaWorkFlowCheckResultForm = (OaWorkFlowCheckResultForm) convert(oaWorkFlowCheckResult);
            updateFormBean(mapping, request, oaWorkFlowCheckResultForm);
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
        OaWorkFlowCheckResultForm oaWorkFlowCheckResultForm = (OaWorkFlowCheckResultForm) form;
        boolean isNew = ("".equals(oaWorkFlowCheckResultForm.getId()) || oaWorkFlowCheckResultForm.getId() == null);

        OaWorkFlowCheckResultManager mgr = (OaWorkFlowCheckResultManager) getBean("oaWorkFlowCheckResultManager");
        OaWorkFlowCheckResult oaWorkFlowCheckResult = (OaWorkFlowCheckResult) convert(oaWorkFlowCheckResultForm);
        mgr.saveOaWorkFlowCheckResult(oaWorkFlowCheckResult);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaWorkFlowCheckResult.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaWorkFlowCheckResult.updated"));
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

        OaWorkFlowCheckResultForm oaWorkFlowCheckResultForm = (OaWorkFlowCheckResultForm) form;
        OaWorkFlowCheckResult oaWorkFlowCheckResult = (OaWorkFlowCheckResult) convert(oaWorkFlowCheckResultForm);
        OaWorkFlowCheckResultManager mgr = (OaWorkFlowCheckResultManager) getBean("oaWorkFlowCheckResultManager");
        oaWorkFlowCheckResult = null;
        int resultSize = Integer.parseInt(mgr.getOaWorkFlowCheckResultsCount(oaWorkFlowCheckResult));
        Page page = new Page(Constants.OAWORKFLOWCHECKRESULT_LIST,request);        
        PaginatedList pageList = mgr.getOaWorkFlowCheckResultsPage(oaWorkFlowCheckResult,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OAWORKFLOWCHECKRESULT_LIST, pageList);                    
        //request.setAttribute(Constants.OAWORKFLOWCHECKRESULT_LIST, mgr.getOaWorkFlowCheckResults(oaWorkFlowCheckResult));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
