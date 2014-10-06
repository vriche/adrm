
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.FeedbackInfoDao;
import com.vriche.adrm.model.FeedbackInfo;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.FeedbackInfoManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class FeedbackInfoManagerTest extends BaseManagerTestCase {
    private final String feedbackInfoId = "1";
    private FeedbackInfoManagerImpl feedbackInfoManager = new FeedbackInfoManagerImpl();
    private Mock feedbackInfoDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        feedbackInfoDao = new Mock(FeedbackInfoDao.class);
        feedbackInfoManager.setFeedbackInfoDao((FeedbackInfoDao) feedbackInfoDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        feedbackInfoManager = null;
    }

    public void testGetFeedbackInfos() throws Exception {
        List results = new ArrayList();
        FeedbackInfo feedbackInfo = new FeedbackInfo();
        results.add(feedbackInfo);

        // set expected behavior on dao
        feedbackInfoDao.expects(once()).method("getFeedbackInfos")
            .will(returnValue(results));

        List feedbackInfos = feedbackInfoManager.getFeedbackInfos(null);
        assertTrue(feedbackInfos.size() == 1);
        feedbackInfoDao.verify();
    }

    public void testGetFeedbackInfo() throws Exception {
        // set expected behavior on dao
        feedbackInfoDao.expects(once()).method("getFeedbackInfo")
            .will(returnValue(new FeedbackInfo()));
        FeedbackInfo feedbackInfo = feedbackInfoManager.getFeedbackInfo(feedbackInfoId);
        assertTrue(feedbackInfo != null);
        feedbackInfoDao.verify();
    }

    public void testSaveFeedbackInfo() throws Exception {
        FeedbackInfo feedbackInfo = new FeedbackInfo();

        // set expected behavior on dao
        feedbackInfoDao.expects(once()).method("saveFeedbackInfo")
            .with(same(feedbackInfo)).isVoid();

        feedbackInfoManager.saveFeedbackInfo(feedbackInfo);
        feedbackInfoDao.verify();
    }

    public void testAddAndRemoveFeedbackInfo() throws Exception {
        FeedbackInfo feedbackInfo = new FeedbackInfo();

        // set required fields
        feedbackInfo.setFeedContent("YzXzUbUjNhVeLvUmIhRtWgRcMdFaLbBjYcNbZiAkVyFbZcRwVeCzEnElDbNmGqWaCnMrKlIzDrDtXmWrNoYmJfGfYfPxGcDbPeZsMwHjKkXjLtToKuErFbCpEnHuQdAuVuSiMaNvRdZfBnNfOzFaCpOlTzQcBdFqMxYdYsFmLrGxDmCjZtMoQyLnFcXnUrSlFwTjCnFpKuWfQsNmRyLzXfFoCjUiCuUgWpUpVxGxIjApKnNhUuVoYzVgOkAhFfA");

        // set expected behavior on dao
        feedbackInfoDao.expects(once()).method("saveFeedbackInfo")
            .with(same(feedbackInfo)).isVoid();
        feedbackInfoManager.saveFeedbackInfo(feedbackInfo);
        feedbackInfoDao.verify();

        // reset expectations
        feedbackInfoDao.reset();

        feedbackInfoDao.expects(once()).method("removeFeedbackInfo").with(eq(new Long(feedbackInfoId)));
        feedbackInfoManager.removeFeedbackInfo(feedbackInfoId);
        feedbackInfoDao.verify();

        // reset expectations
        feedbackInfoDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(FeedbackInfo.class, feedbackInfo.getId());
        feedbackInfoDao.expects(once()).method("removeFeedbackInfo").isVoid();
        feedbackInfoDao.expects(once()).method("getFeedbackInfo").will(throwException(ex));
        feedbackInfoManager.removeFeedbackInfo(feedbackInfoId);
        try {
            feedbackInfoManager.getFeedbackInfo(feedbackInfoId);
            fail("FeedbackInfo with identifier '" + feedbackInfoId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        feedbackInfoDao.verify();
    }
}
