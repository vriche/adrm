
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
import com.vriche.adrm.model.OaWorkFlowCheck;
import com.vriche.adrm.service.OaWorkFlowCheckManager;
import com.vriche.adrm.webapp.form.OaWorkFlowCheckForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaWorkFlowCheck object
 *
 * @struts.action name="oaWorkFlowCheckForm" path="/oaWorkFlowChecks" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaWorkFlowCheckForm" path="/editOaWorkFlowCheck" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaWorkFlowCheckForm" path="/saveOaWorkFlowCheck" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/workFlow/oaWorkFlowCheckForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/workFlow/oaWorkFlowCheckList.jsp"
 * @struts.action-forward name="search" path="/oaWorkFlowChecks.html" redirect="true"
 */
public final class OaWorkFlowCheckAction extends BaseAction {
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
        OaWorkFlowCheckForm oaWorkFlowCheckForm = (OaWorkFlowCheckForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaWorkFlowCheckManager mgr = (OaWorkFlowCheckManager) getBean("oaWorkFlowCheckManager");
        mgr.removeOaWorkFlowCheck(oaWorkFlowCheckForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaWorkFlowCheck.deleted"));

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

        OaWorkFlowCheckForm oaWorkFlowCheckForm = (OaWorkFlowCheckForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaWorkFlowCheckForm.getId() != null) {
            OaWorkFlowCheckManager mgr = (OaWorkFlowCheckManager) getBean("oaWorkFlowCheckManager");
            OaWorkFlowCheck oaWorkFlowCheck = mgr.getOaWorkFlowCheck(oaWorkFlowCheckForm.getId());
            oaWorkFlowCheckForm = (OaWorkFlowCheckForm) convert(oaWorkFlowCheck);
            updateFormBean(mapping, request, oaWorkFlowCheckForm);
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
        OaWorkFlowCheckForm oaWorkFlowCheckForm = (OaWorkFlowCheckForm) form;
        boolean isNew = ("".equals(oaWorkFlowCheckForm.getId()) || oaWorkFlowCheckForm.getId() == null);

        OaWorkFlowCheckManager mgr = (OaWorkFlowCheckManager) getBean("oaWorkFlowCheckManager");
        OaWorkFlowCheck oaWorkFlowCheck = (OaWorkFlowCheck) convert(oaWorkFlowCheckForm);
        mgr.saveOaWorkFlowCheck(oaWorkFlowCheck);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaWorkFlowCheck.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaWorkFlowCheck.updated"));
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

//        OaWorkFlowCheckForm oaWorkFlowCheckForm = (OaWorkFlowCheckForm) form;
//        OaWorkFlowCheck oaWorkFlowCheck = (OaWorkFlowCheck) convert(oaWorkFlowCheckForm);
//        OaWorkFlowCheckManager mgr = (OaWorkFlowCheckManager) getBean("oaWorkFlowCheckManager");
//        oaWorkFlowCheck = null;
//        int resultSize = Integer.parseInt(mgr.getOaWorkFlowChecksCount(oaWorkFlowCheck));
//        Page page = new Page(Constants.OAWORKFLOWCHECK_LIST,request);        
//        PaginatedList pageList = mgr.getOaWorkFlowChecksPage(oaWorkFlowCheck,page.getPageIndex().toString(),page.getPageSize().toString());
//        pageList.gotoPage(page.getPageIndex().intValue());   
//        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
//        request.setAttribute(Constants.OAWORKFLOWCHECK_LIST, pageList);                    
        //request.setAttribute(Constants.OAWORKFLOWCHECK_LIST, mgr.getOaWorkFlowChecks(oaWorkFlowCheck));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
