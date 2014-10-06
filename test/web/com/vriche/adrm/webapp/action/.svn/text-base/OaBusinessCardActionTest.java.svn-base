package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaBusinessCardForm;

public class OaBusinessCardActionTest extends BaseStrutsTestCase {

    public OaBusinessCardActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaBusinessCard");
        addRequestParameter("method", "Save");

        OaBusinessCardForm oaBusinessCardForm = new OaBusinessCardForm();
        // set required fields

        request.setAttribute(Constants.OABUSINESSCARD_KEY, oaBusinessCardForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaBusinessCards");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OABUSINESSCARD_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaBusinessCard");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OABUSINESSCARD_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaBusinessCard");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaBusinessCardForm oaBusinessCardForm = (OaBusinessCardForm) request.getAttribute(Constants.OABUSINESSCARD_KEY);
        assertNotNull(oaBusinessCardForm);

        setRequestPathInfo("/saveOaBusinessCard");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OABUSINESSCARD_KEY, oaBusinessCardForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaBusinessCard.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaBusinessCard");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
