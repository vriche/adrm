package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaWorkFlowForm;

public class OaWorkFlowActionTest extends BaseStrutsTestCase {

    public OaWorkFlowActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaWorkFlow");
        addRequestParameter("method", "Save");

        OaWorkFlowForm oaWorkFlowForm = new OaWorkFlowForm();
        // set required fields

        request.setAttribute(Constants.OAWORKFLOW_KEY, oaWorkFlowForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaWorkFlows");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OAWORKFLOW_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaWorkFlow");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OAWORKFLOW_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaWorkFlow");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaWorkFlowForm oaWorkFlowForm = (OaWorkFlowForm) request.getAttribute(Constants.OAWORKFLOW_KEY);
        assertNotNull(oaWorkFlowForm);

        setRequestPathInfo("/saveOaWorkFlow");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OAWORKFLOW_KEY, oaWorkFlowForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaWorkFlow.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaWorkFlow");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
