/*  Student information for assignment:
 *
 *  On my honor, <NAME>, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID:
 *  email address:
 *  Grader name:
 *  Number of slip days I am using:
 */


/** 
 * ArrayProblems.java<br>
 * CS 307<br><br>
 * 
 * VERY IMPORTANT: For this assignment only, the only methods and classes from the 
 * Java standard library you may use in your final solutions are:<br>
 * 1. All methods from the System class<br>
 * 2. All methods from the Math class<br>
 * 3. native arrays, including the <tt>arr.length</tt> field and creating and using new native arrays
 */
import java.lang.Math;

public class Assignment2
{

    /**
     * Determine the Hamming distance between two arrays of ints. 
     * Neither the parameter <tt>aList</tt> or
     * <tt>bList</tt> are altered as a result of this method.
     * @param aList != null, aList.length == bList.length
     * @param bList != null, bList.length == aList.length
     * @return the Hamming Distance between the two arrays of ints.
     */    
    public static int hammingDistance(int[] aList, int[] bList){
        assert (aList != null && bList != null && aList.length == bList.length) : "Violation of precondition: hammingDistance";
        
        /*CS307 STUDENTS: INSERT YOUR CODE HERE*/
    		int hammDist = 0;
    		for (int i = 0; i < aList.length; i++)
    		{
    			if (aList[i] != bList[i])
    			{
    				hammDist++;
    			}
    		}
    		return hammDist;
    }
    
	/**
     * Determine if one array of ints is a permutation of another.
     * Neither the parameter <tt>listA</tt> or 
     * the parameter <tt>listB</tt> are altered as a result of this method.
     * @param listA != null
     * @param listB != null
     * @param listA == listB
     * @return <tt>true</tt> if listB is a permutation of listA, <tt>false</tt> otherwise
     * 
	*/
		/*CS307 STUDENTS: INSERT YOUR CODE HERE*/
		
	public static boolean isPermutation(int[] listA, int[] listB){
		assert (listA != null && listB != null && listA.length == listB.length) : "Violation of precondition";
		
		
		int[] digits1 = countDigits(listA);
		int[] digits2 = countDigits(listB);
		for (int i = 0; i < digits1.length; i++)
		{
			if (digits1[i] != digits2[i])
				return false;
		}
		return true;
	}
		
		
	/** Helper method for isPermutation method
	 *  You will need to redo this method if you wish to compare arrays that have non-positive integers
	 *  or integers with multiple digits
	 * @param theList
	 * @return array containing the number of each digit in the parameter array
	 */
	public static int[] countDigits(int[] theList)
	{
		int[] digits = new int[10];
		for (int i = 0;i < theList.length; i++)
		{
			digits[theList[i]]++;
		}
		return digits;
	}

	
	/** Find the two values in an array of ints that have the smallest absolute
	 * difference.
	 * The parameter <tt>nums</tt> is not altered as a result of
	 * this method.
	 * @param nums The array being searched.
	 * <tt>nums</tt> != null, <tt>nums.length</tt> >= 2
	 * @return Returns an array of length 2. 
	 * The elements of the result are the indices of ints in 
	 * nums that have the smallest absolute difference
	 * of any pair of ints in nums.<br>
	 * If there is more than one pair of ints that meet this 
	 * criteria return the indices of the pair with the index closest
	 * to zero.<br>
	 * If there is more than one pair of ints with the 
	 * index closest to 0, return the indices of the pair with the
	 * second index closest to 0.<br>
	 * The first element of the result is the index closest to 0.
	 * For example given the array <tt>{5, 3, 21, 10, 12, 7}</tt> the method
	 * would return <tt>{0, 1}</tt>. 
	 */
	public static int[] minDifference(int[] nums) {
	    int[] result = new int[2];
	    int firstIndex = 0;
	    int secondIndex = 0;
	    int minDifference = Integer.MAX_VALUE;
	    /*CS307 STUDENTS: INSERT YOUR CODE HERE*/
	    for (int i = 0; i < nums.length-1; i++)
	    {
	    	for (int j = i+1; j < nums.length; j++)
	    	{
	    		int difference = Math.abs(nums[i]-nums[j]);
	    		if (difference < minDifference)
	    		{
	    			firstIndex = i;
	    			secondIndex = j;
	    			minDifference = difference;
	    			
	    		}
	    	}
	    }
	    result[0] = firstIndex;
	    result[1] = secondIndex;
	    return result;
	}
	

