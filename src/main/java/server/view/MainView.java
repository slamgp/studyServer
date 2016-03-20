package server.view;

import java.io.IOException;
import java.net.Socket;

public class MainView implements View{
    public void show (String httpResponse, Socket socket) {
    	try {
			socket.getOutputStream().write(httpResponse.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
