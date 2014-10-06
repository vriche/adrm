
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.IncomeDao;
import com.vriche.adrm.model.Income;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.IncomeManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class IncomeManagerTest extends BaseManagerTestCase {
    private final String incomeId = "1";
    private IncomeManagerImpl incomeManager = new IncomeManagerImpl();
    private Mock incomeDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        incomeDao = new Mock(IncomeDao.class);
        incomeManager.setIncomeDao((IncomeDao) incomeDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        incomeManager = null;
    }

    public void testGetIncomes() throws Exception {
        List results = new ArrayList();
        Income income = new Income();
        results.add(income);

        // set expected behavior on dao
        incomeDao.expects(once()).method("getIncomes")
            .will(returnValue(results));

        List incomes = incomeManager.getIncomes(null);
        assertTrue(incomes.size() == 1);
        incomeDao.verify();
    }

    public void testGetIncome() throws Exception {
        // set expected behavior on dao
        incomeDao.expects(once()).method("getIncome")
            .will(returnValue(new Income()));
        Income income = incomeManager.getIncome(incomeId);
        assertTrue(income != null);
        incomeDao.verify();
    }

    public void testSaveIncome() throws Exception {
        Income income = new Income();

        // set expected behavior on dao
        incomeDao.expects(once()).method("saveIncome")
            .with(same(income)).isVoid();

        incomeManager.saveIncome(income);
        incomeDao.verify();
    }

    public void testAddAndRemoveIncome() throws Exception {
        Income income = new Income();

        // set required fields

        // set expected behavior on dao
        incomeDao.expects(once()).method("saveIncome")
            .with(same(income)).isVoid();
        incomeManager.saveIncome(income);
        incomeDao.verify();

        // reset expectations
        incomeDao.reset();

        incomeDao.expects(once()).method("removeIncome").with(eq(new Long(incomeId)));
        incomeManager.removeIncome(incomeId);
        incomeDao.verify();

        // reset expectations
        incomeDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(Income.class, income.getId());
        incomeDao.expects(once()).method("removeIncome").isVoid();
        incomeDao.expects(once()).method("getIncome").will(throwException(ex));
        incomeManager.removeIncome(incomeId);
        try {
            incomeManager.getIncome(incomeId);
            fail("Income with identifier '" + incomeId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        incomeDao.verify();
    }
}
