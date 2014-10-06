package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaProductInfo;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaProductInfoDaoTest extends BaseDaoTestCase {
    private Long oaProductInfoId = new Long("1");
    private OaProductInfoDao dao = null;

    public void setOaProductInfoDao(OaProductInfoDao dao) {
        this.dao = dao;
    }

    public void testAddOaProductInfo() throws Exception {
        OaProductInfo oaProductInfo = new OaProductInfo();

        // set required fields

        dao.saveOaProductInfo(oaProductInfo);

        // verify a primary key was assigned
        assertNotNull(oaProductInfo.getId());

        // verify set fields are same after save
    }

    public void testGetOaProductInfo() throws Exception {
        OaProductInfo oaProductInfo = dao.getOaProductInfo(oaProductInfoId);
        assertNotNull(oaProductInfo);
    }

    public void testGetOaProductInfos() throws Exception {
        OaProductInfo oaProductInfo = new OaProductInfo();

        List results = dao.getOaProductInfos(oaProductInfo);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaProductInfo() throws Exception {
        OaProductInfo oaProductInfo = dao.getOaProductInfo(oaProductInfoId);

        // update required fields

        dao.saveOaProductInfo(oaProductInfo);

    }

    public void testRemoveOaProductInfo() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaProductInfo(removeId);
        try {
            dao.getOaProductInfo(removeId);
            fail("oaProductInfo found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaProductInfos(final Map idList) throws Exception {
        try {
        	dao.removeOaProductInfos(idList);
            fail("oaProductInfo found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
