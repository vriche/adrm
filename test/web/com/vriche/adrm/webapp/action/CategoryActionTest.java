package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.webapp.form.CategoryForm;
import com.vriche.adrm.Constants;

public class CategoryActionTest extends BaseStrutsTestCase {

    public CategoryActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveCategory");
        addRequestParameter("method", "Save");

        CategoryForm categoryForm = new CategoryForm();
        // set required fields
        categoryForm.setCategoryCode("RlUjPbVi");
        categoryForm.setCategoryName("AjFdYoFzLhVsLvLnIxJnVjTwMfArGbWhHoTdEvJyRyBiQhQePdOfAqCnAtLhIvLrBuWtXvXjMxAfNoEfChEtAdSoFpSrHcNcLqNaOuYsUqDyMlIyMjUuXcJpYeIaXuHe");
        categoryForm.setDisplayNo("1984845718");

        request.setAttribute(Constants.CATEGORY_KEY, categoryForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/categorys");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.CATEGORY_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editCategory");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.CATEGORY_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editCategory");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        CategoryForm categoryForm = (CategoryForm) request.getAttribute(Constants.CATEGORY_KEY);
        assertNotNull(categoryForm);

        setRequestPathInfo("/saveCategory");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request
        categoryForm.setCategoryCode("FzIeToMc");
        categoryForm.setCategoryName("VnFxVtNcIjZqFhJqQuPcHtYiWfNlOxIvWyPuByQlJjSbBrNiPcLdPzFzBqHfCpJvQrYkJvWkIwCqBvLrScBvGgGiDzTaPfOdBsShTpVxHjGyOiNlXpNcAnZpXoJaNcUf");
        categoryForm.setDisplayNo("1052010637");

        request.setAttribute(Constants.CATEGORY_KEY, categoryForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"category.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editCategory");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
