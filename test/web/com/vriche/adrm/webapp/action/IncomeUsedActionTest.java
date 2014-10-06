package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.IncomeUsedForm;
import com.vriche.adrm.Constants;

public class IncomeUsedActionTest extends BaseStrutsTestCase {

    public IncomeUsedActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveIncomeUsed");
        addRequestParameter("method", "Save");

        IncomeUsedForm incomeUsedForm = new IncomeUsedForm();
        // set required fields

        request.setAttribute(Constants.INCOMEUSED_KEY, incomeUsedForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/incomeUseds");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.INCOMEUSED_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editIncomeUsed");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.INCOMEUSED_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editIncomeUsed");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        IncomeUsedForm incomeUsedForm = (IncomeUsedForm) request.getAttribute(Constants.INCOMEUSED_KEY);
        assertNotNull(incomeUsedForm);

        setRequestPathInfo("/saveIncomeUsed");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.INCOMEUSED_KEY, incomeUsedForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"incomeUsed.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editIncomeUsed");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
