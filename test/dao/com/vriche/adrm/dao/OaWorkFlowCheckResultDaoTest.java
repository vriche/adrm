package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaWorkFlowCheckResult;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaWorkFlowCheckResultDaoTest extends BaseDaoTestCase {
    private Long oaWorkFlowCheckResultId = new Long("1");
    private OaWorkFlowCheckResultDao dao = null;

    public void setOaWorkFlowCheckResultDao(OaWorkFlowCheckResultDao dao) {
        this.dao = dao;
    }

    public void testAddOaWorkFlowCheckResult() throws Exception {
        OaWorkFlowCheckResult oaWorkFlowCheckResult = new OaWorkFlowCheckResult();

        // set required fields

        dao.saveOaWorkFlowCheckResult(oaWorkFlowCheckResult);

        // verify a primary key was assigned
        assertNotNull(oaWorkFlowCheckResult.getId());

        // verify set fields are same after save
    }

    public void testGetOaWorkFlowCheckResult() throws Exception {
        OaWorkFlowCheckResult oaWorkFlowCheckResult = dao.getOaWorkFlowCheckResult(oaWorkFlowCheckResultId);
        assertNotNull(oaWorkFlowCheckResult);
    }

    public void testGetOaWorkFlowCheckResults() throws Exception {
        OaWorkFlowCheckResult oaWorkFlowCheckResult = new OaWorkFlowCheckResult();

        List results = dao.getOaWorkFlowCheckResults(oaWorkFlowCheckResult);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaWorkFlowCheckResult() throws Exception {
        OaWorkFlowCheckResult oaWorkFlowCheckResult = dao.getOaWorkFlowCheckResult(oaWorkFlowCheckResultId);

        // update required fields

        dao.saveOaWorkFlowCheckResult(oaWorkFlowCheckResult);

    }

    public void testRemoveOaWorkFlowCheckResult() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaWorkFlowCheckResult(removeId);
        try {
            dao.getOaWorkFlowCheckResult(removeId);
            fail("oaWorkFlowCheckResult found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaWorkFlowCheckResults(final Map idList) throws Exception {
        try {
        	dao.removeOaWorkFlowCheckResults(idList);
            fail("oaWorkFlowCheckResult found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
