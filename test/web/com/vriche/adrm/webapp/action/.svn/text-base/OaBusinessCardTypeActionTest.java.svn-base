package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaBusinessCardTypeForm;

public class OaBusinessCardTypeActionTest extends BaseStrutsTestCase {

    public OaBusinessCardTypeActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaBusinessCardType");
        addRequestParameter("method", "Save");

        OaBusinessCardTypeForm oaBusinessCardTypeForm = new OaBusinessCardTypeForm();
        // set required fields

        request.setAttribute(Constants.OABUSINESSCARDTYPE_KEY, oaBusinessCardTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaBusinessCardTypes");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OABUSINESSCARDTYPE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaBusinessCardType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OABUSINESSCARDTYPE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaBusinessCardType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaBusinessCardTypeForm oaBusinessCardTypeForm = (OaBusinessCardTypeForm) request.getAttribute(Constants.OABUSINESSCARDTYPE_KEY);
        assertNotNull(oaBusinessCardTypeForm);

        setRequestPathInfo("/saveOaBusinessCardType");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OABUSINESSCARDTYPE_KEY, oaBusinessCardTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaBusinessCardType.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaBusinessCardType");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
