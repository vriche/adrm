package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.DayInfoForm;
import com.vriche.adrm.Constants;

public class DayInfoActionTest extends BaseStrutsTestCase {

    public DayInfoActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveDayInfo");
        addRequestParameter("method", "Save");

        DayInfoForm dayInfoForm = new DayInfoForm();
        // set required fields

        request.setAttribute(Constants.DAYINFO_KEY, dayInfoForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/dayInfos");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.DAYINFO_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editDayInfo");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.DAYINFO_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editDayInfo");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        DayInfoForm dayInfoForm = (DayInfoForm) request.getAttribute(Constants.DAYINFO_KEY);
        assertNotNull(dayInfoForm);

        setRequestPathInfo("/saveDayInfo");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.DAYINFO_KEY, dayInfoForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"dayInfo.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editDayInfo");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
