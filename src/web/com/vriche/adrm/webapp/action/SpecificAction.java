
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.Specific;
import com.vriche.adrm.service.SpecificManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.SpecificForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a Specific object
 *
 * @struts.action name="specificForm" path="/specifics" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="specificForm" path="/editSpecific" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="specificForm" path="/saveSpecific" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adres/specificForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adres/specificList.jsp"
 * @struts.action-forward name="search" path="/specifics.html" redirect="true"
 */
public final class SpecificAction extends BaseAction {
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
        SpecificForm specificForm = (SpecificForm) form;

        // Exceptions are caught by ActionExceptionHandler
        SpecificManager mgr = (SpecificManager) getBean("specificManager");
        mgr.removeSpecific(specificForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("specific.deleted"));

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

        SpecificForm specificForm = (SpecificForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (specificForm.getId() != null) {
            SpecificManager mgr = (SpecificManager) getBean("specificManager");
            Specific specific = mgr.getSpecific(specificForm.getId());
            specificForm = (SpecificForm) convert(specific);
            updateFormBean(mapping, request, specificForm);
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
        SpecificForm specificForm = (SpecificForm) form;
        boolean isNew = ("".equals(specificForm.getId()) || specificForm.getId() == null);

        SpecificManager mgr = (SpecificManager) getBean("specificManager");
        Specific specific = (Specific) convert(specificForm);
        mgr.saveSpecific(specific);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("specific.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("specific.updated"));
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

        SpecificForm specificForm = (SpecificForm) form;
        Specific specific = (Specific) convert(specificForm);

        SpecificManager mgr = (SpecificManager) getBean("specificManager");
        request.setAttribute(Constants.SPECIFIC_LIST, mgr.getSpecifics(specific));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
