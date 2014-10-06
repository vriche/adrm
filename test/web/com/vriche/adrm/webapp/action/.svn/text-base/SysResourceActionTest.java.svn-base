package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.SysResourceForm;

public class SysResourceActionTest extends BaseStrutsTestCase {

    public SysResourceActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveSysResource");
        addRequestParameter("method", "Save");

        SysResourceForm sysResourceForm = new SysResourceForm();
        // set required fields

        request.setAttribute(Constants.SYSRESOURCE_KEY, sysResourceForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/sysResources");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.SYSRESOURCE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editSysResource");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.SYSRESOURCE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editSysResource");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        SysResourceForm sysResourceForm = (SysResourceForm) request.getAttribute(Constants.SYSRESOURCE_KEY);
        assertNotNull(sysResourceForm);

        setRequestPathInfo("/saveSysResource");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.SYSRESOURCE_KEY, sysResourceForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"sysResource.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editSysResource");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
