
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.CompagesDao;
import com.vriche.adrm.model.Compages;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.CompagesManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class CompagesManagerTest extends BaseManagerTestCase {
    private final String compagesId = "1";
    private CompagesManagerImpl compagesManager = new CompagesManagerImpl();
    private Mock compagesDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        compagesDao = new Mock(CompagesDao.class);
        compagesManager.setCompagesDao((CompagesDao) compagesDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        compagesManager = null;
    }

    public void testGetCompagess() throws Exception {
        List results = new ArrayList();
        Compages compages = new Compages();
        results.add(compages);

        // set expected behavior on dao
        compagesDao.expects(once()).method("getCompagess")
            .will(returnValue(results));

        List compagess = compagesManager.getCompagess(null);
        assertTrue(compagess.size() == 1);
        compagesDao.verify();
    }

    public void testGetCompages() throws Exception {
        // set expected behavior on dao
        compagesDao.expects(once()).method("getCompages")
            .will(returnValue(new Compages()));
        Compages compages = compagesManager.getCompages(compagesId);
        assertTrue(compages != null);
        compagesDao.verify();
    }

    public void testSaveCompages() throws Exception {
        Compages compages = new Compages();

        // set expected behavior on dao
        compagesDao.expects(once()).method("saveCompages")
            .with(same(compages)).isVoid();

        compagesManager.saveCompages(compages);
        compagesDao.verify();
    }

    public void testAddAndRemoveCompages() throws Exception {
        Compages compages = new Compages();

        // set required fields

        // set expected behavior on dao
        compagesDao.expects(once()).method("saveCompages")
            .with(same(compages)).isVoid();
        compagesManager.saveCompages(compages);
        compagesDao.verify();

        // reset expectations
        compagesDao.reset();

        compagesDao.expects(once()).method("removeCompages").with(eq(new Long(compagesId)));
//        compagesManager.removeCompages(compagesId);
        compagesDao.verify();

        // reset expectations
        compagesDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(Compages.class, compages.getId());
        compagesDao.expects(once()).method("removeCompages").isVoid();
        compagesDao.expects(once()).method("getCompages").will(throwException(ex));
//        compagesManager.removeCompages(compagesId);
        try {
            compagesManager.getCompages(compagesId);
            fail("Compages with identifier '" + compagesId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        compagesDao.verify();
    }
}
