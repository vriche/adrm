
/**
 * Title:
 * Description:
 * Copyright:    Copyright (c) 2002
 * Company:
 * @author
 * @version 3.1
 */
 
//Sorter.java

package com.vriche.adrm.util;


public interface Sorter
{
	 
/**
 * compare two elements of a SortedVector
 * returns: -1 if a < b
 *           0 if a = b
 *           1 if a > b
 */

    public abstract int compare(Object obj, Object obj1);
    
 
}
