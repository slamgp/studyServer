package server.model;


public class CalculatorResponseCreatot extends ResponseCreator{
	@Override
	public String createResponse() {
        String responseBody = getMainCalculatorBody();
        return createHttpHeader(responseBody.getBytes().length) + responseBody;

	}

	private String getMainCalculatorBody() {
		return  "<html><head><title>KOZAK:CALCULATOR</title></head>"
        		+ "<body>"
        		+ "<h1>Available operations</h1>"
        		+ "<p>add - add operands</p>"
        		+ "<p>sub - subtraction operands</p>"
        		+ "<p>mul - multiply  operands</p>"
        		+ "<p>dev - devide operands</p>"
        		+ "<h1>Operation format</h1>"
        		+ "<p>/calculator?operation=add&param=10&param=2</p>"
        		+ " <body></html>"; 
	} 
}
