package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaWorkFlowCheckState;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaWorkFlowCheckStateDaoTest extends BaseDaoTestCase {
    private Long oaWorkFlowCheckStateId = new Long("1");
    private OaWorkFlowCheckStateDao dao = null;

    public void setOaWorkFlowCheckStateDao(OaWorkFlowCheckStateDao dao) {
        this.dao = dao;
    }

    public void testAddOaWorkFlowCheckState() throws Exception {
        OaWorkFlowCheckState oaWorkFlowCheckState = new OaWorkFlowCheckState();

        // set required fields

        dao.saveOaWorkFlowCheckState(oaWorkFlowCheckState);

        // verify a primary key was assigned
        assertNotNull(oaWorkFlowCheckState.getId());

        // verify set fields are same after save
    }

    public void testGetOaWorkFlowCheckState() throws Exception {
        OaWorkFlowCheckState oaWorkFlowCheckState = dao.getOaWorkFlowCheckState(oaWorkFlowCheckStateId);
        assertNotNull(oaWorkFlowCheckState);
    }

    public void testGetOaWorkFlowCheckStates() throws Exception {
        OaWorkFlowCheckState oaWorkFlowCheckState = new OaWorkFlowCheckState();

        List results = dao.getOaWorkFlowCheckStates(oaWorkFlowCheckState);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaWorkFlowCheckState() throws Exception {
        OaWorkFlowCheckState oaWorkFlowCheckState = dao.getOaWorkFlowCheckState(oaWorkFlowCheckStateId);

        // update required fields

        dao.saveOaWorkFlowCheckState(oaWorkFlowCheckState);

    }

    public void testRemoveOaWorkFlowCheckState() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaWorkFlowCheckState(removeId);
        try {
            dao.getOaWorkFlowCheckState(removeId);
            fail("oaWorkFlowCheckState found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaWorkFlowCheckStates(final Map idList) throws Exception {
        try {
        	dao.removeOaWorkFlowCheckStates(idList);
            fail("oaWorkFlowCheckState found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
