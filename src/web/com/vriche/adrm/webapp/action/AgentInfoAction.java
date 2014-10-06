
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.AgentInfo;
import com.vriche.adrm.service.AgentInfoManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.AgentInfoForm;
import com.vriche.adrm.Constants;
 
/**
 * Action class to handle CRUD on a AgentInfo object
 *
 * @struts.action name="agentInfoForm" path="/agentInfos" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="agentInfoForm" path="/editAgentInfo" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="agentInfoForm" path="/saveAgentInfo" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/crm/agentInfoForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/crm/agentInfoList.jsp"
 * @struts.action-forward name="search" path="/agentInfos.html" redirect="true"
 */
public final class AgentInfoAction extends BaseAction {
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
        AgentInfoForm agentInfoForm = (AgentInfoForm) form;

        // Exceptions are caught by ActionExceptionHandler
        AgentInfoManager mgr = (AgentInfoManager) getBean("agentInfoManager");
        mgr.removeAgentInfo(agentInfoForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("agentInfo.deleted"));

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

        AgentInfoForm agentInfoForm = (AgentInfoForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (agentInfoForm.getId() != null) {
            AgentInfoManager mgr = (AgentInfoManager) getBean("agentInfoManager");
            AgentInfo agentInfo = mgr.getAgentInfo(agentInfoForm.getId());
            agentInfoForm = (AgentInfoForm) convert(agentInfo);
            updateFormBean(mapping, request, agentInfoForm);
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
        AgentInfoForm agentInfoForm = (AgentInfoForm) form;
        boolean isNew = ("".equals(agentInfoForm.getId()) || agentInfoForm.getId() == null);

        AgentInfoManager mgr = (AgentInfoManager) getBean("agentInfoManager");
        AgentInfo agentInfo = (AgentInfo) convert(agentInfoForm);
        mgr.saveAgentInfo(agentInfo);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("agentInfo.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("agentInfo.updated"));
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

        AgentInfoForm agentInfoForm = (AgentInfoForm) form;
        AgentInfo agentInfo = (AgentInfo) convert(agentInfoForm);

        AgentInfoManager mgr = (AgentInfoManager) getBean("agentInfoManager");
        request.setAttribute(Constants.AGENTINFO_LIST, mgr.getAgentInfos(agentInfo));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
