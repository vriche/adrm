
package com.vriche.adrm.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;

import com.vriche.adrm.service.BaseManagerTestCase;
import com.vriche.adrm.dao.PublishArrangeDetailDao;
import com.vriche.adrm.model.PublishArrangeDetail;
import com.vriche.adrm.service.impl.PublishArrangeDetailManagerImpl;

import org.jmock.Mock;
import org.springframework.orm.ObjectRetrievalFailureException;

public class PublishArrangeDetailManagerTest extends BaseManagerTestCase {
    private final String publishArrangeDetailId = "1";
    private PublishArrangeDetailManagerImpl publishArrangeDetailManager = new PublishArrangeDetailManagerImpl();
    private Mock publishArrangeDetailDao = null;

    protected void setUp() throws Exception {
        super.setUp();
        publishArrangeDetailDao = new Mock(PublishArrangeDetailDao.class);
        publishArrangeDetailManager.setPublishArrangeDetailDao((PublishArrangeDetailDao) publishArrangeDetailDao.proxy());
    }

    protected void tearDown() throws Exception {
        super.tearDown();
        publishArrangeDetailManager = null;
    }

    public void testGetPublishArrangeDetails() throws Exception {
        List results = new ArrayList();
        PublishArrangeDetail publishArrangeDetail = new PublishArrangeDetail();
        results.add(publishArrangeDetail);

        // set expected behavior on dao
        publishArrangeDetailDao.expects(once()).method("getPublishArrangeDetails")
            .will(returnValue(results));

        List publishArrangeDetails = publishArrangeDetailManager.getPublishArrangeDetails(null);
        assertTrue(publishArrangeDetails.size() == 1);
        publishArrangeDetailDao.verify();
    }

    public void testGetPublishArrangeDetail() throws Exception {
        // set expected behavior on dao
        publishArrangeDetailDao.expects(once()).method("getPublishArrangeDetail")
            .will(returnValue(new PublishArrangeDetail()));
        PublishArrangeDetail publishArrangeDetail = publishArrangeDetailManager.getPublishArrangeDetail(publishArrangeDetailId);
        assertTrue(publishArrangeDetail != null);
        publishArrangeDetailDao.verify();
    }

    public void testSavePublishArrangeDetail() throws Exception {
        PublishArrangeDetail publishArrangeDetail = new PublishArrangeDetail();

        // set expected behavior on dao
        publishArrangeDetailDao.expects(once()).method("savePublishArrangeDetail")
            .with(same(publishArrangeDetail)).isVoid();

        publishArrangeDetailManager.savePublishArrangeDetail(publishArrangeDetail);
        publishArrangeDetailDao.verify();
    }

