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
   
	// 0 �������
    public List getOrderCategory(String level);
    
    // 1 ���������
    public List getOrderCategoryLevelSecond(String parentId);
    
    
    public Map getOrderCategoryLevelSecondMap(String parentId);
    
    // 2 �û���
    public List getUser(String level,User user);
    
    // 3 ����
    public List getCarrier(String level,User user);
    
    // 4 ���λ��
    public List getResourceInfo(String level,User user);
    
    // 5 ָ��
    public List getResourceSpecific(String level,User user);  
    
    // 6 ��ҵ
    public List getIndustry(String level,User user);    
    
    // 7 �۸����
    public List getResourcePriceType(String level,User user);
    
    // 8 �ͻ�����
    public List getCustomerNames(String level,User user);    
    
    // 9 �ͻ�����
    public List getCustomerCategory(String level,User user);   
    
    // 12 �ͻ����
    public List getCustomerType(String level,User user);
    
    // 13 �������
    public List getCarrierTypes(String level,User user);
    
    // 14 ý�����  
    public List getMediaOrgs(String level,User user);
    
    
    // 15 Ƶ��
    public List getResourceChannels(String level,User user);
    
    // 16 ��Դ��� 
    public List getResourceType(String level,User user);
    
    // 17 ���ʽ
    public List getIncomeMode(String level,User user);   
    
    // 18 ������;
    public List getIncomePurpose(String level,User user); 
    
    //�����Դ
    public Map getResourceInfoMap(String level,User user);
    
    //�۸�
    public Map getPricesMap(String resourceInfoId,String length, User user);
    

    
    // 20 ��Ϣ���
    public List getOaInfoType(String level,User user);    
    
    // 21 ���������
    public List getOaWorkFlowType(String level,User user);       
    
    // 22 �������״̬
    public List getOaWorkFlowResult(String level,User user);    
    
    // 23 ��Ʒ���
    public List getOaProductType(String level,User user);       
    
    // 24 �ʲ����
    public List getOaAssetsType(String level,User user);    
    
    // 25 �ʲ�״̬
    public List getOaAssetsState(String level,User user);    
    
    // 26 Ŀ¼Ȩ�����
    public List getOaDocPermitType(String level,User user);    
    
    // 27 ��������
    public List getOaAreaCity(String level,User user);       
    
    // 28 ��������
    public List getOaAreaPc(String level,User user);      

    // 29 �û�����
    public List getSysUserType(String level,User user);   
    
    // 30 ���ű�
    public List getSysBranch(String level,User user);   
    
    // 31 ϵͳ�¼�����
    public List getSysEventType(String level,User user);  
    
    // 32 �¼�ִ��״̬��
    public List getSysEventState(String level,User user);   
    
    // 33 ϵͳ��ʾ��ʽ
    public List getSysPromptMode(String level,User user);   
    
    // 34 ��֯
    public List getSysOrg(String level,User user);   
    public List getParentSysOrg();
    
    // 35 ������ת��ʽ
    public List getWorkFlowMoveTypes(String level,User user);   
    
    // 35 �������״̬
    public List getWorkFlowCheckState(String level,User user); 
    
    // 40 �����ʽ
    public List getResourceSort(String level,User user);
    // 41 ������ 
    public List getMatterType(String level,User user);
    
    // 42 �û���
    public List getUserByOrg(String orgId);
    

    
}


