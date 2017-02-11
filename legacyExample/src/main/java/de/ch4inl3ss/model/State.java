package de.ch4inl3ss.model;

public enum State {

	COMPLEX("complex"),

	REMOTE("remote"),

	DATABASE("database");

	private String state;

	State(String state) {
		this.state = state;
	}

	public String getState() {
		return state;
	}
}
