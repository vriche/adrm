import javax.xml.namespace.QName;

import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.rpc.client.RPCServiceClient;

import com.vriche.adrm.model.Income;


public class testaxi2 {
	
	public testaxi2() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		System.out.println("1111111");
		Income income = new Income();
		try {
			RPCServiceClient serviceClient = new  RPCServiceClient();
			Options options = serviceClient.getOptions();
			EndpointReference targetEPR = new EndpointReference("http://168.168.168.2:8080/adrm/services/IncomeManagerImpl");
			options.setTo(targetEPR);
			QName opAddEntry = new QName("http://service.addressbook.sample", "addEntry");

			Object[] opAddEntryArgs = new Object[] {income};
			serviceClient.invokeRobust(opAddEntry, opAddEntryArgs);
			
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 

	}

}
