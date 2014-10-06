
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
import com.vriche.adrm.model.OaProductType;
import com.vriche.adrm.service.OaProductTypeManager;
import com.vriche.adrm.webapp.form.OaProductTypeForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaProductType object
 *
 * @struts.action name="oaProductTypeForm" path="/oaProductTypes" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaProductTypeForm" path="/editOaProductType" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaProductTypeForm" path="/saveOaProductType" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/product/oaProductTypeForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/product/oaProductTypeList.jsp"
 * @struts.action-forward name="search" path="/oaProductTypes.html" redirect="true"
 */
public final class OaProductTypeAction extends BaseAction {
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
        OaProductTypeForm oaProductTypeForm = (OaProductTypeForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaProductTypeManager mgr = (OaProductTypeManager) getBean("oaProductTypeManager");
        mgr.removeOaProductType(oaProductTypeForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaProductType.deleted"));

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

        OaProductTypeForm oaProductTypeForm = (OaProductTypeForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaProductTypeForm.getId() != null) {
            OaProductTypeManager mgr = (OaProductTypeManager) getBean("oaProductTypeManager");
            OaProductType oaProductType = mgr.getOaProductType(oaProductTypeForm.getId());
            oaProductTypeForm = (OaProductTypeForm) convert(oaProductType);
            updateFormBean(mapping, request, oaProductTypeForm);
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
        OaProductTypeForm oaProductTypeForm = (OaProductTypeForm) form;
        boolean isNew = ("".equals(oaProductTypeForm.getId()) || oaProductTypeForm.getId() == null);

        OaProductTypeManager mgr = (OaProductTypeManager) getBean("oaProductTypeManager");
        OaProductType oaProductType = (OaProductType) convert(oaProductTypeForm);
        mgr.saveOaProductType(oaProductType);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaProductType.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaProductType.updated"));
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

        OaProductTypeForm oaProductTypeForm = (OaProductTypeForm) form;
        OaProductType oaProductType = (OaProductType) convert(oaProductTypeForm);
        OaProductTypeManager mgr = (OaProductTypeManager) getBean("oaProductTypeManager");
        oaProductType = null;
        int resultSize = Integer.parseInt(mgr.getOaProductTypesCount(oaProductType));
        Page page = new Page(Constants.OAPRODUCTTYPE_LIST,request);        
        PaginatedList pageList = mgr.getOaProductTypesPage(oaProductType,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OAPRODUCTTYPE_LIST, pageList);                    
        //request.setAttribute(Constants.OAPRODUCTTYPE_LIST, mgr.getOaProductTypes(oaProductType));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
