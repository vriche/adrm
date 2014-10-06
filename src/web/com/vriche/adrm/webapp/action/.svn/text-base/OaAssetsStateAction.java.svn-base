
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
import com.vriche.adrm.model.OaAssetsState;
import com.vriche.adrm.service.OaAssetsStateManager;
import com.vriche.adrm.webapp.form.OaAssetsStateForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaAssetsState object
 *
 * @struts.action name="oaAssetsStateForm" path="/oaAssetsStates" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaAssetsStateForm" path="/editOaAssetsState" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaAssetsStateForm" path="/saveOaAssetsState" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/assets/oaAssetsStateForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/assets/oaAssetsStateList.jsp"
 * @struts.action-forward name="search" path="/oaAssetsStates.html" redirect="true"
 */
public final class OaAssetsStateAction extends BaseAction {
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
        OaAssetsStateForm oaAssetsStateForm = (OaAssetsStateForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaAssetsStateManager mgr = (OaAssetsStateManager) getBean("oaAssetsStateManager");
        mgr.removeOaAssetsState(oaAssetsStateForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaAssetsState.deleted"));

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

        OaAssetsStateForm oaAssetsStateForm = (OaAssetsStateForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaAssetsStateForm.getId() != null) {
            OaAssetsStateManager mgr = (OaAssetsStateManager) getBean("oaAssetsStateManager");
            OaAssetsState oaAssetsState = mgr.getOaAssetsState(oaAssetsStateForm.getId());
            oaAssetsStateForm = (OaAssetsStateForm) convert(oaAssetsState);
            updateFormBean(mapping, request, oaAssetsStateForm);
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
        OaAssetsStateForm oaAssetsStateForm = (OaAssetsStateForm) form;
        boolean isNew = ("".equals(oaAssetsStateForm.getId()) || oaAssetsStateForm.getId() == null);

        OaAssetsStateManager mgr = (OaAssetsStateManager) getBean("oaAssetsStateManager");
        OaAssetsState oaAssetsState = (OaAssetsState) convert(oaAssetsStateForm);
        mgr.saveOaAssetsState(oaAssetsState);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaAssetsState.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaAssetsState.updated"));
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

        OaAssetsStateForm oaAssetsStateForm = (OaAssetsStateForm) form;
        OaAssetsState oaAssetsState = (OaAssetsState) convert(oaAssetsStateForm);
        OaAssetsStateManager mgr = (OaAssetsStateManager) getBean("oaAssetsStateManager");
        oaAssetsState = null;
        int resultSize = Integer.parseInt(mgr.getOaAssetsStatesCount(oaAssetsState));
        Page page = new Page(Constants.OAASSETSSTATE_LIST,request);        
        PaginatedList pageList = mgr.getOaAssetsStatesPage(oaAssetsState,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OAASSETSSTATE_LIST, pageList);                    
        //request.setAttribute(Constants.OAASSETSSTATE_LIST, mgr.getOaAssetsStates(oaAssetsState));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
