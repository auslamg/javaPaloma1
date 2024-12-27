package clase.tictactoe;

import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings("unused")
public final class TicTacToeGame {

	Square n = new Square();

	Square[][] board = new Square[3][3];

	public TicTacToeGame() {
		for (int col = 0; col < 3; col++) {
			for (int row = 0; row < 3; row++) {
				board[col][row] = new Square();
			}
		}
    }

	public static void main(String[] args) {
		TicTacToeGame game = new TicTacToeGame();

		game.DisplayBoard();
		boolean turnO = true;

		while (!game.isVictory()) {
			//Turn Player O
			if (turnO) {
				int[] coords = game.ReadInput(Team.O);
				game.PlacePiece(coords, Team.O);
			}
			//Turn player X
			else {
				int[] coords = game.ReadInput(Team.X);
				game.PlacePiece(coords, Team.X);
			}
			//Change turn
			game.DisplayBoard();
			turnO = !turnO;	
		}
		System.out.println("");
		if (game.threeInARow(Team.O)) {
			System.out.println("Player O won!");
		}
		else {
			System.out.println("Player X won!");
		}
	}

	int[] ReadInput(Team pieceTeam) {
		String input;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Player " + pieceTeam.name() + ", state your move position (type /help for help)");
		input = scanner.nextLine();

		int[] coords = new int[2];

		switch (input) {
			case "/help" -> {
				System.out.println("Type the number you see on the right board where you want to put your piece");
				DisplayBoard();
				return ReadInput(pieceTeam);
			}

			case "1" -> coords = new int[]{0,0};
			case "2" -> coords = new int[]{0,1};
			case "3" -> coords = new int[]{0,2};
			case "4" -> coords = new int[]{1,0};
			case "5" -> coords = new int[]{1,1};
			case "6" -> coords = new int[]{1,2};
			case "7" -> coords = new int[]{2,0};
			case "8" -> coords = new int[]{2,1};
			case "9" -> coords = new int[]{2,2};

			default -> {
                            System.out.println("Invalid input. Type /help for help");
							DisplayBoard();
							return ReadInput(pieceTeam);
                }
		}
		if (isAvailable(coords)) {
			System.out.println("=======================================================");
			return coords;
		}
		else {
			System.out.println("Square is unavailable. Choose a different position");
			DisplayBoard();
			return ReadInput(pieceTeam);
		}
	}

	boolean isAvailable(int[] coords) {
		return board[coords[0]][coords[1]].piece == null;
	}

	void PlacePiece(int[] coords, Team pieceTeam) {
		board[coords[0]][coords[1]].piece = new Piece(pieceTeam);
	}

	void DisplayBoard() {
		//For each row
		for (int row = 0; row < 3; row++) {
			//For each character in the row
			for (int col = 0; col < 3; col++) {
				Piece p = board[row][col].piece;
				if (p!= null) {
					System.out.print(p.team + " ");
				}
				else {
					System.out.print("_ ");
				}
			}
			DisplayHelpBoard(row);
			//Jump line
			System.out.println();
		}		
	}

	void DisplayHelpBoard(int row) {
		switch (row) {
			case 0 -> System.out.print("\t\t 1 2 3");
			case 1 -> System.out.print("\t\t 4 5 6");
			case 2 -> System.out.print("\t\t 7 8 9");
		}
	}

	boolean isVictory() {
		return threeInARow(Team.O) || threeInARow(Team.X);
	}
	
	boolean threeInARow(Team team) {

		int countOnThisLine = 0;

		//For each column
		for (int col = 0; col < 3; col++) {
			//Clear list
			ArrayList<Piece> checkPieces = new ArrayList<>();

			//Check every row
			for (int row = 0; row < 3; row++) {
				Piece p = board[col][row].piece;				
				checkPieces.add(p);		
			}

			//Check if new list is valid
			if (isSameTeam(checkPieces, team)) {
				return true;
			}
		}

		//For each row
		for (int row = 0; row < 3; row++) {
			//Clear list
			ArrayList<Piece> checkPieces = new ArrayList<>();

			//Check every column
			for (int col = 0; col < 3; col++) {
				Piece p = board[col][row].piece;				
				checkPieces.add(p);		
			}

			//Check if new list is valid
			if (isSameTeam(checkPieces, team)) {
				return true;
			}
		}

		//For each diagonal
		for (int diagonal = 0; diagonal < 2; diagonal++) {
			//Left diagonal
			if (diagonal == 0) {
				//Clear list
				ArrayList<Piece> checkPieces = new ArrayList<>();

				//Check every diagonal square
				for (int j = 0; j < 3; j++) {
					Piece p = board[j][j].piece;				
					checkPieces.add(p);
				}

				//Check if new list is valid
				if (isSameTeam(checkPieces, team)) {
					return true;
				}					
			}
			//Right diagonal
			else {
				//Clear list
				ArrayList<Piece> checkPieces = new ArrayList<>();

				//Check every diagonal square
				for (int j = 0; j < 3; j++) {
					Piece p = board[2 - j][j].piece;				
					checkPieces.add(p);
				}

				//Check if new list is valid
				if (isSameTeam(checkPieces, team)) {
					return true;
				}	
			}			
		}
		return false;
	}

	boolean isSameTeam(ArrayList<Piece> pieces, Team team) {
		for (Piece p : pieces) {
			if (p == null || p.team != team) {
				return false;
			}
		}
		return true;
	}

}

class Square {

	Piece piece;
	
    public Square() {
		this(null);
		//this(new Piece(Team.O));
    }
	public Square(Piece piece) {
		this.piece = piece;
    }
	
}

class Piece {
	Team team;
	int[] coords;

    public Piece(Team team) {
		this.team = team;
		coords = new int[2];
    }	
}

enum Team {
	X,
	O
}	
