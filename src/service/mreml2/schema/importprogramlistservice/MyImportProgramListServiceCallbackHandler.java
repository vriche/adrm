package mreml2.schema.importprogramlistservice;

import mreml2.schema.commondatatype.CommonResponseType;
import mreml2.schema.programlistparameter.ImportProgramListResponse;
import mreml2.schema.programlistparameter.ImportProgramListResponseType;









public class MyImportProgramListServiceCallbackHandler extends
		ImportProgramListServiceCallbackHandler {
    /**
     * auto generated Axis2 call back method for importProgramList method
     * override this method for handling normal response from importProgramList operation
     */
    public void receiveResultimportProgramList(ImportProgramListResponse result ) 
    {
    	ImportProgramListResponseType ret = result.getImportProgramListResponse();
//    	ImportProgramListResponseType ret = saveProgramListLockInfo2(importProgramListRequest);
    	CommonResponseType commonResponse = ret.getCommonResponse();
    	

		//		<!-- ����״̬��0-�ɹ���1-ʧ�� -->
		//		<ns4:Status>0</ns4:Status>
				String staus = String.valueOf(commonResponse.getStatus());
		//		<!-- ״̬�������� -->
		//		<ns4:Description>����IDΪ44668221���ز���Ϣ�ɹ���</ns4:Description>
				String newId = commonResponse.getDescription();
				 
				 
				 System.out.println("/****************************************************************/");
				 System.out.println("                                              					   ");
				 System.out.println("Status> " + staus);
				 System.out.println("Description>" + newId);
				 System.out.println("                                              					   ");
				 System.out.println("/****************************************************************/");
    }
    
	 public synchronized void receiveErrorimportProgramList(Exception e) {
		    System.out.println("CallbackHandler receive Error importProgramList..............................     ");
		   notify();
	 }

    
    
    
}
