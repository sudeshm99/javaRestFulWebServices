import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.json.simple.*;


public class connectDB {
	 public Connection conn = null;
	    public JSONObject connect(String name){
	        String url = "jdbc:mysql://localhost:3306/bookDB?useSSL=false";
	        String user = "root";
	        String pass = "1234";
	        int price = 0;
	        String Name = name;
	        String sql = null;
	        JSONObject obj = new JSONObject();
	        try{
	            conn = DriverManager.getConnection(url, user, pass);
	            if(conn != null){
	                System.out.println("Connected to database");
	                sql = "SELECT Price,Name FROM bookPrice;";
		            PreparedStatement st = conn.prepareStatement(sql);
		            //st.setString(1, Name);
		            ResultSet rs = st.executeQuery();
		            while(rs.next()){
		            	price = rs.getInt("Price");
		            	String Price = Integer.toString(price);
		            	Name = rs.getString("Name");
		            	obj.put(Name,Price);
		            }
		            
	            }
	        }catch(Exception ex){
	            System.out.println("Maybe username or password is incorrent");
	            ex.printStackTrace();
	        }
	        return obj;
	}
}
