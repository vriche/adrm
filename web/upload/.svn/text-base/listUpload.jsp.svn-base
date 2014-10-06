
<%

    String path1=request.getRealPath("upload")+ FILE_SEP+ "upload";
    File d1 = new File(path1);
    if(!d1.exists())d1.mkdir();

    StringBuffer sbu = new StringBuffer();
    String dirDownload = "upload/upload";
    String pathDownload=request.getRealPath(dirDownload);
    File dFile = new File(pathDownload); 
    File dList[] = dFile.listFiles(); 
    
    
    sbu.append("<table  width=\"100%\" border=\"0\">");
    for(int i=0;i<dList.length;i++){
      if(dList[i].isFile()){ 
	String name =dList[i].getName();
	long lm = dList[i].lastModified(); 
	String url = "upload" + "/" + name;
	String hre = "<a href=" + url + ">" + name +"</a>";
	String lastModified = sdf.format(new Date(lm));
	
	sbu.append("<tr>");
        sbu.append("<td width=\"50%\">");
        sbu.append(hre);
        sbu.append("</td>");
        sbu.append("<td>");
        sbu.append(lastModified);
        sbu.append("</td>");    
        sbu.append("</tr>");
      }
    }
   sbu.append("</table>");

   out.println(sbu.toString());
%>



