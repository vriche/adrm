package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.CustomerAddressForm;
import com.vriche.adrm.Constants;

public class CustomerAddressActionTest extends BaseStrutsTestCase {

    public CustomerAddressActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveCustomerAddress");
        addRequestParameter("method", "Save");

        CustomerAddressForm customerAddressForm = new CustomerAddressForm();
        // set required fields
        customerAddressForm.setCity("TyAvEoGdOaQyTuLzXaAvFqDwLjYjIuWk");
        customerAddressForm.setPostalCode("KrMiNgHkTcOiHgI");

        request.setAttribute(Constants.CUSTOMERADDRESS_KEY, customerAddressForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/customerAddresss");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.CUSTOMERADDRESS_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editCustomerAddress");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.CUSTOMERADDRESS_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editCustomerAddress");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        CustomerAddressForm customerAddressForm = (CustomerAddressForm) request.getAttribute(Constants.CUSTOMERADDRESS_KEY);
        assertNotNull(customerAddressForm);

        setRequestPathInfo("/saveCustomerAddress");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        customerAddressForm.setCity("OyOpNkQuQcDgFlAbFaErCwSpOfPiRlMp");
        customerAddressForm.setPostalCode("XaZjHcPtYmPlMnO");

        request.setAttribute(Constants.CUSTOMERADDRESS_KEY, customerAddressForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"customerAddress.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editCustomerAddress");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
