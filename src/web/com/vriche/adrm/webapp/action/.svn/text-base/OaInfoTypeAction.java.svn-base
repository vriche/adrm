
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
import com.vriche.adrm.model.OaInfoType;
import com.vriche.adrm.service.OaInfoTypeManager;
import com.vriche.adrm.webapp.form.OaInfoTypeForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaInfoType object
 *
 * @struts.action name="oaInfoTypeForm" path="/oaInfoTypes" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaInfoTypeForm" path="/editOaInfoType" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaInfoTypeForm" path="/saveOaInfoType" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/info/oaInfoTypeForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/info/oaInfoTypeList.jsp"
 * @struts.action-forward name="search" path="/oaInfoTypes.html" redirect="true"
 */
public final class OaInfoTypeAction extends BaseAction {
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
        OaInfoTypeForm oaInfoTypeForm = (OaInfoTypeForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaInfoTypeManager mgr = (OaInfoTypeManager) getBean("oaInfoTypeManager");
        mgr.removeOaInfoType(oaInfoTypeForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaInfoType.deleted"));

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

        OaInfoTypeForm oaInfoTypeForm = (OaInfoTypeForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaInfoTypeForm.getId() != null) {
            OaInfoTypeManager mgr = (OaInfoTypeManager) getBean("oaInfoTypeManager");
            OaInfoType oaInfoType = mgr.getOaInfoType(oaInfoTypeForm.getId());
            oaInfoTypeForm = (OaInfoTypeForm) convert(oaInfoType);
            updateFormBean(mapping, request, oaInfoTypeForm);
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
        OaInfoTypeForm oaInfoTypeForm = (OaInfoTypeForm) form;
        boolean isNew = ("".equals(oaInfoTypeForm.getId()) || oaInfoTypeForm.getId() == null);

        OaInfoTypeManager mgr = (OaInfoTypeManager) getBean("oaInfoTypeManager");
        OaInfoType oaInfoType = (OaInfoType) convert(oaInfoTypeForm);
        mgr.saveOaInfoType(oaInfoType);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaInfoType.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaInfoType.updated"));
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

        OaInfoTypeForm oaInfoTypeForm = (OaInfoTypeForm) form;
        OaInfoType oaInfoType = (OaInfoType) convert(oaInfoTypeForm);
        OaInfoTypeManager mgr = (OaInfoTypeManager) getBean("oaInfoTypeManager");
        oaInfoType = null;
        int resultSize = Integer.parseInt(mgr.getOaInfoTypesCount(oaInfoType));
        Page page = new Page(Constants.OAINFOTYPE_LIST,request);        
        PaginatedList pageList = mgr.getOaInfoTypesPage(oaInfoType,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OAINFOTYPE_LIST, pageList);                    
        //request.setAttribute(Constants.OAINFOTYPE_LIST, mgr.getOaInfoTypes(oaInfoType));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
