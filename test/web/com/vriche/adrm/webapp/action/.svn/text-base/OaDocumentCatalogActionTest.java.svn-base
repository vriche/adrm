package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaDocumentCatalogForm;

public class OaDocumentCatalogActionTest extends BaseStrutsTestCase {

    public OaDocumentCatalogActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaDocumentCatalog");
        addRequestParameter("method", "Save");

        OaDocumentCatalogForm oaDocumentCatalogForm = new OaDocumentCatalogForm();
        // set required fields

        request.setAttribute(Constants.OADOCUMENTCATALOG_KEY, oaDocumentCatalogForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaDocumentCatalogs");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OADOCUMENTCATALOG_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaDocumentCatalog");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OADOCUMENTCATALOG_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaDocumentCatalog");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaDocumentCatalogForm oaDocumentCatalogForm = (OaDocumentCatalogForm) request.getAttribute(Constants.OADOCUMENTCATALOG_KEY);
        assertNotNull(oaDocumentCatalogForm);

        setRequestPathInfo("/saveOaDocumentCatalog");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OADOCUMENTCATALOG_KEY, oaDocumentCatalogForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaDocumentCatalog.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaDocumentCatalog");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
