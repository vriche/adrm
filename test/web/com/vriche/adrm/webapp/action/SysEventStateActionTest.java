package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.SysEventStateForm;

public class SysEventStateActionTest extends BaseStrutsTestCase {

    public SysEventStateActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveSysEventState");
        addRequestParameter("method", "Save");

        SysEventStateForm sysEventStateForm = new SysEventStateForm();
        // set required fields

        request.setAttribute(Constants.SYSEVENTSTATE_KEY, sysEventStateForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/sysEventStates");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.SYSEVENTSTATE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editSysEventState");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.SYSEVENTSTATE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editSysEventState");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        SysEventStateForm sysEventStateForm = (SysEventStateForm) request.getAttribute(Constants.SYSEVENTSTATE_KEY);
        assertNotNull(sysEventStateForm);

        setRequestPathInfo("/saveSysEventState");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.SYSEVENTSTATE_KEY, sysEventStateForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"sysEventState.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editSysEventState");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
