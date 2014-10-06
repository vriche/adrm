
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import com.ibatis.common.util.PaginatedList;

import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.Constants;
import com.vriche.adrm.model.OaScratchpad;
import com.vriche.adrm.service.OaScratchpadManager;
import com.vriche.adrm.webapp.form.OaScratchpadForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a OaScratchpad object
 *
 * @struts.action name="oaScratchpadForm" path="/oaScratchpads" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="oaScratchpadForm" path="/editOaScratchpad" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="oaScratchpadForm" path="/saveOaScratchpad" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/tools/oaScratchpadForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/tools/oaScratchpadList.jsp"
 * @struts.action-forward name="search" path="/oaScratchpads.html" redirect="true"
 */
public final class OaScratchpadAction extends BaseAction {
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
        OaScratchpadForm oaScratchpadForm = (OaScratchpadForm) form;

        // Exceptions are caught by ActionExceptionHandler
        OaScratchpadManager mgr = (OaScratchpadManager) getBean("oaScratchpadManager");
        mgr.removeOaScratchpad(oaScratchpadForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("oaScratchpad.deleted"));

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

        OaScratchpadForm oaScratchpadForm = (OaScratchpadForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (oaScratchpadForm.getId() != null) {
            OaScratchpadManager mgr = (OaScratchpadManager) getBean("oaScratchpadManager");
            OaScratchpad oaScratchpad = mgr.getOaScratchpad(oaScratchpadForm.getId());
            oaScratchpadForm = (OaScratchpadForm) convert(oaScratchpad);
            updateFormBean(mapping, request, oaScratchpadForm);
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
        OaScratchpadForm oaScratchpadForm = (OaScratchpadForm) form;
        boolean isNew = ("".equals(oaScratchpadForm.getId()) || oaScratchpadForm.getId() == null);

        OaScratchpadManager mgr = (OaScratchpadManager) getBean("oaScratchpadManager");
        OaScratchpad oaScratchpad = (OaScratchpad) convert(oaScratchpadForm);
        mgr.saveOaScratchpad(oaScratchpad);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaScratchpad.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("oaScratchpad.updated"));
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

        OaScratchpadForm oaScratchpadForm = (OaScratchpadForm) form;
        OaScratchpad oaScratchpad = (OaScratchpad) convert(oaScratchpadForm);
        OaScratchpadManager mgr = (OaScratchpadManager) getBean("oaScratchpadManager");
        oaScratchpad = null;
        int resultSize = Integer.parseInt(mgr.getOaScratchpadsCount(oaScratchpad));
        Page page = new Page(Constants.OASCRATCHPAD_LIST,request);        
        PaginatedList pageList = mgr.getOaScratchpadsPage(oaScratchpad,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.OASCRATCHPAD_LIST, pageList);                    
        //request.setAttribute(Constants.OASCRATCHPAD_LIST, mgr.getOaScratchpads(oaScratchpad));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
