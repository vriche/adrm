package com.vriche.adrm.util;

//import com.dayang.adp.service.importbroadcastlistservice._0.ImportBroadcastList;
//import com.dayang.adp.service.importmaterialservice._0.ImportMaterialServiceImpl;
import com.vriche.adrm.dao.AnalySumDao;
import com.vriche.adrm.dao.CarrierDao;
import com.vriche.adrm.dao.CarrierTypeDao;
import com.vriche.adrm.dao.ContractDao;
import com.vriche.adrm.dao.ContractPaymentDao;
import com.vriche.adrm.dao.CustomerDao;
import com.vriche.adrm.dao.Dao;
import com.vriche.adrm.dao.DayInfoDao;
import com.vriche.adrm.dao.IncomePullDao;
import com.vriche.adrm.dao.IndustryDao;
import com.vriche.adrm.dao.MatterDao;
import com.vriche.adrm.dao.OaWorkFlowCheckDao;
import com.vriche.adrm.dao.OrderDao;
import com.vriche.adrm.dao.OrderDayInfoDao;
import com.vriche.adrm.dao.OrderDetailDao;
import com.vriche.adrm.dao.OrderLogDao;
import com.vriche.adrm.dao.OrgDao;
import com.vriche.adrm.dao.PriceDao;
import com.vriche.adrm.dao.PriceDetailDao;
import com.vriche.adrm.dao.PublishArrangeDao;
import com.vriche.adrm.dao.PublishArrangeDetailDao;
import com.vriche.adrm.dao.ResourceDao;
import com.vriche.adrm.dao.SysParamDao;
import com.vriche.adrm.dao.UserDao;
import com.vriche.adrm.dao.WorkspanDao;
import com.vriche.adrm.service.ContractPaymentManager;
import com.vriche.adrm.service.IncomeManager;
import com.vriche.adrm.service.LookupManager;
import com.vriche.adrm.service.MatterManager;
import com.vriche.adrm.service.OrderDetailManager;
import com.vriche.adrm.service.OrderManager;
import com.vriche.adrm.service.ResourceChannelManager;
import com.vriche.adrm.service.ResourceManager;
import com.vriche.adrm.service.RoleManager;
import com.vriche.adrm.service.security.acegi.cache.AcegiCacheManager;

public class ServiceLocator { 
	
    
    public static CarrierDao getCarrierDao() {
        return (CarrierDao)SpringContext.getBean("carrierDao");
    }
    
    
    public static Dao getDao() {
        return (Dao)SpringContext.getBean("dao");
    }
    
    public static DayInfoDao getDayInfoDao() {
        return (DayInfoDao)SpringContext.getBean("dayInfoDao");
    }
    public static OrderDayInfoDao getOrderDayInfoDao() {
        return (OrderDayInfoDao)SpringContext.getBean("orderDayInfoDao");
    }
    
    public static ResourceDao getResourceDao() {
        return (ResourceDao)SpringContext.getBean("resourceDao");
    }
    
    public static IndustryDao getIndustrysDao() {
        return (IndustryDao)SpringContext.getBean("industryDao");
    }  
    
    
    public static PublishArrangeDetailDao getPublishArrangeDetailDao() {
   	 return (PublishArrangeDetailDao)SpringContext.getBean("publishArrangeDetailDao");
   }  
   
    
    public static UserDao getUserDao() {
    	 return (UserDao)SpringContext.getBean("userDao");
    }  
    
    public static OaWorkFlowCheckDao getOaWorkFlowCheckDao() {
   	 return (OaWorkFlowCheckDao)SpringContext.getBean("oaWorkFlowCheckDao");
   }   
    

    public static CustomerDao getCustomerDao() {
   	 return (CustomerDao)SpringContext.getBean("customerDao");
   }  
    
    
    public static OrderLogDao getOrderLogDao() {
      	 return (OrderLogDao)SpringContext.getBean("orderLogDao");
      }     
    
