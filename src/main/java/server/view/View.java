package server.view;

import java.net.Socket;

public interface View {
    public void show(String httpResponse, Socket socket);
}
