package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.FinanceTargetForm;

public class FinanceTargetActionTest extends BaseStrutsTestCase {

    public FinanceTargetActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveFinanceTarget");
        addRequestParameter("method", "Save");

        FinanceTargetForm financeTargetForm = new FinanceTargetForm();
        // set required fields
        financeTargetForm.setTargetDateYear("25973663");
        financeTargetForm.setTargetDateMonth("90240460");
        financeTargetForm.setTargetMoney("3.165971225345595E307");

        request.setAttribute(Constants.FINANCETARGET_KEY, financeTargetForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/financeTargets");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.FINANCETARGET_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editFinanceTarget");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.FINANCETARGET_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editFinanceTarget");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        FinanceTargetForm financeTargetForm = (FinanceTargetForm) request.getAttribute(Constants.FINANCETARGET_KEY);
        assertNotNull(financeTargetForm);

        setRequestPathInfo("/saveFinanceTarget");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        financeTargetForm.setTargetDateYear("349605893");
        financeTargetForm.setTargetDateMonth("2004561332");
        financeTargetForm.setTargetMoney("8.729702804580084E306");

        request.setAttribute(Constants.FINANCETARGET_KEY, financeTargetForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"financeTarget.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editFinanceTarget");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
