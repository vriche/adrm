package com.vriche.adrm.webapp.action;

import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.OrderLogForm;

public class OrderLogActionTest extends BaseStrutsTestCase {

    public OrderLogActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOrderLog");
        addRequestParameter("method", "Save");

        OrderLogForm orderLogForm = new OrderLogForm();
        // set required fields

        request.setAttribute(Constants.ORDERLOG_KEY, orderLogForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/orderLogs");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.ORDERLOG_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOrderLog");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.ORDERLOG_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOrderLog");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OrderLogForm orderLogForm = (OrderLogForm) request.getAttribute(Constants.ORDERLOG_KEY);
        assertNotNull(orderLogForm);

        setRequestPathInfo("/saveOrderLog");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.ORDERLOG_KEY, orderLogForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"orderLog.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOrderLog");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
