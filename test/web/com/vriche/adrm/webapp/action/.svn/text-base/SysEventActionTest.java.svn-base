package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.SysEventForm;

public class SysEventActionTest extends BaseStrutsTestCase {

    public SysEventActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveSysEvent");
        addRequestParameter("method", "Save");

        SysEventForm sysEventForm = new SysEventForm();
        // set required fields

        request.setAttribute(Constants.SYSEVENT_KEY, sysEventForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/sysEvents");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.SYSEVENT_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editSysEvent");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.SYSEVENT_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editSysEvent");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        SysEventForm sysEventForm = (SysEventForm) request.getAttribute(Constants.SYSEVENT_KEY);
        assertNotNull(sysEventForm);

        setRequestPathInfo("/saveSysEvent");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.SYSEVENT_KEY, sysEventForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"sysEvent.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editSysEvent");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
