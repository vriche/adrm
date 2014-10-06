package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaProductType;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaProductTypeDaoTest extends BaseDaoTestCase {
    private Long oaProductTypeId = new Long("1");
    private OaProductTypeDao dao = null;

    public void setOaProductTypeDao(OaProductTypeDao dao) {
        this.dao = dao;
    }

    public void testAddOaProductType() throws Exception {
        OaProductType oaProductType = new OaProductType();

        // set required fields

        dao.saveOaProductType(oaProductType);

        // verify a primary key was assigned
        assertNotNull(oaProductType.getId());

        // verify set fields are same after save
    }

    public void testGetOaProductType() throws Exception {
        OaProductType oaProductType = dao.getOaProductType(oaProductTypeId);
        assertNotNull(oaProductType);
    }

    public void testGetOaProductTypes() throws Exception {
        OaProductType oaProductType = new OaProductType();

        List results = dao.getOaProductTypes(oaProductType);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaProductType() throws Exception {
        OaProductType oaProductType = dao.getOaProductType(oaProductTypeId);

        // update required fields

        dao.saveOaProductType(oaProductType);

    }

    public void testRemoveOaProductType() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaProductType(removeId);
        try {
            dao.getOaProductType(removeId);
            fail("oaProductType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaProductTypes(final Map idList) throws Exception {
        try {
        	dao.removeOaProductTypes(idList);
            fail("oaProductType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
