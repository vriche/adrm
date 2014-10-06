package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.SysEventTypeForm;

public class SysEventTypeActionTest extends BaseStrutsTestCase {

    public SysEventTypeActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveSysEventType");
        addRequestParameter("method", "Save");

        SysEventTypeForm sysEventTypeForm = new SysEventTypeForm();
        // set required fields

        request.setAttribute(Constants.SYSEVENTTYPE_KEY, sysEventTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/sysEventTypes");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.SYSEVENTTYPE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editSysEventType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.SYSEVENTTYPE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editSysEventType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        SysEventTypeForm sysEventTypeForm = (SysEventTypeForm) request.getAttribute(Constants.SYSEVENTTYPE_KEY);
        assertNotNull(sysEventTypeForm);

        setRequestPathInfo("/saveSysEventType");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.SYSEVENTTYPE_KEY, sysEventTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"sysEventType.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editSysEventType");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
