
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaAssetsDao;
import com.vriche.adrm.model.OaAssets;
import com.vriche.adrm.service.impl.OaAssetsManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaAssetsManagerTest extends BaseManagerTestCase {
    private final String oaAssetsId = "1";
    private OaAssetsManagerImpl oaAssetsManager = new OaAssetsManagerImpl();
    private Mock oaAssetsDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaAssetsDao = new Mock(OaAssetsDao.class);
        oaAssetsManager.setOaAssetsDao((OaAssetsDao) oaAssetsDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaAssetsManager = null;
    }

    public void testGetOaAssetss() throws Exception {
        List results = new ArrayList();
        OaAssets oaAssets = new OaAssets();
        results.add(oaAssets);

        // set expected behavior on dao
        oaAssetsDao.expects(once()).method("getOaAssetss")
            .will(returnValue(results));

        List oaAssetss = oaAssetsManager.getOaAssetss(null);
        assertTrue(oaAssetss.size() == 1);
        oaAssetsDao.verify();
    }

    public void testGetOaAssets() throws Exception {
        // set expected behavior on dao
        oaAssetsDao.expects(once()).method("getOaAssets")
            .will(returnValue(new OaAssets()));
        OaAssets oaAssets = oaAssetsManager.getOaAssets(oaAssetsId);
        assertTrue(oaAssets != null);
        oaAssetsDao.verify();
    }

    public void testSaveOaAssets() throws Exception {
        OaAssets oaAssets = new OaAssets();

        // set expected behavior on dao
        oaAssetsDao.expects(once()).method("saveOaAssets")
            .with(same(oaAssets)).isVoid();

        oaAssetsManager.saveOaAssets(oaAssets);
        oaAssetsDao.verify();
    }

    public void testAddAndRemoveOaAssets() throws Exception {
        OaAssets oaAssets = new OaAssets();

        // set required fields

        // set expected behavior on dao
        oaAssetsDao.expects(once()).method("saveOaAssets")
            .with(same(oaAssets)).isVoid();
        oaAssetsManager.saveOaAssets(oaAssets);
        oaAssetsDao.verify();

        // reset expectations
        oaAssetsDao.reset();

        oaAssetsDao.expects(once()).method("removeOaAssets").with(eq(new Long(oaAssetsId)));
        oaAssetsManager.removeOaAssets(oaAssetsId);
        oaAssetsDao.verify();

        // reset expectations
        oaAssetsDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaAssets.class, oaAssets.getId());
        oaAssetsDao.expects(once()).method("removeOaAssets").isVoid();
        oaAssetsDao.expects(once()).method("getOaAssets").will(throwException(ex));
        oaAssetsManager.removeOaAssets(oaAssetsId);
        try {
            oaAssetsManager.getOaAssets(oaAssetsId);
            fail("OaAssets with identifier '" + oaAssetsId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaAssetsDao.verify();
    }
}
