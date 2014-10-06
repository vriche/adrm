package com.vriche.adrm.webapp.serlet;
import java.io.IOException;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.dhtmlx.xml2excel.CSVWriter;
import com.vriche.adrm.util.StringUtil;

public class DhtmlCSVGeneratorServlet extends HttpServlet {

		public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			
			String xml = StringUtil.getURLDecoderStr(req.getParameter("grid_xml"));
			
//			req.setCharacterEncoding("UTF-8");
//			String xml = req.getParameter("grid_xml");
//			xml = URLDecoder.decode(xml, "UTF-8");
			CSVWriter writer = new CSVWriter();
			writer.generate(xml, resp);
		}
		
//		public void service(HttpServletRequest req,	HttpServletResponse resp) throws IOException, ServletException
//		{
//			req.setCharacterEncoding("UTF-8");
//			String xml = req.getParameter("grid_xml");
//			xml = URLDecoder.decode(xml, "UTF-8");
//			CSVWriter writer = new CSVWriter();
//			writer.generate(xml, resp);
//		}
}
