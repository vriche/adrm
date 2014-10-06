
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
import com.vriche.adrm.model.SysResource;
import com.vriche.adrm.service.SysResourceManager;
import com.vriche.adrm.webapp.form.SysResourceForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a SysResource object
 *
 * @struts.action name="sysResourceForm" path="/sysResources" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="sysResourceForm" path="/editSysResource" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="sysResourceForm" path="/saveSysResource" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/admin/sysResourceForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/admin/sysResourceList.jsp"
 * @struts.action-forward name="search" path="/sysResources.html" redirect="true"
 */
public final class SysResourceAction extends BaseAction {
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
        SysResourceForm sysResourceForm = (SysResourceForm) form;

        // Exceptions are caught by ActionExceptionHandler
        SysResourceManager mgr = (SysResourceManager) getBean("sysResourceManager");
        mgr.removeSysResource(sysResourceForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("sysResource.deleted"));

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

        SysResourceForm sysResourceForm = (SysResourceForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (sysResourceForm.getId() != null) {
            SysResourceManager mgr = (SysResourceManager) getBean("sysResourceManager");
            SysResource sysResource = mgr.getSysResource(sysResourceForm.getId());
            sysResourceForm = (SysResourceForm) convert(sysResource);
            updateFormBean(mapping, request, sysResourceForm);
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
        SysResourceForm sysResourceForm = (SysResourceForm) form;
        boolean isNew = ("".equals(sysResourceForm.getId()) || sysResourceForm.getId() == null);

        SysResourceManager mgr = (SysResourceManager) getBean("sysResourceManager");
        SysResource sysResource = (SysResource) convert(sysResourceForm);
        mgr.saveSysResource(sysResource);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("sysResource.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("sysResource.updated"));
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

        SysResourceForm sysResourceForm = (SysResourceForm) form;
        SysResource sysResource = (SysResource) convert(sysResourceForm);
        SysResourceManager mgr = (SysResourceManager) getBean("sysResourceManager");
        sysResource = null;
        int resultSize = Integer.parseInt(mgr.getSysResourcesCount(sysResource));
        Page page = new Page(Constants.SYSRESOURCE_LIST,request);        
        PaginatedList pageList = mgr.getSysResourcesPage(sysResource,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.SYSRESOURCE_LIST, pageList);                    
        //request.setAttribute(Constants.SYSRESOURCE_LIST, mgr.getSysResources(sysResource));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
