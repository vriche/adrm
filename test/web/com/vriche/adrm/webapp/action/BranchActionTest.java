package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.BranchForm;

public class BranchActionTest extends BaseStrutsTestCase {

    public BranchActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveBranch");
        addRequestParameter("method", "Save");

        BranchForm branchForm = new BranchForm();
        // set required fields
        branchForm.setName("OxFfNcNjJdGfBdEnJdMxZaVgFtLpSvNo");
        branchForm.setDisplayNo("1953586866");

        request.setAttribute(Constants.BRANCH_KEY, branchForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/branchs");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.BRANCH_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editBranch");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.BRANCH_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editBranch");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        BranchForm branchForm = (BranchForm) request.getAttribute(Constants.BRANCH_KEY);
        assertNotNull(branchForm);

        setRequestPathInfo("/saveBranch");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        branchForm.setName("NzEzRpMzTzMbVuXsUgSyVwSwMoZxCgSt");
        branchForm.setDisplayNo("1206405300");

        request.setAttribute(Constants.BRANCH_KEY, branchForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"branch.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editBranch");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
