package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.IncomeUsedDao;
import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.IncomeUsed;

import org.springframework.orm.ObjectRetrievalFailureException;

public class IncomeUsedDaoTest extends BaseDaoTestCase {
    private Long incomeUsedId = new Long("1");
    private IncomeUsedDao dao = null;

    public void setIncomeUsedDao(IncomeUsedDao dao) {
        this.dao = dao;
    }

    public void testAddIncomeUsed() throws Exception {
        IncomeUsed incomeUsed = new IncomeUsed();

        // set required fields

        dao.saveIncomeUsed(incomeUsed);

        // verify a primary key was assigned
        assertNotNull(incomeUsed.getId());

        // verify set fields are same after save
    }

    public void testGetIncomeUsed() throws Exception {
        IncomeUsed incomeUsed = dao.getIncomeUsed(incomeUsedId);
        assertNotNull(incomeUsed);
    }

    public void testGetIncomeUseds() throws Exception {
        IncomeUsed incomeUsed = new IncomeUsed();

        List results = dao.getIncomeUseds(incomeUsed);
        assertTrue(results.size() > 0);
    }

    public void testSaveIncomeUsed() throws Exception {
        IncomeUsed incomeUsed = dao.getIncomeUsed(incomeUsedId);

        // update required fields

        dao.saveIncomeUsed(incomeUsed);

    }

    public void testRemoveIncomeUsed() throws Exception {
        Long removeId = new Long("3");
        dao.removeIncomeUsed(removeId);
        try {
            dao.getIncomeUsed(removeId);
            fail("incomeUsed found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveIncomeUseds(final Map idList) throws Exception {
        try {
        	dao.removeIncomeUseds(idList);
            fail("incomeUsed found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
