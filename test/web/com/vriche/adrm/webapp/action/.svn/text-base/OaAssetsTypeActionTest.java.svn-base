package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaAssetsTypeForm;

public class OaAssetsTypeActionTest extends BaseStrutsTestCase {

    public OaAssetsTypeActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaAssetsType");
        addRequestParameter("method", "Save");

        OaAssetsTypeForm oaAssetsTypeForm = new OaAssetsTypeForm();
        // set required fields

        request.setAttribute(Constants.OAASSETSTYPE_KEY, oaAssetsTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaAssetsTypes");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OAASSETSTYPE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaAssetsType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OAASSETSTYPE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaAssetsType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaAssetsTypeForm oaAssetsTypeForm = (OaAssetsTypeForm) request.getAttribute(Constants.OAASSETSTYPE_KEY);
        assertNotNull(oaAssetsTypeForm);

        setRequestPathInfo("/saveOaAssetsType");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OAASSETSTYPE_KEY, oaAssetsTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaAssetsType.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaAssetsType");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