    public void testAddAndRemovePublishArrangeDetail() throws Exception {
        PublishArrangeDetail publishArrangeDetail = new PublishArrangeDetail();

        // set required fields
        publishArrangeDetail.setPublishSort(new Integer(2004850534));
        publishArrangeDetail.setSpecificValue("ImWyZxNgLiMfKyQaFpVvKwQfVhItPpZtHzCvDuMmWbPoUtUxXmJcFnPjAbKuFzKnJuXoHhXeJjKoPlStKzRjDaWrBdSsRtZcCcKbDaVdFwMzEcIsJsQbByDfZhDeEqFh");
        publishArrangeDetail.setContractId(new Long(541451520));
        publishArrangeDetail.setCustomerId(new Long(1981056946));
        publishArrangeDetail.setMatterId(new Long(1334215490));
        publishArrangeDetail.setOrderDayId(new Long(954989179));
        publishArrangeDetail.setOrderDetailId(new Long(34367900));
        publishArrangeDetail.setOrderId(new Long(2083618187));
        publishArrangeDetail.setOwnerUserId(new Long(1558846236));
        publishArrangeDetail.setCustomerName("XcLiReBjZmCxKuBfLqFlXhGbSuXkWzUiOjItHdViByPiUwYiIvPfXaQrVyBlPzZfPoIbAwKiSiKqKkAjZaRuYbByLoEuIqQuFcNyWmOqXnFlHjSpLxSoFfZjFxDfOuGp");
        publishArrangeDetail.setTapeCode("QbQfVlOfBaJkGtAnWxBpLcMkQiTePpVtXpPzNuDgNkAvLoJvRaDeYfTsDpOyKaGvUiFdDzPqJdZgBlHbEuZdGdWbMdFuBbXrWxJxMqJyKpIlCcYbMvUxSzWbHuUuBwNs");
        publishArrangeDetail.setMatterEdit("FfBuEoMdKhOqQmLtLgVcMdBkCoPlJmKoWhCuOfRiOiAyFsTmBlOjYhRlHyAzHlNpVyUrGiMwJhHeLsLgYiFiUqLqRdYnTzMbJmBuJpQqPfFsAqFkHoDzFiUrYuWsZdBi");
        publishArrangeDetail.setMatterLength("IpMuZcWrJuXtVcDkUdWzLfDoQtBrDqQiWmDxNgSwXyZuHyMbAcKsHvMbJlAzIeFiKlDiRtTaDoJiDeVwBxFcMsBmXbDaCaHyTnSxPhYiVnWtHbBoFmJbJsOmDeVpVuSh");
        publishArrangeDetail.setMatterName("TlLxDqMtQzNuYoCeBvYwYwIhUuKtKnOrSuYiMbNxWuRrCaLwZaQaChYeNlAyNwUeNnLfAwNcXjTaEdIoKcUhZoAbLkUhUvSqUqWhLjOsQqAvUbWnXlFwVyHpPoJdGgVb");
        publishArrangeDetail.setSpecificName("FdDzBxArIjQpEtMzDmBcYiVfXfPaIfZzLeRkJdOfIqBwKvWrDgYcVeQoHcJrRbVeWoDyAuJcTnOxBiQwZtKwSsPhDyBiPcGwXlOtTmIuNgCpGyYcNbLlHjFwSbUkLgIs");
        publishArrangeDetail.setAdverTimes(new Integer(857599930));
//        publishArrangeDetail.setOwnerUserName("HlSzSzErLlWrMsClZnPrQeXiEeJqHnLgBkRbJjDsMjWbKjVsAoOpYvKfOjPlZwQnQxRmGaTmKjYvWbXyCnZzXyQbNeBkPtRmMgVsYrRcZlMaVpGlHzFmVvZpAoPvWsXb");
        publishArrangeDetail.setPublishMemo("TzYsYuMjSeBmMfWbCzZqMnAjKiZqYmGsKfYjZmUbQdDdAdAqMeYbYmEdTdXiQnYbNmDmPsXuYgLwHnQoRiYtBiGyDnIfAlMkFwWxCsPaAzIfIzWnVtCcPwJyGsBfIzYy");

        // set expected behavior on dao
        publishArrangeDetailDao.expects(once()).method("savePublishArrangeDetail")
            .with(same(publishArrangeDetail)).isVoid();
        publishArrangeDetailManager.savePublishArrangeDetail(publishArrangeDetail);
        publishArrangeDetailDao.verify();

        // reset expectations
        publishArrangeDetailDao.reset();

        publishArrangeDetailDao.expects(once()).method("removePublishArrangeDetail").with(eq(new Long(publishArrangeDetailId)));
        publishArrangeDetailManager.removePublishArrangeDetail(publishArrangeDetailId);
        publishArrangeDetailDao.verify();

        // reset expectations
        publishArrangeDetailDao.reset();
        // remove
        Exception ex = new ObjectRetrievalFailureException(PublishArrangeDetail.class, publishArrangeDetail.getId());
        publishArrangeDetailDao.expects(once()).method("removePublishArrangeDetail").isVoid();
        publishArrangeDetailDao.expects(once()).method("getPublishArrangeDetail").will(throwException(ex));
        publishArrangeDetailManager.removePublishArrangeDetail(publishArrangeDetailId);
        try {
            publishArrangeDetailManager.getPublishArrangeDetail(publishArrangeDetailId);
            fail("PublishArrangeDetail with identifier '" + publishArrangeDetailId + "' found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
        publishArrangeDetailDao.verify();
    }
}
