package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.ContractTargetMonthForm;

public class ContractTargetMonthActionTest extends BaseStrutsTestCase {

    public ContractTargetMonthActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveContractTargetMonth");
        addRequestParameter("method", "Save");

        ContractTargetMonthForm contractTargetMonthForm = new ContractTargetMonthForm();
        // set required fields
        contractTargetMonthForm.setMonthDate("944868386");
        contractTargetMonthForm.setMonthTarg("7.677791792537327E307");
        contractTargetMonthForm.setMonthReal("7.822401579135628E307");

        request.setAttribute(Constants.CONTRACTTARGETMONTH_KEY, contractTargetMonthForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/contractTargetMonths");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.CONTRACTTARGETMONTH_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editContractTargetMonth");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.CONTRACTTARGETMONTH_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editContractTargetMonth");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        ContractTargetMonthForm contractTargetMonthForm = (ContractTargetMonthForm) request.getAttribute(Constants.CONTRACTTARGETMONTH_KEY);
        assertNotNull(contractTargetMonthForm);

        setRequestPathInfo("/saveContractTargetMonth");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        contractTargetMonthForm.setMonthDate("858585276");
        contractTargetMonthForm.setMonthTarg("7.410694383993412E307");
        contractTargetMonthForm.setMonthReal("5.76560899878233E307");

        request.setAttribute(Constants.CONTRACTTARGETMONTH_KEY, contractTargetMonthForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"contractTargetMonth.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editContractTargetMonth");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
