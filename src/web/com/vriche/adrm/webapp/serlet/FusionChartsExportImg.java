package com.vriche.adrm.webapp.serlet;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfWriter;



	
	/**
	 *
	 * <br>
	 * 说明：<br>
	 * <br>
	 * 导出图形
	 * @author: meteor
	 * 创建时间 2008-11-11<br>
	 * <br>
	 * 修改记录:
	 */
public class FusionChartsExportImg extends HttpServlet {
	 private static final long serialVersionUID = 1L;

//	 private static final Logger log = Logger.getLogger(FusionChartsExportImg.class);

	 private int width = 0;

	 private int height = 0;

	
	 protected void service(HttpServletRequest request,
	   HttpServletResponse response) throws ServletException, IOException {
	  try {
			BufferedImage chart = getPicture(request, response);
			exportImgFile(chart, response);
	  } catch (Exception e) {
//	      log.error("Error", e);
	      System.out.println("Error"+e.toString());
	  }
	 }
	 
	 
	 
//	 protected void service(HttpServletRequest request,
//			   HttpServletResponse response) throws ServletException, IOException {
//			  try {
//					String type = request.getParameter("exportType");
//					HttpSession session = request.getSession();
//					System.out.println("exportType>>>>>>>>>>>>>>" + type);
//					if (null != type) {
//						session.removeAttribute("sessExportType");
//						session.setAttribute("sessExportType", type);
//					} else {
//						response.setContentType("application/vnd.ms-excel");
//						BufferedImage chart = getPicture(request, response);
//						ByteArrayOutputStream byteArrayOut = savePicture(chart);
//						String exportType = (String) session.getAttribute("sessExportType");
//						if (exportType.equals("PDF")) {
//							this.exportPdf(byteArrayOut, response);
//						} else if (exportType.equals("EXCEL")) {
//							this.exportExcel(byteArrayOut, response);
//						} else {
//							exportImgFile(chart, response);
//						}
//					}
//			  } catch (Exception e) {
////			      log.error("Error", e);
//			      System.out.println("Error"+e.toString());
//			  }
//			 }

	 /**
	  * 导出到excel
	  * @param byteArrayOut
	  * @param response
	  */
	 private void exportExcel(ByteArrayOutputStream byteArrayOut,
	   HttpServletResponse response) {
	  try {
	   HSSFWorkbook wb = new HSSFWorkbook();
	   HSSFSheet sheet = wb.createSheet("dpChart");
//	   sheet.setColumnWidth(arg0, arg1)
//	   row.setHeight((short)height);
	   HSSFPatriarch patriarch = sheet.createDrawingPatriarch();
	   int rowL = height/20;
	   int colL = width/70;
	   
	   HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 255, 255,
	     (short) 0, 1, (short)colL,rowL);

	   int a = wb.addPicture(byteArrayOut.toByteArray(),
	     HSSFWorkbook.PICTURE_TYPE_JPEG);
	   patriarch.createPicture(anchor, a);//将统计图片添加到Excel文件中
	   response.setContentType("xls");//image/jpeg
	   response.addHeader("Content-Disposition","attachment; filename=\"FusionCharts.xls\"");
	   OutputStream os = response.getOutputStream();
	   wb.write(os);
	   os.close();
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	 }

