
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.MediaOrg;
import com.vriche.adrm.service.MediaOrgManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.MediaOrgForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a MediaOrg object
 *
 * @struts.action name="mediaOrgForm" path="/mediaOrgs" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="mediaOrgForm" path="/editMediaOrg" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="mediaOrgForm" path="/saveMediaOrg" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adres/mediaOrgForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adres/mediaOrgList.jsp"
 * @struts.action-forward name="search" path="/mediaOrgs.html" redirect="true"
 */
public final class MediaOrgAction extends BaseAction {
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
        MediaOrgForm mediaOrgForm = (MediaOrgForm) form;

        // Exceptions are caught by ActionExceptionHandler
        MediaOrgManager mgr = (MediaOrgManager) getBean("mediaOrgManager");
        mgr.removeMediaOrg(mediaOrgForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("mediaOrg.deleted"));

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

        MediaOrgForm mediaOrgForm = (MediaOrgForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (mediaOrgForm.getId() != null) {
            MediaOrgManager mgr = (MediaOrgManager) getBean("mediaOrgManager");
            MediaOrg mediaOrg = mgr.getMediaOrg(mediaOrgForm.getId());
            mediaOrgForm = (MediaOrgForm) convert(mediaOrg);
            updateFormBean(mapping, request, mediaOrgForm);
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
        MediaOrgForm mediaOrgForm = (MediaOrgForm) form;
        boolean isNew = ("".equals(mediaOrgForm.getId()) || mediaOrgForm.getId() == null);

        MediaOrgManager mgr = (MediaOrgManager) getBean("mediaOrgManager");
        MediaOrg mediaOrg = (MediaOrg) convert(mediaOrgForm);
        mgr.saveMediaOrg(mediaOrg);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("mediaOrg.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("mediaOrg.updated"));
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

        MediaOrgForm mediaOrgForm = (MediaOrgForm) form;
        MediaOrg mediaOrg = (MediaOrg) convert(mediaOrgForm);
        
        
        String orgId = request.getParameter("orgId");
        orgId = orgId == null?"0":orgId;
        mediaOrg.setOrgId(new Long(orgId));

        
        System.out.println("orgId >>>>>>>>>>>>>>>>"+orgId);
        

        MediaOrgManager mgr = (MediaOrgManager) getBean("mediaOrgManager");
        request.setAttribute(Constants.MEDIAORG_LIST, mgr.getMediaOrgs(mediaOrg));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