    /**
     * Determine which row or column in a matrix has the largest sum.
     * The parameter <tt>mat</tt> is not altered as a result of
     * this method call.
     * <p>pre: mat != null, mat.length > 0,
     * mat is a rectangular matrix, mat[0].length > 0
     * <p>post: determine which row or column of ints has the maximum sum in max. 
     * If a row contains the maximum sum, return a string starting with "R" and 
     * then the number of the row with no spaces. For example "R0" or "R12". If a 
     * column contains the maximum sum, return a string starting with "C" and then 
     * the number of the column with no spaces. For example "C0" or "C12".  
     * If there is more than one row or column with the maximum sum 
     * return rows over columns first, then smaller indices over
     * larger indices.<br>
     * Thus if rows 3, 5, and 12, and columns 0 and 2 all contained
     * the same maximum sum the method would return "R3".
    */
    public static String maxSum(int[][] mat) {
        assert (mat != null) && (mat.length > 0) && (mat[0].length > 0)
                && isRectangular( mat ) : "Violation of precondition: maxSum";
                
        /*CS307 STUDENTS: INSERT YOUR CODE HERE*/
        String place = "";
        int largestSum = Integer.MIN_VALUE;
        // Loop for rows
        for (int i = 0; i < mat.length; i++)
        {
        	int sum = 0;
        	for (int j = 0; j < mat[0].length; j++)
        	{
        		sum+=mat[i][j];
        	}
        	if (sum > largestSum)
        	{
        		largestSum = sum;
        		place = "R" + i;
        	}
        }
        // Loop for columns
        for (int i = 0; i < mat[0].length; i++)
        {
        	int sum = 0;
        	for (int j = 0; j < mat.length; j++)
        	{
        		sum+=mat[j][i];
        	}
        	if (sum > largestSum)
        	{
        		largestSum = sum;
        		place = "C"+i;
        	}
        }
        return place; //must change
    }
    
    /**
     * Given a 2D array of ints return the value of the
     * most valuable contiguous sub rectangle in the 2D array.
     * The sub rectnagle must be at lest 1 by 1. 
     * <p>pre: <tt>mat != null, mat.length > 0, mat[0].length > 0,
     * mat</tt> is a rectangular matrix.
     * <p>post: return the value of the most valuable contiguous sub rectangle
     * in <tt>city</tt>.
     * @param city The 2D array of ints representing the value of
     * each block in a portion of a city.
     * @return return the value of the most valuable contigous sub rectangle
     * in <tt>city</tt>.
     */
    public static int mostValuablePlot(int[][] city){
        assert city != null && city.length > 0 && city[0].length > 0 && 
            isRectangular(city) : "Failed precondition sizeOfLargestSubMatrix";

        /*CS307 STUDENTS: INSERT YOUR CODE HERE*/
		int bigSum = Integer.MIN_VALUE;
		int[] startCoords = new int[2];	
		for (int rowPlace = 0; rowPlace < city.length; rowPlace++)
		{
			startCoords[0] = rowPlace;
			for (int colPlace = 0; colPlace < city[0].length; colPlace++)
			{
				startCoords[1] = colPlace;
				bigSum = goThroughEndPoints(startCoords,city,bigSum);
				
			}
		}
	
		return bigSum;
		
	}
    /** Helper method to mostValuablePlot
	 * Determines total value of a certain amount of plots
	 * @param startCoords the first number is the row. the second number is the column
	 * @param endCoords the first number is the row. the second number is the column
	 * @param mat 2d array that needs to be traversed
	 * @return total of the plots from the starting coords to the ending coords
	 */
	public static int plotTotal(int[] startCoords, int[] endCoords, int[][] mat)
	{
		int startRow = startCoords[0];
		int startCol = startCoords[1];
		int endRow = endCoords[0];
		int endCol = endCoords[1];
		int totalPlot = 0;
		for (int x = startRow; x <= endRow; x++)
		{
			for (int y = startCol; y <= endCol; y++)
			{
				totalPlot+=mat[x][y];
			}
		}		
		return totalPlot;
	}

