package com.vriche.adrm.webapp.taglib;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.displaytag.tags.el.ExpressionEvaluator;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.vriche.adrm.model.Branch;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.CarrierType;
import com.vriche.adrm.model.Category;
import com.vriche.adrm.model.Customer;
import com.vriche.adrm.model.CustomerType;
import com.vriche.adrm.model.IncomeMode;
import com.vriche.adrm.model.IncomePurpose;
import com.vriche.adrm.model.Industry;
import com.vriche.adrm.model.LabelValue;
import com.vriche.adrm.model.MediaOrg;
import com.vriche.adrm.model.OaAreaCity;
import com.vriche.adrm.model.OaAreaPc;
import com.vriche.adrm.model.OaAssetsState;
import com.vriche.adrm.model.OaAssetsType;
import com.vriche.adrm.model.OaDocumentCatalogPermitType;
import com.vriche.adrm.model.OaInfoType;
import com.vriche.adrm.model.OaProductType;
import com.vriche.adrm.model.OaWorkFlowCheckResult;
import com.vriche.adrm.model.OaWorkFlowCheckState;
import com.vriche.adrm.model.OaWorkFlowMoveType;
import com.vriche.adrm.model.OaWorkFlowType;
import com.vriche.adrm.model.OrderCategory;
import com.vriche.adrm.model.Org;
import com.vriche.adrm.model.PriceType;
import com.vriche.adrm.model.Resource;
import com.vriche.adrm.model.ResourceChannel;
import com.vriche.adrm.model.ResourceSort;
import com.vriche.adrm.model.ResourceType;
import com.vriche.adrm.model.Specific;
import com.vriche.adrm.model.SysEventState;
import com.vriche.adrm.model.SysEventType;
import com.vriche.adrm.model.SysPromptMode;
import com.vriche.adrm.model.SysUserType;
import com.vriche.adrm.model.User;
import com.vriche.adrm.service.SelectListManager;
import com.vriche.adrm.util.SysParamUtil;
import com.vriche.adrm.model.MatterType;

/**
 * Tag for creating multiple &lt;select&gt; options for displaying a list of
 * country names.
 *
 * <p>
 * <b>NOTE</b> - This tag requires a Java2 (JDK 1.2 or later) platform.
 * </p>
 *
 * @author Jens Fischer, Matt Raible
 * @version $Revision: 1.1 $ $Date: 2007/04/05 01:39:44 $
 *
 * @jsp.tag name="selectList" bodycontent="empty"
 */
public class SelectListTag extends TagSupport {
	private static final long serialVersionUID = 3905528206810167095L;
    private String name;
    private String prompt;
    private String scope;
    private String selected;
    private int key;
    private User user;
    private String level;

    /**
     * @param name The name to set.
     *
     * @jsp.attribute required="false" rtexprvalue="true"
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /**
     * @param prompt The prompt to set.
     * @jsp.attribute required="false" rtexprvalue="true"
     */
    public void setPrompt(String prompt) {
        this.prompt = prompt;
    }

    
    /**
     * @param selected The selected option.
     * @jsp.attribute required="false" rtexprvalue="true"
     */
    public void setDefault(String selected) {
        this.selected = selected;
    }

    /**
     * Property used to simply stuff the list of countries into a
     * specified scope.
     *
     * @param scope
     *
     * @jsp.attribute required="false" rtexprvalue="true"
     */
    public void setToScope(String scope) {
        this.scope = scope;
    }
    
    /**
     * @param name The name to set.
     *
     * @jsp.attribute required="false" rtexprvalue="true"
     */
    public void setKey(int key) {
        this.key = key;
    }
    
    /**
     * @param name The name to set.
     *
     * @jsp.attribute required="false" rtexprvalue="true"
     */
    public void setLevel(String level) {
        this.level = level;
    }
    /**
     * @param name The name to set.
     *
     * @jsp.attribute required="false" rtexprvalue="true"
     */
    public void setUser(User user) {
        this.user = user;
    }
    
    
    

