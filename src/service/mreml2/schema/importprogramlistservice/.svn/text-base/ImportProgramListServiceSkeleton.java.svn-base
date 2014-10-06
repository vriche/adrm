
/**
 * ImportProgramListServiceSkeleton.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.5.4  Built on : Dec 19, 2010 (08:18:42 CET)
 */
    package mreml2.schema.importprogramlistservice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import mreml2.schema.commondatatype.CommonResponseType;
import mreml2.schema.programlist.BroadcastListEntityType;
import mreml2.schema.programlist.BroadcastListItemType;
import mreml2.schema.programlistparameter.ImportProgramListResponse;
import mreml2.schema.programlistparameter.ImportProgramListResponseType;
import mreml2.schema.programlistparameter.ImportProgramListRequest;

import com.vriche.adrm.dao.PublishArrangeDao;
import com.vriche.adrm.util.ServiceLocator;
    /**
     *  ImportProgramListServiceSkeleton java skeleton for the axisService
     */
    public class ImportProgramListServiceSkeleton implements ImportProgramListServiceSkeletonInterface{
        
         
        /**
         * Auto generated method signature
         * 
                                     * @param importProgramListRequest0
         */
        
                 public mreml2.schema.programlistparameter.ImportProgramListResponse importProgramList(ImportProgramListRequest importProgramListRequest){
                	  try{
                	      	 ImportProgramListResponseType ret = saveProgramListLockInfo2(importProgramListRequest.getImportProgramListRequest());
                        	 ImportProgramListResponse rp = new ImportProgramListResponse();
                        	 rp.setImportProgramListResponse(ret);
                        	 return rp;
                	  }catch(java.lang.UnsupportedOperationException e){
                          // we cannot intantiate the class - throw the original Axis fault
                		  throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#importProgramList");
                      }
             
                //TODO : fill this with the necessary business logic
//                throw new  java.lang.UnsupportedOperationException("Please implement " + this.getClass().getName() + "#importProgramList");
        }
                 
//               webService 调用地址  http://10.77.51.51:8080/adrm/services/ImportProgramListService?wsdl
//               方法名 saveProgramListLockInfo(String iteId,String lockStatus)
//               参数1 iteId = <!-- 广告播出单段ID --> <m0:ItemID>20131101s01</m0:ItemID> 如果多个段用逗号隔开 如 id="20131101s0001,20131101s0002,20131101s0003"
//               参数2 lockStatus = 0 或 1   0-解锁   1-锁定
//               返回值 0-成功  其它是错误描述
             	private String saveProgramListLockInfo(String iteId,String lockStatus) {
             		
//             		System.out.println("saveProgramListLockInfo  iteId>>>>>>>>>>>>>>>>>" + iteId);
//             		System.out.println("saveProgramListLockInfo  lockStatus>>>>>>>>>>>>>>>>>" + lockStatus);

             		PublishArrangeDao dao = ServiceLocator.getPublishArrangeDao();
             		String state  = "0";
             		
             		if(iteId != null && !"".equals(iteId)){
             			String[] ids = iteId.split(",");
             			int size = ids.length;
             			Map<String,List> mp = new HashMap<String,List>();
             			
//             			System.out.println("saveProgramListLockInfo  size>>>>>>>>>>>>>>>>>" + size);
             			
             			for(int i = 0;i<size;i++){
//             				System.out.println("saveProgramListLockInfo  ids[i]>>>>>>>>>>>>>>>>>" + ids[i]);
             				String[] idmp = ids[i].split("s");
             				String publishDate = idmp[0];
             				String resourceId = idmp[1];
//             				System.out.println("saveProgramListLockInfo  publishDate>>>>>>>>>>>>>>>>>" + publishDate);
//             				System.out.println("saveProgramListLockInfo  resourceId>>>>>>>>>>>>>>>>>" + resourceId);
             				
             				
             				if(mp.containsKey(publishDate)){
             					List ls = mp.get(publishDate);
             					ls.add(resourceId);
             					mp.put(publishDate,ls);
             				}else{
             					List ls = new ArrayList<String>();
             					ls.add(resourceId);
             					mp.put(publishDate,ls);
             				}
             			}
             			
             			Iterator it = mp.keySet().iterator();
             			List lsAll = new ArrayList();
             			while(it.hasNext()){
             				Map mpp = new HashMap();
             				String publishDate = (String)it.next();
             				
//             				System.out.println("saveProgramListLockInfo  publishDate>>>>>>>>>>>>>>>>>" + publishDate);
             				
//             				System.out.println("saveProgramListLockInfo  residList>>>>>>>>>>>>>>>>>" + mp.get(publishDate).toString());
             				
             				mpp.put("publishDate",publishDate);
             				mpp.put("residList",mp.get(publishDate));
             				
             				lsAll = dao.getPublishArrangeIdsByDateResid(mpp);
             				
//             				System.out.println("saveProgramListLockInfo  ls.size()>>>>>>>>>>>>>>>>>" + ls.size());
             				
//             				if(ls.size()>0) lsAll.addAll(ls);
             			}
             			
//             			System.out.println("saveProgramListLockInfo  lsAll>>>>>>>>>>>>>>>>>" + lsAll.toString());
             			
             			if(lsAll.size()>0){
             				Map mp2 = new HashMap();
             				mp2.put("idList",lsAll);
             				mp2.put("isLocked",lockStatus);
             				
             				System.out.println("saveProgramListLockInfo  lsAll>>>>>>>>>>>>>>>>>" + lsAll.toString());
             				System.out.println("saveProgramListLockInfo  isLocked start >>>>>>>>>>>>>>>>>" + lockStatus);
             				dao.updatePublishArrangeLock(mp2);
             				
             				System.out.println("saveProgramListLockInfo  isLocked end>>>>>>>>>>>>>>>>>" + lockStatus);
             				
             			}
             			
             			System.out.println("saveProgramListLockInfo  >>>>>>>>>>>>>>>>" + "锁定（"+ iteId +"）成功。");
             			
             			
//             			state ="锁定（"+ id +"）成功。";
             		}else{
             			state ="id不能为空";
             		}

             		return state;
             	}
             	
             	
             	private mreml2.schema.programlistparameter.ImportProgramListResponseType saveProgramListLockInfo2(mreml2.schema.programlistparameter.ImportProgramListRequestType importProgramListRequest) {
//             	System.out.println("saveProgramListLockInfo  lockStatus>>>>>>>>>>>>>>>>>" + lockStatus);
             	
             	BroadcastListEntityType broadcastListEntity = importProgramListRequest.getBroadcastListEntity();
             	String lockStatus = "0";
             	int listType = broadcastListEntity.getListType();
             	
             	System.out.println("saveProgramListLockInfo  broadcastListEntity.getListType()>>>>>>>>>>>>>>>>>" + listType);
             	
             	ImportProgramListResponseType importProgramListResponse = new ImportProgramListResponseType();
             	CommonResponseType commonResponse =  new CommonResponseType();
             	int states = 1;
             	String description = "";
             	if(listType == 5 || listType == 6){
             		if(listType == 5){
             			lockStatus = "1";
             		}else{
             			lockStatus = "0";
             		}

             	
             	BroadcastListItemType[] items =broadcastListEntity.getListItem();
             	StringBuffer sb = new StringBuffer();
             	String iteIds = null;
             	int size = items.length;
             	for(int i=0;i<size;i++){
             		BroadcastListItemType broadcastListItemType = items[i];
             		String itemId = broadcastListItemType.getItemID();
             		sb.append(itemId);
             		if(i<size-1)sb.append(",");
             	}
             	iteIds = sb.toString();
             	String rs = this.saveProgramListLockInfo(iteIds,lockStatus);

             	String islock = "locked";

             	if("0".equals(rs)) states = 0;
             	if("0".equals(lockStatus)) islock = "unlock";
             	if(states == 0){
             		description = islock+"（"+ iteIds +"） is ok";
             	}else{
             		description = islock+"（"+ iteIds +"） is fail";
             	}

             	}else{
             		description = " BroadcastListItemType   ListType is between (5-6)";
             	}
             	
             	commonResponse.setStatus(states);
             	commonResponse.setDescription(description);
             	importProgramListResponse.setCommonResponse(commonResponse);
             	
             	return importProgramListResponse;
             }                     
                 
                 
     
    }
    