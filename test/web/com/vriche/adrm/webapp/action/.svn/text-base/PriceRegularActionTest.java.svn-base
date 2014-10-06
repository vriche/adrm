package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.PriceRegularForm;
import com.vriche.adrm.Constants;

public class PriceRegularActionTest extends BaseStrutsTestCase {

    public PriceRegularActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/savePriceRegular");
        addRequestParameter("method", "Save");

        PriceRegularForm priceRegularForm = new PriceRegularForm();
        // set required fields

        request.setAttribute(Constants.PRICEREGULAR_KEY, priceRegularForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/priceRegulars");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.PRICEREGULAR_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editPriceRegular");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.PRICEREGULAR_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editPriceRegular");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        PriceRegularForm priceRegularForm = (PriceRegularForm) request.getAttribute(Constants.PRICEREGULAR_KEY);
        assertNotNull(priceRegularForm);

        setRequestPathInfo("/savePriceRegular");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.PRICEREGULAR_KEY, priceRegularForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"priceRegular.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editPriceRegular");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
