
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
import com.vriche.adrm.model.ProPublishPlan;
import com.vriche.adrm.service.ProPublishPlanManager;
import com.vriche.adrm.webapp.form.ProPublishPlanForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a ProPublishPlan object
 *
 * @struts.action name="proPublishPlanForm" path="/proPublishPlans" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="proPublishPlanForm" path="/editProPublishPlan" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="proPublishPlanForm" path="/saveProPublishPlan" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/merm/proPublishPlanForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/merm/proPublishPlanList.jsp"
 * @struts.action-forward name="search" path="/proPublishPlans.html" redirect="true"
 */
public final class ProPublishPlanAction extends BaseAction {
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
        ProPublishPlanForm proPublishPlanForm = (ProPublishPlanForm) form;

        // Exceptions are caught by ActionExceptionHandler
        ProPublishPlanManager mgr = (ProPublishPlanManager) getBean("proPublishPlanManager");
        mgr.removeProPublishPlan(proPublishPlanForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("proPublishPlan.deleted"));

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

        ProPublishPlanForm proPublishPlanForm = (ProPublishPlanForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (proPublishPlanForm.getId() != null) {
            ProPublishPlanManager mgr = (ProPublishPlanManager) getBean("proPublishPlanManager");
            ProPublishPlan proPublishPlan = mgr.getProPublishPlan(proPublishPlanForm.getId());
            proPublishPlanForm = (ProPublishPlanForm) convert(proPublishPlan);
            updateFormBean(mapping, request, proPublishPlanForm);
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
        ProPublishPlanForm proPublishPlanForm = (ProPublishPlanForm) form;
        boolean isNew = ("".equals(proPublishPlanForm.getId()) || proPublishPlanForm.getId() == null);

        ProPublishPlanManager mgr = (ProPublishPlanManager) getBean("proPublishPlanManager");
        ProPublishPlan proPublishPlan = (ProPublishPlan) convert(proPublishPlanForm);
        mgr.saveProPublishPlan(proPublishPlan);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("proPublishPlan.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("proPublishPlan.updated"));
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

        ProPublishPlanForm proPublishPlanForm = (ProPublishPlanForm) form;
        ProPublishPlan proPublishPlan = (ProPublishPlan) convert(proPublishPlanForm);
        ProPublishPlanManager mgr = (ProPublishPlanManager) getBean("proPublishPlanManager");
        proPublishPlan = null;
        int resultSize = Integer.parseInt(mgr.getProPublishPlansCount(proPublishPlan));
        Page page = new Page(Constants.PROPUBLISHPLAN_LIST,request);        
        List list = mgr.getProPublishPlansPage(proPublishPlan,page.getPageIndex().toString(),page.getPageSize().toString());

        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.PROPUBLISHPLAN_LIST, list);                    
        //request.setAttribute(Constants.PROPUBLISHPLAN_LIST, mgr.getProPublishPlans(proPublishPlan));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
