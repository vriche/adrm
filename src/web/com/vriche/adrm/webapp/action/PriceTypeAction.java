
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.PriceType;
import com.vriche.adrm.service.PriceTypeManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.PriceTypeForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a PriceType object
 *
 * @struts.action name="priceTypeForm" path="/priceTypes" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="priceTypeForm" path="/editPriceType" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="priceTypeForm" path="/savePriceType" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adres/priceTypeForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adres/priceTypeList.jsp"
 * @struts.action-forward name="search" path="/priceTypes.html" redirect="true"
 */
public final class PriceTypeAction extends BaseAction {
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
        PriceTypeForm priceTypeForm = (PriceTypeForm) form;

        // Exceptions are caught by ActionExceptionHandler
        PriceTypeManager mgr = (PriceTypeManager) getBean("priceTypeManager");
        mgr.removePriceType(priceTypeForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("priceType.deleted"));

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

        PriceTypeForm priceTypeForm = (PriceTypeForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (priceTypeForm.getId() != null) {
            PriceTypeManager mgr = (PriceTypeManager) getBean("priceTypeManager");
            PriceType priceType = mgr.getPriceType(priceTypeForm.getId());
            priceTypeForm = (PriceTypeForm) convert(priceType);
            updateFormBean(mapping, request, priceTypeForm);
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
        PriceTypeForm priceTypeForm = (PriceTypeForm) form;
        boolean isNew = ("".equals(priceTypeForm.getId()) || priceTypeForm.getId() == null);

        PriceTypeManager mgr = (PriceTypeManager) getBean("priceTypeManager");
        PriceType priceType = (PriceType) convert(priceTypeForm);
        mgr.savePriceType(priceType);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("priceType.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("priceType.updated"));
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

        PriceTypeForm priceTypeForm = (PriceTypeForm) form;
        PriceType priceType = (PriceType) convert(priceTypeForm);

        PriceTypeManager mgr = (PriceTypeManager) getBean("priceTypeManager");
        request.setAttribute(Constants.PRICETYPE_LIST, mgr.getPriceTypes(priceType));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
