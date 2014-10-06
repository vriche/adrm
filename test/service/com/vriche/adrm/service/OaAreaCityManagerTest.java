
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaAreaCityDao;
import com.vriche.adrm.model.OaAreaCity;
import com.vriche.adrm.service.impl.OaAreaCityManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaAreaCityManagerTest extends BaseManagerTestCase {
    private final String oaAreaCityId = "1";
    private OaAreaCityManagerImpl oaAreaCityManager = new OaAreaCityManagerImpl();
    private Mock oaAreaCityDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaAreaCityDao = new Mock(OaAreaCityDao.class);
        oaAreaCityManager.setOaAreaCityDao((OaAreaCityDao) oaAreaCityDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaAreaCityManager = null;
    }

    public void testGetOaAreaCitys() throws Exception {
        List results = new ArrayList();
        OaAreaCity oaAreaCity = new OaAreaCity();
        results.add(oaAreaCity);

        // set expected behavior on dao
        oaAreaCityDao.expects(once()).method("getOaAreaCitys")
            .will(returnValue(results));

        List oaAreaCitys = oaAreaCityManager.getOaAreaCitys(null);
        assertTrue(oaAreaCitys.size() == 1);
        oaAreaCityDao.verify();
    }

    public void testGetOaAreaCity() throws Exception {
        // set expected behavior on dao
        oaAreaCityDao.expects(once()).method("getOaAreaCity")
            .will(returnValue(new OaAreaCity()));
        OaAreaCity oaAreaCity = oaAreaCityManager.getOaAreaCity(oaAreaCityId);
        assertTrue(oaAreaCity != null);
        oaAreaCityDao.verify();
    }

    public void testSaveOaAreaCity() throws Exception {
        OaAreaCity oaAreaCity = new OaAreaCity();

        // set expected behavior on dao
        oaAreaCityDao.expects(once()).method("saveOaAreaCity")
            .with(same(oaAreaCity)).isVoid();

        oaAreaCityManager.saveOaAreaCity(oaAreaCity);
        oaAreaCityDao.verify();
    }

    public void testAddAndRemoveOaAreaCity() throws Exception {
        OaAreaCity oaAreaCity = new OaAreaCity();

        // set required fields

        // set expected behavior on dao
        oaAreaCityDao.expects(once()).method("saveOaAreaCity")
            .with(same(oaAreaCity)).isVoid();
        oaAreaCityManager.saveOaAreaCity(oaAreaCity);
        oaAreaCityDao.verify();

        // reset expectations
        oaAreaCityDao.reset();

        oaAreaCityDao.expects(once()).method("removeOaAreaCity").with(eq(new Long(oaAreaCityId)));
        oaAreaCityManager.removeOaAreaCity(oaAreaCityId);
        oaAreaCityDao.verify();

        // reset expectations
        oaAreaCityDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaAreaCity.class, oaAreaCity.getId());
        oaAreaCityDao.expects(once()).method("removeOaAreaCity").isVoid();
        oaAreaCityDao.expects(once()).method("getOaAreaCity").will(throwException(ex));
        oaAreaCityManager.removeOaAreaCity(oaAreaCityId);
        try {
            oaAreaCityManager.getOaAreaCity(oaAreaCityId);
            fail("OaAreaCity with identifier '" + oaAreaCityId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaAreaCityDao.verify();
    }
}