    public static OrderDao getOrderDao() {
     	 return (OrderDao)SpringContext.getBean("orderDao");
     }    
    public static SysParamDao getSysParamDao() {
    	 return (SysParamDao)SpringContext.getBean("sysParamDao");
    }    
  
    public static OrgDao getOrgDao() {
    	 return (OrgDao)SpringContext.getBean("orgDao");
    } 
    
    public static AnalySumDao getAnalySumDao() {
   	 return (AnalySumDao)SpringContext.getBean("analySumDao");
   } 
    
    public static WorkspanDao getWorkspanDao() {
      	 return (WorkspanDao)SpringContext.getBean("workspanDao");
      }   
    
    public static PriceDao getPriceDao() {
     	 return (PriceDao)SpringContext.getBean("priceDao");
     }   
    
    public static PriceDetailDao getPriceDetailDao() {
    	 return (PriceDetailDao)SpringContext.getBean("priceDetailDao");
    }   
    
    
    
    public static IncomePullDao getIncomePullDao() {
        return (IncomePullDao)SpringContext.getBean("incomePullDao");
    }    
    
    
    public static ContractDao getContractDao() {
        return (ContractDao)SpringContext.getBean("contractDao");
    }    
    
    
    public static ContractPaymentDao getContractPaymentDao() {
        return (ContractPaymentDao)SpringContext.getBean("contractPaymentDao");
    }    
    
    public static PublishArrangeDao getPublishArrangeDao() {
        return (PublishArrangeDao)SpringContext.getBean("publishArrangeDao");
    }  
    
    
    
    
    
    
    public static OrderManager getOrderManager() {
      	 return (OrderManager)SpringContext.getBean("orderManager");
      }    
    
    
    public static OrderDetailManager getOrderDetailManager() {
     	 return (OrderDetailManager)SpringContext.getBean("orderDetailManager");
     }    
    
    
    public static OrderDetailDao getOrderDetailDao() {
    	 return (OrderDetailDao)SpringContext.getBean("orderDetailDao");
    }    
    
    public static AcegiCacheManager getAcegiCacheManager() {
     	 return (AcegiCacheManager)SpringContext.getBean("acegiCacheManager");
     }   
    
    
    
    public static ResourceManager getResourceManager() {
    	 return (ResourceManager)SpringContext.getBean("resourceManager");
    }   
    
    public static ContractPaymentManager getContractPaymentManager() {
   	 return (ContractPaymentManager)SpringContext.getBean("contractPaymentManager");
   }   
   
    
   
    public static LookupManager getLookupManager() {
    	 return (LookupManager)SpringContext.getBean("lookupManager");
    }     
    
    public static MatterManager getMatterManager() {
   	 return (MatterManager)SpringContext.getBean("matterManager");
   } 
    
    
    public static MatterDao getMatterDao() {
      	 return (MatterDao)SpringContext.getBean("matterDao");
      } 

    public static CarrierTypeDao getCarrierTypeDao() {
      	 return (CarrierTypeDao)SpringContext.getBean("carrierTypeDao");
     } 
    
    
    public static IncomeManager getIncomeManager() {
      	 return (IncomeManager)SpringContext.getBean("incomeManager");
      } 
    
    
    public static RoleManager getRoleManager() {
     	 return (RoleManager)SpringContext.getBean("roleManager");
     } 
    
    public static ResourceChannelManager getResourceChannelManager() {
    	 return (ResourceChannelManager)SpringContext.getBean("resourceChannelManager");
    } 
    
//    public static ImportMaterialServiceImpl getImportMaterialManager() {
//    	 return (ImportMaterialServiceImpl)SpringContext.getBean("dayangImportMaterial");
//    } 
//    
//   public static ImportBroadcastList getImportBroadcastListManager() {
//    	 return (ImportBroadcastList)SpringContext.getBean("dayangImportBroadcastList");
//    } 

    
}
