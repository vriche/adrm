
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
import com.vriche.adrm.model.MatterType;
import com.vriche.adrm.service.MatterTypeManager;
import com.vriche.adrm.webapp.form.MatterTypeForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a MatterType object
 *
 * @struts.action name="matterTypeForm" path="/matterTypes" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="matterTypeForm" path="/editMatterType" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="matterTypeForm" path="/saveMatterType" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adver/matterTypeForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adver/matterTypeList.jsp"
 * @struts.action-forward name="search" path="/matterTypes.html" redirect="true"
 */
public final class MatterTypeAction extends BaseAction {
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
        MatterTypeForm matterTypeForm = (MatterTypeForm) form;

        // Exceptions are caught by ActionExceptionHandler
        MatterTypeManager mgr = (MatterTypeManager) getBean("matterTypeManager");
        mgr.removeMatterType(matterTypeForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("matterType.deleted"));

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

        MatterTypeForm matterTypeForm = (MatterTypeForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (matterTypeForm.getId() != null) {
            MatterTypeManager mgr = (MatterTypeManager) getBean("matterTypeManager");
            MatterType matterType = mgr.getMatterType(matterTypeForm.getId());
            matterTypeForm = (MatterTypeForm) convert(matterType);
            updateFormBean(mapping, request, matterTypeForm);
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
        MatterTypeForm matterTypeForm = (MatterTypeForm) form;
        boolean isNew = ("".equals(matterTypeForm.getId()) || matterTypeForm.getId() == null);

        MatterTypeManager mgr = (MatterTypeManager) getBean("matterTypeManager");
        MatterType matterType = (MatterType) convert(matterTypeForm);
        mgr.saveMatterType(matterType);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("matterType.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("matterType.updated"));
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

        MatterTypeForm matterTypeForm = (MatterTypeForm) form;
        MatterType matterType = (MatterType) convert(matterTypeForm);
        MatterTypeManager mgr = (MatterTypeManager) getBean("matterTypeManager");
        matterType = null;
        int resultSize = Integer.parseInt(mgr.getMatterTypesCount(matterType));
        Page page = new Page(Constants.MATTERTYPE_LIST,request);        
        PaginatedList pageList = mgr.getMatterTypesPage(matterType,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.MATTERTYPE_LIST, pageList);                    
        //request.setAttribute(Constants.MATTERTYPE_LIST, mgr.getMatterTypes(matterType));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
