package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.ResourceSortForm;

public class ResourceSortActionTest extends BaseStrutsTestCase {

    public ResourceSortActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveResourceSort");
        addRequestParameter("method", "Save");

        ResourceSortForm resourceSortForm = new ResourceSortForm();
        // set required fields

        request.setAttribute(Constants.RESOURCESORT_KEY, resourceSortForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/resourceSorts");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.RESOURCESORT_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editResourceSort");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.RESOURCESORT_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editResourceSort");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        ResourceSortForm resourceSortForm = (ResourceSortForm) request.getAttribute(Constants.RESOURCESORT_KEY);
        assertNotNull(resourceSortForm);

        setRequestPathInfo("/saveResourceSort");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.RESOURCESORT_KEY, resourceSortForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"resourceSort.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editResourceSort");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
