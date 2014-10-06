package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.PublishArrangeForm;

public class PublishArrangeActionTest extends BaseStrutsTestCase {

    public PublishArrangeActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/savePublishArrange");
        addRequestParameter("method", "Save");

        PublishArrangeForm publishArrangeForm = new PublishArrangeForm();
        // set required fields
        publishArrangeForm.setCarrierId("3135575492919888896");
        publishArrangeForm.setCarrierName("QsKjWeRhQbDwJeFeJbCyEnOyLjCjVqEwWaWtKvWjFjEcUbQlZmFzBjGnBbSvTjRjPzOpAmMeVcRrSmWoNdJjMkMmBgSbOgBeUdFkMhGtDtJzJqSwAmKqNzZsLxMbCwPa");
        publishArrangeForm.setFilePath("FcCbAmTiRmTrFwMhAlPsYkXsGcDjBnBaXcZmXhRwOpYvOhNjChOrXsKhMjLnZuYuRxCjDeMqAuBqFnBoToVsTcJfViJrWnNsJxQpMhMhVzLvTnArKkXpFnMlYlHiPuYrXrIkRyVuDgJyTdGrWbKcUhKgWdElHiMyWjHfDvXfKaDgHgCpVrUrIjLyOeJwBgChDuDkJyBdZlZnYtXzXhStYlFsZdZwXrJfYnLqKdLqDfVnRiGcMaMsEsTmDhNzWzPv");
//        publishArrangeForm.setIsEnable("N");
//        publishArrangeForm.setIsLocked("N");
        publishArrangeForm.setPublishDate("2137021123");
        publishArrangeForm.setResourceId("1470499482835928064");
        publishArrangeForm.setResourceMeno("FbRsGsMnQbHxYzHtUsJkRjPsOcPfAnDfWcTmZiLeQgYaNgXsVfFaUiApWvZoLeVtIjZtDkZcGwZoCjNrIeUqWtFvTeBiDoKsIuQxGsSaTfYrDgGbEiNhPsFrNfHzXwCe");
        publishArrangeForm.setResourceName("CyZyVxFlUzAfUyInFqSaZdTfKfYmKsMdHwZoXeNxImMbIpTvCcDrToWgLfVbQdLgXvXeQtXiXdRvVuEpOuVjDsUfAhEvZcXbVnKkDxXsAgVbDyWwCdJwAsGuFpXdCzFk");
        publishArrangeForm.setResourceTotalTimes("968311010");
        publishArrangeForm.setResourceUsedTimes("1118541816");

        request.setAttribute(Constants.PUBLISHARRANGE_KEY, publishArrangeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/publishArranges");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.PUBLISHARRANGE_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editPublishArrange");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.PUBLISHARRANGE_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editPublishArrange");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        PublishArrangeForm publishArrangeForm = (PublishArrangeForm) request.getAttribute(Constants.PUBLISHARRANGE_KEY);
        assertNotNull(publishArrangeForm);

        setRequestPathInfo("/savePublishArrange");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        publishArrangeForm.setCarrierId("7101726866479547392");
        publishArrangeForm.setCarrierName("TtGtGvXsDeFjMjOdRcMtDqLdSlPnZkXlPlZrIaFvCfGqSnZbUjZjBrPsLrEoHuEsDhTyFcRpDuTkOgGjBaKlUoWgFpVpWmIwDnKsLsEeTnSxWhZwXkZaQaAhUfGtKwMh");
        publishArrangeForm.setFilePath("IsKjDkQxUkIiThMeYiKbDcVvPcIiSnEbKzCdWnLvFeXoNqHnBnIfKfJyZyPpKnSrHwLvJhWmMeDvSvHmUlHqSlRtCjKvCqYdMbYuDnRdWfSzDyZfTjQgFbRoHeNmUbXbTrZjJzHwMsWsQgBsOoYfDjAmDkFrPiHhAoYiEnXiVjMeTlCrTwMiDuSwFdExMhQsPzFqAdWkNqLaRqRcFlFfUcOmZiXaMmCdNmAoNnQmJwYdScOqQvQlJzZoUtOoEzGp");
//        publishArrangeForm.setIsEnable("N");
//        publishArrangeForm.setIsLocked("N");
        publishArrangeForm.setPublishDate("631842435");
        publishArrangeForm.setResourceId("1744682706569677824");
        publishArrangeForm.setResourceMeno("LzIqMqLlJkNtJxJeDtDxGkJmOzDyMxWyEvGsWdQfGbDjHbJvSzLfRxHjVrZyXjQfZyWkYnMhNmWrAuQbStMfInXzEuNhSuAuPcDeDjAyApMyGkSaRvYzUqNqYlApKtCd");
        publishArrangeForm.setResourceName("FjIdEvBuHyYqZcKeCjIzHvRqUgZtNdLoPlJsLcSkMiYnLwWtNsZiBpRcYaVxMwLbVtDdEhDuRwDuDbAkQgYwYkSpMvKzVwQcNeEoKlJoJvEqYuZmInRwDtPhZcYcOkIw");
        publishArrangeForm.setResourceTotalTimes("1297701457");
        publishArrangeForm.setResourceUsedTimes("1224933967");

        request.setAttribute(Constants.PUBLISHARRANGE_KEY, publishArrangeForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"publishArrange.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editPublishArrange");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
