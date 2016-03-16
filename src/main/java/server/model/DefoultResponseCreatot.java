package server.model;


public class DefoultResponseCreatot extends ResponseCreator{
	@Override
	public String createResponse() {
        String responseBody = getMainCalculatorBody();
        return createHttpHeader(responseBody.getBytes().length) + responseBody;

	}

	private String getMainCalculatorBody() {
		return  "<html><head><title>KOZAK</title></head>"
        		+ "<body>"
        		+ "<h1>HELLO I AM KOZAK SERVER</h1>"
        		+ " <body></html>"; 
	} 
}
