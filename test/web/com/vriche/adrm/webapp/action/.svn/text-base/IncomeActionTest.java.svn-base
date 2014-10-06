package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.IncomeForm;
import com.vriche.adrm.Constants;

public class IncomeActionTest extends BaseStrutsTestCase {

    public IncomeActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveIncome");
        addRequestParameter("method", "Save");

        IncomeForm incomeForm = new IncomeForm();
        // set required fields

        request.setAttribute(Constants.INCOME_KEY, incomeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/incomes");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.INCOME_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editIncome");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.INCOME_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editIncome");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        IncomeForm incomeForm = (IncomeForm) request.getAttribute(Constants.INCOME_KEY);
        assertNotNull(incomeForm);

        setRequestPathInfo("/saveIncome");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.INCOME_KEY, incomeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"income.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editIncome");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
