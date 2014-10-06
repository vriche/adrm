package com.vriche.adrm.dao;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.BaseDaoTestCase;
import com.vriche.adrm.model.PublishArrangeDetail;

import org.springframework.orm.ObjectRetrievalFailureException;

public class PublishArrangeDetailDaoTest extends BaseDaoTestCase {
    private Long publishArrangeDetailId = new Long("1");
    private PublishArrangeDetailDao dao = null;

    public void setPublishArrangeDetailDao(PublishArrangeDetailDao dao) {
        this.dao = dao;
    }

    public void testAddPublishArrangeDetail() throws Exception {
        PublishArrangeDetail publishArrangeDetail = new PublishArrangeDetail();

        // set required fields

        java.lang.Integer publishSort = new Integer(1572008258);
        publishArrangeDetail.setPublishSort(publishSort);        

        java.lang.String specificValue = "HqPtRtSdIbIsPgUzXqLgIoKtTsVoHeJoVqJgGxDlNjYyTnLpZfUxNrJrIkGcUpBeVqBdPzSpXiOiIvCjZvImMaHgQhMhCmYuEdMhJlEjSoVbTuVrRzXwQaDaWbWwOeIl";
        publishArrangeDetail.setSpecificValue(specificValue);        

        java.lang.Long contractId = new Long(1536409469);
        publishArrangeDetail.setContractId(contractId);        

        java.lang.Long customerId = new Long(81775055);
        publishArrangeDetail.setCustomerId(customerId);        

        java.lang.Long matterId = new Long(1009104615);
        publishArrangeDetail.setMatterId(matterId);        

        java.lang.Long orderDayId = new Long(248184001);
        publishArrangeDetail.setOrderDayId(orderDayId);        

        java.lang.Long orderDetailId = new Long(622839013);
        publishArrangeDetail.setOrderDetailId(orderDetailId);        

        java.lang.Long orderId = new Long(1751805963);
        publishArrangeDetail.setOrderId(orderId);        

        java.lang.Long ownerUserId = new Long(1465027979);
        publishArrangeDetail.setOwnerUserId(ownerUserId);        

        java.lang.String customerName = "ZrYjZyUsReRsStVeSdHqFnBiUyTwZeUfLaUgKuJsTvLfIxZgKtKmTnFcZsVgHpPhLmFyCvDkXuHgJmOaVeGrWrFoUjQoDkSwGtLiYiJlOrDiIqJnCaOaTgFeFaIcFwRm";
        publishArrangeDetail.setCustomerName(customerName);        

        java.lang.String tapeCode = "YbAbLrTyVlOmXsQxLcFoWuJdYcIzVsLsBzLzOrFeMrNyOhNqMcDbHyJoIgLkFtPvAtWfYqKoVbPjQcMmJgZfPfGgReBpEnDrLkLbIaXbHuGfQkGkQlPmXiQpPfTrUhGy";
        publishArrangeDetail.setTapeCode(tapeCode);        

        java.lang.String matterEdit = "FpFjFcDjOwPlKsQdXgFzZiYkRtVcTdTkYjCbQfDxUzFgDlChAqJrWqAqKzQyLqCvVeIbJrCqKfHlBdZrNpQyUlCqJcNxQjKsPpZgLtNkNlXnZuNtCeZcXkShRoOdHcEm";
        publishArrangeDetail.setMatterEdit(matterEdit);        

        java.lang.String matterLength = "SmTyOaBjHnVpIhUoPtClTpEyPqDpRsMzWhCgDsOrFhHcFoApZmFnSmDxOcCnRyLaTvJeOuFpLcCbGhZiXaWkVpLvHoWfKyTmZxQlGpAoUoEiSoFnDrHoTwFwEmDcYjUi";
        publishArrangeDetail.setMatterLength(matterLength);        

        java.lang.String matterName = "MuJwRoQvTfXjBiIdNkRsCwGoCzIvOkOzVdLeYhBbScIaQgDkBpZcXqMfEmAaXkGgAdRlErFlQwZtRuKaGnWuIkBqCuSvUoWxMuBlTvEuToOyJnItUqVpYxGuKnVaTuDf";
        publishArrangeDetail.setMatterName(matterName);        

        java.lang.String specificName = "JrYyAhAcSqGpLwYgIpRuQoVeKmXhIcQyYqWeEoQgTcYfWsZcSuFnLoTwSqGsKxGmJdVrMaEcIwAxSrWzGfGcEdXjVcPnQuViSkDnNuKnAmZtOkClGhQvIkIjIkCcLpAp";
        publishArrangeDetail.setSpecificName(specificName);        

        java.lang.Integer adverTimes = new Integer(357218759);
        publishArrangeDetail.setAdverTimes(adverTimes);        

        java.lang.String ownerUserName = "EzKyDjYiFyNrCoLdIwUrCjVqEpIaLoHnPnLjXmGgXrNxLqPiVtGlXnKvVeYqIoXyGhWjHrNqVmSrRxKrFeXhQcAzQvNiSgMyOuCeAyLcYuEbWsSdDoUhCjRmDnGpRxRo";
//        publishArrangeDetail.setOwnerUserName(ownerUserName);        

        java.lang.String publishMemo = "LdCbMyRzDtQiNnPpHcAeXxQtPmIpAyIaEiBgFcRsHzIoOtLxFqEtQiUfXrMkRhWgMjZgXuPkUwKsFwDkYiOzEwDgMkRsOfMbXbZbEtNoZvYvNpQiZdBqMsTzTqElLbEf";
        publishArrangeDetail.setPublishMemo(publishMemo);        

        dao.savePublishArrangeDetail(publishArrangeDetail);

        // verify a primary key was assigned
        assertNotNull(publishArrangeDetail.getId());

        // verify set fields are same after save
        assertEquals(publishSort, publishArrangeDetail.getPublishSort());
        assertEquals(specificValue, publishArrangeDetail.getSpecificValue());
        assertEquals(contractId, publishArrangeDetail.getContractId());
        assertEquals(customerId, publishArrangeDetail.getCustomerId());
        assertEquals(matterId, publishArrangeDetail.getMatterId());
        assertEquals(orderDayId, publishArrangeDetail.getOrderDayId());
        assertEquals(orderDetailId, publishArrangeDetail.getOrderDetailId());
        assertEquals(orderId, publishArrangeDetail.getOrderId());
        assertEquals(ownerUserId, publishArrangeDetail.getOwnerUserId());
        assertEquals(customerName, publishArrangeDetail.getCustomerName());
        assertEquals(tapeCode, publishArrangeDetail.getTapeCode());
        assertEquals(matterEdit, publishArrangeDetail.getMatterEdit());
        assertEquals(matterLength, publishArrangeDetail.getMatterLength());
        assertEquals(matterName, publishArrangeDetail.getMatterName());
        assertEquals(specificName, publishArrangeDetail.getSpecificName());
        assertEquals(adverTimes, publishArrangeDetail.getAdverTimes());
//        assertEquals(ownerUserName, publishArrangeDetail.getOwnerUserName());
        assertEquals(publishMemo, publishArrangeDetail.getPublishMemo());
    }

