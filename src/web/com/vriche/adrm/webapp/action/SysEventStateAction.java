
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
import com.vriche.adrm.model.SysEventState;
import com.vriche.adrm.service.SysEventStateManager;
import com.vriche.adrm.webapp.form.SysEventStateForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a SysEventState object
 *
 * @struts.action name="sysEventStateForm" path="/sysEventStates" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="sysEventStateForm" path="/editSysEventState" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="sysEventStateForm" path="/saveSysEventState" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/admin/sysEventStateForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/admin/sysEventStateList.jsp"
 * @struts.action-forward name="search" path="/sysEventStates.html" redirect="true"
 */
public final class SysEventStateAction extends BaseAction {
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
        SysEventStateForm sysEventStateForm = (SysEventStateForm) form;

        // Exceptions are caught by ActionExceptionHandler
        SysEventStateManager mgr = (SysEventStateManager) getBean("sysEventStateManager");
        mgr.removeSysEventState(sysEventStateForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("sysEventState.deleted"));

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

        SysEventStateForm sysEventStateForm = (SysEventStateForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (sysEventStateForm.getId() != null) {
            SysEventStateManager mgr = (SysEventStateManager) getBean("sysEventStateManager");
            SysEventState sysEventState = mgr.getSysEventState(sysEventStateForm.getId());
            sysEventStateForm = (SysEventStateForm) convert(sysEventState);
            updateFormBean(mapping, request, sysEventStateForm);
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
        SysEventStateForm sysEventStateForm = (SysEventStateForm) form;
        boolean isNew = ("".equals(sysEventStateForm.getId()) || sysEventStateForm.getId() == null);

        SysEventStateManager mgr = (SysEventStateManager) getBean("sysEventStateManager");
        SysEventState sysEventState = (SysEventState) convert(sysEventStateForm);
        mgr.saveSysEventState(sysEventState);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("sysEventState.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("sysEventState.updated"));
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

        SysEventStateForm sysEventStateForm = (SysEventStateForm) form;
        SysEventState sysEventState = (SysEventState) convert(sysEventStateForm);
        SysEventStateManager mgr = (SysEventStateManager) getBean("sysEventStateManager");
        sysEventState = null;
        int resultSize = Integer.parseInt(mgr.getSysEventStatesCount(sysEventState));
        Page page = new Page(Constants.SYSEVENTSTATE_LIST,request);        
        PaginatedList pageList = mgr.getSysEventStatesPage(sysEventState,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.SYSEVENTSTATE_LIST, pageList);                    
        //request.setAttribute(Constants.SYSEVENTSTATE_LIST, mgr.getSysEventStates(sysEventState));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
