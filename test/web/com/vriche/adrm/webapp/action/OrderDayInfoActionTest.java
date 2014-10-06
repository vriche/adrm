package com.vriche.adrm.webapp.action;

import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.OrderDayInfoForm;

public class OrderDayInfoActionTest extends BaseStrutsTestCase {

    public OrderDayInfoActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOrderDayInfo");
        addRequestParameter("method", "Save");

        OrderDayInfoForm orderDayInfoForm = new OrderDayInfoForm();
        // set required fields

        request.setAttribute(Constants.ORDERDAYINFO_KEY, orderDayInfoForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/orderDayInfos");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.ORDERDAYINFO_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOrderDayInfo");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.ORDERDAYINFO_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOrderDayInfo");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OrderDayInfoForm orderDayInfoForm = (OrderDayInfoForm) request.getAttribute(Constants.ORDERDAYINFO_KEY);
        assertNotNull(orderDayInfoForm);

        setRequestPathInfo("/saveOrderDayInfo");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.ORDERDAYINFO_KEY, orderDayInfoForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"orderDayInfo.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOrderDayInfo");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
