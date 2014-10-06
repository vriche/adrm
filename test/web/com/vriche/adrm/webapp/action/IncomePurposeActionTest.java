package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.IncomePurposeForm;
import com.vriche.adrm.Constants;

public class IncomePurposeActionTest extends BaseStrutsTestCase {

    public IncomePurposeActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveIncomePurpose");
        addRequestParameter("method", "Save");

        IncomePurposeForm incomePurposeForm = new IncomePurposeForm();
        // set required fields

        request.setAttribute(Constants.INCOMEPURPOSE_KEY, incomePurposeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/incomePurposes");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.INCOMEPURPOSE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editIncomePurpose");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.INCOMEPURPOSE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editIncomePurpose");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        IncomePurposeForm incomePurposeForm = (IncomePurposeForm) request.getAttribute(Constants.INCOMEPURPOSE_KEY);
        assertNotNull(incomePurposeForm);

        setRequestPathInfo("/saveIncomePurpose");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.INCOMEPURPOSE_KEY, incomePurposeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"incomePurpose.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editIncomePurpose");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
