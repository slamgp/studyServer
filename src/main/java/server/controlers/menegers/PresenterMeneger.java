package server.controlers.menegers;

import server.model.PresenterResponseCreator;
import server.model.ResponseCreator;

public class PresenterMeneger implements RequestManager{
    private final ResponseCreator responseCreator = new PresenterResponseCreator();
    
	
	@Override
	public String processing(String[] parametrs) {
		String httpSerponse = "";
		String httmlBody = "";
        
	    if (parametrs[1] != null) {
	    	int index = parametrs[1].indexOf(RequestManager.VALUE_SPLITER);
	    	if (index >= 0) {
	            String []requestParametrs = {parametrs[1].substring(index + 1)};
	            httmlBody = httmlBody + responseCreator.processingParametrs(requestParametrs);
	    	}
	    }
	    
	    httmlBody = httmlBody + responseCreator.createResponse();
	    httpSerponse = responseCreator.createHttpHeader(httmlBody.getBytes().length) + httmlBody;
		return httpSerponse;
	}

}
