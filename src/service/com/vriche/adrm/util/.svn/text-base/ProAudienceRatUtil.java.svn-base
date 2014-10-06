package com.vriche.adrm.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.vriche.adrm.Constants;
import com.vriche.adrm.model.Carrier;
import com.vriche.adrm.model.ProAudienceRat;

public class ProAudienceRatUtil {
	
	

	
	public static void getProAudienceRatDataFromExcel(List ls,List resList,Map parmap){
		int rows = ls.size();
		
		if(rows > 0){
			Map carrierMp = getCarriersMap();
			int cols = 0;
			cols = ((String[])ls.get(0)).length;
			String[][] strArray = new String[rows][cols];  
			
			int i = 0;
			for(Iterator it = ls.iterator();it.hasNext();){
				String[] arr = (String[])it.next();
				for(int j = 0 ; j < arr.length ; j++){
					System.out.println("arr >>>>>>>>>>>>>>>>>>>"+arr[j]);
					strArray[i][j] = arr[j];
				}
				i++;
//				System.out.println();  
			}
			
			/*****************************************************************************
			 * 日期	 	｜2013－2－26	｜2013－2－26｜2013－2－26｜
			 * 时间段	｜河北卫视		｜河北电视台二套 ｜
			 * 7：00		｜0.1					  |   0.2	
			 * ***************************************************************************/
			
		
			
			
			List carrIdList = new ArrayList();
			
			for(int m = 1; m < cols; m++) { 
				int dd = 0;  //日期
				int tt = 0;  //时间段
				long ch = 0; // 频道
				
				for(int n = 0; n < rows-1; n++) {  
					
					double rate = 0;
					
					if(n == 0){
							if(dd == 0){
									dd = Integer.parseInt(strArray[0][m]);
									parmap.put("audienceDate",strArray[0][m]);
	            			}
					}else if(n == 1){
						if(ch == 0 && ch != -1){
								Long id = getCarrierIdByName(carrierMp,strArray[1][m]);
								
								System.out.println("getCarrierIdByName id>>>>>>>>>>>>>>>>>>>"+id);
								
								ch = (id).longValue();
								carrIdList.add(id);
								parmap.put("carrierIds",carrIdList);
	            		}
					}else if(n >2 && ch > 0){
						
						System.out.println("getCarrierIdByName strArray[n][0]>>>>>>>>>>>>>>>>>>>"+strArray[n][0]);
						
						
//						String[] s = strArray[n][0].split("：");
//						int hh = 0;
//						int mm = 0;
//						int ss = 0;
//				
////					 	Integer startTime = new Integer(h*3600+m*60+s);
//						if(s.length ==2){
//							hh = Integer.parseInt(s[0]);
//							mm = Integer.parseInt(s[1]);
//							tt =  hh*3600+mm*60;
//						}else{
//							hh = Integer.parseInt(s[0]);
//							mm = Integer.parseInt(s[1]);
//							ss = Integer.parseInt(s[2]);
//							tt =hh*3600+mm*60+ss;
//						}
						
//							SimpleDateFormat a=new SimpleDateFormat("yyyy-MM-dd");
						 
				    		tt = Integer.parseInt(strArray[n][0]);
				    		rate = Double.parseDouble(strArray[n][m]);
				    		
//				    		System.out.println("ch >>>>>>>>>>>>>>>>>>>"+ch);
//				    		System.out.println("dd >>>>>>>>>>>>>>>>>>>"+dd);
//				    		System.out.println("tt >>>>>>>>>>>>>>>>>>>"+tt);
//				    		System.out.println("rate >>>>>>>>>>>>>>>>>>>"+rate);
//				    		System.out.println();  
				    		
				        	ProAudienceRat audienceRat= new ProAudienceRat();
				        	audienceRat.setCarrierId(new Long(ch));
				        	audienceRat.setAudienceDate(new Integer(dd));
				        	audienceRat.setAudienceTime(new Integer(tt));
				        	audienceRat.setAudienceRat(new Double(rate));
				        	resList.add(audienceRat);
				        	
//				        	System.out.println("audienceRat >>>>>>>>>>>>>>>>>>>"+audienceRat.toString());
			           

	            	}
	
	            }   
			} 	
			
			
//			System.out.println("resList.size >>>>>>>>>>>>>>>>>>>"+resList.size());
			
			
		}
		

		
	}
	
	
	
