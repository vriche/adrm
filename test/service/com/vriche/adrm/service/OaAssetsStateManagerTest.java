
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaAssetsStateDao;
import com.vriche.adrm.model.OaAssetsState;
import com.vriche.adrm.service.impl.OaAssetsStateManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaAssetsStateManagerTest extends BaseManagerTestCase {
    private final String oaAssetsStateId = "1";
    private OaAssetsStateManagerImpl oaAssetsStateManager = new OaAssetsStateManagerImpl();
    private Mock oaAssetsStateDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaAssetsStateDao = new Mock(OaAssetsStateDao.class);
        oaAssetsStateManager.setOaAssetsStateDao((OaAssetsStateDao) oaAssetsStateDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaAssetsStateManager = null;
    }

    public void testGetOaAssetsStates() throws Exception {
        List results = new ArrayList();
        OaAssetsState oaAssetsState = new OaAssetsState();
        results.add(oaAssetsState);

        // set expected behavior on dao
        oaAssetsStateDao.expects(once()).method("getOaAssetsStates")
            .will(returnValue(results));

        List oaAssetsStates = oaAssetsStateManager.getOaAssetsStates(null);
        assertTrue(oaAssetsStates.size() == 1);
        oaAssetsStateDao.verify();
    }

    public void testGetOaAssetsState() throws Exception {
        // set expected behavior on dao
        oaAssetsStateDao.expects(once()).method("getOaAssetsState")
            .will(returnValue(new OaAssetsState()));
        OaAssetsState oaAssetsState = oaAssetsStateManager.getOaAssetsState(oaAssetsStateId);
        assertTrue(oaAssetsState != null);
        oaAssetsStateDao.verify();
    }

    public void testSaveOaAssetsState() throws Exception {
        OaAssetsState oaAssetsState = new OaAssetsState();

        // set expected behavior on dao
        oaAssetsStateDao.expects(once()).method("saveOaAssetsState")
            .with(same(oaAssetsState)).isVoid();

        oaAssetsStateManager.saveOaAssetsState(oaAssetsState);
        oaAssetsStateDao.verify();
    }

    public void testAddAndRemoveOaAssetsState() throws Exception {
        OaAssetsState oaAssetsState = new OaAssetsState();

        // set required fields

        // set expected behavior on dao
        oaAssetsStateDao.expects(once()).method("saveOaAssetsState")
            .with(same(oaAssetsState)).isVoid();
        oaAssetsStateManager.saveOaAssetsState(oaAssetsState);
        oaAssetsStateDao.verify();

        // reset expectations
        oaAssetsStateDao.reset();

        oaAssetsStateDao.expects(once()).method("removeOaAssetsState").with(eq(new Long(oaAssetsStateId)));
        oaAssetsStateManager.removeOaAssetsState(oaAssetsStateId);
        oaAssetsStateDao.verify();

        // reset expectations
        oaAssetsStateDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaAssetsState.class, oaAssetsState.getId());
        oaAssetsStateDao.expects(once()).method("removeOaAssetsState").isVoid();
        oaAssetsStateDao.expects(once()).method("getOaAssetsState").will(throwException(ex));
        oaAssetsStateManager.removeOaAssetsState(oaAssetsStateId);
        try {
            oaAssetsStateManager.getOaAssetsState(oaAssetsStateId);
            fail("OaAssetsState with identifier '" + oaAssetsStateId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaAssetsStateDao.verify();
    }
}
