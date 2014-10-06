package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaApplyInfoForm;

public class OaApplyInfoActionTest extends BaseStrutsTestCase {

    public OaApplyInfoActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaApplyInfo");
        addRequestParameter("method", "Save");

        OaApplyInfoForm oaApplyInfoForm = new OaApplyInfoForm();
        // set required fields

        request.setAttribute(Constants.OAAPPLYINFO_KEY, oaApplyInfoForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaApplyInfos");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OAAPPLYINFO_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaApplyInfo");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OAAPPLYINFO_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaApplyInfo");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaApplyInfoForm oaApplyInfoForm = (OaApplyInfoForm) request.getAttribute(Constants.OAAPPLYINFO_KEY);
        assertNotNull(oaApplyInfoForm);

        setRequestPathInfo("/saveOaApplyInfo");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OAAPPLYINFO_KEY, oaApplyInfoForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaApplyInfo.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaApplyInfo");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
