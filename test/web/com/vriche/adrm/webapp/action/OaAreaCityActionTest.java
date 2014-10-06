package com.vriche.adrm.webapp.action;

import com.vriche.adrm.webapp.action.BaseStrutsTestCase;
import com.vriche.adrm.Constants;
import com.vriche.adrm.webapp.form.OaAreaCityForm;

public class OaAreaCityActionTest extends BaseStrutsTestCase {

    public OaAreaCityActionTest(String name) {
        super(name);
    }

    public void testAdd() throws Exception {
        setRequestPathInfo("/saveOaAreaCity");
        addRequestParameter("method", "Save");

        OaAreaCityForm oaAreaCityForm = new OaAreaCityForm();
        // set required fields

        request.setAttribute(Constants.OAAREACITY_KEY, oaAreaCityForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }

    public void testSearch() {
        setRequestPathInfo("/oaAreaCitys");
        addRequestParameter("method", "Search");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("list");
        assertNotNull(request.getAttribute(Constants.OAAREACITY_LIST));
    }

    public void testEdit() throws Exception {
        setRequestPathInfo("/editOaAreaCity");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");
        assertNotNull(request.getAttribute(Constants.OAAREACITY_KEY));

    }

    public void testSave() throws Exception {
        setRequestPathInfo("/editOaAreaCity");
        addRequestParameter("method", "Edit");
        addRequestParameter("id", "1");

        actionPerform();

        OaAreaCityForm oaAreaCityForm = (OaAreaCityForm) request.getAttribute(Constants.OAAREACITY_KEY);
        assertNotNull(oaAreaCityForm);

        setRequestPathInfo("/saveOaAreaCity");
        addRequestParameter("method", "Save");

        // update the form's required string fields and add it back to the request

        request.setAttribute(Constants.OAAREACITY_KEY, oaAreaCityForm);

        actionPerform();

        verifyNoActionErrors();
        verifyForward("edit");

        // verify success messages
        verifyActionMessages(new String[] {"oaAreaCity.updated"});

    }

    public void testRemove() throws Exception {
        setRequestPathInfo("/editOaAreaCity");
        addRequestParameter("method", "Delete");
        addRequestParameter("id", "2");

        actionPerform();

        verifyNoActionErrors();
        verifyForward("search");
    }
}
