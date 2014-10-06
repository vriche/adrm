
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
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.service.SysParamManager;
import com.vriche.adrm.webapp.form.SysParamForm;
import com.vriche.adrm.webapp.listener.StartupListener;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a SysParam object
 *
 * @struts.action name="sysParamForm" path="/sysParams" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="sysParamForm" path="/editSysParam" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="sysParamForm" path="/saveSysParam" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/admin/sysParamForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/admin/sysParamList.jsp"
 * @struts.action-forward name="search" path="/sysParams.html" redirect="true"
 */
public final class SysParamAction extends BaseAction {
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
        SysParamForm sysParamForm = (SysParamForm) form;

        // Exceptions are caught by ActionExceptionHandler
        SysParamManager mgr = (SysParamManager) getBean("sysParamManager");
        mgr.removeSysParam(sysParamForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("sysParam.deleted"));

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

        SysParamForm sysParamForm = (SysParamForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (sysParamForm.getId() != null) {
            SysParamManager mgr = (SysParamManager) getBean("sysParamManager");
            SysParam sysParam = mgr.getSysParam(sysParamForm.getId());
            sysParamForm = (SysParamForm) convert(sysParam);
            updateFormBean(mapping, request, sysParamForm);
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
        SysParamForm sysParamForm = (SysParamForm) form;
        boolean isNew = ("".equals(sysParamForm.getId()) || sysParamForm.getId() == null);

        SysParamManager mgr = (SysParamManager) getBean("sysParamManager");
        SysParam sysParam = (SysParam) convert(sysParamForm);
        mgr.saveSysParam(sysParam);
        
        //÷ÿ‘ÿ—°œÓ
        StartupListener.setupContext(getServlet().getServletContext());

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("sysParam.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("sysParam.updated"));
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

        SysParamForm sysParamForm = (SysParamForm) form;
        SysParam sysParam = (SysParam) convert(sysParamForm);
        SysParamManager mgr = (SysParamManager) getBean("sysParamManager");
        sysParam = null;
        

        
        int resultSize = Integer.parseInt(mgr.getSysParamsCount(sysParam));
        Page page = new Page(Constants.SYSPARAM_LIST,request);   
        
        PaginatedList pageList = mgr.getSysParamsPage(sysParam,page.getPageIndex().toString(),"13");
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.SYSPARAM_LIST, pageList);                    
        //request.setAttribute(Constants.SYSPARAM_LIST, mgr.getSysParams(sysParam));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
