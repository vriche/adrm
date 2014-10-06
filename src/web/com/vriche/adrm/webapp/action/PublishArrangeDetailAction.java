
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
import com.vriche.adrm.model.PublishArrangeDetail;
import com.vriche.adrm.service.PublishArrangeDetailManager;
import com.vriche.adrm.webapp.form.PublishArrangeDetailForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a PublishArrangeDetail object
 *
 * @struts.action name="publishArrangeDetailForm" path="/publishArrangeDetails" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="publishArrangeDetailForm" path="/editPublishArrangeDetail" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="publishArrangeDetailForm" path="/savePublishArrangeDetail" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adver/publishArrangeDetailForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adver/publishArrangeDetailList.jsp"
 * @struts.action-forward name="search" path="/publishArrangeDetails.html" redirect="true"
 */
public final class PublishArrangeDetailAction extends BaseAction {
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
        PublishArrangeDetailForm publishArrangeDetailForm = (PublishArrangeDetailForm) form;

        // Exceptions are caught by ActionExceptionHandler
        PublishArrangeDetailManager mgr = (PublishArrangeDetailManager) getBean("publishArrangeDetailManager");
        mgr.removePublishArrangeDetail(publishArrangeDetailForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("publishArrangeDetail.deleted"));

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

        PublishArrangeDetailForm publishArrangeDetailForm = (PublishArrangeDetailForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (publishArrangeDetailForm.getId() != null) {
            PublishArrangeDetailManager mgr = (PublishArrangeDetailManager) getBean("publishArrangeDetailManager");
            PublishArrangeDetail publishArrangeDetail = mgr.getPublishArrangeDetail(publishArrangeDetailForm.getId());
            publishArrangeDetailForm = (PublishArrangeDetailForm) convert(publishArrangeDetail);
            updateFormBean(mapping, request, publishArrangeDetailForm);
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
        PublishArrangeDetailForm publishArrangeDetailForm = (PublishArrangeDetailForm) form;
        boolean isNew = ("".equals(publishArrangeDetailForm.getId()) || publishArrangeDetailForm.getId() == null);

        PublishArrangeDetailManager mgr = (PublishArrangeDetailManager) getBean("publishArrangeDetailManager");
        PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail) convert(publishArrangeDetailForm);
        mgr.savePublishArrangeDetail(publishArrangeDetail);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("publishArrangeDetail.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("publishArrangeDetail.updated"));
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

        PublishArrangeDetailForm publishArrangeDetailForm = (PublishArrangeDetailForm) form;
        PublishArrangeDetail publishArrangeDetail = (PublishArrangeDetail) convert(publishArrangeDetailForm);
        PublishArrangeDetailManager mgr = (PublishArrangeDetailManager) getBean("publishArrangeDetailManager");
        publishArrangeDetail = null;
        int resultSize = Integer.parseInt(mgr.getPublishArrangeDetailsCount(publishArrangeDetail));
        Page page = new Page(Constants.PUBLISHARRANGEDETAIL_LIST,request);        
        PaginatedList pageList = mgr.getPublishArrangeDetailsPage(publishArrangeDetail,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.PUBLISHARRANGEDETAIL_LIST, pageList);                    
        //request.setAttribute(Constants.PUBLISHARRANGEDETAIL_LIST, mgr.getPublishArrangeDetails(publishArrangeDetail));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