	/** Helper method that mostValuePlot
	 * takes a starting coordinate in a 2d array and traverses through each of the possible endPoints 
	 * that would result in a rectangle.
	 * It may be more ideal to use an ArrayList to build an array of 
	 * endpoints that can then be traversed using another method.
	 * This combines two methods. Traversing the endPoints and calling
	 * the plotTotal method to find the size and returning the largest value
	 * It does not keep track of the coordinates of the actual biggest plot.
	 * @param startCoords starting points "row" and "column" of a 2d array
	 * @param mat 2d array to be traversed
	 * @param currentLargest largest possible plot returned by plotTotal
	 * @return largest plot size
	 */
	public static int goThroughEndPoints(int[] startCoords, int[][] mat, int currentLargest)
	{
		int startRow = startCoords[0];
		int startCol = startCoords[1];
		for (int row = startRow; row < mat.length; row++)
		{		
		
			for (int col = startCol; col < mat[0].length; col++)
			{
				int[] nextPoint = {row,col};
				int tempSum = plotTotal(startCoords,nextPoint,mat);
				if (tempSum >= currentLargest)
				{
					currentLargest = tempSum;

				}	
			}
		}
		return currentLargest;		
	}

    /**
	 * Determine if the chess board represented by board is a safe set up.
	 * <p>pre: board != null, board.length > 0, board is a square matrix.
	 * (In other words all rows in board have board.length columns.),
	 * all elements of board == 'q' or '.'. 'q's represent queens, '.'s
	 * represent open spaces.<br>
	 * <p>post: return true if the configuration of board is safe,
	 * that is no queen can attack any other queen on the board.
	 * false otherwise.
	 * the parameter <tt>board</tt> is not altered as a result of 
	 * this method.
	 * @param board the chessboard
	 * @return true if the configuration of board is safe,
	 * that is no queen can attack any other queen on the board.
	 * false otherwise.
	*/
	public static boolean queensAreSafe(char[][] board) {
		char[] validChars = {'q', '.'};
		assert (board != null) && (board.length > 0)
				&& isSquare(board) && onlyContains(board, validChars)
				: "Violation of precondition: queensAreSafe";
				
		/*CS307 STUDENTS: INSERT YOUR CODE HERE*/
		int[][] queenLocations = new int[10][2];
		int numQueens = 0;
		int numBoardRows = board.length;
		int numBoardCols = board[0].length;
		int[][] queenBadLocations = new int[10][2];
		for (int rows = 0; rows < board.length; rows++)
		{
			for (int cols = 0; cols < board[0].length; cols++)
			{
				if (board[rows][cols] == 'q')
				{
					queenLocations[numQueens][0] = rows;
					queenLocations[numQueens][1] = cols;
					numQueens++;
					if(numQueens == queenLocations.length)
					{
						queenLocations = resize(queenLocations, queenLocations.length * 2);
					}
				}
			}
		}
		queenLocations = resize(queenLocations,numQueens);
		for (int i = 0; i < queenLocations.length; i++)
		{
			queenBadLocations = queenMoves(queenLocations[i],numBoardRows,numBoardCols);
			for (int j = 0; j < queenBadLocations.length; j++)
			{
				int badRow = queenBadLocations[j][0];
				int badCol = queenBadLocations[j][1];
				for (int x = i+1; x < queenLocations.length; x++)
				{
					if (queenLocations[x][0] == badRow && queenLocations[x][1] == badCol)
					{
						return false;
					}
				}
			}
		}
		/*
		//Temp loop used to check contacts of temp variable "queenBadLocations
		System.out.println("Queen bad locations are: ");
		for (int i = 0; i < queenBadLocations.length; i++)
		{
			System.out.println("(" + queenBadLocations[i][0] + "," + queenBadLocations[i][1] + ")");
		}
		System.out.println(queenLocations.length);
		*/
		return true;
	}
	/**
	 * Helper method to safeQueens. Finds all "bad" spots depending on the given 
	 * location of the queen. Returns a list of "bad" spots for the safeQueens
	 * method to check remaining queen locations against.
	 * @param queenLoc
	 * @param boardRows
	 * @param boardCols
	 */
	public static int[][] queenMoves(int[] queenLoc, int boardRows, int boardCols)
	{
		int rowLocation = queenLoc[0];
		int colLocation = queenLoc[1];
		int[][] badSpots = new int[10][2];
		int numBadSpots = 0;
		//All spots directly to the right of the queen
		for (int i = colLocation+1; i < boardCols; i++)
		{
			numBadSpots = addNewBadSpot(numBadSpots, badSpots, rowLocation, i);

		}
		//All spots directly to the left of the queen
		for (int j = colLocation-1; j >= 0; j--)
		{
			numBadSpots = addNewBadSpot(numBadSpots, badSpots, rowLocation, j);

		}
		//All spots directly below the queen
		for (int k = rowLocation+1; k < boardRows; k++)
		{
			numBadSpots = addNewBadSpot(numBadSpots, badSpots, k, colLocation);

		}
		//All spots directly above the queen
		for (int m = rowLocation-1; m >= 0; m--)
		{
			numBadSpots = addNewBadSpot(numBadSpots, badSpots, m, colLocation);

		}
		
		// Get all spots diagonal (right and up) from starting spot
		int rightUpCols = queenLoc[1]+1;
		int rightUpRows = queenLoc[0]-1;
		while (rightUpCols < boardCols && rightUpRows >= 0)
		{
			numBadSpots = addNewBadSpot(numBadSpots, badSpots, rightUpRows, rightUpCols);
			rightUpCols++;
			rightUpRows--;
		}
		// Get all spots diagonal (left and up) from starting spot
		int leftUpCols = queenLoc[1]-1;
		int leftUpRows = queenLoc[0]-1;
		while (leftUpCols >= 0 && leftUpRows >= 0)
		{
			numBadSpots = addNewBadSpot(numBadSpots, badSpots, leftUpRows, leftUpCols);
			leftUpCols--;
			leftUpRows--;
		}
		// Get all spots diagonal (right and up) from starting spot
		int rightDownCols = queenLoc[1]+1;
		int rightDownRows = queenLoc[0]+1;
		while (rightDownCols < boardCols && rightDownRows < boardRows)
		{
			numBadSpots = addNewBadSpot(numBadSpots, badSpots, rightDownRows, rightDownCols);
			rightDownCols++;
			rightDownRows++;
		}
		// Get all spots diagonal (right and up) from starting spot
		int leftDownCols = queenLoc[1]-1;
		int leftDownRows = queenLoc[0]+1;
		while (leftDownCols >= 0 && leftDownRows < boardRows)
		{
			numBadSpots = addNewBadSpot(numBadSpots, badSpots, leftDownRows, leftDownCols);
			leftDownCols--;
			leftDownRows++;
		}
				
				
		badSpots = resize(badSpots,numBadSpots);
		return badSpots;
	}
	
