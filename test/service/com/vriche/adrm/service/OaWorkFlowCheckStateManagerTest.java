
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaWorkFlowCheckStateDao;
import com.vriche.adrm.model.OaWorkFlowCheckState;
import com.vriche.adrm.service.impl.OaWorkFlowCheckStateManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaWorkFlowCheckStateManagerTest extends BaseManagerTestCase {
    private final String oaWorkFlowCheckStateId = "1";
    private OaWorkFlowCheckStateManagerImpl oaWorkFlowCheckStateManager = new OaWorkFlowCheckStateManagerImpl();
    private Mock oaWorkFlowCheckStateDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaWorkFlowCheckStateDao = new Mock(OaWorkFlowCheckStateDao.class);
        oaWorkFlowCheckStateManager.setOaWorkFlowCheckStateDao((OaWorkFlowCheckStateDao) oaWorkFlowCheckStateDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaWorkFlowCheckStateManager = null;
    }

    public void testGetOaWorkFlowCheckStates() throws Exception {
        List results = new ArrayList();
        OaWorkFlowCheckState oaWorkFlowCheckState = new OaWorkFlowCheckState();
        results.add(oaWorkFlowCheckState);

        // set expected behavior on dao
        oaWorkFlowCheckStateDao.expects(once()).method("getOaWorkFlowCheckStates")
            .will(returnValue(results));

        List oaWorkFlowCheckStates = oaWorkFlowCheckStateManager.getOaWorkFlowCheckStates(null);
        assertTrue(oaWorkFlowCheckStates.size() == 1);
        oaWorkFlowCheckStateDao.verify();
    }

    public void testGetOaWorkFlowCheckState() throws Exception {
        // set expected behavior on dao
        oaWorkFlowCheckStateDao.expects(once()).method("getOaWorkFlowCheckState")
            .will(returnValue(new OaWorkFlowCheckState()));
        OaWorkFlowCheckState oaWorkFlowCheckState = oaWorkFlowCheckStateManager.getOaWorkFlowCheckState(oaWorkFlowCheckStateId);
        assertTrue(oaWorkFlowCheckState != null);
        oaWorkFlowCheckStateDao.verify();
    }

    public void testSaveOaWorkFlowCheckState() throws Exception {
        OaWorkFlowCheckState oaWorkFlowCheckState = new OaWorkFlowCheckState();

        // set expected behavior on dao
        oaWorkFlowCheckStateDao.expects(once()).method("saveOaWorkFlowCheckState")
            .with(same(oaWorkFlowCheckState)).isVoid();

        oaWorkFlowCheckStateManager.saveOaWorkFlowCheckState(oaWorkFlowCheckState);
        oaWorkFlowCheckStateDao.verify();
    }

    public void testAddAndRemoveOaWorkFlowCheckState() throws Exception {
        OaWorkFlowCheckState oaWorkFlowCheckState = new OaWorkFlowCheckState();

        // set required fields

        // set expected behavior on dao
        oaWorkFlowCheckStateDao.expects(once()).method("saveOaWorkFlowCheckState")
            .with(same(oaWorkFlowCheckState)).isVoid();
        oaWorkFlowCheckStateManager.saveOaWorkFlowCheckState(oaWorkFlowCheckState);
        oaWorkFlowCheckStateDao.verify();

        // reset expectations
        oaWorkFlowCheckStateDao.reset();

        oaWorkFlowCheckStateDao.expects(once()).method("removeOaWorkFlowCheckState").with(eq(new Long(oaWorkFlowCheckStateId)));
        oaWorkFlowCheckStateManager.removeOaWorkFlowCheckState(oaWorkFlowCheckStateId);
        oaWorkFlowCheckStateDao.verify();

        // reset expectations
        oaWorkFlowCheckStateDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaWorkFlowCheckState.class, oaWorkFlowCheckState.getId());
        oaWorkFlowCheckStateDao.expects(once()).method("removeOaWorkFlowCheckState").isVoid();
        oaWorkFlowCheckStateDao.expects(once()).method("getOaWorkFlowCheckState").will(throwException(ex));
        oaWorkFlowCheckStateManager.removeOaWorkFlowCheckState(oaWorkFlowCheckStateId);
        try {
            oaWorkFlowCheckStateManager.getOaWorkFlowCheckState(oaWorkFlowCheckStateId);
            fail("OaWorkFlowCheckState with identifier '" + oaWorkFlowCheckStateId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaWorkFlowCheckStateDao.verify();
    }
}
