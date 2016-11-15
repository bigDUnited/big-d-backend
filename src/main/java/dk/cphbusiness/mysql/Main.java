package dk.cphbusiness.mysql;

public class Main {  
	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String MYSQL_URL = "jdbc:mysql://138.68.86.0:3306/javaTestDB?user=root&password=russiandick";
	
	public static void main(String[] args) throws Exception {
		MySQLJava dao = new MySQLJava(MYSQL_DRIVER,MYSQL_URL);
		dao.readData();
	}
}
