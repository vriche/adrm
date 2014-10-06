
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.IncomePurposeDao;
import com.vriche.adrm.model.IncomePurpose;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.IncomePurposeManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class IncomePurposeManagerTest extends BaseManagerTestCase {
    private final String incomePurposeId = "1";
    private IncomePurposeManagerImpl incomePurposeManager = new IncomePurposeManagerImpl();
    private Mock incomePurposeDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        incomePurposeDao = new Mock(IncomePurposeDao.class);
        incomePurposeManager.setIncomePurposeDao((IncomePurposeDao) incomePurposeDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        incomePurposeManager = null;
    }

    public void testGetIncomePurposes() throws Exception {
        List results = new ArrayList();
        IncomePurpose incomePurpose = new IncomePurpose();
        results.add(incomePurpose);

        // set expected behavior on dao
        incomePurposeDao.expects(once()).method("getIncomePurposes")
            .will(returnValue(results));

        List incomePurposes = incomePurposeManager.getIncomePurposes(null);
        assertTrue(incomePurposes.size() == 1);
        incomePurposeDao.verify();
    }

    public void testGetIncomePurpose() throws Exception {
        // set expected behavior on dao
        incomePurposeDao.expects(once()).method("getIncomePurpose")
            .will(returnValue(new IncomePurpose()));
        IncomePurpose incomePurpose = incomePurposeManager.getIncomePurpose(incomePurposeId);
        assertTrue(incomePurpose != null);
        incomePurposeDao.verify();
    }

    public void testSaveIncomePurpose() throws Exception {
        IncomePurpose incomePurpose = new IncomePurpose();

        // set expected behavior on dao
        incomePurposeDao.expects(once()).method("saveIncomePurpose")
            .with(same(incomePurpose)).isVoid();

        incomePurposeManager.saveIncomePurpose(incomePurpose);
        incomePurposeDao.verify();
    }

    public void testAddAndRemoveIncomePurpose() throws Exception {
        IncomePurpose incomePurpose = new IncomePurpose();

        // set required fields

        // set expected behavior on dao
        incomePurposeDao.expects(once()).method("saveIncomePurpose")
            .with(same(incomePurpose)).isVoid();
        incomePurposeManager.saveIncomePurpose(incomePurpose);
        incomePurposeDao.verify();

        // reset expectations
        incomePurposeDao.reset();

        incomePurposeDao.expects(once()).method("removeIncomePurpose").with(eq(new Long(incomePurposeId)));
        incomePurposeManager.removeIncomePurpose(incomePurposeId);
        incomePurposeDao.verify();

        // reset expectations
        incomePurposeDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(IncomePurpose.class, incomePurpose.getId());
        incomePurposeDao.expects(once()).method("removeIncomePurpose").isVoid();
        incomePurposeDao.expects(once()).method("getIncomePurpose").will(throwException(ex));
        incomePurposeManager.removeIncomePurpose(incomePurposeId);
        try {
            incomePurposeManager.getIncomePurpose(incomePurposeId);
            fail("IncomePurpose with identifier '" + incomePurposeId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        incomePurposeDao.verify();
    }
}
