package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.MediaOrgForm;
import com.vriche.adrm.Constants;

public class MediaOrgActionTest extends BaseStrutsTestCase {

    public MediaOrgActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveMediaOrg");
        addRequestParameter("method", "Save");

        MediaOrgForm mediaOrgForm = new MediaOrgForm();
        // set required fields

        request.setAttribute(Constants.MEDIAORG_KEY, mediaOrgForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/mediaOrgs");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.MEDIAORG_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editMediaOrg");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.MEDIAORG_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editMediaOrg");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        MediaOrgForm mediaOrgForm = (MediaOrgForm) request.getAttribute(Constants.MEDIAORG_KEY);
        assertNotNull(mediaOrgForm);

        setRequestPathInfo("/saveMediaOrg");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.MEDIAORG_KEY, mediaOrgForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"mediaOrg.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editMediaOrg");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
