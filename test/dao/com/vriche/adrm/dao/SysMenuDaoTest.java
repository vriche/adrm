package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.SysMenu;

import org.springframework.orm.ObjectRetrievalFailureException;

public class SysMenuDaoTest extends BaseDaoTestCase {
    private Long sysMenuId = new Long("1");
    private SysMenuDao dao = null;

    public void setSysMenuDao(SysMenuDao dao) {
        this.dao = dao;
    }

    public void testAddSysMenu() throws Exception {
        SysMenu sysMenu = new SysMenu();

        // set required fields

        java.lang.String name = "GcVoSaYhJlIaTrUhSqXhOtKmBqUfQgGw";
        sysMenu.setName(name);        

        java.lang.Integer displayNo = new Integer(2077862807);
        sysMenu.setDisplayNo(displayNo);        

        dao.saveSysMenu(sysMenu);

        // verify a primary key was assigned
        assertNotNull(sysMenu.getId());

        // verify set fields are same after save
        assertEquals(name, sysMenu.getName());
        assertEquals(displayNo, sysMenu.getDisplayNo());
    }

    public void testGetSysMenu() throws Exception {
        SysMenu sysMenu = dao.getSysMenu(sysMenuId);
        assertNotNull(sysMenu);
    }

    public void testGetSysMenus() throws Exception {
        SysMenu sysMenu = new SysMenu();

        List results = dao.getSysMenus(sysMenu);
        assertTrue(results.size() > 0);
    }

    public void testSaveSysMenu() throws Exception {
        SysMenu sysMenu = dao.getSysMenu(sysMenuId);

        // update required fields
        java.lang.String name = "WcQpDdApItDgLcItJkLyOdDlBwMwZvYe";
        sysMenu.setName(name);        
        java.lang.Integer displayNo = new Integer(1292062978);
        sysMenu.setDisplayNo(displayNo);        

        dao.saveSysMenu(sysMenu);

        assertEquals(name, sysMenu.getName());
        assertEquals(displayNo, sysMenu.getDisplayNo());
    }

    public void testRemoveSysMenu() throws Exception {
        Long removeId = new Long("3");
        dao.removeSysMenu(removeId);
        try {
            dao.getSysMenu(removeId);
            fail("sysMenu found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveSysMenus(final Map idList) throws Exception {
        try {
        	dao.removeSysMenus(idList);
            fail("sysMenu found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
