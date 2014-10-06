package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.IncomePullDao;
import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.IncomePull;

import org.springframework.orm.ObjectRetrievalFailureException;

public class IncomePullDaoTest extends BaseDaoTestCase {
    private Long incomePullId = new Long("1");
    private IncomePullDao dao = null;

    public void setIncomePullDao(IncomePullDao dao) {
        this.dao = dao;
    }

    public void testAddIncomePull() throws Exception {
        IncomePull incomePull = new IncomePull();

        // set required fields

        dao.saveIncomePull(incomePull);

        // verify a primary key was assigned
        assertNotNull(incomePull.getId());

        // verify set fields are same after save
    }

    public void testGetIncomePull() throws Exception {
        IncomePull incomePull = dao.getIncomePull(incomePullId);
        assertNotNull(incomePull);
    }

    public void testGetIncomePulls() throws Exception {
        IncomePull incomePull = new IncomePull();

        List results = dao.getIncomePulls(incomePull);
        assertTrue(results.size() > 0);
    }

    public void testSaveIncomePull() throws Exception {
        IncomePull incomePull = dao.getIncomePull(incomePullId);

        // update required fields

        dao.saveIncomePull(incomePull);

    }

    public void testRemoveIncomePull() throws Exception {
        Long removeId = new Long("3");
        dao.removeIncomePull(removeId);
        try {
            dao.getIncomePull(removeId);
            fail("incomePull found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveIncomePulls(final Map idList) throws Exception {
        try {
        	dao.removeIncomePulls(idList);
            fail("incomePull found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
