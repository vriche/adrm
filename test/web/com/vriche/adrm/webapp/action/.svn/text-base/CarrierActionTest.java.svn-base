package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.CarrierForm;
import com.vriche.adrm.Constants;

public class CarrierActionTest extends BaseStrutsTestCase {

    public CarrierActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveCarrier");
        addRequestParameter("method", "Save");

        CarrierForm carrierForm = new CarrierForm();
        // set required fields
        carrierForm.setCarrierName("OxYuVdKmBcIpLhIeYoJuOyGuVfUhXsKyHqOdIxWyWbOqBiFyVrYqRhDwUmWgJgOzEgNgQbOkUqOfImYjGkAnEpPdTfEoGgXgUhEfCjDnVqOtRhAzFuHrUgNbYjPqDhYz");

        request.setAttribute(Constants.CARRIER_KEY, carrierForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/carriers");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.CARRIER_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editCarrier");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.CARRIER_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editCarrier");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        CarrierForm carrierForm = (CarrierForm) request.getAttribute(Constants.CARRIER_KEY);
        assertNotNull(carrierForm);

        setRequestPathInfo("/saveCarrier");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        carrierForm.setCarrierName("UqAqCuRyXaAqVgEdMrMpDlChYlAzCeMmAbLsHgPeFxAoVrCcLcUbHuVbYxIvIsAwExKoDnAgFlWbKgRdIpCoEnDpFvVqWjKzOiUnKlGcOmEeGdGaMxZsOsQaYaOgWrUh");

        request.setAttribute(Constants.CARRIER_KEY, carrierForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"carrier.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editCarrier");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
