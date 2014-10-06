
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;

import com.vriche.adrm.dao.LinkManDao;
import com.vriche.adrm.model.LinkMan;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.LinkManManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class LinkManManagerTest extends BaseManagerTestCase {
    private final String linkManId = "1";
    private LinkManManagerImpl linkManManager = new LinkManManagerImpl();
    private Mock linkManDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        linkManDao = new Mock(LinkManDao.class);
        linkManManager.setLinkManDao((LinkManDao) linkManDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        linkManManager = null;
    }

    public void testGetLinkMans() throws Exception {
        List results = new ArrayList();
        LinkMan linkMan = new LinkMan();
        results.add(linkMan);

        // set expected behavior on dao
        linkManDao.expects(once()).method("getLinkMans")
            .will(returnValue(results));

        List linkMans = linkManManager.getLinkMans(null);
        assertTrue(linkMans.size() == 1);
        linkManDao.verify();
    }

    public void testGetLinkMan() throws Exception {
        // set expected behavior on dao
        linkManDao.expects(once()).method("getLinkMan")
            .will(returnValue(new LinkMan()));
        LinkMan linkMan = linkManManager.getLinkMan(linkManId);
        assertTrue(linkMan != null);
        linkManDao.verify();
    }

    public void testSaveLinkMan() throws Exception {
        LinkMan linkMan = new LinkMan();

        // set expected behavior on dao
        linkManDao.expects(once()).method("saveLinkMan")
            .with(same(linkMan)).isVoid();

        linkManManager.saveLinkMan(linkMan);
        linkManDao.verify();
    }

    public void testAddAndRemoveLinkMan() throws Exception {
        LinkMan linkMan = new LinkMan();

        // set required fields
        linkMan.setLinkmanName("SvNpKyLaLnDdJeDuVqRtJnLpTtYbNyJaTrWcDxVsCjBuUpVjSfIgQcGoLpIpWjDqZhVyJqJcTdAzLsClCuDgNpKrVvPeNzLpZfJzTuDqDbYaRrNfWfLuDjViIcUzPeXc");

        // set expected behavior on dao
        linkManDao.expects(once()).method("saveLinkMan")
            .with(same(linkMan)).isVoid();
        linkManManager.saveLinkMan(linkMan);
        linkManDao.verify();

        // reset expectations
        linkManDao.reset();

        linkManDao.expects(once()).method("removeLinkMan").with(eq(new Long(linkManId)));
        linkManManager.removeLinkMan(linkManId);
        linkManDao.verify();

        // reset expectations
        linkManDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(LinkMan.class, linkMan.getId());
        linkManDao.expects(once()).method("removeLinkMan").isVoid();
        linkManDao.expects(once()).method("getLinkMan").will(throwException(ex));
        linkManManager.removeLinkMan(linkManId);
        try {
            linkManManager.getLinkMan(linkManId);
            fail("LinkMan with identifier '" + linkManId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        linkManDao.verify();
    }
}
