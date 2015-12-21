package cc.eabour.websocket;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.log4j.Logger;

@ServerEndpoint("/chat")
public class WebSocketServer {
	
	private Session session;
	private Logger logger = Logger.getLogger(WebSocketServer.class);
	
	@OnOpen
	public void open(Session session){
		this.session = session;
		logger.info("WebSocket is opening...");
		
		logger.info("Sesson id: " + this.session.getId());
		logger.info("Query string: " + this.session.getQueryString());
		
	}
	
	@OnMessage
	public void onMessage(String message){
		logger.info("Client send message: " + message);
		try {
			this.session.getBasicRemote().sendText("Server message form Websocket server");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@OnClose
	public void onClose(){
		logger.info("Websocket closed");
	}
	

    @OnError
    public void onError(Session session, Throwable t) {
        t.printStackTrace();
    }
}
