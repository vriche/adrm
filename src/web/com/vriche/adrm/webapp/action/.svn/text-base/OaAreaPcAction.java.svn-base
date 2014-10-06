
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
import com.vriche.adrm.model.OaAreaPc;
import com.vriche.adrm.service.OaAreaPcManager;
import com.vriche.adrm.webapp.form.OaAreaPcForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaAreaPc object
 *
 * @struts.action name="oaAreaPcForm" path="/oaAreaPcs" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaAreaPcForm" path="/editOaAreaPc" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaAreaPcForm" path="/saveOaAreaPc" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/tools/oaAreaPcForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/tools/oaAreaPcList.jsp"
 * @struts.action-forward name="search" path="/oaAreaPcs.html" redirect="true"
 */
public final class OaAreaPcAction extends BaseAction {
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
        OaAreaPcForm oaAreaPcForm = (OaAreaPcForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaAreaPcManager mgr = (OaAreaPcManager) getBean("oaAreaPcManager");
        mgr.removeOaAreaPc(oaAreaPcForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaAreaPc.deleted"));

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

        OaAreaPcForm oaAreaPcForm = (OaAreaPcForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaAreaPcForm.getId() != null) {
            OaAreaPcManager mgr = (OaAreaPcManager) getBean("oaAreaPcManager");
            OaAreaPc oaAreaPc = mgr.getOaAreaPc(oaAreaPcForm.getId());
            oaAreaPcForm = (OaAreaPcForm) convert(oaAreaPc);
            updateFormBean(mapping, request, oaAreaPcForm);
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
        OaAreaPcForm oaAreaPcForm = (OaAreaPcForm) form;
        boolean isNew = ("".equals(oaAreaPcForm.getId()) || oaAreaPcForm.getId() == null);

        OaAreaPcManager mgr = (OaAreaPcManager) getBean("oaAreaPcManager");
        OaAreaPc oaAreaPc = (OaAreaPc) convert(oaAreaPcForm);
        mgr.saveOaAreaPc(oaAreaPc);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaAreaPc.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaAreaPc.updated"));
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

        OaAreaPcForm oaAreaPcForm = (OaAreaPcForm) form;
        OaAreaPc oaAreaPc = (OaAreaPc) convert(oaAreaPcForm);
        OaAreaPcManager mgr = (OaAreaPcManager) getBean("oaAreaPcManager");
        oaAreaPc = null;
        int resultSize = Integer.parseInt(mgr.getOaAreaPcsCount(oaAreaPc));
        Page page = new Page(Constants.OAAREAPC_LIST,request);        
        PaginatedList pageList = mgr.getOaAreaPcsPage(oaAreaPc,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OAAREAPC_LIST, pageList);                    
        //request.setAttribute(Constants.OAAREAPC_LIST, mgr.getOaAreaPcs(oaAreaPc));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
