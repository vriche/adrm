
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaProductTypeDao;
import com.vriche.adrm.model.OaProductType;
import com.vriche.adrm.service.impl.OaProductTypeManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaProductTypeManagerTest extends BaseManagerTestCase {
    private final String oaProductTypeId = "1";
    private OaProductTypeManagerImpl oaProductTypeManager = new OaProductTypeManagerImpl();
    private Mock oaProductTypeDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaProductTypeDao = new Mock(OaProductTypeDao.class);
        oaProductTypeManager.setOaProductTypeDao((OaProductTypeDao) oaProductTypeDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaProductTypeManager = null;
    }

    public void testGetOaProductTypes() throws Exception {
        List results = new ArrayList();
        OaProductType oaProductType = new OaProductType();
        results.add(oaProductType);

        // set expected behavior on dao
        oaProductTypeDao.expects(once()).method("getOaProductTypes")
            .will(returnValue(results));

        List oaProductTypes = oaProductTypeManager.getOaProductTypes(null);
        assertTrue(oaProductTypes.size() == 1);
        oaProductTypeDao.verify();
    }

    public void testGetOaProductType() throws Exception {
        // set expected behavior on dao
        oaProductTypeDao.expects(once()).method("getOaProductType")
            .will(returnValue(new OaProductType()));
        OaProductType oaProductType = oaProductTypeManager.getOaProductType(oaProductTypeId);
        assertTrue(oaProductType != null);
        oaProductTypeDao.verify();
    }

    public void testSaveOaProductType() throws Exception {
        OaProductType oaProductType = new OaProductType();

        // set expected behavior on dao
        oaProductTypeDao.expects(once()).method("saveOaProductType")
            .with(same(oaProductType)).isVoid();

        oaProductTypeManager.saveOaProductType(oaProductType);
        oaProductTypeDao.verify();
    }

    public void testAddAndRemoveOaProductType() throws Exception {
        OaProductType oaProductType = new OaProductType();

        // set required fields

        // set expected behavior on dao
        oaProductTypeDao.expects(once()).method("saveOaProductType")
            .with(same(oaProductType)).isVoid();
        oaProductTypeManager.saveOaProductType(oaProductType);
        oaProductTypeDao.verify();

        // reset expectations
        oaProductTypeDao.reset();

        oaProductTypeDao.expects(once()).method("removeOaProductType").with(eq(new Long(oaProductTypeId)));
        oaProductTypeManager.removeOaProductType(oaProductTypeId);
        oaProductTypeDao.verify();

        // reset expectations
        oaProductTypeDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaProductType.class, oaProductType.getId());
        oaProductTypeDao.expects(once()).method("removeOaProductType").isVoid();
        oaProductTypeDao.expects(once()).method("getOaProductType").will(throwException(ex));
        oaProductTypeManager.removeOaProductType(oaProductTypeId);
        try {
            oaProductTypeManager.getOaProductType(oaProductTypeId);
            fail("OaProductType with identifier '" + oaProductTypeId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaProductTypeDao.verify();
    }
}
