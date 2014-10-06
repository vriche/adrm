package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.MatterType;

import org.springframework.orm.ObjectRetrievalFailureException;

public class MatterTypeDaoTest extends BaseDaoTestCase {
    private Long matterTypeId = new Long("1");
    private MatterTypeDao dao = null;

    public void setMatterTypeDao(MatterTypeDao dao) {
        this.dao = dao;
    }

    public void testAddMatterType() throws Exception {
        MatterType matterType = new MatterType();

        // set required fields

        dao.saveMatterType(matterType);

        // verify a primary key was assigned
        assertNotNull(matterType.getId());

        // verify set fields are same after save
    }

    public void testGetMatterType() throws Exception {
        MatterType matterType = dao.getMatterType(matterTypeId);
        assertNotNull(matterType);
    }

    public void testGetMatterTypes() throws Exception {
        MatterType matterType = new MatterType();

        List results = dao.getMatterTypes(matterType);
        assertTrue(results.size() > 0);
    }

    public void testSaveMatterType() throws Exception {
        MatterType matterType = dao.getMatterType(matterTypeId);

        // update required fields

        dao.saveMatterType(matterType);

    }

    public void testRemoveMatterType() throws Exception {
        Long removeId = new Long("3");
        dao.removeMatterType(removeId);
        try {
            dao.getMatterType(removeId);
            fail("matterType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveMatterTypes(final Map idList) throws Exception {
        try {
        	dao.removeMatterTypes(idList);
            fail("matterType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
