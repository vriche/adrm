
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
import com.vriche.adrm.model.SysEventType;
import com.vriche.adrm.service.SysEventTypeManager;
import com.vriche.adrm.webapp.form.SysEventTypeForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a SysEventType object
 *
 * @struts.action name="sysEventTypeForm" path="/sysEventTypes" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="sysEventTypeForm" path="/editSysEventType" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="sysEventTypeForm" path="/saveSysEventType" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/admin/sysEventTypeForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/admin/sysEventTypeList.jsp"
 * @struts.action-forward name="search" path="/sysEventTypes.html" redirect="true"
 */
public final class SysEventTypeAction extends BaseAction {
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
        SysEventTypeForm sysEventTypeForm = (SysEventTypeForm) form;

        // Exceptions are caught by ActionExceptionHandler
        SysEventTypeManager mgr = (SysEventTypeManager) getBean("sysEventTypeManager");
        mgr.removeSysEventType(sysEventTypeForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("sysEventType.deleted"));

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

        SysEventTypeForm sysEventTypeForm = (SysEventTypeForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (sysEventTypeForm.getId() != null) {
            SysEventTypeManager mgr = (SysEventTypeManager) getBean("sysEventTypeManager");
            SysEventType sysEventType = mgr.getSysEventType(sysEventTypeForm.getId());
            sysEventTypeForm = (SysEventTypeForm) convert(sysEventType);
            updateFormBean(mapping, request, sysEventTypeForm);
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
        SysEventTypeForm sysEventTypeForm = (SysEventTypeForm) form;
        boolean isNew = ("".equals(sysEventTypeForm.getId()) || sysEventTypeForm.getId() == null);

        SysEventTypeManager mgr = (SysEventTypeManager) getBean("sysEventTypeManager");
        SysEventType sysEventType = (SysEventType) convert(sysEventTypeForm);
        mgr.saveSysEventType(sysEventType);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("sysEventType.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("sysEventType.updated"));
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

        SysEventTypeForm sysEventTypeForm = (SysEventTypeForm) form;
        SysEventType sysEventType = (SysEventType) convert(sysEventTypeForm);
        SysEventTypeManager mgr = (SysEventTypeManager) getBean("sysEventTypeManager");
        sysEventType = null;
        int resultSize = Integer.parseInt(mgr.getSysEventTypesCount(sysEventType));
        Page page = new Page(Constants.SYSEVENTTYPE_LIST,request);        
        PaginatedList pageList = mgr.getSysEventTypesPage(sysEventType,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.SYSEVENTTYPE_LIST, pageList);                    
        //request.setAttribute(Constants.SYSEVENTTYPE_LIST, mgr.getSysEventTypes(sysEventType));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
