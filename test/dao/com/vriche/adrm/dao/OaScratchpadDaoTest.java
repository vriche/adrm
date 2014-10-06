package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaScratchpad;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaScratchpadDaoTest extends BaseDaoTestCase {
    private Long oaScratchpadId = new Long("1");
    private OaScratchpadDao dao = null;

    public void setOaScratchpadDao(OaScratchpadDao dao) {
        this.dao = dao;
    }

    public void testAddOaScratchpad() throws Exception {
        OaScratchpad oaScratchpad = new OaScratchpad();

        // set required fields

        dao.saveOaScratchpad(oaScratchpad);

        // verify a primary key was assigned
        assertNotNull(oaScratchpad.getId());

        // verify set fields are same after save
    }

    public void testGetOaScratchpad() throws Exception {
        OaScratchpad oaScratchpad = dao.getOaScratchpad(oaScratchpadId);
        assertNotNull(oaScratchpad);
    }

    public void testGetOaScratchpads() throws Exception {
        OaScratchpad oaScratchpad = new OaScratchpad();

        List results = dao.getOaScratchpads(oaScratchpad);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaScratchpad() throws Exception {
        OaScratchpad oaScratchpad = dao.getOaScratchpad(oaScratchpadId);

        // update required fields

        dao.saveOaScratchpad(oaScratchpad);

    }

    public void testRemoveOaScratchpad() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaScratchpad(removeId);
        try {
            dao.getOaScratchpad(removeId);
            fail("oaScratchpad found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaScratchpads(final Map idList) throws Exception {
        try {
        	dao.removeOaScratchpads(idList);
            fail("oaScratchpad found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
