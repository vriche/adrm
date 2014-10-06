package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.PublishArrangeDetailForm;

public class PublishArrangeDetailActionTest extends BaseStrutsTestCase {

    public PublishArrangeDetailActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/savePublishArrangeDetail");
        addRequestParameter("method", "Save");

        PublishArrangeDetailForm publishArrangeDetailForm = new PublishArrangeDetailForm();
        // set required fields
        publishArrangeDetailForm.setPublishSort("1084123938");
        publishArrangeDetailForm.setSpecificValue("CmSrSfJqCpRkTaRkMkQhKgGkYrGsDiMlDjWnTxXqCgAbOoWyGqGrJpZpRmPwMnPrZmEtZgEmWbDqSsFiUdWiYqTvRzDhScMcTaIbBbZlOqPvEvZxTgZkIjGyOlQhStSs");
        publishArrangeDetailForm.setContractId("6626869289941015552");
        publishArrangeDetailForm.setCustomerId("1232157158184981504");
        publishArrangeDetailForm.setMatterId("841479350568483840");
        publishArrangeDetailForm.setOrderDayId("8466778064947678208");
        publishArrangeDetailForm.setOrderDetailId("7041881174449474560");
        publishArrangeDetailForm.setOrderId("3769906115136180224");
        publishArrangeDetailForm.setOwnerUserId("7982826601464043520");
        publishArrangeDetailForm.setCustomerName("TjOgUcKqFjWrFyKbFlPxXkOrAcGeWyXiFhWgBrEcUqAwLwSyUxXnHkZsHqMxFtLwWiTzFyMjEwFwExAaXgWgDiSfLsDiTaRuAqOtHeYjFcKwMkZqPvOrOyWcTpUrYzNm");
        publishArrangeDetailForm.setTapeCode("PiBfCiEwUeUdDpGyLyKtEbRlHaIuJbXcMaUoTtCzMwHdPgXjYrNaHbCmFuJdEhZbNhUgVdEsSdVcElCsSbSwMiUvPzXuZmIfIoSxMyDoDyPpOnExDrLbKjLvFdJwAcLc");
        publishArrangeDetailForm.setMatterEdit("QfWoQpTxBzJpSlRxLfGkWrGhXuLbOdSjSvUyZoBbLbNtLlUuOpHzCfPnZdWmHdKoJwWgSzPyTfXsDrDcRbGiFbFiUiTwKxYeRkJzQhFzPnFaViPoYoHzEeEpWlRtPwMw");
        publishArrangeDetailForm.setMatterLength("KiSdThSzYbLaEzOwDqReSpRaAeVgLiTyMoVpVhGqGvTyIbJxZiXdQtMwUnHtYjCdTtWuKvKyKiKqErXaNiDbIdGkFxVeOjSrBzIsTzAfAeCbYtSuQkQxScNdQiScDuKi");
        publishArrangeDetailForm.setMatterName("KyBwPxZwAzMmReXtCgSxCzHoCzXpHyEfNhWwMoKzPkXmLmWqNiWzRnVePyLxBfJiPcEcYpXtCsOmPpWtYcZpTmOpZhDsVpAqJwAkOsJjLiNqZwUmInAqYjKcSgKgGfKg");
        publishArrangeDetailForm.setSpecificName("GkHoHePzUsPnXmSjNrWbXtHdDwLdThUcZiAlHjSfDpUrCvXcHxGwTmTlBqRaDlNlIqKvVyHlOiPuWmVwWsLoOhBdFoKxIxJeCkMgHcCvOjBpOcZeMnKlGwMgKmRhPkBu");
        publishArrangeDetailForm.setAdverTimes("841926564");
        publishArrangeDetailForm.setOwnerUserName("ZnCuXyLnOmVkWaLfGaQnRrHpOkWwYcAdIlEtDvIpVbJlZgMhHyBfNnHlAvIhBtQvNmGuGhFwYzUsKiNhQzPuDcZxGePeEmKpSgAzRzLlYtAuZdBwNvTfXxFgXoXaLkHk");
        publishArrangeDetailForm.setPublishMemo("BvFcEoWhBpKkUzSrXqIxGjRhQbSzKfBoDkBpTzDwAiXsNdIkRlQdSpTtUfGgLdWoNuXeMoNjGjLdLjGiOePmTkWaHrYgZeOzSnGfVvJwPaVeKyDsYnKrLnTaCaLlHxPv");

