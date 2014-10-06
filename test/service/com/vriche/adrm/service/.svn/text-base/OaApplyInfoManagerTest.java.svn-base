
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaApplyInfoDao;
import com.vriche.adrm.model.OaApplyInfo;
import com.vriche.adrm.service.impl.OaApplyInfoManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaApplyInfoManagerTest extends BaseManagerTestCase {
    private final String oaApplyInfoId = "1";
    private OaApplyInfoManagerImpl oaApplyInfoManager = new OaApplyInfoManagerImpl();
    private Mock oaApplyInfoDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaApplyInfoDao = new Mock(OaApplyInfoDao.class);
        oaApplyInfoManager.setOaApplyInfoDao((OaApplyInfoDao) oaApplyInfoDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaApplyInfoManager = null;
    }

    public void testGetOaApplyInfos() throws Exception {
        List results = new ArrayList();
        OaApplyInfo oaApplyInfo = new OaApplyInfo();
        results.add(oaApplyInfo);

        // set expected behavior on dao
        oaApplyInfoDao.expects(once()).method("getOaApplyInfos")
            .will(returnValue(results));

        List oaApplyInfos = oaApplyInfoManager.getOaApplyInfos(null);
        assertTrue(oaApplyInfos.size() == 1);
        oaApplyInfoDao.verify();
    }

    public void testGetOaApplyInfo() throws Exception {
        // set expected behavior on dao
        oaApplyInfoDao.expects(once()).method("getOaApplyInfo")
            .will(returnValue(new OaApplyInfo()));
        OaApplyInfo oaApplyInfo = oaApplyInfoManager.getOaApplyInfo(oaApplyInfoId);
        assertTrue(oaApplyInfo != null);
        oaApplyInfoDao.verify();
    }

    public void testSaveOaApplyInfo() throws Exception {
        OaApplyInfo oaApplyInfo = new OaApplyInfo();

        // set expected behavior on dao
        oaApplyInfoDao.expects(once()).method("saveOaApplyInfo")
            .with(same(oaApplyInfo)).isVoid();

        oaApplyInfoManager.saveOaApplyInfo(oaApplyInfo);
        oaApplyInfoDao.verify();
    }

    public void testAddAndRemoveOaApplyInfo() throws Exception {
        OaApplyInfo oaApplyInfo = new OaApplyInfo();

        // set required fields

        // set expected behavior on dao
        oaApplyInfoDao.expects(once()).method("saveOaApplyInfo")
            .with(same(oaApplyInfo)).isVoid();
        oaApplyInfoManager.saveOaApplyInfo(oaApplyInfo);
        oaApplyInfoDao.verify();

        // reset expectations
        oaApplyInfoDao.reset();

        oaApplyInfoDao.expects(once()).method("removeOaApplyInfo").with(eq(new Long(oaApplyInfoId)));
        oaApplyInfoManager.removeOaApplyInfo(oaApplyInfoId);
        oaApplyInfoDao.verify();

        // reset expectations
        oaApplyInfoDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaApplyInfo.class, oaApplyInfo.getId());
        oaApplyInfoDao.expects(once()).method("removeOaApplyInfo").isVoid();
        oaApplyInfoDao.expects(once()).method("getOaApplyInfo").will(throwException(ex));
        oaApplyInfoManager.removeOaApplyInfo(oaApplyInfoId);
        try {
            oaApplyInfoManager.getOaApplyInfo(oaApplyInfoId);
            fail("OaApplyInfo with identifier '" + oaApplyInfoId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaApplyInfoDao.verify();
    }
}
