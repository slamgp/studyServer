package server.controlers.menegers;

import server.model.DefoultResponseCreatot;
import server.model.ResponseCreator;

public class DefaultManager implements RequestManager{
    private final ResponseCreator responseCreator = new DefoultResponseCreatot();
	public String processing(String[] parametrs) {
			String httpSerponse = null;
			httpSerponse = responseCreator.createResponse();
		    return httpSerponse;
	}
}
