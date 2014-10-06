package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaInfo;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaInfoDaoTest extends BaseDaoTestCase {
    private Long oaInfoId = new Long("1");
    private OaInfoDao dao = null;

    public void setOaInfoDao(OaInfoDao dao) {
        this.dao = dao;
    }

    public void testAddOaInfo() throws Exception {
        OaInfo oaInfo = new OaInfo();

        // set required fields

        dao.saveOaInfo(oaInfo);

        // verify a primary key was assigned
        assertNotNull(oaInfo.getId());

        // verify set fields are same after save
    }

    public void testGetOaInfo() throws Exception {
        OaInfo oaInfo = dao.getOaInfo(oaInfoId);
        assertNotNull(oaInfo);
    }

    public void testGetOaInfos() throws Exception {
        OaInfo oaInfo = new OaInfo();

        List results = dao.getOaInfos(oaInfo);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaInfo() throws Exception {
        OaInfo oaInfo = dao.getOaInfo(oaInfoId);

        // update required fields

        dao.saveOaInfo(oaInfo);

    }

    public void testRemoveOaInfo() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaInfo(removeId);
        try {
            dao.getOaInfo(removeId);
            fail("oaInfo found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaInfos(final Map idList) throws Exception {
        try {
        	dao.removeOaInfos(idList);
            fail("oaInfo found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
