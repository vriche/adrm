package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaAreaPcForm;

public class OaAreaPcActionTest extends BaseStrutsTestCase {

    public OaAreaPcActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaAreaPc");
        addRequestParameter("method", "Save");

        OaAreaPcForm oaAreaPcForm = new OaAreaPcForm();
        // set required fields

        request.setAttribute(Constants.OAAREAPC_KEY, oaAreaPcForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaAreaPcs");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OAAREAPC_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaAreaPc");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OAAREAPC_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaAreaPc");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaAreaPcForm oaAreaPcForm = (OaAreaPcForm) request.getAttribute(Constants.OAAREAPC_KEY);
        assertNotNull(oaAreaPcForm);

        setRequestPathInfo("/saveOaAreaPc");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OAAREAPC_KEY, oaAreaPcForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaAreaPc.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaAreaPc");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
