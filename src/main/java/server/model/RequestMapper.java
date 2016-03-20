package server.model;

import java.util.HashMap;

import server.controlers.menegers.CalculatorMeneger;
import server.controlers.menegers.DefaultManager;
import server.controlers.menegers.PresenterMeneger;
import server.controlers.menegers.RequestManager;

public class RequestMapper {
    private final HashMap<String, RequestManager> requestMap;

	public RequestMapper() {
		requestMap = new HashMap<String, RequestManager>();
		requestMap.put("calculator", new CalculatorMeneger());
		requestMap.put("presenter", new PresenterMeneger());
		requestMap.put("default", new DefaultManager());
	}    
	
	public RequestManager getManager(String id) {
		return requestMap.get(id);
	}
}
