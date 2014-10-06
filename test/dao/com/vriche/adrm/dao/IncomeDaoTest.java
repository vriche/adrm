package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.IncomeDao;
import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.Income;

import org.springframework.orm.ObjectRetrievalFailureException;


public class IncomeDaoTest extends BaseDaoTestCase {
    private Long incomeId = new Long("1");
    private IncomeDao dao = null;

    public void setIncomeDao(IncomeDao dao) {
        this.dao = dao;
    }

    public void testAddIncome() throws Exception {
        Income income = new Income();

        // set required fields

        dao.saveIncome(income);

        // verify a primary key was assigned
        assertNotNull(income.getId());

        // verify set fields are same after save
    }

    public void testGetIncome() throws Exception {
        Income income = dao.getIncome(incomeId);
        assertNotNull(income);
    }

    public void testGetIncomes() throws Exception {
        Income income = new Income();

        List results = dao.getIncomes(income);
        assertTrue(results.size() > 0);
    }

    public void testSaveIncome() throws Exception {
        Income income = dao.getIncome(incomeId);

        // update required fields

        dao.saveIncome(income);

    }

    public void testRemoveIncome() throws Exception {
        Long removeId = new Long("3");
        dao.removeIncome(removeId);
        try {
            dao.getIncome(removeId);
            fail("income found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveIncomes(final Map idList) throws Exception {
        try {
        	dao.removeIncomes(idList);
            fail("income found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
