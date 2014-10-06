
package com.vriche.adrm.webapp.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.vriche.adrm.model.Brand;
import com.vriche.adrm.service.BrandManager;
import com.vriche.adrm.webapp.action.BaseAction;
import com.vriche.adrm.webapp.form.BrandForm;
import com.vriche.adrm.Constants;

/**
 * Action class to handle CRUD on a Brand object
 *
 * @struts.action name="brandForm" path="/brands" scope="request"
 *  validate="false" parameter="method" input="mainMenu"
 * @struts.action name="brandForm" path="/editBrand" scope="request"
 *  validate="false" parameter="method" input="list"
 * @struts.action name="brandForm" path="/saveBrand" scope="request"
 *  validate="true" parameter="method" input="edit"
 * @struts.action-set-property property="cancellable" value="true"
 * @struts.action-forward name="edit" path="/WEB-INF/pages/adver/brandForm.jsp"
 * @struts.action-forward name="list" path="/WEB-INF/pages/adver/brandList.jsp"
 * @struts.action-forward name="search" path="/brands.html" redirect="true"
 */

public final class BrandAction extends BaseAction {
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
        BrandForm brandForm = (BrandForm) form;

        // Exceptions are caught by ActionExceptionHandler
        BrandManager mgr = (BrandManager) getBean("brandManager");
        mgr.removeBrand(brandForm.getId());

        messages.add(ActionMessages.GLOBAL_MESSAGE,
                     new ActionMessage("brand.deleted"));

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

        BrandForm brandForm = (BrandForm) form;

        // if an id is passed in, look up the user - otherwise
        // don't do anything - user is doing an add
        if (brandForm.getId() != null) {
            BrandManager mgr = (BrandManager) getBean("brandManager");
            Brand brand = mgr.getBrand(brandForm.getId());
            brandForm = (BrandForm) convert(brand);
            updateFormBean(mapping, request, brandForm);
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
        BrandForm brandForm = (BrandForm) form;
        boolean isNew = ("".equals(brandForm.getId()) || brandForm.getId() == null);

        BrandManager mgr = (BrandManager) getBean("brandManager");
        Brand brand = (Brand) convert(brandForm);
        mgr.saveBrand(brand);

        // add success messages
        if (isNew) {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("brand.added"));

            // save messages in session to survive a redirect
            saveMessages(request.getSession(), messages);

            return mapping.findForward("search");
        } else {
            messages.add(ActionMessages.GLOBAL_MESSAGE,
                         new ActionMessage("brand.updated"));
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

        BrandForm brandForm = (BrandForm) form;
        Brand brand = (Brand) convert(brandForm);

        BrandManager mgr = (BrandManager) getBean("brandManager");
        request.setAttribute(Constants.BRAND_LIST, mgr.getBrands(brand));

        return mapping.findForward("list");
    }
    public ActionForward unspecified(ActionMapping mapping, ActionForm form,
                                     HttpServletRequest request,
                                     HttpServletResponse response)
            throws Exception {
        return search(mapping, form, request, response);
    }
}
