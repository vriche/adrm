
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
import com.vriche.adrm.model.OaBusinessCardType;
import com.vriche.adrm.service.OaBusinessCardTypeManager;
import com.vriche.adrm.webapp.form.OaBusinessCardTypeForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaBusinessCardType object
 *
 * @struts.action name="oaBusinessCardTypeForm" path="/oaBusinessCardTypes" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaBusinessCardTypeForm" path="/editOaBusinessCardType" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaBusinessCardTypeForm" path="/saveOaBusinessCardType" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/tools/oaBusinessCardTypeForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/tools/oaBusinessCardTypeList.jsp"
 * @struts.action-forward name="search" path="/oaBusinessCardTypes.html" redirect="true"
 */
public final class OaBusinessCardTypeAction extends BaseAction {
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
        OaBusinessCardTypeForm oaBusinessCardTypeForm = (OaBusinessCardTypeForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaBusinessCardTypeManager mgr = (OaBusinessCardTypeManager) getBean("oaBusinessCardTypeManager");
        mgr.removeOaBusinessCardType(oaBusinessCardTypeForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaBusinessCardType.deleted"));

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

        OaBusinessCardTypeForm oaBusinessCardTypeForm = (OaBusinessCardTypeForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaBusinessCardTypeForm.getId() != null) {
            OaBusinessCardTypeManager mgr = (OaBusinessCardTypeManager) getBean("oaBusinessCardTypeManager");
            OaBusinessCardType oaBusinessCardType = mgr.getOaBusinessCardType(oaBusinessCardTypeForm.getId());
            oaBusinessCardTypeForm = (OaBusinessCardTypeForm) convert(oaBusinessCardType);
            updateFormBean(mapping, request, oaBusinessCardTypeForm);
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
        OaBusinessCardTypeForm oaBusinessCardTypeForm = (OaBusinessCardTypeForm) form;
        boolean isNew = ("".equals(oaBusinessCardTypeForm.getId()) || oaBusinessCardTypeForm.getId() == null);

        OaBusinessCardTypeManager mgr = (OaBusinessCardTypeManager) getBean("oaBusinessCardTypeManager");
        OaBusinessCardType oaBusinessCardType = (OaBusinessCardType) convert(oaBusinessCardTypeForm);
        mgr.saveOaBusinessCardType(oaBusinessCardType);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaBusinessCardType.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaBusinessCardType.updated"));
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

        OaBusinessCardTypeForm oaBusinessCardTypeForm = (OaBusinessCardTypeForm) form;
        OaBusinessCardType oaBusinessCardType = (OaBusinessCardType) convert(oaBusinessCardTypeForm);
        OaBusinessCardTypeManager mgr = (OaBusinessCardTypeManager) getBean("oaBusinessCardTypeManager");
        oaBusinessCardType = null;
        int resultSize = Integer.parseInt(mgr.getOaBusinessCardTypesCount(oaBusinessCardType));
        Page page = new Page(Constants.OABUSINESSCARDTYPE_LIST,request);        
        PaginatedList pageList = mgr.getOaBusinessCardTypesPage(oaBusinessCardType,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OABUSINESSCARDTYPE_LIST, pageList);                    
        //request.setAttribute(Constants.OABUSINESSCARDTYPE_LIST, mgr.getOaBusinessCardTypes(oaBusinessCardType));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
