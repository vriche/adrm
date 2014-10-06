package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.PublishedInfoForm;
import com.vriche.adrm.Constants;

public class PublishedInfoActionTest extends BaseStrutsTestCase {

    public PublishedInfoActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/savePublishedInfo");
        addRequestParameter("method", "Save");

        PublishedInfoForm publishedInfoForm = new PublishedInfoForm();
        // set required fields

        request.setAttribute(Constants.PUBLISHEDINFO_KEY, publishedInfoForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/publishedInfos");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.PUBLISHEDINFO_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editPublishedInfo");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.PUBLISHEDINFO_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editPublishedInfo");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        PublishedInfoForm publishedInfoForm = (PublishedInfoForm) request.getAttribute(Constants.PUBLISHEDINFO_KEY);
        assertNotNull(publishedInfoForm);

        setRequestPathInfo("/savePublishedInfo");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.PUBLISHEDINFO_KEY, publishedInfoForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"publishedInfo.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editPublishedInfo");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
