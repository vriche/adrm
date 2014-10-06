package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaWorkFlowCheck;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaWorkFlowCheckDaoTest extends BaseDaoTestCase {
    private Long oaWorkFlowCheckId = new Long("1");
    private OaWorkFlowCheckDao dao = null;

    public void setOaWorkFlowCheckDao(OaWorkFlowCheckDao dao) {
        this.dao = dao;
    }

    public void testAddOaWorkFlowCheck() throws Exception {
        OaWorkFlowCheck oaWorkFlowCheck = new OaWorkFlowCheck();

        // set required fields

        dao.saveOaWorkFlowCheck(oaWorkFlowCheck);

        // verify a primary key was assigned
        assertNotNull(oaWorkFlowCheck.getId());

        // verify set fields are same after save
    }

    public void testGetOaWorkFlowCheck() throws Exception {
        OaWorkFlowCheck oaWorkFlowCheck = dao.getOaWorkFlowCheck(oaWorkFlowCheckId);
        assertNotNull(oaWorkFlowCheck);
    }

    public void testGetOaWorkFlowChecks() throws Exception {
        OaWorkFlowCheck oaWorkFlowCheck = new OaWorkFlowCheck();

        List results = dao.getOaWorkFlowChecks(oaWorkFlowCheck);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaWorkFlowCheck() throws Exception {
        OaWorkFlowCheck oaWorkFlowCheck = dao.getOaWorkFlowCheck(oaWorkFlowCheckId);

        // update required fields

        dao.saveOaWorkFlowCheck(oaWorkFlowCheck);

    }

    public void testRemoveOaWorkFlowCheck() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaWorkFlowCheck(removeId);
        try {
            dao.getOaWorkFlowCheck(removeId);
            fail("oaWorkFlowCheck found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaWorkFlowChecks(final Map idList) throws Exception {
        try {
        	dao.removeOaWorkFlowChecks(idList);
            fail("oaWorkFlowCheck found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
