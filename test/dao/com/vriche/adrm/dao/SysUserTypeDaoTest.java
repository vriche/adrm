package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.SysUserType;

import org.springframework.orm.ObjectRetrievalFailureException;

public class SysUserTypeDaoTest extends BaseDaoTestCase {
    private Long sysUserTypeId = new Long("1");
    private SysUserTypeDao dao = null;

    public void setSysUserTypeDao(SysUserTypeDao dao) {
        this.dao = dao;
    }

    public void testAddSysUserType() throws Exception {
        SysUserType sysUserType = new SysUserType();

        // set required fields

        dao.saveSysUserType(sysUserType);

        // verify a primary key was assigned
        assertNotNull(sysUserType.getId());

        // verify set fields are same after save
    }

    public void testGetSysUserType() throws Exception {
        SysUserType sysUserType = dao.getSysUserType(sysUserTypeId);
        assertNotNull(sysUserType);
    }

    public void testGetSysUserTypes() throws Exception {
        SysUserType sysUserType = new SysUserType();

        List results = dao.getSysUserTypes(sysUserType);
        assertTrue(results.size() > 0);
    }

    public void testSaveSysUserType() throws Exception {
        SysUserType sysUserType = dao.getSysUserType(sysUserTypeId);

        // update required fields

        dao.saveSysUserType(sysUserType);

    }

    public void testRemoveSysUserType() throws Exception {
        Long removeId = new Long("3");
        dao.removeSysUserType(removeId);
        try {
            dao.getSysUserType(removeId);
            fail("sysUserType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveSysUserTypes(final Map idList) throws Exception {
        try {
        	dao.removeSysUserTypes(idList);
            fail("sysUserType found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
