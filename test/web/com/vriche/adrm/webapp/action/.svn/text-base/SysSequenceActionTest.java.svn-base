package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.SysSequenceForm;

public class SysSequenceActionTest extends BaseStrutsTestCase {

    public SysSequenceActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveSysSequence");
        addRequestParameter("method", "Save");

        SysSequenceForm sysSequenceForm = new SysSequenceForm();
        // set required fields
        sysSequenceForm.setId("4");

        request.setAttribute(Constants.SYSSEQUENCE_KEY, sysSequenceForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/sysSequences");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.SYSSEQUENCE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editSysSequence");
        addRequestParameter("method", "Edit");
        addRequestParameter("sequenceID", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.SYSSEQUENCE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editSysSequence");
        addRequestParameter("method", "Edit");
        addRequestParameter("sequenceID", "1");

        actionPerform();

        SysSequenceForm sysSequenceForm = (SysSequenceForm) request.getAttribute(Constants.SYSSEQUENCE_KEY);
        assertNotNull(sysSequenceForm);

        setRequestPathInfo("/saveSysSequence");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.SYSSEQUENCE_KEY, sysSequenceForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"sysSequence.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editSysSequence");
        addRequestParameter("method", "Delete");
        addRequestParameter("sequenceID", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
