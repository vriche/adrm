package com.vriche.adrm.util;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

//import net.sf.json.JSONObject;


public class JsonUtil {
//	排除的字段     
    private static Set excludeFields = new HashSet();     
    private static Set inclueFields = new HashSet();     
    
    private static final Object EMPTY_OBJECT_ARRAY[] = new Object[0];    
    
    public JsonUtil() {     
        excludeFields.add("class");     
        excludeFields.add("declaringClass");     
        excludeFields.add("metaClass");     
    }   
    
//    public static Map parserToMap(String s){
//		Map map=new HashMap();
//		JSONObject json=JSONObject.fromObject(s);
//		Iterator keys=json.keys();
//		while(keys.hasNext()){
//			String key=(String) keys.next();
//			String value=json.get(key).toString();
//			if(value.startsWith("{")&&value.endsWith("}")){
//				map.put(key, parserToMap(value));
//			}else{
//				map.put(key, value);
//			}
//
//		}
//		return map;
//	}
    
    /**   
     * 转换成JSON时需要排除的字段   
     * @param excludes   
     */    
    public static void setExcludeFields(String[] excludes) {  
        for (int i = 0 ;i< excludes.length;i++) {     
            excludeFields.add(excludes[i]);     
        }     
    }   
    
    
    /**   
     * 转换成JSON时需要包含的字段   
     * @param excludes   
     */    
    public static void setInclueFields(String[] inclues) {  
        for (int i = 0 ;i< inclues.length;i++) {     
        	inclueFields.add(inclues[i]);     
        }     
    }   
    
    /**   
     * 将Java对象转化为JSON对象   
     * @param obj java对象   
     * @return js对象   
     */    
//    public String encode(Object object) {     
//        return encodeBasic(object);     
//    }     
    
    /**   
     * 将Java对象转化为JSON对象   
     * @param obj java对象   
     * @return js对象   
     */    
    public static  String encodeBasic(Object object) {     
        // basic     
        if (object == null) {     
            return encodeNULL();     
        } else if (object instanceof String) {     
            return encodeString((String) object);
//            return (String) object;
            
        } else if (object instanceof Boolean) {     
            return encodeBoolean((Boolean) object); 
            
        } else if (object instanceof Integer) {     
            return encodeInteger((Integer) object);              
        }else if (object instanceof Double) {     
            return encodeDouble((Double) object);   
            
        }else if (object instanceof Number) {     
            return encodeNumber((Number) object);     
        }else if (object instanceof Map) {     
            return encodeMap((Map) object);     
//        } else if (object instanceof Iterable) {     
//            return encodeIterable((Iterable) object);     
        } else if (object instanceof Collection) {     
            return encodeCollection((Collection) object);                
        } else if (object instanceof Object[]) {// object.getClass().isArray()     
            return encodeArray((Object[]) object);     
        } else if (object instanceof java.util.Date) {     
            return encodeDate((java.util.Date) object);     
        } else {     
            Class clazz = object.getClass();     
    
        if (clazz.isInterface()) {     
                return encodeEmpty();     
            		}  
            
//        System.out.println("aaa bbbbbbbbbbbbb ccccccccc>>>>>>>>>>>encodeAdapter>>>>>>>>>>>>>> ******************" ); 
        
        
            return encodeAdapter(object);     
    
//            if (clazz.isEnum()) {     
//                return encodeEnum((java.lang.Enum) object);     
//            } else {     
//                return encodeAdapter(object);     
//            }     
        }     
    }     
    
    /**   
     * 返回一个NULL对象   
     * @return javascript null对象   
     */    
    public static String encodeNULL() {     
        return "null";     
    }     
    
