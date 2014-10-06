package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaWorkFlowMoveTypeForm;

public class OaWorkFlowMoveTypeActionTest extends BaseStrutsTestCase {

    public OaWorkFlowMoveTypeActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaWorkFlowMoveType");
        addRequestParameter("method", "Save");

        OaWorkFlowMoveTypeForm oaWorkFlowMoveTypeForm = new OaWorkFlowMoveTypeForm();
        // set required fields

        request.setAttribute(Constants.OAWORKFLOWMOVETYPE_KEY, oaWorkFlowMoveTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaWorkFlowMoveTypes");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OAWORKFLOWMOVETYPE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaWorkFlowMoveType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OAWORKFLOWMOVETYPE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaWorkFlowMoveType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaWorkFlowMoveTypeForm oaWorkFlowMoveTypeForm = (OaWorkFlowMoveTypeForm) request.getAttribute(Constants.OAWORKFLOWMOVETYPE_KEY);
        assertNotNull(oaWorkFlowMoveTypeForm);

        setRequestPathInfo("/saveOaWorkFlowMoveType");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OAWORKFLOWMOVETYPE_KEY, oaWorkFlowMoveTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaWorkFlowMoveType.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaWorkFlowMoveType");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
