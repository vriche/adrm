
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import java.util.List;

import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.Constants;
import com.vriche.adrm.model.ProProgram;
import com.vriche.adrm.service.ProProgramManager;
import com.vriche.adrm.webapp.form.ProProgramForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a ProProgram object
 *
 * @struts.action name="proProgramForm" path="/proPrograms" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="proProgramForm" path="/editProProgram" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="proProgramForm" path="/saveProProgram" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/merm/proProgramForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/merm/proProgramList.jsp"
 * @struts.action-forward name="search" path="/proPrograms.html" redirect="true"
 */
public final class ProProgramAction extends BaseAction {
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
        ProProgramForm proProgramForm = (ProProgramForm) form;

        // Exceptions are caught by ActionExceptionHandler
        ProProgramManager mgr = (ProProgramManager) getBean("proProgramManager");
        mgr.removeProProgram(proProgramForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("proProgram.deleted"));

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

        ProProgramForm proProgramForm = (ProProgramForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (proProgramForm.getId() != null) {
            ProProgramManager mgr = (ProProgramManager) getBean("proProgramManager");
            ProProgram proProgram = mgr.getProProgram(proProgramForm.getId());
            proProgramForm = (ProProgramForm) convert(proProgram);
            updateFormBean(mapping, request, proProgramForm);
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
        ProProgramForm proProgramForm = (ProProgramForm) form;
        boolean isNew = ("".equals(proProgramForm.getId()) || proProgramForm.getId() == null);

        ProProgramManager mgr = (ProProgramManager) getBean("proProgramManager");
        ProProgram proProgram = (ProProgram) convert(proProgramForm);
        mgr.saveProProgram(proProgram);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("proProgram.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("proProgram.updated"));
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

        ProProgramForm proProgramForm = (ProProgramForm) form;
        ProProgram proProgram = (ProProgram) convert(proProgramForm);
        ProProgramManager mgr = (ProProgramManager) getBean("proProgramManager");
        proProgram = null;
        int resultSize = Integer.parseInt(mgr.getProProgramsCount(proProgram));
        Page page = new Page(Constants.PROPROGRAM_LIST,request);        
        List list = mgr.getProProgramsPage(proProgram,page.getPageIndex().toString(),page.getPageSize().toString());

        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.PROPROGRAM_LIST, list);                    
        //request.setAttribute(Constants.PROPROGRAM_LIST, mgr.getProPrograms(proProgram));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
