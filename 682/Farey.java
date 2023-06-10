import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Farey {
	public static String[] farey(int n) {
		return IntStream.rangeClosed(0, n)
			.boxed()
			.flatMap(i -> IntStream.range(0, n)
				.mapToObj(j -> new Fraction(j, i))
				.filter(f ->
					(f.doubleValue() > 0 || f.d == 1) &&
						(f.doubleValue() < 1 || f.n == 1)
				)
			)
			.sorted( Comparator.comparing(Fraction::doubleValue) )
			.distinct()
			.map(Object::toString)
			.toArray(String[]::new);
	}
	
	public static void main(String[] args) {
		String[] farey = farey(5);
		System.out.println( Arrays.toString(farey) );
	}
}
