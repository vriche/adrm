package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.IncomePullForm;
import com.vriche.adrm.Constants;

public class IncomePullActionTest extends BaseStrutsTestCase {

    public IncomePullActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveIncomePull");
        addRequestParameter("method", "Save");

        IncomePullForm incomePullForm = new IncomePullForm();
        // set required fields

        request.setAttribute(Constants.INCOMEPULL_KEY, incomePullForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/incomePulls");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.INCOMEPULL_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editIncomePull");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.INCOMEPULL_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editIncomePull");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        IncomePullForm incomePullForm = (IncomePullForm) request.getAttribute(Constants.INCOMEPULL_KEY);
        assertNotNull(incomePullForm);

        setRequestPathInfo("/saveIncomePull");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.INCOMEPULL_KEY, incomePullForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"incomePull.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editIncomePull");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
