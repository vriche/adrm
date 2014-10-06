
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.MatterTypeDao;
import com.vriche.adrm.model.MatterType;
import com.vriche.adrm.service.impl.MatterTypeManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class MatterTypeManagerTest extends BaseManagerTestCase {
    private final String matterTypeId = "1";
    private MatterTypeManagerImpl matterTypeManager = new MatterTypeManagerImpl();
    private Mock matterTypeDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        matterTypeDao = new Mock(MatterTypeDao.class);
        matterTypeManager.setMatterTypeDao((MatterTypeDao) matterTypeDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        matterTypeManager = null;
    }

    public void testGetMatterTypes() throws Exception {
        List results = new ArrayList();
        MatterType matterType = new MatterType();
        results.add(matterType);

        // set expected behavior on dao
        matterTypeDao.expects(once()).method("getMatterTypes")
            .will(returnValue(results));

        List matterTypes = matterTypeManager.getMatterTypes(null);
        assertTrue(matterTypes.size() == 1);
        matterTypeDao.verify();
    }

    public void testGetMatterType() throws Exception {
        // set expected behavior on dao
        matterTypeDao.expects(once()).method("getMatterType")
            .will(returnValue(new MatterType()));
        MatterType matterType = matterTypeManager.getMatterType(matterTypeId);
        assertTrue(matterType != null);
        matterTypeDao.verify();
    }

    public void testSaveMatterType() throws Exception {
        MatterType matterType = new MatterType();

        // set expected behavior on dao
        matterTypeDao.expects(once()).method("saveMatterType")
            .with(same(matterType)).isVoid();

        matterTypeManager.saveMatterType(matterType);
        matterTypeDao.verify();
    }

    public void testAddAndRemoveMatterType() throws Exception {
        MatterType matterType = new MatterType();

        // set required fields

        // set expected behavior on dao
        matterTypeDao.expects(once()).method("saveMatterType")
            .with(same(matterType)).isVoid();
        matterTypeManager.saveMatterType(matterType);
        matterTypeDao.verify();

        // reset expectations
        matterTypeDao.reset();

        matterTypeDao.expects(once()).method("removeMatterType").with(eq(new Long(matterTypeId)));
        matterTypeManager.removeMatterType(matterTypeId);
        matterTypeDao.verify();

        // reset expectations
        matterTypeDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(MatterType.class, matterType.getId());
        matterTypeDao.expects(once()).method("removeMatterType").isVoid();
        matterTypeDao.expects(once()).method("getMatterType").will(throwException(ex));
        matterTypeManager.removeMatterType(matterTypeId);
        try {
            matterTypeManager.getMatterType(matterTypeId);
            fail("MatterType with identifier '" + matterTypeId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        matterTypeDao.verify();
    }
}
