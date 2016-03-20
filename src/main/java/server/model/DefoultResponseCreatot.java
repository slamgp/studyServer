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
        		+ "<h1> <center> HELLO    I     AM      KOZAK      SERVER </center></h1>"
        		+ "<p><h3> My options: <h3></p>"
        		+ "<li><h4> <a href = calculator> simple calculator </a> </h4></li>"
        		+ "<li><h4> <a href = presenter> file presenter  </h4></li>"
        		+ " <body></html>"; 
	}

	@Override
	public String processingParametrs(String[] str) {
		return null;
	}

	@Override
	protected String getMainBody() {
		return null;
	} 
}
