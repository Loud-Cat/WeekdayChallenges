public class Fraction implements Comparable<Fraction> {
	int n, d;
	
	public Fraction(int n, int d) {
		this.n = n;
		this.d = d;
	}
	
	public double doubleValue() {
		if (d == 0)
			return -1;
		
		return (double) n / d;
	}
	
	@Override
	public String toString() {
		return String.format("%d/%d", n, d);
	}
	
	@Override
	public int compareTo(Fraction other) {
		return Double.compare(doubleValue(), other.doubleValue());
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Fraction)
			return compareTo( (Fraction) obj ) == 0;
		
		return false;
	}
	
	@Override
	public int hashCode() {
		return 0;
	}
}
