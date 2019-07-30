package response;

public class UpperMirrorResponse implements Protocol {

	@Override
	public String getResponse(String request) {
		return request.toUpperCase();
	}

}
