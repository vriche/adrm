package com.vriche.adrm.webapp.action;

import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.OrderDetailForm;

public class OrderDetailActionTest extends BaseStrutsTestCase {

    public OrderDetailActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOrderDetail");
        addRequestParameter("method", "Save");

        OrderDetailForm orderDetailForm = new OrderDetailForm();
        // set required fields

        request.setAttribute(Constants.ORDERDETAIL_KEY, orderDetailForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/orderDetails");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.ORDERDETAIL_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOrderDetail");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.ORDERDETAIL_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOrderDetail");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OrderDetailForm orderDetailForm = (OrderDetailForm) request.getAttribute(Constants.ORDERDETAIL_KEY);
        assertNotNull(orderDetailForm);

        setRequestPathInfo("/saveOrderDetail");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.ORDERDETAIL_KEY, orderDetailForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"orderDetail.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOrderDetail");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
