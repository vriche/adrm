
<%

 
    String path2=request.getRealPath("upload")+ FILE_SEP+ "download";
    File d2 = new File(path2);
    if(!d2.exists())d2.mkdir();



    StringBuffer sbd = new StringBuffer();
    String dirUpload = "upload/download";
    String pathUpload = request.getRealPath(dirUpload);
    File uFile = new File(pathUpload); 
    File uList[] = uFile.listFiles(); 

    sbd.append("<table  width=\"100%\"  border=\"0\">");
    for(int i=0;i<uList.length;i++){
      if(uList[i].isFile()){
	String name =uList[i].getName();
	long lm = uList[i].lastModified(); 
	String url = "download" + "/" + name;
	String hre = "<a href=" + url + ">" + name +"</a>";
	String lastModified = sdf.format(new Date(lm));
            	
        sbd.append("<tr>");
        
        sbd.append("<td width=\"50%\">");
        sbd.append(hre);
        sbd.append("</td>");
        
        sbd.append("<td>");
        sbd.append(lastModified);
        sbd.append("</td>"); 
           
        sbd.append("</tr>");
      }
    }
   sbd.append("</table>");

   out.println(sbd.toString());   
    
    
    
    
    
    
    
      
%>


