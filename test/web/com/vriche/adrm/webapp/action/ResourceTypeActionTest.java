package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.ResourceTypeForm;
import com.vriche.adrm.Constants;

public class ResourceTypeActionTest extends BaseStrutsTestCase {

    public ResourceTypeActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveResourceType");
        addRequestParameter("method", "Save");

        ResourceTypeForm resourceTypeForm = new ResourceTypeForm();
        // set required fields

        request.setAttribute(Constants.RESOURCETYPE_KEY, resourceTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/resourceTypes");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.RESOURCETYPE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editResourceType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.RESOURCETYPE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editResourceType");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        ResourceTypeForm resourceTypeForm = (ResourceTypeForm) request.getAttribute(Constants.RESOURCETYPE_KEY);
        assertNotNull(resourceTypeForm);

        setRequestPathInfo("/saveResourceType");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.RESOURCETYPE_KEY, resourceTypeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"resourceType.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editResourceType");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
