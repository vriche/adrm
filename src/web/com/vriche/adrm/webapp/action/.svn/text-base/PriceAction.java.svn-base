
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.Price;
import com.vriche.adrm.service.PriceManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.PriceForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a Price object
 *
 * @struts.action name="priceForm" path="/prices" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="priceForm" path="/editPrice" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="priceForm" path="/savePrice" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adres/priceForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adres/priceList.jsp"
 * @struts.action-forward name="search" path="/prices.html" redirect="true"
 */
public final class PriceAction extends BaseAction {
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
        PriceForm priceForm = (PriceForm) form;

        // Exceptions are caught by ActionExceptionHandler
        PriceManager mgr = (PriceManager) getBean("priceManager");
        mgr.removePrice(priceForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("price.deleted"));

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

        PriceForm priceForm = (PriceForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (priceForm.getId() != null) {
            PriceManager mgr = (PriceManager) getBean("priceManager");
            Price price = mgr.getPrice(priceForm.getId());
            priceForm = (PriceForm) convert(price);
            updateFormBean(mapping, request, priceForm);
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
        PriceForm priceForm = (PriceForm) form;
        boolean isNew = ("".equals(priceForm.getId()) || priceForm.getId() == null);

        PriceManager mgr = (PriceManager) getBean("priceManager");
        Price price = (Price) convert(priceForm);
        mgr.savePrice(price);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("price.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("price.updated"));
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

        PriceForm priceForm = (PriceForm) form;
        Price price = (Price) convert(priceForm);

        PriceManager mgr = (PriceManager) getBean("priceManager");
        request.setAttribute(Constants.PRICE_LIST, mgr.getPrices(price));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