	 /**
	  * 导出到pdf
	  * @param byteArrayOut
	  * @param response
	  */
	 private void exportPdf(ByteArrayOutputStream byteArrayOut,
	   HttpServletResponse response) {
	  try {
	   Document doc = new Document();
	   Image jpeg;
	   try {
	    response.setContentType("pdf");
	    response.addHeader("Content-Disposition",
	      "attachment; filename=\"FusionCharts.pdf\"");
	    OutputStream os = response.getOutputStream();
	    PdfWriter.getInstance(doc, os);
	    doc.open();
	    jpeg = Image.getInstance(byteArrayOut.toByteArray());
	    // 图片居中
	    //log.info(jpeg.height()+"****==="+height);
	    //log.info(jpeg.width()+"****==="+width);
	    jpeg.scaleAbsolute(width,height);
	    jpeg.scalePercent(100);
	    jpeg.setAlignment(Image.ALIGN_LEFT);
	    doc.add(jpeg);
	    doc.close();
	   } catch (BadElementException e) {
	    e.printStackTrace();
	   } catch (MalformedURLException e) {
	    e.printStackTrace();
	   } catch (IOException e) {
	    e.printStackTrace();
	   } catch (DocumentException e) {
	    e.printStackTrace();
	   }
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	 }
	 
	 /**
	  * 导出到图片文件
	  * @param chart
	  * @param response
	  */
	 private void exportImgFile(BufferedImage chart,HttpServletResponse response){
	  try {
	   //Returns the image
	   response.setContentType("image/jpeg");
	   response.addHeader("Content-Disposition","attachment; filename=\"FusionCharts.jpg\"");
	   //FileOutputStream os = new FileOutputStream("d://test2.jpeg");
	   OutputStream os = response.getOutputStream();
	   ImageIO.write(chart, "jpeg", os);
	   os.close();
	  } catch (MalformedURLException e) {
	   e.printStackTrace();
	  } catch (IOException e) {
	   e.printStackTrace();
	  }
	 }

	 /**
	  * 取得图形数据信息
	  * @param request
	  * @param response
	  * @return
	  */
	 private ByteArrayOutputStream savePicture(BufferedImage chart) {
//	   字节输出流，用来写二进制文件
	  ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
	  try {
	   ImageIO.write(chart, "jpeg", byteArrayOut);
	  } catch (IOException e) {
	   e.printStackTrace();
	  }
	  return byteArrayOut;
	 }
	 
	 /**
	  * 取得图形数据信息
	  * @param request
	  * @param response
	  * @return
	  */
	 private BufferedImage getPicture(HttpServletRequest request,
	   HttpServletResponse response) {
	  String data = "";
	  String[] rows;
	  String bgcolor = "";
	  Color bgColor;  
	  PrintWriter out = null;
	  
	  try {
	   out = response.getWriter();
	  } catch (IOException e1) {
	   e1.printStackTrace();
	  }

	  try {
	   width = Integer.parseInt(request.getParameter("width"));
	   this.setWidth(width);
	   height = Integer.parseInt(request.getParameter("height"));
	   this.setHeight(height);
	  } catch (Exception e) {
	   out.print("Image width/height not provided.");
	   out.close();
	  }

	  if (width == 0 || height == 0) {
	   out.print("Image width/height not provided.");
	   out.close();
	  }

	  // Get background color from request and set default
	  bgcolor = request.getParameter("bgcolor");
	  if (bgcolor == null || bgcolor == "" || bgcolor == null) {
//	   bgcolor = "FFFFFF";
	   bgcolor = "CCCCCC";
	   
	  }
	  // Convert background color to color object
	  bgColor = new Color(Integer.parseInt(bgcolor, 16));

	  // Get image data from request
	  data = request.getParameter("data");

	  if (data == null) {
	   out.print("Image Data not supplied.");
	   out.close();
	  }
	  
	  BufferedImage chart = null;
	  try {
	   // Parse data
	   rows = new String[height + 1];
	   rows = data.split(";");
	   // Bitmap to store the chart.
	   // Reference to graphics object - gr
	   chart = new BufferedImage(width, height,BufferedImage.TYPE_3BYTE_BGR);
	   Graphics gr = chart.createGraphics();
	   gr.setColor(bgColor);
	   gr.fillRect(0, 0, width, height);

	   String c;
	   int r;
	   int ri = 0;
	   for (int i = 0; i < rows.length; i++) {
	    // Split individual pixels.
	    String[] pixels = rows[i].split(",");
	    // Set horizontal row index to 0
	    ri = 0;
	    for (int j = 0; j < pixels.length; j++) {
	     // Now, if it's not empty, we process it
	     // Split the color and repeat factor
	     String[] clrs = pixels[j].split("_");
	     // Reference to color
	     c = clrs[0];
	     r = Integer.parseInt(clrs[1]);

	     // If color is not empty (i.e. not background pixel)
	     if (c != null && c.length() > 0 && c != "") {
	      if (c.length() < 6) {
	       // If the hexadecimal code is less than 6
	       // characters, pad with 0
	       StringBuffer str = new StringBuffer(c);
	       // int strLength = str.length();
	       for (int p = c.length() + 1; p <= 6; p++) {
	        str.insert(0, "0");
	       }
	       // Assing the new padded string
	       c = str.toString();
	      }
	      for (int k = 1; k <= r; k++) {
	       // Draw each pixel
	       gr.setColor(new Color(Integer.parseInt(c, 16)));
	       gr.fillRect(ri, i, 1, 1);
	       // Increment horizontal row count
	       ri++;
	      }
	     } else {
	      // Just increment horizontal index
	      ri = ri + r;
	     }
	    }
	   }
	  } catch (Exception e) {
	   // IF the image data is mal-formatted.
	   out.print("Image data is not in proper format.");
	   out.close();
	  }
	  return chart;
	 }

	 public int getHeight() {
	  return height;
	 }

	 public void setHeight(int height) {
	  this.height = height;
	 }

	 public int getWidth() {
	  return width;
	 }

	 public void setWidth(int width) {
	  this.width = width;
	 }

}
