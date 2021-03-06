package pol.frontend;

public enum WindowWidth {
	SHORT, MEDIUM, LONG;

	public String getMinWindowWidth() {
		switch (this) {
		case LONG:
			return "1220px";
		case MEDIUM:
			return "820px";
		case SHORT:
			return "440px";
		default:
			return "0";
		}
	}

	public String getContentWidth() {
		switch (this) {
		case LONG:
			return "1160px";
		case MEDIUM:
			return "800px";
		case SHORT:
			return "420px";
		default:
			return "0";
		}
	}
}
