package cc.eabour.websocket.client.param;

import javax.websocket.EncodeException;
import javax.websocket.EndpointConfig;

public class SimpleEncoder implements javax.websocket.Encoder.Text<String> {

	public void init(EndpointConfig paramEndpointConfig) {
		//Auto-generated method stub
		System.out.println("Encoder init: " + paramEndpointConfig.getUserProperties());
	}

	public void destroy() {
		//Auto-generated method stub
	}

	public String encode(String paramT) throws EncodeException {
		//Auto-generated method stub
		System.out.println("encode: " + paramT);
		return "mess:" + paramT.toUpperCase();
	}

}
