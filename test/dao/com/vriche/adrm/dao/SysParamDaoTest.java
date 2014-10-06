package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.SysParam;

import org.springframework.orm.ObjectRetrievalFailureException;

public class SysParamDaoTest extends BaseDaoTestCase {
    private Long sysParamId = new Long("1");
    private SysParamDao dao = null;

    public void setSysParamDao(SysParamDao dao) {
        this.dao = dao;
    }

    public void testAddSysParam() throws Exception {
        SysParam sysParam = new SysParam();

        // set required fields

        java.lang.String name = "LcCxFbWqIkOkDnEmSlSqVaSeMwFyYuUwXtPfOdTvTjWxXuZhNoHnOtPkElJiSfUlUeVjLaAaQtUoJdUhZsToXiAoYqNfOpHcUcDhWxKaBiIpMcVaDzAhDjKzAlEsDhKo";
        sysParam.setName(name);        

        java.lang.String value = "1";
        sysParam.setValue(value);        

        dao.saveSysParam(sysParam);

        // verify a primary key was assigned
        assertNotNull(sysParam.getId());

        // verify set fields are same after save
        assertEquals(name, sysParam.getName());
        assertEquals(value, sysParam.getValue());
    }

    public void testGetSysParam() throws Exception {
        SysParam sysParam = dao.getSysParam(sysParamId);
        assertNotNull(sysParam);
    }

    public void testGetSysParams() throws Exception {
        SysParam sysParam = new SysParam();

        List results = dao.getSysParams(sysParam);
        assertTrue(results.size() > 0);
    }

    public void testSaveSysParam() throws Exception {
        SysParam sysParam = dao.getSysParam(sysParamId);

        // update required fields
        java.lang.String name = "VqTfSqPoMcCzPeLgNeSlUlAzBzUfKrMpBjFcEiGjJcFqXoWnIqAcDaPcRtKnJxLdTxFoLiIxQtBmKbGhGaXxDvVyTsTnMzHlMaJuXgLpVjFoIfOiKvFuSvIjIuUrXfUe";
        sysParam.setName(name);        
        java.lang.String value ="2";
        sysParam.setValue(value);        

        dao.saveSysParam(sysParam);

        assertEquals(name, sysParam.getName());
        assertEquals(value, sysParam.getValue());
    }

    public void testRemoveSysParam() throws Exception {
        Long removeId = new Long("3");
        dao.removeSysParam(removeId);
        try {
            dao.getSysParam(removeId);
            fail("sysParam found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveSysParams(final Map idList) throws Exception {
        try {
        	dao.removeSysParams(idList);
            fail("sysParam found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
