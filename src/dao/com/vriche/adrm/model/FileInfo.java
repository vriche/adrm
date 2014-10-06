package com.vriche.adrm.model;
  
import java.util.ArrayList;  
import java.util.List;  
  
/** 
 * <b>function:</b>�ļ���Ϣ 
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
    //�ļ�id  
    private String id;  
    //�ļ�����  
    private String name;  
    
    private String text;  
    //�ļ�·��  
    private String path;  
    //�Ƿ���Ŀ¼�������ӽڵ�  
    private boolean leaf; 
    
    private boolean expand;  
    
    
    //�޸�����  
    private String editDate;  
    //��׺  
    private String suffix;  
    //����  
    private long length;  
    // ��Ŀ¼�������ļ�  
    private List children = new ArrayList();  
    //setter��getter   
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