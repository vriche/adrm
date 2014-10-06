
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.PublishMemoDao;
import com.vriche.adrm.model.PublishMemo;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.PublishMemoManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class PublishMemoManagerTest extends BaseManagerTestCase {
    private final String publishMemoId = "1";
    private PublishMemoManagerImpl publishMemoManager = new PublishMemoManagerImpl();
    private Mock publishMemoDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        publishMemoDao = new Mock(PublishMemoDao.class);
        publishMemoManager.setPublishMemoDao((PublishMemoDao) publishMemoDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        publishMemoManager = null;
    }

    public void testGetPublishMemos() throws Exception {
        List results = new ArrayList();
        PublishMemo publishMemo = new PublishMemo();
        results.add(publishMemo);

        // set expected behavior on dao
        publishMemoDao.expects(once()).method("getPublishMemos")
            .will(returnValue(results));

        List publishMemos = publishMemoManager.getPublishMemos(null);
        assertTrue(publishMemos.size() == 1);
        publishMemoDao.verify();
    }

    public void testGetPublishMemo() throws Exception {
        // set expected behavior on dao
        publishMemoDao.expects(once()).method("getPublishMemo")
            .will(returnValue(new PublishMemo()));
        PublishMemo publishMemo = publishMemoManager.getPublishMemo(publishMemoId);
        assertTrue(publishMemo != null);
        publishMemoDao.verify();
    }

    public void testSavePublishMemo() throws Exception {
        PublishMemo publishMemo = new PublishMemo();

        // set expected behavior on dao
        publishMemoDao.expects(once()).method("savePublishMemo")
            .with(same(publishMemo)).isVoid();

        publishMemoManager.savePublishMemo(publishMemo);
        publishMemoDao.verify();
    }

    public void testAddAndRemovePublishMemo() throws Exception {
        PublishMemo publishMemo = new PublishMemo();

        // set required fields

        // set expected behavior on dao
        publishMemoDao.expects(once()).method("savePublishMemo")
            .with(same(publishMemo)).isVoid();
        publishMemoManager.savePublishMemo(publishMemo);
        publishMemoDao.verify();

        // reset expectations
        publishMemoDao.reset();

        publishMemoDao.expects(once()).method("removePublishMemo").with(eq(new Long(publishMemoId)));
        publishMemoManager.removePublishMemo(publishMemoId);
        publishMemoDao.verify();

        // reset expectations
        publishMemoDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(PublishMemo.class, publishMemo.getId());
        publishMemoDao.expects(once()).method("removePublishMemo").isVoid();
        publishMemoDao.expects(once()).method("getPublishMemo").will(throwException(ex));
        publishMemoManager.removePublishMemo(publishMemoId);
        try {
            publishMemoManager.getPublishMemo(publishMemoId);
            fail("PublishMemo with identifier '" + publishMemoId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        publishMemoDao.verify();
    }
}
