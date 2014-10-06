package com.vriche.adrm.util;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;



 
 
public class JsonUtil2 {  
	
	 private static Set inclueFields = new HashSet(); 
   
  private static org.apache.commons.logging.Log log = org.apache.commons.logging.LogFactory  
      .getLog(JsonUtil.class);  
  
  private static final Object EMPTY_OBJECT_ARRAY[] = new Object[0];    
 
  /**   
   * 转换成JSON时需要包含的字段   
   * @param excludes   
   */    
  public static void setInclueFields(String[] inclues) {  
      for (int i = 0 ;i< inclues.length;i++) {     
      	inclueFields.add(inclues[i]);     
      }     
  }   
  
  public static String object2json(Object obj) {  
    StringBuffer json = new StringBuffer();  
    if (obj == null) {  
      json.append("\"\"");  
    } else if (obj instanceof String ||
         obj instanceof Integer ||
         obj instanceof Float  ||
         obj instanceof Boolean ||
         obj instanceof Short ||
         obj instanceof Double || 
         obj instanceof Long ||
         obj instanceof BigDecimal ||
         obj instanceof BigInteger || 
         obj instanceof Byte) {  
    			String s = string2json(obj.toString());
    			if("true".equals(s)||"false".equals(s)){
    				json.append(string2json(obj.toString())); 
    			}else{
    				json.append("\"").append(string2json(obj.toString())).append("\""); 
    				}
    		
    			
      
    } else if (obj instanceof Object[]) {  
      json.append(array2json((Object[]) obj));  
    } else if (obj instanceof List) {  
      json.append(list2json((List) obj));  
    } else if (obj instanceof Map) {  
      json.append(map2json((Map) obj));  
    } else if (obj instanceof Set) {  
      json.append(set2json((Set) obj));  
    } else {  
      json.append(bean2json(obj));  
    }  
    return json.toString();  
  }  
 
   
  public static String bean2json(Object bean) {  
	  StringBuffer json = new StringBuffer();  
    json.append("{");  
    PropertyDescriptor[] props = null;  
    try {  
      props = Introspector.getBeanInfo(bean.getClass(), Object.class).getPropertyDescriptors();  
    } catch (IntrospectionException e) {}  
    if (props != null) {  
      for (int i = 0; i < props.length; i++) {  
        try {  
          String name = object2json(props[i].getName()); 
//       	System.out.println(">>>>>>>>>>>>>>>>>>>>>>"+name);
//          String value = object2json(props[i].getReadMethod().invoke(bean));  
          String value = object2json(props[i].getReadMethod().invoke(bean, EMPTY_OBJECT_ARRAY));
          
          
//       	System.out.println(">>>>>>>>>>>value>>>>>>>"+value); 
          
          
          if (!inclueFields.contains(name)) {     
              continue;     
          					}  
          
          
          json.append(name);  
          json.append(":");  
          json.append(value);  
          json.append(",");  
        } catch (Exception e) {}  
      }  
      json.setCharAt(json.length() - 1, '}');  
    } else {  
      json.append("}");  
    }  
    return json.toString();  
  }  
 
   
  public static String list2json(List list) {  
    StringBuffer json = new StringBuffer();  
    json.append("[");  
    if (list != null && list.size() > 0) {  
    	
    	    Iterator it = list.iterator();
    	    while(it.hasNext()){
    	    	  json.append(object2json(it.next()));  
    	    	  json.append(",");  
    	    			}
    	
//      for (Object obj : list) {  
//        json.append(object2json(obj));  
//        json.append(",");  
//      			}  
      
      
      
      json.setCharAt(json.length() - 1, ']');  
    } else {  
      json.append("]");  
    }  
    return json.toString();  
  }  
 
   
  public static String array2json(Object[] array) {  
    StringBuffer json = new StringBuffer();  
    json.append("[");  
    if (array != null && array.length > 0) {  
//      for (Object obj : array) {  
//        json.append(object2json(obj));  
//        json.append(",");  
//      }  
    	
    	for(int i=0;i<array.length;i++){
          json.append(object2json(array[i]));  
          json.append(",");  
    	}
    	
    	
    	
    	
    	
      json.setCharAt(json.length() - 1, ']');  
    } else {  
      json.append("]");  
    }  
    return json.toString();  
  }  
 
   
  public static String map2json(Map map) {  
    StringBuffer json = new StringBuffer();  
    json.append("{");  
    if (map != null && map.size() > 0) {  
    	
    	
	    Iterator it = map.keySet().iterator();
	    while(it.hasNext()){
	    			Object key = it.next();
	        json.append(object2json(key));  
	        json.append(":");  
	        json.append(object2json(map.get(key)));  
	        json.append(",");  
	    		}
    	
    	
    	
//      for (Object key : map.keySet()) {  
//        json.append(object2json(key));  
//        json.append(":");  
//        json.append(object2json(map.get(key)));  
//        json.append(",");  
//      }  
      json.setCharAt(json.length() - 1, '}');  
    } else {  
      json.append("}");  
    }  
    return json.toString();  
  }  
 
   
  public static String set2json(Set set) {  
    StringBuffer json = new StringBuffer();  
    json.append("[");  
    if (set != null && set.size() > 0) {  
    	
	    Iterator it = set.iterator();
	    while(it.hasNext()){
	    	  json.append(object2json(it.next()));  
	    	  json.append(",");  
	    		}
	  	
    	
    	
//      for (Object obj : set) {  
//        json.append(object2json(obj));  
//        json.append(",");  
//      }  
      json.setCharAt(json.length() - 1, ']');  
    } else {  
      json.append("]");  
    }  
    return json.toString();  
  }  
 
   
  public static String string2json(String s) {  
    if (s == null)  
      return "";  
    StringBuffer sb = new StringBuffer();  
    for (int i = 0; i < s.length(); i++) {  
      char ch = s.charAt(i);  
      switch (ch) {  
      case '"':  
        sb.append("\\\"");  
        break;  
      case '\\':  
        sb.append("\\\\");  
        break;  
      case '\b':  
        sb.append("\\b");  
        break;  
      case '\f':  
        sb.append("\\f");  
        break;  
      case '\n':  
        sb.append("\\n");  
        break;  
      case '\r':  
        sb.append("\\r");  
        break;  
      case '\t':  
        sb.append("\\t");  
        break;  
      case '/':  
        sb.append("\\/");  
        break;  
      default:  
        if (ch >= '\u0000' && ch <= '\u001F') {  
          String ss = Integer.toHexString(ch);  
          sb.append("\\u");  
          for (int k = 0; k < 4 - ss.length(); k++) {  
            sb.append('0');  
          }  
          sb.append(ss.toUpperCase());  
        } else {  
          sb.append(ch);  
        }  
      }  
    }  
    return sb.toString();  
  }  
} 