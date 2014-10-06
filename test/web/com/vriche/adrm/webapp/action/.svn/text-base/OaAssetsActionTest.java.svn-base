package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaAssetsForm;

public class OaAssetsActionTest extends BaseStrutsTestCase {

    public OaAssetsActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaAssets");
        addRequestParameter("method", "Save");

        OaAssetsForm oaAssetsForm = new OaAssetsForm();
        // set required fields

        request.setAttribute(Constants.OAASSETS_KEY, oaAssetsForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaAssetss");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OAASSETS_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaAssets");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OAASSETS_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaAssets");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaAssetsForm oaAssetsForm = (OaAssetsForm) request.getAttribute(Constants.OAASSETS_KEY);
        assertNotNull(oaAssetsForm);

        setRequestPathInfo("/saveOaAssets");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OAASSETS_KEY, oaAssetsForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaAssets.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaAssets");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
