package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.ResourceForm;
import com.vriche.adrm.Constants;

public class ResourceActionTest extends BaseStrutsTestCase {

    public ResourceActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveResource");
        addRequestParameter("method", "Save");

        ResourceForm resourceForm = new ResourceForm();
        // set required fields
        resourceForm.setCarrierId("4472150371957651456");
        resourceForm.setResourceName("ZxLgCoTjDdOlPxIlGePuAxCkXzNtYpUg");

        request.setAttribute(Constants.RESOURCE_KEY, resourceForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/resources");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.RESOURCE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editResource");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.RESOURCE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editResource");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        ResourceForm resourceForm = (ResourceForm) request.getAttribute(Constants.RESOURCE_KEY);
        assertNotNull(resourceForm);

        setRequestPathInfo("/saveResource");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        resourceForm.setCarrierId("7768886290653585408");
        resourceForm.setResourceName("WvXgJcWfRmLqYjYoKyWqMxXmVrCcZtOi");

        request.setAttribute(Constants.RESOURCE_KEY, resourceForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"resource.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editResource");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
