package server.model;

import java.util.HashMap;

import server.controlers.menegers.CalculatorMeneger;
import server.controlers.menegers.RequestManager;

public class RequestMapper {
    private final HashMap<String, RequestManager> requestMap;

	public RequestMapper() {
		requestMap = new HashMap<String, RequestManager>();
		requestMap.put("calculator", new CalculatorMeneger());
	}    
	
	public RequestManager getManager(String id) {
		return requestMap.get(id);
	}
}
