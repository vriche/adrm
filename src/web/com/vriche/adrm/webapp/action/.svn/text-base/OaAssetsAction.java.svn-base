
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
import com.vriche.adrm.model.OaAssets;
import com.vriche.adrm.service.OaAssetsManager;
import com.vriche.adrm.webapp.form.OaAssetsForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaAssets object
 *
 * @struts.action name="oaAssetsForm" path="/oaAssetss" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaAssetsForm" path="/editOaAssets" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaAssetsForm" path="/saveOaAssets" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/assets/oaAssetsForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/assets/oaAssetsList.jsp"
 * @struts.action-forward name="search" path="/oaAssetss.html" redirect="true"
 */
public final class OaAssetsAction extends BaseAction {
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
        OaAssetsForm oaAssetsForm = (OaAssetsForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaAssetsManager mgr = (OaAssetsManager) getBean("oaAssetsManager");
        mgr.removeOaAssets(oaAssetsForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaAssets.deleted"));

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

        OaAssetsForm oaAssetsForm = (OaAssetsForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaAssetsForm.getId() != null) {
            OaAssetsManager mgr = (OaAssetsManager) getBean("oaAssetsManager");
            OaAssets oaAssets = mgr.getOaAssets(oaAssetsForm.getId());
            oaAssetsForm = (OaAssetsForm) convert(oaAssets);
            updateFormBean(mapping, request, oaAssetsForm);
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
        OaAssetsForm oaAssetsForm = (OaAssetsForm) form;
        boolean isNew = ("".equals(oaAssetsForm.getId()) || oaAssetsForm.getId() == null);

        OaAssetsManager mgr = (OaAssetsManager) getBean("oaAssetsManager");
        OaAssets oaAssets = (OaAssets) convert(oaAssetsForm);
        mgr.saveOaAssets(oaAssets);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaAssets.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaAssets.updated"));
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

        OaAssetsForm oaAssetsForm = (OaAssetsForm) form;
        OaAssets oaAssets = (OaAssets) convert(oaAssetsForm);
        OaAssetsManager mgr = (OaAssetsManager) getBean("oaAssetsManager");
        oaAssets = null;
        int resultSize = Integer.parseInt(mgr.getOaAssetssCount(oaAssets));
        Page page = new Page(Constants.OAASSETS_LIST,request);        
        PaginatedList pageList = mgr.getOaAssetssPage(oaAssets,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OAASSETS_LIST, pageList);                    
        //request.setAttribute(Constants.OAASSETS_LIST, mgr.getOaAssetss(oaAssets));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
