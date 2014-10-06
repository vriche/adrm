
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.ibatis.common.util.PaginatedList;
import com.vriche.adrm.model.Industry;
import com.vriche.adrm.service.IndustryManager;
import com.vriche.adrm.webapp.form.IndustryForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a Industry object
 *
 * @struts.action name="industryForm" path="/industrys" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="industryForm" path="/editIndustry" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="industryForm" path="/saveIndustry" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/crm/industryForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/crm/industryList.jsp"
 * @struts.action-forward name="search" path="/industrys.html" redirect="true"
 */
public final class IndustryAction extends BaseAction {
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
        IndustryForm industryForm = (IndustryForm) form;

        // Exceptions are caught by ActionExceptionHandler
        IndustryManager mgr = (IndustryManager) getBean("industryManager");
        mgr.removeIndustry(industryForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("industry.deleted"));

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

        IndustryForm industryForm = (IndustryForm) form;
        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (industryForm.getId() != null) {
            IndustryManager mgr = (IndustryManager) getBean("industryManager");
            Industry industry = mgr.getIndustry(industryForm.getId());
            industryForm = (IndustryForm) convert(industry);
            updateFormBean(mapping, request, industryForm);
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
        IndustryForm industryForm = (IndustryForm) form;
        boolean isNew = ("".equals(industryForm.getId()) || industryForm.getId() == null);

        IndustryManager mgr = (IndustryManager) getBean("industryManager");
        Industry industry = (Industry) convert(industryForm);
        mgr.saveIndustry(industry);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("industry.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("industry.updated"));
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

        IndustryForm industryForm = (IndustryForm) form;
        Industry industry = (Industry) convert(industryForm);
        IndustryManager mgr = (IndustryManager) getBean("industryManager");
        
        int  resultSize = Integer.parseInt(mgr.getIndustrysCount(industry));
        Page page = new Page(Constants.INDUSTRY_LIST,request);
        PaginatedList pageList = mgr.getIndustrysPage(industry,"19");
        pageList.gotoPage(page.getPageIndex().intValue());   
        
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.INDUSTRY_LIST, pageList);

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
