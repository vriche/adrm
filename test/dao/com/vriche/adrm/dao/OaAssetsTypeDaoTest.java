package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaAssetsType;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaAssetsTypeDaoTest extends BaseDaoTestCase {
    private Long oaAssetsTypeId = new Long("1");
    private OaAssetsTypeDao dao = null;

    public void setOaAssetsTypeDao(OaAssetsTypeDao dao) {
        this.dao = dao;
    }

    public void testAddOaAssetsType() throws Exception {
        OaAssetsType oaAssetsType = new OaAssetsType();

        // set required fields

        dao.saveOaAssetsType(oaAssetsType);

        // verify a primary key was assigned
        assertNotNull(oaAssetsType.getId());

        // verify set fields are same after save
    }

    public void testGetOaAssetsType() throws Exception {
        OaAssetsType oaAssetsType = dao.getOaAssetsType(oaAssetsTypeId);
        assertNotNull(oaAssetsType);
    }

    public void testGetOaAssetsTypes() throws Exception {
        OaAssetsType oaAssetsType = new OaAssetsType();

        List results = dao.getOaAssetsTypes(oaAssetsType);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaAssetsType() throws Exception {
        OaAssetsType oaAssetsType = dao.getOaAssetsType(oaAssetsTypeId);

        // update required fields

        dao.saveOaAssetsType(oaAssetsType);

    }

    public void testRemoveOaAssetsType() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaAssetsType(removeId);
        try {
            dao.getOaAssetsType(removeId);
            fail("oaAssetsType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaAssetsTypes(final Map idList) throws Exception {
        try {
        	dao.removeOaAssetsTypes(idList);
            fail("oaAssetsType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
