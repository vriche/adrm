package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaWorkFlowTypeForm;

public class OaWorkFlowTypeActionTest extends BaseStrutsTestCase {

    public OaWorkFlowTypeActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaWorkFlowType");
        addRequestParameter("method", "Save");

        OaWorkFlowTypeForm oaWorkFlowTypeForm = new OaWorkFlowTypeForm();
        // set required fields

        request.setAttribute(Constants.OAWORKFLOWTYPE_KEY, oaWorkFlowTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaWorkFlowTypes");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OAWORKFLOWTYPE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaWorkFlowType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OAWORKFLOWTYPE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaWorkFlowType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaWorkFlowTypeForm oaWorkFlowTypeForm = (OaWorkFlowTypeForm) request.getAttribute(Constants.OAWORKFLOWTYPE_KEY);
        assertNotNull(oaWorkFlowTypeForm);

        setRequestPathInfo("/saveOaWorkFlowType");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OAWORKFLOWTYPE_KEY, oaWorkFlowTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaWorkFlowType.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaWorkFlowType");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
