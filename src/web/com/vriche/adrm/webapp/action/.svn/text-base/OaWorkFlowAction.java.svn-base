
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
import com.vriche.adrm.model.OaWorkFlow;
import com.vriche.adrm.service.OaWorkFlowManager;
import com.vriche.adrm.webapp.form.OaWorkFlowForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaWorkFlow object
 *
 * @struts.action name="oaWorkFlowForm" path="/oaWorkFlows" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaWorkFlowForm" path="/editOaWorkFlow" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaWorkFlowForm" path="/saveOaWorkFlow" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/workFlow/oaWorkFlowForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/workFlow/oaWorkFlowList.jsp"
 * @struts.action-forward name="search" path="/oaWorkFlows.html" redirect="true"
 */
public final class OaWorkFlowAction extends BaseAction {
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
        OaWorkFlowForm oaWorkFlowForm = (OaWorkFlowForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaWorkFlowManager mgr = (OaWorkFlowManager) getBean("oaWorkFlowManager");
        mgr.removeOaWorkFlow(oaWorkFlowForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaWorkFlow.deleted"));

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

        OaWorkFlowForm oaWorkFlowForm = (OaWorkFlowForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaWorkFlowForm.getId() != null) {
            OaWorkFlowManager mgr = (OaWorkFlowManager) getBean("oaWorkFlowManager");
            OaWorkFlow oaWorkFlow = mgr.getOaWorkFlow(oaWorkFlowForm.getId());
            oaWorkFlowForm = (OaWorkFlowForm) convert(oaWorkFlow);
            updateFormBean(mapping, request, oaWorkFlowForm);
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
        OaWorkFlowForm oaWorkFlowForm = (OaWorkFlowForm) form;
        boolean isNew = ("".equals(oaWorkFlowForm.getId()) || oaWorkFlowForm.getId() == null);

        OaWorkFlowManager mgr = (OaWorkFlowManager) getBean("oaWorkFlowManager");
        OaWorkFlow oaWorkFlow = (OaWorkFlow) convert(oaWorkFlowForm);
        mgr.saveOaWorkFlow(oaWorkFlow);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaWorkFlow.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaWorkFlow.updated"));
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

        OaWorkFlowForm oaWorkFlowForm = (OaWorkFlowForm) form;
        OaWorkFlow oaWorkFlow = (OaWorkFlow) convert(oaWorkFlowForm);
        OaWorkFlowManager mgr = (OaWorkFlowManager) getBean("oaWorkFlowManager");
        oaWorkFlow = null;
        int resultSize = Integer.parseInt(mgr.getOaWorkFlowsCount(oaWorkFlow));
        Page page = new Page(Constants.OAWORKFLOW_LIST,request);        
        PaginatedList pageList = mgr.getOaWorkFlowsPage(oaWorkFlow,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OAWORKFLOW_LIST, pageList);                    
        //request.setAttribute(Constants.OAWORKFLOW_LIST, mgr.getOaWorkFlows(oaWorkFlow));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
