package com.vriche.adrm.webapp.serlet;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.filechooser.FileSystemView;

import com.vriche.adrm.model.FileInfo;
import com.vriche.adrm.util.FileUtils;
import com.vriche.adrm.util.JsonUtil2;
  
/** 
 * <b>function:</b> 查询本地硬盘文件数据、创建目录 
 * @project Test 
 * @package com.hoo.servlet  
 * @fileName FileBrowser.java 
 * @author hoojo 
 */  
public class FileBrowserServlet extends HttpServlet {  
    private static final long serialVersionUID = 1599390137455995515L;  
  
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
    	
    	
//    	 System.out.println(">>>>>>>>>>>>path>>>>>>>>>>>>>>"); 
    	 

    	 
//        response.setContentType("text/html");  
//        response.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=UTF-8");
        
        PrintWriter out = response.getWriter();  
          
        String path = request.getParameter("path"); 
        
        System.out.println(">>>>>>>>>>>>path>>>>>>>>>>>>>>"+path); 

        path = path == null ? "" : URLDecoder.decode(path, "UTF-8");  
        String method = request.getParameter("method");  
        FileInfo info = new FileInfo();  
        
//        System.out.println(">>>>>>>>>>>>path>>>>>>>>>>>>>>" +path);   
        
        if ("getData".equals(method)) {  
        	
            if ("root".equals(path)) {            
                FileSystemView fsv = FileSystemView.getFileSystemView();
                File[] roots = fsv.getRoots(); //File.listRoots(); 
                
//                System.out.println(">>>>>>>>>>>>roots.length>>>>>>>>>>>>>>" + roots.length); 
                
                							//桌面  
                for(int i = 0;i<roots.length;i++){
                		File f = roots[i];   
                		info.getChildren().add(FileUtils.getFileInfo(f));  
                							}

                                       
                File[] allFiles1 = roots[0].listFiles();  
                
//                System.out.println(">>>>>>>>>>>>roots[0].listFiles().length>>>>>>>>>>>>>>" + allFiles1.length); 
                
                int k = 0;
                for(int i = 0;i<allFiles1.length;i++){
                				File f = allFiles1[i];
//                    if (f.getName().indexOf("My Documents")>-1) {  
//                				System.out.println(">>>>>>>>>>>>>> k >>>>>>>>>>>"+(k++) ); 
                        info.getChildren().add(FileUtils.getFileInfo(f));  
//                        System.out.println(">>>>>>>>>>>>f.getName()>>>>>>>>>>>>>>" + f.getName()); 
//                    									}  
            								}            
                
                
                
                
//                FileInfo fileInfo = new FileInfo();  
//                fileInfo.setName("我的电脑");  
//                fileInfo.setPath("My Computer"); 
//                File[] allFiles2 = roots[0].listFiles()[0].listFiles(); 
//                for(int i = 0;i<allFiles2.length;i++){
//                		File fi = allFiles2[i];
//                		fileInfo.getChildren().add(FileUtils.getFileInfo(fi));  
//											}      
//                
//
//                
//                info.getChildren().add(fileInfo);  
//                fileInfo = new FileInfo();  
//                fileInfo.setName("网上邻居");  
//                fileInfo.setPath("Network Place");  
//                File[] allFiles3 = roots[0].listFiles()[1].listFiles(); 
//                for(int i = 0;i<allFiles3.length;i++){
//                			File fi = allFiles3[i];
//                			fileInfo.getChildren().add(FileUtils.getFileInfo(fi));  
//                							}
//                
// 
//                
//                info.getChildren().add(fileInfo);   1 6  n18   5 7 
                
//                System.out.println(">>>>>>>>>>>>fileInfos.length>>> 0  >>>>>>>>>>>" ); 
//                String joson = JsonUtil.encodeArray(info.getChildren().toArray(new FileInfo[info.getChildren().size()-1]));
                
//                String joson = JsonUtil.encodeCollection(info.getChildren());
//                String joson =  JSONArray.fromCollection(info.getChildren()).toString();
                String joson =  JsonUtil2.list2json(info.getChildren());
                
//                String joson = "[{expand:true,id:123,leaf:false,name:2012,path:\"ctr_data\",text:\"2012\"}]";
               
                System.out.println(">>>>>>>>>>>>joson  1 >>>>>>>>>" + joson); 
                out.print(joson); 
                
                
//                FileInfo[] fileInfos = new FileInfo[info.getChildren().size()];
////                
//////                System.out.println(">>>>>>>>>>>>fileInfos.length>>> 1  >>>>>>>>>>>" + fileInfos.length); 
////                
//                Iterator it= info.getChildren().iterator();
//                	int i = 0;
//                	
//                while(it.hasNext()){
//                	
////                	System.out.println(">>>>>>>>>>>>fileInfos.length>>> 2  >>>>>>>>>>>"+(k++) ); 
//                	
//                	FileInfo ff= (FileInfo)it.next();
//                	System.out.println(">>>>>>>>>>> getText  >>>>>>>>>>>" + ff.getText()); 
//                	fileInfos[i++] = ff;
//                							}
//                
//            	System.out.println(">>>>>>>>>>> i  >>>>>>>>>>>" + i ); 
//            	
////                System.out.println(">>>>>>>>>>>>fileInfos.length>>> 2  >>>>>>>>>>>" + fileInfos.length); 
//                                           
//                System.out.println(">>>>>>>>>>>>JSONArray.fromObject>>>>>>>>>>>>>" + JsonUtil.encodeArray(fileInfos)); 
//                
//                out.print(JsonUtil.encodeArray(fileInfos)); 
//                out.print(JSONArray.fromObject(info.getChildren().toArray(new FileInfo[info.getChildren().size()-1])).toString()); 
                
            
                
            } else if (path != null && !"".equals(path)) {  
                FileUtils.getFileInfo(info, new File(path), new String[] {"*"});  
//                out.print(JSONArray.fromObject(info.getChildren()).toString()); 
//                String joson = JsonUtil.encodeArray(info.getChildren().toArray(new FileInfo[info.getChildren().size()-1]));
//                JsonUtil.setInclueFields(new String[]{"id","name","text","path"});
//                String joson = JsonUtil.encodeCollection(info.getChildren());
//                String joson =  JSONArray.fromCollection(info.getChildren()).toString();
                String joson =  JsonUtil2.list2json(info.getChildren());
//                String joson = "[{\"expand\":true,\"id\":123,\"leaf\":false,\"name\":2012,path:\"ctr_data\",text:\"2012\"}]";
               
                
                System.out.println(">>>>>>>>>>>>joson  2>>>>>>>>>" + joson); 
                
                out.print(joson); 

      

                
                
//                out.print(JsonUtil.encodeArray(info.getChildren().toArray(new FileInfo[info.getChildren().size()-1]))); 
            					}   
        }  
        if ("mkDir".equals(method)) {  
            String dirName = request.getParameter("dirName");  
            dirName = dirName == null ? "" : URLDecoder.decode(dirName, "UTF-8");  
            boolean success = false;  
            try {  
                success = FileUtils.mkDir(path, dirName);  
                FileInfo node = FileUtils.getFileInfo(new File(FileUtils.getDoPath(path) + dirName));  
                out.print(JsonUtil2.object2json(node));  
            } catch (Exception e) {  
                e.printStackTrace();  
                success = false;  
            					}  
            System.out.println(success);  
        			}  
        
        if ("deleFile".equals(method)) {  
            String dirName = request.getParameter("dirName");  
            dirName = dirName == null ? "" : URLDecoder.decode(dirName, "UTF-8");  
            boolean success = false;  
            try {  
                success = FileUtils.deleFile(path+dirName);  
                FileInfo node = FileUtils.getFileInfo(new File(FileUtils.getDoPath(path) + dirName));  
                out.print(JsonUtil2.object2json(node));  
            } catch (Exception e) {  
                e.printStackTrace();  
                success = false;  
            					}  
            System.out.println(success);  
        			}  
        
        
        
        
        
        out.flush();  
        out.close();  
    }  
  
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        this.doGet(request, response);  
    }  
}  