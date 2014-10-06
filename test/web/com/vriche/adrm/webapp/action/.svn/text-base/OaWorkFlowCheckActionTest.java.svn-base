package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaWorkFlowCheckForm;

public class OaWorkFlowCheckActionTest extends BaseStrutsTestCase {

    public OaWorkFlowCheckActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaWorkFlowCheck");
        addRequestParameter("method", "Save");

        OaWorkFlowCheckForm oaWorkFlowCheckForm = new OaWorkFlowCheckForm();
        // set required fields

        request.setAttribute(Constants.OAWORKFLOWCHECK_KEY, oaWorkFlowCheckForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaWorkFlowChecks");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OAWORKFLOWCHECK_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaWorkFlowCheck");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OAWORKFLOWCHECK_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaWorkFlowCheck");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaWorkFlowCheckForm oaWorkFlowCheckForm = (OaWorkFlowCheckForm) request.getAttribute(Constants.OAWORKFLOWCHECK_KEY);
        assertNotNull(oaWorkFlowCheckForm);

        setRequestPathInfo("/saveOaWorkFlowCheck");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OAWORKFLOWCHECK_KEY, oaWorkFlowCheckForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaWorkFlowCheck.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaWorkFlowCheck");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
