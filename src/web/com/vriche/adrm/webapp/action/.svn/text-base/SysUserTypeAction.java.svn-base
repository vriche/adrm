
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
import com.vriche.adrm.model.SysUserType;
import com.vriche.adrm.service.SysUserTypeManager;
import com.vriche.adrm.webapp.form.SysUserTypeForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a SysUserType object
 *
 * @struts.action name="sysUserTypeForm" path="/sysUserTypes" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="sysUserTypeForm" path="/editSysUserType" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="sysUserTypeForm" path="/saveSysUserType" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/admin/sysUserTypeForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/admin/sysUserTypeList.jsp"
 * @struts.action-forward name="search" path="/sysUserTypes.html" redirect="true"
 */
public final class SysUserTypeAction extends BaseAction {
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
        SysUserTypeForm sysUserTypeForm = (SysUserTypeForm) form;

        // Exceptions are caught by ActionExceptionHandler
        SysUserTypeManager mgr = (SysUserTypeManager) getBean("sysUserTypeManager");
        mgr.removeSysUserType(sysUserTypeForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("sysUserType.deleted"));

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

        SysUserTypeForm sysUserTypeForm = (SysUserTypeForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (sysUserTypeForm.getId() != null) {
            SysUserTypeManager mgr = (SysUserTypeManager) getBean("sysUserTypeManager");
            SysUserType sysUserType = mgr.getSysUserType(sysUserTypeForm.getId());
            sysUserTypeForm = (SysUserTypeForm) convert(sysUserType);
            updateFormBean(mapping, request, sysUserTypeForm);
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
        SysUserTypeForm sysUserTypeForm = (SysUserTypeForm) form;
        boolean isNew = ("".equals(sysUserTypeForm.getId()) || sysUserTypeForm.getId() == null);

        SysUserTypeManager mgr = (SysUserTypeManager) getBean("sysUserTypeManager");
        SysUserType sysUserType = (SysUserType) convert(sysUserTypeForm);
        mgr.saveSysUserType(sysUserType);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("sysUserType.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("sysUserType.updated"));
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

        SysUserTypeForm sysUserTypeForm = (SysUserTypeForm) form;
        SysUserType sysUserType = (SysUserType) convert(sysUserTypeForm);
        SysUserTypeManager mgr = (SysUserTypeManager) getBean("sysUserTypeManager");
        sysUserType = null;
        int resultSize = Integer.parseInt(mgr.getSysUserTypesCount(sysUserType));
        Page page = new Page(Constants.SYSUSERTYPE_LIST,request);        
        PaginatedList pageList = mgr.getSysUserTypesPage(sysUserType,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.SYSUSERTYPE_LIST, pageList);                    
        //request.setAttribute(Constants.SYSUSERTYPE_LIST, mgr.getSysUserTypes(sysUserType));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
