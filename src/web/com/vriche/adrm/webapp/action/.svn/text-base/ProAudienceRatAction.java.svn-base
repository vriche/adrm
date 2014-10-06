
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
import com.vriche.adrm.model.ProAudienceRat;
import com.vriche.adrm.service.ProAudienceRatManager;
import com.vriche.adrm.webapp.form.ProAudienceRatForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a ProAudienceRat object
 *
 * @struts.action name="proAudienceRatForm" path="/proAudienceRats" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="proAudienceRatForm" path="/editProAudienceRat" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="proAudienceRatForm" path="/saveProAudienceRat" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/merm/proAudienceRatForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/merm/proAudienceRatList.jsp"
 * @struts.action-forward name="search" path="/proAudienceRats.html" redirect="true"
 */
public final class ProAudienceRatAction extends BaseAction {
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
        ProAudienceRatForm proAudienceRatForm = (ProAudienceRatForm) form;

        // Exceptions are caught by ActionExceptionHandler
        ProAudienceRatManager mgr = (ProAudienceRatManager) getBean("proAudienceRatManager");
        mgr.removeProAudienceRat(proAudienceRatForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("proAudienceRat.deleted"));

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

        ProAudienceRatForm proAudienceRatForm = (ProAudienceRatForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (proAudienceRatForm.getId() != null) {
            ProAudienceRatManager mgr = (ProAudienceRatManager) getBean("proAudienceRatManager");
            ProAudienceRat proAudienceRat = mgr.getProAudienceRat(proAudienceRatForm.getId());
            proAudienceRatForm = (ProAudienceRatForm) convert(proAudienceRat);
            updateFormBean(mapping, request, proAudienceRatForm);
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
        ProAudienceRatForm proAudienceRatForm = (ProAudienceRatForm) form;
        boolean isNew = ("".equals(proAudienceRatForm.getId()) || proAudienceRatForm.getId() == null);

        ProAudienceRatManager mgr = (ProAudienceRatManager) getBean("proAudienceRatManager");
        ProAudienceRat proAudienceRat = (ProAudienceRat) convert(proAudienceRatForm);
        mgr.saveProAudienceRat(proAudienceRat);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("proAudienceRat.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("proAudienceRat.updated"));
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

        ProAudienceRatForm proAudienceRatForm = (ProAudienceRatForm) form;
        ProAudienceRat proAudienceRat = (ProAudienceRat) convert(proAudienceRatForm);
        ProAudienceRatManager mgr = (ProAudienceRatManager) getBean("proAudienceRatManager");
        proAudienceRat = null;
        int resultSize = Integer.parseInt(mgr.getProAudienceRatsCount(proAudienceRat));
        Page page = new Page(Constants.PROAUDIENCERAT_LIST,request);        
        List list = mgr.getProAudienceRatsPage(proAudienceRat,page.getPageIndex().toString(),page.getPageSize().toString());

        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.PROAUDIENCERAT_LIST, list);                    
        //request.setAttribute(Constants.PROAUDIENCERAT_LIST, mgr.getProAudienceRats(proAudienceRat));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
