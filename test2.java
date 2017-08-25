package book;

import org.json.simple.JSONObject;

public class test2 {
	@SuppressWarnings("unchecked")
	public JSONObject testmthod2(){
		
		JSONObject obj = new JSONObject();
		obj.put("javabook", "100");
		obj.put("phpbook", "200");
		obj.put("javaeebook", "300");
		return obj;
	}
}
