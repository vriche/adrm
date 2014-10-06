package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaInfoType;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaInfoTypeDaoTest extends BaseDaoTestCase {
    private Long oaInfoTypeId = new Long("1");
    private OaInfoTypeDao dao = null;

    public void setOaInfoTypeDao(OaInfoTypeDao dao) {
        this.dao = dao;
    }

    public void testAddOaInfoType() throws Exception {
        OaInfoType oaInfoType = new OaInfoType();

        // set required fields

        dao.saveOaInfoType(oaInfoType);

        // verify a primary key was assigned
        assertNotNull(oaInfoType.getId());

        // verify set fields are same after save
    }

    public void testGetOaInfoType() throws Exception {
        OaInfoType oaInfoType = dao.getOaInfoType(oaInfoTypeId);
        assertNotNull(oaInfoType);
    }

    public void testGetOaInfoTypes() throws Exception {
        OaInfoType oaInfoType = new OaInfoType();

        List results = dao.getOaInfoTypes(oaInfoType);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaInfoType() throws Exception {
        OaInfoType oaInfoType = dao.getOaInfoType(oaInfoTypeId);

        // update required fields

        dao.saveOaInfoType(oaInfoType);

    }

    public void testRemoveOaInfoType() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaInfoType(removeId);
        try {
            dao.getOaInfoType(removeId);
            fail("oaInfoType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaInfoTypes(final Map idList) throws Exception {
        try {
        	dao.removeOaInfoTypes(idList);
            fail("oaInfoType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
