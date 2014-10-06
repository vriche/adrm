package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaAreaPc;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaAreaPcDaoTest extends BaseDaoTestCase {
    private Long oaAreaPcId = new Long("1");
    private OaAreaPcDao dao = null;

    public void setOaAreaPcDao(OaAreaPcDao dao) {
        this.dao = dao;
    }

    public void testAddOaAreaPc() throws Exception {
        OaAreaPc oaAreaPc = new OaAreaPc();

        // set required fields

        dao.saveOaAreaPc(oaAreaPc);

        // verify a primary key was assigned
        assertNotNull(oaAreaPc.getId());

        // verify set fields are same after save
    }

    public void testGetOaAreaPc() throws Exception {
        OaAreaPc oaAreaPc = dao.getOaAreaPc(oaAreaPcId);
        assertNotNull(oaAreaPc);
    }

    public void testGetOaAreaPcs() throws Exception {
        OaAreaPc oaAreaPc = new OaAreaPc();

        List results = dao.getOaAreaPcs(oaAreaPc);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaAreaPc() throws Exception {
        OaAreaPc oaAreaPc = dao.getOaAreaPc(oaAreaPcId);

        // update required fields

        dao.saveOaAreaPc(oaAreaPc);

    }

    public void testRemoveOaAreaPc() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaAreaPc(removeId);
        try {
            dao.getOaAreaPc(removeId);
            fail("oaAreaPc found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaAreaPcs(final Map idList) throws Exception {
        try {
        	dao.removeOaAreaPcs(idList);
            fail("oaAreaPc found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
