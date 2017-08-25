package book;



import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam; 	
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.json.simple.JSONObject;

//import dbconnection.connectDB;
//
//import java.sql.Connection;

//annoations
@Path("/book") //for url
public class Book {
	

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{name}/")
	public JSONObject  sayHelloXML(@PathParam("name") String name){
		connectDB data = new connectDB();
		JSONObject dataObj = data.connect(name);
		return dataObj;
		
	 	   
	}
	
}
