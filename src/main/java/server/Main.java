package server;

import server.model.ResourcesReader;

public class Main {

	public static void main(String[] args) {
        Server studyServer = new Server();
        studyServer.start();
	//	ResourcesReader rr = new ResourcesReader();
	//	System.out.println("content = " +  rr.getContent("file2.txt"));
	}
}
