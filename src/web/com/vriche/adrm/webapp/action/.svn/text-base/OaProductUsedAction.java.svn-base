
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
import com.vriche.adrm.model.OaProductUsed;
import com.vriche.adrm.service.OaProductUsedManager;
import com.vriche.adrm.webapp.form.OaProductUsedForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaProductUsed object
 *
 * @struts.action name="oaProductUsedForm" path="/oaProductUseds" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaProductUsedForm" path="/editOaProductUsed" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaProductUsedForm" path="/saveOaProductUsed" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/product/oaProductUsedForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/product/oaProductUsedList.jsp"
 * @struts.action-forward name="search" path="/oaProductUseds.html" redirect="true"
 */
public final class OaProductUsedAction extends BaseAction {
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
        OaProductUsedForm oaProductUsedForm = (OaProductUsedForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaProductUsedManager mgr = (OaProductUsedManager) getBean("oaProductUsedManager");
        mgr.removeOaProductUsed(oaProductUsedForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaProductUsed.deleted"));

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

        OaProductUsedForm oaProductUsedForm = (OaProductUsedForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaProductUsedForm.getId() != null) {
            OaProductUsedManager mgr = (OaProductUsedManager) getBean("oaProductUsedManager");
            OaProductUsed oaProductUsed = mgr.getOaProductUsed(oaProductUsedForm.getId());
            oaProductUsedForm = (OaProductUsedForm) convert(oaProductUsed);
            updateFormBean(mapping, request, oaProductUsedForm);
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
        OaProductUsedForm oaProductUsedForm = (OaProductUsedForm) form;
        boolean isNew = ("".equals(oaProductUsedForm.getId()) || oaProductUsedForm.getId() == null);

        OaProductUsedManager mgr = (OaProductUsedManager) getBean("oaProductUsedManager");
        OaProductUsed oaProductUsed = (OaProductUsed) convert(oaProductUsedForm);
        System.out.println("  >>>>>>    "+oaProductUsed.getPlayReturnDate());
        mgr.saveOaProductUsed(oaProductUsed);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaProductUsed.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaProductUsed.updated"));
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

        OaProductUsedForm oaProductUsedForm = (OaProductUsedForm) form;
        OaProductUsed oaProductUsed = (OaProductUsed) convert(oaProductUsedForm);
        OaProductUsedManager mgr = (OaProductUsedManager) getBean("oaProductUsedManager");
        oaProductUsed = null;
        int resultSize = Integer.parseInt(mgr.getOaProductUsedsCount(oaProductUsed));
        Page page = new Page(Constants.OAPRODUCTUSED_LIST,request);        
        PaginatedList pageList = mgr.getOaProductUsedsPage(oaProductUsed,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OAPRODUCTUSED_LIST, pageList);                    
        //request.setAttribute(Constants.OAPRODUCTUSED_LIST, mgr.getOaProductUseds(oaProductUsed));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
