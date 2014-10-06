
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
import com.vriche.adrm.model.SysPromptMode;
import com.vriche.adrm.service.SysPromptModeManager;
import com.vriche.adrm.webapp.form.SysPromptModeForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a SysPromptMode object
 *
 * @struts.action name="sysPromptModeForm" path="/sysPromptModes" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="sysPromptModeForm" path="/editSysPromptMode" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="sysPromptModeForm" path="/saveSysPromptMode" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/admin/sysPromptModeForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/admin/sysPromptModeList.jsp"
 * @struts.action-forward name="search" path="/sysPromptModes.html" redirect="true"
 */
public final class SysPromptModeAction extends BaseAction {
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
        SysPromptModeForm sysPromptModeForm = (SysPromptModeForm) form;

        // Exceptions are caught by ActionExceptionHandler
        SysPromptModeManager mgr = (SysPromptModeManager) getBean("sysPromptModeManager");
        mgr.removeSysPromptMode(sysPromptModeForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("sysPromptMode.deleted"));

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

        SysPromptModeForm sysPromptModeForm = (SysPromptModeForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (sysPromptModeForm.getId() != null) {
            SysPromptModeManager mgr = (SysPromptModeManager) getBean("sysPromptModeManager");
            SysPromptMode sysPromptMode = mgr.getSysPromptMode(sysPromptModeForm.getId());
            sysPromptModeForm = (SysPromptModeForm) convert(sysPromptMode);
            updateFormBean(mapping, request, sysPromptModeForm);
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
        SysPromptModeForm sysPromptModeForm = (SysPromptModeForm) form;
        boolean isNew = ("".equals(sysPromptModeForm.getId()) || sysPromptModeForm.getId() == null);

        SysPromptModeManager mgr = (SysPromptModeManager) getBean("sysPromptModeManager");
        SysPromptMode sysPromptMode = (SysPromptMode) convert(sysPromptModeForm);
        mgr.saveSysPromptMode(sysPromptMode);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("sysPromptMode.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("sysPromptMode.updated"));
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

        SysPromptModeForm sysPromptModeForm = (SysPromptModeForm) form;
        SysPromptMode sysPromptMode = (SysPromptMode) convert(sysPromptModeForm);
        SysPromptModeManager mgr = (SysPromptModeManager) getBean("sysPromptModeManager");
        sysPromptMode = null;
        int resultSize = Integer.parseInt(mgr.getSysPromptModesCount(sysPromptMode));
        Page page = new Page(Constants.SYSPROMPTMODE_LIST,request);        
        PaginatedList pageList = mgr.getSysPromptModesPage(sysPromptMode,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.SYSPROMPTMODE_LIST, pageList);                    
        //request.setAttribute(Constants.SYSPROMPTMODE_LIST, mgr.getSysPromptModes(sysPromptMode));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
