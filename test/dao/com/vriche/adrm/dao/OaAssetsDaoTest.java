package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaAssets;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaAssetsDaoTest extends BaseDaoTestCase {
    private Long oaAssetsId = new Long("1");
    private OaAssetsDao dao = null;

    public void setOaAssetsDao(OaAssetsDao dao) {
        this.dao = dao;
    }

    public void testAddOaAssets() throws Exception {
        OaAssets oaAssets = new OaAssets();

        // set required fields

        dao.saveOaAssets(oaAssets);

        // verify a primary key was assigned
        assertNotNull(oaAssets.getId());

        // verify set fields are same after save
    }

    public void testGetOaAssets() throws Exception {
        OaAssets oaAssets = dao.getOaAssets(oaAssetsId);
        assertNotNull(oaAssets);
    }

    public void testGetOaAssetss() throws Exception {
        OaAssets oaAssets = new OaAssets();

        List results = dao.getOaAssetss(oaAssets);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaAssets() throws Exception {
        OaAssets oaAssets = dao.getOaAssets(oaAssetsId);

        // update required fields

        dao.saveOaAssets(oaAssets);

    }

    public void testRemoveOaAssets() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaAssets(removeId);
        try {
            dao.getOaAssets(removeId);
            fail("oaAssets found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaAssetss(final Map idList) throws Exception {
        try {
        	dao.removeOaAssetss(idList);
            fail("oaAssets found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
