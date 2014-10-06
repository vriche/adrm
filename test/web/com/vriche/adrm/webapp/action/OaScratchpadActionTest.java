package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaScratchpadForm;

public class OaScratchpadActionTest extends BaseStrutsTestCase {

    public OaScratchpadActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaScratchpad");
        addRequestParameter("method", "Save");

        OaScratchpadForm oaScratchpadForm = new OaScratchpadForm();
        // set required fields

        request.setAttribute(Constants.OASCRATCHPAD_KEY, oaScratchpadForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaScratchpads");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OASCRATCHPAD_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaScratchpad");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OASCRATCHPAD_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaScratchpad");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaScratchpadForm oaScratchpadForm = (OaScratchpadForm) request.getAttribute(Constants.OASCRATCHPAD_KEY);
        assertNotNull(oaScratchpadForm);

        setRequestPathInfo("/saveOaScratchpad");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OASCRATCHPAD_KEY, oaScratchpadForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaScratchpad.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaScratchpad");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