        request.setAttribute(Constants.PUBLISHARRANGEDETAIL_KEY, publishArrangeDetailForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/publishArrangeDetails");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.PUBLISHARRANGEDETAIL_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editPublishArrangeDetail");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.PUBLISHARRANGEDETAIL_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editPublishArrangeDetail");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        PublishArrangeDetailForm publishArrangeDetailForm = (PublishArrangeDetailForm) request.getAttribute(Constants.PUBLISHARRANGEDETAIL_KEY);
        assertNotNull(publishArrangeDetailForm);

        setRequestPathInfo("/savePublishArrangeDetail");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        publishArrangeDetailForm.setPublishSort("2032041466");
        publishArrangeDetailForm.setSpecificValue("AqAeIoAfYoWcUuYfOhOvCiOrYlTlBtCwEjQmTlWtBeAsBfLaAkMcLlSsUjJjSxKvWzPhItVrLqIoNzHgMkWgAgLcZqIjOvAzZfIzKdEaQcTiXzQqArVxUnOkByUtKrGa");
        publishArrangeDetailForm.setContractId("7381168548205750272");
        publishArrangeDetailForm.setCustomerId("1260638627666279424");
        publishArrangeDetailForm.setMatterId("2533617590995161088");
        publishArrangeDetailForm.setOrderDayId("2707124189708880896");
        publishArrangeDetailForm.setOrderDetailId("2203928235246914560");
        publishArrangeDetailForm.setOrderId("3970944269025995776");
        publishArrangeDetailForm.setOwnerUserId("4410579779954495488");
        publishArrangeDetailForm.setCustomerName("EhWkGqGtKcImNnKeExThVcIvYgQwAjVmBsPoQrZbGqExUsKsVxInZnHuFsAdZtOfNdXqVyDoOgZaAlJaOxRzDwOhYaWgJmRfBwWzChXpUzAeGuFbVuAeNgXdRqJnBqAe");
        publishArrangeDetailForm.setTapeCode("OwClBvNlHbXfGdLgQzHzMoMcAbNlMlTvQlDjBeRsEzNwXcEuJoAgRkLqXrAiQoRwWlPtFgPsOyLfTkEoZaMrOmCfToXqFvGkMgExFgVxBjJkBdNtBgZuBeYdHxYjDaNn");
        publishArrangeDetailForm.setMatterEdit("HsLdWqCzKqYxShDmKoNoJhLlZfZsKbOyVnFnMvLxLlVrPnVuUdLrIeOlRiNzVhYlRnWmQsOjMwXpLcKtDsXrRaWuJbStPeNuGvEyLpLiKfXoLdCfNmWyUiUuFsNgMfSq");
        publishArrangeDetailForm.setMatterLength("OlHgPmIzVnCeJeLxWfVcSwBuBjCeSwNbJaWdDkSxRbKhExYdTqVmCqPcVqMmZfHxStQyDcUjOiRnJaMiFdEeYfJyLqKnPhOzJzAySdDzGwEyYsRaHrFaYhRqXeRoBeYo");
        publishArrangeDetailForm.setMatterName("XjIkMvMsJxMdPyObJwQbQmTeRhHmUaQjSvQfAuZwGrIqWiOzZnKzOlKcDyImAjWoNpOkOtJoHpBhBcRwXdYcOaDfLxWoDxSbWmWjHhWiJwDeVjXeFwInOcFgUbXqEfHc");
        publishArrangeDetailForm.setSpecificName("FiLwJbVzKjWoKmYxEsAgObLaOuAkLbYeWwNtUiAwOuNgAaFfQwScOdQiWwZeRmVzNrDkXoYbHvMfKpWyGlFjHpUaPdOdDrUtYnXbOkKfWxZcTfLrUgDzReJgHaTqDvKy");
        publishArrangeDetailForm.setAdverTimes("1419605359");
        publishArrangeDetailForm.setOwnerUserName("YyRnVnIzZqQsQiWlCfUwFqWqUeXwBgXiVdTxPuUvOuQyGzIwDiJjJqHxIuBhAoCzRpSzYlBhFnRoCvAyLmQmDzMwEuEiJyJuRiJgOdYiZhYzZyUfZfCaKgFwQrSoSoLu");
        publishArrangeDetailForm.setPublishMemo("KiNsPrVtGtDfBqSkVfFcDlQfGrEsQhXhLqCoKkNeZuWcMjQdKcWoMsXoRqDvGnDyPzHsWkVdXtDyQyOwJoLdFlKzKoHmQsSsYlBfQcDsEzDiCdZkGuSgClSzEcWcVqZm");

        request.setAttribute(Constants.PUBLISHARRANGEDETAIL_KEY, publishArrangeDetailForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"publishArrangeDetail.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editPublishArrangeDetail");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
