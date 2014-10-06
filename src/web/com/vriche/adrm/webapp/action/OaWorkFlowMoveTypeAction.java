
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
import com.vriche.adrm.model.OaWorkFlowMoveType;
import com.vriche.adrm.service.OaWorkFlowMoveTypeManager;
import com.vriche.adrm.webapp.form.OaWorkFlowMoveTypeForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaWorkFlowMoveType object
 *
 * @struts.action name="oaWorkFlowMoveTypeForm" path="/oaWorkFlowMoveTypes" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaWorkFlowMoveTypeForm" path="/editOaWorkFlowMoveType" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaWorkFlowMoveTypeForm" path="/saveOaWorkFlowMoveType" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/workFlow/oaWorkFlowMoveTypeForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/workFlow/oaWorkFlowMoveTypeList.jsp"
 * @struts.action-forward name="search" path="/oaWorkFlowMoveTypes.html" redirect="true"
 */
public final class OaWorkFlowMoveTypeAction extends BaseAction {
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
        OaWorkFlowMoveTypeForm oaWorkFlowMoveTypeForm = (OaWorkFlowMoveTypeForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaWorkFlowMoveTypeManager mgr = (OaWorkFlowMoveTypeManager) getBean("oaWorkFlowMoveTypeManager");
        mgr.removeOaWorkFlowMoveType(oaWorkFlowMoveTypeForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaWorkFlowMoveType.deleted"));

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

        OaWorkFlowMoveTypeForm oaWorkFlowMoveTypeForm = (OaWorkFlowMoveTypeForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaWorkFlowMoveTypeForm.getId() != null) {
            OaWorkFlowMoveTypeManager mgr = (OaWorkFlowMoveTypeManager) getBean("oaWorkFlowMoveTypeManager");
            OaWorkFlowMoveType oaWorkFlowMoveType = mgr.getOaWorkFlowMoveType(oaWorkFlowMoveTypeForm.getId());
            oaWorkFlowMoveTypeForm = (OaWorkFlowMoveTypeForm) convert(oaWorkFlowMoveType);
            updateFormBean(mapping, request, oaWorkFlowMoveTypeForm);
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
        OaWorkFlowMoveTypeForm oaWorkFlowMoveTypeForm = (OaWorkFlowMoveTypeForm) form;
        boolean isNew = ("".equals(oaWorkFlowMoveTypeForm.getId()) || oaWorkFlowMoveTypeForm.getId() == null);

        OaWorkFlowMoveTypeManager mgr = (OaWorkFlowMoveTypeManager) getBean("oaWorkFlowMoveTypeManager");
        OaWorkFlowMoveType oaWorkFlowMoveType = (OaWorkFlowMoveType) convert(oaWorkFlowMoveTypeForm);
        mgr.saveOaWorkFlowMoveType(oaWorkFlowMoveType);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaWorkFlowMoveType.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaWorkFlowMoveType.updated"));
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

        OaWorkFlowMoveTypeForm oaWorkFlowMoveTypeForm = (OaWorkFlowMoveTypeForm) form;
        OaWorkFlowMoveType oaWorkFlowMoveType = (OaWorkFlowMoveType) convert(oaWorkFlowMoveTypeForm);
        OaWorkFlowMoveTypeManager mgr = (OaWorkFlowMoveTypeManager) getBean("oaWorkFlowMoveTypeManager");
        oaWorkFlowMoveType = null;
        int resultSize = Integer.parseInt(mgr.getOaWorkFlowMoveTypesCount(oaWorkFlowMoveType));
        Page page = new Page(Constants.OAWORKFLOWMOVETYPE_LIST,request);        
        PaginatedList pageList = mgr.getOaWorkFlowMoveTypesPage(oaWorkFlowMoveType,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OAWORKFLOWMOVETYPE_LIST, pageList);                    
        //request.setAttribute(Constants.OAWORKFLOWMOVETYPE_LIST, mgr.getOaWorkFlowMoveTypes(oaWorkFlowMoveType));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
