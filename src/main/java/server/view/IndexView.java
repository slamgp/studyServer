package server.view;

import java.io.IOException;
import java.net.Socket;

public class IndexView implements View {

	public void show (String httpResponse, Socket socket) {
    	try {
    		System.out.println("goooooooooooo");
			socket.getOutputStream().write(httpResponse.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}
