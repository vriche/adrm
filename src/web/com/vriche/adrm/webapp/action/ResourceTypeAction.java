
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.ResourceType;
import com.vriche.adrm.service.ResourceTypeManager;
import com.vriche.adrm.util.DateUtil;
import com.vriche.adrm.webapp.form.ResourceTypeForm;

/**
 * Action class to handle CRUD on a ResourceType object
 *
 * @struts.action name="resourceTypeForm" path="/resourceTypes" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="resourceTypeForm" path="/editResourceType" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="resourceTypeForm" path="/saveResourceType" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adres/resourceTypeForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adres/resourceTypeList.jsp"
 * @struts.action-forward name="search" path="/resourceTypes.html" redirect="true"
 */
public final class ResourceTypeAction extends BaseAction {
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
        ResourceTypeForm resourceTypeForm = (ResourceTypeForm) form;

        // Exceptions are caught by ActionExceptionHandler
        ResourceTypeManager mgr = (ResourceTypeManager) getBean("resourceTypeManager");
        mgr.removeResourceType(resourceTypeForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("resourceType.deleted"));

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

        ResourceTypeForm resourceTypeForm = (ResourceTypeForm) form;
        
   

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (resourceTypeForm.getId() != null) {
            ResourceTypeManager mgr = (ResourceTypeManager) getBean("resourceTypeManager");
            ResourceType resourceType = mgr.getResourceType(resourceTypeForm.getId());
            resourceTypeForm = (ResourceTypeForm) convert(resourceType);
            updateFormBean(mapping, request, resourceTypeForm);
        }else{
            String version = request.getParameter("version");
            String orgId = request.getParameter("orgId");
            version = version == null?String.valueOf(DateUtil.getYear()):version;
            orgId = orgId == null?"0":orgId;

            
            resourceTypeForm.setOrgId(orgId);
            resourceTypeForm.setVersion(version);
            resourceTypeForm.setEnable("1");
            updateFormBean(mapping, request, resourceTypeForm);
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
        ResourceTypeForm resourceTypeForm = (ResourceTypeForm) form;
        boolean isNew = ("".equals(resourceTypeForm.getId()) || resourceTypeForm.getId() == null);

        ResourceTypeManager mgr = (ResourceTypeManager) getBean("resourceTypeManager");
        ResourceType resourceType = (ResourceType) convert(resourceTypeForm);
        
        if(resourceTypeForm.getActivation()){
        	resourceType.setEnable(new Integer(1));
        }else{
        	resourceType.setEnable(new Integer(0));
        }       
        
        mgr.saveResourceType(resourceType);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("resourceType.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("resourceType.updated"));
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

        ResourceTypeForm resourceTypeForm = (ResourceTypeForm) form;
        ResourceType resourceType = (ResourceType) convert(resourceTypeForm);
        
        
        String orgId = request.getParameter("orgId");
        System.out.println("系统数1 .................orgId..............." + orgId);
        String version = request.getParameter("version");
        orgId = orgId == null?"0":orgId;
        
        System.out.println("系统数1 .................version..............." + version);
        version = version == null?String.valueOf(DateUtil.getYear()):version;
        
//        System.out.println("系统数2 .................version..............." + version);
        resourceType.setOrgId(new Long(orgId));
        resourceType.setVersion(new Integer(version));

        
//        System.out.println("orgId >>>>>>>>>>>>>>>>"+orgId);
        

        ResourceTypeManager mgr = (ResourceTypeManager) getBean("resourceTypeManager");
        request.setAttribute(Constants.RESOURCETYPE_LIST, mgr.getResourceTypes(resourceType));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
