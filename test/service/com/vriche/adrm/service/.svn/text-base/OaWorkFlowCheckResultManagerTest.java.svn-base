
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaWorkFlowCheckResultDao;
import com.vriche.adrm.model.OaWorkFlowCheckResult;
import com.vriche.adrm.service.impl.OaWorkFlowCheckResultManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaWorkFlowCheckResultManagerTest extends BaseManagerTestCase {
    private final String oaWorkFlowCheckResultId = "1";
    private OaWorkFlowCheckResultManagerImpl oaWorkFlowCheckResultManager = new OaWorkFlowCheckResultManagerImpl();
    private Mock oaWorkFlowCheckResultDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaWorkFlowCheckResultDao = new Mock(OaWorkFlowCheckResultDao.class);
        oaWorkFlowCheckResultManager.setOaWorkFlowCheckResultDao((OaWorkFlowCheckResultDao) oaWorkFlowCheckResultDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaWorkFlowCheckResultManager = null;
    }

    public void testGetOaWorkFlowCheckResults() throws Exception {
        List results = new ArrayList();
        OaWorkFlowCheckResult oaWorkFlowCheckResult = new OaWorkFlowCheckResult();
        results.add(oaWorkFlowCheckResult);

        // set expected behavior on dao
        oaWorkFlowCheckResultDao.expects(once()).method("getOaWorkFlowCheckResults")
            .will(returnValue(results));

        List oaWorkFlowCheckResults = oaWorkFlowCheckResultManager.getOaWorkFlowCheckResults(null);
        assertTrue(oaWorkFlowCheckResults.size() == 1);
        oaWorkFlowCheckResultDao.verify();
    }

    public void testGetOaWorkFlowCheckResult() throws Exception {
        // set expected behavior on dao
        oaWorkFlowCheckResultDao.expects(once()).method("getOaWorkFlowCheckResult")
            .will(returnValue(new OaWorkFlowCheckResult()));
        OaWorkFlowCheckResult oaWorkFlowCheckResult = oaWorkFlowCheckResultManager.getOaWorkFlowCheckResult(oaWorkFlowCheckResultId);
        assertTrue(oaWorkFlowCheckResult != null);
        oaWorkFlowCheckResultDao.verify();
    }

    public void testSaveOaWorkFlowCheckResult() throws Exception {
        OaWorkFlowCheckResult oaWorkFlowCheckResult = new OaWorkFlowCheckResult();

        // set expected behavior on dao
        oaWorkFlowCheckResultDao.expects(once()).method("saveOaWorkFlowCheckResult")
            .with(same(oaWorkFlowCheckResult)).isVoid();

        oaWorkFlowCheckResultManager.saveOaWorkFlowCheckResult(oaWorkFlowCheckResult);
        oaWorkFlowCheckResultDao.verify();
    }

    public void testAddAndRemoveOaWorkFlowCheckResult() throws Exception {
        OaWorkFlowCheckResult oaWorkFlowCheckResult = new OaWorkFlowCheckResult();

        // set required fields

        // set expected behavior on dao
        oaWorkFlowCheckResultDao.expects(once()).method("saveOaWorkFlowCheckResult")
            .with(same(oaWorkFlowCheckResult)).isVoid();
        oaWorkFlowCheckResultManager.saveOaWorkFlowCheckResult(oaWorkFlowCheckResult);
        oaWorkFlowCheckResultDao.verify();

        // reset expectations
        oaWorkFlowCheckResultDao.reset();

        oaWorkFlowCheckResultDao.expects(once()).method("removeOaWorkFlowCheckResult").with(eq(new Long(oaWorkFlowCheckResultId)));
        oaWorkFlowCheckResultManager.removeOaWorkFlowCheckResult(oaWorkFlowCheckResultId);
        oaWorkFlowCheckResultDao.verify();

        // reset expectations
        oaWorkFlowCheckResultDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaWorkFlowCheckResult.class, oaWorkFlowCheckResult.getId());
        oaWorkFlowCheckResultDao.expects(once()).method("removeOaWorkFlowCheckResult").isVoid();
        oaWorkFlowCheckResultDao.expects(once()).method("getOaWorkFlowCheckResult").will(throwException(ex));
        oaWorkFlowCheckResultManager.removeOaWorkFlowCheckResult(oaWorkFlowCheckResultId);
        try {
            oaWorkFlowCheckResultManager.getOaWorkFlowCheckResult(oaWorkFlowCheckResultId);
            fail("OaWorkFlowCheckResult with identifier '" + oaWorkFlowCheckResultId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaWorkFlowCheckResultDao.verify();
    }
}
