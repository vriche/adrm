package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaAreaCity;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaAreaCityDaoTest extends BaseDaoTestCase {
    private Long oaAreaCityId = new Long("1");
    private OaAreaCityDao dao = null;

    public void setOaAreaCityDao(OaAreaCityDao dao) {
        this.dao = dao;
    }

    public void testAddOaAreaCity() throws Exception {
        OaAreaCity oaAreaCity = new OaAreaCity();

        // set required fields

        dao.saveOaAreaCity(oaAreaCity);

        // verify a primary key was assigned
        assertNotNull(oaAreaCity.getId());

        // verify set fields are same after save
    }

    public void testGetOaAreaCity() throws Exception {
        OaAreaCity oaAreaCity = dao.getOaAreaCity(oaAreaCityId);
        assertNotNull(oaAreaCity);
    }

    public void testGetOaAreaCitys() throws Exception {
        OaAreaCity oaAreaCity = new OaAreaCity();

        List results = dao.getOaAreaCitys(oaAreaCity);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaAreaCity() throws Exception {
        OaAreaCity oaAreaCity = dao.getOaAreaCity(oaAreaCityId);

        // update required fields

        dao.saveOaAreaCity(oaAreaCity);

    }

    public void testRemoveOaAreaCity() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaAreaCity(removeId);
        try {
            dao.getOaAreaCity(removeId);
            fail("oaAreaCity found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaAreaCitys(final Map idList) throws Exception {
        try {
        	dao.removeOaAreaCitys(idList);
            fail("oaAreaCity found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
