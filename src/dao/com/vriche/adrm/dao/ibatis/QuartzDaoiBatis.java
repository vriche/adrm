package com.vriche.adrm.dao.ibatis;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.commons.collections.MapUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.jdbc.core.JdbcTemplate;

import com.vriche.adrm.Constants;
import com.vriche.adrm.dao.QuartzDao;
import com.vriche.adrm.model.TriggerVO;
//import com.vriche.adrm.util.StringUtil;
//import com.vriche.adrm.util.DateUtil;

public class QuartzDaoiBatis  implements QuartzDao {
	
    private static final String ADD_JOBDETAIL_SQL = "insert into QRTZ_INSTALLED_JOBS(JOB_NAME,JOB_GROUP,APP_PATH) values(?,?,?)";
    private static final String DEL_JOBDETAIL_SQL = "delete from QRTZ_INSTALLED_JOBS WHERE JOB_NAME=? AND JOB_GROUP=?";
    private static final String GET_JOBDETAIL_SQL = "select * from QRTZ_INSTALLED_JOBS WHERE APP_PATH=?";
    private static final String GET_TRIGGERS_SQL = "select A.*,B.CRON_EXPRESSION  from QRTZ_TRIGGERS A left outer join QRTZ_CRON_TRIGGERS B on A.TRIGGER_NAME =B.TRIGGER_NAME order by A.START_TIME";
//    private static final String GET_CON_TRIGGERS_SQL = "select TRIGGER_NAME,TRIGGER_GROUP,CRON_EXPRESSION,TIME_ZONE_ID from qrtz_cron_triggers";
    private static final String UPDATE_CRON_EXPRESSION_SQL = "update QRTZ_CRON_TRIGGERS set CRON_EXPRESSION =? WHERE TRIGGER_NAME=?";

    private DataSource dataSource;

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }
    
    
//    private String getCronExpressionFromDB(){
//
//    	   String dbCronExpression = "";
//    	   List rs = getJdbcTemplate().queryForList(GET_CON_TRIGGERS_SQL);
//    	
//    	     while (rs.next()) {
//               String conExpr =  rs.getString("TRIGGER_NAME");
//           } 	   
//
//
//    	     return dbCronExpression;
//    	  }


	public List getQrtzTriggers2() {

		List  results = getJdbcTemplate().queryForList("select * from QRTZ_TRIGGERS order by START_TIME");

		long val = 0;
		String temp = null;
		Iterator it = results.iterator();
		
		while(it.hasNext()){
			Map map = (Map)it.next();
			temp = MapUtils.getString(map, "trigger_name");
			
			if(StringUtils.indexOf(temp, "&") != -1){
				map.put("display_name", StringUtils.substringBefore(temp, "&"));
			}else{
				map.put("display_name", temp);
			}
			
			val = MapUtils.getLong(map, "next_fire_time").longValue();
			if (val > 0) {
				map.put("next_fire_time", DateFormatUtils.format(val, "yyyy-MM-dd HH:mm:ss"));
			}

			val = MapUtils.getLong(map, "prev_fire_time").longValue();
			if (val > 0) {
				map.put("prev_fire_time", DateFormatUtils.format(val, "yyyy-MM-dd HH:mm:ss"));
			}

			val = MapUtils.getLong(map, "start_time").longValue();
			if (val > 0) {
				map.put("start_time", DateFormatUtils.format(val, "yyyy-MM-dd HH:mm:ss"));
			}
			
			val = MapUtils.getLong(map, "end_time").longValue();
			if (val > 0) {
				map.put("end_time", DateFormatUtils.format(val, "yyyy-MM-dd HH:mm:ss"));
			}
			
			map.put("statu",Constants.quartzStatus.get(MapUtils.getString(map, "trigger_state")));
					
			
		}
		
		
		
		return results;
	}
	
