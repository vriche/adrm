package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaWorkFlowType;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaWorkFlowTypeDaoTest extends BaseDaoTestCase {
    private Long oaWorkFlowTypeId = new Long("1");
    private OaWorkFlowTypeDao dao = null;

    public void setOaWorkFlowTypeDao(OaWorkFlowTypeDao dao) {
        this.dao = dao;
    }

    public void testAddOaWorkFlowType() throws Exception {
        OaWorkFlowType oaWorkFlowType = new OaWorkFlowType();

        // set required fields

        dao.saveOaWorkFlowType(oaWorkFlowType);

        // verify a primary key was assigned
        assertNotNull(oaWorkFlowType.getId());

        // verify set fields are same after save
    }

    public void testGetOaWorkFlowType() throws Exception {
        OaWorkFlowType oaWorkFlowType = dao.getOaWorkFlowType(oaWorkFlowTypeId);
        assertNotNull(oaWorkFlowType);
    }

    public void testGetOaWorkFlowTypes() throws Exception {
        OaWorkFlowType oaWorkFlowType = new OaWorkFlowType();

        List results = dao.getOaWorkFlowTypes(oaWorkFlowType);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaWorkFlowType() throws Exception {
        OaWorkFlowType oaWorkFlowType = dao.getOaWorkFlowType(oaWorkFlowTypeId);

        // update required fields

        dao.saveOaWorkFlowType(oaWorkFlowType);

    }

    public void testRemoveOaWorkFlowType() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaWorkFlowType(removeId);
        try {
            dao.getOaWorkFlowType(removeId);
            fail("oaWorkFlowType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaWorkFlowTypes(final Map idList) throws Exception {
        try {
        	dao.removeOaWorkFlowTypes(idList);
            fail("oaWorkFlowType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
