
package com.vriche.adrm.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.dao.ForetArrearageDao;
import com.vriche.adrm.model.ForetArrearage;
import com.vriche.adrm.service.ForetArrearageManager;
import com.vriche.adrm.util.StringUtil;

public class ForetArrearageManagerImpl extends BaseManager implements ForetArrearageManager {
    private ForetArrearageDao dao;

    /**
     * Set the Dao for communication with the data layer.
     * @param dao
     */
    public void setForetArrearageDao(ForetArrearageDao dao) {
        this.dao = dao;
    }
   /**
     * @see com.vriche.adrm.service.ForetArrearageManager#getForetArrearages(com.vriche.adrm.model.ForetArrearage)
     */
    public List getForetArrearages(final ForetArrearage foretArrearage) {
        return dao.getForetArrearages(foretArrearage);
    }
   /**
     * @see com.vriche.adrm.service.ForetArrearageManager#getForetArrearagesCount(com.vriche.adrm.model.ForetArrearage)
     */
    public String getForetArrearagesCount(final ForetArrearage foretArrearage) {
        return dao.getForetArrearagesCount(foretArrearage).toString();
    }    

   /**
     * @see com.vriche.adrm.service.ForetArrearageManager#getForetArrearagesCount(com.vriche.adrm.model.ForetArrearage)
     */    
	public List getForetArrearagesPage(final ForetArrearage foretArrearage,String pageIndex, String pageSize) {
		return dao.getForetArrearagesPage(foretArrearage,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
	}    
   /**
     * @see com.vriche.adrm.service.ForetArrearageManager#getForetArrearagesCount(com.vriche.adrm.model.ForetArrearage)
     */    
	public String getForetArrearagesPageXML(final ForetArrearage foretArrearage,String pageIndex, String pageSize) {
	    StringBuffer sb = new StringBuffer();
	    List ls = dao.getForetArrearagesPage(foretArrearage,Integer.parseInt(pageIndex),Integer.parseInt(pageSize));
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");   
		for(Iterator it = ls.iterator();it.hasNext();){
			ForetArrearage obj = (ForetArrearage)it.next();
			sb.append("<row  id=\""+ obj.getId()  +"\"" +">");
			sb.append("<cell><![CDATA["+ obj  +"]]></cell>");
			sb.append("</row>");
		}
		sb.append("</rows>");	
		return sb.toString();
	}  
	
	
	private  Map getMapByList(List ls,int y,String cutName,int type){
		Map mp = new HashMap();
		boolean fiterYear = y >0;
		boolean fiterCutName = (cutName !=""&&cutName !=null&&cutName !="null");
		for (Iterator it = ls.iterator(); it.hasNext();) {
			ForetArrearage obj = (ForetArrearage)it.next();
			int year = Integer.parseInt(obj.getPayDate().toString().substring(0,4));
			String customerName = obj.getCustomerName();
			
			String key = year +"," +  customerName;
			
			int month = Integer.parseInt(obj.getPayDate().toString().substring(4, 6));
//			System.out.println(">>>>>>>>>>>>month>>>>>>"+month);
			double payMoney = obj.getPayMoney().doubleValue();
			double incomeMoney = obj.getIncomeMoney().doubleValue();
			double noPayMoney = payMoney - incomeMoney;
			
			String[] values = new String[12];
			
			
			if (mp.containsKey(key)) {
				values = (String[]) mp.get(key);
				for (int i = 0; i < 12; i++) {
					//System.out.println(">>>>>>>>>>>>i>>>>>>"+i);
					if (values[i] == null){
						if(type == 4){
							values[i] ="0,0,0";
						}else{
							values[i] = "0";
						}
						
					}
					if (month - 1 == i) {
//						double v1 = 0;double v2 = 0;double v3 = 0;
							
						if(type == 1){
							double v1  = new Double(values[i]).doubleValue() + payMoney;
							values[i] = new Double(v1).toString();
						}
						if(type == 2){
							double v2 = new Double(values[i]).doubleValue() + incomeMoney;
							values[i] = new Double(v2).toString();
						}
						if(type == 3){
							double v3 = new Double(values[i]).doubleValue() + noPayMoney;
							values[i] = new Double(v3).toString();
						}
						if(type == 4){
							String v[] = values[i].split(",");
							double v1  = new Double(v[0]).doubleValue() + payMoney;
							double v2 = new Double(v[1]).doubleValue() + incomeMoney;
							double v3 = new Double(v[2]).doubleValue() + noPayMoney;
							values[i] =  v1+","+ v2+","+ v3;
						}
						
						
					}
				}
			} else {
//				values = new String[12];
				for (int i = 0; i < 12; i++) {
					if (month - 1 == i) {
						if(type == 1){
							values[i] = new Double(payMoney).toString();
						}
						if(type == 2){
							values[i] = new Double(incomeMoney).toString();
						}
						if(type == 3){
							values[i] = new Double(noPayMoney).toString();
						}
						if(type == 4){
							values[i] = new Double(payMoney).toString()+","+new Double(incomeMoney).toString()+","+new Double(noPayMoney).toString();
						}
						
					}else{
						if(type == 4){
							values[i] = "0,0,0";
						}else{
							values[i] = "0";
						}
						
					}
					
				}
			}
			if((fiterYear && year==y) ||!fiterYear){
				//if((fiterCutName && cutName == customerName) ||!fiterCutName) 
					mp.put(key,values);	
			}
			    
		}
		
		return mp;
	}
	
	public String getForetArrearagesForXML(final ForetArrearage foretArrearage,int type) {
	    StringBuffer sb = new StringBuffer();
	    String cutName = foretArrearage.getCustomerName();
	    int year = foretArrearage.getYear().intValue();
		List ls = dao.getForetArrearagesList(foretArrearage);
		Map mp =  getMapByList(ls,year,cutName,type);
		
		sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		sb.append("<rows>");
		
		for (Iterator it = mp.keySet().iterator(); it.hasNext();) {
			String key =  it.next().toString();
			String keys[] = key.split(",");
			
			ForetArrearage obj = new ForetArrearage();
			obj.setYear(new Integer(keys[0]));
			obj.setCustomerName(keys[1]);
			obj.setMonth((String[])mp.get(key));
			
			sb.append("<row  id=\"" + key + "\"" + ">");
			getCellByType(sb,obj,type);
			sb.append("</row>");
		}

		sb.append("</rows>");

		return sb.toString();
	
	}
	
	private  void getCellByType(StringBuffer sb,ForetArrearage obj,int type){
//		 if(type == 1){
			 sb.append("<cell><![CDATA["+  obj.getYear() +"]]></cell>");
			 sb.append("<cell><![CDATA["+ obj.getCustomerName()  +"]]></cell>");
			 double sum = 0;
			 double[] s= new double[3];
			 
			 for( int i = 0;i < 12;i++){
				 if(type == 4){
					 String v[] = (obj.getMonth()[i]).split(",");
					 for(int j = 0;j<v.length;j++){
						 String vl = v[j] == "0"?"":v[j];
//						 System.out.println(">>>>>>>>>>>>v["+j+"]>>>>>>"+v[j]);
						 sb.append("<cell><![CDATA["+  vl  +"]]></cell>");
						 s[j]+=Double.valueOf(v[j]).doubleValue();
					 }
						
				 }else{
					 String v = (obj.getMonth()[i]) == "0"?"": String.valueOf(obj.getMonth()[i]);
					 sb.append("<cell><![CDATA["+ v  +"]]></cell>");
					 sum+=Double.valueOf(obj.getMonth()[i]).doubleValue();
				 }
			 }
			 
			 if(type == 4){
				 sb.append("<cell><![CDATA["+ s[0]  +"]]></cell>"); 
				 sb.append("<cell><![CDATA["+ s[1]  +"]]></cell>"); 
				 sb.append("<cell><![CDATA["+ s[2]  +"]]></cell>"); 
			 }else{
				 sb.append("<cell><![CDATA["+ String.valueOf(sum)  +"]]></cell>"); 
		     }
	}
	
    /**
     * @see com.vriche.adrm.service.ForetArrearageManager#getForetArrearage(String id)
     */
    public ForetArrearage getForetArrearage(final String id) {
        return dao.getForetArrearage(new Long(id));
    }
    /**
     * @see com.vriche.adrm.service.ForetArrearageManager#getForetArrearagesByIdList(final Map idList)
     */
    public List getForetArrearagesByMap(final Map mp) {
        return dao.getForetArrearagesByMap(mp);
    }    

    /**
     * @see com.vriche.adrm.service.ForetArrearageManager#saveForetArrearage(ForetArrearage foretArrearage)
     */
    public String saveForetArrearage(ForetArrearage foretArrearage) {
        return dao.saveForetArrearage(foretArrearage).toString();
    }

    /**
     * @see com.vriche.adrm.service.ForetArrearageManager#removeForetArrearage(String id)
     */
    public void removeForetArrearage(final String id) {
        dao.removeForetArrearage(new Long(id));
    }

     /**
     * @see com.vriche.adrm.service.ForetArrearageManager#removeForetArrearages(String Map)
     */
    public void removeForetArrearages(final Map mp) {
        dao.removeForetArrearages(mp);
    }
  
}
