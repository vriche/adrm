
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.SysUserTypeDao;
import com.vriche.adrm.model.SysUserType;
import com.vriche.adrm.service.impl.SysUserTypeManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class SysUserTypeManagerTest extends BaseManagerTestCase {
    private final String sysUserTypeId = "1";
    private SysUserTypeManagerImpl sysUserTypeManager = new SysUserTypeManagerImpl();
    private Mock sysUserTypeDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        sysUserTypeDao = new Mock(SysUserTypeDao.class);
        sysUserTypeManager.setSysUserTypeDao((SysUserTypeDao) sysUserTypeDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        sysUserTypeManager = null;
    }

    public void testGetSysUserTypes() throws Exception {
        List results = new ArrayList();
        SysUserType sysUserType = new SysUserType();
        results.add(sysUserType);

        // set expected behavior on dao
        sysUserTypeDao.expects(once()).method("getSysUserTypes")
            .will(returnValue(results));

        List sysUserTypes = sysUserTypeManager.getSysUserTypes(null);
        assertTrue(sysUserTypes.size() == 1);
        sysUserTypeDao.verify();
    }

    public void testGetSysUserType() throws Exception {
        // set expected behavior on dao
        sysUserTypeDao.expects(once()).method("getSysUserType")
            .will(returnValue(new SysUserType()));
        SysUserType sysUserType = sysUserTypeManager.getSysUserType(sysUserTypeId);
        assertTrue(sysUserType != null);
        sysUserTypeDao.verify();
    }

    public void testSaveSysUserType() throws Exception {
        SysUserType sysUserType = new SysUserType();

        // set expected behavior on dao
        sysUserTypeDao.expects(once()).method("saveSysUserType")
            .with(same(sysUserType)).isVoid();

        sysUserTypeManager.saveSysUserType(sysUserType);
        sysUserTypeDao.verify();
    }

    public void testAddAndRemoveSysUserType() throws Exception {
        SysUserType sysUserType = new SysUserType();

        // set required fields

        // set expected behavior on dao
        sysUserTypeDao.expects(once()).method("saveSysUserType")
            .with(same(sysUserType)).isVoid();
        sysUserTypeManager.saveSysUserType(sysUserType);
        sysUserTypeDao.verify();

        // reset expectations
        sysUserTypeDao.reset();

        sysUserTypeDao.expects(once()).method("removeSysUserType").with(eq(new Long(sysUserTypeId)));
        sysUserTypeManager.removeSysUserType(sysUserTypeId);
        sysUserTypeDao.verify();

        // reset expectations
        sysUserTypeDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(SysUserType.class, sysUserType.getId());
        sysUserTypeDao.expects(once()).method("removeSysUserType").isVoid();
        sysUserTypeDao.expects(once()).method("getSysUserType").will(throwException(ex));
        sysUserTypeManager.removeSysUserType(sysUserTypeId);
        try {
            sysUserTypeManager.getSysUserType(sysUserTypeId);
            fail("SysUserType with identifier '" + sysUserTypeId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        sysUserTypeDao.verify();
    }
}
