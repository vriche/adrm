package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.LinkHisotryForm;
import com.vriche.adrm.Constants;

public class LinkHisotryActionTest extends BaseStrutsTestCase {

    public LinkHisotryActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveLinkHisotry");
        addRequestParameter("method", "Save");

        LinkHisotryForm linkHisotryForm = new LinkHisotryForm();
        // set required fields
        linkHisotryForm.setSubject("JjFlBgJdIxOzOpUuLtHwEvQeBwPeTbAuTcSlTbXnNnKzDyFiZpUhXiKbVuYhRrVmJiMxVxWlDoYzQzEbDlMaMnZuKqVmAnKgXeApAtRtQkElJdBvBzDtBqEkNyUgKcKu");

        request.setAttribute(Constants.LINKHISOTRY_KEY, linkHisotryForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/linkHisotrys");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.LINKHISOTRY_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editLinkHisotry");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.LINKHISOTRY_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editLinkHisotry");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        LinkHisotryForm linkHisotryForm = (LinkHisotryForm) request.getAttribute(Constants.LINKHISOTRY_KEY);
        assertNotNull(linkHisotryForm);

        setRequestPathInfo("/saveLinkHisotry");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        linkHisotryForm.setSubject("MfAjSfUhMaSnQsWuDbFmBaBzSnPrWhUbZcZzVuGqJtCgGiLuXyBvMxCjCdMiFsRiUmAzAhEkXqMwTuBtOpBxVsQbPbEbKyMdSaXcWtVpFpHkJeXlLrOaAhCbIiKgMkKv");

        request.setAttribute(Constants.LINKHISOTRY_KEY, linkHisotryForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"linkHisotry.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editLinkHisotry");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
