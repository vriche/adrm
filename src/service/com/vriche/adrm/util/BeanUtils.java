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
     * �õ��ո�֮����ַ�
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
     * �ж��Ƿ��Ǽ���������
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
     * ��String����ת��ΪInteger
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
     * ��String����ת��ΪDate
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
     * ת�������û�����Ķ��󣩡����ö����Id��
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
     * �������ͽ���ת��
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
    
    /** ʵ�ֽ�Դ��(Map����)���Կ�����Ŀ������
       * @param Map map 
       * @param Object obj
       */
    public static void copyProperties(Map map, Object obj) throws Exception {
        // ��ȡĿ�����������Ϣ
        BeanInfo targetbean = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = targetbean.getPropertyDescriptors();
        // ��ÿ��Ŀ��������Բ���set�����������д���
        for (int i = 0; i < propertyDescriptors.length; i++) {
            PropertyDescriptor pro = propertyDescriptors[i];
            Method wm = pro.getWriteMethod();
            if (wm != null) {
                Iterator ite = map.keySet().iterator();
                while (ite.hasNext()) {
                    String key = (String) ite.next();
                    // �ж�ƥ��
                    if (key.toLowerCase().equals(pro.getName().toLowerCase())) {
                        if (!Modifier.isPublic(wm.getDeclaringClass().getModifiers())) {
                            wm.setAccessible(true);
                        }
                        Object value = ((String[]) map.get(key))[0];
                        String pt = splitSpace(pro.getPropertyType().getName());
                        //�ж������Ƿ�ƥ�䣬��ƥ������ǿ��ת��
                        if (!(pt.equals(value.getClass().getName()))) {
                            value = parseByType(pro.getPropertyType(),value.toString());
                        }
                        // ����Ŀ�����Ӧ���Ե�set�����Ը����Խ������
                        wm.invoke((Object) obj, new Object[] {value});
                        break;
                    }
                }
            }
        }
    }
}