
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.ForetArrearageDao;
import com.vriche.adrm.model.ForetArrearage;
import com.vriche.adrm.service.impl.ForetArrearageManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class ForetArrearageManagerTest extends BaseManagerTestCase {
    private final String foretArrearageId = "1";
    private ForetArrearageManagerImpl foretArrearageManager = new ForetArrearageManagerImpl();
    private Mock foretArrearageDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        foretArrearageDao = new Mock(ForetArrearageDao.class);
        foretArrearageManager.setForetArrearageDao((ForetArrearageDao) foretArrearageDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        foretArrearageManager = null;
    }

    public void testGetForetArrearages() throws Exception {
        List results = new ArrayList();
        ForetArrearage foretArrearage = new ForetArrearage();
        results.add(foretArrearage);

        // set expected behavior on dao
        foretArrearageDao.expects(once()).method("getForetArrearages")
            .will(returnValue(results));

        List foretArrearages = foretArrearageManager.getForetArrearages(null);
        assertTrue(foretArrearages.size() == 1);
        foretArrearageDao.verify();
    }

    public void testGetForetArrearage() throws Exception {
        // set expected behavior on dao
        foretArrearageDao.expects(once()).method("getForetArrearage")
            .will(returnValue(new ForetArrearage()));
        ForetArrearage foretArrearage = foretArrearageManager.getForetArrearage(foretArrearageId);
        assertTrue(foretArrearage != null);
        foretArrearageDao.verify();
    }

    public void testSaveForetArrearage() throws Exception {
        ForetArrearage foretArrearage = new ForetArrearage();

        // set expected behavior on dao
        foretArrearageDao.expects(once()).method("saveForetArrearage")
            .with(same(foretArrearage)).isVoid();

        foretArrearageManager.saveForetArrearage(foretArrearage);
        foretArrearageDao.verify();
    }

    public void testAddAndRemoveForetArrearage() throws Exception {
        ForetArrearage foretArrearage = new ForetArrearage();

        // set required fields
        foretArrearage.setCustomerName("AnHaKlZzBwFnKkBfEtVtFgVmSbNyLzUr");
        foretArrearage.setIncomeCode("XmQnLyXkOvHlSqAbFsXuDxBlIaNbZlNf");
        foretArrearage.setIncomeDate(new Integer(1105819905));
        foretArrearage.setIncomeMode("UcNlAdXnSzZxNsZlQlNdVsMhYvSjSvZi");
        foretArrearage.setIncomeMoney(new Double(1.5662299795121223E308));
        foretArrearage.setIncomePurpose("FgPhTtNhKiVnJcMfPxHlXgAnUaLzNbYf");
        foretArrearage.setPayDate(new Integer(1356964256));
        foretArrearage.setPayMoney(new Double(6.45549203860673E307));
        foretArrearage.setUserName("XbFdBfLaCrYuKzMjAuZsVcYtYsApVjRj");

        // set expected behavior on dao
        foretArrearageDao.expects(once()).method("saveForetArrearage")
            .with(same(foretArrearage)).isVoid();
        foretArrearageManager.saveForetArrearage(foretArrearage);
        foretArrearageDao.verify();

        // reset expectations
        foretArrearageDao.reset();

        foretArrearageDao.expects(once()).method("removeForetArrearage").with(eq(new Long(foretArrearageId)));
        foretArrearageManager.removeForetArrearage(foretArrearageId);
        foretArrearageDao.verify();

        // reset expectations
        foretArrearageDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(ForetArrearage.class, foretArrearage.getId());
        foretArrearageDao.expects(once()).method("removeForetArrearage").isVoid();
        foretArrearageDao.expects(once()).method("getForetArrearage").will(throwException(ex));
        foretArrearageManager.removeForetArrearage(foretArrearageId);
        try {
            foretArrearageManager.getForetArrearage(foretArrearageId);
            fail("ForetArrearage with identifier '" + foretArrearageId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        foretArrearageDao.verify();
    }
}
