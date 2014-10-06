
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
import com.vriche.adrm.model.OaWorkFlowType;
import com.vriche.adrm.service.OaWorkFlowTypeManager;
import com.vriche.adrm.webapp.form.OaWorkFlowTypeForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaWorkFlowType object
 *
 * @struts.action name="oaWorkFlowTypeForm" path="/oaWorkFlowTypes" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaWorkFlowTypeForm" path="/editOaWorkFlowType" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaWorkFlowTypeForm" path="/saveOaWorkFlowType" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/workFlow/oaWorkFlowTypeForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/workFlow/oaWorkFlowTypeList.jsp"
 * @struts.action-forward name="search" path="/oaWorkFlowTypes.html" redirect="true"
 */
public final class OaWorkFlowTypeAction extends BaseAction {
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
        OaWorkFlowTypeForm oaWorkFlowTypeForm = (OaWorkFlowTypeForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaWorkFlowTypeManager mgr = (OaWorkFlowTypeManager) getBean("oaWorkFlowTypeManager");
        mgr.removeOaWorkFlowType(oaWorkFlowTypeForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaWorkFlowType.deleted"));

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

        OaWorkFlowTypeForm oaWorkFlowTypeForm = (OaWorkFlowTypeForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaWorkFlowTypeForm.getId() != null) {
            OaWorkFlowTypeManager mgr = (OaWorkFlowTypeManager) getBean("oaWorkFlowTypeManager");
            OaWorkFlowType oaWorkFlowType = mgr.getOaWorkFlowType(oaWorkFlowTypeForm.getId());
            oaWorkFlowTypeForm = (OaWorkFlowTypeForm) convert(oaWorkFlowType);
            updateFormBean(mapping, request, oaWorkFlowTypeForm);
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
        OaWorkFlowTypeForm oaWorkFlowTypeForm = (OaWorkFlowTypeForm) form;
        boolean isNew = ("".equals(oaWorkFlowTypeForm.getId()) || oaWorkFlowTypeForm.getId() == null);

        OaWorkFlowTypeManager mgr = (OaWorkFlowTypeManager) getBean("oaWorkFlowTypeManager");
        OaWorkFlowType oaWorkFlowType = (OaWorkFlowType) convert(oaWorkFlowTypeForm);
        oaWorkFlowType.setParentId(new Long(0));
        mgr.saveOaWorkFlowType(oaWorkFlowType);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaWorkFlowType.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaWorkFlowType.updated"));
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

        OaWorkFlowTypeForm oaWorkFlowTypeForm = (OaWorkFlowTypeForm) form;
        OaWorkFlowType oaWorkFlowType = (OaWorkFlowType) convert(oaWorkFlowTypeForm);
        OaWorkFlowTypeManager mgr = (OaWorkFlowTypeManager) getBean("oaWorkFlowTypeManager");
        oaWorkFlowType = null;
        int resultSize = Integer.parseInt(mgr.getOaWorkFlowTypesCount(oaWorkFlowType));
        Page page = new Page(Constants.OAWORKFLOWTYPE_LIST,request);        
        PaginatedList pageList = mgr.getOaWorkFlowTypesPage(oaWorkFlowType,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OAWORKFLOWTYPE_LIST, pageList);                    
        //request.setAttribute(Constants.OAWORKFLOWTYPE_LIST, mgr.getOaWorkFlowTypes(oaWorkFlowType));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
