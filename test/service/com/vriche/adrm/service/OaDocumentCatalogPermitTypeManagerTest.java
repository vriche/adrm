
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaDocumentCatalogPermitTypeDao;
import com.vriche.adrm.model.OaDocumentCatalogPermitType;
import com.vriche.adrm.service.impl.OaDocumentCatalogPermitTypeManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaDocumentCatalogPermitTypeManagerTest extends BaseManagerTestCase {
    private final String oaDocumentCatalogPermitTypeId = "1";
    private OaDocumentCatalogPermitTypeManagerImpl oaDocumentCatalogPermitTypeManager = new OaDocumentCatalogPermitTypeManagerImpl();
    private Mock oaDocumentCatalogPermitTypeDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaDocumentCatalogPermitTypeDao = new Mock(OaDocumentCatalogPermitTypeDao.class);
        oaDocumentCatalogPermitTypeManager.setOaDocumentCatalogPermitTypeDao((OaDocumentCatalogPermitTypeDao) oaDocumentCatalogPermitTypeDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaDocumentCatalogPermitTypeManager = null;
    }

    public void testGetOaDocumentCatalogPermitTypes() throws Exception {
        List results = new ArrayList();
        OaDocumentCatalogPermitType oaDocumentCatalogPermitType = new OaDocumentCatalogPermitType();
        results.add(oaDocumentCatalogPermitType);

        // set expected behavior on dao
        oaDocumentCatalogPermitTypeDao.expects(once()).method("getOaDocumentCatalogPermitTypes")
            .will(returnValue(results));

        List oaDocumentCatalogPermitTypes = oaDocumentCatalogPermitTypeManager.getOaDocumentCatalogPermitTypes(null);
        assertTrue(oaDocumentCatalogPermitTypes.size() == 1);
        oaDocumentCatalogPermitTypeDao.verify();
    }

    public void testGetOaDocumentCatalogPermitType() throws Exception {
        // set expected behavior on dao
        oaDocumentCatalogPermitTypeDao.expects(once()).method("getOaDocumentCatalogPermitType")
            .will(returnValue(new OaDocumentCatalogPermitType()));
        OaDocumentCatalogPermitType oaDocumentCatalogPermitType = oaDocumentCatalogPermitTypeManager.getOaDocumentCatalogPermitType(oaDocumentCatalogPermitTypeId);
        assertTrue(oaDocumentCatalogPermitType != null);
        oaDocumentCatalogPermitTypeDao.verify();
    }

    public void testSaveOaDocumentCatalogPermitType() throws Exception {
        OaDocumentCatalogPermitType oaDocumentCatalogPermitType = new OaDocumentCatalogPermitType();

        // set expected behavior on dao
        oaDocumentCatalogPermitTypeDao.expects(once()).method("saveOaDocumentCatalogPermitType")
            .with(same(oaDocumentCatalogPermitType)).isVoid();

        oaDocumentCatalogPermitTypeManager.saveOaDocumentCatalogPermitType(oaDocumentCatalogPermitType);
        oaDocumentCatalogPermitTypeDao.verify();
    }

    public void testAddAndRemoveOaDocumentCatalogPermitType() throws Exception {
        OaDocumentCatalogPermitType oaDocumentCatalogPermitType = new OaDocumentCatalogPermitType();

        // set required fields

        // set expected behavior on dao
        oaDocumentCatalogPermitTypeDao.expects(once()).method("saveOaDocumentCatalogPermitType")
            .with(same(oaDocumentCatalogPermitType)).isVoid();
        oaDocumentCatalogPermitTypeManager.saveOaDocumentCatalogPermitType(oaDocumentCatalogPermitType);
        oaDocumentCatalogPermitTypeDao.verify();

        // reset expectations
        oaDocumentCatalogPermitTypeDao.reset();

        oaDocumentCatalogPermitTypeDao.expects(once()).method("removeOaDocumentCatalogPermitType").with(eq(new Long(oaDocumentCatalogPermitTypeId)));
        oaDocumentCatalogPermitTypeManager.removeOaDocumentCatalogPermitType(oaDocumentCatalogPermitTypeId);
        oaDocumentCatalogPermitTypeDao.verify();

        // reset expectations
        oaDocumentCatalogPermitTypeDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaDocumentCatalogPermitType.class, oaDocumentCatalogPermitType.getId());
        oaDocumentCatalogPermitTypeDao.expects(once()).method("removeOaDocumentCatalogPermitType").isVoid();
        oaDocumentCatalogPermitTypeDao.expects(once()).method("getOaDocumentCatalogPermitType").will(throwException(ex));
        oaDocumentCatalogPermitTypeManager.removeOaDocumentCatalogPermitType(oaDocumentCatalogPermitTypeId);
        try {
            oaDocumentCatalogPermitTypeManager.getOaDocumentCatalogPermitType(oaDocumentCatalogPermitTypeId);
            fail("OaDocumentCatalogPermitType with identifier '" + oaDocumentCatalogPermitTypeId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaDocumentCatalogPermitTypeDao.verify();
    }
}
