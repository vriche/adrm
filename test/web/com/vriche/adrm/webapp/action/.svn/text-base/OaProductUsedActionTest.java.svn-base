package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaProductUsedForm;

public class OaProductUsedActionTest extends BaseStrutsTestCase {

    public OaProductUsedActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaProductUsed");
        addRequestParameter("method", "Save");

        OaProductUsedForm oaProductUsedForm = new OaProductUsedForm();
        // set required fields

        request.setAttribute(Constants.OAPRODUCTUSED_KEY, oaProductUsedForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaProductUseds");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OAPRODUCTUSED_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaProductUsed");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OAPRODUCTUSED_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaProductUsed");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaProductUsedForm oaProductUsedForm = (OaProductUsedForm) request.getAttribute(Constants.OAPRODUCTUSED_KEY);
        assertNotNull(oaProductUsedForm);

        setRequestPathInfo("/saveOaProductUsed");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OAPRODUCTUSED_KEY, oaProductUsedForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaProductUsed.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaProductUsed");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
