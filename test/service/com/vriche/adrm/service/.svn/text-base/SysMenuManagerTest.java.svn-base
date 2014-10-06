
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.SysMenuDao;
import com.vriche.adrm.model.SysMenu;
import com.vriche.adrm.service.impl.SysMenuManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class SysMenuManagerTest extends BaseManagerTestCase {
    private final String sysMenuId = "1";
    private SysMenuManagerImpl sysMenuManager = new SysMenuManagerImpl();
    private Mock sysMenuDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        sysMenuDao = new Mock(SysMenuDao.class);
        sysMenuManager.setSysMenuDao((SysMenuDao) sysMenuDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        sysMenuManager = null;
    }

    public void testGetSysMenus() throws Exception {
        List results = new ArrayList();
        SysMenu sysMenu = new SysMenu();
        results.add(sysMenu);

        // set expected behavior on dao
        sysMenuDao.expects(once()).method("getSysMenus")
            .will(returnValue(results));

        List sysMenus = sysMenuManager.getSysMenus(null);
        assertTrue(sysMenus.size() == 1);
        sysMenuDao.verify();
    }

    public void testGetSysMenu() throws Exception {
        // set expected behavior on dao
        sysMenuDao.expects(once()).method("getSysMenu")
            .will(returnValue(new SysMenu()));
        SysMenu sysMenu = sysMenuManager.getSysMenu(sysMenuId);
        assertTrue(sysMenu != null);
        sysMenuDao.verify();
    }

    public void testSaveSysMenu() throws Exception {
        SysMenu sysMenu = new SysMenu();

        // set expected behavior on dao
        sysMenuDao.expects(once()).method("saveSysMenu")
            .with(same(sysMenu)).isVoid();

        sysMenuManager.saveSysMenu(sysMenu);
        sysMenuDao.verify();
    }

    public void testAddAndRemoveSysMenu() throws Exception {
        SysMenu sysMenu = new SysMenu();

        // set required fields
        sysMenu.setName("YnBkUgBeOdTnLtWcKfJwGsZiYiSfZaYo");
        sysMenu.setDisplayNo(new Integer(50160577));

        // set expected behavior on dao
        sysMenuDao.expects(once()).method("saveSysMenu")
            .with(same(sysMenu)).isVoid();
        sysMenuManager.saveSysMenu(sysMenu);
        sysMenuDao.verify();

        // reset expectations
        sysMenuDao.reset();

        sysMenuDao.expects(once()).method("removeSysMenu").with(eq(new Long(sysMenuId)));
        sysMenuManager.removeSysMenu(sysMenuId);
        sysMenuDao.verify();

        // reset expectations
        sysMenuDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(SysMenu.class, sysMenu.getId());
        sysMenuDao.expects(once()).method("removeSysMenu").isVoid();
        sysMenuDao.expects(once()).method("getSysMenu").will(throwException(ex));
        sysMenuManager.removeSysMenu(sysMenuId);
        try {
            sysMenuManager.getSysMenu(sysMenuId);
            fail("SysMenu with identifier '" + sysMenuId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        sysMenuDao.verify();
    }
}
