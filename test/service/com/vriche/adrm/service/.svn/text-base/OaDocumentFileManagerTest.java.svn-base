
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaDocumentFileDao;
import com.vriche.adrm.model.OaDocumentFile;
import com.vriche.adrm.service.impl.OaDocumentFileManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaDocumentFileManagerTest extends BaseManagerTestCase {
    private final String oaDocumentFileId = "1";
    private OaDocumentFileManagerImpl oaDocumentFileManager = new OaDocumentFileManagerImpl();
    private Mock oaDocumentFileDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaDocumentFileDao = new Mock(OaDocumentFileDao.class);
        oaDocumentFileManager.setOaDocumentFileDao((OaDocumentFileDao) oaDocumentFileDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaDocumentFileManager = null;
    }

    public void testGetOaDocumentFiles() throws Exception {
        List results = new ArrayList();
        OaDocumentFile oaDocumentFile = new OaDocumentFile();
        results.add(oaDocumentFile);

        // set expected behavior on dao
        oaDocumentFileDao.expects(once()).method("getOaDocumentFiles")
            .will(returnValue(results));

        List oaDocumentFiles = oaDocumentFileManager.getOaDocumentFiles(null);
        assertTrue(oaDocumentFiles.size() == 1);
        oaDocumentFileDao.verify();
    }

    public void testGetOaDocumentFile() throws Exception {
        // set expected behavior on dao
        oaDocumentFileDao.expects(once()).method("getOaDocumentFile")
            .will(returnValue(new OaDocumentFile()));
        OaDocumentFile oaDocumentFile = oaDocumentFileManager.getOaDocumentFile(oaDocumentFileId);
        assertTrue(oaDocumentFile != null);
        oaDocumentFileDao.verify();
    }

    public void testSaveOaDocumentFile() throws Exception {
        OaDocumentFile oaDocumentFile = new OaDocumentFile();

        // set expected behavior on dao
        oaDocumentFileDao.expects(once()).method("saveOaDocumentFile")
            .with(same(oaDocumentFile)).isVoid();

        oaDocumentFileManager.saveOaDocumentFile(oaDocumentFile);
        oaDocumentFileDao.verify();
    }

    public void testAddAndRemoveOaDocumentFile() throws Exception {
        OaDocumentFile oaDocumentFile = new OaDocumentFile();

        // set required fields

        // set expected behavior on dao
        oaDocumentFileDao.expects(once()).method("saveOaDocumentFile")
            .with(same(oaDocumentFile)).isVoid();
        oaDocumentFileManager.saveOaDocumentFile(oaDocumentFile);
        oaDocumentFileDao.verify();

        // reset expectations
        oaDocumentFileDao.reset();

        oaDocumentFileDao.expects(once()).method("removeOaDocumentFile").with(eq(new Long(oaDocumentFileId)));
        oaDocumentFileManager.removeOaDocumentFile(oaDocumentFileId);
        oaDocumentFileDao.verify();

        // reset expectations
        oaDocumentFileDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaDocumentFile.class, oaDocumentFile.getId());
        oaDocumentFileDao.expects(once()).method("removeOaDocumentFile").isVoid();
        oaDocumentFileDao.expects(once()).method("getOaDocumentFile").will(throwException(ex));
        oaDocumentFileManager.removeOaDocumentFile(oaDocumentFileId);
        try {
            oaDocumentFileManager.getOaDocumentFile(oaDocumentFileId);
            fail("OaDocumentFile with identifier '" + oaDocumentFileId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaDocumentFileDao.verify();
    }
}
