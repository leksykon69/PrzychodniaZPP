package pol.frontend;

public class Message {
	private String message;
	private MessageType type;
	private Exception e; 
	
	public Message(String message, MessageType type){
		this.message = message;
		this.type = type;
	}
	
	public Message(String message, MessageType type, Exception e){
		this.message = message;
		this.type = type;
		this.e = e;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public MessageType getType() {
		return type;
	}

	public void setType(MessageType type) {
		this.type = type;
	}

	public Exception getException() {
		return e;
	}

	public void setException(Exception e) {
		this.e = e;
	}
}
