package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.PriceForm;
import com.vriche.adrm.Constants;

public class PriceActionTest extends BaseStrutsTestCase {

    public PriceActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/savePrice");
        addRequestParameter("method", "Save");

        PriceForm priceForm = new PriceForm();
        // set required fields

        request.setAttribute(Constants.PRICE_KEY, priceForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/prices");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.PRICE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editPrice");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.PRICE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editPrice");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        PriceForm priceForm = (PriceForm) request.getAttribute(Constants.PRICE_KEY);
        assertNotNull(priceForm);

        setRequestPathInfo("/savePrice");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.PRICE_KEY, priceForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"price.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editPrice");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
