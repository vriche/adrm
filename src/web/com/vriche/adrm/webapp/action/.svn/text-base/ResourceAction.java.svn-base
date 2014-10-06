
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.Resource;
import com.vriche.adrm.service.ResourceManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.ResourceForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a Resource object
 *
 * @struts.action name="resourceForm" path="/resources" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="resourceForm" path="/editResource" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="resourceForm" path="/saveResource" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adres/resourceForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adres/resourceList.jsp"
 * @struts.action-forward name="search" path="/resources.html" redirect="true"
 */
public final class ResourceAction extends BaseAction {
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
        ResourceForm resourceForm = (ResourceForm) form;

        // Exceptions are caught by ActionExceptionHandler
        ResourceManager mgr = (ResourceManager) getBean("resourceManager");
        mgr.removeResource(resourceForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("resource.deleted"));

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

        ResourceForm resourceForm = (ResourceForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (resourceForm.getId() != null) {
            ResourceManager mgr = (ResourceManager) getBean("resourceManager");
            Resource resource = mgr.getResource(resourceForm.getId());
            resourceForm = (ResourceForm) convert(resource);
            updateFormBean(mapping, request, resourceForm);
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
        ResourceForm resourceForm = (ResourceForm) form;
        boolean isNew = ("".equals(resourceForm.getId()) || resourceForm.getId() == null);

        ResourceManager mgr = (ResourceManager) getBean("resourceManager");
        Resource resource = (Resource) convert(resourceForm);
        mgr.saveResource(resource);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("resource.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("resource.updated"));
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

//        ResourceForm resourceForm = (ResourceForm) form;
//        Resource resource = (Resource) convert(resourceForm);
//
//        ResourceManager mgr = (ResourceManager) getBean("resourceManager");
//        request.setAttribute(Constants.RESOURCE_LIST, mgr.getResources(resource));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
