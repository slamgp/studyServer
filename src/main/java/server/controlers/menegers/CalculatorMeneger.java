package server.controlers.menegers;

import java.text.DecimalFormat;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

import server.model.CalculatorResponseCreatot;
import server.model.ResponseCreator;


public class CalculatorMeneger implements RequestManager{
    
	private final String OPERATION = "operation";
	private final String VALUE_SPLITER = "=";
	private final String ADD_OPERATION = "add";
    private final String DIV_OPERATION = "dev";
    private final String SUB_OPERATION = "sub";
    private final String MUL_OPERATION = "mul";
    private final String PARAM_1 = "param1";
    private final String PARAM_2 = "param2";
    private final ResponseCreator responseCreator = new CalculatorResponseCreatot();
    
	public String processing(String[] parametrs) {
		String httpSerponse = "";
		String httmlBody = "";
        
	    if (parametrs[1] != null) {
	        String []requestParametrs = parametrs[1].split("&");
	        httmlBody = httmlBody +((CalculatorResponseCreatot) responseCreator).addCalculateResult(calculate(requestParametrs));
	    }
	    httmlBody = httmlBody + responseCreator.createResponse();
	    httpSerponse = responseCreator.createHttpHeader(httmlBody.getBytes().length) + httmlBody;
		return httpSerponse;
	}

	private String[] calculate(String[] requestParametrs) {
		String [] result = new String[5];
	    String operation = 	requestParametrs[0].substring(requestParametrs[0].indexOf(VALUE_SPLITER)+1);
	    String param1    = 	requestParametrs[1].substring(requestParametrs[1].indexOf(VALUE_SPLITER)+1);
	    String param2    = 	requestParametrs[2].substring(requestParametrs[2].indexOf(VALUE_SPLITER)+1);
	    switch (operation) {
		case ADD_OPERATION:
			result[0] = param1;
			result[1] = "+";
			result[2] = param2;
			result[3] = "=";
			try {
			    result[4] ="" + new DecimalFormat("###.##").format((Float.parseFloat(param1) + Float.parseFloat(param2)));
			} catch (NumberFormatException e) {
				result[4] = "not correct number!";
			}
			break;
		case SUB_OPERATION:
			result[0] = param1;
			result[1] = "-";
			result[2] = param2;
			result[3] = "=";
			try {
			    result[4] ="" + new DecimalFormat("###.##").format((Float.parseFloat(param1) - Float.parseFloat(param2)));
			} catch (NumberFormatException e) {
				result[4] = "not correct number!";
			}
			break;
		case MUL_OPERATION:
			result[0] = param1;
			result[1] = "*";
			result[2] = param2;
			result[3] = "=";
			try {
			    result[4] ="" + new DecimalFormat("###.##").format((Float.parseFloat(param1) * Float.parseFloat(param2)));				
			} catch (NumberFormatException e) {
				result[4] = "not correct number!";
			}
			break;
		case DIV_OPERATION:
			result[0] = param1;
			result[1] = "/";
			result[2] = param2;
			result[3] = "=";
			try {
			    result[4] ="" + new DecimalFormat("###.##").format((Float.parseFloat(param1) / Float.parseFloat(param2)));				
			} catch (NumberFormatException e) {
				result[4] = "not correct number!";
			}
			break;
		default:
			result[0] = param1;
			result[1] = "bed operation";
			result[2] = param2;
			result[3] = "=";
			result[4] ="don't calculate result";	
		}
	    return result;
	}

}
