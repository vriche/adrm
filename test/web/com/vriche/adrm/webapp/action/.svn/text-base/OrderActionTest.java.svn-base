package com.vriche.adrm.webapp.action;

import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.OrderForm;

public class OrderActionTest extends BaseStrutsTestCase {

    public OrderActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOrder");
        addRequestParameter("method", "Save");

        OrderForm orderForm = new OrderForm();
        // set required fields

        request.setAttribute(Constants.ORDER_KEY, orderForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/orders");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.ORDER_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOrder");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.ORDER_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOrder");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OrderForm orderForm = (OrderForm) request.getAttribute(Constants.ORDER_KEY);
        assertNotNull(orderForm);

        setRequestPathInfo("/saveOrder");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.ORDER_KEY, orderForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"order.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOrder");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
