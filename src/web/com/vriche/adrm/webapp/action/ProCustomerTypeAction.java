
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
import com.vriche.adrm.model.ProCustomerType;
import com.vriche.adrm.service.ProCustomerTypeManager;
import com.vriche.adrm.webapp.form.ProCustomerTypeForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a ProCustomerType object
 *
 * @struts.action name="proCustomerTypeForm" path="/proCustomerTypes" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="proCustomerTypeForm" path="/editProCustomerType" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="proCustomerTypeForm" path="/saveProCustomerType" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/merm/proCustomerTypeForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/merm/proCustomerTypeList.jsp"
 * @struts.action-forward name="search" path="/proCustomerTypes.html" redirect="true"
 */
public final class ProCustomerTypeAction extends BaseAction {
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
        ProCustomerTypeForm proCustomerTypeForm = (ProCustomerTypeForm) form;

        // Exceptions are caught by ActionExceptionHandler
        ProCustomerTypeManager mgr = (ProCustomerTypeManager) getBean("proCustomerTypeManager");
        mgr.removeProCustomerType(proCustomerTypeForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("proCustomerType.deleted"));

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

        ProCustomerTypeForm proCustomerTypeForm = (ProCustomerTypeForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (proCustomerTypeForm.getId() != null) {
            ProCustomerTypeManager mgr = (ProCustomerTypeManager) getBean("proCustomerTypeManager");
            ProCustomerType proCustomerType = mgr.getProCustomerType(proCustomerTypeForm.getId());
            proCustomerTypeForm = (ProCustomerTypeForm) convert(proCustomerType);
            updateFormBean(mapping, request, proCustomerTypeForm);
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
        ProCustomerTypeForm proCustomerTypeForm = (ProCustomerTypeForm) form;
        boolean isNew = ("".equals(proCustomerTypeForm.getId()) || proCustomerTypeForm.getId() == null);

        ProCustomerTypeManager mgr = (ProCustomerTypeManager) getBean("proCustomerTypeManager");
        ProCustomerType proCustomerType = (ProCustomerType) convert(proCustomerTypeForm);
        mgr.saveProCustomerType(proCustomerType);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("proCustomerType.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("proCustomerType.updated"));
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

        ProCustomerTypeForm proCustomerTypeForm = (ProCustomerTypeForm) form;
        ProCustomerType proCustomerType = (ProCustomerType) convert(proCustomerTypeForm);
        ProCustomerTypeManager mgr = (ProCustomerTypeManager) getBean("proCustomerTypeManager");
        proCustomerType = null;
        int resultSize = Integer.parseInt(mgr.getProCustomerTypesCount(proCustomerType));
        Page page = new Page(Constants.PROCUSTOMERTYPE_LIST,request);        
        List list = mgr.getProCustomerTypesPage(proCustomerType,page.getPageIndex().toString(),page.getPageSize().toString());

        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.PROCUSTOMERTYPE_LIST, list);                    
        //request.setAttribute(Constants.PROCUSTOMERTYPE_LIST, mgr.getProCustomerTypes(proCustomerType));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
