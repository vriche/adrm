
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
import com.vriche.adrm.model.ProOrderType;
import com.vriche.adrm.service.ProOrderTypeManager;
import com.vriche.adrm.webapp.form.ProOrderTypeForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a ProOrderType object
 *
 * @struts.action name="proOrderTypeForm" path="/proOrderTypes" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="proOrderTypeForm" path="/editProOrderType" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="proOrderTypeForm" path="/saveProOrderType" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/merm/proOrderTypeForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/merm/proOrderTypeList.jsp"
 * @struts.action-forward name="search" path="/proOrderTypes.html" redirect="true"
 */
public final class ProOrderTypeAction extends BaseAction {
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
        ProOrderTypeForm proOrderTypeForm = (ProOrderTypeForm) form;

        // Exceptions are caught by ActionExceptionHandler
        ProOrderTypeManager mgr = (ProOrderTypeManager) getBean("proOrderTypeManager");
        mgr.removeProOrderType(proOrderTypeForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("proOrderType.deleted"));

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

        ProOrderTypeForm proOrderTypeForm = (ProOrderTypeForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (proOrderTypeForm.getId() != null) {
            ProOrderTypeManager mgr = (ProOrderTypeManager) getBean("proOrderTypeManager");
            ProOrderType proOrderType = mgr.getProOrderType(proOrderTypeForm.getId());
            proOrderTypeForm = (ProOrderTypeForm) convert(proOrderType);
            updateFormBean(mapping, request, proOrderTypeForm);
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
        ProOrderTypeForm proOrderTypeForm = (ProOrderTypeForm) form;
        boolean isNew = ("".equals(proOrderTypeForm.getId()) || proOrderTypeForm.getId() == null);

        ProOrderTypeManager mgr = (ProOrderTypeManager) getBean("proOrderTypeManager");
        ProOrderType proOrderType = (ProOrderType) convert(proOrderTypeForm);
        mgr.saveProOrderType(proOrderType);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("proOrderType.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("proOrderType.updated"));
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

        ProOrderTypeForm proOrderTypeForm = (ProOrderTypeForm) form;
        ProOrderType proOrderType = (ProOrderType) convert(proOrderTypeForm);
        ProOrderTypeManager mgr = (ProOrderTypeManager) getBean("proOrderTypeManager");
        proOrderType = null;
        int resultSize = Integer.parseInt(mgr.getProOrderTypesCount(proOrderType));
        Page page = new Page(Constants.PROORDERTYPE_LIST,request);        
        List list = mgr.getProOrderTypesPage(proOrderType,page.getPageIndex().toString(),page.getPageSize().toString());

        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.PROORDERTYPE_LIST, list);                    
        //request.setAttribute(Constants.PROORDERTYPE_LIST, mgr.getProOrderTypes(proOrderType));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
