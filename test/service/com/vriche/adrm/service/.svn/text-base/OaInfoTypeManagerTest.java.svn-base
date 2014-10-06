
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaInfoTypeDao;
import com.vriche.adrm.model.OaInfoType;
import com.vriche.adrm.service.impl.OaInfoTypeManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaInfoTypeManagerTest extends BaseManagerTestCase {
    private final String oaInfoTypeId = "1";
    private OaInfoTypeManagerImpl oaInfoTypeManager = new OaInfoTypeManagerImpl();
    private Mock oaInfoTypeDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaInfoTypeDao = new Mock(OaInfoTypeDao.class);
        oaInfoTypeManager.setOaInfoTypeDao((OaInfoTypeDao) oaInfoTypeDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaInfoTypeManager = null;
    }

    public void testGetOaInfoTypes() throws Exception {
        List results = new ArrayList();
        OaInfoType oaInfoType = new OaInfoType();
        results.add(oaInfoType);

        // set expected behavior on dao
        oaInfoTypeDao.expects(once()).method("getOaInfoTypes")
            .will(returnValue(results));

        List oaInfoTypes = oaInfoTypeManager.getOaInfoTypes(null);
        assertTrue(oaInfoTypes.size() == 1);
        oaInfoTypeDao.verify();
    }

    public void testGetOaInfoType() throws Exception {
        // set expected behavior on dao
        oaInfoTypeDao.expects(once()).method("getOaInfoType")
            .will(returnValue(new OaInfoType()));
        OaInfoType oaInfoType = oaInfoTypeManager.getOaInfoType(oaInfoTypeId);
        assertTrue(oaInfoType != null);
        oaInfoTypeDao.verify();
    }

    public void testSaveOaInfoType() throws Exception {
        OaInfoType oaInfoType = new OaInfoType();

        // set expected behavior on dao
        oaInfoTypeDao.expects(once()).method("saveOaInfoType")
            .with(same(oaInfoType)).isVoid();

        oaInfoTypeManager.saveOaInfoType(oaInfoType);
        oaInfoTypeDao.verify();
    }

    public void testAddAndRemoveOaInfoType() throws Exception {
        OaInfoType oaInfoType = new OaInfoType();

        // set required fields

        // set expected behavior on dao
        oaInfoTypeDao.expects(once()).method("saveOaInfoType")
            .with(same(oaInfoType)).isVoid();
        oaInfoTypeManager.saveOaInfoType(oaInfoType);
        oaInfoTypeDao.verify();

        // reset expectations
        oaInfoTypeDao.reset();

        oaInfoTypeDao.expects(once()).method("removeOaInfoType").with(eq(new Long(oaInfoTypeId)));
        oaInfoTypeManager.removeOaInfoType(oaInfoTypeId);
        oaInfoTypeDao.verify();

        // reset expectations
        oaInfoTypeDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaInfoType.class, oaInfoType.getId());
        oaInfoTypeDao.expects(once()).method("removeOaInfoType").isVoid();
        oaInfoTypeDao.expects(once()).method("getOaInfoType").will(throwException(ex));
        oaInfoTypeManager.removeOaInfoType(oaInfoTypeId);
        try {
            oaInfoTypeManager.getOaInfoType(oaInfoTypeId);
            fail("OaInfoType with identifier '" + oaInfoTypeId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaInfoTypeDao.verify();
    }
}
