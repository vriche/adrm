package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.ProductCategoryForm;
import com.vriche.adrm.Constants;

public class ProductCategoryActionTest extends BaseStrutsTestCase {

    public ProductCategoryActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveProductCategory");
        addRequestParameter("method", "Save");

        ProductCategoryForm productCategoryForm = new ProductCategoryForm();
        // set required fields

        request.setAttribute(Constants.PRODUCTCATEGORY_KEY, productCategoryForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/productCategorys");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.PRODUCTCATEGORY_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editProductCategory");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.PRODUCTCATEGORY_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editProductCategory");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        ProductCategoryForm productCategoryForm = (ProductCategoryForm) request.getAttribute(Constants.PRODUCTCATEGORY_KEY);
        assertNotNull(productCategoryForm);

        setRequestPathInfo("/saveProductCategory");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.PRODUCTCATEGORY_KEY, productCategoryForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"productCategory.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editProductCategory");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
