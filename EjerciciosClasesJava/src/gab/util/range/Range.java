package gab.util.range;

public class Range <T extends Number> {

	T min;
	T max;

	boolean minInclusive;
	boolean maxInclusive;

	public Range(T min, T max) {
		this.min = min;
		this.max = max;
	}

	public Range(T min, T max, boolean minInclusive, boolean maxInclusive) {
		this.min = min;
		this.max = max;
		this.minInclusive = minInclusive;
		this.maxInclusive = maxInclusive;
	}

	public boolean Contains(T num) {
		boolean isAboveMin = 
		minInclusive && num.doubleValue() >= min.doubleValue() || 
		!minInclusive && num.doubleValue() > min.doubleValue();

		boolean isBelowMax =
		maxInclusive && num.doubleValue() <= max.doubleValue() || 
		!maxInclusive && num.doubleValue() < max.doubleValue();

		return isAboveMin && isBelowMax;
	}

	public T RandomNumber() {
		return RandomNumber(false, 0);
	}

	public T RandomNumber(boolean roundToX, int x) {
		return null;
	}
}
