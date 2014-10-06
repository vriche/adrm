
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaAssetsTypeDao;
import com.vriche.adrm.model.OaAssetsType;
import com.vriche.adrm.service.impl.OaAssetsTypeManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaAssetsTypeManagerTest extends BaseManagerTestCase {
    private final String oaAssetsTypeId = "1";
    private OaAssetsTypeManagerImpl oaAssetsTypeManager = new OaAssetsTypeManagerImpl();
    private Mock oaAssetsTypeDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaAssetsTypeDao = new Mock(OaAssetsTypeDao.class);
        oaAssetsTypeManager.setOaAssetsTypeDao((OaAssetsTypeDao) oaAssetsTypeDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaAssetsTypeManager = null;
    }

    public void testGetOaAssetsTypes() throws Exception {
        List results = new ArrayList();
        OaAssetsType oaAssetsType = new OaAssetsType();
        results.add(oaAssetsType);

        // set expected behavior on dao
        oaAssetsTypeDao.expects(once()).method("getOaAssetsTypes")
            .will(returnValue(results));

        List oaAssetsTypes = oaAssetsTypeManager.getOaAssetsTypes(null);
        assertTrue(oaAssetsTypes.size() == 1);
        oaAssetsTypeDao.verify();
    }

    public void testGetOaAssetsType() throws Exception {
        // set expected behavior on dao
        oaAssetsTypeDao.expects(once()).method("getOaAssetsType")
            .will(returnValue(new OaAssetsType()));
        OaAssetsType oaAssetsType = oaAssetsTypeManager.getOaAssetsType(oaAssetsTypeId);
        assertTrue(oaAssetsType != null);
        oaAssetsTypeDao.verify();
    }

    public void testSaveOaAssetsType() throws Exception {
        OaAssetsType oaAssetsType = new OaAssetsType();

        // set expected behavior on dao
        oaAssetsTypeDao.expects(once()).method("saveOaAssetsType")
            .with(same(oaAssetsType)).isVoid();

        oaAssetsTypeManager.saveOaAssetsType(oaAssetsType);
        oaAssetsTypeDao.verify();
    }

    public void testAddAndRemoveOaAssetsType() throws Exception {
        OaAssetsType oaAssetsType = new OaAssetsType();

        // set required fields

        // set expected behavior on dao
        oaAssetsTypeDao.expects(once()).method("saveOaAssetsType")
            .with(same(oaAssetsType)).isVoid();
        oaAssetsTypeManager.saveOaAssetsType(oaAssetsType);
        oaAssetsTypeDao.verify();

        // reset expectations
        oaAssetsTypeDao.reset();

        oaAssetsTypeDao.expects(once()).method("removeOaAssetsType").with(eq(new Long(oaAssetsTypeId)));
        oaAssetsTypeManager.removeOaAssetsType(oaAssetsTypeId);
        oaAssetsTypeDao.verify();

        // reset expectations
        oaAssetsTypeDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaAssetsType.class, oaAssetsType.getId());
        oaAssetsTypeDao.expects(once()).method("removeOaAssetsType").isVoid();
        oaAssetsTypeDao.expects(once()).method("getOaAssetsType").will(throwException(ex));
        oaAssetsTypeManager.removeOaAssetsType(oaAssetsTypeId);
        try {
            oaAssetsTypeManager.getOaAssetsType(oaAssetsTypeId);
            fail("OaAssetsType with identifier '" + oaAssetsTypeId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaAssetsTypeDao.verify();
    }
}
