package server.controlers;

import java.net.Socket;
import java.util.HashMap;

import server.controlers.menegers.DefoultManager;
import server.controlers.menegers.RequestManager;
import server.model.RequestMapper;
import server.view.CalculatorView;

public class RequestController {
	private final String  GET_REQUEST = "GET";
	private final String  STARTING_PARAMETRS_SYMBOL = "?";
    private final CalculatorView calculatorView = new CalculatorView();
    private final DefoultManager defoultMennager = new DefoultManager();
    
    public void parseRequest(String request, Socket socket) {
    	RequestMapper requestMaper = new RequestMapper();
        if (request.indexOf(GET_REQUEST) >= 0) {
        	String url = getUrl(request); 
        	String [] parametrs = parseUrl(url);
        	RequestManager currentManager = requestMaper.getManager(parametrs[0]);
        	String result = "";
        	if (currentManager != null) {
        		result = currentManager.processing(parametrs);
        	} else {
        		result = defoultMennager.processing(parametrs);
        	}
    		if (result != null) {
    			calculatorView.show(result, socket);
    		}
        }
    }

	private String[] parseUrl(String url) {
		String [] parametrs = new String [2];
		int idStartParametrs = url.indexOf(STARTING_PARAMETRS_SYMBOL);
		if (idStartParametrs >= 0) {
			parametrs = new String [2];
		    parametrs[0] = url.substring(0, idStartParametrs);
		    parametrs[1] = url.substring(idStartParametrs + 1);
		} else {
			parametrs[0] = url;
		}
		return parametrs;
	}

	private String getUrl(String request) {
    	int startIndex = GET_REQUEST.length() + 1;
        String withoutGet = request.substring(startIndex).trim().substring(1);
        int idSpace = withoutGet.indexOf(" ");
		return withoutGet.substring(0, idSpace);
	}
}
