package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.OaCalendarEvent;

import org.springframework.orm.ObjectRetrievalFailureException;

public class OaCalendarEventDaoTest extends BaseDaoTestCase {
    private Long oaCalendarEventId = new Long("1");
    private OaCalendarEventDao dao = null;

    public void setOaCalendarEventDao(OaCalendarEventDao dao) {
        this.dao = dao;
    }

    public void testAddOaCalendarEvent() throws Exception {
        OaCalendarEvent oaCalendarEvent = new OaCalendarEvent();

        // set required fields

        dao.saveOaCalendarEvent(oaCalendarEvent);

        // verify a primary key was assigned
        assertNotNull(oaCalendarEvent.getId());

        // verify set fields are same after save
    }

    public void testGetOaCalendarEvent() throws Exception {
        OaCalendarEvent oaCalendarEvent = dao.getOaCalendarEvent(oaCalendarEventId);
        assertNotNull(oaCalendarEvent);
    }

    public void testGetOaCalendarEvents() throws Exception {
        OaCalendarEvent oaCalendarEvent = new OaCalendarEvent();

        List results = dao.getOaCalendarEvents(oaCalendarEvent);
        assertTrue(results.size() > 0);
    }

    public void testSaveOaCalendarEvent() throws Exception {
        OaCalendarEvent oaCalendarEvent = dao.getOaCalendarEvent(oaCalendarEventId);

        // update required fields

        dao.saveOaCalendarEvent(oaCalendarEvent);

    }

    public void testRemoveOaCalendarEvent() throws Exception {
        Long removeId = new Long("3");
        dao.removeOaCalendarEvent(removeId);
        try {
            dao.getOaCalendarEvent(removeId);
            fail("oaCalendarEvent found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveOaCalendarEvents(final Map idList) throws Exception {
        try {
        	dao.removeOaCalendarEvents(idList);
            fail("oaCalendarEvent found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
