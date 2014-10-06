package com.vriche.adrm.webapp.action;

import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.ContractPaymentForm;

public class ContractPaymentActionTest extends BaseStrutsTestCase {

    public ContractPaymentActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveContractPayment");
        addRequestParameter("method", "Save");

        ContractPaymentForm contractPaymentForm = new ContractPaymentForm();
        // set required fields

        request.setAttribute(Constants.CONTRACTPAYMENT_KEY, contractPaymentForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/contractPayments");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.CONTRACTPAYMENT_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editContractPayment");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.CONTRACTPAYMENT_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editContractPayment");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        ContractPaymentForm contractPaymentForm = (ContractPaymentForm) request.getAttribute(Constants.CONTRACTPAYMENT_KEY);
        assertNotNull(contractPaymentForm);

        setRequestPathInfo("/saveContractPayment");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.CONTRACTPAYMENT_KEY, contractPaymentForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"contractPayment.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editContractPayment");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