    /**
     * Process the start of this tag.
     *
     * @return int status
     *
     * @exception JspException if a JSP exception has occurred
     *
     * @see javax.servlet.jsp.tagext.Tag#doStartTag()
     */
    public int doStartTag() throws JspException {
        ExpressionEvaluator eval = new ExpressionEvaluator(this, pageContext);

        if (selected != null) {
            selected = eval.evalString("default", selected);
        }

        List selects = this.buildSelectList(key,level,user);
        
       
        
        if (scope != null) {
            if (scope.equals("page")) {
                pageContext.setAttribute(name, selects);
            } else if (scope.equals("request")) {
                pageContext.getRequest().setAttribute(name, selects);
            } else if (scope.equals("session")) {
                pageContext.getSession().setAttribute(name, selects);
            } else if (scope.equals("application")) {
                pageContext.getServletContext().setAttribute(name, selects);
            } else {
                throw new JspException("Attribute 'scope' must be: page, request, session or application");
            }
        } else {
            StringBuffer sb = new StringBuffer();
            sb.append("<select name=\"" + name + "\" id=\"" + name + "\" class=\"select\">\n");

            if (prompt != null) {
                sb.append("    <option class=\"select\" value=\"\" selected=\"selected\">");
                sb.append(eval.evalString("prompt", prompt) + "</option>\n");
            }

            for (Iterator i = selects.iterator(); i.hasNext();) {
                LabelValue opt = (LabelValue) i.next();
                sb.append("    <option class=\"select\" value=\"" + opt.getValue() + "\"");

                if ((selected != null) && selected.equals(opt.getValue())) {
                    sb.append(" selected=\"selected\"");
                }

                sb.append(">" + opt.getLabel() + "</option>\n");
            }

            sb.append("</select>");
            

            try {
                pageContext.getOut().write(sb.toString());
            } catch (IOException io) {
                throw new JspException(io);
            }
        }

        return super.doStartTag();
    }
    

    /**
     * Release aquired resources to enable tag reusage.
     *
     * @see javax.servlet.jsp.tagext.Tag#release()
     */
    public void release() {
        super.release();
    }

