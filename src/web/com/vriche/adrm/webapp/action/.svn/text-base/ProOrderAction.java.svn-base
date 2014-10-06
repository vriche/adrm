
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
import com.vriche.adrm.model.ProOrder;
import com.vriche.adrm.service.ProOrderManager;
import com.vriche.adrm.webapp.form.ProOrderForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a ProOrder object
 *
 * @struts.action name="proOrderForm" path="/proOrders" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="proOrderForm" path="/editProOrder" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="proOrderForm" path="/saveProOrder" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/merm/proOrderForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/merm/proOrderList.jsp"
 * @struts.action-forward name="search" path="/proOrders.html" redirect="true"
 */
public final class ProOrderAction extends BaseAction {
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
        ProOrderForm proOrderForm = (ProOrderForm) form;

        // Exceptions are caught by ActionExceptionHandler
        ProOrderManager mgr = (ProOrderManager) getBean("proOrderManager");
        mgr.removeProOrder(proOrderForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("proOrder.deleted"));

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

        ProOrderForm proOrderForm = (ProOrderForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (proOrderForm.getId() != null) {
            ProOrderManager mgr = (ProOrderManager) getBean("proOrderManager");
            ProOrder proOrder = mgr.getProOrder(proOrderForm.getId());
            proOrderForm = (ProOrderForm) convert(proOrder);
            updateFormBean(mapping, request, proOrderForm);
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
        ProOrderForm proOrderForm = (ProOrderForm) form;
        boolean isNew = ("".equals(proOrderForm.getId()) || proOrderForm.getId() == null);

        ProOrderManager mgr = (ProOrderManager) getBean("proOrderManager");
        ProOrder proOrder = (ProOrder) convert(proOrderForm);
        mgr.saveProOrder(proOrder);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("proOrder.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("proOrder.updated"));
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

        ProOrderForm proOrderForm = (ProOrderForm) form;
        ProOrder proOrder = (ProOrder) convert(proOrderForm);
        ProOrderManager mgr = (ProOrderManager) getBean("proOrderManager");
        proOrder = null;
        int resultSize = Integer.parseInt(mgr.getProOrdersCount(proOrder));
        Page page = new Page(Constants.PROORDER_LIST,request);        
        List list = mgr.getProOrdersPage(proOrder,page.getPageIndex().toString(),page.getPageSize().toString());

        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.PROORDER_LIST, list);                    
        //request.setAttribute(Constants.PROORDER_LIST, mgr.getProOrders(proOrder));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
