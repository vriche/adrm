package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.DayInfo;
import com.vriche.adrm.dao.DayInfoDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class DayInfoDaoTest extends BaseDaoTestCase {
    private Long dayInfoId = new Long("1");
    private DayInfoDao dao = null;

    public void setDayInfoDao(DayInfoDao dao) {
        this.dao = dao;
    }

    public void testAddDayInfo() throws Exception {
        DayInfo dayInfo = new DayInfo();

        // set required fields

        dao.saveDayInfo(dayInfo);

        // verify a primary key was assigned
        assertNotNull(dayInfo.getId());

        // verify set fields are same after save
    }

    public void testGetDayInfo() throws Exception {
        DayInfo dayInfo = dao.getDayInfo(dayInfoId);
        assertNotNull(dayInfo);
    }

    public void testGetDayInfos() throws Exception {
        DayInfo dayInfo = new DayInfo();

        List results = dao.getDayInfos(dayInfo);
        assertTrue(results.size() > 0);
    }

    public void testSaveDayInfo() throws Exception {
        DayInfo dayInfo = dao.getDayInfo(dayInfoId);

        // update required fields

        dao.saveDayInfo(dayInfo);

    }

    public void testRemoveDayInfo() throws Exception {
        Long removeId = new Long("3");
        dao.removeDayInfo(removeId);
        try {
            dao.getDayInfo(removeId);
            fail("dayInfo found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveDayInfos(final Map idList) throws Exception {
        try {
        	dao.removeDayInfos(idList);
            fail("dayInfo found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
