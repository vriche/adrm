/****************************************************************************     
 * Created on 2006-10-31                                                     *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.service;

import java.util.List;
import java.util.Map;

import com.vriche.adrm.model.TreeNode;
import com.vriche.adrm.model.User;

/**
 * SelectListManager class
 * 
 * This class is used to 
 * 
 * <p><a href="SelectListManager.java.html"><i>View Source</i></a></p>
 * 
 */
public interface SelectListManager {
   
	// 0 订单类别
    public List getOrderCategory(String level);
    
    // 1 订单子类别
    public List getOrderCategoryLevelSecond(String parentId);
    
    
    public Map getOrderCategoryLevelSecondMap(String parentId);
    
    // 2 用户名
    public List getUser(String level,User user);
    
    // 3 载体
    public List getCarrier(String level,User user);
    
    // 4 广告位置
    public List getResourceInfo(String level,User user);
    
    // 5 指定
    public List getResourceSpecific(String level,User user);  
    
    // 6 行业
    public List getIndustry(String level,User user);    
    
    // 7 价格类别
    public List getResourcePriceType(String level,User user);
    
    // 8 客户名称
    public List getCustomerNames(String level,User user);    
    
    // 9 客户分类
    public List getCustomerCategory(String level,User user);   
    
    // 12 客户类别
    public List getCustomerType(String level,User user);
    
    // 13 载体类别
    public List getCarrierTypes(String level,User user);
    
    // 14 媒体机构  
    public List getMediaOrgs(String level,User user);
    
    
    // 15 频道
    public List getResourceChannels(String level,User user);
    
    // 16 资源类别 
    public List getResourceType(String level,User user);
    
    // 17 到款方式
    public List getIncomeMode(String level,User user);   
    
    // 18 到款用途
    public List getIncomePurpose(String level,User user); 
    
    //广告资源
    public Map getResourceInfoMap(String level,User user);
    
    //价格
    public Map getPricesMap(String resourceInfoId,String length, User user);
    

    
    // 20 信息类别
    public List getOaInfoType(String level,User user);    
    
    // 21 工作流类别
    public List getOaWorkFlowType(String level,User user);       
    
    // 22 审批结果状态
    public List getOaWorkFlowResult(String level,User user);    
    
    // 23 用品类别
    public List getOaProductType(String level,User user);       
    
    // 24 资产类别
    public List getOaAssetsType(String level,User user);    
    
    // 25 资产状态
    public List getOaAssetsState(String level,User user);    
    
    // 26 目录权限类别
    public List getOaDocPermitType(String level,User user);    
    
    // 27 城市名称
    public List getOaAreaCity(String level,User user);       
    
    // 28 邮政编码
    public List getOaAreaPc(String level,User user);      

    // 29 用户类别表
    public List getSysUserType(String level,User user);   
    
    // 30 部门表
    public List getSysBranch(String level,User user);   
    
    // 31 系统事件类型
    public List getSysEventType(String level,User user);  
    
    // 32 事件执行状态表
    public List getSysEventState(String level,User user);   
    
    // 33 系统提示方式
    public List getSysPromptMode(String level,User user);   
    
    // 34 组织
    public List getSysOrg(String level,User user);   
    public List getParentSysOrg();
    
    // 35 流程流转方式
    public List getWorkFlowMoveTypes(String level,User user);   
    
    // 35 流程审核状态
    public List getWorkFlowCheckState(String level,User user); 
    
    // 40 广告形式
    public List getResourceSort(String level,User user);
    // 41 广告类别 
    public List getMatterType(String level,User user);
    
    // 42 用户名
    public List getUserByOrg(String orgId);
    

    
}


