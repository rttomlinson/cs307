import java.util.Scanner;


public class ConnectFour {
		private int [][] board;
		private final int LAST_ROW;
		private final int LAST_COL;
		private final int LENGTH_TO_WIN;
	
	
	public ConnectFour(){
		board = new int[6][7];
		LAST_ROW = 5;
		LAST_COL = 6;
		LENGTH_TO_WIN = 4;	
	}
	
	public ConnectFour(int [][] startBoard){
		board = startBoard;
		LAST_ROW = startBoard.length-1;
		LAST_COL = startBoard[0].length-1;
		LENGTH_TO_WIN = 4;
	}
	
	
	public int lastAvailableSpaceInColumn(int col){
		for (int i = LAST_ROW; i >= 0; i--){
			if (board[i][col] == 0){
				return i;
			}
		}
		return 0;
	}
	
	public boolean checkIfSpaceAvailableInColumn(int col){
		if (board[0][col] == 0){
			return true;
		}
		return false;
	}
	
	
	public int[] getNextPlayFromPlayer(Scanner in){
		int[] playersSelectedPlay= new int[2];
		boolean validPlayerSelection = false;
		do{
			System.out.print("Select column to drop next piece: ");
			if (in.hasNextInt()){
				playersSelectedPlay[1] = in.nextInt()-1;
				if (validateColumn(playersSelectedPlay[1])){
					if (checkIfSpaceAvailableInColumn(playersSelectedPlay[1])){
						playersSelectedPlay[0] = this.lastAvailableSpaceInColumn(playersSelectedPlay[1]);
						validPlayerSelection = true;
					}
					else{
						System.out.println("Column is full.");
					}
				}
			}
			else{
				System.out.println("That is not a valid choice");
				in.next();
			} 
		} while (!validPlayerSelection);
		return playersSelectedPlay;
	}

/*
	public boolean validateRow(int playersSelectedPlay){
		if (playersSelectedPlay[1] < 0 || playersSelectedPlay[1] > LAST_COL || playersSelectedPlay[0] < 0){
			System.out.println("That is not a valid column or column is full.");	
			System.out.print("Select column to drop next piece: ");
			return false;
		}
		return true;
	}
*/	
	public boolean validateColumn(int playersSelectedColumn){
		if (playersSelectedColumn < 0 || playersSelectedColumn > LAST_COL){
			System.out.println("That is not a valid column.");	
			return false;
		}
		return true;
	}
/*
	public boolean validateCoordinates(int playersSelectedPlay){
		if (playersSelectedPlay[1] < 0 || playersSelectedPlay[1] > LAST_COL || playersSelectedPlay[0] < 0){
			System.out.println("That is not a valid column or column is full.");	
			System.out.print("Select column to drop next piece: ");
			return false;
		}
		return true;
	}
*/	
	
	
	
	public boolean checkIfGameIsADraw(){
		for (int i = 0; i <= LAST_COL; i++){
			if (board[0][i] == 0){
				return false;
			}
		}	
		System.out.println("It's a draw! No more valid spots.");
		return true;
	}
		
	public void addPiece(int playerTurn, int[] nextPlay){
		if (playerTurn == -1){
			System.out.println("Player 1's turn (X)");
		}
		else{
			System.out.println("Player 2's turn (O)");

		}
		board[nextPlay[0]][nextPlay[1]] = playerTurn;
		System.out.println("You added a piece to column: " + (nextPlay[1]+1));		
	}
	
	public boolean checkIfWinner(int player){
		//for each space
		for (int x = 0; x <= LAST_ROW; x++){
			for (int y = 0; y <= LAST_COL; y++){
				if (checkAllPossibleWaysToWinFromGivenCoorindates(x,y, player)){
					if (player == -1){
						System.out.println("Player 1 is the winner!");
					}
					else{
						System.out.println("Player 2 is the winner!");

					}
					return true;
				}
			}
		}
		System.out.println("No winner yet");
		return false;	
	}
	
