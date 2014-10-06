package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.IncomePurposeDao;
import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.IncomePurpose;

import org.springframework.orm.ObjectRetrievalFailureException;

public class IncomePurposeDaoTest extends BaseDaoTestCase {
    private Long incomePurposeId = new Long("1");
    private IncomePurposeDao dao = null;

    public void setIncomePurposeDao(IncomePurposeDao dao) {
        this.dao = dao;
    }

    public void testAddIncomePurpose() throws Exception {
        IncomePurpose incomePurpose = new IncomePurpose();

        // set required fields

        dao.saveIncomePurpose(incomePurpose);

        // verify a primary key was assigned
        assertNotNull(incomePurpose.getId());

        // verify set fields are same after save
    }

    public void testGetIncomePurpose() throws Exception {
        IncomePurpose incomePurpose = dao.getIncomePurpose(incomePurposeId);
        assertNotNull(incomePurpose);
    }

    public void testGetIncomePurposes() throws Exception {
        IncomePurpose incomePurpose = new IncomePurpose();

        List results = dao.getIncomePurposes(incomePurpose);
        assertTrue(results.size() > 0);
    }

    public void testSaveIncomePurpose() throws Exception {
        IncomePurpose incomePurpose = dao.getIncomePurpose(incomePurposeId);

        // update required fields

        dao.saveIncomePurpose(incomePurpose);

    }

    public void testRemoveIncomePurpose() throws Exception {
        Long removeId = new Long("3");
        dao.removeIncomePurpose(removeId);
        try {
            dao.getIncomePurpose(removeId);
            fail("incomePurpose found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveIncomePurposes(final Map idList) throws Exception {
        try {
        	dao.removeIncomePurposes(idList);
            fail("incomePurpose found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