    /**
     * Build a List of LabelValues for all the available countries. Uses
     * the two letter uppercase ISO name of the country as the value and the
     * localized country name as the label.
     *
     * @param locale The Locale used to localize the country names.
     *
     * @return List of LabelValues for all available countries.
     */
    protected List buildSelectList(int key,String level,User user) {
//        final String EMPTY = "";

        List selects = new ArrayList();
        List rt = new ArrayList();
        
        
        SelectListManager mgr = (SelectListManager) getBean("selectListManager");
        
        switch(key){
        	case 0: //订单类别
        	    selects = mgr.getOrderCategory(level);
                Iterator it0 = selects.iterator();
                while (it0.hasNext()){
                    OrderCategory orderCategory = (OrderCategory)it0.next();
                    LabelValue lb = new LabelValue(orderCategory.getName() +" || "+orderCategory.getValue(),orderCategory.getId().toString());
                    rt.add(lb);
                }
        		break;	  
        		
        	case 1: //订单子类别
        	    
        	    selects = mgr.getOrderCategoryLevelSecond(level);
                Iterator it01 = selects.iterator();
                while (it01.hasNext()){
                    OrderCategory orderCategory = (OrderCategory)it01.next();
                    LabelValue lb = new LabelValue(orderCategory.getName() +" || "+orderCategory.getValue().toString(),orderCategory.getId().toString());
                    rt.add(lb);
                }
        		break;	         		
          	case 2: //业务员
          	    selects = mgr.getUser(level,user);
                Iterator it2 = selects.iterator();
                while (it2.hasNext()){
                    User ur = (User)it2.next();
                    LabelValue lb = new LabelValue(ur.getFullName(),ur.getId().toString());
                    rt.add(lb);
                }        	    
        		break;
          	case 3: //载体
          	    selects = mgr.getCarrier(level,user);
                Iterator it3 = selects.iterator();
                rt.add( new LabelValue("",""));  
                while (it3.hasNext()){
                    Carrier carrier = (Carrier)it3.next();
                    LabelValue lb = new LabelValue(carrier.getCarrierName(),carrier.getId().toString());
                    rt.add(lb);
                }             	    
        		break;
          	case 4 : //广告位置
          	    selects = mgr.getResourceInfo(level,user);
	            Iterator it4 = selects.iterator();
	            while (it4.hasNext()){
	                Resource resource = (Resource)it4.next();
	                LabelValue lb = new LabelValue(resource.getResourceName(),resource.getId().toString());
	                rt.add(lb);
	            }             	
          	    break;
	    
          	case 5 : //指定
          	    selects = mgr.getResourceSpecific(level,user);
	            Iterator it5 = selects.iterator();
	            while (it5.hasNext()){
	                Specific specific = (Specific)it5.next();
	                LabelValue lb = new LabelValue(specific.getName()+" || "+specific.getPosition(),specific.getId().toString());
	                rt.add(lb);
	            }             	
          	    break;     
          	    
          	case 6 : //行业
          	    selects = mgr.getIndustry(level,user);
	            Iterator it6 = selects.iterator();
	            while (it6.hasNext()){
	                Industry industry = (Industry)it6.next();
//	                LabelValue lb = new LabelValue(industry.getCode()+"||"+industry.getName(),industry.getId().toString());
	                LabelValue lb = new LabelValue(industry.getCode()+" || "+ industry.getName(),industry.getId().toString());
	                rt.add(lb);
	            }             	
          	    break;   	    
 
          	case 7 : //价格类别
          	    selects = mgr.getResourcePriceType(level,user);
	            Iterator it7 = selects.iterator();
	            while (it7.hasNext()){
	            	PriceType priceType = (PriceType)it7.next();
	                LabelValue lb = new LabelValue(priceType.getPriceTypeName()+" ||"+priceType.getValue(),priceType.getId().toString());
	                rt.add(lb);
	            }             	
          	    break;     
          	    
          	case 8 : //客户名称
          	    selects = mgr.getCustomerNames(level,user);
	            Iterator it8 = selects.iterator();
	            while (it8.hasNext()){
	            	Customer customer = (Customer)it8.next();
//	                LabelValue lb = new LabelValue(customer.getCustomerName()+" ||"+customer.getDiscountRate(),customer.getId().toString());
	            	LabelValue lb = new LabelValue(customer.getCustomerName(),customer.getId().toString());
	                rt.add(lb);
	            }             	
          	    break;        
          	        
          	case 9 : //客户类别
          	    selects = mgr.getCustomerType(level,user);
	            Iterator it9 = selects.iterator();
	            while (it9.hasNext()){
	            	CustomerType customerType = (CustomerType)it9.next();
	            	LabelValue lb = new LabelValue(customerType.getName(),customerType.getId().toString());
	                rt.add(lb);
	            }             	
          	    break;     
          	    
          	case 10 : //月份
	            for (int i=0;i<13;i++){
	            	LabelValue lb = new LabelValue(String.valueOf(i).toString(),String.valueOf(i).toString());
	                rt.add(lb);
	            }          	
          	    break;            	    
          	    
          	case 11 : //日 31天
	            for (int i=0;i<32;i++){
	            	LabelValue lb = new LabelValue(String.valueOf(i).toString(),String.valueOf(i).toString());
	                rt.add(lb);
	            }          	
          	    break;    
          	    
          	case 12 : //客户类别
          	    selects = mgr.getCustomerCategory(level,user);
	            Iterator it12 = selects.iterator();
	            while (it12.hasNext()){
	            	Category customerCategory = (Category)it12.next();
	            	if(!customerCategory.getCategoryName().equals("所有客户")){
		            	LabelValue lb = new LabelValue(customerCategory.getCategoryName(),customerCategory.getId().toString());
		                rt.add(lb);
	            	}
	            }             	
          	    break;   
          	case 13: //载体类别
          	    selects = mgr.getCarrierTypes(level,user);
                Iterator it13 = selects.iterator();
                while (it13.hasNext()){
                	CarrierType carrierType = (CarrierType)it13.next();
                    LabelValue lb = new LabelValue(carrierType.getName(),carrierType.getId().toString());
                    rt.add(lb);
                }             	    
        		break;         	    
          	case 14: //媒体机构
          	    selects = mgr.getMediaOrgs(level,user);
                Iterator it14 = selects.iterator();
                while (it14.hasNext()){
                	MediaOrg mediaOrg = (MediaOrg)it14.next();
                    LabelValue lb = new LabelValue(mediaOrg.getName(),mediaOrg.getId().toString());
                    rt.add(lb);
                }             	    
        		break;     	  
          	case 15: //频道 一套 二套
          	    selects = mgr.getResourceChannels(level,user);
                Iterator it15 = selects.iterator();
                while (it15.hasNext()){
                	ResourceChannel resourceChannel = (ResourceChannel)it15.next();
                    LabelValue lb = new LabelValue(resourceChannel.getName(),resourceChannel.getId().toString());
                    rt.add(lb);
                }             	    
        		break;    
        		
          	case 16: //资源类别 如黄金
          	    selects = mgr.getResourceType(level,user);
                Iterator it16 = selects.iterator();
                while (it16.hasNext()){
                	ResourceType resourceType = (ResourceType)it16.next();
                    LabelValue lb = new LabelValue(resourceType.getName(),resourceType.getId().toString());
                    rt.add(lb);
                }             	    
        		break;   
        		
          	case 17: //到款方式 
          	    selects = mgr.getIncomeMode(level,user);
                Iterator it17 = selects.iterator();
                while (it17.hasNext()){
                	IncomeMode incomeMode = (IncomeMode)it17.next();
                    LabelValue lb = new LabelValue(incomeMode.getName(),incomeMode.getId().toString());
                    rt.add(lb);
                }             	    
        		break;   
        		
          	case 18: //到款用途 
          	    selects = mgr.getIncomePurpose(level,user);
                Iterator it18 = selects.iterator();
                while (it18.hasNext()){
                	IncomePurpose incomePurpose = (IncomePurpose)it18.next();
                    LabelValue lb = new LabelValue(incomePurpose.getName(),incomePurpose.getId().toString());
                    rt.add(lb);
                }             	    
        		break;    
        		
        		
          	case 19 : //年
	            for (int i=0;i<15;i++){
	            	LabelValue lb = new LabelValue(String.valueOf(i+2005).toString(),String.valueOf(i+1900).toString());
	                rt.add(lb);
	            }          	
          	    break;     
          	    
          	   
          	    
          	    
          	    
          	    
          	case 20: //信息类别 
          	    selects = mgr.getOaInfoType(level,user);
                Iterator it20 = selects.iterator();
                while (it20.hasNext()){
                	OaInfoType oaInfoType = (OaInfoType)it20.next();
                    LabelValue lb = new LabelValue(oaInfoType.getName(),oaInfoType.getId().toString());
                    rt.add(lb);
                }             	    
        		break;    
        		
          	case 21: //工作流类别 
          	    selects = mgr.getOaWorkFlowType(level,user);
                Iterator it21 = selects.iterator();
                while (it21.hasNext()){
                	OaWorkFlowType oaWorkFlowType = (OaWorkFlowType)it21.next();
                    LabelValue lb = new LabelValue(oaWorkFlowType.getName(),oaWorkFlowType.getId().toString());
                    rt.add(lb);
                }             	    
        		break;    
        		
          	case 22: //审批结果状态 
          	    selects = mgr.getOaWorkFlowResult(level,user);
                Iterator it22 = selects.iterator();
                while (it22.hasNext()){
                	OaWorkFlowCheckResult oaWorkFlowCheckResult = (OaWorkFlowCheckResult)it22.next();
                    LabelValue lb = new LabelValue(oaWorkFlowCheckResult.getName(),oaWorkFlowCheckResult.getId().toString());
                    rt.add(lb);
                }             	    
        		break;           		
        		
        		
          	case 23: //用品类别 
          	    selects = mgr.getOaProductType(level,user);
                Iterator it23 = selects.iterator();
                while (it23.hasNext()){
                	OaProductType oaProductType = (OaProductType)it23.next();
                    LabelValue lb = new LabelValue(oaProductType.getName(),oaProductType.getId().toString());
                    rt.add(lb);
                }             	    
        		break;           		
          	    
          	    
          	case 24: //资产类别 
          	    selects = mgr.getOaAssetsType(level,user);
                Iterator it24 = selects.iterator();
                while (it24.hasNext()){
                	OaAssetsType oaAssetsType = (OaAssetsType)it24.next();
                    LabelValue lb = new LabelValue(oaAssetsType.getName(),oaAssetsType.getId().toString());
                    rt.add(lb);
                }             	    
        		break;            	    
          	    
          	case 25: //资产状态 
          	    selects = mgr.getOaAssetsState(level,user);
                Iterator it25 = selects.iterator();
                while (it25.hasNext()){
                	OaAssetsState oaAssetsState = (OaAssetsState)it25.next();
                    LabelValue lb = new LabelValue(oaAssetsState.getName(),oaAssetsState.getId().toString());
                    rt.add(lb);
                }             	    
        		break;    
        		
          	case 26: //目录权限类别 
          	    selects = mgr.getOaDocPermitType(level,user);
                Iterator it26 = selects.iterator();
                while (it26.hasNext()){
                	OaDocumentCatalogPermitType oaDocumentCatalogPermitType = (OaDocumentCatalogPermitType)it26.next();
                    LabelValue lb = new LabelValue(oaDocumentCatalogPermitType.getName(),oaDocumentCatalogPermitType.getId().toString());
                    rt.add(lb);
                }             	    
        		break;    
        		
          	case 27: //城市名称 
          	    selects = mgr.getOaAreaCity(level,user);
                Iterator it27 = selects.iterator();
                while (it27.hasNext()){
                	OaAreaCity oaAreaCity = (OaAreaCity)it27.next();
                    LabelValue lb = new LabelValue(oaAreaCity.getName(),oaAreaCity.getId().toString());
                    rt.add(lb);
                }             	    
        		break;            		
          	    
          	case 28: //邮政编码 
          	    selects = mgr.getOaAreaPc(level,user);
                Iterator it28 = selects.iterator();
                while (it28.hasNext()){
                	OaAreaPc oaAreaPc = (OaAreaPc)it28.next();
                    LabelValue lb = new LabelValue(oaAreaPc.getName(),oaAreaPc.getId().toString());
                    rt.add(lb);
                }             	    
        		break;    
        		
          	case 29: //用户类别表 
          	    selects = mgr.getSysUserType(level,user);
                Iterator it29 = selects.iterator();
                while (it29.hasNext()){
                	SysUserType sysUserType = (SysUserType)it29.next();
                    LabelValue lb = new LabelValue(sysUserType.getName(),sysUserType.getId().toString());
                    rt.add(lb);
                }             	    
        		break;    
        		
          	case 30: //部门表 
          	    selects = mgr.getSysBranch(level,user);
                Iterator it30 = selects.iterator();
                while (it30.hasNext()){
                	Branch branch = (Branch)it30.next();
                    LabelValue lb = new LabelValue(branch.getName(),branch.getId().toString());
                    rt.add(lb);
                }             	    
        		break;    
        		
          	case 31: //系统事件类型 
          	    selects = mgr.getSysEventType(level,user);
                Iterator it31 = selects.iterator();
                while (it31.hasNext()){
                	SysEventType sysEventType = (SysEventType)it31.next();
                    LabelValue lb = new LabelValue(sysEventType.getName(),sysEventType.getId().toString());
                    rt.add(lb);
                }             	    
        		break;    
        		
          	case 32: //事件执行状态表 
          	    selects = mgr.getSysEventState(level,user);
                Iterator it32 = selects.iterator();
                while (it32.hasNext()){
                	SysEventState sysEventState = (SysEventState)it32.next();
                    LabelValue lb = new LabelValue(sysEventState.getName(),sysEventState.getId().toString());
                    rt.add(lb);
                }             	    
        		break;         		
        		
          	case 33: //系统提示方式 
          	    selects = mgr.getSysPromptMode(level,user);
                Iterator it33 = selects.iterator();
                while (it33.hasNext()){
                	SysPromptMode sysPromptMode = (SysPromptMode)it33.next();
                    LabelValue lb = new LabelValue(sysPromptMode.getName(),sysPromptMode.getId().toString());
                    rt.add(lb);
                }             	    
        		break;         		
        		
          	case 34: //系统提示方式 
          	    selects = mgr.getSysOrg(level,user);
                Iterator it34 = selects.iterator();
                while (it34.hasNext()){
                	Org org = (Org)it34.next();
                    LabelValue lb = new LabelValue(org.getName(),org.getId().toString());
                    rt.add(lb);
                }             	    
        		break;     
        		
          	case 35: //流程流转方式 
          	    selects = mgr.getWorkFlowMoveTypes(level,user);
                Iterator it35 = selects.iterator();
                while (it35.hasNext()){
                	OaWorkFlowMoveType workFlowMoveType = (OaWorkFlowMoveType)it35.next();
                    LabelValue lb = new LabelValue(workFlowMoveType.getName(),workFlowMoveType.getId().toString());
                    rt.add(lb);
                }             	    
        		break;     
        		
          	case 36: //流程流转方式 
          	    selects = mgr.getWorkFlowCheckState(level,user);
                Iterator it36 = selects.iterator();
                while (it36.hasNext()){
                	OaWorkFlowCheckState OaWorkFlowCheckState = (OaWorkFlowCheckState)it36.next();
                    LabelValue lb = new LabelValue(OaWorkFlowCheckState.getName(),OaWorkFlowCheckState.getId().toString());
                    rt.add(lb);
                }             	    
        		break;  
        		
          	case 37: //合同性质
          		
//          		if(!SysParamUtil.isHNTVParam(null) && !SysParamUtil.isSJZTVParam(null)){
//                     LabelValue lb1 = new LabelValue("协议","1");
//                     rt.add(lb1);    
//          		}

                LabelValue lb = new LabelValue("协约合同","0");
                rt.add(lb);
                
                LabelValue lb1 = new LabelValue("协议","1");
                rt.add(lb1);                   
                 
//                if(SysParamUtil.getWithResourceSort()){
//                    LabelValue lb22 = new LabelValue("部门订单","2");
//                    rt.add(lb22);  	
//                }
                
//                if(!SysParamUtil.isHNTVParam(null) && !SysParamUtil.isSJZTVParam(null)){
//                    LabelValue lb22 = new LabelValue("部门订单","2");
//                    rt.add(lb22);  
//                }
   
              
    		break;  
    		
          	case 38: //合同类别
                LabelValue lb2 = new LabelValue("销售合同","0");
                rt.add(lb2);
                LabelValue lb3 = new LabelValue("购买合同","1");
                rt.add(lb3);           	    
    		break;  
    		
          	case 39: //到期通知
                LabelValue lb4 = new LabelValue("15天","15");
                rt.add(lb4);
                LabelValue lb5 = new LabelValue("30天","30");
                rt.add(lb5);  
                LabelValue lb6 = new LabelValue("45天","45");
                rt.add(lb6);
                LabelValue lb7 = new LabelValue("60天","60");
                rt.add(lb7); 
                LabelValue lb8 = new LabelValue("90天","90");
                rt.add(lb8); 
    		break; 
    		
    		
          	case 40: //广告形式 
          	    selects = mgr.getResourceSort(level,user);
                Iterator it40 = selects.iterator();
                while (it40.hasNext()){
                	ResourceSort resourceSort = (ResourceSort)it40.next();
                    LabelValue lbv = new LabelValue(resourceSort.getName(),resourceSort.getId().toString());
                    rt.add(lbv);
                }             	    
        		break; 
          	case 41: //广告形式 
          	    selects = mgr.getMatterType(level,user);
                Iterator it41 = selects.iterator();
                while (it41.hasNext()){
                	MatterType matterType = (MatterType)it41.next();
                    LabelValue lbv = new LabelValue(matterType.getName(),matterType.getId().toString());
                    rt.add(lbv);
                }             	    
        		break; 
        		
          	case 42: //业务员
          	    selects = mgr.getUserByOrg(level);
                Iterator it42 = selects.iterator();
                while (it42.hasNext()){
                    User ur = (User)it42.next();
                    LabelValue lb42 = new LabelValue(ur.getFullName(),ur.getId().toString());
                    rt.add(lb42);
                }        	    
        		break;
        		
        		
          	case 43: //业务员
                for (int i=2010;i<2005;i++){
                    LabelValue lb43 = new LabelValue(String.valueOf(i),String.valueOf(i));
                    rt.add(lb43);
                }        	    
        		break;		
        		
          	case 44: //组织类型
                    rt.add( new LabelValue("电视","1"));  
                    rt.add( new LabelValue("电台","2"));  
                    rt.add( new LabelValue("报纸","3"));  
        		break;       		
        		
        		
          	case 45: //系统提示方式 
          	    selects = mgr.getParentSysOrg();
                Iterator it45 = selects.iterator();
                rt.add( new LabelValue("","0"));  
                while (it45.hasNext()){
                	Org org = (Org)it45.next();
                    LabelValue lb45 = new LabelValue(org.getName(),org.getId().toString());
                    rt.add(lb45);
                }             	    
        		break;  
        		
          	case 46: //组织类型
          		rt.add( new LabelValue("","0"));  
                rt.add( new LabelValue("首一","1"));  
                rt.add( new LabelValue("尾一","2"));  
    		break;  
        }
        
        
        

        return rt;
    }
    
    /**
     * Convenience method to get Spring-initialized beans
     *
     * @param name
     * @return Object bean from ApplicationContext
     */
    public Object getBean(String name) {
        ApplicationContext ctx = 
            WebApplicationContextUtils.getRequiredWebApplicationContext(pageContext.getServletContext());
        return ctx.getBean(name);
    }

    

}
