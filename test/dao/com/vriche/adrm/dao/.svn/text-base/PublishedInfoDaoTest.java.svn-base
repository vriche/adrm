package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.PublishedInfo;
import com.vriche.adrm.dao.PublishedInfoDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class PublishedInfoDaoTest extends BaseDaoTestCase {
    private Long publishedInfoId = new Long("1");
    private PublishedInfoDao dao = null;

    public void setPublishedInfoDao(PublishedInfoDao dao) {
        this.dao = dao;
    }

    public void testAddPublishedInfo() throws Exception {
        PublishedInfo publishedInfo = new PublishedInfo();

        // set required fields

        dao.savePublishedInfo(publishedInfo);

        // verify a primary key was assigned
        assertNotNull(publishedInfo.getId());

        // verify set fields are same after save
    }

    public void testGetPublishedInfo() throws Exception {
        PublishedInfo publishedInfo = dao.getPublishedInfo(publishedInfoId);
        assertNotNull(publishedInfo);
    }

    public void testGetPublishedInfos() throws Exception {
        PublishedInfo publishedInfo = new PublishedInfo();

        List results = dao.getPublishedInfos(publishedInfo);
        assertTrue(results.size() > 0);
    }

    public void testSavePublishedInfo() throws Exception {
        PublishedInfo publishedInfo = dao.getPublishedInfo(publishedInfoId);

        // update required fields

        dao.savePublishedInfo(publishedInfo);

    }

    public void testRemovePublishedInfo() throws Exception {
        Long removeId = new Long("3");
        dao.removePublishedInfo(removeId);
        try {
            dao.getPublishedInfo(removeId);
            fail("publishedInfo found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemovePublishedInfos(final Map idList) throws Exception {
        try {
        	dao.removePublishedInfos(idList);
            fail("publishedInfo found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
