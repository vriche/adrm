
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
import com.vriche.adrm.model.OaCalendarEvent;
import com.vriche.adrm.service.OaCalendarEventManager;
import com.vriche.adrm.webapp.form.OaCalendarEventForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaCalendarEvent object
 *
 * @struts.action name="oaCalendarEventForm" path="/oaCalendarEvents" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaCalendarEventForm" path="/editOaCalendarEvent" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaCalendarEventForm" path="/saveOaCalendarEvent" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/tools/oaCalendarEventForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/tools/oaCalendarEventList.jsp"
 * @struts.action-forward name="search" path="/oaCalendarEvents.html" redirect="true"
 */
public final class OaCalendarEventAction extends BaseAction {
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
        OaCalendarEventForm oaCalendarEventForm = (OaCalendarEventForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaCalendarEventManager mgr = (OaCalendarEventManager) getBean("oaCalendarEventManager");
        mgr.removeOaCalendarEvent(oaCalendarEventForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaCalendarEvent.deleted"));

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

        OaCalendarEventForm oaCalendarEventForm = (OaCalendarEventForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaCalendarEventForm.getId() != null) {
            OaCalendarEventManager mgr = (OaCalendarEventManager) getBean("oaCalendarEventManager");
            OaCalendarEvent oaCalendarEvent = mgr.getOaCalendarEvent(oaCalendarEventForm.getId());
            oaCalendarEventForm = (OaCalendarEventForm) convert(oaCalendarEvent);
            updateFormBean(mapping, request, oaCalendarEventForm);
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
        OaCalendarEventForm oaCalendarEventForm = (OaCalendarEventForm) form;
        boolean isNew = ("".equals(oaCalendarEventForm.getId()) || oaCalendarEventForm.getId() == null);

        OaCalendarEventManager mgr = (OaCalendarEventManager) getBean("oaCalendarEventManager");
        OaCalendarEvent oaCalendarEvent = (OaCalendarEvent) convert(oaCalendarEventForm);
        mgr.saveOaCalendarEvent(oaCalendarEvent);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaCalendarEvent.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaCalendarEvent.updated"));
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

        OaCalendarEventForm oaCalendarEventForm = (OaCalendarEventForm) form;
        OaCalendarEvent oaCalendarEvent = (OaCalendarEvent) convert(oaCalendarEventForm);
        OaCalendarEventManager mgr = (OaCalendarEventManager) getBean("oaCalendarEventManager");
        oaCalendarEvent = null;
        int resultSize = Integer.parseInt(mgr.getOaCalendarEventsCount(oaCalendarEvent));
        Page page = new Page(Constants.OACALENDAREVENT_LIST,request);        
        PaginatedList pageList = mgr.getOaCalendarEventsPage(oaCalendarEvent,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OACALENDAREVENT_LIST, pageList);                    
        //request.setAttribute(Constants.OACALENDAREVENT_LIST, mgr.getOaCalendarEvents(oaCalendarEvent));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