	private boolean checkAllPossibleWaysToWinFromGivenCoorindates(int i, int j, int playerTurn){
		int counter = 0;
		if (j+3 <= LAST_COL){ //check if winner directly to the right
			for (int x = j; x <= j+3; x++){
				if (board[i][x] != playerTurn){
					//not matching
					break;
				}
				else{
					counter++;
				}
				//what to do if they are all matching
			}
			if (counter == LENGTH_TO_WIN){
				return true;
			}
			counter = 0;
		}
		if (i+3 <= LAST_ROW){ //check if winner directly down
			for (int x = i; x <= i+3; x++){
				if (board[x][j] != playerTurn){
					//not matching
					break;
				}
				else{
					counter++;
				}
				//what to do if they are all matching
			}
			if (counter == LENGTH_TO_WIN){
				return true;
			}
			counter = 0;
		}
		if (j-3 >= 0){ // check if winner directly left
			for (int x = j; x >= 0; x--){
				if (board[i][x] != playerTurn){
					//not matching
					break;
				}
				else{
					counter++;
				}
				//what to do if they are all matching
			}
			if (counter == LENGTH_TO_WIN){
				return true;
			}
			counter = 0;
		}
		if (i-3 >= 0){// check if winner directly up
			for (int x = i; x >= 0; x--){
				if (board[x][j] != playerTurn){
					//not matching
					break;
				}
				else{
					counter++;
				}
				//what to do if they are all matching
			}
			if (counter == LENGTH_TO_WIN){
				return true;
			}
			counter = 0;
		}
		if (j-3 >= 0 && i-3 >= 0){ // check if winner diagonally left and up
			int y = j;
			for (int x = i; x >= i-3; x--){
				if (board[x][y] != playerTurn){
					//not matching
					break;
				}
				else{
					counter++;
					y--;
				}
				//what to do if they are all matching
			}
			if (counter == LENGTH_TO_WIN){
				return true;
			}
			counter = 0;
		}
		if (i-3 >= 0 && j+3 <= LAST_COL){// check if winner diagonally up and right
			int y = j;
			for (int x = i; x >= i-3; x--){
				if (board[x][y] != playerTurn){
					//not matching
					break;
				}
				else{
					counter++;
					y++;
				}
				//what to do if they are all matching
			}
			if (counter == LENGTH_TO_WIN){
				return true;
			}
			counter = 0;
		}
		if (i+3 <= LAST_ROW && j-3 >= 0){ //check if winner diagonally down and left
			int y = j;
			for (int x = i; x <= i+3; x++){
				if (board[x][y] != playerTurn){
					//not matching
					break;
				}
				else{
					counter++;
					y--;
				}
				//what to do if they are all matching
			}
			if (counter == LENGTH_TO_WIN){
				return true;
			}
			counter = 0;
		}
		if (j+3 <= LAST_COL && i+3 <= LAST_ROW){ //check if winner diagonally right and down
			int y = j;
			for (int x = i; x <= i+3; x++){
				if (board[x][y] != playerTurn){
					//not matching
					break;
				}
				else{
					counter++;
					y++;
				}
				//what to do if they are all matching
			}
			if (counter == LENGTH_TO_WIN){
				return true;
			}
			counter = 0;
		}
		return false;	
	}
	
	public String toString(){
		String visualBoard = "";
		for (int i = 0; i <= LAST_ROW; i++){
			for (int j = 0; j <= LAST_COL; j++){
				switch (board[i][j]){
				case -1: visualBoard += "[X]";
						break;
				case 1: visualBoard += "[O]";
						break;
				default: visualBoard += "[ ]";
						break;

				}
			}
			visualBoard += "\n";
		}
		return visualBoard;
	}
	
		
	public void playGame(Scanner in){
		System.out.println("Welcome to Connect 4. Player 1 goes first and is 'X's. Player 2 is 'O's");
		
		boolean isWinner = false;
		boolean isGameADraw = false;
		int playerPiece = -1;
		while (!isWinner && !isGameADraw){
			int[] nextPlay = this.getNextPlayFromPlayer(in);
			this.addPiece(playerPiece, nextPlay);
			System.out.println(this.toString());
			isWinner = this.checkIfWinner(playerPiece);
			isGameADraw = this.checkIfGameIsADraw();
			playerPiece = playerPiece * -1;
		}
	}
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		ConnectFour board3 = new ConnectFour();
		board3.playGame(in);
		in.close();
		
	}

	
	
	
}
