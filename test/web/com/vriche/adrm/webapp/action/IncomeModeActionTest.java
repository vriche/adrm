package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.IncomeModeForm;
import com.vriche.adrm.Constants;

public class IncomeModeActionTest extends BaseStrutsTestCase {

    public IncomeModeActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveIncomeMode");
        addRequestParameter("method", "Save");

        IncomeModeForm incomeModeForm = new IncomeModeForm();
        // set required fields

        request.setAttribute(Constants.INCOMEMODE_KEY, incomeModeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/incomeModes");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.INCOMEMODE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editIncomeMode");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.INCOMEMODE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editIncomeMode");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        IncomeModeForm incomeModeForm = (IncomeModeForm) request.getAttribute(Constants.INCOMEMODE_KEY);
        assertNotNull(incomeModeForm);

        setRequestPathInfo("/saveIncomeMode");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.INCOMEMODE_KEY, incomeModeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"incomeMode.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editIncomeMode");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
