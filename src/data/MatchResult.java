package data;

public enum MatchResult {
	HOME("1"), DEUCE("2"), AWAY("3");

	private final String id;

	private MatchResult(String id) {
		this.id = id;
	}

	public String getId() {
		return this.id;
	}

}
