
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
import com.vriche.adrm.model.SysEvent;
import com.vriche.adrm.service.SysEventManager;
import com.vriche.adrm.webapp.form.SysEventForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a SysEvent object
 *
 * @struts.action name="sysEventForm" path="/sysEvents" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="sysEventForm" path="/editSysEvent" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="sysEventForm" path="/saveSysEvent" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/admin/sysEventForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/admin/sysEventList.jsp"
 * @struts.action-forward name="search" path="/sysEvents.html" redirect="true"
 */
public final class SysEventAction extends BaseAction {
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
        SysEventForm sysEventForm = (SysEventForm) form;

        // Exceptions are caught by ActionExceptionHandler
        SysEventManager mgr = (SysEventManager) getBean("sysEventManager");
        mgr.removeSysEvent(sysEventForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("sysEvent.deleted"));

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

        SysEventForm sysEventForm = (SysEventForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (sysEventForm.getId() != null) {
            SysEventManager mgr = (SysEventManager) getBean("sysEventManager");
            SysEvent sysEvent = mgr.getSysEvent(sysEventForm.getId());
            sysEventForm = (SysEventForm) convert(sysEvent);
            updateFormBean(mapping, request, sysEventForm);
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
        SysEventForm sysEventForm = (SysEventForm) form;
        boolean isNew = ("".equals(sysEventForm.getId()) || sysEventForm.getId() == null);

        SysEventManager mgr = (SysEventManager) getBean("sysEventManager");
        SysEvent sysEvent = (SysEvent) convert(sysEventForm);
        mgr.saveSysEvent(sysEvent);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("sysEvent.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("sysEvent.updated"));
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

        SysEventForm sysEventForm = (SysEventForm) form;
        SysEvent sysEvent = (SysEvent) convert(sysEventForm);
        SysEventManager mgr = (SysEventManager) getBean("sysEventManager");
        sysEvent = null;
        int resultSize = Integer.parseInt(mgr.getSysEventsCount(sysEvent));
        Page page = new Page(Constants.SYSEVENT_LIST,request);        
        PaginatedList pageList = mgr.getSysEventsPage(sysEvent,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.SYSEVENT_LIST, pageList);                    
        //request.setAttribute(Constants.SYSEVENT_LIST, mgr.getSysEvents(sysEvent));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
