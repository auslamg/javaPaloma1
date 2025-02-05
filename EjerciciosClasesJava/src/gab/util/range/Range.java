package gab.util.range;

import java.util.Random;

public class Range <T extends Number> {

	public static void main(String[] args) {
		Range<Double> myRange = new Range<>(5d, 6d);
		
		for (int i = 000; i < 1000; i++) {
			System.out.println(myRange.RandomNumber());
		}
	}

	T min;
	T max;

	boolean minInclusive;
	boolean maxInclusive;

	public Range(T min, T max) {
		this(min, max, true, true);
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

	public Number RandomNumber() {
		return RandomNumber(false, 0);
	}

	public Number RandomNumber(boolean roundToX, int x) {

		Random r = new Random();

		if (min instanceof Integer) {
			Integer result = r.nextInt(min.intValue(), max.intValue()+1);
			return result;		
		}
		else if (min instanceof Long) {
			Long result = r.nextLong(min.longValue(), max.longValue()+1);
			return result;
		}
		else if (min instanceof Float) {
			Float result = min.floatValue() + (max.floatValue() - min.floatValue()) * r.nextFloat();
			return result;
		}
		else if (min instanceof Double) {
			Double result = min.doubleValue() + (max.doubleValue() - min.doubleValue()) * r.nextDouble();
			return result;
		}
		else {
			System.out.println("Unsupported data type");
			return null;		
		}		
	}

	public static Number RandomNumber(Range<Number> range) {
		return null;
	}
}