    /**   
     * 将Java-String对象转化为JSON对象   
     * @param string 字符串对象   
     * @return javascript string对象   
     */    
    public  static String encodeString(String string) {     
    	StringBuffer sbr = new StringBuffer();     
        sbr.append("'");     
        for (int i = 0, sz = string.length(); i < sz; i++) {     
            char ch = string.charAt(i);     
            // handle unicode     
            if (ch > 0xfff) {     
                sbr.append("\\u");     
                sbr.append(hex(ch));     
            } else if (ch > 0xff) {     
                sbr.append("\\u0");     
                sbr.append(hex(ch));     
            } else if (ch > 0x7f) {     
                sbr.append("\\u00");     
                sbr.append(hex(ch));     
            } else if (ch < 32) {     
                switch (ch) {     
                case '\b':     
                    sbr.append('\\');     
                    sbr.append('b');     
                    break;     
                case '\n':     
                    sbr.append('\\');     
                    sbr.append('n');     
                    break;     
                case '\t':     
                    sbr.append('\\');     
                    sbr.append('t');     
                    break;     
                case '\f':     
                    sbr.append('\\');     
                    sbr.append('f');     
                    break;     
                case '\r':     
                    sbr.append('\\');     
                    sbr.append('r');     
                    break;     
                default:     
                    if (ch > 0xf) {     
                        sbr.append("\\u00");     
                        sbr.append(hex(ch));     
                    } else {     
                        sbr.append("\\u000");     
                        sbr.append(hex(ch));     
                    }     
                    break;     
                }     
            } else {     
                // line.     
                switch (ch) {     
                case '\'':     
                    sbr.append('\\');     
                    sbr.append('\'');     
                    break;     
                case '"':     
                    sbr.append('\\');     
                    sbr.append('"');     
                    break;     
                case '\\':     
                    sbr.append('\\');     
                    sbr.append('\\');     
                    break;     
                default:     
                    sbr.append(ch);     
                    break;     
                }     
            }     
        }     
        sbr.append("'");     
        return sbr.toString();     
    }     
    
     public  static String hex(char ch) {     
        return Integer.toHexString(ch).toUpperCase(Locale.ENGLISH);     
    }     
    
    /**   
     * 将Java-Boolean对象转化为JSON对象   
     * @param obj 字符串对象   
     * @return javascript Boolean对象   
     */    
     public  static String encodeBoolean(Boolean b) {     
        return b.toString();     
    }     
     
     public  static String encodeInteger(Integer b) {     
         return b.toString();     
     }     
        
     
     
     
     /**   
      * 将Java-Boolean对象转化为JSON对象   
      * @param obj 字符串对象   
      * @return javascript Boolean对象   
      */    
      public  static String encodeDouble(Double b) {     
         return b.toString();     
     }       
     
     
    
    /**   
     * 将Java-Number对象转化为JSON对象   
     * @param n 数字对象   
     * @return javascript Number对象   
     */    
     public  static String encodeNumber(Number n) {     
        return n.toString();     
    }     
    
    /**   
     * 将Java-Map对象转化为JSON对象   
     *    
     * @param map Map对象   
     * @return javascript Map对象(简单对象)   
     */    
    public  static String encodeMap(Map map) {     
    	StringBuffer sbr = new StringBuffer();     
        sbr.append("{");     
        boolean isFirst = true;     
        for (java.util.Iterator it = map.entrySet().iterator(); it.hasNext();) {     
            if (isFirst) {     
                isFirst = false;     
            } else {     
                sbr.append(",");     
            }     
            Map.Entry entry = (Map.Entry) it.next();     
            sbr.append(encodeBasic(entry.getKey())).append(":").append(encodeBasic(entry.getValue()));     
        }     
        sbr.append("}");     
        return sbr.toString();     
    }     
    
//    /**   
//     * 将Java-Iterable对象转化为JSON对象   
//     * @param iterable Iterable对象   
//     * @return javascript Array对象   
//     */    
//     public static String encodeIterable(java.lang.Iterable iterable) {     
//    	StringBuffer sbr = new StringBuffer();     
//        sbr.append("[");     
//        int index = 0;     
//        for (java.util.Iterator it = iterable.iterator(); it.hasNext();) {     
//            if ((index++) > 0) {     
//                sbr.append(",");     
//            }     
//            sbr.append(encodeBasic(it.next()));     
//        }     
//        sbr.append("]");     
//        return sbr.toString();     
//    }     
    
