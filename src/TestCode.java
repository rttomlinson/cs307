import java.util.ArrayList;
import java.lang.Math;
import java.util.Random;

public class TestCode {

	public static void main(String[] args) {
		long bigSum = 600851475143L;

		for (long factors = 2L; factors < bigSum; factors++)
		{
		    if (bigSum % factors == 0)
		    {
		    	boolean tester = true;
		        for (long facFac = factors-1L; facFac > 1; facFac--)
		        {
		            
		            if (factors % facFac == 0)
		            {
		                tester = false;
		            }
		        }
		        if (tester)
		        {
		            System.out.println(factors);
		        }
		    }
		}
		
	}
	
	public static boolean safeQueens(char[][] board)
	{
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
	
	/**
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
			System.out.println("Value of x = " + x);
			System.out.println("Value of endRow = " + endRow);
			for (int y = startCol; y <= endCol; y++)
			{
				System.out.println("Value of y = " + y);
				System.out.println("Value of endCol = " + endCol);
				totalPlot+=mat[x][y];
				System.out.println("Value of totalPlot = " + totalPlot);
			}
		}		
		return totalPlot;
	}
	
	/**
	 * Finds the largest consecutive plot
	 * @param mat
	 */
	
	public static void traverseMatrix(int[][] mat)
	{
		System.out.println("hello");
		int bigSum = Integer.MIN_VALUE;
		int[] startCoords = new int[2];	
		for (int rowPlace = 0; rowPlace < mat.length; rowPlace++)
		{
			startCoords[0] = rowPlace;
			for (int colPlace = 0; colPlace < mat[0].length; colPlace++)
			{
				startCoords[1] = colPlace;
				bigSum = goThroughEndPoints(startCoords,mat,bigSum);
				
			}
		}
	
		System.out.println(bigSum);
		
	}
	/**
	 * takes a starting value and traverses through each of the endPoints.
	 * It may be more ideal to use an ArrayList to build an array of 
	 * endpoints that can then be traversed using another method.
	 * This combines two functions. Traversing the endPoints and calling
	 * the plotTotal method to find the size and returning the largest value
	 * It does not keep track of the actual biggest plot.
	 * @param startCoords
	 * @param mat
	 * @param currentLargest
	 * @return
	 */
	public static int goThroughEndPoints(int[] startCoords, int[][] mat, int currentLargest)
	{
		System.out.println("Start goThroughEndPoints");
		int startRow = startCoords[0];
		int startCol = startCoords[1];
		for (int row = startRow; row < mat.length; row++)
		{		
		
			for (int col = startCol; col < mat[0].length; col++)
			{
				int[] nextPoint = {row,col};
				System.out.println("The next point is " + nextPoint[0] + "," + nextPoint[1]);
				int tempSum = plotTotal(startCoords,nextPoint,mat);
				if (tempSum >= currentLargest)
				{
					System.out.println("tempSum is larger or equal to currentLargest");
					currentLargest = tempSum;

				}	
			}
		}
		return currentLargest;		
	}
	
	public static void traverseCols(int[][] mat)
	{
		int[][] coords = new int[2][2];
		int bigSum = Integer.MIN_VALUE;
		int startX = 0;
		int startY = 0;

		for (int startRow = 0; startRow < mat.length; startRow++)
		{
		
			for (int colPlace = 0; colPlace < mat[0].length; colPlace++)
			{
				
				int littleSum = 0;
				for (int rowPlace = startRow; rowPlace < mat.length; rowPlace++)
				{
					littleSum+=mat[rowPlace][colPlace];
					if (littleSum >= bigSum)
					{	
						coords[0][1] = colPlace;
						coords[1][0] = rowPlace;
						coords[1][1] = colPlace;
						if (littleSum > bigSum)
						{
							coords[0][0] = startRow;
						}
						bigSum = littleSum;
						
					}
				}
			}
		}
		System.out.println("starting coords are Row" + (coords[0][0]+1) + " and Col" +
		(coords[0][1]+1) + ".");
		System.out.println("ending coords are Row" + (coords[1][0]+1) + " and Col" +
		(coords[1][1]+1) + ".");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static boolean isPermutation(int[] listA, int[] listB)
	{
		int[] digits1 = countDigits(listA);
		int[] digits2 = countDigits(listB);
		for (int i = 0; i < digits1.length; i++)
		{
			if (digits1[i] != digits2[i])
				return false;
		}
		return true;

	}
	
	public static int[] countDigits(int[] theList)
	{
		int[] digits = new int[10];
		for (int i = 0;i < theList.length; i++)
		{
			digits[theList[i]]++;
		}
		return digits;
	}
	
	
	public static int hammingDistance(int[] aList, int[] bList)
	{
		assert (aList != null) && (bList != null) && (aList.length == bList.length):
			"Violation of preconditions";
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
	
	
	
	public static void vowelCount(String[] list)
	{
		if (list.length == 0)
		{
			System.out.println("There are no elements");
		}
		int mostVowelIndex = 0;
		int highestNumVowel = 0;
		for (int i = 0; i < list.length; i++)
		{
			int numVowels = 0;
			for (int x = 0; x < list[i].length(); x++)
			{
				switch(list[i].charAt(x))
				{
				case 'a': case 'A': case 'e': case 'E': case 'I': case 'i':
				case 'o': case 'O': case 'u': case 'U':
					numVowels++;
					break;
				default:
					break;
				}
			}
			if (numVowels > highestNumVowel)
			{
				highestNumVowel = numVowels;
				mostVowelIndex = i;
			}
		}
		System.out.println(list[mostVowelIndex]);
		
	}
	public static int majority(int[] list)
	{
		assert (list != null) : "Violation of precondition";
		int magicNumber = list.length/2+1;
		for (int i = 0; i <= list.length + 1;i++)
		{
			int counter = 0;
			for (int j = i+1; j < list.length; j++)
			{
				if (list[i] == list[j])
				{
					counter++;
				}
			}
			if (counter >= magicNumber)
			{
				return i;
			}
			
		}
		return -1;
	}
	public static int[] birthdayProblem(int groupNum, int daysInYear)
	{
		int[] bdays = new int[daysInYear];
		Random r = new Random();
		for (int i = 0; i < groupNum; i++)
		{
			int x = r.nextInt(daysInYear);
			bdays[x]++;
		}
		return bdays;
	}
	public static void takingAvg(int[] list)
	{
		for (int i = 0; i < list.length; i++)
		{
			int counter = 0;
			if (list[i] > 1)
			{
				counter++;
			}
		}
	}
	public static int totalPairs(int[] list)
	{
		int totalPairs = 0;
		for (int i = 0; i < list.length; i++)
		{
			totalPairs+=(list[i] * (list[i]-1))/2;
		}
		return totalPairs;
	}
}
/*
set the variable that holds the index of the string with the greatest number of vowels to 0

for until there are no more strings keep checking
check each character in the string to see if it is contained in the vowels string


before checking next string-check if the number of vowels is greater than the last index 
that had the most vowels, if so assign the current index checked to the variable that 
holds the index of the string with the most vowels
*/