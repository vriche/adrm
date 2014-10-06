
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.DayInfo;
import com.vriche.adrm.service.DayInfoManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.DayInfoForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a DayInfo object
 *
 * @struts.action name="dayInfoForm" path="/dayInfos" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="dayInfoForm" path="/editDayInfo" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="dayInfoForm" path="/saveDayInfo" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adres/dayInfoForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adres/dayInfoList.jsp"
 * @struts.action-forward name="search" path="/dayInfos.html" redirect="true"
 */
public final class DayInfoAction extends BaseAction {
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
        DayInfoForm dayInfoForm = (DayInfoForm) form;

        // Exceptions are caught by ActionExceptionHandler
        DayInfoManager mgr = (DayInfoManager) getBean("dayInfoManager");
        mgr.removeDayInfo(dayInfoForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("dayInfo.deleted"));

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

        DayInfoForm dayInfoForm = (DayInfoForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (dayInfoForm.getId() != null) {
            DayInfoManager mgr = (DayInfoManager) getBean("dayInfoManager");
            DayInfo dayInfo = mgr.getDayInfo(dayInfoForm.getId());
            dayInfoForm = (DayInfoForm) convert(dayInfo);
            updateFormBean(mapping, request, dayInfoForm);
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
        DayInfoForm dayInfoForm = (DayInfoForm) form;
        boolean isNew = ("".equals(dayInfoForm.getId()) || dayInfoForm.getId() == null);

        DayInfoManager mgr = (DayInfoManager) getBean("dayInfoManager");
        DayInfo dayInfo = (DayInfo) convert(dayInfoForm);
        mgr.saveDayInfo(dayInfo);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("dayInfo.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("dayInfo.updated"));
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

        DayInfoForm dayInfoForm = (DayInfoForm) form;
        DayInfo dayInfo = (DayInfo) convert(dayInfoForm);

        DayInfoManager mgr = (DayInfoManager) getBean("dayInfoManager");
        request.setAttribute(Constants.DAYINFO_LIST, mgr.getDayInfos(dayInfo));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
