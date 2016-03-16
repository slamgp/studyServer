package server.model;

import java.sql.Date;
import java.time.LocalDateTime;

public abstract class ResponseCreator {
    protected String createHttpHeader(int contentLenght) {
    	return  "HTTP/1.1 200 OK\r\n"
    			+ "Date:" + LocalDateTime.now() 
    			+ "\r\nServer: Kozak"
    			+ "\r\nLast-Modified:"
    			+ "\r\nContent-Length: " + contentLenght
    			+ "\r\nContent-Type: text/html\r\n\r\n";
    }
    abstract public String createResponse();
}
