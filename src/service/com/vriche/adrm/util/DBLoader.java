package com.vriche.adrm.util;

import java.io.BufferedReader;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

//import org.apache.derby.tools.ij;


public class DBLoader {
	
	private static Files _fileUtil = new Files();

	private String _databaseType;
	private String _databaseName;
	private String _scriptFile;
	private String _fileName;
	private String _username;
	private String _passwd;

	
	public DBLoader(String databaseType, String databaseName, String scriptFile,String fileName,String username,String passwd) {
		
		try {
			_databaseType = databaseType;
			_databaseName = databaseName;
			_scriptFile = scriptFile;
			_fileName = fileName;
			_username = username;
			_passwd = passwd;


		 if (_databaseType.equals("hypersonic")) {
				_loadHypersonic();
		 }
		 if (_databaseType.equals("mysql")) {
				_loadMysql();
		 }
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void _loadHypersonic() throws Exception {
		
//		System.out.println("HSQL Server _loadHypersonic>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>: " + _databaseName);
		
		Class.forName("org.hsqldb.jdbcDriver");

		// See LEP-2927. Appending ;shutdown=true to the database connection URL
		// guarantees that ${_databaseName}.log is purged.

		Connection con = DriverManager.getConnection("jdbc:hsqldb:" + _databaseName + ";create=true;", "sa", "");
		
//		System.out.println("HSQL Server _loadHypersonic>>>>>>>>>>_fileName>>>>>>>>>>>>>>>>>>>>>>>>>>: " + _fileName);
//		System.out.println("HSQL Server _loadHypersonic>>>>>>>>>>_scriptFile>>>>>>>>>>>>>>>>>>>>>>>>>>: " + _scriptFile);
		

		if (Validator.isNull(_fileName)) {
			_loadHypersonic(con, "../sql/quartz-tables.sql");
		}
		else {
			_loadHypersonic(con, _fileName);
		}

		// Shutdown Hypersonic

		Statement statement = con.createStatement();

		statement.execute("SHUTDOWN COMPACT");

		statement.close();

		con.close();

		// Hypersonic will encode unicode characters twice, this will undo
		// it

		String content = _fileUtil.read(_scriptFile);
		content = StringUtil.replace(content, "\\u005cu", "\\u");
		_fileUtil.write(_scriptFile, content);
	}
	
	
	
	
	
	private void _loadMysql() throws Exception {
		
	
		Class.forName("com.mysql.jdbc.Driver");

		// See LEP-2927. Appending ;shutdown=true to the database connection URL
		// guarantees that ${_databaseName}.log is purged.
		
		System.out.println("mysql Server _loadMysql>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>: " + _databaseName);

		Connection con = DriverManager.getConnection( _databaseName, _username, _passwd);
//		jdbc:mysql://localhost/quartz?useUnicode=true&amp;characterEncoding=gbk
			
//		System.out.println("HSQL Server _loadHypersonic>>>>>>>>>>_fileName>>>>>>>>>>>>>>>>>>>>>>>>>>: " + _fileName);
//		System.out.println("HSQL Server _loadHypersonic>>>>>>>>>>_scriptFile>>>>>>>>>>>>>>>>>>>>>>>>>>: " + _scriptFile);
		
		if (Validator.isNull(_fileName)) {
			_loadHypersonic(con, "../sql/quartz_mysql.sql");
		}
		else {
			_loadHypersonic(con, _fileName);
		}

		con.close();

	}
	
	
	
	
	
	

	private void _loadHypersonic(Connection con, String fileName) throws Exception {

		StringBuffer sb = new StringBuffer();

		BufferedReader br = new BufferedReader(new StringReader(_fileUtil.read(fileName)));

		String line = null;

		while ((line = br.readLine()) != null) {
			if (!line.startsWith("//")) {
				sb.append(line);

				if (line.endsWith(";")) {
					String sql = sb.toString();

					sql =
						StringUtil.replace(
							sql,
							new String[] {
								"\\\"",
								"\\\\",
								"\\n",
								"\\r"
							},
							new String[] {
								"\"",
								"\\",
								"\\u000a",
								"\\u000a"
							});

					sb = new StringBuffer();
					
					System.out.println("mysql Server _loadHypersonic sql>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>: " + sql);

					PreparedStatement ps = con.prepareStatement(sql);

					ps.executeUpdate();

					ps.close();
				}
			}
		}

		br.close();
	}

	
	
}
