package cc.eabour.websocket.client.param;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;

public class SampleDecoder implements Decoder.Text<String>{

	public void init(EndpointConfig paramEndpointConfig) {
		// Auto-generated method stub
	}

	public void destroy() {
		// Auto-generated method stub
	}

	public String decode(String paramString) throws DecodeException {
		// Auto-generated method stub
		return "MESS:" + paramString.toLowerCase();
	}

	public boolean willDecode(String paramString) {
		// Auto-generated method stub
		return false;
	}

}
