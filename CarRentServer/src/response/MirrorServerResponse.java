package response;

public class MirrorServerResponse implements Protocol{

	@Override
	public String getResponse(String request) {
		return (new StringBuilder(request)).reverse().toString();
	}
}
