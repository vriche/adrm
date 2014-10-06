package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaWorkFlow;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaWorkFlowDaoTest extends BaseDaoTestCase {
    private Long oaWorkFlowId = new Long("1");
    private OaWorkFlowDao dao = null;

    public void setOaWorkFlowDao(OaWorkFlowDao dao) {
        this.dao = dao;
    }

    public void testAddOaWorkFlow() throws Exception {
        OaWorkFlow oaWorkFlow = new OaWorkFlow();

        // set required fields

        dao.saveOaWorkFlow(oaWorkFlow);

        // verify a primary key was assigned
        assertNotNull(oaWorkFlow.getId());

        // verify set fields are same after save
    }

    public void testGetOaWorkFlow() throws Exception {
        OaWorkFlow oaWorkFlow = dao.getOaWorkFlow(oaWorkFlowId);
        assertNotNull(oaWorkFlow);
    }

    public void testGetOaWorkFlows() throws Exception {
        OaWorkFlow oaWorkFlow = new OaWorkFlow();

        List results = dao.getOaWorkFlows(oaWorkFlow);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaWorkFlow() throws Exception {
        OaWorkFlow oaWorkFlow = dao.getOaWorkFlow(oaWorkFlowId);

        // update required fields

        dao.saveOaWorkFlow(oaWorkFlow);

    }

    public void testRemoveOaWorkFlow() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaWorkFlow(removeId);
        try {
            dao.getOaWorkFlow(removeId);
            fail("oaWorkFlow found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaWorkFlows(final Map idList) throws Exception {
        try {
        	dao.removeOaWorkFlows(idList);
            fail("oaWorkFlow found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
