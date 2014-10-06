package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaProductTypeForm;

public class OaProductTypeActionTest extends BaseStrutsTestCase {

    public OaProductTypeActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaProductType");
        addRequestParameter("method", "Save");

        OaProductTypeForm oaProductTypeForm = new OaProductTypeForm();
        // set required fields

        request.setAttribute(Constants.OAPRODUCTTYPE_KEY, oaProductTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaProductTypes");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OAPRODUCTTYPE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaProductType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OAPRODUCTTYPE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaProductType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaProductTypeForm oaProductTypeForm = (OaProductTypeForm) request.getAttribute(Constants.OAPRODUCTTYPE_KEY);
        assertNotNull(oaProductTypeForm);

        setRequestPathInfo("/saveOaProductType");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OAPRODUCTTYPE_KEY, oaProductTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaProductType.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaProductType");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
