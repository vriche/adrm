
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
import com.vriche.adrm.model.SysSequence;
import com.vriche.adrm.service.SysSequenceManager;
import com.vriche.adrm.webapp.form.SysSequenceForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a SysSequence object
 *
 * @struts.action name="sysSequenceForm" path="/sysSequences" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="sysSequenceForm" path="/editSysSequence" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="sysSequenceForm" path="/saveSysSequence" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/admin/sysSequenceForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/admin/sysSequenceList.jsp"
 * @struts.action-forward name="search" path="/sysSequences.html" redirect="true"
 */
public final class SysSequenceAction extends BaseAction {
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
        SysSequenceForm sysSequenceForm = (SysSequenceForm) form;

        // Exceptions are caught by ActionExceptionHandler
        SysSequenceManager mgr = (SysSequenceManager) getBean("sysSequenceManager");
        mgr.removeSysSequence(sysSequenceForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("sysSequence.deleted"));

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

        SysSequenceForm sysSequenceForm = (SysSequenceForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (sysSequenceForm.getId() != null) {
            SysSequenceManager mgr = (SysSequenceManager) getBean("sysSequenceManager");
            SysSequence sysSequence = mgr.getSysSequence(sysSequenceForm.getId());
            sysSequenceForm = (SysSequenceForm) convert(sysSequence);
            updateFormBean(mapping, request, sysSequenceForm);
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
        SysSequenceForm sysSequenceForm = (SysSequenceForm) form;
        boolean isNew = ("".equals(sysSequenceForm.getId()) || sysSequenceForm.getId() == null);

        SysSequenceManager mgr = (SysSequenceManager) getBean("sysSequenceManager");
        SysSequence sysSequence = (SysSequence) convert(sysSequenceForm);
        mgr.saveSysSequence(sysSequence);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("sysSequence.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("sysSequence.updated"));
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

        SysSequenceForm sysSequenceForm = (SysSequenceForm) form;
        SysSequence sysSequence = (SysSequence) convert(sysSequenceForm);
        SysSequenceManager mgr = (SysSequenceManager) getBean("sysSequenceManager");
        sysSequence = null;
        int resultSize = Integer.parseInt(mgr.getSysSequencesCount(sysSequence));
        Page page = new Page(Constants.SYSSEQUENCE_LIST,request);        
        PaginatedList pageList = mgr.getSysSequencesPage(sysSequence,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.SYSSEQUENCE_LIST, pageList);                    
        //request.setAttribute(Constants.SYSSEQUENCE_LIST, mgr.getSysSequences(sysSequence));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
