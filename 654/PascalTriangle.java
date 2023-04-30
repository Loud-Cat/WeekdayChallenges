import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/** An implementation of Pascal's triangle */
public class PascalTriangle {
	private List<List<Integer>> triangle;
	
	/** Creates a triangle with a small initial size */
	public PascalTriangle() {
		this(2);
	}
	
	/** Creates a triangle with the specified size
	  * @param size the initial size of the triangle
	  */
	public PascalTriangle(int size) {
		triangle = new ArrayList<>();
		
		ensureSize(size);
		fill(2);
	}
	
	/** Returns a copy of the triangle
	  * @return a copy of the triangle
	  */
	public List<List<Integer>> getTriangle() {
		return new ArrayList<>(triangle);
	}
	
	/** Fills the triangle with correct values starting from the given row.
	  * Allows the triangle to skip values that already exist.
	  * @param start the starting row to start at.
	  */
	private void fill(int start) {
		for (List<Integer> row : triangle) {
			row.set(0, 1);
			row.set(row.size() - 1, 1);
		}
		
		for (int row = start; row < triangle.size(); row++)
			for (int col = 1; col < triangle.get(row).size() - 1; col++) {
				int left = triangle.get(row - 1).get(col - 1);
				int right = triangle.get(row - 1).get(col);
				triangle.get(row).set(col, left + right);
			}
	}
	
	/** Ensures that the triangle has at least n rows.
	  * If the triangle has more than the given number of rows, it does nothing.
	  * It does not remove any extra rows.
	  * @param size the minimum number of rows
	  */
	public void ensureSize(int size) {
		int length = triangle.size();
		
		if (length > size)
			return;
		
		for (int i = length; i <= size; i++)
			triangle.add( new ArrayList<>( Collections.nCopies(i + 1, 0) ) );
		
		fill( length );
	}
}
