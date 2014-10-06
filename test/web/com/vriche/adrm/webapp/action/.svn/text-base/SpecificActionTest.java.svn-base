package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.SpecificForm;
import com.vriche.adrm.Constants;

public class SpecificActionTest extends BaseStrutsTestCase {

    public SpecificActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveSpecific");
        addRequestParameter("method", "Save");

        SpecificForm specificForm = new SpecificForm();
        // set required fields

        request.setAttribute(Constants.SPECIFIC_KEY, specificForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/specifics");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.SPECIFIC_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editSpecific");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.SPECIFIC_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editSpecific");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        SpecificForm specificForm = (SpecificForm) request.getAttribute(Constants.SPECIFIC_KEY);
        assertNotNull(specificForm);

        setRequestPathInfo("/saveSpecific");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.SPECIFIC_KEY, specificForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"specific.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editSpecific");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
