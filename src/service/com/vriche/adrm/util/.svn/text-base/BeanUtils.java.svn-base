package com.vriche.adrm.util;
import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

public class BeanUtils {
    public static String DATE_FORMAT = "yyyy-MM-dd";
    public static String[] TYPE_SIMPLE = {"java.lang.Integer","int","java.util.Date"};
    public static String TYPE_INTEGER = "java.lang.Integer,int";
    public static String TYPE_DATE = "java.util.Date";
    
    /**
     * 得到空格之后的字符
     * 
     * @param String type
     * @param String str
     * @return Date
     * @throws ParseException
     */
    public static String splitSpace(String str) throws ParseException{
        if(StringUtils.contains(str," ")){
            return str.split(" ")[1];
        } else {
            return str;
        }
    }
    
    /**
     * 判断是否是简单数据类型
     * 
     * @param String type
     */
    public static boolean isSimpleType(String type) {
        for (int i = 0; i < TYPE_SIMPLE.length; i++) {
            if (type.equals(TYPE_SIMPLE[i])) {
                return true;
            }
        }
        return false;
    }
    /**
     * 把String类型转换为Integer
     * 
     * @param String str
     * @return Integer
     */
    public static Integer parseInteger(String str){
        if(str == null || str.equals("")){
            return new Integer(0);
        } else {
            return Integer.valueOf(str);
        }
    }
    
    /**
     * 把String类型转换为Date
     * 
     * @param String str
     * @return Date
     * @throws ParseException
     */
    public static Date parseDate(String str) throws ParseException{
        if(str == null || str.equals("")){
            return null;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
            Date date = sdf.parse(str);
            return date;
        }
    }
    
    /**
     * 转换对象（用户定义的对象）。设置对象的Id。
     * 
     * @param Class clazz
     * @param  String str
     * @return Object
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws NoSuchMethodException 
     * @throws SecurityException 
     * @throws InvocationTargetException 
     * @throws IllegalArgumentException 
     * @throws ParseException
     */
    public static Object parseObject(Class clazz, String str) throws InstantiationException, IllegalAccessException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        Object obj;
        if(str == null || str.equals("")){
            obj = null;
        } else {
            obj = clazz.newInstance();
            Class[] cls = new Class[1];
            cls[0] = str.getClass();
            Method m = clazz.getMethod("setId",cls);
            Object[] obs = new Object[1];
            obs[0] = str;
            m.invoke(obj,obs);
        }
        return obj;
    }
    
    /**
     * 根据类型进行转换
     * 
     * @param Class clazz
     * @param String str
     * @return Object
     * @throws ParseException
     * @throws IllegalAccessException 
     * @throws InstantiationException 
     * @throws InvocationTargetException 
     * @throws NoSuchMethodException 
     * @throws IllegalArgumentException 
     * @throws SecurityException 
     */
    public static Object parseByType(Class clazz, String str) throws ParseException, InstantiationException, IllegalAccessException, SecurityException, IllegalArgumentException, NoSuchMethodException, InvocationTargetException{
        Object r = "";
        String clazzName = splitSpace(clazz.getName());
        if (isSimpleType(clazzName)){
        	
        	
            if (StringUtils.contains(TYPE_INTEGER,clazzName)) {
                r = parseInteger(str);
            } else if (StringUtils.contains(TYPE_DATE,clazzName)) {
                r = parseDate(str);
            }
        } else {
            r = parseObject(clazz, str);
        }
        return r;
    }
    
    /** 实现将源类(Map类型)属性拷贝到目标类中
       * @param Map map 
       * @param Object obj
       */
    public static void copyProperties(Map map, Object obj) throws Exception {
        // 获取目标类的属性信息
        BeanInfo targetbean = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = targetbean.getPropertyDescriptors();
        // 对每个目标类的属性查找set方法，并进行处理
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor pro = propertyDescriptors[i];
            Method wm = pro.getWriteMethod();
            if (wm != null) {
                Iterator ite = map.keySet().iterator();
                while (ite.hasNext()) {
                    String key = (String) ite.next();
                    // 判断匹配
                    if (key.toLowerCase().equals(pro.getName().toLowerCase())) {
                        if (!Modifier.isPublic(wm.getDeclaringClass().getModifiers())) {
                            wm.setAccessible(true);
                        }
                        Object value = ((String[]) map.get(key))[0];
                        String pt = splitSpace(pro.getPropertyType().getName());
                        //判断类型是否匹配，不匹配则作强制转换
                        if (!(pt.equals(value.getClass().getName()))) {
                            value = parseByType(pro.getPropertyType(),value.toString());
                        }
                        // 调用目标类对应属性的set方法对该属性进行填充
                        wm.invoke((Object) obj, new Object[] {value});
                        break;
                    }
                }
            }
        }
    }
}