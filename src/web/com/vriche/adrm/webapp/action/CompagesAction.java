
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.Compages;
import com.vriche.adrm.service.CompagesManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.CompagesForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a Compages object
 *
 * @struts.action name="compagesForm" path="/compagess" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="compagesForm" path="/editCompages" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="compagesForm" path="/saveCompages" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adres/compagesForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adres/compagesList.jsp"
 * @struts.action-forward name="search" path="/compagess.html" redirect="true"
 */
public final class CompagesAction extends BaseAction {
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
        CompagesForm compagesForm = (CompagesForm) form;

        // Exceptions are caught by ActionExceptionHandler
        CompagesManager mgr = (CompagesManager) getBean("compagesManager");
//        mgr.removeCompages(compagesForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("compages.deleted"));

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

        CompagesForm compagesForm = (CompagesForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (compagesForm.getId() != null) {
            CompagesManager mgr = (CompagesManager) getBean("compagesManager");
            Compages compages = mgr.getCompages(compagesForm.getId());
            compagesForm = (CompagesForm) convert(compages);
            updateFormBean(mapping, request, compagesForm);
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
        CompagesForm compagesForm = (CompagesForm) form;
        boolean isNew = ("".equals(compagesForm.getId()) || compagesForm.getId() == null);

        CompagesManager mgr = (CompagesManager) getBean("compagesManager");
        Compages compages = (Compages) convert(compagesForm);
        mgr.saveCompages(compages);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("compages.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("compages.updated"));
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

        CompagesForm compagesForm = (CompagesForm) form;
        Compages compages = (Compages) convert(compagesForm);

        CompagesManager mgr = (CompagesManager) getBean("compagesManager");
        request.setAttribute(Constants.COMPAGES_LIST, mgr.getCompagess(compages));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
