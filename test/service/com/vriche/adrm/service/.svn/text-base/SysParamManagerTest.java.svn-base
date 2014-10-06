
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.SysParamDao;
import com.vriche.adrm.model.SysParam;
import com.vriche.adrm.service.impl.SysParamManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class SysParamManagerTest extends BaseManagerTestCase {
    private final String sysParamId = "1";
    private SysParamManagerImpl sysParamManager = new SysParamManagerImpl();
    private Mock sysParamDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        sysParamDao = new Mock(SysParamDao.class);
        sysParamManager.setSysParamDao((SysParamDao) sysParamDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        sysParamManager = null;
    }

    public void testGetSysParams() throws Exception {
        List results = new ArrayList();
        SysParam sysParam = new SysParam();
        results.add(sysParam);

        // set expected behavior on dao
        sysParamDao.expects(once()).method("getSysParams")
            .will(returnValue(results));

        List sysParams = sysParamManager.getSysParams(null);
        assertTrue(sysParams.size() == 1);
        sysParamDao.verify();
    }

    public void testGetSysParam() throws Exception {
        // set expected behavior on dao
        sysParamDao.expects(once()).method("getSysParam")
            .will(returnValue(new SysParam()));
        SysParam sysParam = sysParamManager.getSysParam(sysParamId);
        assertTrue(sysParam != null);
        sysParamDao.verify();
    }

    public void testSaveSysParam() throws Exception {
        SysParam sysParam = new SysParam();

        // set expected behavior on dao
        sysParamDao.expects(once()).method("saveSysParam")
            .with(same(sysParam)).isVoid();

        sysParamManager.saveSysParam(sysParam);
        sysParamDao.verify();
    }

    public void testAddAndRemoveSysParam() throws Exception {
        SysParam sysParam = new SysParam();

        // set required fields
        sysParam.setName("VgRzEeBwNoLyLkLqTjQyGaRsLcZzThGyVaZnUvFzXxQoNeLpVqQoUeCjMxQiGxXvOtMgPrXkPiRkNcDoHdJkXpIbJhVwXvRhJnQmNgSzCqXhWrSyFkTnRgPgPvGoTwAl");
        sysParam.setValue("500158457");

        // set expected behavior on dao
        sysParamDao.expects(once()).method("saveSysParam")
            .with(same(sysParam)).isVoid();
        sysParamManager.saveSysParam(sysParam);
        sysParamDao.verify();

        // reset expectations
        sysParamDao.reset();

        sysParamDao.expects(once()).method("removeSysParam").with(eq(new Long(sysParamId)));
        sysParamManager.removeSysParam(sysParamId);
        sysParamDao.verify();

        // reset expectations
        sysParamDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(SysParam.class, sysParam.getId());
        sysParamDao.expects(once()).method("removeSysParam").isVoid();
        sysParamDao.expects(once()).method("getSysParam").will(throwException(ex));
        sysParamManager.removeSysParam(sysParamId);
        try {
            sysParamManager.getSysParam(sysParamId);
            fail("SysParam with identifier '" + sysParamId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        sysParamDao.verify();
    }
}
