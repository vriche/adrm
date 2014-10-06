
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
import com.vriche.adrm.model.PublishArrange;
import com.vriche.adrm.service.PublishArrangeManager;
import com.vriche.adrm.webapp.form.PublishArrangeForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a PublishArrange object
 *
 * @struts.action name="publishArrangeForm" path="/publishArranges" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="publishArrangeForm" path="/editPublishArrange" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="publishArrangeForm" path="/savePublishArrange" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adver/publishArrangeForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adver/publishArrangeList.jsp"
 * @struts.action-forward name="search" path="/publishArranges.html" redirect="true"
 */
public final class PublishArrangeAction extends BaseAction {
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
        PublishArrangeForm publishArrangeForm = (PublishArrangeForm) form;

        // Exceptions are caught by ActionExceptionHandler
        PublishArrangeManager mgr = (PublishArrangeManager) getBean("publishArrangeManager");
        mgr.removePublishArrange(publishArrangeForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("publishArrange.deleted"));

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

        PublishArrangeForm publishArrangeForm = (PublishArrangeForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (publishArrangeForm.getId() != null) {
            PublishArrangeManager mgr = (PublishArrangeManager) getBean("publishArrangeManager");
            PublishArrange publishArrange = mgr.getPublishArrange(publishArrangeForm.getId());
            publishArrangeForm = (PublishArrangeForm) convert(publishArrange);
            updateFormBean(mapping, request, publishArrangeForm);
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
        PublishArrangeForm publishArrangeForm = (PublishArrangeForm) form;
        boolean isNew = ("".equals(publishArrangeForm.getId()) || publishArrangeForm.getId() == null);

        PublishArrangeManager mgr = (PublishArrangeManager) getBean("publishArrangeManager");
        PublishArrange publishArrange = (PublishArrange) convert(publishArrangeForm);
        mgr.savePublishArrange(publishArrange);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("publishArrange.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("publishArrange.updated"));
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

//        PublishArrangeForm publishArrangeForm = (PublishArrangeForm) form;
//        PublishArrange publishArrange = (PublishArrange) convert(publishArrangeForm);
//        PublishArrangeManager mgr = (PublishArrangeManager) getBean("publishArrangeManager");
//        publishArrange = null;
//        int resultSize = Integer.parseInt(mgr.getPublishArrangesCount(publishArrange));
//        Page page = new Page(Constants.PUBLISHARRANGE_LIST,request);        
//        PaginatedList pageList = mgr.getPublishArrangesPage(publishArrange,page.getPageIndex().toString(),page.getPageSize().toString());
//        pageList.gotoPage(page.getPageIndex().intValue());   
//        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
//        request.setAttribute(Constants.PUBLISHARRANGE_LIST, pageList);                    
        //request.setAttribute(Constants.PUBLISHARRANGE_LIST, mgr.getPublishArranges(publishArrange));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
