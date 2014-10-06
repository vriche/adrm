
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.util.*;

import java.io.*;
import java.net.*;
import java.awt.BorderLayout;
import javax.swing.JOptionPane;


/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: PrinterApplet.java,v 1.3 2004/06/01 20:46:04 teodord Exp $
 */
public class ContractPrinterApplet extends javax.swing.JApplet
{

//
//	/**
//	 *
//	 */
//	private URL url = null;
//	private String printType="ABC";
//	private JasperPrint jasperPrint = null;
//
//
//	/** Creates new form AppletViewer */
//	public ContractPrinterApplet()
//	{
//		initComponents();
//	}
//
//
//	/**
//	*
//	*/
//	public void init()
//	{
//		String strUrl = getParameter("REPORT_URL");
//		printType=getParameter("printType");
//		if(printType==null)
//		  printType="ABC";
//		if (strUrl != null)
//		{
//			try
//			{
//				url = new URL(getCodeBase(), strUrl);
//			}
//			catch (Exception e)
//			{
//				StringWriter swriter = new StringWriter();
//				PrintWriter pwriter = new PrintWriter(swriter);
//				e.printStackTrace(pwriter);
//				JOptionPane.showMessageDialog(this, swriter.toString());
//			}
//			//myPrint();
//		}
//		else
//		{
//		JOptionPane.showMessageDialog(this, "Source URL not specified");
//		}
//	}
//
//
//    /** This method is called from within the constructor to
//     * initialize the form.
//     * WARNING: Do NOT modify this code. The content of this method is
//     * always regenerated by the Form Editor.
//     */
//    private void initComponents() {//GEN-BEGIN:initComponents
//        pnlMain = new javax.swing.JPanel();
//        //pnlMain.setBackground(java.awt.Color.WHITE);
//        btnPrint = new javax.swing.JButton();
//        //btnPrint.setBackground(java.awt.Color.WHITE);
//        btnView = new javax.swing.JButton();
//        //btnView.setBackground(java.awt.Color.WHITE);
//        btnPrint.setText("Print the report");
//        btnPrint.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnPrintActionPerformed(evt);
//            }
//        });
//
//        pnlMain.add(btnPrint);
//
//        btnView.setText("View the report");
//        btnView.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                btnViewActionPerformed(evt);
//            }
//        });
//
//        pnlMain.add(btnView);
//
//        getContentPane().add(pnlMain, java.awt.BorderLayout.CENTER);
//
//    }//GEN-END:initComponents
//public void preView(){
//	if (url != null)
//		{
//			try
//			{
//				if (jasperPrint == null)
//				{
//					jasperPrint = (JasperPrint)JRLoader.loadObject(url);
//				}
//				if (jasperPrint != null)
//				{
//					ViewerFrame viewerFrame = new ViewerFrame(this.getAppletContext(), jasperPrint,printType);
//					viewerFrame.show();
//				}
//				else
//				{
//					JOptionPane.showMessageDialog(this, "Empty report.");
//				}
//			}
//			catch (Exception e)
//			{
//				StringWriter swriter = new StringWriter();
//				PrintWriter pwriter = new PrintWriter(swriter);
//				e.printStackTrace(pwriter);
//				JOptionPane.showMessageDialog(this, swriter.toString());
//			}
//		}
//		else
//		{
//			JOptionPane.showMessageDialog(this, "Source URL not specified");
//		}
//}
//public void print(){
//  if (url != null)
//  {
//    if (jasperPrint == null)
//	{
//	  try
//	{
//	 jasperPrint = (JasperPrint)JRLoader.loadObject(url);
//	}
//	catch (Exception e)
//	{
//	 StringWriter swriter = new StringWriter();
//	 PrintWriter pwriter = new PrintWriter(swriter);
//	 e.printStackTrace(pwriter);
//	 JOptionPane.showMessageDialog(this, swriter.toString());
//	}
//       }
//
//  if (jasperPrint != null)
//  {
//   Thread thread = new Thread
//  (
//    new Runnable()
//	{
//	public void run()
//	{
//	 try 
//	 {	  
//	  if(printType.indexOf("A")!=-1) //printType.equals("A")||printType.equals("D")
//	     JasperPrintManager.printReport(jasperPrint, false);
//	  java.util.Collection pages = jasperPrint.getPages();
//	  JRPrintPage page;
//	  java.util.Collection elements;
//	  JRPrintElement element;
//	  JRPrintText jrt;
//	  for( java.util.Iterator pageIt = pages.iterator();pageIt.hasNext();){	  	
//	    page = (JRPrintPage)pageIt.next();
//	    elements = page.getElements();	  
//	  for(java.util.Iterator it = elements.iterator(); it.hasNext();){
//	    element = (JRPrintElement)it.next();
//	    if (element instanceof JRPrintText){
//	    	jrt =(JRPrintText)element;
//	    	if("第一联：广告部留存".equals(jrt.getText())){
//	    	  jrt.setText("第二联：客户留存");
//	    	}
//	    }
//	    if (element instanceof JRPrintText){
//	    	jrt =(JRPrintText)element;
//	    	if("A".equals(jrt.getText()))
//	    	  jrt.setText("B");
//	    }
//	  }
//	}
//	if(printType.indexOf("B")!=-1) //printType.equals("B")||printType.equals("D")
//	  JasperPrintManager.printReport(jasperPrint, false);
//	 for( java.util.Iterator pageIt = pages.iterator();pageIt.hasNext();){	  	
//	    page = (JRPrintPage)pageIt.next();
//	    elements = page.getElements();	  
//	  for(java.util.Iterator it = elements.iterator(); it.hasNext();){
//	    element = (JRPrintElement)it.next();
//	    if (element instanceof JRPrintText){
//	    	jrt =(JRPrintText)element;
//	    	if("第二联：客户留存".equals(jrt.getText()))
//	    	  jrt.setText("第三联：财务部留存");
//	    }
//	    if (element instanceof JRPrintText){
//	    	jrt =(JRPrintText)element;
//	    	if("B".equals(jrt.getText()))
//	    	  jrt.setText("C");
//	    }
//	  }
//	}
//	if(printType.indexOf("C")!=-1)//printType.equals("C")||printType.equals("D")
//	  JasperPrintManager.printReport(jasperPrint, false); 					
//	 }
//	catch (Exception e) 
//	{
//	 StringWriter swriter = new StringWriter();
//	 PrintWriter pwriter = new PrintWriter(swriter);
//	 e.printStackTrace(pwriter);
//	 JOptionPane.showMessageDialog(null, swriter.toString());
//	}
//	}
//	}
// );
//				
//   thread.start();
//  }
//  else
// 	{
//    	JOptionPane.showMessageDialog(this, "Empty report.");
//  	}
//     }
//		else
//		{
//			JOptionPane.showMessageDialog(this, "Source URL not specified");
//		}
//}
//    private void btnViewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnViewActionPerformed
//		// Add your handling code here:
//		if (url != null)
//		{
//			try
//			{
//				if (jasperPrint == null)
//				{
//					jasperPrint = (JasperPrint)JRLoader.loadObject(url);
//				}
//				if (jasperPrint != null)
//				{
//					ViewerFrame viewerFrame = new ViewerFrame(this.getAppletContext(), jasperPrint);
//					viewerFrame.show();
//				}
//				else
//				{
//					JOptionPane.showMessageDialog(this, "Empty report.");
//				}
//			}
//			catch (Exception e)
//			{
//				StringWriter swriter = new StringWriter();
//				PrintWriter pwriter = new PrintWriter(swriter);
//				e.printStackTrace(pwriter);
//				JOptionPane.showMessageDialog(this, swriter.toString());
//			}
//		}
//		else
//		{
//			JOptionPane.showMessageDialog(this, "Source URL not specified");
//		}
//    }//GEN-LAST:event_btnViewActionPerformed
//
//    private void btnPrintActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrintActionPerformed
//		// Add your handling code here:
//		if (url != null)
//		{
//			if (jasperPrint == null)
//			{
//				try
//				{
//					jasperPrint = (JasperPrint)JRLoader.loadObject(url);
//				}
//				catch (Exception e)
//				{
//					StringWriter swriter = new StringWriter();
//					PrintWriter pwriter = new PrintWriter(swriter);
//					e.printStackTrace(pwriter);
//					JOptionPane.showMessageDialog(this, swriter.toString());
//				}
//			}
//			
//  if (jasperPrint != null)
//  {
//   Thread thread = new Thread
//  (
//    new Runnable()
//	{
//	public void run()
//	{
//	 try 
//	 {
//	  JasperPrintManager.printReport(jasperPrint, false);
//	  java.util.Collection pages = jasperPrint.getPages();
//	  JRPrintPage page;
//	  java.util.Collection elements;
//	  JRPrintElement element;
//	  JRPrintText jrt;
//	  for( java.util.Iterator pageIt = pages.iterator();pageIt.hasNext();){	  	
//	    page = (JRPrintPage)pageIt.next();
//	    elements = page.getElements();	  
//	  for(java.util.Iterator it = elements.iterator(); it.hasNext();){
//	    element = (JRPrintElement)it.next();
//	    if (element instanceof JRPrintText){
//	    	jrt =(JRPrintText)element;
//	    	if("第一联：广告部留存".equals(jrt.getText()))
//	    	  jrt.setText("第二联：电视台留存");
//	    }
//	    if (element instanceof JRPrintText){
//	    	jrt =(JRPrintText)element;
//	    	if("A".equals(jrt.getText()))
//	    	  jrt.setText("B");
//	    }
//	  }
//	}
//	  JasperPrintManager.printReport(jasperPrint, false);
//	 for( java.util.Iterator pageIt = pages.iterator();pageIt.hasNext();){	  	
//	    page = (JRPrintPage)pageIt.next();
//	    elements = page.getElements();	  
//	  for(java.util.Iterator it = elements.iterator(); it.hasNext();){
//	    element = (JRPrintElement)it.next();
//	    if (element instanceof JRPrintText){
//	    	jrt =(JRPrintText)element;
//	    	if("第二联：电视台留存".equals(jrt.getText()))
//	    	  jrt.setText("第三联：客户留存");
//	    }
//	    if (element instanceof JRPrintText){
//	    	jrt =(JRPrintText)element;
//	    	if("B".equals(jrt.getText()))
//	    	  jrt.setText("C");
//	    }
//	  }
//	}
//	JasperPrintManager.printReport(jasperPrint, false); 					
//	 }
//	catch (Exception e) 
//	{
//	 StringWriter swriter = new StringWriter();
//	 PrintWriter pwriter = new PrintWriter(swriter);
//	 e.printStackTrace(pwriter);
//	 JOptionPane.showMessageDialog(null, swriter.toString());
//	}
//	}
//	}
// );
//				
//   thread.start();
//			}
//			else
//			{
//				JOptionPane.showMessageDialog(this, "Empty report.");
//			}
//		}
//		else
//		{
//			JOptionPane.showMessageDialog(this, "Source URL not specified");
//		}
//    }//GEN-LAST:event_btnPrintActionPerformed
//    
//    
//    // Variables declaration - do not modify//GEN-BEGIN:variables
//    private javax.swing.JPanel pnlMain;
//    private javax.swing.JButton btnView;
//    private javax.swing.JButton btnPrint;
//    // End of variables declaration//GEN-END:variables
    
}
