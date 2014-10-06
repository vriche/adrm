package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaDocumentForm;

public class OaDocumentActionTest extends BaseStrutsTestCase {

    public OaDocumentActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaDocument");
        addRequestParameter("method", "Save");

        OaDocumentForm oaDocumentForm = new OaDocumentForm();
        // set required fields

        request.setAttribute(Constants.OADOCUMENT_KEY, oaDocumentForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaDocuments");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OADOCUMENT_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaDocument");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OADOCUMENT_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaDocument");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaDocumentForm oaDocumentForm = (OaDocumentForm) request.getAttribute(Constants.OADOCUMENT_KEY);
        assertNotNull(oaDocumentForm);

        setRequestPathInfo("/saveOaDocument");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OADOCUMENT_KEY, oaDocumentForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaDocument.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaDocument");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
