package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.Industry;
import com.vriche.adrm.dao.IndustryDao;

import org.springframework.orm.ObjectRetrievalFailureException;

public class IndustryDaoTest extends BaseDaoTestCase {
    private Long industryId = new Long("1");
    private IndustryDao dao = null;

    public void setIndustryDao(IndustryDao dao) {
        this.dao = dao;
    }

    public void testAddIndustry() throws Exception {
        Industry industry = new Industry();

        // set required fields

        java.lang.String name = "MfJpBrCiShAhWfXzVeMiLcZpZbAqXuHjHlToNpQyEkCoWuYpIaHmMwQfPaQzFxEeFaTmCzKeKqNpWbAmVoObVvGjYdHmOzPsZnOmPbMkRiMyBkXdEgOsHnFzJsGsIiAt";
        industry.setName(name);        

        dao.saveIndustry(industry);

        // verify a primary key was assigned
        assertNotNull(industry.getId());

        // verify set fields are same after save
        assertEquals(name, industry.getName());
    }

    public void testGetIndustry() throws Exception {
        Industry industry = dao.getIndustry(industryId);
        assertNotNull(industry);
    }

    public void testGetIndustrys() throws Exception {
        Industry industry = new Industry();

        List results = dao.getIndustrys(industry);
        assertTrue(results.size() > 0);
    }

    public void testSaveIndustry() throws Exception {
        Industry industry = dao.getIndustry(industryId);

        // update required fields
        java.lang.String name = "DqEiBqBmSoVnPzVhSmSlBvHnYfUtMrJtKkEoChBmFnCmXmNdRpLvAjZuWsFwCyKaIfPtMtEpIhCtIfZxZiFlTaChFcXlApLrUhCsYvZoRzOcCjZsXkVgExNgBaQbByCh";
        industry.setName(name);        

        dao.saveIndustry(industry);

        assertEquals(name, industry.getName());
    }

    public void testRemoveIndustry() throws Exception {
        Long removeId = new Long("3");
        dao.removeIndustry(removeId);
        try {
            dao.getIndustry(removeId);
            fail("industry found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemoveIndustrys(final Map idList) throws Exception {
        try {
        	dao.removeIndustrys(idList);
            fail("industry found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
