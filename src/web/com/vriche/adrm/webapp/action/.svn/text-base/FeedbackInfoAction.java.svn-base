
package com.vriche.adrm.webapp.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.FeedbackInfo;
import com.vriche.adrm.service.FeedbackInfoManager;
import com.vriche.adrm.util.UserUtil;
import com.vriche.adrm.webapp.form.FeedbackInfoForm;

/**
 * Action class to handle CRUD on a FeedbackInfo object
 *
 * @struts.action name="feedbackInfoForm" path="/feedbackInfos" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="feedbackInfoForm" path="/editFeedbackInfo" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="feedbackInfoForm" path="/saveFeedbackInfo" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/crm/feedbackInfoForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/crm/feedbackInfoList.jsp"
 * @struts.action-forward name="search" path="/feedbackInfos.html" redirect="true"
 */
public final class FeedbackInfoAction extends BaseAction {
	
	
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
        FeedbackInfoForm feedbackInfoForm = (FeedbackInfoForm) form;

        // Exceptions are caught by ActionExceptionHandler
        FeedbackInfoManager mgr = (FeedbackInfoManager) getBean("feedbackInfoManager");
        mgr.removeFeedbackInfo(feedbackInfoForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("feedbackInfo.deleted"));

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

        FeedbackInfoForm feedbackInfoForm = (FeedbackInfoForm) form;
        
        String orgId = request.getParameter("orgId");
        feedbackInfoForm.setOrgId(orgId);

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (feedbackInfoForm.getId() != null) {
            FeedbackInfoManager mgr = (FeedbackInfoManager) getBean("feedbackInfoManager");
            FeedbackInfo feedbackInfo = mgr.getFeedbackInfo(feedbackInfoForm.getId());
            
            
            feedbackInfoForm = (FeedbackInfoForm) convert(feedbackInfo);
            updateFormBean(mapping, request, feedbackInfoForm);
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
        FeedbackInfoForm feedbackInfoForm = (FeedbackInfoForm) form;
        
        String orgId = request.getParameter("orgId");
        feedbackInfoForm.setOrgId(orgId);
        
        boolean isNew = ("".equals(feedbackInfoForm.getId()) || feedbackInfoForm.getId() == null);

        FeedbackInfoManager mgr = (FeedbackInfoManager) getBean("feedbackInfoManager");
        FeedbackInfo feedbackInfo = (FeedbackInfo) convert(feedbackInfoForm);
        feedbackInfo.setCreateDate(new Date());
        feedbackInfo.setModifyDate(new Date());
        mgr.saveFeedbackInfo(feedbackInfo);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("feedbackInfo.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("feedbackInfo.updated"));
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
        
        
        if (log.isDebugEnabled()) {
            log.info("Entering 'search' method orgId>>>>>>>>>>>>>>>>>>>>>>>>>>>"+orgId);
            log.info("Entering 'search' method orgId>>>>>>>>>>>>>>>>>>>>>>>>>>>"+orgId.length());
            log.info("Entering 'search' method orgId>>>>>>>>>>>>>>>>>>>>>>>>>>>"+sOrgs);
        }
        
         
        

        FeedbackInfoForm feedbackInfoForm = (FeedbackInfoForm) form;
        feedbackInfoForm.setOrgId(orgId);
        
        FeedbackInfo feedbackInfo = (FeedbackInfo) convert(feedbackInfoForm);
        
        feedbackInfo.setOrgId(new Long(orgId));

        FeedbackInfoManager mgr = (FeedbackInfoManager) getBean("feedbackInfoManager");
        request.setAttribute(Constants.FEEDBACKINFO_LIST, mgr.getFeedbackInfos(feedbackInfo));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
