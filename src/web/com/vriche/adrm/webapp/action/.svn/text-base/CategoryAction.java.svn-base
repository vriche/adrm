
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.Category;
import com.vriche.adrm.service.CategoryManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.CategoryForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a Category object
 *
 * @struts.action name="categoryForm" path="/categorys" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="categoryForm" path="/editCategory" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="categoryForm" path="/saveCategory" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/crm/categoryForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/crm/categoryList.jsp"
 * @struts.action-forward name="search" path="/categorys.html" redirect="true"
 */
public final class CategoryAction extends BaseAction {
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
        CategoryForm categoryForm = (CategoryForm) form;

        // Exceptions are caught by ActionExceptionHandler
        CategoryManager mgr = (CategoryManager) getBean("categoryManager");
        mgr.removeCategory(categoryForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("category.deleted"));

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

        CategoryForm categoryForm = (CategoryForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (categoryForm.getId() != null) {
            CategoryManager mgr = (CategoryManager) getBean("categoryManager");
            Category category = mgr.getCategory(categoryForm.getId());
            categoryForm = (CategoryForm) convert(category);
            updateFormBean(mapping, request, categoryForm);
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
        CategoryForm categoryForm = (CategoryForm) form;
        boolean isNew = ("".equals(categoryForm.getId()) || categoryForm.getId() == null);

        CategoryManager mgr = (CategoryManager) getBean("categoryManager");
        Category category = (Category) convert(categoryForm);
        mgr.saveCategory(category);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("category.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("category.updated"));
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

        CategoryForm categoryForm = (CategoryForm) form;
        Category category = (Category) convert(categoryForm);

        CategoryManager mgr = (CategoryManager) getBean("categoryManager");
        request.setAttribute(Constants.CATEGORY_LIST, mgr.getCategorys(category));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
