package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.PublishArrange;

import org.springframework.orm.ObjectRetrievalFailureException;

public class PublishArrangeDaoTest extends BaseDaoTestCase {
    private Long publishArrangeId = new Long("1");
    private PublishArrangeDao dao = null;

    public void setPublishArrangeDao(PublishArrangeDao dao) {
        this.dao = dao;
    }

    public void testAddPublishArrange() throws Exception {
        PublishArrange publishArrange = new PublishArrange();

        // set required fields

        java.lang.Long carrierId = new Long(742466640);
        publishArrange.setCarrierId(carrierId);        

        java.lang.String carrierName = "NbAcNkZsXbPkYxRaKqAcFaCuHvGlBdJhVgCuIgPpPuAeDfEpChYdGfDsYtTtIlNiVuEjUqDwXxDpVgHbAiBkKbXjYgHwIlOuAmDcUsPyQhSbEsFuApTiWmExWwFhZrZj";
        publishArrange.setCarrierName(carrierName);        

        java.lang.String filePath = "KvFbWzBpIxTcTqKrXvUrEoCkIpLaWfHqDpPnZiYkMnQzNpTsGrBhYdSpHvUbRuDmBzHnNqNlVuRiUhLsAsHsEkRnJiIeZvMzVuYwQsZaXqKfXoNeXuLhQvZrSzDdEhBrHzHeVzCdWsRcJgLpSvZgMiLgTgGwRuErWfQgScXpOgOnErYzXlMkFpXrPcYcOgVmHdRuBgBwXdWsPfCmPfRuZtZmKjDgDjRrUkMgBzSzLdOkUaYkObNvSiDeAzEkAxUd";
        publishArrange.setFilePath(filePath);        

        java.lang.Boolean isEnable = new Boolean("false");
        publishArrange.setIsEnable(isEnable);        

        java.lang.Boolean isLocked = new Boolean("false");
        publishArrange.setIsLocked(isLocked);        

        java.lang.Integer publishDate = new Integer(248565391);
        publishArrange.setPublishDate(publishDate);        

        java.lang.Long resourceId = new Long(643971977);
        publishArrange.setResourceId(resourceId);        

        java.lang.String resourceMeno = "SyYjOoDnVhChUmUsRhBjRrBtRoInJhIjJlTbDlOxWhHlIhAwBdGvHuBgYkFnNvJlJdIwMeAePfIvPbQxVcDfScXcGzNnVlCbPhSsUyJyYxZmMnXqMqTlStMhSwWgRaRq";
        publishArrange.setResourceMeno(resourceMeno);        

        java.lang.String resourceName = "HbQlQxRaUeEeGgEsKlZdEdVvCkUxAyZlOwIfEjJdFnHyPdSnHpKwSzDuEgHqIsIpBbOxTqNgOoPkLzOjHqNvCoHmEjNeBuReDuWbRuOpHgJxRsNuAlFwLlPuKvWtUtRt";
        publishArrange.setResourceName(resourceName);        

        java.lang.Integer resourceTotalTimes = new Integer(26172240);
        publishArrange.setResourceTotalTimes(resourceTotalTimes);        

        java.lang.Integer resourceUsedTimes = new Integer(353052580);
        publishArrange.setResourceUsedTimes(resourceUsedTimes);        

        dao.savePublishArrange(publishArrange);

        // verify a primary key was assigned
        assertNotNull(publishArrange.getId());

        // verify set fields are same after save
        assertEquals(carrierId, publishArrange.getCarrierId());
        assertEquals(carrierName, publishArrange.getCarrierName());
        assertEquals(filePath, publishArrange.getFilePath());
        assertEquals(isEnable, publishArrange.getIsEnable());
        assertEquals(isLocked, publishArrange.getIsLocked());
        assertEquals(publishDate, publishArrange.getPublishDate());
        assertEquals(resourceId, publishArrange.getResourceId());
        assertEquals(resourceMeno, publishArrange.getResourceMeno());
        assertEquals(resourceName, publishArrange.getResourceName());
        assertEquals(resourceTotalTimes, publishArrange.getResourceTotalTimes());
        assertEquals(resourceUsedTimes, publishArrange.getResourceUsedTimes());
    }

    public void testGetPublishArrange() throws Exception {
        PublishArrange publishArrange = dao.getPublishArrange(publishArrangeId);
        assertNotNull(publishArrange);
    }