    public void testGetPublishArrangeDetail() throws Exception {
        PublishArrangeDetail publishArrangeDetail = dao.getPublishArrangeDetail(publishArrangeDetailId);
        assertNotNull(publishArrangeDetail);
    }

    public void testGetPublishArrangeDetails() throws Exception {
        PublishArrangeDetail publishArrangeDetail = new PublishArrangeDetail();

        List results = dao.getPublishArrangeDetails(publishArrangeDetail);
        assertTrue(results.size() > 0);
    }

    public void testSavePublishArrangeDetail() throws Exception {
        PublishArrangeDetail publishArrangeDetail = dao.getPublishArrangeDetail(publishArrangeDetailId);

        // update required fields
        java.lang.Integer publishSort = new Integer(1137993266);
        publishArrangeDetail.setPublishSort(publishSort);        
        java.lang.String specificValue = "PmXzXbEmBxKuLwYqDcVlFwQrYtBdNgCsUwBeGzZaFuCnQpKjDrJaOhRlGfUcZvIgGeDeCeEbUyWmYvGsUzRpQwVrIgEaFySvDjIbRxXjHuWaDkZcRbQuBkPpCiBvJpRn";
        publishArrangeDetail.setSpecificValue(specificValue);        
        java.lang.Long contractId = new Long(1780474071);
        publishArrangeDetail.setContractId(contractId);        
        java.lang.Long customerId = new Long(1156202438);
        publishArrangeDetail.setCustomerId(customerId);        
        java.lang.Long matterId = new Long(260612159);
        publishArrangeDetail.setMatterId(matterId);        
        java.lang.Long orderDayId = new Long(1858187404);
        publishArrangeDetail.setOrderDayId(orderDayId);        
        java.lang.Long orderDetailId = new Long(1178931671);
        publishArrangeDetail.setOrderDetailId(orderDetailId);        
        java.lang.Long orderId = new Long(736875199);
        publishArrangeDetail.setOrderId(orderId);        
        java.lang.Long ownerUserId = new Long(1551262614);
        publishArrangeDetail.setOwnerUserId(ownerUserId);        
        java.lang.String customerName = "DaRgTjRyHrRcDoWyTrZlZwGoUzMfBzHmXtOpGdPmRwOcNoOeSyJaSfMlNzNpIvCfGdFbGeZeDhZyGaZdDgBqBhUdJjRzRfXsHwQkXwFnDfFzZqIrCpXfNlZkMsUmPeFs";
        publishArrangeDetail.setCustomerName(customerName);        
        java.lang.String tapeCode = "RkSrNoUyRoRaNaZeQqLtOrJkHsKmSqMcVvZrErNpEpCuYmPsQjKrUxPnSmHtKpFpHyAdClWbWxVrArUbTtJnYvLiJdQwBuEkMrMtRkGsYoVvYxCeWxWnQrDtKmKvCcVi";
        publishArrangeDetail.setTapeCode(tapeCode);        
        java.lang.String matterEdit = "OuAtItFsYmFlChVuNePbSkOsGiZbSuBeSqBoFiAbZjXdImSmUrAqRdErSpSkMrHbKjZuHmLaQhSvHnIvIdArJvSuLzIpNlMlIfLiVlVqZfEvDvArTvXiYdMcKtBaSqWd";
        publishArrangeDetail.setMatterEdit(matterEdit);        
        java.lang.String matterLength = "ChCbSxFsThQwJqZzAvWkErSwAuGhGjLnOiJfQrGxXlExZpPsLpEyUfJqZzEuJsCbDvSqVuOzIpIsAoCyQnHqHqTxVqFsKdYiSmXvTwEoVoOyYuKjTgOrUqCoMnAaDeLw";
        publishArrangeDetail.setMatterLength(matterLength);        
        java.lang.String matterName = "HuVmJlKwKrKlXcExHqRwKyQiDtEaFmOmJyCdFzXzTkMsNtGtPkDzQrLkKdCvXaKwIxNdJvWcZkEsOaGiGxAhZdGoRwYmInSmBwFxWlSdQnCuMmHaAcYlCqUkQdBwMdEl";
        publishArrangeDetail.setMatterName(matterName);        
        java.lang.String specificName = "ZvKjEzSrWkEeHgGnStLnVrZtKkNhAqEvGmEnFbEzDbVfUsDaWzHiUfWlJoZyTkXlAjUsHvSnRxKkYeNhUbNdDqEjRoPbXaJiIgZnMgSiTzXgOcPaXkDhIkXpXiRrHyDb";
        publishArrangeDetail.setSpecificName(specificName);        
        java.lang.Integer adverTimes = new Integer(1905022199);
        publishArrangeDetail.setAdverTimes(adverTimes);        
        java.lang.String ownerUserName = "QlJhPfDrGwOcLdQhSrLnHkYwPwOvNvXjXbFjHwInJrYxGxEoRmXzVgSsMiEmEgKtErPsWhIrSwSqNhKuNpCsYaQkVnJzYpFcWuPzIrHzLaUwEcJxEvOqVoEgEsRjBwDk";
//        publishArrangeDetail.setOwnerUserName(ownerUserName);        
        java.lang.String publishMemo = "DzOaSkVzYoYyOuYjLtUpFkYtVoNmDqKwBvRuRgGfRxKhAqUqMpVwRjMvBtEoEdFeLfYkWoWgYdQqSlRqRqTaGoIdTiEoFhOlKnJnWzPnDmFuRmRuOmJqPmArFuCcYjJv";
        publishArrangeDetail.setPublishMemo(publishMemo);        

        dao.savePublishArrangeDetail(publishArrangeDetail);

        assertEquals(publishSort, publishArrangeDetail.getPublishSort());
        assertEquals(specificValue, publishArrangeDetail.getSpecificValue());
        assertEquals(contractId, publishArrangeDetail.getContractId());
        assertEquals(customerId, publishArrangeDetail.getCustomerId());
        assertEquals(matterId, publishArrangeDetail.getMatterId());
        assertEquals(orderDayId, publishArrangeDetail.getOrderDayId());
        assertEquals(orderDetailId, publishArrangeDetail.getOrderDetailId());
        assertEquals(orderId, publishArrangeDetail.getOrderId());
        assertEquals(ownerUserId, publishArrangeDetail.getOwnerUserId());
        assertEquals(customerName, publishArrangeDetail.getCustomerName());
        assertEquals(tapeCode, publishArrangeDetail.getTapeCode());
        assertEquals(matterEdit, publishArrangeDetail.getMatterEdit());
        assertEquals(matterLength, publishArrangeDetail.getMatterLength());
        assertEquals(matterName, publishArrangeDetail.getMatterName());
        assertEquals(specificName, publishArrangeDetail.getSpecificName());
        assertEquals(adverTimes, publishArrangeDetail.getAdverTimes());
        assertEquals(ownerUserName, publishArrangeDetail.getOwnerUserName());
        assertEquals(publishMemo, publishArrangeDetail.getPublishMemo());
    }

    public void testRemovePublishArrangeDetail() throws Exception {
        Long removeId = new Long("3");
        dao.removePublishArrangeDetail(removeId);
        try {
            dao.getPublishArrangeDetail(removeId);
            fail("publishArrangeDetail found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
   public void testRemovePublishArrangeDetails(final Map idList) throws Exception {
        try {
        	dao.removePublishArrangeDetails(idList);
            fail("publishArrangeDetail found in database");
        } catch (ObjectRetrievalFailureException e) {
            assertNotNull(e.getMessage());
        }
    }
}
