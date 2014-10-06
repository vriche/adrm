
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.SysResourceDao;
import com.vriche.adrm.model.SysResource;
import com.vriche.adrm.service.impl.SysResourceManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class SysResourceManagerTest extends BaseManagerTestCase {
    private final String sysResourceId = "1";
    private SysResourceManagerImpl sysResourceManager = new SysResourceManagerImpl();
    private Mock sysResourceDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        sysResourceDao = new Mock(SysResourceDao.class);
        sysResourceManager.setSysResourceDao((SysResourceDao) sysResourceDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        sysResourceManager = null;
    }

    public void testGetSysResources() throws Exception {
        List results = new ArrayList();
        SysResource sysResource = new SysResource();
        results.add(sysResource);

        // set expected behavior on dao
        sysResourceDao.expects(once()).method("getSysResources")
            .will(returnValue(results));

        List sysResources = sysResourceManager.getSysResources(null);
        assertTrue(sysResources.size() == 1);
        sysResourceDao.verify();
    }

    public void testGetSysResource() throws Exception {
        // set expected behavior on dao
        sysResourceDao.expects(once()).method("getSysResource")
            .will(returnValue(new SysResource()));
        SysResource sysResource = sysResourceManager.getSysResource(sysResourceId);
        assertTrue(sysResource != null);
        sysResourceDao.verify();
    }

    public void testSaveSysResource() throws Exception {
        SysResource sysResource = new SysResource();

        // set expected behavior on dao
        sysResourceDao.expects(once()).method("saveSysResource")
            .with(same(sysResource)).isVoid();

        sysResourceManager.saveSysResource(sysResource);
        sysResourceDao.verify();
    }

    public void testAddAndRemoveSysResource() throws Exception {
        SysResource sysResource = new SysResource();

        // set required fields

        // set expected behavior on dao
        sysResourceDao.expects(once()).method("saveSysResource")
            .with(same(sysResource)).isVoid();
        sysResourceManager.saveSysResource(sysResource);
        sysResourceDao.verify();

        // reset expectations
        sysResourceDao.reset();

        sysResourceDao.expects(once()).method("removeSysResource").with(eq(new Long(sysResourceId)));
        sysResourceManager.removeSysResource(sysResourceId);
        sysResourceDao.verify();

        // reset expectations
        sysResourceDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(SysResource.class, sysResource.getId());
        sysResourceDao.expects(once()).method("removeSysResource").isVoid();
        sysResourceDao.expects(once()).method("getSysResource").will(throwException(ex));
        sysResourceManager.removeSysResource(sysResourceId);
        try {
            sysResourceManager.getSysResource(sysResourceId);
            fail("SysResource with identifier '" + sysResourceId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        sysResourceDao.verify();
    }
}
