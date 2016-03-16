package server.controlers.menegers;

import server.model.CalculatorResponseCreatot;
import server.model.ResponseCreator;
import server.view.CalculatorView;


public class CalculatorMeneger implements RequestManager{
    private final String ADD_OPERATION = "add";
    private final String DIV_OPERATION = "div";
    private final String SUB_OPERATION = "sub";
    private final String MUL_OPERATION = "mul";
    private final ResponseCreator responseCreator = new CalculatorResponseCreatot();
    
	public String processing(String[] parametrs) {
		String httpSerponse = null;
	/*	for(String param: parametrs) {
		    System.out.println("parametrs = " + param);
		}*/
	
	    httpSerponse = responseCreator.createResponse();
		return httpSerponse;
	}
}
