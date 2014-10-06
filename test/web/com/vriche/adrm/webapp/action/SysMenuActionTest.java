package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.SysMenuForm;

public class SysMenuActionTest extends BaseStrutsTestCase {

    public SysMenuActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveSysMenu");
        addRequestParameter("method", "Save");

        SysMenuForm sysMenuForm = new SysMenuForm();
        // set required fields
        sysMenuForm.setName("IvSdXqJqZiRpSxIyUfJvEoEvKbFhOjDy");
        sysMenuForm.setDisplayNo("1734507236");

        request.setAttribute(Constants.SYSMENU_KEY, sysMenuForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/sysMenus");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.SYSMENU_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editSysMenu");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.SYSMENU_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editSysMenu");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        SysMenuForm sysMenuForm = (SysMenuForm) request.getAttribute(Constants.SYSMENU_KEY);
        assertNotNull(sysMenuForm);

        setRequestPathInfo("/saveSysMenu");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        sysMenuForm.setName("SvJgNaSeWtWlNwMpGzZwTeRuQsGrPeMv");
        sysMenuForm.setDisplayNo("1747057335");

        request.setAttribute(Constants.SYSMENU_KEY, sysMenuForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"sysMenu.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editSysMenu");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
