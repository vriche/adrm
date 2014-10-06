
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.PublishedInfoDao;
import com.vriche.adrm.model.PublishedInfo;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.PublishedInfoManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class PublishedInfoManagerTest extends BaseManagerTestCase {
    private final String publishedInfoId = "1";
    private PublishedInfoManagerImpl publishedInfoManager = new PublishedInfoManagerImpl();
    private Mock publishedInfoDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        publishedInfoDao = new Mock(PublishedInfoDao.class);
        publishedInfoManager.setPublishedInfoDao((PublishedInfoDao) publishedInfoDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        publishedInfoManager = null;
    }

    public void testGetPublishedInfos() throws Exception {
        List results = new ArrayList();
        PublishedInfo publishedInfo = new PublishedInfo();
        results.add(publishedInfo);

        // set expected behavior on dao
        publishedInfoDao.expects(once()).method("getPublishedInfos")
            .will(returnValue(results));

        List publishedInfos = publishedInfoManager.getPublishedInfos(null);
        assertTrue(publishedInfos.size() == 1);
        publishedInfoDao.verify();
    }

    public void testGetPublishedInfo() throws Exception {
        // set expected behavior on dao
        publishedInfoDao.expects(once()).method("getPublishedInfo")
            .will(returnValue(new PublishedInfo()));
        PublishedInfo publishedInfo = publishedInfoManager.getPublishedInfo(publishedInfoId);
        assertTrue(publishedInfo != null);
        publishedInfoDao.verify();
    }

    public void testSavePublishedInfo() throws Exception {
        PublishedInfo publishedInfo = new PublishedInfo();

        // set expected behavior on dao
        publishedInfoDao.expects(once()).method("savePublishedInfo")
            .with(same(publishedInfo)).isVoid();

        publishedInfoManager.savePublishedInfo(publishedInfo);
        publishedInfoDao.verify();
    }

    public void testAddAndRemovePublishedInfo() throws Exception {
        PublishedInfo publishedInfo = new PublishedInfo();

        // set required fields

        // set expected behavior on dao
        publishedInfoDao.expects(once()).method("savePublishedInfo")
            .with(same(publishedInfo)).isVoid();
        publishedInfoManager.savePublishedInfo(publishedInfo);
        publishedInfoDao.verify();

        // reset expectations
        publishedInfoDao.reset();

        publishedInfoDao.expects(once()).method("removePublishedInfo").with(eq(new Long(publishedInfoId)));
        publishedInfoManager.removePublishedInfo(publishedInfoId);
        publishedInfoDao.verify();

        // reset expectations
        publishedInfoDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(PublishedInfo.class, publishedInfo.getId());
        publishedInfoDao.expects(once()).method("removePublishedInfo").isVoid();
        publishedInfoDao.expects(once()).method("getPublishedInfo").will(throwException(ex));
        publishedInfoManager.removePublishedInfo(publishedInfoId);
        try {
            publishedInfoManager.getPublishedInfo(publishedInfoId);
            fail("PublishedInfo with identifier '" + publishedInfoId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        publishedInfoDao.verify();
    }
}
