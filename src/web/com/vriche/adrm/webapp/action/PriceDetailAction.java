
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.PriceDetail;
import com.vriche.adrm.service.PriceDetailManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.PriceDetailForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a PriceDetail object
 *
 * @struts.action name="priceDetailForm" path="/priceDetails" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="priceDetailForm" path="/editPriceDetail" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="priceDetailForm" path="/savePriceDetail" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adres/priceDetailForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adres/priceDetailList.jsp"
 * @struts.action-forward name="search" path="/priceDetails.html" redirect="true"
 */
public final class PriceDetailAction extends BaseAction {
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
        PriceDetailForm priceDetailForm = (PriceDetailForm) form;

        // Exceptions are caught by ActionExceptionHandler
        PriceDetailManager mgr = (PriceDetailManager) getBean("priceDetailManager");
        mgr.removePriceDetail(priceDetailForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("priceDetail.deleted"));

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

        PriceDetailForm priceDetailForm = (PriceDetailForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (priceDetailForm.getId() != null) {
            PriceDetailManager mgr = (PriceDetailManager) getBean("priceDetailManager");
            PriceDetail priceDetail = mgr.getPriceDetail(priceDetailForm.getId());
            priceDetailForm = (PriceDetailForm) convert(priceDetail);
            updateFormBean(mapping, request, priceDetailForm);
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
        PriceDetailForm priceDetailForm = (PriceDetailForm) form;
        boolean isNew = ("".equals(priceDetailForm.getId()) || priceDetailForm.getId() == null);

        PriceDetailManager mgr = (PriceDetailManager) getBean("priceDetailManager");
        PriceDetail priceDetail = (PriceDetail) convert(priceDetailForm);
        mgr.savePriceDetail(priceDetail);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("priceDetail.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("priceDetail.updated"));
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

        PriceDetailForm priceDetailForm = (PriceDetailForm) form;
        PriceDetail priceDetail = (PriceDetail) convert(priceDetailForm);

        PriceDetailManager mgr = (PriceDetailManager) getBean("priceDetailManager");
        request.setAttribute(Constants.PRICEDETAIL_LIST, mgr.getPriceDetails(priceDetail));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
