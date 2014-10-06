package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.MatterTypeForm;

public class MatterTypeActionTest extends BaseStrutsTestCase {

    public MatterTypeActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveMatterType");
        addRequestParameter("method", "Save");

        MatterTypeForm matterTypeForm = new MatterTypeForm();
        // set required fields

        request.setAttribute(Constants.MATTERTYPE_KEY, matterTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/matterTypes");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.MATTERTYPE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editMatterType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.MATTERTYPE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editMatterType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        MatterTypeForm matterTypeForm = (MatterTypeForm) request.getAttribute(Constants.MATTERTYPE_KEY);
        assertNotNull(matterTypeForm);

        setRequestPathInfo("/saveMatterType");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.MATTERTYPE_KEY, matterTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"matterType.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editMatterType");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
