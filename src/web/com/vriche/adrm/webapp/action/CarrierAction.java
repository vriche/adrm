
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.service.CarrierManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.CarrierForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a Carrier object
 *
 * @struts.action name="carrierForm" path="/carriers" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="carrierForm" path="/editCarrier" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="carrierForm" path="/saveCarrier" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adres/carrierForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adres/carrierList.jsp"
 * @struts.action-forward name="search" path="/carriers.html" redirect="true"
 */
public final class CarrierAction extends BaseAction {
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
        CarrierForm carrierForm = (CarrierForm) form;

        // Exceptions are caught by ActionExceptionHandler
        CarrierManager mgr = (CarrierManager) getBean("carrierManager");
        mgr.removeCarrier(carrierForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("carrier.deleted"));

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

        CarrierForm carrierForm = (CarrierForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (carrierForm.getId() != null) {
            CarrierManager mgr = (CarrierManager) getBean("carrierManager");
            Carrier carrier = mgr.getCarrier(carrierForm.getId());
            carrierForm = (CarrierForm) convert(carrier);
            updateFormBean(mapping, request, carrierForm);
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
        CarrierForm carrierForm = (CarrierForm) form;
        boolean isNew = ("".equals(carrierForm.getId()) || carrierForm.getId() == null);

        CarrierManager mgr = (CarrierManager) getBean("carrierManager");
        Carrier carrier = (Carrier) convert(carrierForm);
        mgr.saveCarrier(carrier);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("carrier.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("carrier.updated"));
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

        CarrierForm carrierForm = (CarrierForm) form;
        Carrier carrier = (Carrier) convert(carrierForm);

        CarrierManager mgr = (CarrierManager) getBean("carrierManager");
        request.setAttribute(Constants.CARRIER_LIST, mgr.getCarriers(carrier));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
