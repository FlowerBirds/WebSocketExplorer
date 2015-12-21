package cc.eabour.websocket.client;

import java.io.IOException;

import javax.websocket.ClientEndpoint;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;

import org.apache.log4j.Logger;

import cc.eabour.websocket.WebSocketServer;
import cc.eabour.websocket.client.param.SampleConfigurator;
import cc.eabour.websocket.client.param.SampleDecoder;
import cc.eabour.websocket.client.param.SimpleEncoder;

@ClientEndpoint(
		configurator=SampleConfigurator.class,
		decoders={SampleDecoder.class},
		encoders={SimpleEncoder.class},
		subprotocols={})
public class WebSocketClient {

	private Logger logger = Logger.getLogger(WebSocketServer.class);
	private Session session;
	
	@OnOpen
	public void open(Session session){
		logger.info("Client WebSocket is opening...");
		this.session = session;
	}
	
	@OnMessage
	public void onMessage(String message){
		logger.info("Server send message: " + message);
	}
	
	@OnClose
	public void onClose(){
		logger.info("Websocket closed");
	}
	

    @OnError
    public void onError(Session session, Throwable t) {
        t.printStackTrace();
    }
    
	public void send(Object message){
		this.session.getAsyncRemote().sendObject(message);
	}
	
	public void close() throws IOException{
		if(this.session.isOpen()){
			this.session.close();
		}
	}
}
