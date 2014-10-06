
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.MatterDao;
import com.vriche.adrm.model.Matter;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.MatterManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class MatterManagerTest extends BaseManagerTestCase {
    private final String matterId = "1";
    private MatterManagerImpl matterManager = new MatterManagerImpl();
    private Mock matterDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        matterDao = new Mock(MatterDao.class);
        matterManager.setMatterDao((MatterDao) matterDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        matterManager = null;
    }

    public void testGetMatters() throws Exception {
        List results = new ArrayList();
        Matter matter = new Matter();
        results.add(matter);

        // set expected behavior on dao
        matterDao.expects(once()).method("getMatters")
            .will(returnValue(results));

        List matters = matterManager.getMatters(null);
        assertTrue(matters.size() == 1);
        matterDao.verify();
    }

    public void testGetMatter() throws Exception {
        // set expected behavior on dao
        matterDao.expects(once()).method("getMatter")
            .will(returnValue(new Matter()));
        Matter matter = matterManager.getMatter(matterId);
        assertTrue(matter != null);
        matterDao.verify();
    }

    public void testSaveMatter() throws Exception {
        Matter matter = new Matter();

        // set expected behavior on dao
        matterDao.expects(once()).method("saveMatter")
            .with(same(matter)).isVoid();

        matterManager.saveMatter(matter);
        matterDao.verify();
    }

    public void testAddAndRemoveMatter() throws Exception {
        Matter matter = new Matter();

        // set required fields

        // set expected behavior on dao
        matterDao.expects(once()).method("saveMatter")
            .with(same(matter)).isVoid();
        matterManager.saveMatter(matter);
        matterDao.verify();

        // reset expectations
        matterDao.reset();

        matterDao.expects(once()).method("removeMatter").with(eq(new Long(matterId)));
        matterManager.removeMatter(matterId);
        matterDao.verify();

        // reset expectations
        matterDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(Matter.class, matter.getId());
        matterDao.expects(once()).method("removeMatter").isVoid();
        matterDao.expects(once()).method("getMatter").will(throwException(ex));
        matterManager.removeMatter(matterId);
        try {
            matterManager.getMatter(matterId);
            fail("Matter with identifier '" + matterId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        matterDao.verify();
    }
}
