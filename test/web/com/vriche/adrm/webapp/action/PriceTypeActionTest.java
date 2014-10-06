package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.PriceTypeForm;
import com.vriche.adrm.Constants;

public class PriceTypeActionTest extends BaseStrutsTestCase {

    public PriceTypeActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/savePriceType");
        addRequestParameter("method", "Save");

        PriceTypeForm priceTypeForm = new PriceTypeForm();
        // set required fields

        request.setAttribute(Constants.PRICETYPE_KEY, priceTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/priceTypes");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.PRICETYPE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editPriceType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.PRICETYPE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editPriceType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        PriceTypeForm priceTypeForm = (PriceTypeForm) request.getAttribute(Constants.PRICETYPE_KEY);
        assertNotNull(priceTypeForm);

        setRequestPathInfo("/savePriceType");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.PRICETYPE_KEY, priceTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"priceType.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editPriceType");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
