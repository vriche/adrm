package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.ForetArrearageForm;

public class ForetArrearageActionTest extends BaseStrutsTestCase {

    public ForetArrearageActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveForetArrearage");
        addRequestParameter("method", "Save");

        ForetArrearageForm foretArrearageForm = new ForetArrearageForm();
        // set required fields
        foretArrearageForm.setCustomerName("BoCiIqOzDbKkKbCyMmWcHnVvWrEvRiPp");
        foretArrearageForm.setIncomeCode("MrYgGwHlUwQaPjKaKaTaWuXgSrUqNkKf");
        foretArrearageForm.setIncomeDate("1297570504");
        foretArrearageForm.setIncomeMode("QiImLuNnKgNaStSwDnXrNrBmDbHtXwSm");
        foretArrearageForm.setIncomeMoney("9.933435398262064E306");
        foretArrearageForm.setIncomePurpose("KkEhNaWnUzAlKgQoErSvCpQhPiRkSmQm");
        foretArrearageForm.setPayDate("927024873");
        foretArrearageForm.setPayMoney("1.9085674063854867E307");
        foretArrearageForm.setUserName("KdKdXgIgOhKyMwTnAhHhFfGwAgDsBrRj");

        request.setAttribute(Constants.FORETARREARAGE_KEY, foretArrearageForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/foretArrearages");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.FORETARREARAGE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editForetArrearage");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.FORETARREARAGE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editForetArrearage");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        ForetArrearageForm foretArrearageForm = (ForetArrearageForm) request.getAttribute(Constants.FORETARREARAGE_KEY);
        assertNotNull(foretArrearageForm);

        setRequestPathInfo("/saveForetArrearage");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        foretArrearageForm.setCustomerName("LjAuJtBuHiUvXvAfMpNeNoTzAcPkNsQe");
        foretArrearageForm.setIncomeCode("TbGaNiEtJhWhDuHmOxIeSfZmIvRyFuJn");
        foretArrearageForm.setIncomeDate("1062229608");
        foretArrearageForm.setIncomeMode("ZdQtYiIuAwFhGiNkVwHzJbWtWkLoWeWk");
        foretArrearageForm.setIncomeMoney("4.899041870021774E307");
        foretArrearageForm.setIncomePurpose("TgAuVjBoTdUaQcGkSfQqImOlTzDxKnOc");
        foretArrearageForm.setPayDate("1308706470");
        foretArrearageForm.setPayMoney("6.836861510960091E307");
        foretArrearageForm.setUserName("XcOeUvLsCjBoWsTeStOcViIiGxVmUrFw");

        request.setAttribute(Constants.FORETARREARAGE_KEY, foretArrearageForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"foretArrearage.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editForetArrearage");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
