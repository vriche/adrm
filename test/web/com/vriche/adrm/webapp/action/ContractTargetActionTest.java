package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.ContractTargetForm;

public class ContractTargetActionTest extends BaseStrutsTestCase {

    public ContractTargetActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveContractTarget");
        addRequestParameter("method", "Save");

        ContractTargetForm contractTargetForm = new ContractTargetForm();
        // set required fields

        request.setAttribute(Constants.CONTRACTTARGET_KEY, contractTargetForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/contractTargets");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.CONTRACTTARGET_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editContractTarget");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.CONTRACTTARGET_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editContractTarget");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        ContractTargetForm contractTargetForm = (ContractTargetForm) request.getAttribute(Constants.CONTRACTTARGET_KEY);
        assertNotNull(contractTargetForm);

        setRequestPathInfo("/saveContractTarget");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.CONTRACTTARGET_KEY, contractTargetForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"contractTarget.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editContractTarget");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
