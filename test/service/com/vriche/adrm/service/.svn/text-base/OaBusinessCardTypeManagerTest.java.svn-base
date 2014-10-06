
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaBusinessCardTypeDao;
import com.vriche.adrm.model.OaBusinessCardType;
import com.vriche.adrm.service.impl.OaBusinessCardTypeManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaBusinessCardTypeManagerTest extends BaseManagerTestCase {
    private final String oaBusinessCardTypeId = "1";
    private OaBusinessCardTypeManagerImpl oaBusinessCardTypeManager = new OaBusinessCardTypeManagerImpl();
    private Mock oaBusinessCardTypeDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaBusinessCardTypeDao = new Mock(OaBusinessCardTypeDao.class);
        oaBusinessCardTypeManager.setOaBusinessCardTypeDao((OaBusinessCardTypeDao) oaBusinessCardTypeDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaBusinessCardTypeManager = null;
    }

    public void testGetOaBusinessCardTypes() throws Exception {
        List results = new ArrayList();
        OaBusinessCardType oaBusinessCardType = new OaBusinessCardType();
        results.add(oaBusinessCardType);

        // set expected behavior on dao
        oaBusinessCardTypeDao.expects(once()).method("getOaBusinessCardTypes")
            .will(returnValue(results));

        List oaBusinessCardTypes = oaBusinessCardTypeManager.getOaBusinessCardTypes(null);
        assertTrue(oaBusinessCardTypes.size() == 1);
        oaBusinessCardTypeDao.verify();
    }

    public void testGetOaBusinessCardType() throws Exception {
        // set expected behavior on dao
        oaBusinessCardTypeDao.expects(once()).method("getOaBusinessCardType")
            .will(returnValue(new OaBusinessCardType()));
        OaBusinessCardType oaBusinessCardType = oaBusinessCardTypeManager.getOaBusinessCardType(oaBusinessCardTypeId);
        assertTrue(oaBusinessCardType != null);
        oaBusinessCardTypeDao.verify();
    }

    public void testSaveOaBusinessCardType() throws Exception {
        OaBusinessCardType oaBusinessCardType = new OaBusinessCardType();

        // set expected behavior on dao
        oaBusinessCardTypeDao.expects(once()).method("saveOaBusinessCardType")
            .with(same(oaBusinessCardType)).isVoid();

        oaBusinessCardTypeManager.saveOaBusinessCardType(oaBusinessCardType);
        oaBusinessCardTypeDao.verify();
    }

    public void testAddAndRemoveOaBusinessCardType() throws Exception {
        OaBusinessCardType oaBusinessCardType = new OaBusinessCardType();

        // set required fields

        // set expected behavior on dao
        oaBusinessCardTypeDao.expects(once()).method("saveOaBusinessCardType")
            .with(same(oaBusinessCardType)).isVoid();
        oaBusinessCardTypeManager.saveOaBusinessCardType(oaBusinessCardType);
        oaBusinessCardTypeDao.verify();

        // reset expectations
        oaBusinessCardTypeDao.reset();

        oaBusinessCardTypeDao.expects(once()).method("removeOaBusinessCardType").with(eq(new Long(oaBusinessCardTypeId)));
        oaBusinessCardTypeManager.removeOaBusinessCardType(oaBusinessCardTypeId);
        oaBusinessCardTypeDao.verify();

        // reset expectations
        oaBusinessCardTypeDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaBusinessCardType.class, oaBusinessCardType.getId());
        oaBusinessCardTypeDao.expects(once()).method("removeOaBusinessCardType").isVoid();
        oaBusinessCardTypeDao.expects(once()).method("getOaBusinessCardType").will(throwException(ex));
        oaBusinessCardTypeManager.removeOaBusinessCardType(oaBusinessCardTypeId);
        try {
            oaBusinessCardTypeManager.getOaBusinessCardType(oaBusinessCardTypeId);
            fail("OaBusinessCardType with identifier '" + oaBusinessCardTypeId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaBusinessCardTypeDao.verify();
    }
}
