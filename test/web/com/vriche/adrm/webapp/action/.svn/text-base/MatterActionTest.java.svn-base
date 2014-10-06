package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.MatterForm;
import com.vriche.adrm.Constants;

public class MatterActionTest extends BaseStrutsTestCase {

    public MatterActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveMatter");
        addRequestParameter("method", "Save");

        MatterForm matterForm = new MatterForm();
        // set required fields

        request.setAttribute(Constants.MATTER_KEY, matterForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/matters");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.MATTER_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editMatter");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.MATTER_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editMatter");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        MatterForm matterForm = (MatterForm) request.getAttribute(Constants.MATTER_KEY);
        assertNotNull(matterForm);

        setRequestPathInfo("/saveMatter");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.MATTER_KEY, matterForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"matter.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editMatter");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
