/** My solution for Weekday Challenge #654 */
public class Challenge {
	private PascalTriangle triangle = new PascalTriangle();
	
	public int paths(int x, int y) {
		triangle.ensureSize(x + y);
		return triangle.getTriangle().get(x + y).get(y);
	}
	
	public static void main(String[] args) {
		Challenge c = new Challenge();
		System.out.println( c.paths(6, 9) );
	}
}
