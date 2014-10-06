
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaWorkFlowDao;
import com.vriche.adrm.model.OaWorkFlow;
import com.vriche.adrm.service.impl.OaWorkFlowManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaWorkFlowManagerTest extends BaseManagerTestCase {
    private final String oaWorkFlowId = "1";
    private OaWorkFlowManagerImpl oaWorkFlowManager = new OaWorkFlowManagerImpl();
    private Mock oaWorkFlowDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaWorkFlowDao = new Mock(OaWorkFlowDao.class);
        oaWorkFlowManager.setOaWorkFlowDao((OaWorkFlowDao) oaWorkFlowDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaWorkFlowManager = null;
    }

    public void testGetOaWorkFlows() throws Exception {
        List results = new ArrayList();
        OaWorkFlow oaWorkFlow = new OaWorkFlow();
        results.add(oaWorkFlow);

        // set expected behavior on dao
        oaWorkFlowDao.expects(once()).method("getOaWorkFlows")
            .will(returnValue(results));

        List oaWorkFlows = oaWorkFlowManager.getOaWorkFlows(null);
        assertTrue(oaWorkFlows.size() == 1);
        oaWorkFlowDao.verify();
    }

    public void testGetOaWorkFlow() throws Exception {
        // set expected behavior on dao
        oaWorkFlowDao.expects(once()).method("getOaWorkFlow")
            .will(returnValue(new OaWorkFlow()));
        OaWorkFlow oaWorkFlow = oaWorkFlowManager.getOaWorkFlow(oaWorkFlowId);
        assertTrue(oaWorkFlow != null);
        oaWorkFlowDao.verify();
    }

    public void testSaveOaWorkFlow() throws Exception {
        OaWorkFlow oaWorkFlow = new OaWorkFlow();

        // set expected behavior on dao
        oaWorkFlowDao.expects(once()).method("saveOaWorkFlow")
            .with(same(oaWorkFlow)).isVoid();

        oaWorkFlowManager.saveOaWorkFlow(oaWorkFlow);
        oaWorkFlowDao.verify();
    }

    public void testAddAndRemoveOaWorkFlow() throws Exception {
        OaWorkFlow oaWorkFlow = new OaWorkFlow();

        // set required fields

        // set expected behavior on dao
        oaWorkFlowDao.expects(once()).method("saveOaWorkFlow")
            .with(same(oaWorkFlow)).isVoid();
        oaWorkFlowManager.saveOaWorkFlow(oaWorkFlow);
        oaWorkFlowDao.verify();

        // reset expectations
        oaWorkFlowDao.reset();

        oaWorkFlowDao.expects(once()).method("removeOaWorkFlow").with(eq(new Long(oaWorkFlowId)));
        oaWorkFlowManager.removeOaWorkFlow(oaWorkFlowId);
        oaWorkFlowDao.verify();

        // reset expectations
        oaWorkFlowDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaWorkFlow.class, oaWorkFlow.getId());
        oaWorkFlowDao.expects(once()).method("removeOaWorkFlow").isVoid();
        oaWorkFlowDao.expects(once()).method("getOaWorkFlow").will(throwException(ex));
        oaWorkFlowManager.removeOaWorkFlow(oaWorkFlowId);
        try {
            oaWorkFlowManager.getOaWorkFlow(oaWorkFlowId);
            fail("OaWorkFlow with identifier '" + oaWorkFlowId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaWorkFlowDao.verify();
    }
}
