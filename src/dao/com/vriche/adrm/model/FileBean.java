package com.vriche.adrm.model;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: SongJiao
 * Date: 2010-1-10
 * Time: 16:59:01
 * To change this template use File | Settings | File Templates.
 */
public class FileBean {
    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public Date getLastmodified() {
        return lastmodified;
    }

    public void setLastmodified(Date lastmodified) {
        this.lastmodified = lastmodified;
    }

    private String filename;//目录�?
    private Date lastmodified;   //�?后一次修改的时间

}
