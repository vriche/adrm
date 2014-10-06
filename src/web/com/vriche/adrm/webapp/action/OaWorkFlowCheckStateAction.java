
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
import com.vriche.adrm.model.OaWorkFlowCheckState;
import com.vriche.adrm.service.OaWorkFlowCheckStateManager;
import com.vriche.adrm.webapp.form.OaWorkFlowCheckStateForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaWorkFlowCheckState object
 *
 * @struts.action name="oaWorkFlowCheckStateForm" path="/oaWorkFlowCheckStates" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaWorkFlowCheckStateForm" path="/editOaWorkFlowCheckState" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaWorkFlowCheckStateForm" path="/saveOaWorkFlowCheckState" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/workFlow/oaWorkFlowCheckStateForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/workFlow/oaWorkFlowCheckStateList.jsp"
 * @struts.action-forward name="search" path="/oaWorkFlowCheckStates.html" redirect="true"
 */
public final class OaWorkFlowCheckStateAction extends BaseAction {
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
        OaWorkFlowCheckStateForm oaWorkFlowCheckStateForm = (OaWorkFlowCheckStateForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaWorkFlowCheckStateManager mgr = (OaWorkFlowCheckStateManager) getBean("oaWorkFlowCheckStateManager");
        mgr.removeOaWorkFlowCheckState(oaWorkFlowCheckStateForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaWorkFlowCheckState.deleted"));

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

        OaWorkFlowCheckStateForm oaWorkFlowCheckStateForm = (OaWorkFlowCheckStateForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaWorkFlowCheckStateForm.getId() != null) {
            OaWorkFlowCheckStateManager mgr = (OaWorkFlowCheckStateManager) getBean("oaWorkFlowCheckStateManager");
            OaWorkFlowCheckState oaWorkFlowCheckState = mgr.getOaWorkFlowCheckState(oaWorkFlowCheckStateForm.getId());
            oaWorkFlowCheckStateForm = (OaWorkFlowCheckStateForm) convert(oaWorkFlowCheckState);
            updateFormBean(mapping, request, oaWorkFlowCheckStateForm);
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
        OaWorkFlowCheckStateForm oaWorkFlowCheckStateForm = (OaWorkFlowCheckStateForm) form;
        boolean isNew = ("".equals(oaWorkFlowCheckStateForm.getId()) || oaWorkFlowCheckStateForm.getId() == null);

        OaWorkFlowCheckStateManager mgr = (OaWorkFlowCheckStateManager) getBean("oaWorkFlowCheckStateManager");
        OaWorkFlowCheckState oaWorkFlowCheckState = (OaWorkFlowCheckState) convert(oaWorkFlowCheckStateForm);
        mgr.saveOaWorkFlowCheckState(oaWorkFlowCheckState);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaWorkFlowCheckState.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaWorkFlowCheckState.updated"));
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

        OaWorkFlowCheckStateForm oaWorkFlowCheckStateForm = (OaWorkFlowCheckStateForm) form;
        OaWorkFlowCheckState oaWorkFlowCheckState = (OaWorkFlowCheckState) convert(oaWorkFlowCheckStateForm);
        OaWorkFlowCheckStateManager mgr = (OaWorkFlowCheckStateManager) getBean("oaWorkFlowCheckStateManager");
        oaWorkFlowCheckState = null;
        int resultSize = Integer.parseInt(mgr.getOaWorkFlowCheckStatesCount(oaWorkFlowCheckState));
        Page page = new Page(Constants.OAWORKFLOWCHECKSTATE_LIST,request);        
        PaginatedList pageList = mgr.getOaWorkFlowCheckStatesPage(oaWorkFlowCheckState,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OAWORKFLOWCHECKSTATE_LIST, pageList);                    
        //request.setAttribute(Constants.OAWORKFLOWCHECKSTATE_LIST, mgr.getOaWorkFlowCheckStates(oaWorkFlowCheckState));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
