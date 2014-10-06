package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.IndustryForm;
import com.vriche.adrm.Constants;

public class IndustryActionTest extends BaseStrutsTestCase {

    public IndustryActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveIndustry");
        addRequestParameter("method", "Save");

        IndustryForm industryForm = new IndustryForm();
        // set required fields
        industryForm.setName("WaEtArIgHoDaBbDdLlXgCxQwJvKnQaRsGeZhZkRuVlWzXxJnSoDvWbUfLvJqIaYmTzPqIxSxOhEuNyZmZvFxAmNzGpEpBsJfSxKyAiDxRgInMeYfKhQvFuYkBiMpVsBh");

        request.setAttribute(Constants.INDUSTRY_KEY, industryForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/industrys");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.INDUSTRY_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editIndustry");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.INDUSTRY_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editIndustry");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        IndustryForm industryForm = (IndustryForm) request.getAttribute(Constants.INDUSTRY_KEY);
        assertNotNull(industryForm);

        setRequestPathInfo("/saveIndustry");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        industryForm.setName("LrKfRpWzPbUqMlIlChEcMvGeZlAuVoYgIbRkStOcHcYoSgRoRqVhLxUjRjJwArBoMgMmDiSwCoCnFsKiSxRrCpTuUlBaSnDyLfLaFhRxKdSmEzQqTeKmUkBzEyBaUzRq");

        request.setAttribute(Constants.INDUSTRY_KEY, industryForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"industry.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editIndustry");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
