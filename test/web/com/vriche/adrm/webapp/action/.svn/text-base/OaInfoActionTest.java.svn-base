package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaInfoForm;

public class OaInfoActionTest extends BaseStrutsTestCase {

    public OaInfoActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaInfo");
        addRequestParameter("method", "Save");

        OaInfoForm oaInfoForm = new OaInfoForm();
        // set required fields

        request.setAttribute(Constants.OAINFO_KEY, oaInfoForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaInfos");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OAINFO_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaInfo");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OAINFO_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaInfo");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaInfoForm oaInfoForm = (OaInfoForm) request.getAttribute(Constants.OAINFO_KEY);
        assertNotNull(oaInfoForm);

        setRequestPathInfo("/saveOaInfo");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OAINFO_KEY, oaInfoForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaInfo.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaInfo");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
