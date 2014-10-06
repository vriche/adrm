
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaProductInfoDao;
import com.vriche.adrm.model.OaProductInfo;
import com.vriche.adrm.service.impl.OaProductInfoManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaProductInfoManagerTest extends BaseManagerTestCase {
    private final String oaProductInfoId = "1";
    private OaProductInfoManagerImpl oaProductInfoManager = new OaProductInfoManagerImpl();
    private Mock oaProductInfoDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaProductInfoDao = new Mock(OaProductInfoDao.class);
        oaProductInfoManager.setOaProductInfoDao((OaProductInfoDao) oaProductInfoDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaProductInfoManager = null;
    }

    public void testGetOaProductInfos() throws Exception {
        List results = new ArrayList();
        OaProductInfo oaProductInfo = new OaProductInfo();
        results.add(oaProductInfo);

        // set expected behavior on dao
        oaProductInfoDao.expects(once()).method("getOaProductInfos")
            .will(returnValue(results));

        List oaProductInfos = oaProductInfoManager.getOaProductInfos(null);
        assertTrue(oaProductInfos.size() == 1);
        oaProductInfoDao.verify();
    }

    public void testGetOaProductInfo() throws Exception {
        // set expected behavior on dao
        oaProductInfoDao.expects(once()).method("getOaProductInfo")
            .will(returnValue(new OaProductInfo()));
        OaProductInfo oaProductInfo = oaProductInfoManager.getOaProductInfo(oaProductInfoId);
        assertTrue(oaProductInfo != null);
        oaProductInfoDao.verify();
    }

    public void testSaveOaProductInfo() throws Exception {
        OaProductInfo oaProductInfo = new OaProductInfo();

        // set expected behavior on dao
        oaProductInfoDao.expects(once()).method("saveOaProductInfo")
            .with(same(oaProductInfo)).isVoid();

        oaProductInfoManager.saveOaProductInfo(oaProductInfo);
        oaProductInfoDao.verify();
    }

    public void testAddAndRemoveOaProductInfo() throws Exception {
        OaProductInfo oaProductInfo = new OaProductInfo();

        // set required fields

        // set expected behavior on dao
        oaProductInfoDao.expects(once()).method("saveOaProductInfo")
            .with(same(oaProductInfo)).isVoid();
        oaProductInfoManager.saveOaProductInfo(oaProductInfo);
        oaProductInfoDao.verify();

        // reset expectations
        oaProductInfoDao.reset();

        oaProductInfoDao.expects(once()).method("removeOaProductInfo").with(eq(new Long(oaProductInfoId)));
        oaProductInfoManager.removeOaProductInfo(oaProductInfoId);
        oaProductInfoDao.verify();

        // reset expectations
        oaProductInfoDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaProductInfo.class, oaProductInfo.getId());
        oaProductInfoDao.expects(once()).method("removeOaProductInfo").isVoid();
        oaProductInfoDao.expects(once()).method("getOaProductInfo").will(throwException(ex));
        oaProductInfoManager.removeOaProductInfo(oaProductInfoId);
        try {
            oaProductInfoManager.getOaProductInfo(oaProductInfoId);
            fail("OaProductInfo with identifier '" + oaProductInfoId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaProductInfoDao.verify();
    }
}
