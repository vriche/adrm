/****************************************************************************     
 * Created on 2007-11-18                                      *    
 *                                                               			*
 * @author <a href="mailto:hongxilin@yahoo.com.cn">hongxi</a>               *
 *         Updated by hongxi (hongxilin@yahoo.com.cn)                       *
 *                                                                          *
 * @version  Vision:1.0														*
 * 																			*
 ***************************************************************************/
package com.vriche.adrm.util;

import java.io.File;
import java.io.FilenameFilter;

public class FileZipFilter implements FilenameFilter {

    public boolean accept(File dir, String s) { 
        if (s.endsWith(".zip")) 
            return true; 
    return false; 
    }

}
