package com.vriche.adrm.model;
  
import java.util.ArrayList;  
import java.util.List;  
  
/** 
 * <b>function:</b>文件信息 
 * @author hoojo 
 * @createDate Oct 10, 2010 9:53:51 PM 
 * @file FileInfo.java 
 * @package com.hoo.entity 
 * @project MultiUpload 
 * @blog http://blog.csdn.net/IBM_hoojo 
 * @email hoojo_@126.com 
 * @version 1.0 
 */  
public class FileInfo {  
    //文件id  
    private String id;  
    //文件名称  
    private String name;  
    
    private String text;  
    //文件路径  
    private String path;  
    //是否有目录，有无子节点  
    private boolean leaf; 
    
    private boolean expand;  
    
    
    //修改日期  
    private String editDate;  
    //后缀  
    private String suffix;  
    //长度  
    private long length;  
    // 子目录中所有文件  
    private List children = new ArrayList();  
    //setter、getter   
    public String toString() {  
        return "name:" + name + ", size:" + children.size();  
    }
    
	public List getChildren() {
		return children;
	}
	public void setChildren(List children) {
		this.children = children;
	}
	public String getEditDate() {
		return editDate;
	}
	public void setEditDate(String editDate) {
		this.editDate = editDate;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public boolean isLeaf() {
		return leaf;
	}
	public void setLeaf(boolean leaf) {
		this.leaf = leaf;
	}
	public long getLength() {
		return length;
	}
	public void setLength(long length) {
		this.length = length;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getSuffix() {
		return suffix;
	}
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

	public boolean isExpand() {
		return expand;
	}

	public void setExpand(boolean expand) {
		this.expand = expand;
	}  
} 