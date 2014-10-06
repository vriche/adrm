
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaWorkFlowTypeDao;
import com.vriche.adrm.model.OaWorkFlowType;
import com.vriche.adrm.service.impl.OaWorkFlowTypeManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaWorkFlowTypeManagerTest extends BaseManagerTestCase {
    private final String oaWorkFlowTypeId = "1";
    private OaWorkFlowTypeManagerImpl oaWorkFlowTypeManager = new OaWorkFlowTypeManagerImpl();
    private Mock oaWorkFlowTypeDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaWorkFlowTypeDao = new Mock(OaWorkFlowTypeDao.class);
        oaWorkFlowTypeManager.setOaWorkFlowTypeDao((OaWorkFlowTypeDao) oaWorkFlowTypeDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaWorkFlowTypeManager = null;
    }

    public void testGetOaWorkFlowTypes() throws Exception {
        List results = new ArrayList();
        OaWorkFlowType oaWorkFlowType = new OaWorkFlowType();
        results.add(oaWorkFlowType);

        // set expected behavior on dao
        oaWorkFlowTypeDao.expects(once()).method("getOaWorkFlowTypes")
            .will(returnValue(results));

        List oaWorkFlowTypes = oaWorkFlowTypeManager.getOaWorkFlowTypes(null);
        assertTrue(oaWorkFlowTypes.size() == 1);
        oaWorkFlowTypeDao.verify();
    }

    public void testGetOaWorkFlowType() throws Exception {
        // set expected behavior on dao
        oaWorkFlowTypeDao.expects(once()).method("getOaWorkFlowType")
            .will(returnValue(new OaWorkFlowType()));
        OaWorkFlowType oaWorkFlowType = oaWorkFlowTypeManager.getOaWorkFlowType(oaWorkFlowTypeId);
        assertTrue(oaWorkFlowType != null);
        oaWorkFlowTypeDao.verify();
    }

    public void testSaveOaWorkFlowType() throws Exception {
        OaWorkFlowType oaWorkFlowType = new OaWorkFlowType();

        // set expected behavior on dao
        oaWorkFlowTypeDao.expects(once()).method("saveOaWorkFlowType")
            .with(same(oaWorkFlowType)).isVoid();

        oaWorkFlowTypeManager.saveOaWorkFlowType(oaWorkFlowType);
        oaWorkFlowTypeDao.verify();
    }

    public void testAddAndRemoveOaWorkFlowType() throws Exception {
        OaWorkFlowType oaWorkFlowType = new OaWorkFlowType();

        // set required fields

        // set expected behavior on dao
        oaWorkFlowTypeDao.expects(once()).method("saveOaWorkFlowType")
            .with(same(oaWorkFlowType)).isVoid();
        oaWorkFlowTypeManager.saveOaWorkFlowType(oaWorkFlowType);
        oaWorkFlowTypeDao.verify();

        // reset expectations
        oaWorkFlowTypeDao.reset();

        oaWorkFlowTypeDao.expects(once()).method("removeOaWorkFlowType").with(eq(new Long(oaWorkFlowTypeId)));
        oaWorkFlowTypeManager.removeOaWorkFlowType(oaWorkFlowTypeId);
        oaWorkFlowTypeDao.verify();

        // reset expectations
        oaWorkFlowTypeDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaWorkFlowType.class, oaWorkFlowType.getId());
        oaWorkFlowTypeDao.expects(once()).method("removeOaWorkFlowType").isVoid();
        oaWorkFlowTypeDao.expects(once()).method("getOaWorkFlowType").will(throwException(ex));
        oaWorkFlowTypeManager.removeOaWorkFlowType(oaWorkFlowTypeId);
        try {
            oaWorkFlowTypeManager.getOaWorkFlowType(oaWorkFlowTypeId);
            fail("OaWorkFlowType with identifier '" + oaWorkFlowTypeId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaWorkFlowTypeDao.verify();
    }
}