	public static void getProAudienceRatDataFromExcelForHBTV(List ls,List resList,Map parmap){
		
		
		
		int rows = ls.size();
		
		if(rows > 0){
			Map carrierMp = getCarriersMap();
			int cols = 0;
			cols = ((String[])ls.get(0)).length;
			String[][] strArray = new String[rows][cols];  
			
			int i = 0;
			for(Iterator it = ls.iterator();it.hasNext();){
				String[] arr = (String[])it.next();
				for(int j = 0 ; j < arr.length ; j++){
//					System.out.println("arr >>>>>>>>>>>>>>>>>>>"+arr[j]);
					strArray[i][j] = arr[j];
				}
				i++;
//				System.out.println();  
			}
			
			/*****************************************************************************
			 * 日期	 	｜2013－2－26	｜2013－2－26｜2013－2－26｜
			 * 时间段	｜河北卫视		｜河北电视台二套 ｜
			 * 7：00		｜0.1					  |   0.2	
			 * ***************************************************************************/
			
			/*****************************************************************************
			 * 单位	 	｜收视率％		｜收视率％				｜收视率％｜
			 * 频道        ｜河北卫视		｜河北卫视 				｜
			 * 时间段	｜2013－2－1	｜2013－2－2			｜2013－2－3｜
			 * 2：00		｜0.1					  |   0.1							  |   0.2
			 * 2：01		｜0.1					  |   0.2							  |   0.3	
			 * ***************************************************************************/
			
		
			
			
			List carrIdList = new ArrayList();
			
			System.out.println("arr rows>>>>>>>>>>>>>>>>>>>"+rows);
			System.out.println("arr cols>>>>>>>>>>>>>>>>>>>"+cols);
			
			for(int m = 1; m < cols-1; m++) { 
				int dd = 0;  //日期
				int tt = 0;  //时间段
				long ch = 0; // 频道
				
				for(int n = 0; n < rows-1; n++) {  
					
					double rate = 0;
					
					if(n == 2){
							if(dd == 0){
									dd = Integer.parseInt(strArray[n][m]);
									parmap.put("audienceDate",strArray[n][m]);
	            			}
					}else if(n == 1){
						if(ch == 0 && ch != -1){
								Long id = getCarrierIdByName(carrierMp,strArray[n][m]);
								
								System.out.println("getCarrierIdByName id>>>>>>>>>>>>>>>>>>>"+id);
								
								ch = (id).longValue();
								carrIdList.add(id);
								parmap.put("carrierIds",carrIdList);
	            		}
					}else if(n >2 && ch > 0){
						
						System.out.println("getCarrierIdByName strArray[n][0]>>>>>>>>>>>>>>>>>>>"+strArray[n][0]);
						
						
//						String[] s = strArray[n][0].split("：");
//						int hh = 0;
//						int mm = 0;
//						int ss = 0;
//				
////					 	Integer startTime = new Integer(h*3600+m*60+s);
//						if(s.length ==2){
//							hh = Integer.parseInt(s[0]);
//							mm = Integer.parseInt(s[1]);
//							tt =  hh*3600+mm*60;
//						}else{
//							hh = Integer.parseInt(s[0]);
//							mm = Integer.parseInt(s[1]);
//							ss = Integer.parseInt(s[2]);
//							tt =hh*3600+mm*60+ss;
//						}
						
//							SimpleDateFormat a=new SimpleDateFormat("yyyy-MM-dd");
						 
				    		tt = Integer.parseInt(strArray[n][0]);
				    		rate = Double.parseDouble(strArray[n][m]);
				    		
//				    		System.out.println("ch >>>>>>>>>>>>>>>>>>>"+ch);
//				    		System.out.println("dd >>>>>>>>>>>>>>>>>>>"+dd);
//				    		System.out.println("tt >>>>>>>>>>>>>>>>>>>"+tt);
//				    		System.out.println("rate >>>>>>>>>>>>>>>>>>>"+rate);
//				    		System.out.println();  
				    		
				        	ProAudienceRat audienceRat= new ProAudienceRat();
				        	audienceRat.setCarrierId(new Long(ch));
				        	audienceRat.setAudienceDate(new Integer(dd));
				        	audienceRat.setAudienceTime(new Integer(tt));
				        	audienceRat.setAudienceRat(new Double(rate));
				        	resList.add(audienceRat);
				        	
//				        	System.out.println("audienceRat >>>>>>>>>>>>>>>>>>>"+audienceRat.toString());
			           

	            	}
	
	            }   
			} 	
			
			
//			System.out.println("resList.size >>>>>>>>>>>>>>>>>>>"+resList.size());
			
			
		}
		

		
	}
	
	private static Long   getCarrierIdByName(Map carrierMp,String name){
		
		System.out.println("getCarrierIdByName >>>>>>>>>>>>>>>>>>>"+name);
		
		Object obj = carrierMp.get(name);
		if(obj == null) obj = new Long(-1);
		return (Long)obj;
	}
	
	
	
	private static Map   getCarriersMap() {
		Map mp = (Map)Constants.APPLACTION_MAP.get(Constants.AVAILABLE_CARRIERS_BY_CARRIER_TYPE);
		Object obj = mp.get(new Long(1));
		List ls  = new ArrayList();
		if(obj != null) ls = (List)obj;
		
		Map carrierMap = new HashMap();
		for(Iterator it = ls.iterator();it.hasNext();){
			Carrier carrier = (Carrier)it.next();
			carrierMap.put(carrier.getAliasName(),carrier.getId());
		}

		return carrierMap;
	}	

}
