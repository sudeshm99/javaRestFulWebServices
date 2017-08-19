import org.json.simple.JSONObject;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
public class book {
	
	public static void main(String[] args ){
		
		Client client = ClientBuilder.newClient();//create a client
		
		WebTarget target = client.target("http://localhost:8080/FirstRestWebService/book/phpbook");//target url
		
		System.out.println(
					target.request().get(String.class)
				);
		
	}
}
