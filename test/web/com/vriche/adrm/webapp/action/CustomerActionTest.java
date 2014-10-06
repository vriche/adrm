package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.CustomerForm;
import com.vriche.adrm.Constants;

public class CustomerActionTest extends BaseStrutsTestCase {

    public CustomerActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveCustomer");
        addRequestParameter("method", "Save");

        CustomerForm customerForm = new CustomerForm();
        // set required fields
        customerForm.setCustomerName("TsIoMdLdAtRfStSvGjGuNiKjYhXhItWnDfKcEqNuClFpNiIoDqPwYzByXbBwJmGxMvBlBeTsCuTmKjPpEtWhBgFuNvYmGtFrXtVeJeQeVcEmRaXoKrNjEhJuLrReUoVy");
        customerForm.setHelpCode("RjEdVmLmUiEtNiEb");
        customerForm.setParentId("ArLcRwJwYlEjDaIlIeErMbUxKcWxHpYyPdBoAdEzWoVfZzSqUbZpQjSxCwKlAjAoDxTdQgZoCrKzKtHkWnDaZnWyXmCjHdFjZvJgKnMkDzBwSmPpTkFaDiZbAuOaCwJz");

        request.setAttribute(Constants.CUSTOMER_KEY, customerForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/customers");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.CUSTOMER_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editCustomer");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.CUSTOMER_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editCustomer");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        CustomerForm customerForm = (CustomerForm) request.getAttribute(Constants.CUSTOMER_KEY);
        assertNotNull(customerForm);

        setRequestPathInfo("/saveCustomer");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        customerForm.setCustomerName("EnAkDqPkZfUwMfRhFvVrKwOcYqJeHfSdZjEcLkFyErBcCuHvMgWjNzYaRdPjWoGeSuWmVhIdHpRgFmSjYaUiAkIjFaZpYtTqRwLuAsKrJsVhVhOvMuKkRuOdEkEbRmOc");
        customerForm.setHelpCode("QyGnNfWtZaQlJfBo");
        customerForm.setParentId("UqWeEdLzZwBhNrAnGuRjKbBeCcPlZyHaFdSdCrEiYlTqVlYgWvPuMaKxSeQzIoBwKsLhBnBbTfLpLuMbRsTpPlMsHuBmIxNaUiCzFcMhHaSxZbAuUyTvEpXdOwAaLtQn");

        request.setAttribute(Constants.CUSTOMER_KEY, customerForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"customer.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editCustomer");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
