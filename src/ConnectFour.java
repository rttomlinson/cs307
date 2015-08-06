import java.util.Scanner;


public class ConnectFour {
		private int [][] board;
		private int lastRow;
		private int lastCol;
	
	
	public ConnectFour(){
		board = new int[6][7];
		lastRow = 5;
		lastCol = 6;
		
		
	}
	
	public ConnectFour(int [][] startBoard){
		board = startBoard;
		lastRow = startBoard.length-1;
		lastCol = startBoard[0].length-1;
	}
	
	
	//Combine isSpace and spotsLeft?
	public int isSpace(int col){
		for (int i = lastRow; i > -1; i--)
		{
			if (board[i][col] == 0)
			{
				return i;
			}
		}
		return -1;
	}
	
	public boolean spotsLeft(){
		int counter = 0;
		for (int i = 0; i <= lastCol; i++){
			if (board[0][i] == 0){
				counter++;
			}
		}
		if (counter > 0){
			return true;
		}
		return false;
	}
	
	
	
	public void addPiece(int playerTurn, int colPiece, int availRow){
		
		if (playerTurn == -1){
			board[availRow][colPiece] = -1;
			System.out.println("You added a piece to column: " + (colPiece+1));
		}
		else{
			board[availRow][colPiece] = 1;
			System.out.println("You added a piece to column: " + (colPiece+1));
		}
		
		
	}
	
	public boolean checkIfWinner(){
		//for each space
		for (int x = 0; x <= lastRow; x++){
			for (int y = 0; y <= lastCol; y++){
				if (directCheck(x,y)){
					int maybeWinner = board[x][y];
					if (maybeWinner == -1){
						System.out.println("-1 is the winner!");
						return true;
					}
					else if (maybeWinner  == 1){
						System.out.println("1 is the winner!");
						return true;
					}
				}
			}
		}
		System.out.println("No winner yet");
		return false;
		
	}
	
	private boolean directCheck(int i, int j){
		int counter = 0;
		if (j+3 <= lastCol){ //check if winner directly to the right
			for (int x = j; x <= j+3; x++){
				if (board[i][x] != board[i][j]){
					//not matching
					break;
				}
				else{
					counter++;
				}
				//what to do if they are all matching
			}
			if (counter == 4){
				return true;
			}
			else{
				counter = 0;
			}
		}
		
		
		if (i+3 <= lastRow){ //check if winner directly down
			for (int x = i; x <= i+3; x++){
				if (board[x][j] != board[i][j]){
					//not matching
					break;
				}
				else{
					counter++;
				}
				//what to do if they are all matching
			}
			if (counter == 4){
				return true;
			}
			else{
				counter = 0;
			}
		}
		if (j-3 >= 0){ // check if winner directly left
			for (int x = j; x >= 0; x--){
				if (board[i][x] != board[i][j]){
					//not matching
					break;
				}
				else{
					counter++;
				}
				//what to do if they are all matching
			}
			if (counter == 4){
				return true;
			}
			else{
				counter = 0;
			}
		}
		if (i-3 >= 0){// check if winner directly up
			for (int x = i; x >= 0; x--){
				if (board[x][j] != board[i][j]){
					//not matching
					break;
				}
				else{
					counter++;
				}
				//what to do if they are all matching
			}
			if (counter == 4){
				return true;
			}
			else{
				counter = 0;
			}
		}
		if (j-3 >= 0 && i-3 >= 0){ // check if winner diagonally left and up
			int y = j;
			for (int x = i; x >= i-3; x--){
				if (board[x][y] != board[i][j]){
					//not matching
					break;
				}
				else{
					counter++;
					y--;
				}
				//what to do if they are all matching
			}
			if (counter == 4){
				return true;
			}
			else{
				counter = 0;
			}
		}
		if (i-3 >= 0 && j+3 <= lastCol){// check if winner diagonally up and right
			int y = j;
			for (int x = i; x >= i-3; x--){
				if (board[x][y] != board[i][j]){
					//not matching
					break;
				}
				else{
					counter++;
					y++;
				}
				//what to do if they are all matching
			}
			if (counter == 4){
				return true;
			}
			else{
				counter = 0;
			}
		}
		if (i+3 <= lastRow && j-3 >= 0){ //check if winner diagonally down and left
			int y = j;
			for (int x = i; x <= i+3; x++){
				if (board[x][y] != board[i][j]){
					//not matching
					break;
				}
				else{
					counter++;
					y--;
				}
				//what to do if they are all matching
			}
			if (counter == 4){
				return true;
			}
			else{
				counter = 0;
			}
		}
		if (j+3 <= lastCol && i+3 <= lastRow){ //check if winner diagonally right and down
			int y = j;
			for (int x = i; x <= i+3; x++){
				if (board[x][y] != board[i][j]){
					//not matching
					break;
				}
				else{
					counter++;
					y++;
				}
				//what to do if they are all matching
			}
			if (counter == 4){
				return true;
			}
			else{
				counter = 0;
			}
		}

		return false;

		
	}
		
	public void playGame(){
		
		Scanner in = new Scanner(System.in);
		boolean isWinner = false;
		int playerPiece = -1;
		while (!isWinner){
			if (!this.spotsLeft()){
				System.out.println("It's a draw! No more valid spots.");
				break;
			}
			int colPiece = 0;
			boolean goodValue = false;
			System.out.print("Select column to drop next piece: ");
			
			while (!goodValue){
				if (in.hasNextInt()){
					colPiece = in.nextInt()-1;
					if (colPiece < 0 || colPiece > lastCol){
						System.out.println("That is not a valid column.");	
						System.out.print("Select column to drop next piece: ");
					}
					else{
						int availRow = this.isSpace(colPiece);

						if (availRow < 0){
							System.out.println("This column is full.");
							System.out.print("Please select another column: ");

						}
						else{
							this.addPiece(playerPiece, colPiece, availRow);
							goodValue = true;
							
						}
					}
				}
				else{	
					System.out.println("Invalid Input");	
					System.out.print("Select column to drop next piece: ");
					in.next();
				}
				
			}
			System.out.println("You picked column " + (colPiece+1));
			isWinner = this.checkIfWinner();
			if (isWinner){
				break;
			}
			playerPiece = playerPiece * -1;
		}
		in.close();
	}
	
	

	public static void main(String[] args) {
		
		
		System.out.println("Welcome to Connect 4. Player 1 goes first and is 'X's. Player 2 is 'O's");
		ConnectFour board3 = new ConnectFour();
		board3.playGame();
		
	}

	
	
	
}
