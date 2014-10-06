
package com.vriche.adrm.webapp.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.ForetArrearage;
import com.vriche.adrm.service.ForetArrearageManager;
import com.vriche.adrm.util.Page;
import com.vriche.adrm.webapp.form.ForetArrearageForm;

/**
 * Action class to handle CRUD on a ForetArrearage object
 *
 * @struts.action name="foretArrearageForm" path="/foretArrearages" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="foretArrearageForm" path="/editForetArrearage" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="foretArrearageForm" path="/saveForetArrearage" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/finance/foretArrearageForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/finance/foretArrearageList.jsp"
 * @struts.action-forward name="search" path="/foretArrearages.html" redirect="true"
 */
public final class ForetArrearageAction extends BaseAction {
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
        ForetArrearageForm foretArrearageForm = (ForetArrearageForm) form;

        // Exceptions are caught by ActionExceptionHandler
        ForetArrearageManager mgr = (ForetArrearageManager) getBean("foretArrearageManager");
        mgr.removeForetArrearage(foretArrearageForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("foretArrearage.deleted"));

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

        ForetArrearageForm foretArrearageForm = (ForetArrearageForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (foretArrearageForm.getId() != null) {
            ForetArrearageManager mgr = (ForetArrearageManager) getBean("foretArrearageManager");
            ForetArrearage foretArrearage = mgr.getForetArrearage(foretArrearageForm.getId());
            foretArrearageForm = (ForetArrearageForm) convert(foretArrearage);
            updateFormBean(mapping, request, foretArrearageForm);
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
        ForetArrearageForm foretArrearageForm = (ForetArrearageForm) form;
        boolean isNew = ("".equals(foretArrearageForm.getId()) || foretArrearageForm.getId() == null);

        ForetArrearageManager mgr = (ForetArrearageManager) getBean("foretArrearageManager");
        ForetArrearage foretArrearage = (ForetArrearage) convert(foretArrearageForm);
        mgr.saveForetArrearage(foretArrearage);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("foretArrearage.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("foretArrearage.updated"));
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

        ForetArrearageForm foretArrearageForm = (ForetArrearageForm) form;
        ForetArrearage foretArrearage = (ForetArrearage) convert(foretArrearageForm);
        ForetArrearageManager mgr = (ForetArrearageManager) getBean("foretArrearageManager");
        foretArrearage = null;
        int resultSize = Integer.parseInt(mgr.getForetArrearagesCount(foretArrearage));
        Page page = new Page(Constants.FORETARREARAGE_LIST,request);        
        List list = mgr.getForetArrearagesPage(foretArrearage,page.getPageIndex().toString(),page.getPageSize().toString());

        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.FORETARREARAGE_LIST, list);                    
        //request.setAttribute(Constants.FORETARREARAGE_LIST, mgr.getForetArrearages(foretArrearage));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