    /**   
     * 将Java-Iterable对象转化为JSON对象   
     * @param iterable Iterable对象   
     * @return javascript Array对象   
     */    
     public  static String encodeCollection(Collection col) {     
    	StringBuffer sbr = new StringBuffer();     
        sbr.append("[");     
        int index = 0;     
        for (java.util.Iterator it = col.iterator(); it.hasNext();) {     
            if ((index++) > 0) {     
                sbr.append(",");     
            }     
            sbr.append(encodeBasic(it.next()));     
        }     
        sbr.append("]");     
        return sbr.toString();     
    }    
    
    /**   
     * 将Java-数组对象转化为JSON对象   
     * @param obj 数组对象   
     * @return javascript Array对象   
     */    
     public  static String encodeArray(Object[] array) {     
        StringBuffer sbr = new StringBuffer();     
        sbr.append("[");     
        for (int index = 0; index < array.length; index++) {     
            if (index > 0) {     
                sbr.append(",");     
            }     
            Object o = array[index];     
            sbr.append(encodeBasic(o));     
        }     
        sbr.append("]");     
        return sbr.toString();     
    }     
    
    /**   
     * 将Java-Date对象转化为JSON对象   
     * @param date 日期对象   
     * @return javascript Date对象   
     */    
     public  static String encodeDate(java.util.Date date) {     
        return new StringBuffer().append("new Date(").append(date.getTime()).append(")").toString();     
    }     
    
    /**   
     * 将Java-Enum对象转化为JSON对象   
     * @param e 枚举对象   
     * @return javascript Date对象   
     */    
//     public static String encodeEnum(java.lang.Enum e) {     
//        return "'" + e.name() + "'";     
//    }     
    
    /**   
     * 返回一个JSON简单对象   
     * @return javascript 简单对象   
     */    
     public  static String encodeEmpty() {     
        return "{}";     
    }     
    
    /**   
     * 将Java对象转化为JSON对象   
     * @param object Java对象   
     * @return 如果适配器能解析,则返回解析后的JSON对象，否则返回一个默认Empty JSON对象   
     */    
     public  static String encodeAdapter(Object object) {     
        try {     
            Map  proxy = new HashMap();     
            Class clazz = object.getClass();     
            if (clazz == null) {     
                throw new IllegalArgumentException("No bean class specified");     
            }     
            
//            proxy.put("class", clazz.getName());  
            
            PropertyDescriptor[] descriptors = null;     
            try {     
                descriptors = Introspector.getBeanInfo(clazz).getPropertyDescriptors();     
            } catch (IntrospectionException e) {     
                descriptors = new PropertyDescriptor[0];     
            					}     
            for (int i = 0, j = descriptors.length; i < j; i++) {     
                PropertyDescriptor descriptor = descriptors[i];     
                String key = descriptor.getName();    
                
//                System.out.println("encodeAdapter key  3  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   "+key);
                
                if(inclueFields.size()>0){
                    							//包含的字段     
                    if (!inclueFields.contains(key)) {     
                        continue;     
                    									}  
                }else{
                								//排除的字段     
                    if (excludeFields.contains(key)) {     
                        continue;     
                    								}  
                						}
                
//                System.out.println("encodeAdapter key		4 >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   "+key);
   
                Method method = descriptor.getReadMethod();     
                if (descriptor.getReadMethod() != null) {     
                    Class type = descriptor.getPropertyType();     
              
//                    System.out.println("encodeAdapter type>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   "+type);
//                    if (type.isEnum()) {     
//                        continue;     
//                    }     
                    Object value = method.invoke(object, EMPTY_OBJECT_ARRAY);    
//                    System.out.println("encodeAdapter key>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   "+key);
                    proxy.put(key, value);   
                    
                						}     
            				}     
            return encodeMap(proxy);     
        } catch (Exception ex) {     
            return encodeEmpty();     
        }     
    }      
}
