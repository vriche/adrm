package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.LinkHisotry;
import com.vriche.adrm.dao.LinkHisotryDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class LinkHisotryDaoTest extends BaseDaoTestCase {
    private Long linkHisotryId = new Long("1");
    private LinkHisotryDao dao = null;

    public void setLinkHisotryDao(LinkHisotryDao dao) {
        this.dao = dao;
    }

    public void testAddLinkHisotry() throws Exception {
        LinkHisotry linkHisotry = new LinkHisotry();

        // set required fields

        java.lang.String subject = "GpLnKcLiZhIdFhSmKjBqLiDfRrNjBgDnFgEqSqNwKzLyYjRjQdYjUyEjMfUjXzNcZqXtVeErGaBnScKdMwQtRhWjVyHwEmEwAxQcRiAnWwEpWpFyTmZtZkYaIpCrGeRw";
        linkHisotry.setSubject(subject);        

        dao.saveLinkHisotry(linkHisotry);

        // verify a primary key was assigned
        assertNotNull(linkHisotry.getId());

        // verify set fields are same after save
        assertEquals(subject, linkHisotry.getSubject());
    }

    public void testGetLinkHisotry() throws Exception {
        LinkHisotry linkHisotry = dao.getLinkHisotry(linkHisotryId);
        assertNotNull(linkHisotry);
    }

    public void testGetLinkHisotrys() throws Exception {
        LinkHisotry linkHisotry = new LinkHisotry();

        List results = dao.getLinkHisotrys(linkHisotry);
        assertTrue(results.size() > 0);
    }

    public void testSaveLinkHisotry() throws Exception {
        LinkHisotry linkHisotry = dao.getLinkHisotry(linkHisotryId);

        // update required fields
        java.lang.String subject = "DdUzZyUeWhTyGqJpWwZdHmKuEmKzShThYxPlFgZhIzZiReKyZfDvOsDoUxPbWxKkNdYkOjLrLzYzYcQgKlNqXkQjHzJfAoUtKdMzJfHpGaMfXjBaAyVzHjGlQoKeMtUh";
        linkHisotry.setSubject(subject);        

        dao.saveLinkHisotry(linkHisotry);

        assertEquals(subject, linkHisotry.getSubject());
    }

    public void testRemoveLinkHisotry() throws Exception {
        Long removeId = new Long("3");
        dao.removeLinkHisotry(removeId);
        try {
            dao.getLinkHisotry(removeId);
            fail("linkHisotry found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveLinkHisotrys(final Map idList) throws Exception {
        try {
        	dao.removeLinkHisotrys(idList);
            fail("linkHisotry found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
