package cc.eabour.websocket.client;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import javax.websocket.ContainerProvider;
import javax.websocket.DeploymentException;
import javax.websocket.WebSocketContainer;

public class AppMain {

	public static void main(String[] args) 
			throws DeploymentException, IOException, URISyntaxException, InterruptedException {
		// Auto-generated method stub
		WebSocketContainer conmtainer = ContainerProvider.getWebSocketContainer();
		WebSocketClient client = new WebSocketClient();
		conmtainer.connectToServer(client, 
				new URI("ws://localhost:8080/websocket/chat?query=Picasso"));
		
		int turn = 0;
		while(turn++ < 10){
			client.send("send text: " + (char)(65 + turn));
			Thread.sleep(1000);
		}
		client.close();
	}

}
