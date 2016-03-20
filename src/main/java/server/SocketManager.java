package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

import server.controlers.RequestController;

public class SocketManager implements Runnable{
	private Socket socket;
	
	public SocketManager(Socket socket) {
		this.socket = socket;
	}
	
	public void run() {
		acceptRequest();		
	}

	private void acceptRequest() {
	   System.out.println("[Server] new connection: " + socket.getInetAddress());
	   try {  	  
		   RequestController requestController = new RequestController();
	       BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	       String request; 
	       while ((request = br.readLine()) != null) {
			   requestController.parseRequest(request, socket);
		   } 
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
