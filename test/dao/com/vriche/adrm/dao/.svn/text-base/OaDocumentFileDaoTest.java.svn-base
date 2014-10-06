package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaDocumentFile;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaDocumentFileDaoTest extends BaseDaoTestCase {
    private Long oaDocumentFileId = new Long("1");
    private OaDocumentFileDao dao = null;

    public void setOaDocumentFileDao(OaDocumentFileDao dao) {
        this.dao = dao;
    }

    public void testAddOaDocumentFile() throws Exception {
        OaDocumentFile oaDocumentFile = new OaDocumentFile();

        // set required fields

        dao.saveOaDocumentFile(oaDocumentFile);

        // verify a primary key was assigned
        assertNotNull(oaDocumentFile.getId());

        // verify set fields are same after save
    }

    public void testGetOaDocumentFile() throws Exception {
        OaDocumentFile oaDocumentFile = dao.getOaDocumentFile(oaDocumentFileId);
        assertNotNull(oaDocumentFile);
    }

    public void testGetOaDocumentFiles() throws Exception {
        OaDocumentFile oaDocumentFile = new OaDocumentFile();

        List results = dao.getOaDocumentFiles(oaDocumentFile);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaDocumentFile() throws Exception {
        OaDocumentFile oaDocumentFile = dao.getOaDocumentFile(oaDocumentFileId);

        // update required fields

        dao.saveOaDocumentFile(oaDocumentFile);

    }

    public void testRemoveOaDocumentFile() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaDocumentFile(removeId);
        try {
            dao.getOaDocumentFile(removeId);
            fail("oaDocumentFile found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaDocumentFiles(final Map idList) throws Exception {
        try {
        	dao.removeOaDocumentFiles(idList);
            fail("oaDocumentFile found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
