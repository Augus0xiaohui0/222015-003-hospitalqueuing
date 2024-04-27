package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MsSQLConnBean {

	private String driver = "com.mysql.cj.jdbc.Driver"; // MySQL 8.0 以上版本需要使用 com.mysql.cj.jdbc.Driver
	private String url = "jdbc:mysql://localhost:3306/"; // 修改为你的 MySQL 数据库连接 URL
	private String database = "hospital";
	private String userName = "root"; // 修改为你的 MySQL 数据库用户名
	private String password = "123456"; // 修改为你的 MySQL 数据库密码
	private Connection connection = null;


	public MsSQLConnBean(){

	}
	public Connection getConnection()
	{
		try{
			Class.forName(driver);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection=DriverManager.getConnection(url+database,userName,password);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(connection!=null)
			return connection;
		else{
			System.out.println("connection is not correct");
			return null;
		}
	}
	
	public void closeConnection()
	{
		try{
			if(connection!=null){
					connection.close();
			}
			connection=null;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
