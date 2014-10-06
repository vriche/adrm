package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaDocumentCatalogPermitType;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaDocumentCatalogPermitTypeDaoTest extends BaseDaoTestCase {
    private Long oaDocumentCatalogPermitTypeId = new Long("1");
    private OaDocumentCatalogPermitTypeDao dao = null;

    public void setOaDocumentCatalogPermitTypeDao(OaDocumentCatalogPermitTypeDao dao) {
        this.dao = dao;
    }

    public void testAddOaDocumentCatalogPermitType() throws Exception {
        OaDocumentCatalogPermitType oaDocumentCatalogPermitType = new OaDocumentCatalogPermitType();

        // set required fields

        dao.saveOaDocumentCatalogPermitType(oaDocumentCatalogPermitType);

        // verify a primary key was assigned
        assertNotNull(oaDocumentCatalogPermitType.getId());

        // verify set fields are same after save
    }

    public void testGetOaDocumentCatalogPermitType() throws Exception {
        OaDocumentCatalogPermitType oaDocumentCatalogPermitType = dao.getOaDocumentCatalogPermitType(oaDocumentCatalogPermitTypeId);
        assertNotNull(oaDocumentCatalogPermitType);
    }

    public void testGetOaDocumentCatalogPermitTypes() throws Exception {
        OaDocumentCatalogPermitType oaDocumentCatalogPermitType = new OaDocumentCatalogPermitType();

        List results = dao.getOaDocumentCatalogPermitTypes(oaDocumentCatalogPermitType);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaDocumentCatalogPermitType() throws Exception {
        OaDocumentCatalogPermitType oaDocumentCatalogPermitType = dao.getOaDocumentCatalogPermitType(oaDocumentCatalogPermitTypeId);

        // update required fields

        dao.saveOaDocumentCatalogPermitType(oaDocumentCatalogPermitType);

    }

    public void testRemoveOaDocumentCatalogPermitType() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaDocumentCatalogPermitType(removeId);
        try {
            dao.getOaDocumentCatalogPermitType(removeId);
            fail("oaDocumentCatalogPermitType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaDocumentCatalogPermitTypes(final Map idList) throws Exception {
        try {
        	dao.removeOaDocumentCatalogPermitTypes(idList);
            fail("oaDocumentCatalogPermitType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
