package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.FeedbackInfoForm;
import com.vriche.adrm.Constants;

public class FeedbackInfoActionTest extends BaseStrutsTestCase {

    public FeedbackInfoActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveFeedbackInfo");
        addRequestParameter("method", "Save");

        FeedbackInfoForm feedbackInfoForm = new FeedbackInfoForm();
        // set required fields
        feedbackInfoForm.setFeedContent("AtYzImGnJlYdTmEgBeGbViYvPdZcYcWxWnZrEjDiDrOgJqFjOeKaAeBsKwHhAvUkKqAbBcBbRlQtKhXlYoQaCfNrFoXbDxAzHbBoTrGoFpKfFoTjYyIxYiQiFkHiXfCsJcPvSgUoQsImKrPgPbNqPaDwRwInAtMtMnMvCoZjAhVgJqSmTuGzCqNoNqJlUcIbAxHeBlYyFuOoUxGaGaPnIgBdCyEqWtRgNmMoGpPeDgGsNqXzCvOrFgLwGjPvFvQ");

        request.setAttribute(Constants.FEEDBACKINFO_KEY, feedbackInfoForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/feedbackInfos");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.FEEDBACKINFO_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editFeedbackInfo");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.FEEDBACKINFO_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editFeedbackInfo");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        FeedbackInfoForm feedbackInfoForm = (FeedbackInfoForm) request.getAttribute(Constants.FEEDBACKINFO_KEY);
        assertNotNull(feedbackInfoForm);

        setRequestPathInfo("/saveFeedbackInfo");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        feedbackInfoForm.setFeedContent("WpTmXqSnFkUqPqZuKyGnLzWjQpHvTgExQzVjEmRoMiVbWxVuGzUvXbHsGhJuFnOuMzRdUuEjIdWjSdJsYtOpHuQpCmOsGeCzCyVfJpKfQlMkTmNhQoNrFsNyAuUcVdZaKmIdIyHdBtNkFwCuHwBhAwQhMhVyNeNvUeTnExOiWsKvFcMmMdNgPpSqWhIwMpJmZiQfRsKtZzBiOtKtXuNcJiQvCbDaWqZhTiExRoIxDxSzPrFbXmByKtXxPwXyGuI");

        request.setAttribute(Constants.FEEDBACKINFO_KEY, feedbackInfoForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"feedbackInfo.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editFeedbackInfo");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
