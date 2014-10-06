
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.PublishedInfo;
import com.vriche.adrm.service.PublishedInfoManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.PublishedInfoForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a PublishedInfo object
 *
 * @struts.action name="publishedInfoForm" path="/publishedInfos" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="publishedInfoForm" path="/editPublishedInfo" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="publishedInfoForm" path="/savePublishedInfo" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adver/publishedInfoForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adver/publishedInfoList.jsp"
 * @struts.action-forward name="search" path="/publishedInfos.html" redirect="true"
 */
public final class PublishedInfoAction extends BaseAction {
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
        PublishedInfoForm publishedInfoForm = (PublishedInfoForm) form;

        // Exceptions are caught by ActionExceptionHandler
        PublishedInfoManager mgr = (PublishedInfoManager) getBean("publishedInfoManager");
        mgr.removePublishedInfo(publishedInfoForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("publishedInfo.deleted"));

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

        PublishedInfoForm publishedInfoForm = (PublishedInfoForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (publishedInfoForm.getId() != null) {
            PublishedInfoManager mgr = (PublishedInfoManager) getBean("publishedInfoManager");
            PublishedInfo publishedInfo = mgr.getPublishedInfo(publishedInfoForm.getId());
            publishedInfoForm = (PublishedInfoForm) convert(publishedInfo);
            updateFormBean(mapping, request, publishedInfoForm);
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
        PublishedInfoForm publishedInfoForm = (PublishedInfoForm) form;
        boolean isNew = ("".equals(publishedInfoForm.getId()) || publishedInfoForm.getId() == null);

        PublishedInfoManager mgr = (PublishedInfoManager) getBean("publishedInfoManager");
        PublishedInfo publishedInfo = (PublishedInfo) convert(publishedInfoForm);
        mgr.savePublishedInfo(publishedInfo);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("publishedInfo.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("publishedInfo.updated"));
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

        PublishedInfoForm publishedInfoForm = (PublishedInfoForm) form;
        PublishedInfo publishedInfo = (PublishedInfo) convert(publishedInfoForm);

        PublishedInfoManager mgr = (PublishedInfoManager) getBean("publishedInfoManager");
        request.setAttribute(Constants.PUBLISHEDINFO_LIST, mgr.getPublishedInfos(publishedInfo));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
