package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.SysResource;

import org.springframework.orm.ObjectRetrievalFailureException;

public class SysResourceDaoTest extends BaseDaoTestCase {
    private Long sysResourceId = new Long("1");
    private SysResourceDao dao = null;

    public void setSysResourceDao(SysResourceDao dao) {
        this.dao = dao;
    }

    public void testAddSysResource() throws Exception {
        SysResource sysResource = new SysResource();

        // set required fields

        dao.saveSysResource(sysResource);

        // verify a primary key was assigned
        assertNotNull(sysResource.getId());

        // verify set fields are same after save
    }

    public void testGetSysResource() throws Exception {
        SysResource sysResource = dao.getSysResource(sysResourceId);
        assertNotNull(sysResource);
    }

    public void testGetSysResources() throws Exception {
        SysResource sysResource = new SysResource();

        List results = dao.getSysResources(sysResource);
        assertTrue(results.size() > 0);
    }

    public void testSaveSysResource() throws Exception {
        SysResource sysResource = dao.getSysResource(sysResourceId);

        // update required fields

        dao.saveSysResource(sysResource);

    }

    public void testRemoveSysResource() throws Exception {
        Long removeId = new Long("3");
        dao.removeSysResource(removeId);
        try {
            dao.getSysResource(removeId);
            fail("sysResource found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveSysResources(final Map idList) throws Exception {
        try {
        	dao.removeSysResources(idList);
            fail("sysResource found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
