package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.ResourceChannelForm;
import com.vriche.adrm.Constants;

public class ResourceChannelActionTest extends BaseStrutsTestCase {

    public ResourceChannelActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveResourceChannel");
        addRequestParameter("method", "Save");

        ResourceChannelForm resourceChannelForm = new ResourceChannelForm();
        // set required fields

        request.setAttribute(Constants.RESOURCECHANNEL_KEY, resourceChannelForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/resourceChannels");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.RESOURCECHANNEL_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editResourceChannel");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.RESOURCECHANNEL_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editResourceChannel");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        ResourceChannelForm resourceChannelForm = (ResourceChannelForm) request.getAttribute(Constants.RESOURCECHANNEL_KEY);
        assertNotNull(resourceChannelForm);

        setRequestPathInfo("/saveResourceChannel");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.RESOURCECHANNEL_KEY, resourceChannelForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"resourceChannel.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editResourceChannel");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
