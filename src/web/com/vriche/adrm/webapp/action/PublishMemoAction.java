
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.PublishMemo;
import com.vriche.adrm.service.PublishMemoManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.PublishMemoForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a PublishMemo object
 *
 * @struts.action name="publishMemoForm" path="/publishMemos" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="publishMemoForm" path="/editPublishMemo" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="publishMemoForm" path="/savePublishMemo" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adver/publishMemoForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adver/publishMemoList.jsp"
 * @struts.action-forward name="search" path="/publishMemos.html" redirect="true"
 */
public final class PublishMemoAction extends BaseAction {
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
        PublishMemoForm publishMemoForm = (PublishMemoForm) form;

        // Exceptions are caught by ActionExceptionHandler
        PublishMemoManager mgr = (PublishMemoManager) getBean("publishMemoManager");
        mgr.removePublishMemo(publishMemoForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("publishMemo.deleted"));

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

        PublishMemoForm publishMemoForm = (PublishMemoForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (publishMemoForm.getId() != null) {
            PublishMemoManager mgr = (PublishMemoManager) getBean("publishMemoManager");
            PublishMemo publishMemo = mgr.getPublishMemo(publishMemoForm.getId());
            publishMemoForm = (PublishMemoForm) convert(publishMemo);
            updateFormBean(mapping, request, publishMemoForm);
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
        PublishMemoForm publishMemoForm = (PublishMemoForm) form;
        boolean isNew = ("".equals(publishMemoForm.getId()) || publishMemoForm.getId() == null);

        PublishMemoManager mgr = (PublishMemoManager) getBean("publishMemoManager");
        PublishMemo publishMemo = (PublishMemo) convert(publishMemoForm);
        mgr.savePublishMemo(publishMemo);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("publishMemo.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("publishMemo.updated"));
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

        PublishMemoForm publishMemoForm = (PublishMemoForm) form;
        PublishMemo publishMemo = (PublishMemo) convert(publishMemoForm);

        PublishMemoManager mgr = (PublishMemoManager) getBean("publishMemoManager");
        request.setAttribute(Constants.PUBLISHMEMO_LIST, mgr.getPublishMemos(publishMemo));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
