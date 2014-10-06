
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.MediaOrgDao;
import com.vriche.adrm.model.MediaOrg;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.MediaOrgManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class MediaOrgManagerTest extends BaseManagerTestCase {
    private final String mediaOrgId = "1";
    private MediaOrgManagerImpl mediaOrgManager = new MediaOrgManagerImpl();
    private Mock mediaOrgDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        mediaOrgDao = new Mock(MediaOrgDao.class);
        mediaOrgManager.setMediaOrgDao((MediaOrgDao) mediaOrgDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        mediaOrgManager = null;
    }

    public void testGetMediaOrgs() throws Exception {
        List results = new ArrayList();
        MediaOrg mediaOrg = new MediaOrg();
        results.add(mediaOrg);

        // set expected behavior on dao
        mediaOrgDao.expects(once()).method("getMediaOrgs")
            .will(returnValue(results));

        List mediaOrgs = mediaOrgManager.getMediaOrgs(null);
        assertTrue(mediaOrgs.size() == 1);
        mediaOrgDao.verify();
    }

    public void testGetMediaOrg() throws Exception {
        // set expected behavior on dao
        mediaOrgDao.expects(once()).method("getMediaOrg")
            .will(returnValue(new MediaOrg()));
        MediaOrg mediaOrg = mediaOrgManager.getMediaOrg(mediaOrgId);
        assertTrue(mediaOrg != null);
        mediaOrgDao.verify();
    }

    public void testSaveMediaOrg() throws Exception {
        MediaOrg mediaOrg = new MediaOrg();

        // set expected behavior on dao
        mediaOrgDao.expects(once()).method("saveMediaOrg")
            .with(same(mediaOrg)).isVoid();

        mediaOrgManager.saveMediaOrg(mediaOrg);
        mediaOrgDao.verify();
    }

    public void testAddAndRemoveMediaOrg() throws Exception {
        MediaOrg mediaOrg = new MediaOrg();

        // set required fields

        // set expected behavior on dao
        mediaOrgDao.expects(once()).method("saveMediaOrg")
            .with(same(mediaOrg)).isVoid();
        mediaOrgManager.saveMediaOrg(mediaOrg);
        mediaOrgDao.verify();

        // reset expectations
        mediaOrgDao.reset();

        mediaOrgDao.expects(once()).method("removeMediaOrg").with(eq(new Long(mediaOrgId)));
        mediaOrgManager.removeMediaOrg(mediaOrgId);
        mediaOrgDao.verify();

        // reset expectations
        mediaOrgDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(MediaOrg.class, mediaOrg.getId());
        mediaOrgDao.expects(once()).method("removeMediaOrg").isVoid();
        mediaOrgDao.expects(once()).method("getMediaOrg").will(throwException(ex));
        mediaOrgManager.removeMediaOrg(mediaOrgId);
        try {
            mediaOrgManager.getMediaOrg(mediaOrgId);
            fail("MediaOrg with identifier '" + mediaOrgId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        mediaOrgDao.verify();
    }
}
