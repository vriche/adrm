
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaDocumentDao;
import com.vriche.adrm.model.OaDocument;
import com.vriche.adrm.service.impl.OaDocumentManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaDocumentManagerTest extends BaseManagerTestCase {
    private final String oaDocumentId = "1";
    private OaDocumentManagerImpl oaDocumentManager = new OaDocumentManagerImpl();
    private Mock oaDocumentDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaDocumentDao = new Mock(OaDocumentDao.class);
        oaDocumentManager.setOaDocumentDao((OaDocumentDao) oaDocumentDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaDocumentManager = null;
    }

    public void testGetOaDocuments() throws Exception {
        List results = new ArrayList();
        OaDocument oaDocument = new OaDocument();
        results.add(oaDocument);

        // set expected behavior on dao
        oaDocumentDao.expects(once()).method("getOaDocuments")
            .will(returnValue(results));

        List oaDocuments = oaDocumentManager.getOaDocuments(null);
        assertTrue(oaDocuments.size() == 1);
        oaDocumentDao.verify();
    }

    public void testGetOaDocument() throws Exception {
        // set expected behavior on dao
        oaDocumentDao.expects(once()).method("getOaDocument")
            .will(returnValue(new OaDocument()));
        OaDocument oaDocument = oaDocumentManager.getOaDocument(oaDocumentId);
        assertTrue(oaDocument != null);
        oaDocumentDao.verify();
    }

    public void testSaveOaDocument() throws Exception {
        OaDocument oaDocument = new OaDocument();

        // set expected behavior on dao
        oaDocumentDao.expects(once()).method("saveOaDocument")
            .with(same(oaDocument)).isVoid();

        oaDocumentManager.saveOaDocument(oaDocument);
        oaDocumentDao.verify();
    }

    public void testAddAndRemoveOaDocument() throws Exception {
        OaDocument oaDocument = new OaDocument();

        // set required fields

        // set expected behavior on dao
        oaDocumentDao.expects(once()).method("saveOaDocument")
            .with(same(oaDocument)).isVoid();
        oaDocumentManager.saveOaDocument(oaDocument);
        oaDocumentDao.verify();

        // reset expectations
        oaDocumentDao.reset();

        oaDocumentDao.expects(once()).method("removeOaDocument").with(eq(new Long(oaDocumentId)));
        oaDocumentManager.removeOaDocument(oaDocumentId);
        oaDocumentDao.verify();

        // reset expectations
        oaDocumentDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaDocument.class, oaDocument.getId());
        oaDocumentDao.expects(once()).method("removeOaDocument").isVoid();
        oaDocumentDao.expects(once()).method("getOaDocument").will(throwException(ex));
        oaDocumentManager.removeOaDocument(oaDocumentId);
        try {
            oaDocumentManager.getOaDocument(oaDocumentId);
            fail("OaDocument with identifier '" + oaDocumentId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaDocumentDao.verify();
    }
}
