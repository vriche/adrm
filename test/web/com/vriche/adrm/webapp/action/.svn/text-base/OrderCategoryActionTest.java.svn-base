package com.vriche.adrm.webapp.action;

import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.OrderCategoryForm;

public class OrderCategoryActionTest extends BaseStrutsTestCase {

    public OrderCategoryActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOrderCategory");
        addRequestParameter("method", "Save");

        OrderCategoryForm orderCategoryForm = new OrderCategoryForm();
        // set required fields

        request.setAttribute(Constants.ORDERCATEGORY_KEY, orderCategoryForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/orderCategorys");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.ORDERCATEGORY_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOrderCategory");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.ORDERCATEGORY_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOrderCategory");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OrderCategoryForm orderCategoryForm = (OrderCategoryForm) request.getAttribute(Constants.ORDERCATEGORY_KEY);
        assertNotNull(orderCategoryForm);

        setRequestPathInfo("/saveOrderCategory");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.ORDERCATEGORY_KEY, orderCategoryForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"orderCategory.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOrderCategory");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
