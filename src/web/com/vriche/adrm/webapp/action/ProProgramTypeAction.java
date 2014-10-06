
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
import com.vriche.adrm.model.ProProgramType;
import com.vriche.adrm.service.ProProgramTypeManager;
import com.vriche.adrm.webapp.form.ProProgramTypeForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a ProProgramType object
 *
 * @struts.action name="proProgramTypeForm" path="/proProgramTypes" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="proProgramTypeForm" path="/editProProgramType" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="proProgramTypeForm" path="/saveProProgramType" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/merm/proProgramTypeForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/merm/proProgramTypeList.jsp"
 * @struts.action-forward name="search" path="/proProgramTypes.html" redirect="true"
 */
public final class ProProgramTypeAction extends BaseAction {
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
        ProProgramTypeForm proProgramTypeForm = (ProProgramTypeForm) form;

        // Exceptions are caught by ActionExceptionHandler
        ProProgramTypeManager mgr = (ProProgramTypeManager) getBean("proProgramTypeManager");
        mgr.removeProProgramType(proProgramTypeForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("proProgramType.deleted"));

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

        ProProgramTypeForm proProgramTypeForm = (ProProgramTypeForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (proProgramTypeForm.getId() != null) {
            ProProgramTypeManager mgr = (ProProgramTypeManager) getBean("proProgramTypeManager");
            ProProgramType proProgramType = mgr.getProProgramType(proProgramTypeForm.getId());
            proProgramTypeForm = (ProProgramTypeForm) convert(proProgramType);
            updateFormBean(mapping, request, proProgramTypeForm);
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
        ProProgramTypeForm proProgramTypeForm = (ProProgramTypeForm) form;
        boolean isNew = ("".equals(proProgramTypeForm.getId()) || proProgramTypeForm.getId() == null);

        ProProgramTypeManager mgr = (ProProgramTypeManager) getBean("proProgramTypeManager");
        ProProgramType proProgramType = (ProProgramType) convert(proProgramTypeForm);
        mgr.saveProProgramType(proProgramType);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("proProgramType.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("proProgramType.updated"));
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

        ProProgramTypeForm proProgramTypeForm = (ProProgramTypeForm) form;
        ProProgramType proProgramType = (ProProgramType) convert(proProgramTypeForm);
        ProProgramTypeManager mgr = (ProProgramTypeManager) getBean("proProgramTypeManager");
        proProgramType = null;
        int resultSize = Integer.parseInt(mgr.getProProgramTypesCount(proProgramType));
        Page page = new Page(Constants.PROPROGRAMTYPE_LIST,request);        
        List list = mgr.getProProgramTypesPage(proProgramType,page.getPageIndex().toString(),page.getPageSize().toString());

        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.PROPROGRAMTYPE_LIST, list);                    
        //request.setAttribute(Constants.PROPROGRAMTYPE_LIST, mgr.getProProgramTypes(proProgramType));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
