package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaCalendarEventForm;

public class OaCalendarEventActionTest extends BaseStrutsTestCase {

    public OaCalendarEventActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaCalendarEvent");
        addRequestParameter("method", "Save");

        OaCalendarEventForm oaCalendarEventForm = new OaCalendarEventForm();
        // set required fields

        request.setAttribute(Constants.OACALENDAREVENT_KEY, oaCalendarEventForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaCalendarEvents");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OACALENDAREVENT_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaCalendarEvent");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OACALENDAREVENT_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaCalendarEvent");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaCalendarEventForm oaCalendarEventForm = (OaCalendarEventForm) request.getAttribute(Constants.OACALENDAREVENT_KEY);
        assertNotNull(oaCalendarEventForm);

        setRequestPathInfo("/saveOaCalendarEvent");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OACALENDAREVENT_KEY, oaCalendarEventForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaCalendarEvent.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaCalendarEvent");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
