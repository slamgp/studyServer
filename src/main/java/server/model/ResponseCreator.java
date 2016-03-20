package server.model;

import java.time.LocalDateTime;

public abstract class ResponseCreator {
    public String createHttpHeader(int contentLenght) {
    	return  "HTTP/1.1 200 OK\r\n"
    			+ "Date:" + LocalDateTime.now() 
    			+ "\r\nServer: Kozak"
    			+ "\r\nLast-Modified:"
    			+ "\r\nContent-Length: " + contentLenght
    			+ "\r\nContent-Type: text/html\r\n\r\n";
    }

    public String endHtmlFile() {
    	return  "</body>"
    			+ "</html>";
    }
    
    abstract public String processingParametrs(String []str); 
    
    public String createResponse() {
        String responseBody = getMainBody();
        return  responseBody;
    };
    
    protected abstract String getMainBody();
}
