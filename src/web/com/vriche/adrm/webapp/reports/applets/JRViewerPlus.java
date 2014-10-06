/*
 * ============================================================================
 * GNU Lesser General Public License
 * ============================================================================
 *
 * JasperReports - Free Java report-generating library.
 * Copyright (C) 2001-2006 JasperSoft Corporation http://www.jaspersoft.com
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 * 
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307, USA.
 * 
 * JasperSoft Corporation
 * 303 Second Street, Suite 450 North
 * San Francisco, CA 94107
 * http://www.jaspersoft.com
 */
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.view.JRViewer;

/**
 * @author Teodor Danciu (teodord@users.sourceforge.net)
 * @version $Id: JRViewerPlus.java,v 1.1 2007/04/05 01:03:15 cvsuser Exp $
 */
public class JRViewerPlus extends JRViewer
{

	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	protected JButton btnPlus = new javax.swing.JButton();
	protected JButton btnCurrent = new javax.swing.JButton();
	JasperPrint jasperPrint;

	/**
	 *
	 */
	public JRViewerPlus(JasperPrint jrPrint) throws JRException
	{
		super(jrPrint);
		jasperPrint = jrPrint;
		
		tlbToolBar.remove(btnSave);
		tlbToolBar.remove(btnReload);
		tlbToolBar.remove(btnPrint);
		
//		getBundleString("zoom.out");
		btnPlus = new javax.swing.JButton();
		btnPlus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/sf/jasperreports/view/images/print.GIF")));
		btnPlus.setToolTipText("打印所有页");
		btnPlus.setMargin(new java.awt.Insets(2, 2, 2, 2));
		btnPlus.setMaximumSize(new java.awt.Dimension(23, 23));
		btnPlus.setMinimumSize(new java.awt.Dimension(23, 23));
		btnPlus.setPreferredSize(new java.awt.Dimension(23, 23));
		btnPlus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnPlusActionPerformed(evt);
            }
        });
        tlbToolBar.add(btnPlus,0);
        
        btnCurrent = new javax.swing.JButton();
        btnCurrent.setIcon(new javax.swing.ImageIcon(getClass().getResource("/net/sf/jasperreports/view/images/print.GIF")));
        btnCurrent.setToolTipText("打印当前页");
        btnCurrent.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btnCurrent.setMaximumSize(new java.awt.Dimension(23, 23));
        btnCurrent.setMinimumSize(new java.awt.Dimension(23, 23));
        btnCurrent.setPreferredSize(new java.awt.Dimension(23, 23));
        btnCurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	btnCurrentActionPerformed(evt);
            }
        });
        tlbToolBar.add(btnCurrent,1);
        
     
	
//		btnPlus = new javax.swing.JButton();
//		btnPlus.setToolTipText("Plus...");
//		btnPlus.setText("Plus...");
//		btnPlus.setPreferredSize(new java.awt.Dimension(80, 23));
//		btnPlus.setMaximumSize(new java.awt.Dimension(80, 23));
//		btnPlus.setMinimumSize(new java.awt.Dimension(80, 23));
//		btnPlus.addActionListener(new java.awt.event.ActionListener() {
//			public void actionPerformed(java.awt.event.ActionEvent evt) {
//				btnPlusActionPerformed(evt);
//			}
//		});
//		tlbToolBar.add(btnPlus, 0);
		

	}


	/**
	 *
	 */
	protected void setZooms()
	{
		this.zooms = new int[]{33, 66, 100, 133, 166, 200, 233};
		this.defaultZoomIndex = 2;
	}


	
	
	/**
	 *
	 */
	protected void btnPlusActionPerformed(java.awt.event.ActionEvent evt)
	{
		
		if (jasperPrint != null)
		{				
			final JasperPrint print = jasperPrint;
			
			Thread thread = new Thread
				(
					new Runnable()
					{
						public void run()
						{
							try 
							{
								JasperPrintManager.printReport(print, false);
							}
							catch (Exception e) 
							{
								StringWriter swriter = new StringWriter();
								PrintWriter pwriter = new PrintWriter(swriter);
								e.printStackTrace(pwriter);
								JOptionPane.showMessageDialog(null, swriter.toString());
							}
						}
					}
				);
			
			thread.start();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Empty report.");
		}
	
	}
	/**
	 *
	 */
	protected void btnCurrentActionPerformed(java.awt.event.ActionEvent evt)
	{
		
		if (jasperPrint != null)
		{				
			final JasperPrint print = jasperPrint;
			
			Thread thread = new Thread
				(
					new Runnable()
					{
						public void run()
						{
							try 
							{
								JasperPrintManager.printPage(print, Integer.parseInt(txtGoTo.getText())-1, false);
							}
							catch (Exception e) 
							{
								StringWriter swriter = new StringWriter();
								PrintWriter pwriter = new PrintWriter(swriter);
								e.printStackTrace(pwriter);
								JOptionPane.showMessageDialog(null, swriter.toString());
							}
						}
					}
				);
			
			thread.start();
		}
		else
		{
			JOptionPane.showMessageDialog(this, "Empty report.");
		}
	
	}
}
