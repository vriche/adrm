package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.CustomerTypeForm;
import com.vriche.adrm.Constants;

public class CustomerTypeActionTest extends BaseStrutsTestCase {

    public CustomerTypeActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveCustomerType");
        addRequestParameter("method", "Save");

        CustomerTypeForm customerTypeForm = new CustomerTypeForm();
        // set required fields
        customerTypeForm.setName("JfZoStFaNvImNnYvWtRyRnWiDdXeRpKmViGwJmQnMcIzFtGrKqToUtArRxKtEoGkAjSaQyJsGmNuMzAdBeJsZsAzXoOqJwWdPaUeKpUoMbYxRxYdNjPsExKwXnWpOlWw");

        request.setAttribute(Constants.CUSTOMERTYPE_KEY, customerTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/customerTypes");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.CUSTOMERTYPE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editCustomerType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.CUSTOMERTYPE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editCustomerType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        CustomerTypeForm customerTypeForm = (CustomerTypeForm) request.getAttribute(Constants.CUSTOMERTYPE_KEY);
        assertNotNull(customerTypeForm);

        setRequestPathInfo("/saveCustomerType");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        customerTypeForm.setName("IuGtVmVdVdWgXeNuNuOoAbEnCxNtVgIiYkAtSnCoMrHaEfSfEqDyFbUpVbQjGyAmIjSaIxPmMmKnHtSqSyBaSeEcKsHlBqXgXtFfOaIlKzQzLhDxRyBaPgFlThHdFkSn");

        request.setAttribute(Constants.CUSTOMERTYPE_KEY, customerTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"customerType.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editCustomerType");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
