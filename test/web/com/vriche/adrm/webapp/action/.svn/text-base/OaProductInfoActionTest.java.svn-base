package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaProductInfoForm;

public class OaProductInfoActionTest extends BaseStrutsTestCase {

    public OaProductInfoActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaProductInfo");
        addRequestParameter("method", "Save");

        OaProductInfoForm oaProductInfoForm = new OaProductInfoForm();
        // set required fields

        request.setAttribute(Constants.OAPRODUCTINFO_KEY, oaProductInfoForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaProductInfos");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OAPRODUCTINFO_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaProductInfo");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OAPRODUCTINFO_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaProductInfo");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaProductInfoForm oaProductInfoForm = (OaProductInfoForm) request.getAttribute(Constants.OAPRODUCTINFO_KEY);
        assertNotNull(oaProductInfoForm);

        setRequestPathInfo("/saveOaProductInfo");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OAPRODUCTINFO_KEY, oaProductInfoForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaProductInfo.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaProductInfo");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
