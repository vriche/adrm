package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaDocumentCatalogPermitTypeForm;

public class OaDocumentCatalogPermitTypeActionTest extends BaseStrutsTestCase {

    public OaDocumentCatalogPermitTypeActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaDocumentCatalogPermitType");
        addRequestParameter("method", "Save");

        OaDocumentCatalogPermitTypeForm oaDocumentCatalogPermitTypeForm = new OaDocumentCatalogPermitTypeForm();
        // set required fields

        request.setAttribute(Constants.OADOCUMENTCATALOGPERMITTYPE_KEY, oaDocumentCatalogPermitTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaDocumentCatalogPermitTypes");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OADOCUMENTCATALOGPERMITTYPE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaDocumentCatalogPermitType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OADOCUMENTCATALOGPERMITTYPE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaDocumentCatalogPermitType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaDocumentCatalogPermitTypeForm oaDocumentCatalogPermitTypeForm = (OaDocumentCatalogPermitTypeForm) request.getAttribute(Constants.OADOCUMENTCATALOGPERMITTYPE_KEY);
        assertNotNull(oaDocumentCatalogPermitTypeForm);

        setRequestPathInfo("/saveOaDocumentCatalogPermitType");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OADOCUMENTCATALOGPERMITTYPE_KEY, oaDocumentCatalogPermitTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaDocumentCatalogPermitType.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaDocumentCatalogPermitType");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
