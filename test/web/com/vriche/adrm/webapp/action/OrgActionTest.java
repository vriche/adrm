package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OrgForm;

public class OrgActionTest extends BaseStrutsTestCase {

    public OrgActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOrg");
        addRequestParameter("method", "Save");

        OrgForm orgForm = new OrgForm();
        // set required fields
        orgForm.getAddressForm().setCity("AnZoUqVsHzIsHyMhWrRuNpHtDgSeWvUqOjThYmFfSbMjOiZjVj");
        orgForm.getAddressForm().setPostalCode("ChFtRyWmGxDgSjP");

        request.setAttribute(Constants.ORG_KEY, orgForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/orgs");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.ORG_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOrg");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.ORG_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOrg");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OrgForm orgForm = (OrgForm) request.getAttribute(Constants.ORG_KEY);
        assertNotNull(orgForm);

        setRequestPathInfo("/saveOrg");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        orgForm.getAddressForm().setCity("CsFeCsFgDjOkMuJiUfNjXzOlCpCjGlBdJqStNhOeUaRsLmGcHl");
        orgForm.getAddressForm().setPostalCode("JuXnBbEfKwSfQpL");

        request.setAttribute(Constants.ORG_KEY, orgForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"org.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOrg");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
