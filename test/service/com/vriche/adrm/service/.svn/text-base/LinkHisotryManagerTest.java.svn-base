
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;


import com.vriche.adrm.dao.LinkHisotryDao;
import com.vriche.adrm.model.LinkHisotry;
import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.service.impl.LinkHisotryManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class LinkHisotryManagerTest extends BaseManagerTestCase {
    private final String linkHisotryId = "1";
    private LinkHisotryManagerImpl linkHisotryManager = new LinkHisotryManagerImpl();
    private Mock linkHisotryDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        linkHisotryDao = new Mock(LinkHisotryDao.class);
        linkHisotryManager.setLinkHisotryDao((LinkHisotryDao) linkHisotryDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        linkHisotryManager = null;
    }

    public void testGetLinkHisotrys() throws Exception {
        List results = new ArrayList();
        LinkHisotry linkHisotry = new LinkHisotry();
        results.add(linkHisotry);

        // set expected behavior on dao
        linkHisotryDao.expects(once()).method("getLinkHisotrys")
            .will(returnValue(results));

        List linkHisotrys = linkHisotryManager.getLinkHisotrys(null);
        assertTrue(linkHisotrys.size() == 1);
        linkHisotryDao.verify();
    }

    public void testGetLinkHisotry() throws Exception {
        // set expected behavior on dao
        linkHisotryDao.expects(once()).method("getLinkHisotry")
            .will(returnValue(new LinkHisotry()));
        LinkHisotry linkHisotry = linkHisotryManager.getLinkHisotry(linkHisotryId);
        assertTrue(linkHisotry != null);
        linkHisotryDao.verify();
    }

    public void testSaveLinkHisotry() throws Exception {
        LinkHisotry linkHisotry = new LinkHisotry();

        // set expected behavior on dao
        linkHisotryDao.expects(once()).method("saveLinkHisotry")
            .with(same(linkHisotry)).isVoid();

        linkHisotryManager.saveLinkHisotry(linkHisotry);
        linkHisotryDao.verify();
    }

    public void testAddAndRemoveLinkHisotry() throws Exception {
        LinkHisotry linkHisotry = new LinkHisotry();

        // set required fields
        linkHisotry.setSubject("XaUyTdEpQaCdAiZaFlXkFmFsLtVjNxMjIiXnMoQnOfPaZeTmBjHsUtPbSeItTuCiWsGnBgWlSdNhRvXuJfGrSfQoDxMvNnFvOeOmDdPmDdWnFbAxPiUdFiLdMjAvYsAd");

        // set expected behavior on dao
        linkHisotryDao.expects(once()).method("saveLinkHisotry")
            .with(same(linkHisotry)).isVoid();
        linkHisotryManager.saveLinkHisotry(linkHisotry);
        linkHisotryDao.verify();

        // reset expectations
        linkHisotryDao.reset();

        linkHisotryDao.expects(once()).method("removeLinkHisotry").with(eq(new Long(linkHisotryId)));
        linkHisotryManager.removeLinkHisotry(linkHisotryId);
        linkHisotryDao.verify();

        // reset expectations
        linkHisotryDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(LinkHisotry.class, linkHisotry.getId());
        linkHisotryDao.expects(once()).method("removeLinkHisotry").isVoid();
        linkHisotryDao.expects(once()).method("getLinkHisotry").will(throwException(ex));
        linkHisotryManager.removeLinkHisotry(linkHisotryId);
        try {
            linkHisotryManager.getLinkHisotry(linkHisotryId);
            fail("LinkHisotry with identifier '" + linkHisotryId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        linkHisotryDao.verify();
    }
}
