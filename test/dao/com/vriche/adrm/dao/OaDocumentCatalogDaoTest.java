package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaDocumentCatalog;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaDocumentCatalogDaoTest extends BaseDaoTestCase {
    private Long oaDocumentCatalogId = new Long("1");
    private OaDocumentCatalogDao dao = null;

    public void setOaDocumentCatalogDao(OaDocumentCatalogDao dao) {
        this.dao = dao;
    }

    public void testAddOaDocumentCatalog() throws Exception {
        OaDocumentCatalog oaDocumentCatalog = new OaDocumentCatalog();

        // set required fields

        dao.saveOaDocumentCatalog(oaDocumentCatalog);

        // verify a primary key was assigned
        assertNotNull(oaDocumentCatalog.getId());

        // verify set fields are same after save
    }

    public void testGetOaDocumentCatalog() throws Exception {
        OaDocumentCatalog oaDocumentCatalog = dao.getOaDocumentCatalog(oaDocumentCatalogId);
        assertNotNull(oaDocumentCatalog);
    }

    public void testGetOaDocumentCatalogs() throws Exception {
        OaDocumentCatalog oaDocumentCatalog = new OaDocumentCatalog();

        List results = dao.getOaDocumentCatalogs(oaDocumentCatalog);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaDocumentCatalog() throws Exception {
        OaDocumentCatalog oaDocumentCatalog = dao.getOaDocumentCatalog(oaDocumentCatalogId);

        // update required fields

        dao.saveOaDocumentCatalog(oaDocumentCatalog);

    }

    public void testRemoveOaDocumentCatalog() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaDocumentCatalog(removeId);
        try {
            dao.getOaDocumentCatalog(removeId);
            fail("oaDocumentCatalog found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaDocumentCatalogs(final Map idList) throws Exception {
        try {
        	dao.removeOaDocumentCatalogs(idList);
            fail("oaDocumentCatalog found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
