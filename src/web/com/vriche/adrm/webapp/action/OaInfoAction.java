
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
import com.vriche.adrm.model.OaInfo;
import com.vriche.adrm.service.OaInfoManager;
import com.vriche.adrm.webapp.form.OaInfoForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaInfo object
 *
 * @struts.action name="oaInfoForm" path="/oaInfos" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaInfoForm" path="/editOaInfo" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaInfoForm" path="/saveOaInfo" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/info/oaInfoForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/info/oaInfoList.jsp"
 * @struts.action-forward name="search" path="/oaInfos.html" redirect="true"
 */
public final class OaInfoAction extends BaseAction {
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
        OaInfoForm oaInfoForm = (OaInfoForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaInfoManager mgr = (OaInfoManager) getBean("oaInfoManager");
        mgr.removeOaInfo(oaInfoForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaInfo.deleted"));

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

        OaInfoForm oaInfoForm = (OaInfoForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaInfoForm.getId() != null) {
            OaInfoManager mgr = (OaInfoManager) getBean("oaInfoManager");
            OaInfo oaInfo = mgr.getOaInfo(oaInfoForm.getId());
            oaInfoForm = (OaInfoForm) convert(oaInfo);
            updateFormBean(mapping, request, oaInfoForm);
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
        OaInfoForm oaInfoForm = (OaInfoForm) form;
        boolean isNew = ("".equals(oaInfoForm.getId()) || oaInfoForm.getId() == null);

        OaInfoManager mgr = (OaInfoManager) getBean("oaInfoManager");
        OaInfo oaInfo = (OaInfo) convert(oaInfoForm);
        mgr.saveOaInfo(oaInfo);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaInfo.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaInfo.updated"));
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

        OaInfoForm oaInfoForm = (OaInfoForm) form;
        OaInfo oaInfo = (OaInfo) convert(oaInfoForm);
        OaInfoManager mgr = (OaInfoManager) getBean("oaInfoManager");
        oaInfo = null;
        int resultSize = Integer.parseInt(mgr.getOaInfosCount(oaInfo));
        Page page = new Page(Constants.OAINFO_LIST,request);        
        PaginatedList pageList = mgr.getOaInfosPage(oaInfo,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OAINFO_LIST, pageList);                    
        //request.setAttribute(Constants.OAINFO_LIST, mgr.getOaInfos(oaInfo));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
