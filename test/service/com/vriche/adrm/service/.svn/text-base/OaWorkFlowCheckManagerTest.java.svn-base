
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaWorkFlowCheckDao;
import com.vriche.adrm.model.OaWorkFlowCheck;
import com.vriche.adrm.service.impl.OaWorkFlowCheckManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaWorkFlowCheckManagerTest extends BaseManagerTestCase {
    private final String oaWorkFlowCheckId = "1";
    private OaWorkFlowCheckManagerImpl oaWorkFlowCheckManager = new OaWorkFlowCheckManagerImpl();
    private Mock oaWorkFlowCheckDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaWorkFlowCheckDao = new Mock(OaWorkFlowCheckDao.class);
        oaWorkFlowCheckManager.setOaWorkFlowCheckDao((OaWorkFlowCheckDao) oaWorkFlowCheckDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaWorkFlowCheckManager = null;
    }

    public void testGetOaWorkFlowChecks() throws Exception {
        List results = new ArrayList();
        OaWorkFlowCheck oaWorkFlowCheck = new OaWorkFlowCheck();
        results.add(oaWorkFlowCheck);

        // set expected behavior on dao
        oaWorkFlowCheckDao.expects(once()).method("getOaWorkFlowChecks")
            .will(returnValue(results));

        List oaWorkFlowChecks = oaWorkFlowCheckManager.getOaWorkFlowChecks(null);
        assertTrue(oaWorkFlowChecks.size() == 1);
        oaWorkFlowCheckDao.verify();
    }

    public void testGetOaWorkFlowCheck() throws Exception {
        // set expected behavior on dao
        oaWorkFlowCheckDao.expects(once()).method("getOaWorkFlowCheck")
            .will(returnValue(new OaWorkFlowCheck()));
        OaWorkFlowCheck oaWorkFlowCheck = oaWorkFlowCheckManager.getOaWorkFlowCheck(oaWorkFlowCheckId);
        assertTrue(oaWorkFlowCheck != null);
        oaWorkFlowCheckDao.verify();
    }

    public void testSaveOaWorkFlowCheck() throws Exception {
        OaWorkFlowCheck oaWorkFlowCheck = new OaWorkFlowCheck();

        // set expected behavior on dao
        oaWorkFlowCheckDao.expects(once()).method("saveOaWorkFlowCheck")
            .with(same(oaWorkFlowCheck)).isVoid();

        oaWorkFlowCheckManager.saveOaWorkFlowCheck(oaWorkFlowCheck);
        oaWorkFlowCheckDao.verify();
    }

    public void testAddAndRemoveOaWorkFlowCheck() throws Exception {
        OaWorkFlowCheck oaWorkFlowCheck = new OaWorkFlowCheck();

        // set required fields

        // set expected behavior on dao
        oaWorkFlowCheckDao.expects(once()).method("saveOaWorkFlowCheck")
            .with(same(oaWorkFlowCheck)).isVoid();
        oaWorkFlowCheckManager.saveOaWorkFlowCheck(oaWorkFlowCheck);
        oaWorkFlowCheckDao.verify();

        // reset expectations
        oaWorkFlowCheckDao.reset();

        oaWorkFlowCheckDao.expects(once()).method("removeOaWorkFlowCheck").with(eq(new Long(oaWorkFlowCheckId)));
        oaWorkFlowCheckManager.removeOaWorkFlowCheck(oaWorkFlowCheckId);
        oaWorkFlowCheckDao.verify();

        // reset expectations
        oaWorkFlowCheckDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaWorkFlowCheck.class, oaWorkFlowCheck.getId());
        oaWorkFlowCheckDao.expects(once()).method("removeOaWorkFlowCheck").isVoid();
        oaWorkFlowCheckDao.expects(once()).method("getOaWorkFlowCheck").will(throwException(ex));
        oaWorkFlowCheckManager.removeOaWorkFlowCheck(oaWorkFlowCheckId);
        try {
            oaWorkFlowCheckManager.getOaWorkFlowCheck(oaWorkFlowCheckId);
            fail("OaWorkFlowCheck with identifier '" + oaWorkFlowCheckId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaWorkFlowCheckDao.verify();
    }
}
