package com.vriche.adrm.util;
/**
 * Copyright: Copyright (c) 2002-2003
 * Company: JavaResearch(http://www.javaresearch.org)
 * 最后更新日期:2003年3月31日
 * @author Cherami
 */


import java.awt.Point;
import java.io.IOException;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.StringTokenizer;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * String Utility Class This is used to encode passwords programmatically
 *
 * <p>
 * <a h
 * ref="StringUtil.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class StringUtilsv {
	

	private final static Log log = LogFactory.getLog(StringUtil.class);
	
    public static String LINE_SEPARATOR = System.getProperty("line.separator");
	//~ Static fields/initializers =============================================
	/**
	 * 私有构造方法，防止类的实例化，因为工具类不需要实例化。
	 */
	private StringUtilsv() {
	      
	} 
	public static String getNullValue(Object obj,String def) {
		try {
			String i = (String)obj;
			i = i.equals("null")||i.equals("undefined")?def:i;
			return i;
		} catch (Exception ex) {
			String j = def;
			return j;
		}
	}
	/**
	 * 字符串数组中是否包含指定的字符串。
	 * @param strings 字符串数组
	 * @param string 字符串
	 * @param caseSensitive 是否大小写敏感
	 * @return 包含时返回true，否则返回false
	 * @since  0.4
	 */
	public static boolean contains(
		String[] strings,
		String string,
		boolean caseSensitive) {
		
		if (strings == null) return false;
			
		for (int i = 0; i < strings.length; i++) {
			if (caseSensitive == true) {
				if (strings[i].equals(string)) {
					return true;
				}
			} else {
				if (strings[i].equalsIgnoreCase(string)) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * 字符串数组中是否包含指定的字符串。大小写敏感。
	 * @param strings 字符串数组
	 * @param string 字符串
	 * @return 包含时返回true，否则返回false
	 * @since  0.4
	 */
	public static boolean contains(String[] strings, String string) {
		return contains(strings, string, true);
	}

	/**
	 * 不区分大小写判定字符串数组中是否包含指定的字符串。
	 * @param strings 字符串数组
	 * @param string 字符串
	 * @return 包含时返回true，否则返回false
	 * @since  0.4
	 */
	public static boolean containsIgnoreCase(String[] strings, String string) {
		return contains(strings, string, false);
	}

	/**
	 * 将字符串数组使用指定的分隔符合并成一个字符串。
	 * @param array 字符串数组
	 * @param delim 分隔符，为null的时候使用""作为分隔符（即没有分隔符）
	 * @return 合并后的字符串
	 * @since  0.4
	 */
	public static String combineStringArray(String[] array, String delim) {
		int length = array.length - 1;
		if (delim == null) {
			delim = "";
		}
		StringBuffer result = new StringBuffer(length * 8);
		for (int i = 0; i < length; i++) {
			result.append(array[i]);
			result.append(delim);
		}
		result.append(array[length]);
		return result.toString();
	}

	/**
	 * Decode a string using Base64 encoding.
	 *
	 * @param str
	 * @return String
	 */
	public static String decodeString(String str) {
		sun.misc.BASE64Decoder dec = new sun.misc.BASE64Decoder();
		try {
			return new String(dec.decodeBuffer(str));
		} catch (IOException io) {
			throw new RuntimeException(io.getMessage(), io.getCause());
		}
	}

	/**
		 * Encode a string using algorithm specified in web.xml and return the
		 * resulting encrypted password. If exception, the plain credentials
		 * string is returned
		 *
		 * @param password Password or other credentials to use in authenticating
		 *        this username
		 * @param algorithm Algorithm used to do the digest
		 *
		 * @return encypted password based on the algorithm.
		 */
	public static String encodePassword(String password, String algorithm) {
		byte[] unencodedPassword = password.getBytes();

		MessageDigest md = null;

		try {
			// first create an instance, given the provider
			md = MessageDigest.getInstance(algorithm);
		} catch (Exception e) {
			log.error("Exception: " + e);

			return password;
		}

		md.reset();

		// call the update method one or more times
		// (useful when you don't know the size of your data, eg. stream)
		md.update(unencodedPassword);

		// now calculate the hash
		byte[] encodedPassword = md.digest();

		StringBuffer buf = new StringBuffer();

		for (int i = 0; i < encodedPassword.length; i++) {
			if ((encodedPassword[i] & 0xff) < 0x10) {
				buf.append("0");
			}

			buf.append(Long.toString(encodedPassword[i] & 0xff, 16));
		}

		return buf.toString();
	}

	/**
	 * Encode a string using Base64 encoding. Used when storing passwords
	 * as cookies.
	 *
	 * This is weak encoding in that anyone can use the decodeString
	 * routine to reverse the encoding.
	 *
	 * @param str
	 * @return String
	 */
	public static String encodeString(String str) {
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		return encoder.encodeBuffer(str.getBytes()).trim();
	}

	/**
	 * 与 substring 同理，只是把数字变成字符
	 * @param source 字符串
	 * @param begin_tag 提取字符串开始的字符
	 * @param end_tag 提取字符串结束的字符，如果end_tag=null,则可以反回开始字符到结尾
	 * @return 开始和结束字符之间的字符
	 * @since  0.6
	 */
	public static String extract(
		String source,
		String begin_tag,
		String end_tag) {
		int begin = begin_tag != null ? source.indexOf(begin_tag) : 0;
		int len = begin_tag != null ? begin_tag.length() : 0;
		int end =
			end_tag != null
				? source.indexOf(end_tag, begin + len)
				: source.length();
		if (begin == -1) {
			begin = 0;
			len = 0;
		}
		if (end == -1)
			end = source.length();
		return source.substring(begin + len, end);
	}

	/**
	 * 根据转义列表对字符串进行转义。
	 * @param source 待转义的字符串
	 * @param escapeCharMap 转义列表
	 * @return 转义后的字符串
	 * @since  0.6
	 */
	public static String escapeCharacter(
		String source,
		HashMap escapeCharMap) {
		if (source == null || source.length() == 0)
			return source;
		if (escapeCharMap.size() == 0)
			return source;
		StringBuffer sb = new StringBuffer();
		StringCharacterIterator sci = new StringCharacterIterator(source);
		for (char c = sci.first();
			c != StringCharacterIterator.DONE;
			c = sci.next()) {
			String character = String.valueOf(c);
			if (escapeCharMap.containsKey(character))
				character = (String) escapeCharMap.get(character);
			sb.append(character);
		}
		return sb.toString();
	}

	/**
	 * 以指定的字符和长度生成一个该字符的指定长度的字符串。
	 * @param c 指定的字符
	 * @param length 指定的长度
	 * @return 最终生成的字符串
	 * @since  0.6
	 */
	public static String fillString(char c, int length) {
		String ret = "";
		for (int i = 0; i < length; i++) {
			ret += c;
		}
		return ret;
	}

	/**
	 * 格式化   如 n = 12345.6667    formatNumber(n,"###.00") =  12,345.67
	 * @param str  字符
	 * @param format 格式
	 * @return 指定格式字符
	 * @since  0.6
	 */
	public static String formatNumber(String value, String formatStr) {

		// formatStr ="###.00"

		value = value != null ? value : "0";
		value = value != "" ? value : "0";
		value = value != "null" ? value : "0";
		
		if (formatStr == "") return value;


		int dicimalindex = value.indexOf(".");
		int dicimaformat = formatStr.indexOf(".");

		if (dicimaformat == 0)
			return getFloatStr(value, formatStr.length());

		String valueStr_left = extract(value, null, ".");
		String valueStr_right = extract(value, ".", null);

		String formatStr_left = extract(formatStr, null, ".");
		String formatStr_right = extract(formatStr, ".", null);

		if (dicimalindex == -1) {
			valueStr_right = "";
		}

		//格式化
		int valueLen_left = valueStr_left.length();
		int valueLen_right = valueStr_right.length();

		int formatLen_left = formatStr_left.length();
		int formatLen_right = formatStr_right.length();

		//格式化左边的字符
		if (formatLen_left > 0) {
			if (valueLen_left == 0) {
				valueStr_left = "0";
			} else {
				valueStr_left = getFloatStr(valueStr_left, formatLen_left);
			}
		}

		//		格式化右边的字符
		if (formatLen_right > 0) {
			if (valueLen_right == 0) {

				valueStr_right = fillString('0', formatLen_right);

			} else {

				if (valueStr_right.length() > formatStr_right.length()) {
					int v1 =
						Integer.parseInt(
							valueStr_right.substring(0, formatLen_right));
					int v2 =
						Integer.parseInt(
							valueStr_right.substring(
								formatLen_right,
								formatLen_right + 1));

					if (v2 > 4)
						v1++;
					valueStr_right = String.valueOf(v1);
				}

			}

		}

		String rt = valueStr_left + "." + valueStr_right;

		return rt;

	}

	public static String formatNumber(String value) {
		String formatStr = "###.00";
		return formatNumber(value, formatStr);
	}

	public static String formatPercent(String value, String formatStr) {
		//formatStr = ".00";	
		int pointIndex = value.indexOf(".");

		String strLeft = "0";
		String strRight = "0";
//		String formatRight = "";
		String rs = "00%";

		if (pointIndex > -1) {
			if (pointIndex > 0)
				strLeft = extract(value, null, ".");
			if (pointIndex < value.length())
				strRight = extract(value, ".", null);
		}

		//不是小数，或小数点左边的数大于0
		if (Integer.parseInt(strLeft) > 0 || pointIndex == -1) {
			return rs = "100%";
		} else {
			// 小数点后边的位数
			int valueLen_Right = strRight.length();
			// 需要精确的位数
			int formatLen_Right = formatStr.length() - 1;
			// 如果实际的位数小于需要精确的位数，先用零补齐
			if (valueLen_Right - 2 <= formatLen_Right) {
				strRight =
					strRight
						+ fillString('0', formatLen_Right - (valueLen_Right - 2));
			} else {

				int v1 = -1;
				int v2 = -1;

				if (formatLen_Right > 0) {
					v1 =
						Integer.parseInt(
							strRight.substring(2, formatLen_Right + 2));
					v2 =
						Integer.parseInt(
							strRight.substring(
								formatLen_Right + 2,
								formatLen_Right + 3));
					if (v2 > 4)
						v1++;
					strRight = strRight.substring(0, 2) + String.valueOf(v1);
				} else {
					v1 = Integer.parseInt(strRight.substring(1, 2));
					if (v1 > 4)
						v1++;
					strRight = strRight.substring(0, 1) + String.valueOf(v1);
				}
			}

			//根据需要精确度，格式化，标准格式  "xx.xx%"
			String Lstr = strRight.substring(0, 2);
			String Rstr = strRight.substring(2, strRight.length());

			if (formatLen_Right > 0) {
				rs = Lstr + "." + Rstr + "%";
			} else {
				rs = Lstr + "%";
			}

		}

		return rs;
	}

	public static String formatPercent(String value) {

		return formatPercent(value, "");

	}

	public static String formatPercent(
		double up,
		double down,
		String formatStr) {

//		int formatLen_Right = formatStr.length() - 1;

		if (up > down)
			return "100%";

		double rs = up / down;

		return formatPercent(String.valueOf(rs), formatStr);

	}

	//~ Methods ================================================================

	public static String getEncrypt(String s) {
		MD5 md5 = new MD5();
		return md5.getMD5ofStr(s);
		
	}

	/**
	 * 将字符串中的变量使用values数组中的内容进行替换。
	 * 替换的过程是不进行嵌套的，即如果替换的内容中包含变量表达式时不会替换。
	 * @param prefix 变量前缀字符串
	 * @param source 带参数的原字符串
	 * @param values 替换用的字符串数组
	 * @return 替换后的字符串。
	 *         如果前缀为null则使用“%”作为前缀；
	 *         如果source或者values为null或者values的长度为0则返回source；
	 *         如果values的长度大于参数的个数，多余的值将被忽略；
	 *         如果values的长度小于参数的个数，则后面的所有参数都使用最后一个值进行替换。
	 * @since  0.2
	 */
	public static String getReplaceString(
		String prefix,
		String source,
		String[] values) {
		String result = source;
		if (source == null || values == null || values.length < 1) {
			return source;
		}
		if (prefix == null) {
			prefix = "%";
		}

		for (int i = 0; i < values.length; i++) {
			String argument = prefix + Integer.toString(i + 1);
			int index = result.indexOf(argument);
			if (index != -1) {
				String temp = result.substring(0, index);
				if (i < values.length) {
					temp += values[i];
				} else {
					temp += values[values.length - 1];
				}
				temp += result.substring(index + 2);
				result = temp;
			}
		}
		return result;
	}

	/**
	 * 将字符串中的变量（以“%”为前导后接数字）使用values数组中的内容进行替换。
	 * 替换的过程是不进行嵌套的，即如果替换的内容中包含变量表达式时不会替换。
	 * @param source 带参数的原字符串
	 * @param values 替换用的字符串数组
	 * @return 替换后的字符串
	 * @since  0.1
	 */
	public static String getReplaceString(String source, String[] values) {
		return getReplaceString("%", source, values);
	}

	/**
	 * 根据指定 用"," 格式化    如 12345.666    
	 * @param str 待转义的字符串
	 * @param dimlen 需要的精度
	 * @return 指定精度的字符
	 * @since  0.6
	 */
	public static String getFloatStr(String str, int dimlen) {
		int dicimalindex = str.indexOf(".");
		String decimalstr = "";
		if (dicimalindex != -1)
			decimalstr = extract(str, ".", null);
		String intstr = extract(str, null, ".");
		if (intstr.length() < dimlen + 1)
			return str;
		String beginstr = "";
		int thebeginlen = intstr.length() % dimlen;
		beginstr = intstr.substring(0, thebeginlen);
		intstr = intstr.substring(thebeginlen);
		int intstrcount = intstr.length() / dimlen;
		for (int i = 0; i < intstrcount; i++)
			if (beginstr.equals("") || beginstr.equals("-")) {
				beginstr =
					String.valueOf(beginstr)
						+ String.valueOf(intstr.substring(0, dimlen));
				intstr = intstr.substring(dimlen);
			} else {
				beginstr =
					String.valueOf(beginstr)
						+ String.valueOf(
							",".concat(
								String.valueOf(
									String.valueOf(
										intstr.substring(0, dimlen)))));
				intstr = intstr.substring(dimlen);
			}

		if (dicimalindex != -1)
			return String.valueOf(
				String.valueOf(
					(
						new StringBuffer(
							String.valueOf(String.valueOf(beginstr)))).append(
						".").append(
						decimalstr)));
		else
			return beginstr;
	}

	public static String getfloatToString(String value) {
		int index = value.indexOf("E");
		if (index == -1)
			return value;
		int num = Integer.parseInt(value.substring(index + 1, value.length()));
		value = value.substring(0, index);
		index = value.indexOf(".");
		value =
			String.valueOf(value.substring(0, index))
				+ String.valueOf(value.substring(index + 1, value.length()));
		String number = value;
		if (value.length() <= num) {
			for (int i = 0; i < num - value.length(); i++)
				number = String.valueOf(String.valueOf(number)).concat("0");

		} else {
			number =
				String.valueOf(
					String.valueOf(
						(new StringBuffer(String
							.valueOf(
								String.valueOf(number.substring(0, num + 1)))))
							.append(".")
							.append(number.substring(num + 1))
							.append("0")));
		}
		return number;
	}

	/**
	 * 根据指定的位数。返回需要精确的字符
	 * @param str 待转义的字符串
	 * @param dimlen 需要的精度
	 * @return 指定精度的字符
	 * @since  0.6
	 */

	public static String getCharString(int preint) //将数字转换为ABCD的ACCLE 字母
	{
		int theint = preint + 64;
		String thechar = "";
		if (theint > 90) {
			int tempint = theint - 90;
			int modint = tempint % 26;
			int scaleint = tempint / 26;
			if (modint != 0)
				scaleint++;
			char thechar1 = (char) (scaleint + 64);
			char thechar2 = (char) (theint - scaleint * 26);
			thechar =
				String.valueOf(
					String.valueOf(
						(new StringBuffer("")).append(thechar1).append(
							"").append(
							thechar2)));
		} else {
			thechar = "".concat(String.valueOf(String.valueOf((char) theint)));
		}
		return thechar;
	}

	/**
	 * 得到字符串的字节长度
	 * @param source 字符串
	 * @return 字符串的字节长度
	 * @since  0.6
	 */
	public static int getByteLength(String source) {
		int len = 0;
		for (int i = 0; i < source.length(); i++) {
			char c = source.charAt(i);
			int highByte = c >>> 8;
			len += highByte == 0 ? 1 : 2;
		}
		return len;
	}

	/**
	 *  字符转换成数字类型  int Float Double
	 * @param source 字符串
	 * @return 字符串的字节长度
	 * @since  0.6
	 */
	public static int getIntValue(String v) {
		return getIntValue(v, -1);
	}

	public static int getIntValue(String v, int def) {
		try {
			int i = Integer.parseInt(v);
			return i;
		} catch (Exception ex) {
			int j = def;
			return j;
		}
	}
	public static float getFloatValue(String v) {
		return getFloatValue(v, -1F);
	}

	public static float getFloatValue(String v, float def) {
		try {
			float f = Float.parseFloat(v);
			return f;
		} catch (Exception ex) {
			float f1 = def;
			return f1;
		}
	}

	public static double getDoubleValue(String v) {
		return getDoubleValue(v, -1D);
	}

	public static double getDoubleValue(String v, double def) {
		try {
			double d = Double.parseDouble(v);
			return d;
		} catch (Exception ex) {
			double d1 = def;
			return d1;
		}
	}
  
	public static void quickSort(Object a[], Sorter s) {
		
		Stack sf = new Stack();
		Point p = new Point(0, a.length - 1);
		int m = a.length;
		do {
			while (p.y > p.x) {
				Object v = a[p.y];
				int i = p.x - 1;
				int j = p.y;
				do {
					if (s != null) {
						while (++i < m && s.compare(a[i], v) < 0);
						while (--j >= 0 && s.compare(a[j], v) > 0);
					} else {
						String vs;
						for (vs = v.toString();
							++i < m && a[i].toString().compareTo(vs) < 0;
							);
						while (--j >= 0 && a[j].toString().compareTo(vs) > 0);
					}
					if (i >= j)
						break;
					swap(a, i, j);
				}
				while (true);
				swap(a, i, p.y);
				int sl;
				int sr;
				if ((sl = i - p.x) > (sr = p.y - i)) {
					if (sl > 1)
						sf.push(new Point(p.x, i - 1));
					p.x = i + 1;
				} else {
					if (sr > 1)
						sf.push(new Point(i + 1, p.y));
					p.y = i - 1;
				}
			}
			if (!sf.empty())
				p = (Point) sf.pop();
			else
				return;
		}
		while (true);
	}

	/**
		 * 把NULL 类型转换成空字符串。
		 */
	public static String null2String(String s) {
		return s != null ? s : "";
	}

	/**
	 * 循环打印字符串数组。
	 * 字符串数组的各元素间以指定字符分隔，如果字符串中已经包含指定字符则在字符串的两端加上双引号。
	 * @param strings 字符串数组
	 * @param delim 分隔符
	 * @param out 打印到的输出流
	 * @since  0.4
	 */
	public static void printStrings(
		String[] strings,
		String delim,
		OutputStream out) {
		try {
			if (strings != null) {
				int length = strings.length - 1;
				for (int i = 0; i < length; i++) {
					if (strings[i] != null) {
						if (strings[i].indexOf(delim) > -1) {
							out.write(
								("\"" + strings[i] + "\"" + delim).getBytes());
						} else {
							out.write((strings[i] + delim).getBytes());
						}
					} else {
						out.write("null".getBytes());
					}
				}
				if (strings[length] != null) {
					if (strings[length].indexOf(delim) > -1) {
						out.write(("\"" + strings[length] + "\"").getBytes());
					} else {
						out.write(strings[length].getBytes());
					}
				} else {
					out.write("null".getBytes());
				}
			} else {
				out.write("null".getBytes());
			}
			out.write(LINE_SEPARATOR.getBytes());
		} catch (IOException e) {

		}
	}
	
	


	/**
	 * 循环打印字符串数组到标准输出。
	 * 字符串数组的各元素间以指定字符分隔，如果字符串中已经包含指定字符则在字符串的两端加上双引号。
	 * @param strings 字符串数组
	 * @param delim 分隔符
	 * @since  0.4
	 */
	public static void printStrings(String[] strings, String delim) {
		printStrings(strings, delim, System.out);
	}

	/**
	 * 循环打印字符串数组。
	 * 字符串数组的各元素间以逗号分隔，如果字符串中已经包含逗号则在字符串的两端加上双引号。
	 * @param strings 字符串数组
	 * @param out 打印到的输出流
	 * @since  0.2
	 */
	public static void printStrings(String[] strings, OutputStream out) {
		printStrings(strings, ",", out);
	}

	/**
	 * 循环打印字符串数组到系统标准输出流System.out。
	 * 字符串数组的各元素间以逗号分隔，如果字符串中已经包含逗号则在字符串的两端加上双引号。
	 * @param strings 字符串数组
	 * @since  0.2
	 */
	public static void printStrings(String[] strings) {
		printStrings(strings, ",", System.out);
	}

	/**
		 * 将明文转换为密文
		 *
		 * This is weak encoding in that anyone can use the decodeString
		 * routine to reverse the encoding.
		 * @param s 原文
		 * @return String
		 */

	public static String replace(
		String value,
		String key,
		String replaceValue) {
		if (value == null || key == null || replaceValue == null)
			return value;
		int pos = value.indexOf(key);
		if (pos < 0)
			return value;
		int length = value.length();
		int start = pos;
		int end = pos + key.length();
		if (length == key.length())
			value = replaceValue;
		else if (end == length)
			value = value.substring(0, start) + replaceValue;
		else
			value =
				value.substring(0, start)
					+ replaceValue
					+ replace(value.substring(end), key, replaceValue);
		return value;
	}

	public static String replaceChar(String s, char c1, char c2) {
		if (s == null)
			return s;
		char buf[] = s.toCharArray();
		for (int i = 0; i < buf.length; i++)
			if (buf[i] == c1)
				buf[i] = c2;

		return String.valueOf(buf);
	}

	/**
	 * 删除字符串中的，的指定字符
	 *
	 * @param source
	 * @param key
	 * @return String
	 */

	public static String remove(String source, String key) {
		int i = source.indexOf(key);
		int l = key.length();
		if (i != -1)
			return String.valueOf(source.substring(0, i))
				+ String.valueOf(source.substring(i + l));
		else
			return source;
	}

	public static void swap(Object a[], int i, int j) {
		Object t = a[i];
		a[i] = a[j];
		a[j] = t;
	}

	/**
		   * 此方法将给出的字符串source使用delim划分为单词数组。
		   * @param source 需要进行划分的原字符串
		   * @param delim 单词的分隔字符串
		   * @return 划分以后的数组，如果source为null的时候返回以source为唯一元素的数组，
		   *         如果delim为null则使用逗号作为分隔字符串。
		   * @since  0.1
		   */
	public static String[] split(String source, String delim) {
		String[] wordLists;
		if (source == null) {
			wordLists = new String[1];
			wordLists[0] = source;
			return wordLists;
		}
		if (delim == null) {
			delim = ",";
		}
		StringTokenizer st = new StringTokenizer(source, delim);
		int total = st.countTokens();
		wordLists = new String[total];
		for (int i = 0; i < total; i++) {
			wordLists[i] = st.nextToken();
		}
		return wordLists;
	}

	/**
	 * 此方法将给出的字符串source使用delim划分为单词数组。
	 * @param source 需要进行划分的原字符串
	 * @param delim 单词的分隔字符
	 * @return 划分以后的数组，如果source为null的时候返回以source为唯一元素的数组。
	 * @since  0.2
	 */
	public static String[] split(String source, char delim) {
		return split(source, String.valueOf(delim));
	}

	/**
	 * 此方法将给出的字符串source使用逗号划分为单词数组。
	 * @param source 需要进行划分的原字符串
	 * @return 划分以后的数组，如果source为null的时候返回以source为唯一元素的数组。
	 * @since  0.1
	 */
	public static String[] split(String source) {
		return split(source, ",");
	}

	/**
		 * 去除左边多余的空格。
		 * @param value 待去左边空格的字符串
		 * @return 去掉左边空格后的字符串
		 * @since  0.6
		 */
	public static String trimLeft(String value) {
		String result = value;
		if (result == null)
			return result;
		char ch[] = result.toCharArray();
		int index = -1;
		for (int i = 0; i < ch.length; i++) {
			if (Character.isWhitespace(ch[i])) {
				index = i;
			} else {
				break;
			}
		}
		if (index != -1) {
			result = result.substring(index + 1);
		}
		return result;
	}

	/**
	 * 去除右边多余的空格。
	 * @param value 待去右边空格的字符串
	 * @return 去掉右边空格后的字符串
	 * @since  0.6
	 */
	public static String trimRight(String value) {
		String result = value;
		if (result == null)
			return result;
		char ch[] = result.toCharArray();
		int endIndex = -1;
		for (int i = ch.length - 1; i > -1; i--) {
			if (Character.isWhitespace(ch[i])) {
				endIndex = i;
			} else {
				break;
			}
		}
		if (endIndex != -1) {
			result = result.substring(0, endIndex);
		}
		return result;
	}

	public static ArrayList tokenizerString(String str, String dim) {
		return tokenizerString(str, dim, false);

	}

	public static ArrayList tokenizerString(
		String str,
		String dim,
		boolean returndim) {
		str = null2String(str);
		dim = null2String(dim);
		ArrayList strlist = new ArrayList();
		for (StringTokenizer strtoken =
			new StringTokenizer(str, dim, returndim);
			strtoken.hasMoreTokens();
			strlist.add(strtoken.nextToken()));
		return strlist;
	}
	
	
	public static void printMap(Map map){
		
		    System.out.println("StringUtilsv >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>printMap>>>>>>>>>>>>>>>>start>>>>>>> ");

			Iterator   it   =   map.keySet().iterator();

			while   (it.hasNext()){
				Object   key   =   it.next()   ;
				Object   value   =  map.get(key);
				System.out.println("key="+ key+"  value="+value);
			} 
			
			System.out.println("StringUtilsv >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>printMap>>>>>>>>>>>>>>>>end>>>>>>> ");		
 
	}
	

	public static List singleElement(List l) {
	    	List ls = new ArrayList();
	    	for(int i = 0; i < l.size(); i++) {
				Object o = l.get(i);
				if (!ls.contains(o)) {
					ls.add(o);
				}else{
					ls.remove(ls.indexOf(o));
					ls.add(o);
				}
			}
		return ls;
	}
	
	
	public static boolean ByForLoop(String[] arr, String targetValue) {
		for (String s : arr) {
			if (s.equals(targetValue))
				return true;
		}
		return false;
	}

	public static boolean ByArraysBinarySearch(String[] arr, String targetValue) {
		int a = Arrays.binarySearch(arr, targetValue);
		if (a > 0)
			return true;
		else
			return false;
	}
	
	 public static boolean ByList(String[] arr, String targetValue) {
		  return Arrays.asList(arr).contains(targetValue);
	 }
	 
	 
//	 public static void main(String[] args) {
//	        int arr[] = { 49, 38, 65, 97, 76, 13, 27, 49 };
//	        int len = 8;
//	        int i;
//	        System.out.printf("before sort\n");
//	        for (i = 0; i < len; i++)
//	            System.out.printf("%d  ", arr[i]);
//	        System.out.printf("\n");
//	 
//	        QuickSort(arr, 0, len - 1);
//	 
//	        System.out.printf("after sorted\n");
//	        for (i = 0; i < len; i++)
//	            System.out.printf("%d  ", arr[i]);
//	    }
	 public static void QuickSort(int e[], int first, int end) {
	        int i = first, j = end, temp = e[first];
	        while (i < j) {
	            while (i < j && e[j] >= temp)
	                j--;
	            e[i] = e[j];
	            while (i < j && e[i] <= temp)
	                i++;
	            e[j] = e[i];
	        }
	        e[i] = temp;
	        if (first < i - 1)
	            QuickSort(e, first, i - 1);
	        if (end > i + 1)
	            QuickSort(e, i + 1, end);
	    }
	 
}
