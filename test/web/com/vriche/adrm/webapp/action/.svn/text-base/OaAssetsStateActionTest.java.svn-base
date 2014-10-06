package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaAssetsStateForm;

public class OaAssetsStateActionTest extends BaseStrutsTestCase {

    public OaAssetsStateActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaAssetsState");
        addRequestParameter("method", "Save");

        OaAssetsStateForm oaAssetsStateForm = new OaAssetsStateForm();
        // set required fields

        request.setAttribute(Constants.OAASSETSSTATE_KEY, oaAssetsStateForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaAssetsStates");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OAASSETSSTATE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaAssetsState");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OAASSETSSTATE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaAssetsState");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaAssetsStateForm oaAssetsStateForm = (OaAssetsStateForm) request.getAttribute(Constants.OAASSETSSTATE_KEY);
        assertNotNull(oaAssetsStateForm);

        setRequestPathInfo("/saveOaAssetsState");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OAASSETSSTATE_KEY, oaAssetsStateForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaAssetsState.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaAssetsState");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
