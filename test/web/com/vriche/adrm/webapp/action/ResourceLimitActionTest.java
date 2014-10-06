package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.ResourceLimitForm;

public class ResourceLimitActionTest extends BaseStrutsTestCase {

    public ResourceLimitActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveResourceLimit");
        addRequestParameter("method", "Save");

        ResourceLimitForm resourceLimitForm = new ResourceLimitForm();
        // set required fields
        resourceLimitForm.setStartTime("1687168589");
        resourceLimitForm.setEndTime("1214266025");
        resourceLimitForm.setLimitTime("625033723");

        request.setAttribute(Constants.RESOURCELIMIT_KEY, resourceLimitForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/resourceLimits");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.RESOURCELIMIT_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editResourceLimit");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.RESOURCELIMIT_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editResourceLimit");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        ResourceLimitForm resourceLimitForm = (ResourceLimitForm) request.getAttribute(Constants.RESOURCELIMIT_KEY);
        assertNotNull(resourceLimitForm);

        setRequestPathInfo("/saveResourceLimit");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        resourceLimitForm.setStartTime("1652894112");
        resourceLimitForm.setEndTime("863886721");
        resourceLimitForm.setLimitTime("719787374");

        request.setAttribute(Constants.RESOURCELIMIT_KEY, resourceLimitForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"resourceLimit.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editResourceLimit");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
