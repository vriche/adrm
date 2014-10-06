package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaAssetsState;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaAssetsStateDaoTest extends BaseDaoTestCase {
    private Long oaAssetsStateId = new Long("1");
    private OaAssetsStateDao dao = null;

    public void setOaAssetsStateDao(OaAssetsStateDao dao) {
        this.dao = dao;
    }

    public void testAddOaAssetsState() throws Exception {
        OaAssetsState oaAssetsState = new OaAssetsState();

        // set required fields

        dao.saveOaAssetsState(oaAssetsState);

        // verify a primary key was assigned
        assertNotNull(oaAssetsState.getId());

        // verify set fields are same after save
    }

    public void testGetOaAssetsState() throws Exception {
        OaAssetsState oaAssetsState = dao.getOaAssetsState(oaAssetsStateId);
        assertNotNull(oaAssetsState);
    }

    public void testGetOaAssetsStates() throws Exception {
        OaAssetsState oaAssetsState = new OaAssetsState();

        List results = dao.getOaAssetsStates(oaAssetsState);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaAssetsState() throws Exception {
        OaAssetsState oaAssetsState = dao.getOaAssetsState(oaAssetsStateId);

        // update required fields

        dao.saveOaAssetsState(oaAssetsState);

    }

    public void testRemoveOaAssetsState() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaAssetsState(removeId);
        try {
            dao.getOaAssetsState(removeId);
            fail("oaAssetsState found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaAssetsStates(final Map idList) throws Exception {
        try {
        	dao.removeOaAssetsStates(idList);
            fail("oaAssetsState found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
