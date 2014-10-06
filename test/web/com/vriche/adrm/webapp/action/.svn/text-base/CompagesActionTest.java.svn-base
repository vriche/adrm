package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.CompagesForm;
import com.vriche.adrm.Constants;

public class CompagesActionTest extends BaseStrutsTestCase {

    public CompagesActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveCompages");
        addRequestParameter("method", "Save");

        CompagesForm compagesForm = new CompagesForm();
        // set required fields

        request.setAttribute(Constants.COMPAGES_KEY, compagesForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/compagess");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.COMPAGES_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editCompages");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.COMPAGES_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editCompages");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        CompagesForm compagesForm = (CompagesForm) request.getAttribute(Constants.COMPAGES_KEY);
        assertNotNull(compagesForm);

        setRequestPathInfo("/saveCompages");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.COMPAGES_KEY, compagesForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"compages.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editCompages");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
