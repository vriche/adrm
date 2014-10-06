package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaWorkFlowMoveType;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaWorkFlowMoveTypeDaoTest extends BaseDaoTestCase {
    private Long oaWorkFlowMoveTypeId = new Long("1");
    private OaWorkFlowMoveTypeDao dao = null;

    public void setOaWorkFlowMoveTypeDao(OaWorkFlowMoveTypeDao dao) {
        this.dao = dao;
    }

    public void testAddOaWorkFlowMoveType() throws Exception {
        OaWorkFlowMoveType oaWorkFlowMoveType = new OaWorkFlowMoveType();

        // set required fields

        dao.saveOaWorkFlowMoveType(oaWorkFlowMoveType);

        // verify a primary key was assigned
        assertNotNull(oaWorkFlowMoveType.getId());

        // verify set fields are same after save
    }

    public void testGetOaWorkFlowMoveType() throws Exception {
        OaWorkFlowMoveType oaWorkFlowMoveType = dao.getOaWorkFlowMoveType(oaWorkFlowMoveTypeId);
        assertNotNull(oaWorkFlowMoveType);
    }

    public void testGetOaWorkFlowMoveTypes() throws Exception {
        OaWorkFlowMoveType oaWorkFlowMoveType = new OaWorkFlowMoveType();

        List results = dao.getOaWorkFlowMoveTypes(oaWorkFlowMoveType);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaWorkFlowMoveType() throws Exception {
        OaWorkFlowMoveType oaWorkFlowMoveType = dao.getOaWorkFlowMoveType(oaWorkFlowMoveTypeId);

        // update required fields

        dao.saveOaWorkFlowMoveType(oaWorkFlowMoveType);

    }

    public void testRemoveOaWorkFlowMoveType() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaWorkFlowMoveType(removeId);
        try {
            dao.getOaWorkFlowMoveType(removeId);
            fail("oaWorkFlowMoveType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaWorkFlowMoveTypes(final Map idList) throws Exception {
        try {
        	dao.removeOaWorkFlowMoveTypes(idList);
            fail("oaWorkFlowMoveType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
