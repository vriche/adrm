package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.CarrierTypeForm;
import com.vriche.adrm.Constants;

public class CarrierTypeActionTest extends BaseStrutsTestCase {

    public CarrierTypeActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveCarrierType");
        addRequestParameter("method", "Save");

        CarrierTypeForm carrierTypeForm = new CarrierTypeForm();
        // set required fields
        carrierTypeForm.setName("VoSeSsZbDrYjOjSkLbTqRnSiWaKbNpCtBeYjByCiQcEwBnSkOiLpNlKxHqCfLgFjBaVkNmZnVzVaExXcGfBfYvUdLxGvZcReKoCxXlAkWcQoZtEtZcOcXhWrAnTwItIn");

        request.setAttribute(Constants.CARRIERTYPE_KEY, carrierTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/carrierTypes");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.CARRIERTYPE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editCarrierType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.CARRIERTYPE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editCarrierType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        CarrierTypeForm carrierTypeForm = (CarrierTypeForm) request.getAttribute(Constants.CARRIERTYPE_KEY);
        assertNotNull(carrierTypeForm);

        setRequestPathInfo("/saveCarrierType");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        carrierTypeForm.setName("QrFfVvBgCrDlIpCxCxLjReSlRpLoHzOvItMlZzBxPzFtGmEdNtQaVkAyTvFsWgFeLwJwTdFwRiTmZkXwRuIzGxPgWgEoMyHuBfDdZfGrBmLhWyRxZfHiSbHzHfEqVoHc");

        request.setAttribute(Constants.CARRIERTYPE_KEY, carrierTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"carrierType.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editCarrierType");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
