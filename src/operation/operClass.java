package operation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import bean.demoBean;



public class operClass {

	
	// JDBC driver name and database URL
			static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";  
			   static final String DB_URL = "jdbc:mysql://localhost/demoKesav";

			   //  Database credentials
			   static final String USER = "root";
			   static final String PASS = "admin";
			   
			   
	   
	   public Connection getConnection(){
	    	Connection conn = null;
	    	try{
	    	//STEP 2: Register JDBC driver
		      Class.forName(JDBC_DRIVER);

		      //STEP 3: Open a connection
		      System.out.println("Connecting to database...");
		      conn = DriverManager.getConnection(DB_URL,USER,PASS);
	    	}catch(Exception e){
	    		e.printStackTrace();
	    	}
	    	
			return conn;
	    	
	    }  
			   
			   
			   
	public boolean insert(demoBean bean) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement statement=null;
		boolean flag= false;
		try{
			conn=getConnection();
			
			  String sql = "INSERT INTO demo(name,add1) VALUES(?,?)";
			  
			  statement = conn.prepareStatement(sql);
			  statement.setString(1, bean.getName());
			  statement.setString(2, bean.getAdd());
			  
			  statement.execute();
			  
			  flag= true;
			  
			  
			  
			  
			
		}catch(Exception e){
			flag = false;
			e.printStackTrace();
			
		}finally{
			try {
				statement.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		return flag;
	}



	public ArrayList<demoBean> getDemo() {
		// TODO Auto-generated method stub
		Statement stmt=null;
		Connection conn=null;
		ResultSet rs=null;
		ArrayList<demoBean> al=new ArrayList<demoBean>();
		
		try{
			conn=getConnection();
			stmt = conn.createStatement();
			
			 String sql = "SELECT * FROM demo";
		     rs = stmt.executeQuery(sql);
		     
		     demoBean bean= null;
		     while(rs.next()){
		    	 bean = new demoBean();
		    	 
		    	 bean.setNo(rs.getInt("no"));
		    	 bean.setName(rs.getString("name"));
		    	 bean.setAdd(rs.getString("add1"));
		    	 
		    	 al.add(bean);
		    	 
		     }
		     
		     
		     
			
		}catch(Exception e){
			
			e.printStackTrace();
			
		}finally{
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
		
		return al;
	}
	
	
	
	

}
