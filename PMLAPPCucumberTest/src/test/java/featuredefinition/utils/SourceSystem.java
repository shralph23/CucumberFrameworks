package featuredefinition.utils;

public enum SourceSystem {
	LCLA("LCLA"), LQA("LQA");
	private final String sourceSystem;

	/**
	 * @param text
	 */
	private SourceSystem(final String sourceSystem) {
		this.sourceSystem = sourceSystem;
	}

	/**
	 * Gets the string representation of the element
	 *
	 * @return String type of the Event status
	 */
	@Override
	public String toString() {
		return sourceSystem;
	}

	public static boolean contains(String sourceSystem) {
		for (SourceSystem c : SourceSystem.values()) {
			if (c.toString().equals(sourceSystem)) {
				return true;
			}
		}
		return false;
	}
}
