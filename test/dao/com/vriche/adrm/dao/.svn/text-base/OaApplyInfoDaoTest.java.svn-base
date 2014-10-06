package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaApplyInfo;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaApplyInfoDaoTest extends BaseDaoTestCase {
    private Long oaApplyInfoId = new Long("1");
    private OaApplyInfoDao dao = null;

    public void setOaApplyInfoDao(OaApplyInfoDao dao) {
        this.dao = dao;
    }

    public void testAddOaApplyInfo() throws Exception {
        OaApplyInfo oaApplyInfo = new OaApplyInfo();

        // set required fields

        dao.saveOaApplyInfo(oaApplyInfo);

        // verify a primary key was assigned
        assertNotNull(oaApplyInfo.getId());

        // verify set fields are same after save
    }

    public void testGetOaApplyInfo() throws Exception {
        OaApplyInfo oaApplyInfo = dao.getOaApplyInfo(oaApplyInfoId);
        assertNotNull(oaApplyInfo);
    }

    public void testGetOaApplyInfos() throws Exception {
        OaApplyInfo oaApplyInfo = new OaApplyInfo();

        List results = dao.getOaApplyInfos(oaApplyInfo);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaApplyInfo() throws Exception {
        OaApplyInfo oaApplyInfo = dao.getOaApplyInfo(oaApplyInfoId);

        // update required fields

        dao.saveOaApplyInfo(oaApplyInfo);

    }

    public void testRemoveOaApplyInfo() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaApplyInfo(removeId);
        try {
            dao.getOaApplyInfo(removeId);
            fail("oaApplyInfo found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaApplyInfos(final Map idList) throws Exception {
        try {
        	dao.removeOaApplyInfos(idList);
            fail("oaApplyInfo found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
