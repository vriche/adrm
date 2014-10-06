package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.WorkspanForm;
import com.vriche.adrm.Constants;

public class WorkspanActionTest extends BaseStrutsTestCase {

    public WorkspanActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveWorkspan");
        addRequestParameter("method", "Save");

        WorkspanForm workspanForm = new WorkspanForm();
        // set required fields

        request.setAttribute(Constants.WORKSPAN_KEY, workspanForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/workspans");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.WORKSPAN_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editWorkspan");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.WORKSPAN_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editWorkspan");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        WorkspanForm workspanForm = (WorkspanForm) request.getAttribute(Constants.WORKSPAN_KEY);
        assertNotNull(workspanForm);

        setRequestPathInfo("/saveWorkspan");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.WORKSPAN_KEY, workspanForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"workspan.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editWorkspan");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