//    public List getQrtzTriggers() {
////    	 new BeanPropertyRowMapper(User.class)
//    	String sql = "select * from QRTZ_TRIGGERS order by start_time";
//    	
//		return getJdbcTemplate().queryForList(sql);
//	}
	
	
	
	
    public List  getQrtzTriggers() {
        List  rs = new ArrayList();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rst = null;
        try {
            con = dataSource.getConnection();
            psmt = con.prepareStatement(GET_TRIGGERS_SQL);
            rst = psmt.executeQuery();
            long  v = 0;
            String myDate ="";
            while (rst.next()) {
                TriggerVO vo = new TriggerVO();
                vo.setName(rst.getString("TRIGGER_NAME"));
                vo.setJobName(rst.getString("JOB_NAME"));
                
     
                  v = Long.parseLong(this.getNullValue(rst.getString("NEXT_FIRE_TIME"),"0"));

                
                if(v> 0){
                	myDate = DateFormatUtils.format(v, "yyyy-MM-dd HH:mm:ss");
                	try {
						Date d = this.convertStringToDate("yyyy-MM-dd HH:mm:ss",myDate);
						vo.setNextFireTime(d);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	
                }
                
                  v = Long.parseLong(this.getNullValue(rst.getString("PREV_FIRE_TIME"),"0"));
                if(v> 0){
                	myDate = DateFormatUtils.format(v, "yyyy-MM-dd HH:mm:ss");
                	try {
						Date d = this.convertStringToDate("yyyy-MM-dd HH:mm:ss",myDate);
						vo.setPrevFireTime(d);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	
                }
                
                  v = Long.parseLong(this.getNullValue(rst.getString("START_TIME"),"0"));
                if(v> 0) {
                	myDate = DateFormatUtils.format(v, "yyyy-MM-dd HH:mm:ss");
                	try {
						Date d = this.convertStringToDate("yyyy-MM-dd HH:mm:ss",myDate);
						vo.setStartTime(d);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	
                }
                
                  v = Long.parseLong(this.getNullValue(rst.getString("END_TIME"),"0"));
                if(v> 0) {
                	myDate = DateFormatUtils.format(v, "yyyy-MM-dd HH:mm:ss");
                	try {
						Date d = this.convertStringToDate("yyyy-MM-dd HH:mm:ss",myDate);
						vo.setEndTime(d);
					} catch (ParseException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	
                }

                
//                DateFormatUtils.format(rst.getDate("NEXT_FIRE_TIME"), "yyyy-MM-dd HH:mm:ss"));

                vo.setTriggerGroup(rst.getString("TRIGGER_GROUP"));
                vo.setJobGroup(rst.getString("JOB_GROUP"));
                vo.setVolatility(rst.getString("IS_VOLATILE"));
                vo.setDescription(rst.getString("DESCRIPTION"));
                vo.setPriority(rst.getInt("PRIORITY"));
//                vo(rst.getString("CALENDAR_NAME"));
                vo.setTriggerType(rst.getString("TRIGGER_TYPE"));
                vo.setCronExpression(rst.getString("CRON_EXPRESSION")); 

                vo.setState((String)Constants.quartzStatus.get(rst.getString("TRIGGER_STATE")));
                
                rs.add(vo);
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            closeStatement(psmt);
            closeConnection(con);
            closeResultSet(rst);
        }

        return rs;
    }
    
	
    /**
     * 根据安装目录查找Job是否已经安装
     *
     * @param app_path
     * @return
     */
    public List  getInstalledJobs(String app_path) {
        List  rs = new ArrayList();
        Connection con = null;
        PreparedStatement psmt = null;
        ResultSet rst = null;
        try {
            con = dataSource.getConnection();
            psmt = con.prepareStatement(GET_JOBDETAIL_SQL);
            psmt.setString(1, app_path);
            rst = psmt.executeQuery();
            while (rst.next()) {
                Map  row = new HashMap();
                row.put("JOB_NAME", rst.getString("JOB_NAME"));
                row.put("JOB_GROUP", rst.getString("JOB_GROUP"));
                rs.add(row);
            }
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            closeStatement(psmt);
            closeConnection(con);
            closeResultSet(rst);
        }

        return rs;
    }
	
	
    

	
    /**
     * 安装job,往数据库中插入一条记录
     *
     * @param jobName   job名
     * @param groupName 组名
     * @param app_path  安装目录
     */
    public void installJob(String jobName, String groupName, String app_path) {
        Connection con = null;
        PreparedStatement psmt = null;
        try {
            con = dataSource.getConnection();
            psmt = con.prepareStatement(ADD_JOBDETAIL_SQL);
            psmt.setString(1, jobName);
            psmt.setString(2, groupName);
            psmt.setString(3, app_path);
            psmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            closeStatement(psmt);
            closeConnection(con);
        }
    }
	

	
    /**
     * 卸载job,删除数据库中的记录
     *
     * @param jobName   job名
     * @param groupName 组名
     */
    public void unInstallJob(String jobName, String groupName) {
        Connection con = null;
        PreparedStatement psmt = null;
        try {
            con = dataSource.getConnection();
            psmt = con.prepareStatement(DEL_JOBDETAIL_SQL);
            psmt.setString(1, jobName);
            psmt.setString(2, groupName);
            psmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            closeStatement(psmt);
            closeConnection(con);
        }
    }	
	
    public void updateConExpress(String name,String conExPress) { 
        Connection con = null;
        PreparedStatement psmt = null;
        try {
            con = dataSource.getConnection();
            psmt = con.prepareStatement(UPDATE_CRON_EXPRESSION_SQL); 
            psmt.setString(1,  conExPress);
            psmt.setString(2, name);
            
            System.out.println("tigerName>>>>>>>"+ name);
            System.out.println("conExPress>>>>>>>"+ conExPress);
  		
            psmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        } finally {
            closeStatement(psmt);
            closeConnection(con);
        }
    }	


	
	private JdbcTemplate getJdbcTemplate() {
		return new JdbcTemplate(dataSource);
	}



    /**
     * Cleanup helper method that closes the given <code>Statement</code>
     * while ignoring any errors.
     */
    protected void closeStatement(Statement statement) {
        if (null != statement) {
            try {
                statement.close();
            } catch (SQLException ignore) {
            }
        }
    }


    protected void closeConnection(Connection con) {
        if (null != con) {
            try {
                con.close();
            } catch (SQLException ignore) {
            }
        }
    }

    protected void closeResultSet(ResultSet rs) {
        if (null != rs) {
            try {
                rs.close();
            } catch (SQLException ignore) {
            }
        }
    }

	private  String getNullValue(Object obj,String def) {
		try {
			String i = String.valueOf (obj);
			i = i.equals("null")||i.equals("undefined")||i.equals("")?def:i;
			return i;
		} catch (Exception ex) {
			String j = def;
			return j;
		}
	}
	
	
    private  final Date convertStringToDate(String aMask, String strDate)throws ParseException {
      SimpleDateFormat df = null;
      Date date = null;
      df = new SimpleDateFormat(aMask);

  

      try {
          date = df.parse(strDate);
      } catch (ParseException pe) {
          //log.error("ParseException: " + pe);
          throw new ParseException(pe.getMessage(), pe.getErrorOffset());
      }

      return (date);
  }
}
