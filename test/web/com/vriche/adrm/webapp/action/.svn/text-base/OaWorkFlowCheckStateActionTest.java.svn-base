package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaWorkFlowCheckStateForm;

public class OaWorkFlowCheckStateActionTest extends BaseStrutsTestCase {

    public OaWorkFlowCheckStateActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaWorkFlowCheckState");
        addRequestParameter("method", "Save");

        OaWorkFlowCheckStateForm oaWorkFlowCheckStateForm = new OaWorkFlowCheckStateForm();
        // set required fields

        request.setAttribute(Constants.OAWORKFLOWCHECKSTATE_KEY, oaWorkFlowCheckStateForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaWorkFlowCheckStates");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OAWORKFLOWCHECKSTATE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaWorkFlowCheckState");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OAWORKFLOWCHECKSTATE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaWorkFlowCheckState");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaWorkFlowCheckStateForm oaWorkFlowCheckStateForm = (OaWorkFlowCheckStateForm) request.getAttribute(Constants.OAWORKFLOWCHECKSTATE_KEY);
        assertNotNull(oaWorkFlowCheckStateForm);

        setRequestPathInfo("/saveOaWorkFlowCheckState");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OAWORKFLOWCHECKSTATE_KEY, oaWorkFlowCheckStateForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaWorkFlowCheckState.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaWorkFlowCheckState");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
