
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaAreaPcDao;
import com.vriche.adrm.model.OaAreaPc;
import com.vriche.adrm.service.impl.OaAreaPcManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaAreaPcManagerTest extends BaseManagerTestCase {
    private final String oaAreaPcId = "1";
    private OaAreaPcManagerImpl oaAreaPcManager = new OaAreaPcManagerImpl();
    private Mock oaAreaPcDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaAreaPcDao = new Mock(OaAreaPcDao.class);
        oaAreaPcManager.setOaAreaPcDao((OaAreaPcDao) oaAreaPcDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaAreaPcManager = null;
    }

    public void testGetOaAreaPcs() throws Exception {
        List results = new ArrayList();
        OaAreaPc oaAreaPc = new OaAreaPc();
        results.add(oaAreaPc);

        // set expected behavior on dao
        oaAreaPcDao.expects(once()).method("getOaAreaPcs")
            .will(returnValue(results));

        List oaAreaPcs = oaAreaPcManager.getOaAreaPcs(null);
        assertTrue(oaAreaPcs.size() == 1);
        oaAreaPcDao.verify();
    }

    public void testGetOaAreaPc() throws Exception {
        // set expected behavior on dao
        oaAreaPcDao.expects(once()).method("getOaAreaPc")
            .will(returnValue(new OaAreaPc()));
        OaAreaPc oaAreaPc = oaAreaPcManager.getOaAreaPc(oaAreaPcId);
        assertTrue(oaAreaPc != null);
        oaAreaPcDao.verify();
    }

    public void testSaveOaAreaPc() throws Exception {
        OaAreaPc oaAreaPc = new OaAreaPc();

        // set expected behavior on dao
        oaAreaPcDao.expects(once()).method("saveOaAreaPc")
            .with(same(oaAreaPc)).isVoid();

        oaAreaPcManager.saveOaAreaPc(oaAreaPc);
        oaAreaPcDao.verify();
    }

    public void testAddAndRemoveOaAreaPc() throws Exception {
        OaAreaPc oaAreaPc = new OaAreaPc();

        // set required fields

        // set expected behavior on dao
        oaAreaPcDao.expects(once()).method("saveOaAreaPc")
            .with(same(oaAreaPc)).isVoid();
        oaAreaPcManager.saveOaAreaPc(oaAreaPc);
        oaAreaPcDao.verify();

        // reset expectations
        oaAreaPcDao.reset();

        oaAreaPcDao.expects(once()).method("removeOaAreaPc").with(eq(new Long(oaAreaPcId)));
        oaAreaPcManager.removeOaAreaPc(oaAreaPcId);
        oaAreaPcDao.verify();

        // reset expectations
        oaAreaPcDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaAreaPc.class, oaAreaPc.getId());
        oaAreaPcDao.expects(once()).method("removeOaAreaPc").isVoid();
        oaAreaPcDao.expects(once()).method("getOaAreaPc").will(throwException(ex));
        oaAreaPcManager.removeOaAreaPc(oaAreaPcId);
        try {
            oaAreaPcManager.getOaAreaPc(oaAreaPcId);
            fail("OaAreaPc with identifier '" + oaAreaPcId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaAreaPcDao.verify();
    }
}
