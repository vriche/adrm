package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.LinkManForm;
import com.vriche.adrm.Constants;

public class LinkManActionTest extends BaseStrutsTestCase {

    public LinkManActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveLinkMan");
        addRequestParameter("method", "Save");

        LinkManForm linkManForm = new LinkManForm();
        // set required fields
        linkManForm.setLinkmanName("LoHkNrCtUfJjNdRvZaDwUnDvYdZyRlPlWuTuYlVlTzMrQjHjDtSkTqYtQiZnYvVaFcJvMxPmUgQcQuUiOaEgFfQmAfCpPjIyAuMbUdBiQuNbJlZsNpTwVzPaHnMuKxKn");

        request.setAttribute(Constants.LINKMAN_KEY, linkManForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/linkMans");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.LINKMAN_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editLinkMan");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.LINKMAN_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editLinkMan");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        LinkManForm linkManForm = (LinkManForm) request.getAttribute(Constants.LINKMAN_KEY);
        assertNotNull(linkManForm);

        setRequestPathInfo("/saveLinkMan");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        linkManForm.setLinkmanName("RbLwHzNvPnIaZiWjBoZtAxFeQeOxOhRdXyPxRyCuLnOoPeCjNeEmYwNuKxMqYnUoOmCnDlSzLaJuWeExPlYyPhYiEsHsJlPgQiFrDzOjUqDaClIjEnAqXhHwIyYyDmJx");

        request.setAttribute(Constants.LINKMAN_KEY, linkManForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"linkMan.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editLinkMan");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
