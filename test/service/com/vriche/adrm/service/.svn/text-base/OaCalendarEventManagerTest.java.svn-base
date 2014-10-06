
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.OaCalendarEventDao;
import com.vriche.adrm.model.OaCalendarEvent;
import com.vriche.adrm.service.impl.OaCalendarEventManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class OaCalendarEventManagerTest extends BaseManagerTestCase {
    private final String oaCalendarEventId = "1";
    private OaCalendarEventManagerImpl oaCalendarEventManager = new OaCalendarEventManagerImpl();
    private Mock oaCalendarEventDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        oaCalendarEventDao = new Mock(OaCalendarEventDao.class);
        oaCalendarEventManager.setOaCalendarEventDao((OaCalendarEventDao) oaCalendarEventDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        oaCalendarEventManager = null;
    }

    public void testGetOaCalendarEvents() throws Exception {
        List results = new ArrayList();
        OaCalendarEvent oaCalendarEvent = new OaCalendarEvent();
        results.add(oaCalendarEvent);

        // set expected behavior on dao
        oaCalendarEventDao.expects(once()).method("getOaCalendarEvents")
            .will(returnValue(results));

        List oaCalendarEvents = oaCalendarEventManager.getOaCalendarEvents(null);
        assertTrue(oaCalendarEvents.size() == 1);
        oaCalendarEventDao.verify();
    }

    public void testGetOaCalendarEvent() throws Exception {
        // set expected behavior on dao
        oaCalendarEventDao.expects(once()).method("getOaCalendarEvent")
            .will(returnValue(new OaCalendarEvent()));
        OaCalendarEvent oaCalendarEvent = oaCalendarEventManager.getOaCalendarEvent(oaCalendarEventId);
        assertTrue(oaCalendarEvent != null);
        oaCalendarEventDao.verify();
    }

    public void testSaveOaCalendarEvent() throws Exception {
        OaCalendarEvent oaCalendarEvent = new OaCalendarEvent();

        // set expected behavior on dao
        oaCalendarEventDao.expects(once()).method("saveOaCalendarEvent")
            .with(same(oaCalendarEvent)).isVoid();

        oaCalendarEventManager.saveOaCalendarEvent(oaCalendarEvent);
        oaCalendarEventDao.verify();
    }

    public void testAddAndRemoveOaCalendarEvent() throws Exception {
        OaCalendarEvent oaCalendarEvent = new OaCalendarEvent();

        // set required fields

        // set expected behavior on dao
        oaCalendarEventDao.expects(once()).method("saveOaCalendarEvent")
            .with(same(oaCalendarEvent)).isVoid();
        oaCalendarEventManager.saveOaCalendarEvent(oaCalendarEvent);
        oaCalendarEventDao.verify();

        // reset expectations
        oaCalendarEventDao.reset();

        oaCalendarEventDao.expects(once()).method("removeOaCalendarEvent").with(eq(new Long(oaCalendarEventId)));
        oaCalendarEventManager.removeOaCalendarEvent(oaCalendarEventId);
        oaCalendarEventDao.verify();

        // reset expectations
        oaCalendarEventDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(OaCalendarEvent.class, oaCalendarEvent.getId());
        oaCalendarEventDao.expects(once()).method("removeOaCalendarEvent").isVoid();
        oaCalendarEventDao.expects(once()).method("getOaCalendarEvent").will(throwException(ex));
        oaCalendarEventManager.removeOaCalendarEvent(oaCalendarEventId);
        try {
            oaCalendarEventManager.getOaCalendarEvent(oaCalendarEventId);
            fail("OaCalendarEvent with identifier '" + oaCalendarEventId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        oaCalendarEventDao.verify();
    }
}
