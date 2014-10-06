
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.ContractTargetMonthDao;
import com.vriche.adrm.model.ContractTargetMonth;
import com.vriche.adrm.service.impl.ContractTargetMonthManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class ContractTargetMonthManagerTest extends BaseManagerTestCase {
    private final String contractTargetMonthId = "1";
    private ContractTargetMonthManagerImpl contractTargetMonthManager = new ContractTargetMonthManagerImpl();
    private Mock contractTargetMonthDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        contractTargetMonthDao = new Mock(ContractTargetMonthDao.class);
        contractTargetMonthManager.setContractTargetMonthDao((ContractTargetMonthDao) contractTargetMonthDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        contractTargetMonthManager = null;
    }

    public void testGetContractTargetMonths() throws Exception {
        List results = new ArrayList();
        ContractTargetMonth contractTargetMonth = new ContractTargetMonth();
        results.add(contractTargetMonth);

        // set expected behavior on dao
        contractTargetMonthDao.expects(once()).method("getContractTargetMonths")
            .will(returnValue(results));

        List contractTargetMonths = contractTargetMonthManager.getContractTargetMonths(null);
        assertTrue(contractTargetMonths.size() == 1);
        contractTargetMonthDao.verify();
    }

    public void testGetContractTargetMonth() throws Exception {
        // set expected behavior on dao
        contractTargetMonthDao.expects(once()).method("getContractTargetMonth")
            .will(returnValue(new ContractTargetMonth()));
        ContractTargetMonth contractTargetMonth = contractTargetMonthManager.getContractTargetMonth(contractTargetMonthId);
        assertTrue(contractTargetMonth != null);
        contractTargetMonthDao.verify();
    }

    public void testSaveContractTargetMonth() throws Exception {
        ContractTargetMonth contractTargetMonth = new ContractTargetMonth();

        // set expected behavior on dao
        contractTargetMonthDao.expects(once()).method("saveContractTargetMonth")
            .with(same(contractTargetMonth)).isVoid();

        contractTargetMonthManager.saveContractTargetMonth(contractTargetMonth);
        contractTargetMonthDao.verify();
    }

    public void testAddAndRemoveContractTargetMonth() throws Exception {
        ContractTargetMonth contractTargetMonth = new ContractTargetMonth();

        // set required fields
        contractTargetMonth.setMonthDate(new Integer(1713303787));
        contractTargetMonth.setMonthTarg(new Double(2.427666487640751E307));
        contractTargetMonth.setMonthReal(new Double(1.5175913589198906E308));

        // set expected behavior on dao
        contractTargetMonthDao.expects(once()).method("saveContractTargetMonth")
            .with(same(contractTargetMonth)).isVoid();
        contractTargetMonthManager.saveContractTargetMonth(contractTargetMonth);
        contractTargetMonthDao.verify();

        // reset expectations
        contractTargetMonthDao.reset();

        contractTargetMonthDao.expects(once()).method("removeContractTargetMonth").with(eq(new Long(contractTargetMonthId)));
        contractTargetMonthManager.removeContractTargetMonth(contractTargetMonthId);
        contractTargetMonthDao.verify();

        // reset expectations
        contractTargetMonthDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(ContractTargetMonth.class, contractTargetMonth.getId());
        contractTargetMonthDao.expects(once()).method("removeContractTargetMonth").isVoid();
        contractTargetMonthDao.expects(once()).method("getContractTargetMonth").will(throwException(ex));
        contractTargetMonthManager.removeContractTargetMonth(contractTargetMonthId);
        try {
            contractTargetMonthManager.getContractTargetMonth(contractTargetMonthId);
            fail("ContractTargetMonth with identifier '" + contractTargetMonthId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        contractTargetMonthDao.verify();
    }
}
