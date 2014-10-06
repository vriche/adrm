
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaProductUsedDao;
import com.vriche.adrm.model.OaProductUsed;
import com.vriche.adrm.service.impl.OaProductUsedManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaProductUsedManagerTest extends BaseManagerTestCase {
    private final String oaProductUsedId = "1";
    private OaProductUsedManagerImpl oaProductUsedManager = new OaProductUsedManagerImpl();
    private Mock oaProductUsedDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaProductUsedDao = new Mock(OaProductUsedDao.class);
        oaProductUsedManager.setOaProductUsedDao((OaProductUsedDao) oaProductUsedDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaProductUsedManager = null;
    }

    public void testGetOaProductUseds() throws Exception {
        List results = new ArrayList();
        OaProductUsed oaProductUsed = new OaProductUsed();
        results.add(oaProductUsed);

        // set expected behavior on dao
        oaProductUsedDao.expects(once()).method("getOaProductUseds")
            .will(returnValue(results));

        List oaProductUseds = oaProductUsedManager.getOaProductUseds(null);
        assertTrue(oaProductUseds.size() == 1);
        oaProductUsedDao.verify();
    }

    public void testGetOaProductUsed() throws Exception {
        // set expected behavior on dao
        oaProductUsedDao.expects(once()).method("getOaProductUsed")
            .will(returnValue(new OaProductUsed()));
        OaProductUsed oaProductUsed = oaProductUsedManager.getOaProductUsed(oaProductUsedId);
        assertTrue(oaProductUsed != null);
        oaProductUsedDao.verify();
    }

    public void testSaveOaProductUsed() throws Exception {
        OaProductUsed oaProductUsed = new OaProductUsed();

        // set expected behavior on dao
        oaProductUsedDao.expects(once()).method("saveOaProductUsed")
            .with(same(oaProductUsed)).isVoid();

        oaProductUsedManager.saveOaProductUsed(oaProductUsed);
        oaProductUsedDao.verify();
    }

    public void testAddAndRemoveOaProductUsed() throws Exception {
        OaProductUsed oaProductUsed = new OaProductUsed();

        // set required fields

        // set expected behavior on dao
        oaProductUsedDao.expects(once()).method("saveOaProductUsed")
            .with(same(oaProductUsed)).isVoid();
        oaProductUsedManager.saveOaProductUsed(oaProductUsed);
        oaProductUsedDao.verify();

        // reset expectations
        oaProductUsedDao.reset();

        oaProductUsedDao.expects(once()).method("removeOaProductUsed").with(eq(new Long(oaProductUsedId)));
        oaProductUsedManager.removeOaProductUsed(oaProductUsedId);
        oaProductUsedDao.verify();

        // reset expectations
        oaProductUsedDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaProductUsed.class, oaProductUsed.getId());
        oaProductUsedDao.expects(once()).method("removeOaProductUsed").isVoid();
        oaProductUsedDao.expects(once()).method("getOaProductUsed").will(throwException(ex));
        oaProductUsedManager.removeOaProductUsed(oaProductUsedId);
        try {
            oaProductUsedManager.getOaProductUsed(oaProductUsedId);
            fail("OaProductUsed with identifier '" + oaProductUsedId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaProductUsedDao.verify();
    }
}
