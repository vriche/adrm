package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.SysPromptModeForm;

public class SysPromptModeActionTest extends BaseStrutsTestCase {

    public SysPromptModeActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveSysPromptMode");
        addRequestParameter("method", "Save");

        SysPromptModeForm sysPromptModeForm = new SysPromptModeForm();
        // set required fields

        request.setAttribute(Constants.SYSPROMPTMODE_KEY, sysPromptModeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/sysPromptModes");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.SYSPROMPTMODE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editSysPromptMode");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.SYSPROMPTMODE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editSysPromptMode");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        SysPromptModeForm sysPromptModeForm = (SysPromptModeForm) request.getAttribute(Constants.SYSPROMPTMODE_KEY);
        assertNotNull(sysPromptModeForm);

        setRequestPathInfo("/saveSysPromptMode");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.SYSPROMPTMODE_KEY, sysPromptModeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"sysPromptMode.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editSysPromptMode");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
