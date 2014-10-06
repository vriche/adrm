package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.PublishMemo;
import com.vriche.adrm.dao.PublishMemoDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class PublishMemoDaoTest extends BaseDaoTestCase {
    private Long publishMemoId = new Long("1");
    private PublishMemoDao dao = null;

    public void setPublishMemoDao(PublishMemoDao dao) {
        this.dao = dao;
    }

    public void testAddPublishMemo() throws Exception {
        PublishMemo publishMemo = new PublishMemo();

        // set required fields

        dao.savePublishMemo(publishMemo);

        // verify a primary key was assigned
        assertNotNull(publishMemo.getId());

        // verify set fields are same after save
    }

    public void testGetPublishMemo() throws Exception {
        PublishMemo publishMemo = dao.getPublishMemo(publishMemoId);
        assertNotNull(publishMemo);
    }

    public void testGetPublishMemos() throws Exception {
        PublishMemo publishMemo = new PublishMemo();

        List results = dao.getPublishMemos(publishMemo);
        assertTrue(results.size() > 0);
    }

    public void testSavePublishMemo() throws Exception {
        PublishMemo publishMemo = dao.getPublishMemo(publishMemoId);

        // update required fields

        dao.savePublishMemo(publishMemo);

    }

    public void testRemovePublishMemo() throws Exception {
        Long removeId = new Long("3");
        dao.removePublishMemo(removeId);
        try {
            dao.getPublishMemo(removeId);
            fail("publishMemo found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemovePublishMemos(final Map idList) throws Exception {
        try {
        	dao.removePublishMemos(idList);
            fail("publishMemo found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
