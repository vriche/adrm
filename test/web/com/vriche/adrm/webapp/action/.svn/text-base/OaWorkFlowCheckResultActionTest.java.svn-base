package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaWorkFlowCheckResultForm;

public class OaWorkFlowCheckResultActionTest extends BaseStrutsTestCase {

    public OaWorkFlowCheckResultActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaWorkFlowCheckResult");
        addRequestParameter("method", "Save");

        OaWorkFlowCheckResultForm oaWorkFlowCheckResultForm = new OaWorkFlowCheckResultForm();
        // set required fields

        request.setAttribute(Constants.OAWORKFLOWCHECKRESULT_KEY, oaWorkFlowCheckResultForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaWorkFlowCheckResults");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OAWORKFLOWCHECKRESULT_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaWorkFlowCheckResult");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OAWORKFLOWCHECKRESULT_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaWorkFlowCheckResult");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaWorkFlowCheckResultForm oaWorkFlowCheckResultForm = (OaWorkFlowCheckResultForm) request.getAttribute(Constants.OAWORKFLOWCHECKRESULT_KEY);
        assertNotNull(oaWorkFlowCheckResultForm);

        setRequestPathInfo("/saveOaWorkFlowCheckResult");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OAWORKFLOWCHECKRESULT_KEY, oaWorkFlowCheckResultForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaWorkFlowCheckResult.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaWorkFlowCheckResult");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