	public static int addNewBadSpot(int numBadSpots, int[][] badSpots, int badRow, int badCol)
	{
		if (numBadSpots == badSpots.length)
		{
			badSpots = resize(badSpots,badSpots.length * 2);
			
		}
		badSpots[numBadSpots][0] = badRow;
		badSpots[numBadSpots][1] = badCol;
		numBadSpots++;
		return numBadSpots;
	}
	
	public static int[][] resize(int[][] original, int newSize)
	{
		int [][] temp = original;
		int numToCopy = Math.min(newSize, original.length);
		original = new int[newSize][2];
		for (int i = 0; i < numToCopy; i++)
		{
			original[i] = temp[i];
		}
		return original;
	}
	

	public static void main(String[] args) {
			
		//test 1a
        int[] h1 = {1, 2, 3, 4, 5, 4, 3, 2, 1};
        int[] h2 = {1, 2, 10, 4, 5, 4, 3, -10, 1};
        int expected = 2;
        int actual = hammingDistance(h1, h2);
        System.out.print("Test 1 expected value: " + expected + ", actual value: " + actual);
        if( expected == actual )          
            System.out.println(" passed test 1a, hamming distance");
        else
            System.out.println(" failed test 1a, hamming distance");
        
        //test1b
        h1 = new int[]{1,1,1,1,1,1,1};
        h2 = new int[]{1,1,2,3,4,2,1};
        expected = 4;
        actual = hammingDistance(h1,h2);
        if( expected == actual )          
            System.out.println(" passed test 1b, hamming distance");
        else
            System.out.println(" failed test 1b, hamming distance");

        
        //test 2
		int[] a = {1, 2, 3};
		int[] b = {2, 1, 3};
        boolean expectedBool = true;
        boolean actualBool = isPermutation(a,b);
        System.out.print("\nTest 2 expected value: " + expectedBool + ", actual value: " + actualBool);
		if ( expectedBool == actualBool )
			System.out.println(" passed test 2, isPermutation");
		else
			System.out.println(" failed test 2, isPermutation");

		//test 3a
		int[] c = {2, 1, 3, 3};
		expectedBool = false;
        actualBool = isPermutation(a,c);
        System.out.print("\nTest 3 expected value: " + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
			System.out.println(" passed test 3a, isPermutation");
		else
			System.out.println(" failed test 3a, isPermutation");
        
        
      //test 3b
        a = new int[]{1,2,3,4,5,4,3,2,1};
  		int[] d = {5,4,3,2,1,4,3,2,1};
  		expectedBool = true;
          actualBool = isPermutation(a,d);
          System.out.print("\nTest 3 expected value: " + expectedBool + ", actual value: " + actualBool);
          if ( expectedBool == actualBool )
  			System.out.println(" passed test 3b, isPermutation");
  		else
  			System.out.println(" failed test 3b, isPermutation");

		//test 4
        int[] diffNums = {19, 0, -5, 4, 7, 10};
        int[] diffResult = minDifference(diffNums);
        if( diffResult.length == 2 && diffResult[0] == 3 &&
                diffResult[1] == 4)
            System.out.println(" passed test 4, nearest neighbor");
        else
            System.out.println(" failed test 4, nearest neighbor");         		

		//test 5
		char[][] safe = { {'.', '.', '.'},
		                  {'q', '.', '.'},
		                  {'.', '.', 'q'}};
		
        expectedBool = true;
        actualBool = queensAreSafe(safe);
        System.out.print("\nTest 5 expected value: " + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
			System.out.println(" passed test 5, queensAreSafe");
		else
			System.out.println(" failed test 5, queensAreSafe");

		//test 6
		char[][] unsafe = { {'.', '.', '.', 'q'},
		                    {'.', '.', '.', '.'},
		                    {'.', '.', '.', '.'},
		                    {'q', '.', '.', '.'}};
        expectedBool = false;
        actualBool = queensAreSafe(unsafe);
        System.out.print("\nTest 6 expected value: " + expectedBool + ", actual value: " + actualBool);
        if ( expectedBool == actualBool )
			System.out.println(" passed test 8, queensAreSafe");
		else
			System.out.println(" failed test 8, queensAreSafe");


		
		//test 7
		int[][] mat = { {1, 2, 3, 4},
		                {0, 0, 0, 0},
		                {1, 2, 3, 10},
		                {4, 3, 2, 1}};
        String expectedString = "R2";
        String actualString = maxSum(mat);
        System.out.print("\nTest 7 expected value: " + expectedString + ", actual value: " + actualString);
		if( expectedString.equals(actualString) )
			System.out.println(" passed test 7, maxSum");
		else
			System.out.println(" failed test 7, maxSum");
		
		// test 8
		mat = new int[][] { {-10, -20, -30, -40},
                            {-2, -2, -200, -300},
                            {-200, -2, -300, -100},
                            {-200, -3, -200, -100}};
		expectedString = "C1";
        actualString = maxSum(mat);
        System.out.print("\nTest 8 expected value: " + expectedString + ", actual value: " + actualString);
        if( expectedString.equals(actualString) )
            System.out.println(" passed test 8, maxSum");
        else
            System.out.println(" failed test 8, maxSum");
        
        //test 9
        mat = new int[][] { {1,  2,  3,  4},
                            {2,  0,  0, -1},
                            {3, -2, -2, -1},
                            {4,  2,  3,  1}};
        expectedString = "R0";
        actualString = maxSum(mat);
        System.out.print("\nTest 9 expected value: " + expectedString + ", actual value: " + actualString);
        if( expectedString.equals(actualString) )
            System.out.println(" passed test 9, maxSum");
        else
            System.out.println(" failed test 9, maxSum");
        
        // test 10
        mat = new int[][]{{0, -2, -7, 0, -1},
                          {9, 2, -6, 2, 0},
                          {-4, 1, -4, 1, 0},
                          {-1, 8, 0, -2, 1},
                          {-10, 1, 1, -5, -6},
                          {-15, -1, 1, 5, 4}};
        
        expected = 15;
        actual = mostValuablePlot(mat);
        System.out.print("\nTest 10 expected value: " + expected + ", actual value: " + actual);
        if( expected == actual )          
            System.out.println(" passed test 10, mostValuablePlot");
        else
            System.out.println(" failed test 10, mostValuablePlot");


        // test 11
        mat[4][1] = 6;
        expected = 17;
        actual = mostValuablePlot(mat);
        System.out.print("\nTest 11 expected value: " + expected + ", actual value: " + actual);
        if( expected == actual )          
            System.out.println(" passed test 11, mostValuablePlot");
        else
            System.out.println(" failed test 11, mostValuablePlot");
        
        // test 12
        mat = new int[][] {{1}};
        expected = 1;
        actual = mostValuablePlot(mat);
        System.out.print("\nTest 12 expected value: " + expected + ", actual value: " + actual);
        if( expected == actual )          
            System.out.println(" passed test 12, mostValuablePlot");
        else
            System.out.println(" failed test 12, mostValuablePlot");
        
        // test 13
        mat = new int[][]{{1, 2, 3, 4, 5, 6, 7}};
        expected = 28;
        actual = mostValuablePlot(mat);
        System.out.print("\nTest 13 expected value: " + expected + ", actual value: " + actual);
        if( expected == actual )          
            System.out.println(" passed test 13, mostValuablePlot");
        else
            System.out.println(" failed test 13, mostValuablePlot");
        
        // test 14
        mat = new int[][]{{-10, -10, -10, -5},
                          {-15, -15, -10, -10},
                          {-5, -10, -20, -5},
                          {-5, -5, -10, -20}};
        
        expected = -5;
        actual = mostValuablePlot(mat);
        System.out.print("\nTest 14 expected value: " + expected + ", actual value: " + actual);
        if( expected == actual )          
            System.out.println(" passed test 14, mostValuablePlot");
        else
            System.out.println(" failed test 14, mostValuablePlot");
		
		/*CS307 STUDENTS: ADD YOUR TESTS HERE*/
        //test 15
        mat = new int[][]{{0,0,10,20},
        				{-50,10,10,10},
        				{0,10,-20,0},
        				{-10,10,50,0}};
        expected = 110;
        actual = mostValuablePlot(mat);
        if (expected == actual)
        	System.out.println(" passed test 15, mostValuablePlot");
        else
            System.out.println(" failed test 15, mostValuablePlot");
        
	}


	/* pre: mat != null
	   post: return true if mat is a square matrix, false otherwise
	*/
	private static boolean isSquare(char[][] mat) {
		assert mat != null : "Violation of precondition: isSquare";

		final int numRows = mat.length;
		int row = 0;
		boolean square = true;
		while( square && row < numRows ) {
			square = ( mat[row] != null) && (mat[row].length == numRows);
			row++;
		}
		return square;
	}
	

	/* pre: mat != null, valid != null
	   post: return true if all elements in mat are one of the characters in valid
	*/
	private static boolean onlyContains(char[][] mat, char[] valid)
	{	assert mat != null && valid != null : "Violation of precondition: onlyContains";

		int row = 0;
		int col;
		boolean correct = true;
		while( correct && row < mat.length) {
			col = 0;
			while(correct && col < mat[row].length) {
				correct = contains(valid, mat[row][col]);
				col++;
			}
			row++;
		}
		return correct;
	}


	/* pre: list != null
	   post: return true if c is in list
	*/
	private static boolean contains(char[] list, char c) {
		assert ( list != null ) : "Violation of precondition: contains";

		boolean found = false;
		int index = 0;
		while( !found && index < list.length) {
			found = list[index] == c;
			index++;
		}
		return found;
	}


	/*
	/* pre: mat != null, mat.length > 0
	 * post: return true if mat is rectangular
	 */
	private static boolean isRectangular(int[][] mat) {
		assert (mat != null) && (mat.length > 0) : "Violation of precondition: isRectangular";

		boolean correct = true;
		final int numCols = mat[0].length;
		int row = 0;
		while( correct && row < mat.length) {
			correct = (mat[row] != null) && (mat[row].length == numCols);
			row++;
		}
		return correct;
	}
}