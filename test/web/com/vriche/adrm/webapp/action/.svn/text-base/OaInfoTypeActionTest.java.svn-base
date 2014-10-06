package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaInfoTypeForm;

public class OaInfoTypeActionTest extends BaseStrutsTestCase {

    public OaInfoTypeActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaInfoType");
        addRequestParameter("method", "Save");

        OaInfoTypeForm oaInfoTypeForm = new OaInfoTypeForm();
        // set required fields

        request.setAttribute(Constants.OAINFOTYPE_KEY, oaInfoTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaInfoTypes");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OAINFOTYPE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaInfoType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OAINFOTYPE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaInfoType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaInfoTypeForm oaInfoTypeForm = (OaInfoTypeForm) request.getAttribute(Constants.OAINFOTYPE_KEY);
        assertNotNull(oaInfoTypeForm);

        setRequestPathInfo("/saveOaInfoType");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OAINFOTYPE_KEY, oaInfoTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaInfoType.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaInfoType");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
