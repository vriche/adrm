package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.FeedbackInfo;
import com.vriche.adrm.dao.FeedbackInfoDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class FeedbackInfoDaoTest extends BaseDaoTestCase {
    private Long feedbackInfoId = new Long("1");
    private FeedbackInfoDao dao = null;

    public void setFeedbackInfoDao(FeedbackInfoDao dao) {
        this.dao = dao;
    }

    public void testAddFeedbackInfo() throws Exception {
        FeedbackInfo feedbackInfo = new FeedbackInfo();

        // set required fields

        java.lang.String feedContent = "HhGdCkCuZpFpMpTwWjZzQlBfUdCyQyDyIsFnBlTkUjXuYlKqGtGjJyTgDbQwMeRkJtXxPdCnQaEqCgSmVlQuUvZqNfQgBoQeOeCdLsSiTtZfVeXkJcObQiRyAcOfZnClAnViHkDvCpQsUnDtKtFtKbZmKyPuMkFuAfRaMeBoOdRoMkGdElJnQrQtFgWiEbUnGvDvCzIoVrQsPrVbNiOaNoEyZkVwXfVvKlRjFhNsGnDnMhMbZpOmTcNzWvCgZrH";
        feedbackInfo.setFeedContent(feedContent);        

        dao.saveFeedbackInfo(feedbackInfo);

        // verify a primary key was assigned
        assertNotNull(feedbackInfo.getId());

        // verify set fields are same after save
        assertEquals(feedContent, feedbackInfo.getFeedContent());
    }

    public void testGetFeedbackInfo() throws Exception {
        FeedbackInfo feedbackInfo = dao.getFeedbackInfo(feedbackInfoId);
        assertNotNull(feedbackInfo);
    }

    public void testGetFeedbackInfos() throws Exception {
        FeedbackInfo feedbackInfo = new FeedbackInfo();

        List results = dao.getFeedbackInfos(feedbackInfo);
        assertTrue(results.size() > 0);
    }

    public void testSaveFeedbackInfo() throws Exception {
        FeedbackInfo feedbackInfo = dao.getFeedbackInfo(feedbackInfoId);

        // update required fields
        java.lang.String feedContent = "WcTnHgQnHySiNzVhZmAaPuVrRhBlToEpLwVfSwSsRdQjRmDpRvOjIzBcZaGyXkYpIpMwTyKtHxKiTkJaSvHzElRsSmYmMuElTbXgLrJoCfZiBkItPkRqUtGsLfZmTsClYtHoZjRmXsYyKoWaXfTfPfIeSvVzFeXfKaZzTvSsGmDrBeRvEbXlTaZkJsVsFcHzRjUzHrLdIoAxNeJcIhYgNeQzBqHsDdAhGaHgYjUbLsVyVrNsCoWdSaDoLdBzPvU";
        feedbackInfo.setFeedContent(feedContent);        

        dao.saveFeedbackInfo(feedbackInfo);

        assertEquals(feedContent, feedbackInfo.getFeedContent());
    }

    public void testRemoveFeedbackInfo() throws Exception {
        Long removeId = new Long("3");
        dao.removeFeedbackInfo(removeId);
        try {
            dao.getFeedbackInfo(removeId);
            fail("feedbackInfo found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveFeedbackInfos(final Map idList) throws Exception {
        try {
        	dao.removeFeedbackInfos(idList);
            fail("feedbackInfo found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
