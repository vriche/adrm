
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
import com.vriche.adrm.model.OaAssetsType;
import com.vriche.adrm.service.OaAssetsTypeManager;
import com.vriche.adrm.webapp.form.OaAssetsTypeForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaAssetsType object
 *
 * @struts.action name="oaAssetsTypeForm" path="/oaAssetsTypes" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaAssetsTypeForm" path="/editOaAssetsType" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaAssetsTypeForm" path="/saveOaAssetsType" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/assets/oaAssetsTypeForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/assets/oaAssetsTypeList.jsp"
 * @struts.action-forward name="search" path="/oaAssetsTypes.html" redirect="true"
 */
public final class OaAssetsTypeAction extends BaseAction {
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
        OaAssetsTypeForm oaAssetsTypeForm = (OaAssetsTypeForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaAssetsTypeManager mgr = (OaAssetsTypeManager) getBean("oaAssetsTypeManager");
        mgr.removeOaAssetsType(oaAssetsTypeForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaAssetsType.deleted"));

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

        OaAssetsTypeForm oaAssetsTypeForm = (OaAssetsTypeForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaAssetsTypeForm.getId() != null) {
            OaAssetsTypeManager mgr = (OaAssetsTypeManager) getBean("oaAssetsTypeManager");
            OaAssetsType oaAssetsType = mgr.getOaAssetsType(oaAssetsTypeForm.getId());
            oaAssetsTypeForm = (OaAssetsTypeForm) convert(oaAssetsType);
            updateFormBean(mapping, request, oaAssetsTypeForm);
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
        OaAssetsTypeForm oaAssetsTypeForm = (OaAssetsTypeForm) form;
        boolean isNew = ("".equals(oaAssetsTypeForm.getId()) || oaAssetsTypeForm.getId() == null);

        OaAssetsTypeManager mgr = (OaAssetsTypeManager) getBean("oaAssetsTypeManager");
        OaAssetsType oaAssetsType = (OaAssetsType) convert(oaAssetsTypeForm);
        mgr.saveOaAssetsType(oaAssetsType);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaAssetsType.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaAssetsType.updated"));
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

        OaAssetsTypeForm oaAssetsTypeForm = (OaAssetsTypeForm) form;
        OaAssetsType oaAssetsType = (OaAssetsType) convert(oaAssetsTypeForm);
        OaAssetsTypeManager mgr = (OaAssetsTypeManager) getBean("oaAssetsTypeManager");
        oaAssetsType = null;
        int resultSize = Integer.parseInt(mgr.getOaAssetsTypesCount(oaAssetsType));
        Page page = new Page(Constants.OAASSETSTYPE_LIST,request);        
        PaginatedList pageList = mgr.getOaAssetsTypesPage(oaAssetsType,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OAASSETSTYPE_LIST, pageList);                    
        //request.setAttribute(Constants.OAASSETSTYPE_LIST, mgr.getOaAssetsTypes(oaAssetsType));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
