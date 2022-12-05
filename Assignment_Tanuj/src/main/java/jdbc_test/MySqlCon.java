package jdbc_test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class MySqlCon {
	Object executeQuery(String query, int val){
		//1 execute
		//2 executeQuery
		//3 executeUpdate
		Object resQuery = null;
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/tanuj","root","admin");  
			Statement stmt=con.createStatement();  
			if(val==1) {
				resQuery = stmt.execute(query);	
				return resQuery;
			}
			else if(val==2) {
				resQuery = stmt.executeQuery(query);
				ResultSetMetaData metadata = ((ResultSet) resQuery).getMetaData();
				int numberOfColumns = metadata.getColumnCount();
				String temp = "";
				while (((ResultSet) resQuery).next()) {
					int i=1;
					while(i<= numberOfColumns) {
						temp += ((ResultSet) resQuery).getString(i);
//						System.out.print(((ResultSet) resQuery).getString(i) + "\t");	
						i++;
					}
					System.out.println();
				}
				return temp;
			}
			else if(val==3) {
				resQuery = stmt.executeUpdate(query);
			}
			else if(val==4) {
				resQuery = stmt.executeQuery(query);
				ResultSetMetaData metadata = ((ResultSet) resQuery).getMetaData();
				int numberOfColumns = metadata.getColumnCount();
				String temp = "";
				while (((ResultSet) resQuery).next()) {
					int i=1;
					while(i<= numberOfColumns) {
						temp += ((ResultSet) resQuery).getString(i);
						System.out.print(((ResultSet) resQuery).getString(i) + "\t");	
						i++;
					}
					System.out.println();
				}
				return "OK";
			}
			else {
				Object temp = con;
				return temp;
			}
			con.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return resQuery ;
	}
	
	public static String valueOf(Object obj) {
	    return (obj == null) ? "null" : obj.toString();
	}
	
}
