import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

/** An implementation of Pascal's triangle */
public class PascalTriangle {
	private List<List<Integer>> triangle;
	
	public PascalTriangle() {
		this(2);
	}
	
	public PascalTriangle(int size) {
		triangle = new ArrayList<>();
		
		ensureSize(size);
		fill(2);
	}
	
	public List<List<Integer>> getTriangle() {
		return new ArrayList<>(triangle);
	}
	
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
	
	public void ensureSize(int size) {
		int length = triangle.size();
		
		if (length > size)
			return;
		
		for (int i = length; i <= size; i++)
			triangle.add( new ArrayList<>( Collections.nCopies(i + 1, 0) ) );
		
		fill( length );
	}
}
