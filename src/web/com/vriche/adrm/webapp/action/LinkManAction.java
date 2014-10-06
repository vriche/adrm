
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.LinkMan;
import com.vriche.adrm.service.LinkManManager;
import com.vriche.adrm.util.UserUtil;
import com.vriche.adrm.webapp.form.LinkManForm;

/**
 * Action class to handle CRUD on a LinkMan object
 *
 * @struts.action name="linkManForm" path="/linkMans" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="linkManForm" path="/editLinkMan" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="linkManForm" path="/saveLinkMan" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/crm/linkManForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/crm/linkManList.jsp"
 * @struts.action-forward name="search" path="/linkMans.html" redirect="true"
 */
public final class LinkManAction extends BaseAction {
	
	 private final String sOrgs = UserUtil.getUserOrgs(null);
	 
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
        LinkManForm linkManForm = (LinkManForm) form;

        // Exceptions are caught by ActionExceptionHandler
        LinkManManager mgr = (LinkManManager) getBean("linkManManager");
        mgr.removeLinkMan(linkManForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("linkMan.deleted"));

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

        LinkManForm linkManForm = (LinkManForm) form;
        
        String orgId = request.getParameter("orgId");
        linkManForm.setOrgId(orgId);

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (linkManForm.getId() != null) {
            LinkManManager mgr = (LinkManManager) getBean("linkManManager");
            LinkMan linkMan = mgr.getLinkMan(linkManForm.getId());
            linkManForm = (LinkManForm) convert(linkMan);
            updateFormBean(mapping, request, linkManForm);
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
        LinkManForm linkManForm = (LinkManForm) form;
        
        String orgId = request.getParameter("orgId");
        linkManForm.setOrgId(orgId);
        
        
        boolean isNew = ("".equals(linkManForm.getId()) || linkManForm.getId() == null);

        LinkManManager mgr = (LinkManManager) getBean("linkManManager");
        LinkMan linkMan = (LinkMan) convert(linkManForm);
        mgr.saveLinkMan(linkMan);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("linkMan.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("linkMan.updated"));
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
        
        String orgId = request.getParameter("orgId");
        if(orgId ==null || "".equals(orgId)) orgId = sOrgs.split(",")[0];
        if(orgId.length() ==0) orgId="1";

        LinkManForm linkManForm = (LinkManForm) form;
        LinkMan linkMan = (LinkMan) convert(linkManForm);
        
        linkManForm.setOrgId(orgId);

        LinkManManager mgr = (LinkManManager) getBean("linkManManager");
        request.setAttribute(Constants.LINKMAN_LIST, mgr.getLinkMans(linkMan));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
    	

//    	 log.info("Entering 'unspecified' method>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" +orgId);
    	
        return search(mapping, form, request, response);
    }
}
