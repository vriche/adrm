
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import java.util.List;

import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.Constants;
import com.vriche.adrm.model.ResourceLimit;
import com.vriche.adrm.service.ResourceLimitManager;
import com.vriche.adrm.webapp.form.ResourceLimitForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a ResourceLimit object
 *
 * @struts.action name="resourceLimitForm" path="/resourceLimits" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="resourceLimitForm" path="/editResourceLimit" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="resourceLimitForm" path="/saveResourceLimit" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adres/resourceLimitForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adres/resourceLimitList.jsp"
 * @struts.action-forward name="search" path="/resourceLimits.html" redirect="true"
 */
public final class ResourceLimitAction extends BaseAction {
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
        ResourceLimitForm resourceLimitForm = (ResourceLimitForm) form;

        // Exceptions are caught by ActionExceptionHandler
        ResourceLimitManager mgr = (ResourceLimitManager) getBean("resourceLimitManager");
        mgr.removeResourceLimit(resourceLimitForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("resourceLimit.deleted"));

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

        ResourceLimitForm resourceLimitForm = (ResourceLimitForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (resourceLimitForm.getId() != null) {
            ResourceLimitManager mgr = (ResourceLimitManager) getBean("resourceLimitManager");
            ResourceLimit resourceLimit = mgr.getResourceLimit(resourceLimitForm.getId());
            resourceLimitForm = (ResourceLimitForm) convert(resourceLimit);
            updateFormBean(mapping, request, resourceLimitForm);
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
        ResourceLimitForm resourceLimitForm = (ResourceLimitForm) form;
        boolean isNew = ("".equals(resourceLimitForm.getId()) || resourceLimitForm.getId() == null);

        ResourceLimitManager mgr = (ResourceLimitManager) getBean("resourceLimitManager");
        ResourceLimit resourceLimit = (ResourceLimit) convert(resourceLimitForm);
        mgr.saveResourceLimit(resourceLimit);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("resourceLimit.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("resourceLimit.updated"));
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

        ResourceLimitForm resourceLimitForm = (ResourceLimitForm) form;
        ResourceLimit resourceLimit = (ResourceLimit) convert(resourceLimitForm);
        ResourceLimitManager mgr = (ResourceLimitManager) getBean("resourceLimitManager");
        resourceLimit = null;
        int resultSize = Integer.parseInt(mgr.getResourceLimitsCount(resourceLimit));
        Page page = new Page(Constants.RESOURCELIMIT_LIST,request);        
        List list = mgr.getResourceLimitsPage(resourceLimit,page.getPageIndex().toString(),page.getPageSize().toString());

        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.RESOURCELIMIT_LIST, list);                    
        //request.setAttribute(Constants.RESOURCELIMIT_LIST, mgr.getResourceLimits(resourceLimit));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
