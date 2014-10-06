
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;

import com.vriche.adrm.dao.SpecificDao;
import com.vriche.adrm.model.Specific;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.SpecificManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class SpecificManagerTest extends BaseManagerTestCase {
    private final String specificId = "1";
    private SpecificManagerImpl specificManager = new SpecificManagerImpl();
    private Mock specificDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        specificDao = new Mock(SpecificDao.class);
        specificManager.setSpecificDao((SpecificDao) specificDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        specificManager = null;
    }

    public void testGetSpecifics() throws Exception {
        List results = new ArrayList();
        Specific specific = new Specific();
        results.add(specific);

        // set expected behavior on dao
        specificDao.expects(once()).method("getSpecifics")
            .will(returnValue(results));

        List specifics = specificManager.getSpecifics(null);
        assertTrue(specifics.size() == 1);
        specificDao.verify();
    }

    public void testGetSpecific() throws Exception {
        // set expected behavior on dao
        specificDao.expects(once()).method("getSpecific")
            .will(returnValue(new Specific()));
        Specific specific = specificManager.getSpecific(specificId);
        assertTrue(specific != null);
        specificDao.verify();
    }

    public void testSaveSpecific() throws Exception {
        Specific specific = new Specific();

        // set expected behavior on dao
        specificDao.expects(once()).method("saveSpecific")
            .with(same(specific)).isVoid();

        specificManager.saveSpecific(specific);
        specificDao.verify();
    }

    public void testAddAndRemoveSpecific() throws Exception {
        Specific specific = new Specific();

        // set required fields

        // set expected behavior on dao
        specificDao.expects(once()).method("saveSpecific")
            .with(same(specific)).isVoid();
        specificManager.saveSpecific(specific);
        specificDao.verify();

        // reset expectations
        specificDao.reset();

        specificDao.expects(once()).method("removeSpecific").with(eq(new Long(specificId)));
        specificManager.removeSpecific(specificId);
        specificDao.verify();

        // reset expectations
        specificDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(Specific.class, specific.getId());
        specificDao.expects(once()).method("removeSpecific").isVoid();
        specificDao.expects(once()).method("getSpecific").will(throwException(ex));
        specificManager.removeSpecific(specificId);
        try {
            specificManager.getSpecific(specificId);
            fail("Specific with identifier '" + specificId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        specificDao.verify();
    }
}
