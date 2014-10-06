package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.AgentInfoForm;
import com.vriche.adrm.Constants;

public class AgentInfoActionTest extends BaseStrutsTestCase {

    public AgentInfoActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveAgentInfo");
        addRequestParameter("method", "Save");

        AgentInfoForm agentInfoForm = new AgentInfoForm();
        // set required fields

        request.setAttribute(Constants.AGENTINFO_KEY, agentInfoForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/agentInfos");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.AGENTINFO_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editAgentInfo");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.AGENTINFO_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editAgentInfo");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        AgentInfoForm agentInfoForm = (AgentInfoForm) request.getAttribute(Constants.AGENTINFO_KEY);
        assertNotNull(agentInfoForm);

        setRequestPathInfo("/saveAgentInfo");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.AGENTINFO_KEY, agentInfoForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"agentInfo.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editAgentInfo");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
