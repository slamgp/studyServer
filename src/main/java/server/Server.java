package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	public void start() {
	    boolean stoped = false;
	    try {
			ServerSocket sc = new ServerSocket(7979);
			System.out.println("[Server] server started!");
		    while (!stoped) {
		    	SocketManager socketManager = new SocketManager(sc.accept());
		    	Thread threadSocketManager = new Thread(socketManager);
		    	threadSocketManager.start();
		    }
		} catch (IOException e) {
			e.printStackTrace();
		}
	}    		
}
