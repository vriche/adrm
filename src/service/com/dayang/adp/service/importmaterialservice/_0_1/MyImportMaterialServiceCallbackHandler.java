package com.dayang.adp.service.importmaterialservice._0_1;

import org.apache.axis2.AxisFault;
import org.apache.axis2.client.ServiceClient;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dayang.adp.schema.admaterialentity._1_0.ADMaterialEntityType;
import com.dayang.adp.schema.adpserviceparametertype._0_1.CommonResponseType;
import com.dayang.adp.schema.adpserviceparametertype._0_1.ImportMaterialResponse;
import com.dayang.adp.schema.adpserviceparametertype._0_1.MaterialServiceParameterResponseType;

public  class MyImportMaterialServiceCallbackHandler extends ImportMaterialServiceCallbackHandler {
	
	private static Log log = LogFactory.getLog(MyImportMaterialServiceCallbackHandler.class);
	
	private ImportMaterialServiceStub _service;
	private ADMaterialEntityType _adMaterialEntity;


	
	public  MyImportMaterialServiceCallbackHandler(ImportMaterialServiceStub  service,ADMaterialEntityType adMaterialEntity){
		this._service = service;
		this._adMaterialEntity = adMaterialEntity;
	}
	
	public synchronized void receiveResultimportMaterial(ImportMaterialResponse result) 
	{
		
		
//		try {
//			_service._getServiceClient().cleanupTransport();
//			_service._getServiceClient().cleanup();
//		} catch (AxisFault e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
	
		
		MaterialServiceParameterResponseType materialServiceParameterResponseType = result.getImportMaterialResponse();
		CommonResponseType commonResponse = materialServiceParameterResponseType.getCommonResponse();
		

		//		<!-- 返回状态，0-成功，1-失败 -->
		//		<ns4:Status>0</ns4:Status>
				String staus = String.valueOf(commonResponse.getStatus());
		//		<!-- 状态文字描述 -->
		//		<ns4:Description>新增ID为44668221的素材信息成功。</ns4:Description>
				String description = commonResponse.getDescription();

				 System.out.println("/****************************************************************/");
				 System.out.println("Send Id>>"+ _adMaterialEntity.getMaterialID()+"  Number> " + _service.seq+" / "+_service.sumCount);
				 System.out.println("Status> " + staus);
				 System.out.println("Return Description>" + description);                                            					
				 System.out.println("/****************************************************************/");
				 
//				 System.out.println("m_done 1/****************************************************************/" + m_done);
				 
//				 notify();
				
	} 
	
	
	
	 public synchronized void receiveErrorimportMaterial(Exception e) {

		 System.out.println("/****************************************************************/");
//		 log.info("Error send MaterialID >"+_adMaterialEntity.getMaterialID());
		 System.out.println("Error send MaterialID >"+_adMaterialEntity.getMaterialID());   
		 System.out.println("CallbackHandler receive Error .........     " +e.getMessage());
		 System.out.println("/****************************************************************/");

//		 System.out.println("m_done 2/****************************************************************/" + m_done);

//		   notify();
	 }
}
