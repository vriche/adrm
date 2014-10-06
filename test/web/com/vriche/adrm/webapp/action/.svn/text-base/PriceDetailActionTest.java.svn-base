package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.PriceDetailForm;
import com.vriche.adrm.Constants;

public class PriceDetailActionTest extends BaseStrutsTestCase {

    public PriceDetailActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/savePriceDetail");
        addRequestParameter("method", "Save");

        PriceDetailForm priceDetailForm = new PriceDetailForm();
        // set required fields

        request.setAttribute(Constants.PRICEDETAIL_KEY, priceDetailForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/priceDetails");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.PRICEDETAIL_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editPriceDetail");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.PRICEDETAIL_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editPriceDetail");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        PriceDetailForm priceDetailForm = (PriceDetailForm) request.getAttribute(Constants.PRICEDETAIL_KEY);
        assertNotNull(priceDetailForm);

        setRequestPathInfo("/savePriceDetail");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.PRICEDETAIL_KEY, priceDetailForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"priceDetail.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editPriceDetail");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
