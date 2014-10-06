
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.ProductCategory;
import com.vriche.adrm.service.ProductCategoryManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.ProductCategoryForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a ProductCategory object
 *
 * @struts.action name="productCategoryForm" path="/productCategorys" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="productCategoryForm" path="/editProductCategory" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="productCategoryForm" path="/saveProductCategory" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adver/productCategoryForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adver/productCategoryList.jsp"
 * @struts.action-forward name="search" path="/productCategorys.html" redirect="true"
 */
public final class ProductCategoryAction extends BaseAction {
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
        ProductCategoryForm productCategoryForm = (ProductCategoryForm) form;

        // Exceptions are caught by ActionExceptionHandler
        ProductCategoryManager mgr = (ProductCategoryManager) getBean("productCategoryManager");
        mgr.removeProductCategory(productCategoryForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("productCategory.deleted"));

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

        ProductCategoryForm productCategoryForm = (ProductCategoryForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (productCategoryForm.getId() != null) {
            ProductCategoryManager mgr = (ProductCategoryManager) getBean("productCategoryManager");
            ProductCategory productCategory = mgr.getProductCategory(productCategoryForm.getId());
            productCategoryForm = (ProductCategoryForm) convert(productCategory);
            updateFormBean(mapping, request, productCategoryForm);
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
        ProductCategoryForm productCategoryForm = (ProductCategoryForm) form;
        boolean isNew = ("".equals(productCategoryForm.getId()) || productCategoryForm.getId() == null);
        
        ProductCategoryManager mgr = (ProductCategoryManager) getBean("productCategoryManager");
        ProductCategory productCategory = (ProductCategory) convert(productCategoryForm);
        mgr.saveProductCategory(productCategory);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("productCategory.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("productCategory.updated"));
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

        ProductCategoryForm productCategoryForm = (ProductCategoryForm) form;
        ProductCategory productCategory = (ProductCategory) convert(productCategoryForm);
        System.out.println(">>>>>>>>>>>>>>>"+productCategory.getEnable());
        ProductCategoryManager mgr = (ProductCategoryManager) getBean("productCategoryManager");
        request.setAttribute(Constants.PRODUCTCATEGORY_LIST, mgr.getProductCategorys(productCategory));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
