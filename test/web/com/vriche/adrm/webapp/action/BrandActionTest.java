package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.BrandForm;
import com.vriche.adrm.Constants;


public class BrandActionTest extends BaseStrutsTestCase {

    public BrandActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveBrand");
        addRequestParameter("method", "Save");

        BrandForm brandForm = new BrandForm();
        // set required fields

        request.setAttribute(Constants.BRAND_KEY, brandForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/brands");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.BRAND_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editBrand");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.BRAND_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editBrand");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        BrandForm brandForm = (BrandForm) request.getAttribute(Constants.BRAND_KEY);
        assertNotNull(brandForm);

        setRequestPathInfo("/saveBrand");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.BRAND_KEY, brandForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"brand.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editBrand");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
