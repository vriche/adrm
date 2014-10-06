package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.SysUserTypeForm;

public class SysUserTypeActionTest extends BaseStrutsTestCase {

    public SysUserTypeActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveSysUserType");
        addRequestParameter("method", "Save");

        SysUserTypeForm sysUserTypeForm = new SysUserTypeForm();
        // set required fields

        request.setAttribute(Constants.SYSUSERTYPE_KEY, sysUserTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/sysUserTypes");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.SYSUSERTYPE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editSysUserType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.SYSUSERTYPE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editSysUserType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        SysUserTypeForm sysUserTypeForm = (SysUserTypeForm) request.getAttribute(Constants.SYSUSERTYPE_KEY);
        assertNotNull(sysUserTypeForm);

        setRequestPathInfo("/saveSysUserType");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.SYSUSERTYPE_KEY, sysUserTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"sysUserType.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editSysUserType");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
