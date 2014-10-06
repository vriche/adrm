package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaTeleExpensesForm;

public class OaTeleExpensesActionTest extends BaseStrutsTestCase {

    public OaTeleExpensesActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaTeleExpenses");
        addRequestParameter("method", "Save");

        OaTeleExpensesForm oaTeleExpensesForm = new OaTeleExpensesForm();
        // set required fields
        oaTeleExpensesForm.setExpenses("1.1153497139025192E308");
        oaTeleExpensesForm.setRegisterDate("1278169959");
        oaTeleExpensesForm.setBranchId("1767637888230205440");

        request.setAttribute(Constants.OATELEEXPENSES_KEY, oaTeleExpensesForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaTeleExpensess");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OATELEEXPENSES_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaTeleExpenses");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OATELEEXPENSES_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaTeleExpenses");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaTeleExpensesForm oaTeleExpensesForm = (OaTeleExpensesForm) request.getAttribute(Constants.OATELEEXPENSES_KEY);
        assertNotNull(oaTeleExpensesForm);

        setRequestPathInfo("/saveOaTeleExpenses");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        oaTeleExpensesForm.setExpenses("1.5610465073717311E308");
        oaTeleExpensesForm.setRegisterDate("1932802556");
        oaTeleExpensesForm.setBranchId("6255071750479006720");

        request.setAttribute(Constants.OATELEEXPENSES_KEY, oaTeleExpensesForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaTeleExpenses.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaTeleExpenses");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
