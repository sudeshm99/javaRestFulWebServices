package book;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.json.simple.*;


public class connectDB {
	 public Connection conn = null;
	    @SuppressWarnings("unchecked")
		public JSONObject connect(String category){
	    	 try {
	             Class.forName("com.mysql.jdbc.Driver");
	         } 
	         catch (ClassNotFoundException ex) {
	             System.out.println("DBConnection class :"+ex);
	         }
	    	
	        String url = "jdbc:mysql://localhost:3306/bookDB?useSSL=false";
	        String user = "root";
	        String pass = "1234";
	        String Category = category;
	        //int Price = price;
	        String Name = null;
	        String sql = null;
	        JSONObject obj = new JSONObject();
	        try{
	            conn = DriverManager.getConnection(url, user, pass);
	            if(conn != null){
	                sql ="SELECT Name FROM bookPrice WHERE Category=?";
		            PreparedStatement st = conn.prepareStatement(sql);
		            st.setString(1, Category);
		            ResultSet rs = st.executeQuery();
		            while(rs.next()){
//		            	price = rs.getInt("Price");
//		            	String Price = Integer.toString(price);
		            	Name = rs.getString("Name");
		            	obj.put(Name,Category);
		            }
		            
	            }
	        }catch(Exception ex){
	            System.out.println("Error");
	            ex.printStackTrace();
	        }
	        return obj;
	}
}
