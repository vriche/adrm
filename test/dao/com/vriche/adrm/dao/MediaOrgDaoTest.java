package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.MediaOrg;
import com.vriche.adrm.dao.MediaOrgDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class MediaOrgDaoTest extends BaseDaoTestCase {
    private Long mediaOrgId = new Long("1");
    private MediaOrgDao dao = null;

    public void setMediaOrgDao(MediaOrgDao dao) {
        this.dao = dao;
    }

    public void testAddMediaOrg() throws Exception {
        MediaOrg mediaOrg = new MediaOrg();

        // set required fields

        dao.saveMediaOrg(mediaOrg);

        // verify a primary key was assigned
        assertNotNull(mediaOrg.getId());

        // verify set fields are same after save
    }

    public void testGetMediaOrg() throws Exception {
        MediaOrg mediaOrg = dao.getMediaOrg(mediaOrgId);
        assertNotNull(mediaOrg);
    }

    public void testGetMediaOrgs() throws Exception {
        MediaOrg mediaOrg = new MediaOrg();

        List results = dao.getMediaOrgs(mediaOrg);
        assertTrue(results.size() > 0);
    }

    public void testSaveMediaOrg() throws Exception {
        MediaOrg mediaOrg = dao.getMediaOrg(mediaOrgId);

        // update required fields

        dao.saveMediaOrg(mediaOrg);

    }

    public void testRemoveMediaOrg() throws Exception {
        Long removeId = new Long("3");
        dao.removeMediaOrg(removeId);
        try {
            dao.getMediaOrg(removeId);
            fail("mediaOrg found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveMediaOrgs(final Map idList) throws Exception {
        try {
        	dao.removeMediaOrgs(idList);
            fail("mediaOrg found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
