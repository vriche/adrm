package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.LinkMan;
import com.vriche.adrm.dao.LinkManDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class LinkManDaoTest extends BaseDaoTestCase {
    private Long linkManId = new Long("1");
    private LinkManDao dao = null;

    public void setLinkManDao(LinkManDao dao) {
        this.dao = dao;
    }

    public void testAddLinkMan() throws Exception {
        LinkMan linkMan = new LinkMan();

        // set required fields

        java.lang.String linkmanName = "PsHvUnEpMcPlYtQuQtMqGkKjGzUoHyYbWtVrLpLoCzMmYzOdEqGxTvZrSvFlYtFvBlJsVyPwIaIhZiEzUtKgNzEdHjIeJeQuBqNcMoOuLpFpDdFoLdSmOuYvJxBpEwAw";
        linkMan.setLinkmanName(linkmanName);        

        dao.saveLinkMan(linkMan);

        // verify a primary key was assigned
        assertNotNull(linkMan.getId());

        // verify set fields are same after save
        assertEquals(linkmanName, linkMan.getLinkmanName());
    }

    public void testGetLinkMan() throws Exception {
        LinkMan linkMan = dao.getLinkMan(linkManId);
        assertNotNull(linkMan);
    }

    public void testGetLinkMans() throws Exception {
        LinkMan linkMan = new LinkMan();

        List results = dao.getLinkMans(linkMan);
        assertTrue(results.size() > 0);
    }

    public void testSaveLinkMan() throws Exception {
        LinkMan linkMan = dao.getLinkMan(linkManId);

        // update required fields
        java.lang.String linkmanName = "PvUwDdWvPkThJxVzSpMdSzReXoAlOcXvAiFeBbQnXiSpZzTaViBbFoTdHsDbEcOpYeLrGiUkImQkMoUuGrFuVoItTrPfXmBmIvZpIhEdDiFvPtMrHiExFbHeMqAoBiKv";
        linkMan.setLinkmanName(linkmanName);        

        dao.saveLinkMan(linkMan);

        assertEquals(linkmanName, linkMan.getLinkmanName());
    }

    public void testRemoveLinkMan() throws Exception {
        Long removeId = new Long("3");
        dao.removeLinkMan(removeId);
        try {
            dao.getLinkMan(removeId);
            fail("linkMan found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveLinkMans(final Map idList) throws Exception {
        try {
        	dao.removeLinkMans(idList);
            fail("linkMan found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