    public void testGetPublishArranges() throws Exception {
        PublishArrange publishArrange = new PublishArrange();

        List results = dao.getPublishArranges(publishArrange);
        assertTrue(results.size() > 0);
    }

    public void testSavePublishArrange() throws Exception {
        PublishArrange publishArrange = dao.getPublishArrange(publishArrangeId);

        // update required fields
        java.lang.Long carrierId = new Long(646334669);
        publishArrange.setCarrierId(carrierId);        
        java.lang.String carrierName = "UjAvJqUwFnIuCzLgMhXqXjLbNkNiGkQaCqVaMuIsInQjNgFkHbLpFuCsTrCsViPkJdWeShMlPrTdYmFpPsOqRiQcSwIzAyHlDjVmVnKnXuHvOvTfLsWrWcZaRzCqObXc";
        publishArrange.setCarrierName(carrierName);        
        java.lang.String filePath = "FpNaJoVhPbLqKoGvSfGdCsLgWrNbUpBiVeHuHjSkWzNpFrXeJmOnAoGtHcShUhHxEgWeZbUlHpQrMqEgIqFlZbIrCiPbQvDxHkZjVnPsRoSxZwZtFoLsJtOcVuYxXzZdYuWkLfNnHeTpFvZvNzKaHxWmLyUxHjTaBmJzShMiZyFfLvYwEeYfQxZaWjZhUaHmBxUaRaLlVtVbPyPvWhAuArCjQyDpUoMnUwTbBhLxCkOoXdPmHrErNoDsYmOsQkEl";
        publishArrange.setFilePath(filePath);        
        java.lang.Boolean isEnable = new Boolean("false");
        publishArrange.setIsEnable(isEnable);        
        java.lang.Boolean isLocked = new Boolean("false");
        publishArrange.setIsLocked(isLocked);        
        java.lang.Integer publishDate = new Integer(969405787);
        publishArrange.setPublishDate(publishDate);        
        java.lang.Long resourceId = new Long(796434942);
        publishArrange.setResourceId(resourceId);        
        java.lang.String resourceMeno = "JfNlTqFcTqHqXgCsNzZzWaUiVrIiPyZeRfTkHrDjSgJsBzGnIiJzOjLlEfOeFyMeGtKcMwXdLlMjEhYnZhOkXuGqMwAaHzYgEzHwYtOfMiDtVwCjWeAwXiKaKfQkFvMk";
        publishArrange.setResourceMeno(resourceMeno);        
        java.lang.String resourceName = "DmDmYpCvGpOjJdXfPuLpJdIxNkRsWcJaYdIeQvZlPbRvHeAbTuOpHaDpFyKgFlSlCtVzYoOcIrAuGcDnOcNjWeFvGtPzFvEsVjRhJpBpHnIyWdDrXqCfMfHcEgWbXcBu";
        publishArrange.setResourceName(resourceName);        
        java.lang.Integer resourceTotalTimes = new Integer(22859440);
        publishArrange.setResourceTotalTimes(resourceTotalTimes);        
        java.lang.Integer resourceUsedTimes = new Integer(390694153);
        publishArrange.setResourceUsedTimes(resourceUsedTimes);        

        dao.savePublishArrange(publishArrange);

        assertEquals(carrierId, publishArrange.getCarrierId());
        assertEquals(carrierName, publishArrange.getCarrierName());
        assertEquals(filePath, publishArrange.getFilePath());
        assertEquals(isEnable, publishArrange.getIsEnable());
        assertEquals(isLocked, publishArrange.getIsLocked());
        assertEquals(publishDate, publishArrange.getPublishDate());
        assertEquals(resourceId, publishArrange.getResourceId());
        assertEquals(resourceMeno, publishArrange.getResourceMeno());
        assertEquals(resourceName, publishArrange.getResourceName());
        assertEquals(resourceTotalTimes, publishArrange.getResourceTotalTimes());
        assertEquals(resourceUsedTimes, publishArrange.getResourceUsedTimes());
    }

    public void testRemovePublishArrange() throws Exception {
        Long removeId = new Long("3");
        dao.removePublishArrange(removeId);
        try {
            dao.getPublishArrange(removeId);
            fail("publishArrange found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemovePublishArranges(final Map idList) throws Exception {
        try {
        	dao.removePublishArranges(idList);
            fail("publishArrange found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
