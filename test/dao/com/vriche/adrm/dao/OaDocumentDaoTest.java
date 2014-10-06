package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaDocument;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaDocumentDaoTest extends BaseDaoTestCase {
    private Long oaDocumentId = new Long("1");
    private OaDocumentDao dao = null;

    public void setOaDocumentDao(OaDocumentDao dao) {
        this.dao = dao;
    }

    public void testAddOaDocument() throws Exception {
        OaDocument oaDocument = new OaDocument();

        // set required fields

        dao.saveOaDocument(oaDocument);

        // verify a primary key was assigned
        assertNotNull(oaDocument.getId());

        // verify set fields are same after save
    }

    public void testGetOaDocument() throws Exception {
        OaDocument oaDocument = dao.getOaDocument(oaDocumentId);
        assertNotNull(oaDocument);
    }

    public void testGetOaDocuments() throws Exception {
        OaDocument oaDocument = new OaDocument();

        List results = dao.getOaDocuments(oaDocument);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaDocument() throws Exception {
        OaDocument oaDocument = dao.getOaDocument(oaDocumentId);

        // update required fields

        dao.saveOaDocument(oaDocument);

    }

    public void testRemoveOaDocument() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaDocument(removeId);
        try {
            dao.getOaDocument(removeId);
            fail("oaDocument found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaDocuments(final Map idList) throws Exception {
        try {
        	dao.removeOaDocuments(idList);
            fail("oaDocument found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
