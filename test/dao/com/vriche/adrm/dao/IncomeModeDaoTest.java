package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.IncomeModeDao;
import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.IncomeMode;

import org.springframework.orm.ObjectRetrievalFailureException;

public class IncomeModeDaoTest extends BaseDaoTestCase {
    private Long incomeModeId = new Long("1");
    private IncomeModeDao dao = null;

    public void setIncomeModeDao(IncomeModeDao dao) {
        this.dao = dao;
    }

    public void testAddIncomeMode() throws Exception {
        IncomeMode incomeMode = new IncomeMode();

        // set required fields

        dao.saveIncomeMode(incomeMode);

        // verify a primary key was assigned
        assertNotNull(incomeMode.getId());

        // verify set fields are same after save
    }

    public void testGetIncomeMode() throws Exception {
        IncomeMode incomeMode = dao.getIncomeMode(incomeModeId);
        assertNotNull(incomeMode);
    }

    public void testGetIncomeModes() throws Exception {
        IncomeMode incomeMode = new IncomeMode();

        List results = dao.getIncomeModes(incomeMode);
        assertTrue(results.size() > 0);
    }

    public void testSaveIncomeMode() throws Exception {
        IncomeMode incomeMode = dao.getIncomeMode(incomeModeId);

        // update required fields

        dao.saveIncomeMode(incomeMode);

    }

    public void testRemoveIncomeMode() throws Exception {
        Long removeId = new Long("3");
        dao.removeIncomeMode(removeId);
        try {
            dao.getIncomeMode(removeId);
            fail("incomeMode found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveIncomeModes(final Map idList) throws Exception {
        try {
        	dao.removeIncomeModes(idList);
            fail("incomeMode found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
