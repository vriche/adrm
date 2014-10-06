
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaWorkFlowMoveTypeDao;
import com.vriche.adrm.model.OaWorkFlowMoveType;
import com.vriche.adrm.service.impl.OaWorkFlowMoveTypeManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaWorkFlowMoveTypeManagerTest extends BaseManagerTestCase {
    private final String oaWorkFlowMoveTypeId = "1";
    private OaWorkFlowMoveTypeManagerImpl oaWorkFlowMoveTypeManager = new OaWorkFlowMoveTypeManagerImpl();
    private Mock oaWorkFlowMoveTypeDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaWorkFlowMoveTypeDao = new Mock(OaWorkFlowMoveTypeDao.class);
        oaWorkFlowMoveTypeManager.setOaWorkFlowMoveTypeDao((OaWorkFlowMoveTypeDao) oaWorkFlowMoveTypeDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaWorkFlowMoveTypeManager = null;
    }

    public void testGetOaWorkFlowMoveTypes() throws Exception {
        List results = new ArrayList();
        OaWorkFlowMoveType oaWorkFlowMoveType = new OaWorkFlowMoveType();
        results.add(oaWorkFlowMoveType);

        // set expected behavior on dao
        oaWorkFlowMoveTypeDao.expects(once()).method("getOaWorkFlowMoveTypes")
            .will(returnValue(results));

        List oaWorkFlowMoveTypes = oaWorkFlowMoveTypeManager.getOaWorkFlowMoveTypes(null);
        assertTrue(oaWorkFlowMoveTypes.size() == 1);
        oaWorkFlowMoveTypeDao.verify();
    }

    public void testGetOaWorkFlowMoveType() throws Exception {
        // set expected behavior on dao
        oaWorkFlowMoveTypeDao.expects(once()).method("getOaWorkFlowMoveType")
            .will(returnValue(new OaWorkFlowMoveType()));
        OaWorkFlowMoveType oaWorkFlowMoveType = oaWorkFlowMoveTypeManager.getOaWorkFlowMoveType(oaWorkFlowMoveTypeId);
        assertTrue(oaWorkFlowMoveType != null);
        oaWorkFlowMoveTypeDao.verify();
    }

    public void testSaveOaWorkFlowMoveType() throws Exception {
        OaWorkFlowMoveType oaWorkFlowMoveType = new OaWorkFlowMoveType();

        // set expected behavior on dao
        oaWorkFlowMoveTypeDao.expects(once()).method("saveOaWorkFlowMoveType")
            .with(same(oaWorkFlowMoveType)).isVoid();

        oaWorkFlowMoveTypeManager.saveOaWorkFlowMoveType(oaWorkFlowMoveType);
        oaWorkFlowMoveTypeDao.verify();
    }

    public void testAddAndRemoveOaWorkFlowMoveType() throws Exception {
        OaWorkFlowMoveType oaWorkFlowMoveType = new OaWorkFlowMoveType();

        // set required fields

        // set expected behavior on dao
        oaWorkFlowMoveTypeDao.expects(once()).method("saveOaWorkFlowMoveType")
            .with(same(oaWorkFlowMoveType)).isVoid();
        oaWorkFlowMoveTypeManager.saveOaWorkFlowMoveType(oaWorkFlowMoveType);
        oaWorkFlowMoveTypeDao.verify();

        // reset expectations
        oaWorkFlowMoveTypeDao.reset();

        oaWorkFlowMoveTypeDao.expects(once()).method("removeOaWorkFlowMoveType").with(eq(new Long(oaWorkFlowMoveTypeId)));
        oaWorkFlowMoveTypeManager.removeOaWorkFlowMoveType(oaWorkFlowMoveTypeId);
        oaWorkFlowMoveTypeDao.verify();

        // reset expectations
        oaWorkFlowMoveTypeDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaWorkFlowMoveType.class, oaWorkFlowMoveType.getId());
        oaWorkFlowMoveTypeDao.expects(once()).method("removeOaWorkFlowMoveType").isVoid();
        oaWorkFlowMoveTypeDao.expects(once()).method("getOaWorkFlowMoveType").will(throwException(ex));
        oaWorkFlowMoveTypeManager.removeOaWorkFlowMoveType(oaWorkFlowMoveTypeId);
        try {
            oaWorkFlowMoveTypeManager.getOaWorkFlowMoveType(oaWorkFlowMoveTypeId);
            fail("OaWorkFlowMoveType with identifier '" + oaWorkFlowMoveTypeId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaWorkFlowMoveTypeDao.verify();
    }
}
