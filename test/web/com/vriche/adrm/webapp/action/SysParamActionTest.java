package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.SysParamForm;

public class SysParamActionTest extends BaseStrutsTestCase {

    public SysParamActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveSysParam");
        addRequestParameter("method", "Save");

        SysParamForm sysParamForm = new SysParamForm();
        // set required fields
        sysParamForm.setName("IfEoAaOyWcPsMlWyFsDjXsWjIhPyFeOgPjCaJfStHsUmZlXcKkYzEqXoUvYpTxVyPxJpMjUaQaRtVsFoCrXiVxYwZfXuAxTbQtGyAzInKbMhGtYbIpBzExFjPmBrDhMt");
        sysParamForm.setValue("1216901976");

        request.setAttribute(Constants.SYSPARAM_KEY, sysParamForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/sysParams");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.SYSPARAM_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editSysParam");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.SYSPARAM_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editSysParam");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        SysParamForm sysParamForm = (SysParamForm) request.getAttribute(Constants.SYSPARAM_KEY);
        assertNotNull(sysParamForm);

        setRequestPathInfo("/saveSysParam");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        sysParamForm.setName("WbQnXiXoXvOwXsNsJoYbTnZiRoAiEpMxBkZlWgNlIxCjKnGjMcVoVaStUlYfUzVsJsJeXxLzQgMaHvScFpNnLgMtKiUzTfCzObWpBvSdRiMyAuIaByMwTuYxGjLbKvJj");
        sysParamForm.setValue("2107551386");

        request.setAttribute(Constants.SYSPARAM_KEY, sysParamForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"sysParam.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editSysParam");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
