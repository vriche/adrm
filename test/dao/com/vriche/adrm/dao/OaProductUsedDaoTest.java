package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaProductUsed;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaProductUsedDaoTest extends BaseDaoTestCase {
    private Long oaProductUsedId = new Long("1");
    private OaProductUsedDao dao = null;

    public void setOaProductUsedDao(OaProductUsedDao dao) {
        this.dao = dao;
    }

    public void testAddOaProductUsed() throws Exception {
        OaProductUsed oaProductUsed = new OaProductUsed();

        // set required fields

        dao.saveOaProductUsed(oaProductUsed);

        // verify a primary key was assigned
        assertNotNull(oaProductUsed.getId());

        // verify set fields are same after save
    }

    public void testGetOaProductUsed() throws Exception {
        OaProductUsed oaProductUsed = dao.getOaProductUsed(oaProductUsedId);
        assertNotNull(oaProductUsed);
    }

    public void testGetOaProductUseds() throws Exception {
        OaProductUsed oaProductUsed = new OaProductUsed();

        List results = dao.getOaProductUseds(oaProductUsed);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaProductUsed() throws Exception {
        OaProductUsed oaProductUsed = dao.getOaProductUsed(oaProductUsedId);

        // update required fields

        dao.saveOaProductUsed(oaProductUsed);

    }

    public void testRemoveOaProductUsed() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaProductUsed(removeId);
        try {
            dao.getOaProductUsed(removeId);
            fail("oaProductUsed found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaProductUseds(final Map idList) throws Exception {
        try {
        	dao.removeOaProductUseds(idList);
            fail("oaProductUsed found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
