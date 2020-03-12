package SearchAlgorithm;


public class SearchAlgo {

	boolean searchAlgo(int[][] a, int lo, int hi, int key) {
		 int row = a.length;
		 int col = a[0].length;
		 if (a[lo][hi] == key) {
			return true;
		} 
		 else if(a[0][0]>key ) {
			return false;
		}
		 else if(a[row-1][col-1]<key) {
			 return false;
		 }
		else if (lo == row && hi == col-1  && a[lo][hi] != key) {
			return false;
		} 
		
		else if (a[lo][hi] > key) {
			return searchAlgo(a, lo, hi - 1, key);
		} 
		else if (a[lo][hi] < key) {
			return searchAlgo(a, lo + 1, hi, key);
		}
		return false;
	}

	boolean search(int[][] a, int key) {
		return searchAlgo(a, 0, a[0].length-1, key);

	}

	public static void main(String[] args) {

		int[][] a = { { 0, 1, 3, 9, 14 }, 
					{ 2, 4, 7, 10, 16 }, 
					{ 5, 8, 11, 12, 18 },
					{ 6, 13, 15, 19, 20 },
					{ 17, 21, 23, 25, 29 } };
		

		SearchAlgo sa = new SearchAlgo();
		System.out.println(sa.search(a, 17));

	}

}
