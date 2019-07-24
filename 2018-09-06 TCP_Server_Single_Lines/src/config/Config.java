package config;

import response.Protocol;
import response.UpperMirrorResponse;

public class Config {
	
	public static final int PORT = 2000;
	public static final Protocol ONE_THREAD_PROTOCOL = //new MirrorServerResponse();
			new UpperMirrorResponse();
	
}
