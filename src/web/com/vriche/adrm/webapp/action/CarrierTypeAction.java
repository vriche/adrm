
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.CarrierType;
import com.vriche.adrm.service.CarrierTypeManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.CarrierTypeForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a CarrierType object
 *
 * @struts.action name="carrierTypeForm" path="/carrierTypes" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="carrierTypeForm" path="/editCarrierType" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="carrierTypeForm" path="/saveCarrierType" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adres/carrierTypeForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adres/carrierTypeList.jsp"
 * @struts.action-forward name="search" path="/carrierTypes.html" redirect="true"
 */
public final class CarrierTypeAction extends BaseAction {
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
        CarrierTypeForm carrierTypeForm = (CarrierTypeForm) form;

        // Exceptions are caught by ActionExceptionHandler
        CarrierTypeManager mgr = (CarrierTypeManager) getBean("carrierTypeManager");
        mgr.removeCarrierType(carrierTypeForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("carrierType.deleted"));

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

        CarrierTypeForm carrierTypeForm = (CarrierTypeForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (carrierTypeForm.getId() != null) {
            CarrierTypeManager mgr = (CarrierTypeManager) getBean("carrierTypeManager");
            CarrierType carrierType = mgr.getCarrierType(carrierTypeForm.getId());
            carrierTypeForm = (CarrierTypeForm) convert(carrierType);
            updateFormBean(mapping, request, carrierTypeForm);
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
        CarrierTypeForm carrierTypeForm = (CarrierTypeForm) form;
        boolean isNew = ("".equals(carrierTypeForm.getId()) || carrierTypeForm.getId() == null);

        CarrierTypeManager mgr = (CarrierTypeManager) getBean("carrierTypeManager");
        CarrierType carrierType = (CarrierType) convert(carrierTypeForm);
        carrierType.setParentId(new Long(0));
        mgr.saveCarrierType(carrierType);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("carrierType.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("carrierType.updated"));
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

        CarrierTypeForm carrierTypeForm = (CarrierTypeForm) form;
        CarrierType carrierType = (CarrierType) convert(carrierTypeForm);
        
        String orgId = request.getParameter("orgId");
        orgId = orgId == null?"0":orgId;
        carrierType.setOrgId(new Long(orgId));

        
        System.out.println("orgId >>>>>>>>>>>>>>>>"+orgId);
        
        

        CarrierTypeManager mgr = (CarrierTypeManager) getBean("carrierTypeManager");
        request.setAttribute(Constants.CARRIERTYPE_LIST, mgr.getCarrierTypes(carrierType));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
