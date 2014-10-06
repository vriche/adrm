package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.Matter;
import com.vriche.adrm.dao.MatterDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class MatterDaoTest extends BaseDaoTestCase {
    private Long matterId = new Long("1");
    private MatterDao dao = null;

    public void setMatterDao(MatterDao dao) {
        this.dao = dao;
    }

    public void testAddMatter() throws Exception {
        Matter matter = new Matter();

        // set required fields

        dao.saveMatter(matter);

        // verify a primary key was assigned
        assertNotNull(matter.getId());

        // verify set fields are same after save
    }

    public void testGetMatter() throws Exception {
        Matter matter = dao.getMatter(matterId);
        assertNotNull(matter);
    }

    public void testGetMatters() throws Exception {
        Matter matter = new Matter();

        List results = dao.getMatters(matter);
        assertTrue(results.size() > 0);
    }

    public void testSaveMatter() throws Exception {
        Matter matter = dao.getMatter(matterId);

        // update required fields

        dao.saveMatter(matter);

    }

    public void testRemoveMatter() throws Exception {
        Long removeId = new Long("3");
        dao.removeMatter(removeId);
        try {
            dao.getMatter(removeId);
            fail("matter found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveMatters(final Map idList) throws Exception {
        try {
        	dao.removeMatters(idList);
            fail("matter found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
