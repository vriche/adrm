package com.vriche.adrm.webapp.action;

import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.ContractForm;

public class ContractActionTest extends BaseStrutsTestCase {

    public ContractActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveContract");
        addRequestParameter("method", "Save");

        ContractForm contractForm = new ContractForm();
        // set required fields

        request.setAttribute(Constants.CONTRACT_KEY, contractForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/contracts");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.CONTRACT_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editContract");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.CONTRACT_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editContract");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        ContractForm contractForm = (ContractForm) request.getAttribute(Constants.CONTRACT_KEY);
        assertNotNull(contractForm);

        setRequestPathInfo("/saveContract");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.CONTRACT_KEY, contractForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"contract.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editContract");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
