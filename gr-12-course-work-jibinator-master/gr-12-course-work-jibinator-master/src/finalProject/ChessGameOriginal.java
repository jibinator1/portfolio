package finalProject;
import cc4.Card;
import finalProject.ChessPiece;
import javafx.application.Application; 
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

public class ChessGame extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		ChessPiece bPawn = new ChessPiece("pawn", 'b');//black pawn (B for black)
		ChessPiece wPawn = new ChessPiece("pawn", 'w');//white pawn (W for white)
		ChessPiece bRook = new ChessPiece("pawn", 'b');//black Rook (B for black)
		ChessPiece wRook = new ChessPiece("pawn", 'w');//white Rook (W for white)
		ChessPiece bBishop = new ChessPiece("pawn", 'b');//black Bishop (B for black)
		ChessPiece wBishop = new ChessPiece("pawn", 'w');//white Bishop (W for white)
		ChessPiece bKnight = new ChessPiece("pawn", 'b');//black Knight (B for black)
		ChessPiece wKnight = new ChessPiece("pawn", 'w');//white Knight (W for white)
		ChessPiece bQueen = new ChessPiece("pawn", 'b');//black Queen (B for black)
		ChessPiece wQueen = new ChessPiece("pawn", 'w');//white Queen (W for white)
		ChessPiece bKing = new ChessPiece("pawn", 'b');//black King (B for black)
		ChessPiece wKing = new ChessPiece("pawn", 'w');//white King (W for white)
		//Creating a Grid Pane 
		GridPane board = new GridPane();    
		board.setMinSize(200, 200); 
		board.setAlignment(Pos.CENTER); 


		primaryStage.setTitle("Solitaire Chess");//sets the title of the stage

		Button btn1 = new Button("Level 1");
		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				levelOne(primaryStage, wPawn, bKing);//calls level 1 method
			}
		});
		Button btn2 = new Button("Level 2");
		btn2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				levelTwo(primaryStage);//calls level 2 method
			}
		});
		Button btn3 = new Button("Level 3");
		btn3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				levelThree(primaryStage);// calls level 3 method
			}
		});
		Button btn4 = new Button("Level 4");
		btn4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				levelFour(primaryStage);//calls level 4 method
			}
		});
		Button btn5 = new Button("Level 5");
		btn5.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				levelFive(primaryStage);//calls the level 5 method
			}
		});

		board.add(btn1, 1,0);
		board.add(btn2, 2, 0);
		board.add(btn3, 3, 0);
		board.add(btn4, 4, 0);
		board.add(btn5, 5, 0);

		primaryStage.setScene(new Scene(board, 1024, 576));
		primaryStage.show();
	}
	public static GridPane chessBoard(Stage stage) {
		//Creating a Grid Pane 
		GridPane chessBoard = new GridPane();    
		chessBoard.setMinSize(200, 200); 
		chessBoard.setAlignment(Pos.CENTER); 
		return chessBoard;

	}
	public static GridPane level1ChessBoard(Stage stage, Group pawnBlack, int x1, int y1,Group queenBlack, int x2, int y2, Group bishopBlack, int x3, int y3, Group knightBlack, int x4, int y4, Group pawnWhite, Group queenWhite, Group knightWhite, Group bishopWhite) {

		//Creating a Grid Pane 
		GridPane chessBoard = new GridPane();    
		chessBoard.setMinSize(200, 200); 
		chessBoard.setAlignment(Pos.CENTER); 
		Rectangle square1 = new Rectangle(100, 100, 100, 100);
		Rectangle square2 = new Rectangle(100, 100, 100, 100);
		Rectangle square3 = new Rectangle(100, 100, 100, 100);
		Rectangle square4 = new Rectangle(100, 100, 100, 100);
		Rectangle square5 = new Rectangle(100, 100, 100, 100);
		Rectangle square6 = new Rectangle(100, 100, 100, 100);
		Rectangle square7 = new Rectangle(100, 100, 100, 100);
		Rectangle square8 = new Rectangle(100, 100, 100, 100);
		Rectangle square9 = new Rectangle(100, 100, 100, 100);
		Rectangle square10 = new Rectangle(100, 100, 100, 100);
		Rectangle square11 = new Rectangle(100, 100, 100, 100);
		Rectangle square12 = new Rectangle(100, 100, 100, 100);
		Rectangle square13 = new Rectangle(100, 100, 100, 100);
		Rectangle square14 = new Rectangle(100, 100, 100, 100);
		Rectangle square15 = new Rectangle(100, 100, 100, 100);
		Rectangle square16 = new Rectangle(100, 100, 100, 100);
		square1.setFill(Color.BROWN);
		square3.setFill(Color.BROWN);
		square6.setFill(Color.BROWN);
		square8.setFill(Color.BROWN);
		square9.setFill(Color.BROWN);
		square11.setFill(Color.BROWN);
		square14.setFill(Color.BROWN);
		square16.setFill(Color.BROWN);
		square2.setFill(Color.GRAY);
		square4.setFill(Color.GRAY);
		square5.setFill(Color.GRAY);
		square7.setFill(Color.GRAY);
		square10.setFill(Color.GRAY);
		square12.setFill(Color.GRAY);
		square13.setFill(Color.GRAY);
		square15.setFill(Color.GRAY);

		chessBoard.add(square1,1,0);
		chessBoard.add(square2,2,0);
		chessBoard.add(square3,3,0);
		chessBoard.add(square4,4,0);//first row of squares
		chessBoard.add(square5,1,1);
		chessBoard.add(square6,2,1);
		chessBoard.add(square7,3,1);
		chessBoard.add(square8,4,1);//second row of squares
		chessBoard.add(square9,1,2);
		chessBoard.add(square10,2,2);
		chessBoard.add(square11,3,2);
		chessBoard.add(square12,4,2);//first row of squares
		chessBoard.add(square13,1,3);
		chessBoard.add(square14,2,3);
		chessBoard.add(square15,3,3);
		chessBoard.add(square16,4,3);//first row of squares
		Button[][] tile = new Button[4][5];
		chessBoard.add(pawnBlack, x1, y1);//adds the piecs to the baord
		chessBoard.add(queenBlack, x2, y2);
		chessBoard.add(bishopBlack, x3, y3);
		chessBoard.add(knightBlack, x4, y4);
		pawnBlack.setTranslateX(10);//this centers the pieces
		queenBlack.setTranslateX(10);
		bishopBlack.setTranslateX(10);
		knightBlack.setTranslateX(10);
		for (int row = 0; row < 4; row++) {
			for (int col = 1; col < 5; col++) {
				Button button = new Button();
				button.setMinSize(100, 100);
				tile[row][col] = button; // 2D array of buttons on the same grid as the chessboard
				button.setStyle("-fx-background-color: rgba(0, 0, 0, 0.0);"); //so it shows the button when i need to(change final value 0.0 - 1.0)
				chessBoard.add(button, col, row); // Add the button to the grid pane

				final int currentRow = row;
				final int currentCol = col;
				button.setOnAction(event -> {
					int boardRow = chessBoard.getRowIndex(tile[currentRow][currentCol]);
					int boardCol = chessBoard.getColumnIndex(tile[currentRow][currentCol]);

					System.out.println("row: " + currentRow + ", column: " + (currentCol-1));
if (x1==currentCol&&y1==currentRow||x2==currentCol&&y2==currentRow||x3==currentCol&&y3==currentRow||x4==currentCol&&y4==currentRow) {
						System.out.println("There is a chess piece");
						
					}
//make an array with the white version name? using this I can know if the array.length is larger than 1 to see if there is already an existing highlighted piece and if there is, then remove the the 
//ex: (maybe just a group varaiable? 
/*pseudo code: group whitePiece = pawn
 * if (whitePiece == pawn) check all of them:
 * if one of them is true, they the pawn is reverted to black again and the one you want is turned white?
 * */
					if(x1==currentCol&&y1==currentRow) {//if the pawn position is clicked
						chessBoard.getChildren().remove(pawnBlack);
						chessBoard.add(pawnWhite, x1, y1);
						pawnWhite.setTranslateX(10);

						
					}
					if(x2==currentCol&&y2==currentRow) {
						chessBoard.getChildren().remove(queenBlack);
						chessBoard.add(queenWhite, x2, y2);
						queenWhite.setTranslateX(10);
					}
					if(x3==currentCol&&y3==currentRow) {
						chessBoard.getChildren().remove(bishopBlack);
						chessBoard.add(bishopWhite, x3, y3);
						bishopWhite.setTranslateX(10);
					}
					if(x4==currentCol&&y4==currentRow) {
						chessBoard.getChildren().remove(knightBlack);
						chessBoard.add(knightWhite, x4, y4);
						knightWhite.setTranslateX(10);
					}
				});
			}
		}
		
		return chessBoard;

	}

	public static void levelOne(Stage stage, ChessPiece wPawn, ChessPiece bKing) {
		ChessPiece blackPawn = new ChessPiece("pawn", 'b');//black pawn
		Group pawnWhite = ChessPiece.createPiece(blackPawn);
		ChessPiece pawn = new ChessPiece("pawn", 'W');//white pawn
		Group pawnW = ChessPiece.createPiece(pawn);
		ChessPiece blackQueen = new ChessPiece("queen", 'b');//black queen
		Group queenWhite = ChessPiece.createPiece(blackQueen);
		ChessPiece queen = new ChessPiece("queen", 'W');//white queen
		Group queenW = ChessPiece.createPiece(queen);
		ChessPiece blackKnight = new ChessPiece("knight", 'b');//black knight
		Group knightWhite = ChessPiece.createPiece(blackKnight);
		ChessPiece knight = new ChessPiece("knight", 'W');//white knight
		Group knightW = ChessPiece.createPiece(knight);
		ChessPiece blackBishop = new ChessPiece("bishop", 'b');//black bishop
		Group bishopWhite = ChessPiece.createPiece(blackBishop);
		ChessPiece bishop = new ChessPiece("bishop", 'W');//white bishop
		Group bishopW = ChessPiece.createPiece(bishop);
		GridPane chessBoard = level1ChessBoard(stage, pawnWhite, 3, 0, queenWhite,3, 3, bishopWhite, 2, 1, knightWhite, 1, 1, pawnW, queenW, knightW, bishopW);
		HBox root = new HBox(chessBoard);
		Scene game = new Scene(root, 1024, 576);
		stage.setScene(game);
		stage.show();

	}
	public static void levelTwo(Stage stage) {
		Scene chessBoard = new Scene(chessBoard(stage),  1024, 576);//in order to set the chessBoard as the new scene so it can swap to it after clicking thebutton	
		stage.setScene(chessBoard);
		stage.show();

	}
	public static void levelThree(Stage stage) {
		Scene chessBoard = new Scene(chessBoard(stage),  1024, 576);//in order to set the chessBoard as the new scene so it can swap to it after clicking thebutton	
		stage.setScene(chessBoard);
		stage.show();

	}
	public static void levelFour(Stage stage) {
		Scene chessBoard = new Scene(chessBoard(stage),  1024, 576);//in order to set the chessBoard as the new scene so it can swap to it after clicking thebutton	
		stage.setScene(chessBoard);
		stage.show();

	}
	public static void levelFive(Stage stage) {
		Scene chessBoard = new Scene(chessBoard(stage),  1024, 576);//in order to set the chessBoard as the new scene so it can swap to it after clicking thebutton	
		stage.setScene(chessBoard);
		stage.show();

	}
}