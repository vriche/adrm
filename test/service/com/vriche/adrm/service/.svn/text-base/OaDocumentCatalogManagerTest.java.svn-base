
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaDocumentCatalogDao;
import com.vriche.adrm.model.OaDocumentCatalog;
import com.vriche.adrm.service.impl.OaDocumentCatalogManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaDocumentCatalogManagerTest extends BaseManagerTestCase {
    private final String oaDocumentCatalogId = "1";
    private OaDocumentCatalogManagerImpl oaDocumentCatalogManager = new OaDocumentCatalogManagerImpl();
    private Mock oaDocumentCatalogDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaDocumentCatalogDao = new Mock(OaDocumentCatalogDao.class);
        oaDocumentCatalogManager.setOaDocumentCatalogDao((OaDocumentCatalogDao) oaDocumentCatalogDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaDocumentCatalogManager = null;
    }

    public void testGetOaDocumentCatalogs() throws Exception {
        List results = new ArrayList();
        OaDocumentCatalog oaDocumentCatalog = new OaDocumentCatalog();
        results.add(oaDocumentCatalog);

        // set expected behavior on dao
        oaDocumentCatalogDao.expects(once()).method("getOaDocumentCatalogs")
            .will(returnValue(results));

        List oaDocumentCatalogs = oaDocumentCatalogManager.getOaDocumentCatalogs(null);
        assertTrue(oaDocumentCatalogs.size() == 1);
        oaDocumentCatalogDao.verify();
    }

    public void testGetOaDocumentCatalog() throws Exception {
        // set expected behavior on dao
        oaDocumentCatalogDao.expects(once()).method("getOaDocumentCatalog")
            .will(returnValue(new OaDocumentCatalog()));
        OaDocumentCatalog oaDocumentCatalog = oaDocumentCatalogManager.getOaDocumentCatalog(oaDocumentCatalogId);
        assertTrue(oaDocumentCatalog != null);
        oaDocumentCatalogDao.verify();
    }

    public void testSaveOaDocumentCatalog() throws Exception {
        OaDocumentCatalog oaDocumentCatalog = new OaDocumentCatalog();

        // set expected behavior on dao
        oaDocumentCatalogDao.expects(once()).method("saveOaDocumentCatalog")
            .with(same(oaDocumentCatalog)).isVoid();

        oaDocumentCatalogManager.saveOaDocumentCatalog(oaDocumentCatalog);
        oaDocumentCatalogDao.verify();
    }

    public void testAddAndRemoveOaDocumentCatalog() throws Exception {
        OaDocumentCatalog oaDocumentCatalog = new OaDocumentCatalog();

        // set required fields

        // set expected behavior on dao
        oaDocumentCatalogDao.expects(once()).method("saveOaDocumentCatalog")
            .with(same(oaDocumentCatalog)).isVoid();
        oaDocumentCatalogManager.saveOaDocumentCatalog(oaDocumentCatalog);
        oaDocumentCatalogDao.verify();

        // reset expectations
        oaDocumentCatalogDao.reset();

        oaDocumentCatalogDao.expects(once()).method("removeOaDocumentCatalog").with(eq(new Long(oaDocumentCatalogId)));
        oaDocumentCatalogManager.removeOaDocumentCatalog(oaDocumentCatalogId);
        oaDocumentCatalogDao.verify();

        // reset expectations
        oaDocumentCatalogDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaDocumentCatalog.class, oaDocumentCatalog.getId());
        oaDocumentCatalogDao.expects(once()).method("removeOaDocumentCatalog").isVoid();
        oaDocumentCatalogDao.expects(once()).method("getOaDocumentCatalog").will(throwException(ex));
        oaDocumentCatalogManager.removeOaDocumentCatalog(oaDocumentCatalogId);
        try {
            oaDocumentCatalogManager.getOaDocumentCatalog(oaDocumentCatalogId);
            fail("OaDocumentCatalog with identifier '" + oaDocumentCatalogId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaDocumentCatalogDao.verify();
    }
}
