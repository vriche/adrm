
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
import com.vriche.adrm.model.OaProductInfo;
import com.vriche.adrm.service.OaProductInfoManager;
import com.vriche.adrm.webapp.form.OaProductInfoForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaProductInfo object
 *
 * @struts.action name="oaProductInfoForm" path="/oaProductInfos" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaProductInfoForm" path="/editOaProductInfo" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaProductInfoForm" path="/saveOaProductInfo" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/product/oaProductInfoForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/product/oaProductInfoList.jsp"
 * @struts.action-forward name="search" path="/oaProductInfos.html" redirect="true"
 */
public final class OaProductInfoAction extends BaseAction {
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
        OaProductInfoForm oaProductInfoForm = (OaProductInfoForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaProductInfoManager mgr = (OaProductInfoManager) getBean("oaProductInfoManager");
        mgr.removeOaProductInfo(oaProductInfoForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaProductInfo.deleted"));

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

        OaProductInfoForm oaProductInfoForm = (OaProductInfoForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaProductInfoForm.getId() != null) {
            OaProductInfoManager mgr = (OaProductInfoManager) getBean("oaProductInfoManager");
            OaProductInfo oaProductInfo = mgr.getOaProductInfo(oaProductInfoForm.getId());
            oaProductInfoForm = (OaProductInfoForm) convert(oaProductInfo);
            updateFormBean(mapping, request, oaProductInfoForm);
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
        OaProductInfoForm oaProductInfoForm = (OaProductInfoForm) form;
        boolean isNew = ("".equals(oaProductInfoForm.getId()) || oaProductInfoForm.getId() == null);

        OaProductInfoManager mgr = (OaProductInfoManager) getBean("oaProductInfoManager");
        OaProductInfo oaProductInfo = (OaProductInfo) convert(oaProductInfoForm);
        mgr.saveOaProductInfo(oaProductInfo);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaProductInfo.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaProductInfo.updated"));
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

        OaProductInfoForm oaProductInfoForm = (OaProductInfoForm) form;
        OaProductInfo oaProductInfo = (OaProductInfo) convert(oaProductInfoForm);
        OaProductInfoManager mgr = (OaProductInfoManager) getBean("oaProductInfoManager");
        oaProductInfo = null;
        int resultSize = Integer.parseInt(mgr.getOaProductInfosCount(oaProductInfo));
        Page page = new Page(Constants.OAPRODUCTINFO_LIST,request);        
        PaginatedList pageList = mgr.getOaProductInfosPage(oaProductInfo,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OAPRODUCTINFO_LIST, pageList);                    
        //request.setAttribute(Constants.OAPRODUCTINFO_LIST, mgr.getOaProductInfos(oaProductInfo));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
