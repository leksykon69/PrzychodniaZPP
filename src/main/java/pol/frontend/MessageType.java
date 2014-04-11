package pol.frontend;

public enum MessageType {
	INFO,
	SUCCESS,
	WARN,
	ERROR;
	
	public String getBackgroundColor(){
		switch(this){
		case ERROR:
			return "bg-danger";
		case INFO:
			return "bg-info";
		case SUCCESS:
			return "bg-success";
		case WARN:
			return "bg-warning";
		}
		throw new IllegalArgumentException();
	}
	
	public String getIconName(){
		switch(this){
		case ERROR:
			return "remove-signr";
		case INFO:
			return "info-sign";
		case SUCCESS:
			return "ok-sign";
		case WARN:
			return "exclamation-sign";
		}
		throw new IllegalArgumentException();
	}
}
