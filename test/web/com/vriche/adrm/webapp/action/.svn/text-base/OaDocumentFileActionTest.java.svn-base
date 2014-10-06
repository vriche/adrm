package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaDocumentFileForm;

public class OaDocumentFileActionTest extends BaseStrutsTestCase {

    public OaDocumentFileActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaDocumentFile");
        addRequestParameter("method", "Save");

        OaDocumentFileForm oaDocumentFileForm = new OaDocumentFileForm();
        // set required fields

        request.setAttribute(Constants.OADOCUMENTFILE_KEY, oaDocumentFileForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaDocumentFiles");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OADOCUMENTFILE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaDocumentFile");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OADOCUMENTFILE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaDocumentFile");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaDocumentFileForm oaDocumentFileForm = (OaDocumentFileForm) request.getAttribute(Constants.OADOCUMENTFILE_KEY);
        assertNotNull(oaDocumentFileForm);

        setRequestPathInfo("/saveOaDocumentFile");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OADOCUMENTFILE_KEY, oaDocumentFileForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaDocumentFile.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaDocumentFile");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
