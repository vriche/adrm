
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaInfoDao;
import com.vriche.adrm.model.OaInfo;
import com.vriche.adrm.service.impl.OaInfoManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaInfoManagerTest extends BaseManagerTestCase {
    private final String oaInfoId = "1";
    private OaInfoManagerImpl oaInfoManager = new OaInfoManagerImpl();
    private Mock oaInfoDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaInfoDao = new Mock(OaInfoDao.class);
        oaInfoManager.setOaInfoDao((OaInfoDao) oaInfoDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaInfoManager = null;
    }

    public void testGetOaInfos() throws Exception {
        List results = new ArrayList();
        OaInfo oaInfo = new OaInfo();
        results.add(oaInfo);

        // set expected behavior on dao
        oaInfoDao.expects(once()).method("getOaInfos")
            .will(returnValue(results));

        List oaInfos = oaInfoManager.getOaInfos(null);
        assertTrue(oaInfos.size() == 1);
        oaInfoDao.verify();
    }

    public void testGetOaInfo() throws Exception {
        // set expected behavior on dao
        oaInfoDao.expects(once()).method("getOaInfo")
            .will(returnValue(new OaInfo()));
        OaInfo oaInfo = oaInfoManager.getOaInfo(oaInfoId);
        assertTrue(oaInfo != null);
        oaInfoDao.verify();
    }

    public void testSaveOaInfo() throws Exception {
        OaInfo oaInfo = new OaInfo();

        // set expected behavior on dao
        oaInfoDao.expects(once()).method("saveOaInfo")
            .with(same(oaInfo)).isVoid();

        oaInfoManager.saveOaInfo(oaInfo);
        oaInfoDao.verify();
    }

    public void testAddAndRemoveOaInfo() throws Exception {
        OaInfo oaInfo = new OaInfo();

        // set required fields

        // set expected behavior on dao
        oaInfoDao.expects(once()).method("saveOaInfo")
            .with(same(oaInfo)).isVoid();
        oaInfoManager.saveOaInfo(oaInfo);
        oaInfoDao.verify();

        // reset expectations
        oaInfoDao.reset();

        oaInfoDao.expects(once()).method("removeOaInfo").with(eq(new Long(oaInfoId)));
        oaInfoManager.removeOaInfo(oaInfoId);
        oaInfoDao.verify();

        // reset expectations
        oaInfoDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaInfo.class, oaInfo.getId());
        oaInfoDao.expects(once()).method("removeOaInfo").isVoid();
        oaInfoDao.expects(once()).method("getOaInfo").will(throwException(ex));
        oaInfoManager.removeOaInfo(oaInfoId);
        try {
            oaInfoManager.getOaInfo(oaInfoId);
            fail("OaInfo with identifier '" + oaInfoId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaInfoDao.verify();
    }
}
