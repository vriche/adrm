
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
import com.vriche.adrm.model.ResourceSort;
import com.vriche.adrm.service.ResourceSortManager;
import com.vriche.adrm.webapp.form.ResourceSortForm;
import com.vriche.adrm.Constants;
import com.vriche.adrm.util.Page;

/**
 * Action class to handle CRUD on a ResourceSort object
 *
 * @struts.action name="resourceSortForm" path="/resourceSorts" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="resourceSortForm" path="/editResourceSort" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="resourceSortForm" path="/saveResourceSort" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adres/resourceSortForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adres/resourceSortList.jsp"
 * @struts.action-forward name="search" path="/resourceSorts.html" redirect="true"
 */
public final class ResourceSortAction extends BaseAction {
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
        ResourceSortForm resourceSortForm = (ResourceSortForm) form;

        // Exceptions are caught by ActionExceptionHandler
        ResourceSortManager mgr = (ResourceSortManager) getBean("resourceSortManager");
        mgr.removeResourceSort(resourceSortForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("resourceSort.deleted"));

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

        ResourceSortForm resourceSortForm = (ResourceSortForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (resourceSortForm.getId() != null) {
            ResourceSortManager mgr = (ResourceSortManager) getBean("resourceSortManager");
            ResourceSort resourceSort = mgr.getResourceSort(resourceSortForm.getId());
            resourceSortForm = (ResourceSortForm) convert(resourceSort);
            updateFormBean(mapping, request, resourceSortForm);
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
        ResourceSortForm resourceSortForm = (ResourceSortForm) form;
        boolean isNew = ("".equals(resourceSortForm.getId()) || resourceSortForm.getId() == null);

        ResourceSortManager mgr = (ResourceSortManager) getBean("resourceSortManager");
        ResourceSort resourceSort = (ResourceSort) convert(resourceSortForm);
        mgr.saveResourceSort(resourceSort);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("resourceSort.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("resourceSort.updated"));
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

        ResourceSortForm resourceSortForm = (ResourceSortForm) form;
        ResourceSort resourceSort = (ResourceSort) convert(resourceSortForm);
        ResourceSortManager mgr = (ResourceSortManager) getBean("resourceSortManager");
        resourceSort = null;
        int resultSize = Integer.parseInt(mgr.getResourceSortsCount(resourceSort));
        Page page = new Page(Constants.RESOURCESORT_LIST,request);        
        PaginatedList pageList = mgr.getResourceSortsPage(resourceSort,page.getPageIndex().toString(),page.getPageSize().toString());
        pageList.gotoPage(page.getPageIndex().intValue());   
        request.setAttribute(Constants.RESULT_SIZE, new Integer(resultSize));
        request.setAttribute(Constants.RESOURCESORT_LIST, pageList);                    
        //request.setAttribute(Constants.RESOURCESORT_LIST, mgr.getResourceSorts(resourceSort));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
