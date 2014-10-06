
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
import com.vriche.adrm.model.OaApplyInfo;
import com.vriche.adrm.service.OaApplyInfoManager;
import com.vriche.adrm.webapp.form.OaApplyInfoForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaApplyInfo object
 *
 * @struts.action name="oaApplyInfoForm" path="/oaApplyInfos" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaApplyInfoForm" path="/editOaApplyInfo" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaApplyInfoForm" path="/saveOaApplyInfo" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/workFlow/oaApplyInfoForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/workFlow/oaApplyInfoList.jsp"
 * @struts.action-forward name="search" path="/oaApplyInfos.html" redirect="true"
 */
public final class OaApplyInfoAction extends BaseAction {
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
        OaApplyInfoForm oaApplyInfoForm = (OaApplyInfoForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaApplyInfoManager mgr = (OaApplyInfoManager) getBean("oaApplyInfoManager");
        mgr.removeOaApplyInfo(oaApplyInfoForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaApplyInfo.deleted"));

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

        OaApplyInfoForm oaApplyInfoForm = (OaApplyInfoForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaApplyInfoForm.getId() != null) {
            OaApplyInfoManager mgr = (OaApplyInfoManager) getBean("oaApplyInfoManager");
            OaApplyInfo oaApplyInfo = mgr.getOaApplyInfo(oaApplyInfoForm.getId());
            oaApplyInfoForm = (OaApplyInfoForm) convert(oaApplyInfo);
            updateFormBean(mapping, request, oaApplyInfoForm);
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
        OaApplyInfoForm oaApplyInfoForm = (OaApplyInfoForm) form;
        boolean isNew = ("".equals(oaApplyInfoForm.getId()) || oaApplyInfoForm.getId() == null);

        OaApplyInfoManager mgr = (OaApplyInfoManager) getBean("oaApplyInfoManager");
        OaApplyInfo oaApplyInfo = (OaApplyInfo) convert(oaApplyInfoForm);
        mgr.saveOaApplyInfo(oaApplyInfo);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaApplyInfo.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaApplyInfo.updated"));
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

        OaApplyInfoForm oaApplyInfoForm = (OaApplyInfoForm) form;
        OaApplyInfo oaApplyInfo = (OaApplyInfo) convert(oaApplyInfoForm);
        OaApplyInfoManager mgr = (OaApplyInfoManager) getBean("oaApplyInfoManager");
        oaApplyInfo = null;
        int resultSize = Integer.parseInt(mgr.getOaApplyInfosCount(oaApplyInfo));
        Page page = new Page(Constants.OAAPPLYINFO_LIST,request);        
        PaginatedList pageList = mgr.getOaApplyInfosPage(oaApplyInfo,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OAAPPLYINFO_LIST, pageList);                    
        //request.setAttribute(Constants.OAAPPLYINFO_LIST, mgr.getOaApplyInfos(oaApplyInfo));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
