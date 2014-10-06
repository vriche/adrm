package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.PublishMemoForm;
import com.vriche.adrm.Constants;

public class PublishMemoActionTest extends BaseStrutsTestCase {

    public PublishMemoActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/savePublishMemo");
        addRequestParameter("method", "Save");

        PublishMemoForm publishMemoForm = new PublishMemoForm();
        // set required fields

        request.setAttribute(Constants.PUBLISHMEMO_KEY, publishMemoForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/publishMemos");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.PUBLISHMEMO_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editPublishMemo");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.PUBLISHMEMO_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editPublishMemo");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        PublishMemoForm publishMemoForm = (PublishMemoForm) request.getAttribute(Constants.PUBLISHMEMO_KEY);
        assertNotNull(publishMemoForm);

        setRequestPathInfo("/savePublishMemo");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.PUBLISHMEMO_KEY, publishMemoForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"publishMemo.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editPublishMemo");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
