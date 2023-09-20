package finalProject;

import java.util.concurrent.TimeUnit;

import finalProject.ChessPiece;
import finalProject.ChessPieceButton;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class ChessGame extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	public static int whitePawn = 0;
	public static int whiteQueen = 0;
	public static int whiteBishop = 0;
	public static int whiteKnight = 0;
	public static int deadNum = 0;

	public static int pawn1a = 0;
	public static int pawn2a = 0;
	public static int bishop1a = 0;
	public static int bishop2a = 0;
	public static int knight1a = 0;
	public static int rook1a = 0;
	public static int knight2a = 0;
	public static int rook2a = 0;
	public static int knighta = 0;
	public static int rooka = 0;

	@Override
	public void start(Stage primaryStage) {

		levelMenu(primaryStage);
	}

	public static void levelMenu(Stage primaryStage) {
		ChessPiece bPawn = new ChessPiece("pawn", 'b');// black pawn (B for black)
		ChessPiece wPawn = new ChessPiece("pawn", 'w');// white pawn (W for white)
		ChessPiece bRook = new ChessPiece("pawn", 'b');// black Rook (B for black)
		ChessPiece wRook = new ChessPiece("pawn", 'w');// white Rook (W for white)
		ChessPiece bBishop = new ChessPiece("pawn", 'b');// black Bishop (B for black)
		ChessPiece wBishop = new ChessPiece("pawn", 'w');// white Bishop (W for white)
		ChessPiece bKnight = new ChessPiece("pawn", 'b');// black Knight (B for black)
		ChessPiece wKnight = new ChessPiece("pawn", 'w');// white Knight (W for white)
		ChessPiece bQueen = new ChessPiece("pawn", 'b');// black Queen (B for black)
		ChessPiece wQueen = new ChessPiece("pawn", 'w');// white Queen (W for white)
		ChessPiece bKing = new ChessPiece("pawn", 'b');// black King (B for black)
		ChessPiece wKing = new ChessPiece("pawn", 'w');// white King (W for white)
		// Creating a Grid Pane
		GridPane board = new GridPane();
		board.setMinSize(200, 200);
		board.setAlignment(Pos.CENTER);

		primaryStage.setTitle("Solitaire Chess");// sets the title of the stage

		Button btn1 = new Button("Level 1");
		btn1.setStyle("-fx-background-color: #008000; ");
		btn1.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				levelOne(primaryStage);// calls level 1 method
			}
		});
		Button btn2 = new Button("Level 2");
		btn2.setStyle("-fx-background-color: #FFFF00; ");
		btn2.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				levelTwo(primaryStage);// calls level 2 method
			}
		});
		Button btn3 = new Button("Level 3");
		btn3.setStyle("-fx-background-color: #FFA500; ");
		btn3.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				levelThree(primaryStage);// calls level 3 method
			}
		});
		Button btn4 = new Button("Level 4");
		btn4.setStyle("-fx-background-color: #ff0000; ");
		btn4.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				levelFour(primaryStage);// calls level 4 method
			}
		});
		Text restartInfo = new Text("Tip: Press r to reset and restart the level!");
		restartInfo.setScaleX(1.5);
		restartInfo.setScaleY(1.5);

		board.add(restartInfo, 20, 1);
		restartInfo.setTranslateX(-190);
		restartInfo.setTranslateY(-60);
		board.add(btn1, 1, 0);
		board.add(btn2, 2, 0);
		board.add(btn3, 3, 0);
		board.add(btn4, 4, 0);

		primaryStage.setScene(new Scene(board, 1024, 576));
		primaryStage.show();

	}

	public static boolean checkPawn(int pawnx, int pawny, int secondPieceX, int secondPieceY) {// check if I can move
		// the pawn
		if (secondPieceX == pawnx + 1 && secondPieceY == pawny - 1
				|| secondPieceX == pawnx - 1 && secondPieceY == pawny - 1) {
			return true;
		}
		return false;

	}

	public static boolean checkBishop(int bishopx, int bishopy, int secondPieceX, int secondPieceY, int[] xPieces,
			int[] yPieces) {// check if I can
		System.out.println(secondPieceX + " " + secondPieceY + "   " + bishopx + " " + bishopy);
		// move the bishop
		for (int i = -1; i < 4; i++) {
			int x = 0;
			// topleft direction
			if (bishopx == secondPieceX + i && bishopy == secondPieceY + i) {
				for (int j = 0; j < xPieces.length; j++) {// it has to check whether there is a piece in front of it for
															// lv 4. as I shouldnt be able to capture a knight behind a
															// pawn
					if (bishopx - j != xPieces[j] && bishopy - j != yPieces[j]) {
						x++;
						if (x == xPieces.length) {
							return true;
						}
					}
				}
			}

			// Top right direction
			if (bishopx == secondPieceX + i && bishopy == secondPieceY - i) {
				System.out.println("hi");
			    for (int j = 0; j < xPieces.length; j++) {
			        if (bishopx - j != xPieces[j] && bishopy + j != yPieces[j]) {
			            x++;
			            if (x == xPieces.length) {
			                return true;
			            }
			        }
			    }
			}


			// bottom left direction
			if (bishopx == secondPieceX - i && bishopy == secondPieceY + i) {
				for (int j = 0; j < xPieces.length; j++) {// it has to check whether there is a piece in front of it for
															// lv 4. as I shouldn't be able to capture a knight behind a
															// pawn
					if (bishopx + j != xPieces[j] && bishopy - j != yPieces[j]) {
						x++;
						if (x == xPieces.length) {
							return true;
						}
					}
				}
			}

			// bottomright direction
			if (bishopx == secondPieceX - i && bishopy == secondPieceY - i) {
				for (int j = 0; j < xPieces.length; j++) {// it has to check whether there is a piece in front of it for
															// lv 4. as I shouldnt be able to capture a knight behind a
															// pawn
					if (bishopx + j != xPieces[j] && bishopy + j != yPieces[j]) {
						x++;
						if (x == xPieces.length) {
							return true;
						}
					}
				}
			}
		}

		return false;
	}

	public static boolean checkKnight(int knightx, int knighty, int secondPieceX, int secondPieceY) {
		if (knightx == secondPieceX - 2 && knighty == secondPieceY + 1
				|| knightx == secondPieceX - 2 && knighty == secondPieceY - 1) {
			return true;
		} else if (knightx == secondPieceX + 2 && knighty == secondPieceY + 1
				|| knightx == secondPieceX + 2 && knighty == secondPieceY - 1) {
			return true;
		} else if (knightx == secondPieceX - 1 && knighty == secondPieceY + 2
				|| knightx == secondPieceX + 1 && knighty == secondPieceY + 2) {
			return true;
		} else if (knightx == secondPieceX - 1 && knighty == secondPieceY - 2
				|| knightx == secondPieceX + 1 && knighty == secondPieceY - 2) {
			return true;
		}

		return false;

	}

	public static boolean checkQueen(int queenx, int queeny, int secondPieceX, int secondPieceY, int[] xPieces,
			int[] yPieces) {
		for (int i = 1; i < 4; i++) {
			if (queenx == secondPieceX + i && queeny == secondPieceY + i) {
					return true;
				
			} else if (queenx == secondPieceX - i && queeny == secondPieceY - i) {
					return true;
				
			} else if (queenx == secondPieceX + i && queeny == secondPieceY - i) {
					return true;
				
			} else if (queenx == secondPieceX - i && queeny == secondPieceY + i) {
					return true;
				
			}
			if (queenx == secondPieceX && queeny != secondPieceY) {// if it can move horizontally
					return true;
				
			}
			if (queenx != secondPieceX && queeny == secondPieceY) {// if it can move vertically
					return true;
				
			}
		}
		return false;
	}

	public static boolean checkRook(int rookx, int rooky, int secondPieceX, int secondPieceY) {
		if (rookx == secondPieceX && rooky != secondPieceY) {// if it can move horizontally
			return true;
		}
		if (rookx != secondPieceX && rooky == secondPieceY) {// if it can move vertically
			return true;
		}
		return false;
	}

	private static void winScreen(Stage stage) {
		pawn1a = 0;
		pawn2a = 0;
		bishop1a = 0;
		bishop2a = 0;
		knight1a = 0;
		rook1a = 0;
		knight2a = 0;
		rook2a = 0;
		knighta = 0;
		rooka = 0;
		whitePawn = 0;
		whiteQueen = 0;
		whiteBishop = 0;
		whiteKnight = 0;
		deadNum = 0;
		Text text = new Text(250, 250, "YOU WON!!");
		text.setFont(Font.font("Comic Sans MS", 20));
		text.setFill(Color.BLUE);
		text.setTranslateX(250);
		text.setTranslateY(250);
		Text partyPopper = new Text(100, 400, "\uD83C\uDF89");
		partyPopper.setFont(Font.font("Comic Sans MS", 40));
		/*
		 * TranslateTransition dots = new TranslateTransition();
		 * dots.setDuration(Duration.millis(1000)); dots.setByX(-250); dots.play();
		 * partyPopper.setTranslateX(100); partyPopper.setTranslateY(400); add if i have
		 * time
		 */ HBox root = new HBox(text, partyPopper);

		Scene scene = new Scene(root, 500, 500, Color.BLACK);
		// Setting title to the Stage
		stage.setTitle("YOU'RE A WINNERRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR");
		// Adding scene to the stage
		stage.setScene(scene);
		// Displaying the contents of the stage
		scene.addEventFilter(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent mouseEvent) {
				levelMenu(stage);
			}
		});

	}

	public static GridPane level1ChessBoard(Stage stage, Button pawnBlack, Button queenBlack, Button bishopBlack,
			Button knightBlack, Button pawnWhite, Button queenWhite, Button knightWhite, Button bishopWhite) {

		int[] xValues = { 3, 3, 2, 1 };
		int[] yValues = { 0, 3, 1, 1 };
		// Creating a Grid Pane
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

		chessBoard.add(square1, 1, 0);
		chessBoard.add(square2, 2, 0);
		chessBoard.add(square3, 3, 0);
		chessBoard.add(square4, 4, 0);// first row of squares
		chessBoard.add(square5, 1, 1);
		chessBoard.add(square6, 2, 1);
		chessBoard.add(square7, 3, 1);
		chessBoard.add(square8, 4, 1);// second row of squares
		chessBoard.add(square9, 1, 2);
		chessBoard.add(square10, 2, 2);
		chessBoard.add(square11, 3, 2);
		chessBoard.add(square12, 4, 2);// first row of squares
		chessBoard.add(square13, 1, 3);
		chessBoard.add(square14, 2, 3);
		chessBoard.add(square15, 3, 3);
		chessBoard.add(square16, 4, 3);// first row of squares

		Button[][] tile = new Button[4][5];
		for (int row = 0; row < 4; row++) {
			for (int col = 1; col < 5; col++) {
				Button button = new Button();
				button.setMinSize(100, 100);
				tile[row][col] = button; // 2D array of buttons on the same grid as the chessboard
				button.setStyle("-fx-background-color: rgba(0, 0, 0, 0.0);"); // so it shows the button when i need
				// to(change final value 0.0 - 1.0)
				chessBoard.add(button, col, row); // Add the button to the grid pane
				final int currentRow = row;
				final int currentCol = col;
				button.setOnAction(event -> {
					if (xValues[0] != currentCol && yValues[0] != currentRow) {// if the boar dis pressed with no pieces
						// all of the pices turn black
						if (whitePawn == 1) {
							chessBoard.getChildren().remove(pawnWhite);// if white pawn is already white, make it black
							chessBoard.add(pawnBlack, xValues[0], yValues[0]);
							whitePawn = 0;
						}
						if (whiteBishop == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(bishopWhite);
							chessBoard.add(bishopBlack, xValues[2], yValues[2]);
							whiteBishop = 0;
						}
						if (whiteQueen == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(queenWhite);
							chessBoard.add(queenBlack, xValues[1], yValues[1]);
							whiteQueen = 0;
						}
						if (whiteKnight == 1) {// ssame thing as pawn bishop and queen
							chessBoard.getChildren().remove(knightWhite);
							chessBoard.add(knightBlack, xValues[3], yValues[3]);
							whiteKnight = 0;

						}

					}
					if (xValues[1] != currentCol && yValues[1] != currentRow) {
						if (whitePawn == 1) {
							chessBoard.getChildren().remove(pawnWhite);
							chessBoard.add(pawnBlack, xValues[0], yValues[0]);
							whitePawn = 0;
						}
						if (whiteBishop == 1) {
							chessBoard.getChildren().remove(bishopWhite);
							chessBoard.add(bishopBlack, xValues[2], yValues[2]);
							whiteBishop = 0;
						}
						if (whiteQueen == 1) {
							chessBoard.getChildren().remove(queenWhite);
							chessBoard.add(queenBlack, xValues[1], yValues[1]);
							whiteQueen = 0;
						}
						if (whiteKnight == 1) {
							chessBoard.getChildren().remove(knightWhite);
							chessBoard.add(knightBlack, xValues[3], yValues[3]);
							whiteKnight = 0;

						}

					}
					if (xValues[2] != currentCol && yValues[2] != currentRow) {
						if (whitePawn == 1) {
							chessBoard.getChildren().remove(pawnWhite);
							chessBoard.add(pawnBlack, xValues[0], yValues[0]);
							whitePawn = 0;
						}
						if (whiteBishop == 1) {
							chessBoard.getChildren().remove(bishopWhite);
							chessBoard.add(bishopBlack, xValues[2], yValues[2]);
							whiteBishop = 0;
						}
						if (whiteQueen == 1) {
							chessBoard.getChildren().remove(queenWhite);
							chessBoard.add(queenBlack, xValues[1], yValues[1]);
							whiteQueen = 0;
						}
						if (whiteKnight == 1) {
							chessBoard.getChildren().remove(knightWhite);
							chessBoard.add(knightBlack, xValues[3], yValues[3]);
							whiteKnight = 0;

						}

					}
					if (xValues[3] != currentCol && yValues[3] != currentRow) {
						if (whitePawn == 1) {
							chessBoard.getChildren().remove(pawnWhite);
							chessBoard.add(pawnBlack, xValues[0], yValues[0]);
							whitePawn = 0;
						}
						if (whiteBishop == 1) {
							chessBoard.getChildren().remove(bishopWhite);
							chessBoard.add(bishopBlack, xValues[2], yValues[2]);
							whiteBishop = 0;
						}
						if (whiteQueen == 1) {
							chessBoard.getChildren().remove(queenWhite);
							chessBoard.add(queenBlack, xValues[1], yValues[1]);
							whiteQueen = 0;
						}
						if (whiteKnight == 1) {
							chessBoard.getChildren().remove(knightWhite);
							chessBoard.add(knightBlack, xValues[3], yValues[3]);
							whiteKnight = 0;

						}

					}
				});
			}
		}

		Button[] deadPiece = new Button[4];// might not need this but but an array for dead pieces on the board

		chessBoard.add(pawnBlack, xValues[0], yValues[0]);// adds the piecs to the board
		chessBoard.add(queenBlack, xValues[1], yValues[1]);
		chessBoard.add(bishopBlack, xValues[2], yValues[2]);
		chessBoard.add(knightBlack, xValues[3], yValues[3]);

		pawnBlack.setOnAction(event -> {// if pawnBlack is pressed
			System.out.println("There is a black Pawn here");

			if (whitePawn == 0) {// pawn
				chessBoard.getChildren().remove(pawnBlack);
				chessBoard.add(pawnWhite, xValues[0], yValues[0]);
				whitePawn = 1;

			}
			if (whiteQueen == 1) {// if queen is already white
				chessBoard.getChildren().remove(queenWhite);
				chessBoard.add(queenBlack, xValues[1], yValues[1]);
				if (checkQueen(xValues[1], yValues[1], xValues[0], yValues[0], xValues, yValues) == true) {
					chessBoard.getChildren().remove(queenBlack);
					xValues[1] = xValues[0];// makes the x value of the taking piece into the x value of taken piece
					yValues[1] = yValues[0];// same thing but for y
					chessBoard.add(queenBlack, xValues[0], yValues[0]);
					chessBoard.getChildren().remove(pawnBlack);
					chessBoard.getChildren().remove(pawnWhite);
					deadNum = deadNum + 1;
					deadPiece[0] = pawnBlack;// since pawn is captured, pawn is added to the dead piece array, etc
					whiteQueen = 0;
					whitePawn = 0;// testing this becuase nothing is wokring AHHHHHHHHHH
					/*
					 * chessBoard.getChildren().remove(pawnBlack); chessBoard.add(pawnWhite,
					 * xValues[0], yValues[0]); pawnWhite.setTranslateX(10); whitePawn=1;
					 */
				}
				whiteQueen = 0;
				if (deadNum == 3) {
					winScreen(stage);
				}
			}
			if (whiteBishop == 1) {// if bishop is already white
				chessBoard.getChildren().remove(bishopWhite);
				chessBoard.add(bishopBlack, xValues[2], yValues[2]);
				if (checkBishop(xValues[2], yValues[2], xValues[0], yValues[0], xValues, yValues) == true) {// if its a
																											// legal
																											// move
					chessBoard.getChildren().remove(bishopBlack);
					xValues[2] = xValues[0];
					yValues[2] = yValues[0];
					chessBoard.add(bishopBlack, xValues[0], yValues[0]);
					whiteBishop = 0;
					chessBoard.getChildren().remove(pawnBlack);
					chessBoard.getChildren().remove(pawnWhite);
					deadPiece[0] = pawnBlack;
					whitePawn = 0;
					deadNum = deadNum + 1;
				}
				whiteBishop = 0;
				if (deadNum == 3) {
					winScreen(stage);
				}
				/*
				 * chessBoard.getChildren().remove(pawnBlack); chessBoard.add(pawnWhite,
				 * xValues[0], yValues[0]); pawnWhite.setTranslateX(10); whitePawn=1;
				 */
			}
			if (whiteKnight == 1) {// if knight is already white
				chessBoard.getChildren().remove(knightWhite);
				chessBoard.add(knightBlack, xValues[3], yValues[3]);
				if (checkKnight(xValues[3], yValues[3], xValues[0], yValues[0]) == true) {// if knight is able to be
					// captured
					chessBoard.getChildren().remove(knightBlack);
					xValues[3] = xValues[0];
					yValues[3] = yValues[0];
					chessBoard.add(knightBlack, xValues[0], yValues[0]);
					whiteKnight = 0;
					chessBoard.getChildren().remove(pawnBlack);
					chessBoard.getChildren().remove(pawnWhite);
					deadPiece[0] = pawnBlack;
					whitePawn = 0;
					deadNum = deadNum + 1;
				}
				whiteKnight = 0;
				if (deadNum == 3) {
					winScreen(stage);
				}
				/*
				 * chessBoard.getChildren().remove(pawnBlack); chessBoard.add(pawnWhite,
				 * xValues[0], yValues[0]); pawnWhite.setTranslateX(10); whitePawn=1;
				 */

			}
		});

		queenBlack.setOnAction(event -> {// if queenBlack is pressed
			System.out.println("There is a black Queen here");
			if (whiteQueen == 0 && whiteBishop != 1 && whiteKnight != 1 && whitePawn != 1) {// queen
				chessBoard.getChildren().remove(queenBlack);
				chessBoard.add(queenWhite, xValues[1], yValues[1]);
				whiteQueen = 1;
			}
			if (whiteBishop == 1) {
				chessBoard.getChildren().remove(bishopWhite);
				chessBoard.add(bishopBlack, xValues[2], yValues[2]);
				if (checkBishop(xValues[2], yValues[2], xValues[1], yValues[1], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishopBlack);
					xValues[2] = xValues[1];
					yValues[2] = yValues[1];
					chessBoard.add(bishopBlack, xValues[1], yValues[1]);
					chessBoard.getChildren().remove(queenBlack);
					chessBoard.getChildren().remove(queenWhite);
					deadPiece[1] = queenBlack;
					deadNum = deadNum + 1;
					whiteBishop = 0;
					whiteQueen = 0;
				}
				whiteBishop = 0;
				if (deadNum == 3) {
					winScreen(stage);
				}
				/*
				 * chessBoard.getChildren().remove(queenBlack); chessBoard.add(queenWhite,
				 * xValues[0], yValues[0]); queenWhite.setTranslateX(10); whiteQueen=1;
				 */
			}
			if (whiteKnight == 1) {
				chessBoard.getChildren().remove(knightWhite);
				chessBoard.add(knightBlack, xValues[3], yValues[3]);
				if (checkKnight(xValues[3], yValues[3], xValues[1], yValues[1]) == true) {
					chessBoard.getChildren().remove(knightBlack);

					xValues[3] = xValues[1];
					yValues[3] = yValues[1];
					System.out.println(xValues[3] + " " + yValues[3]);

					chessBoard.add(knightBlack, xValues[3], yValues[3]);
					deadNum = deadNum + 1;
					chessBoard.getChildren().remove(queenBlack);
					chessBoard.getChildren().remove(queenWhite);
					deadPiece[1] = queenBlack;
					whiteKnight = 0;
					whiteQueen = 0;
				}
				whiteKnight = 0;
				if (deadNum == 3) {
					winScreen(stage);
				}
				/*
				 * chessBoard.getChildren().remove(queenBlack); chessBoard.add(queenWhite,
				 * xValues[0], yValues[0]); queenWhite.setTranslateX(10); whiteQueen=1;
				 */

			}
			if (whitePawn == 1) {
				chessBoard.getChildren().remove(pawnWhite);
				chessBoard.add(pawnBlack, xValues[0], yValues[0]);
				if (checkPawn(xValues[0], yValues[0], xValues[1], yValues[1]) == true) {
					xValues[0] = xValues[1];
					yValues[0] = yValues[1];
					chessBoard.getChildren().remove(pawnBlack);
					chessBoard.add(pawnBlack, xValues[0], yValues[0]);
					chessBoard.getChildren().remove(queenBlack);
					chessBoard.getChildren().remove(queenWhite);
					deadPiece[1] = queenBlack;
					whitePawn = 0;
					whiteQueen = 0;
					deadNum = deadNum + 1;

					/*
					 * chessBoard.getChildren().remove(queenBlack); chessBoard.add(queenWhite,
					 * xValues[0], yValues[0]); queenWhite.setTranslateX(10); whiteQueen=1;
					 */
				}
				whitePawn = 0;
				if (deadNum == 3) {
					winScreen(stage);
				}
			}

		});

		bishopBlack.setOnAction(event -> {// if bishopBlack is pressed
			System.out.println("There is a black Bishop here");
			if (whiteBishop == 0) {// bishop
				chessBoard.getChildren().remove(bishopBlack);
				chessBoard.add(bishopWhite, xValues[2], yValues[2]);
				System.out.println("White bishop is added");
				whiteBishop = 1;

			}
			if (whiteQueen == 1) {
				chessBoard.getChildren().remove(queenWhite);
				chessBoard.add(queenBlack, xValues[1], yValues[1]);
				if (checkQueen(xValues[1], yValues[1], xValues[2], yValues[2], xValues, yValues) == true) {
					chessBoard.getChildren().remove(queenBlack);
					xValues[1] = xValues[2];
					yValues[1] = yValues[2];
					chessBoard.add(queenBlack, xValues[1], yValues[1]);
					deadNum = deadNum + 1;
					chessBoard.getChildren().remove(bishopBlack);
					chessBoard.getChildren().remove(bishopWhite);
					deadPiece[2] = bishopBlack;
					whiteQueen = 0;
					whiteBishop = 0;
				}
				whiteQueen = 0;
				if (deadNum == 3) {
					winScreen(stage);
				}
				/*
				 * chessBoard.getChildren().remove(bishopBlack); chessBoard.add(bishopWhite,
				 * xValues[0], yValues[0]); bishopWhite.setTranslateX(10); whiteBishop=1;
				 */

			}
			if (whiteKnight == 1) {
				chessBoard.getChildren().remove(knightWhite);
				chessBoard.add(knightBlack, xValues[3], yValues[3]);
				if (checkKnight(xValues[3], yValues[3], xValues[2], yValues[2]) == true) {
					chessBoard.getChildren().remove(knightBlack);
					xValues[3] = xValues[2];
					yValues[3] = yValues[2];
					chessBoard.add(knightBlack, xValues[3], yValues[3]);
					chessBoard.getChildren().remove(bishopBlack);
					chessBoard.getChildren().remove(bishopWhite);
					deadPiece[2] = bishopBlack;
					whiteKnight = 0;
					whiteBishop = 0;
					deadNum = deadNum + 1;
					System.out.println(deadNum);
				}
				whiteKnight = 0;
				if (deadNum == 3) {
					winScreen(stage);
				}
				/*
				 * chessBoard.getChildren().remove(bishopBlack); chessBoard.add(bishopWhite,
				 * xValues[0], yValues[0]); bishopWhite.setTranslateX(10); whiteBishop=1;
				 */
			}
			if (whitePawn == 1) {
				chessBoard.getChildren().remove(pawnWhite);
				chessBoard.add(pawnBlack, xValues[0], yValues[0]);
				if (checkPawn(xValues[0], yValues[0], xValues[2], yValues[2]) == true) {
					xValues[0] = xValues[2];
					yValues[0] = yValues[2];
					chessBoard.getChildren().remove(pawnBlack);
					chessBoard.add(pawnBlack, xValues[0], yValues[0]);
					chessBoard.getChildren().remove(bishopBlack);
					chessBoard.getChildren().remove(bishopWhite);
					deadPiece[2] = bishopBlack;
					whiteBishop = 0;
					deadNum = deadNum + 1;
					/*
					 * chessBoard.getChildren().remove(bishopBlack); chessBoard.add(bishopWhite,
					 * xValues[0], yValues[0]); bishopWhite.setTranslateX(10); whiteBishop=1;
					 */
				}
				whitePawn = 0;
				if (deadNum == 3) {
					winScreen(stage);
				}
			}

		});

		knightBlack.setOnAction(event -> {// if bishopBlack is pressed
			System.out.println("There is a black Knight here");
			if (whiteKnight == 0) {
				chessBoard.getChildren().remove(knightBlack);
				chessBoard.add(knightWhite, xValues[3], yValues[3]);
				whiteKnight = 1;
			}
			if (whiteQueen == 1) {
				chessBoard.getChildren().remove(queenWhite);
				chessBoard.add(queenBlack, xValues[1], yValues[1]);
				if (checkQueen(xValues[1], yValues[1], xValues[3], yValues[3], xValues, yValues) == true) {
					chessBoard.getChildren().remove(queenBlack);
					xValues[1] = xValues[3];
					yValues[1] = yValues[3];
					chessBoard.add(queenBlack, xValues[1], yValues[1]);
					chessBoard.getChildren().remove(knightBlack);
					chessBoard.getChildren().remove(knightWhite);
					deadPiece[3] = knightBlack;
					whiteQueen = 0;
					whiteKnight = 0;
					deadNum = deadNum + 1;
				}
				whiteQueen = 0;
				if (deadNum == 3) {
					winScreen(stage);
				}
				/*
				 * chessBoard.getChildren().remove(knightBlack); chessBoard.add(knightWhite,
				 * xValues[0], yValues[0]); knightWhite.setTranslateX(10); whiteKnight=1;
				 */

			}
			if (whiteBishop == 1) {
				chessBoard.getChildren().remove(bishopWhite);
				chessBoard.add(bishopBlack, xValues[2], yValues[2]);
				if (checkBishop(xValues[2], yValues[2], xValues[3], yValues[3], xValues, yValues) == true) {
					System.out.println("AHHHHHHHHh");
					chessBoard.getChildren().remove(bishopBlack);
					xValues[2] = xValues[3];
					yValues[2] = yValues[3];
					chessBoard.add(bishopBlack, xValues[2], yValues[2]);
					deadNum = deadNum + 1;
					chessBoard.getChildren().remove(knightBlack);
					chessBoard.getChildren().remove(knightWhite);
					deadPiece[3] = knightBlack;
					whiteKnight = 0;
					whiteBishop = 0;
				}
				whiteBishop = 0;
				if (deadNum == 3) {
					winScreen(stage);
				}

				/*
				 * chessBoard.getChildren().remove(knightBlack); chessBoard.add(knightWhite,
				 * xValues[0], yValues[0]); knightWhite.setTranslateX(10); whiteKnight=1;
				 */
			}
			if (whitePawn == 1) {
				chessBoard.getChildren().remove(pawnWhite);
				chessBoard.add(pawnBlack, xValues[0], yValues[0]);
				if (checkPawn(xValues[0], yValues[0], xValues[3], yValues[3]) == true) {
					xValues[0] = xValues[3];
					yValues[0] = yValues[3];
					chessBoard.getChildren().remove(pawnBlack);
					chessBoard.add(pawnBlack, xValues[0], yValues[0]);
					chessBoard.getChildren().remove(knightBlack);
					chessBoard.getChildren().remove(knightWhite);
					deadPiece[3] = knightBlack;
					whitePawn = 0;
					whiteKnight = 0;
					deadNum = deadNum + 1;
					/*
					 * chessBoard.getChildren().remove(knightBlack); chessBoard.add(knightWhite,
					 * xValues[0], yValues[0]); knightWhite.setTranslateX(10); whiteKnight=1;
					 */
				}
				whitePawn = 0;
				if (deadNum == 3) {
					winScreen(stage);
				}
			}
		});

		return chessBoard;
	}

	public static GridPane level2Chessboard(Stage stage, Button pawn1, Button pawn1White, Button pawn2,
			Button pawn2White, Button bishop1, Button bishop1White, Button bishop2, Button bishop2White, Button rook,
			Button rookWhite, Button knight, Button knightWhite) {
		// pawn1, pawn2, bishop1, bishop2, knight, rook
		int[] xValues = { 2, 3, 1, 1, 4, 3 };
		int[] yValues = { 3, 3, 0, 2, 2, 2 };
		// Creating a Grid Pane
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

		chessBoard.add(square1, 1, 0);
		chessBoard.add(square2, 2, 0);
		chessBoard.add(square3, 3, 0);
		chessBoard.add(square4, 4, 0);// first row of squares
		chessBoard.add(square5, 1, 1);
		chessBoard.add(square6, 2, 1);
		chessBoard.add(square7, 3, 1);
		chessBoard.add(square8, 4, 1);// second row of squares
		chessBoard.add(square9, 1, 2);
		chessBoard.add(square10, 2, 2);
		chessBoard.add(square11, 3, 2);
		chessBoard.add(square12, 4, 2);// first row of squares
		chessBoard.add(square13, 1, 3);
		chessBoard.add(square14, 2, 3);
		chessBoard.add(square15, 3, 3);
		chessBoard.add(square16, 4, 3);// first row of squares

		Button[][] tile = new Button[4][5];
		for (int row = 0; row < 4; row++) {
			for (int col = 1; col < 5; col++) {
				Button button = new Button();
				button.setMinSize(100, 100);
				tile[row][col] = button; // 2D array of buttons on the same grid as the chessboard
				button.setStyle("-fx-background-color: rgba(0, 0, 0, 0.0);"); // so it shows the button when i need
																				// to(change final value 0.0 - 1.0)
				chessBoard.add(button, col, row); // Add the button to the grid pane
				final int currentRow = row;
				final int currentCol = col;
				button.setOnAction(event -> {
					if (xValues[0] != currentCol && yValues[0] != currentRow) {// if the boar dis pressed with no pieces
																				// all of the pices turn black
						if (pawn1a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn1, xValues[0], yValues[0]);
							whitePawn = 0;
						}
						if (pawn2a == 1) {
							chessBoard.getChildren().remove(pawn2White);// if white pawn is already white, make it black
							chessBoard.add(pawn2, xValues[1], yValues[1]);
							pawn2a = 0;
						}
						if (bishop1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(bishop1White);
							chessBoard.add(bishop1, xValues[2], yValues[2]);
							bishop1a = 0;
						}
						if (bishop2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(bishop2White);
							chessBoard.add(bishop2, xValues[3], yValues[3]);
							bishop2a = 0;
						}
						if (knighta == 1) {// ssame thing as pawn bishop and queen
							chessBoard.getChildren().remove(knightWhite);
							chessBoard.add(knight, xValues[4], yValues[4]);
							knighta = 0;

						}
						if (rooka == 1) {// ssame thing as pawn bishop and queen
							chessBoard.getChildren().remove(rookWhite);
							chessBoard.add(rook, xValues[5], yValues[5]);
							rooka = 0;

						}

					}
					if (xValues[1] != currentCol && yValues[1] != currentRow) {// if the boar dis pressed with no pieces
						// all of the pices turn black
						if (pawn1a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn1, xValues[0], yValues[0]);
							whitePawn = 0;
						}
						if (pawn2a == 1) {
							chessBoard.getChildren().remove(pawn2White);// if white pawn is already white, make it black
							chessBoard.add(pawn2, xValues[1], yValues[1]);
							pawn2a = 0;
						}
						if (bishop1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(bishop1White);
							chessBoard.add(bishop1, xValues[2], yValues[2]);
							bishop1a = 0;
						}
						if (bishop2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(bishop2White);
							chessBoard.add(bishop2, xValues[3], yValues[3]);
							bishop2a = 0;
						}
						if (knighta == 1) {// ssame thing as pawn bishop and queen
							chessBoard.getChildren().remove(knightWhite);
							chessBoard.add(knight, xValues[4], yValues[4]);
							knighta = 0;

						}
						if (rooka == 1) {// ssame thing as pawn bishop and queen
							chessBoard.getChildren().remove(rookWhite);
							chessBoard.add(rook, xValues[5], yValues[5]);
							rooka = 0;

						}

					}
					if (xValues[2] != currentCol && yValues[2] != currentRow) {// if the boar dis pressed with no pieces
						// all of the pices turn black
						if (pawn1a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn1, xValues[0], yValues[0]);
							whitePawn = 0;
						}
						if (pawn2a == 1) {
							chessBoard.getChildren().remove(pawn2White);// if white pawn is already white, make it black
							chessBoard.add(pawn2, xValues[1], yValues[1]);
							pawn2a = 0;
						}
						if (bishop1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(bishop1White);
							chessBoard.add(bishop1, xValues[2], yValues[2]);
							bishop1a = 0;
						}
						if (bishop2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(bishop2White);
							chessBoard.add(bishop2, xValues[3], yValues[3]);
							bishop2a = 0;
						}
						if (knighta == 1) {// ssame thing as pawn bishop and queen
							chessBoard.getChildren().remove(knightWhite);
							chessBoard.add(knight, xValues[4], yValues[4]);
							knighta = 0;

						}
						if (rooka == 1) {// ssame thing as pawn bishop and queen
							chessBoard.getChildren().remove(rookWhite);
							chessBoard.add(rook, xValues[5], yValues[5]);
							rooka = 0;

						}

					}
					if (xValues[3] != currentCol && yValues[3] != currentRow) {// if the boar dis pressed with no pieces
						// all of the pices turn black
						if (pawn1a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn1, xValues[0], yValues[0]);
							whitePawn = 0;
						}
						if (pawn2a == 1) {
							chessBoard.getChildren().remove(pawn2White);// if white pawn is already white, make it black
							chessBoard.add(pawn2, xValues[1], yValues[1]);
							pawn2a = 0;
						}
						if (bishop1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(bishop1White);
							chessBoard.add(bishop1, xValues[2], yValues[2]);
							bishop1a = 0;
						}
						if (bishop2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(bishop2White);
							chessBoard.add(bishop2, xValues[3], yValues[3]);
							bishop2a = 0;
						}
						if (knighta == 1) {// ssame thing as pawn bishop and queen
							chessBoard.getChildren().remove(knightWhite);
							chessBoard.add(knight, xValues[4], yValues[4]);
							knighta = 0;

						}
						if (rooka == 1) {// ssame thing as pawn bishop and queen
							chessBoard.getChildren().remove(rookWhite);
							chessBoard.add(rook, xValues[5], yValues[5]);
							rooka = 0;

						}

					}
					if (xValues[4] != currentCol && yValues[4] != currentRow) {// if the boar dis pressed with no pieces
						// all of the pices turn black
						if (pawn1a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn1, xValues[0], yValues[0]);
							whitePawn = 0;
						}
						if (pawn2a == 1) {
							chessBoard.getChildren().remove(pawn2White);// if white pawn is already white, make it black
							chessBoard.add(pawn2, xValues[1], yValues[1]);
							pawn2a = 0;
						}
						if (bishop1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(bishop1White);
							chessBoard.add(bishop1, xValues[2], yValues[2]);
							bishop1a = 0;
						}
						if (bishop2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(bishop2White);
							chessBoard.add(bishop2, xValues[3], yValues[3]);
							bishop2a = 0;
						}
						if (knighta == 1) {// ssame thing as pawn bishop and queen
							chessBoard.getChildren().remove(knightWhite);
							chessBoard.add(knight, xValues[4], yValues[4]);
							knighta = 0;

						}
						if (rooka == 1) {// ssame thing as pawn bishop and queen
							chessBoard.getChildren().remove(rookWhite);
							chessBoard.add(rook, xValues[5], yValues[5]);
							rooka = 0;

						}

					}
					if (xValues[5] != currentCol && yValues[5] != currentRow) {// if the boar dis pressed with no pieces
						// all of the pices turn black
						if (pawn1a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn1, xValues[0], yValues[0]);
							whitePawn = 0;
						}
						if (pawn2a == 1) {
							chessBoard.getChildren().remove(pawn2White);// if white pawn is already white, make it black
							chessBoard.add(pawn2, xValues[1], yValues[1]);
							pawn2a = 0;
						}
						if (bishop1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(bishop1White);
							chessBoard.add(bishop1, xValues[2], yValues[2]);
							bishop1a = 0;
						}
						if (bishop2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(bishop2White);
							chessBoard.add(bishop2, xValues[3], yValues[3]);
							bishop2a = 0;
						}
						if (knighta == 1) {// ssame thing as pawn bishop and queen
							chessBoard.getChildren().remove(knightWhite);
							chessBoard.add(knight, xValues[4], yValues[4]);
							knighta = 0;

						}
						if (rooka == 1) {// ssame thing as pawn bishop and queen
							chessBoard.getChildren().remove(rookWhite);
							chessBoard.add(rook, xValues[5], yValues[5]);
							rooka = 0;

						}

					}

				});

			}
		}
		Button[] deadPiece = new Button[6];// might not need this but but an array for dead pieces on the board

		chessBoard.add(pawn1, xValues[0], yValues[0]);// adds the piecs to the board
		chessBoard.add(pawn2, xValues[1], yValues[1]);
		chessBoard.add(bishop1, xValues[2], yValues[2]);
		chessBoard.add(bishop2, xValues[3], yValues[3]);
		chessBoard.add(knight, xValues[4], yValues[4]);
		chessBoard.add(rook, xValues[5], yValues[5]);

		pawn1.setOnAction(event -> {
			System.out.println("pawn1 added");
			if (pawn1a == 0) {
				chessBoard.getChildren().remove(pawn1);
				chessBoard.add(pawn1White, xValues[0], yValues[0]);
				pawn1a = 1;
			}
			if (pawn2a == 1) {
				System.out.println("pawn1 removed, pawn2 added");
				chessBoard.getChildren().remove(pawn2White);
				chessBoard.add(pawn2, xValues[1], yValues[1]);
				if (checkPawn(xValues[1], yValues[1], xValues[0], yValues[0]) == true) {
					chessBoard.getChildren().remove(pawn2);
					xValues[1] = xValues[0];
					yValues[1] = yValues[0];
					chessBoard.add(pawn2, xValues[1], yValues[1]);
					chessBoard.getChildren().remove(pawn1);
					chessBoard.getChildren().remove(pawn1White);
					deadPiece[0] = knight;
					pawn2a = 0;
					pawn1a = 0;
					deadNum = deadNum + 1;
				}
				pawn2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (bishop1a == 1) {
				System.out.println("pawn1 removed, bishop1 added");
				chessBoard.getChildren().remove(bishop1White);
				chessBoard.add(bishop1, xValues[2], yValues[2]);
				if (checkBishop(xValues[2], yValues[2], xValues[0], yValues[0], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishop1);
					xValues[2] = xValues[0];
					yValues[2] = yValues[0];
					chessBoard.add(bishop1, xValues[2], yValues[2]);
					chessBoard.getChildren().remove(pawn1);
					chessBoard.getChildren().remove(pawn1White);
					deadPiece[0] = pawn1;

					bishop1a = 0;
					pawn1a = 0;
					deadNum = deadNum + 1;
				}
				bishop1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (bishop2a == 1) {
				System.out.println("pawn1 removed, bishop2 added");
				chessBoard.getChildren().remove(bishop2White);
				chessBoard.add(bishop2, xValues[3], yValues[3]);
				if (checkBishop(xValues[3], yValues[3], xValues[0], yValues[0], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishop2);
					xValues[3] = xValues[0];
					yValues[3] = yValues[0];
					chessBoard.add(bishop2, xValues[3], yValues[3]);
					chessBoard.getChildren().remove(pawn1);
					chessBoard.getChildren().remove(pawn1White);
					deadPiece[0] = pawn1;

					bishop2a = 0;
					pawn1a = 0;
					deadNum = deadNum + 1;
				}
				bishop2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}
			}
			if (knighta == 1) {
				System.out.println("pawn1 removed, knight added");
				chessBoard.getChildren().remove(knightWhite);
				chessBoard.add(knight, xValues[4], yValues[4]);
				if (checkKnight(xValues[4], yValues[4], xValues[0], yValues[0]) == true) {// CHANEG THIS
					chessBoard.getChildren().remove(knight);
					xValues[4] = xValues[0];
					yValues[4] = yValues[0];
					chessBoard.add(knight, xValues[4], yValues[4]);
					chessBoard.getChildren().remove(pawn1);
					chessBoard.getChildren().remove(pawn1White);
					deadPiece[1] = pawn1;

					knighta = 0;
					pawn1a = 0;
					deadNum = deadNum + 1;
				}
				knighta = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}
			}
			if (rooka == 1) {
				System.out.println("pawn1 removed, rook added");
				chessBoard.getChildren().remove(rookWhite);
				chessBoard.add(rook, xValues[5], yValues[5]);
				if (checkRook(xValues[5], yValues[5], xValues[0], yValues[0]) == true) {
					chessBoard.getChildren().remove(rook);
					xValues[5] = xValues[0];
					yValues[5] = yValues[0];
					chessBoard.add(rook, xValues[5], yValues[5]);
					chessBoard.getChildren().remove(pawn1);
					chessBoard.getChildren().remove(pawn1White);
					deadPiece[0] = pawn1;

					rooka = 0;
					pawn1a = 0;
					deadNum = deadNum + 1;
				}
				rooka = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
		});// if bishopBlack is pressed
		pawn2.setOnAction(event -> {
			if (pawn2a == 0) {
				System.out.println("pawn2 added");
				chessBoard.getChildren().remove(pawn2);
				chessBoard.add(pawn2White, xValues[1], yValues[1]);
				pawn2a = 1;
			}
			if (pawn1a == 1) {
				System.out.println("pawn2 removed, pawn1 added");
				chessBoard.getChildren().remove(pawn1);
				chessBoard.add(pawn1White, xValues[0], yValues[0]);
				if (checkPawn(xValues[0], yValues[0], xValues[1], yValues[1]) == true) {
					chessBoard.getChildren().remove(pawn1);
					xValues[0] = xValues[1];
					yValues[0] = yValues[1];
					chessBoard.add(pawn1, xValues[0], yValues[0]);
					chessBoard.getChildren().remove(pawn2);
					chessBoard.getChildren().remove(pawn2White);
					deadPiece[1] = pawn2;

					pawn1a = 0;
					pawn2a = 0;
					deadNum = deadNum + 1;
				}
				pawn1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}

			if (bishop1a == 1) {
				System.out.println("pawn2 removed, bishop1 added");
				chessBoard.getChildren().remove(bishop1White);
				chessBoard.add(bishop1, xValues[2], yValues[2]);
				if (checkBishop(xValues[2], yValues[2], xValues[1], yValues[1], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishop1);
					xValues[2] = xValues[1];
					yValues[2] = yValues[1];
					chessBoard.add(bishop1, xValues[2], yValues[2]);
					chessBoard.getChildren().remove(pawn2);
					chessBoard.getChildren().remove(pawn2White);
					deadPiece[1] = pawn2;

					bishop1a = 0;
					pawn2a = 0;
					deadNum = deadNum + 1;
				}
				bishop1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}
				if (bishop2a == 1) {
					System.out.println("pawn2 removed, bishop2 added");
					chessBoard.getChildren().remove(bishop2White);
					chessBoard.add(bishop2, xValues[3], yValues[3]);
					if (checkBishop(xValues[3], yValues[3], xValues[1], yValues[1], xValues, yValues) == true) {
						chessBoard.getChildren().remove(bishop2);
						xValues[3] = xValues[1];
						yValues[3] = yValues[1];
						chessBoard.add(bishop2, xValues[3], yValues[3]);
						chessBoard.getChildren().remove(pawn2);
						chessBoard.getChildren().remove(pawn2White);
						deadPiece[1] = pawn2;

						bishop2a = 0;
						pawn1a = 0;
						deadNum = deadNum + 1;
					}
					bishop2a = 0;
					if (deadNum == 5) {
						winScreen(stage);
					}
				}

			}
			if (knighta == 1) {
				System.out.println("pawn2 removed, kinght added");
				chessBoard.getChildren().remove(knightWhite);
				chessBoard.add(knight, xValues[4], yValues[4]);
				if (checkKnight(xValues[4], yValues[4], xValues[1], yValues[1]) == true) {// CHANEG THIS
					chessBoard.getChildren().remove(knight);
					xValues[4] = xValues[1];
					yValues[4] = yValues[1];
					chessBoard.add(knight, xValues[4], yValues[4]);
					chessBoard.getChildren().remove(pawn2);
					chessBoard.getChildren().remove(pawn2White);
					deadPiece[4] = knight;

					knighta = 0;
					pawn2a = 0;
					deadNum = deadNum + 1;
				}
				knighta = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}
			}
			if (rooka == 1) {
				System.out.println("pawn2 removed, rook added");
				chessBoard.getChildren().remove(rookWhite);
				chessBoard.add(rook, xValues[5], yValues[5]);
				if (checkRook(xValues[5], yValues[5], xValues[1], yValues[1]) == true) {
					chessBoard.getChildren().remove(rook);
					xValues[5] = xValues[1];
					yValues[5] = yValues[1];
					chessBoard.add(rook, xValues[5], yValues[5]);
					chessBoard.getChildren().remove(pawn2);
					chessBoard.getChildren().remove(pawn2White);
					deadPiece[1] = bishop2;

					rooka = 0;
					pawn2a = 0;
					deadNum = deadNum + 1;
				}
				rooka = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}
			}

		});// if bishopBlack is pressed
		bishop1.setOnAction(event -> {
			System.out.println("There is a bishop here");
			if (bishop1a == 0) {
				System.out.println("bishop1 added");
				chessBoard.getChildren().remove(bishop1);
				chessBoard.add(bishop1White, xValues[2], yValues[2]);
				bishop1a = 1;
			}
			if (pawn1a == 1) {
				System.out.println("bishop1 removed, pawn1 added");
				chessBoard.getChildren().remove(pawn1White);
				chessBoard.add(pawn1, xValues[0], yValues[0]);
				if (checkPawn(xValues[0], yValues[0], xValues[2], yValues[2]) == true) {
					chessBoard.getChildren().remove(pawn1);
					xValues[0] = xValues[2];
					yValues[0] = yValues[2];
					chessBoard.add(pawn1, xValues[0], yValues[0]);
					chessBoard.getChildren().remove(bishop1);
					chessBoard.getChildren().remove(bishop1White);
					deadPiece[2] = bishop2;

					pawn1a = 0;
					bishop1a = 0;
					deadNum = deadNum + 1;
				}
				pawn1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (pawn2a == 1) {
				System.out.println("bishop1 removed, pawn2 added");
				chessBoard.getChildren().remove(pawn2White);
				chessBoard.add(pawn2, xValues[1], yValues[1]);
				if (checkPawn(xValues[1], yValues[1], xValues[2], yValues[2]) == true) {
					chessBoard.getChildren().remove(pawn2);
					xValues[1] = xValues[2];
					yValues[1] = yValues[2];
					chessBoard.add(pawn2, xValues[1], yValues[1]);
					chessBoard.getChildren().remove(bishop1);
					chessBoard.getChildren().remove(bishop1White);
					deadPiece[2] = bishop1;
					pawn2a = 0;
					bishop1a = 0;
					deadNum = deadNum + 1;
				}
				pawn2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (bishop2a == 1) {
				System.out.println("bishop1 removed, bishop2 added");
				chessBoard.getChildren().remove(bishop2White);
				chessBoard.add(bishop2, xValues[3], yValues[3]);
				if (checkBishop(xValues[3], yValues[3], xValues[2], yValues[2], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishop2);
					xValues[3] = xValues[2];
					yValues[3] = yValues[2];
					chessBoard.add(bishop2, xValues[3], yValues[3]);
					chessBoard.getChildren().remove(bishop1);
					chessBoard.getChildren().remove(bishop1White);
					deadPiece[2] = bishop1;

					bishop2a = 0;
					bishop1a = 0;
					deadNum = deadNum + 1;
				}
				bishop2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (knighta == 1) {
				System.out.println("bishop1 removed, knight added");
				chessBoard.getChildren().remove(knightWhite);
				chessBoard.add(knight, xValues[4], yValues[4]);
				if (checkKnight(xValues[4], yValues[4], xValues[2], yValues[2]) == true) {// CHANEG THIS
					chessBoard.getChildren().remove(knight);
					xValues[4] = xValues[2];
					yValues[4] = yValues[2];
					chessBoard.add(knight, xValues[4], yValues[4]);
					chessBoard.getChildren().remove(bishop1);
					chessBoard.getChildren().remove(bishop1White);
					deadPiece[2] = bishop1;

					knighta = 0;
					bishop2a = 0;
					deadNum = deadNum + 1;
				}
				knighta = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}
			}
			if (rooka == 1) {
				System.out.println("bishop1 removed, rook added");
				chessBoard.getChildren().remove(rookWhite);
				chessBoard.add(rook, xValues[5], yValues[5]);
				if (checkRook(xValues[5], yValues[5], xValues[2], yValues[2]) == true) {
					chessBoard.getChildren().remove(rook);
					xValues[5] = xValues[2];
					yValues[5] = yValues[2];
					chessBoard.add(rook, xValues[5], yValues[5]);
					chessBoard.getChildren().remove(bishop1);
					chessBoard.getChildren().remove(bishop1White);
					deadPiece[2] = bishop1;

					rooka = 0;
					bishop2a = 0;
					deadNum = deadNum + 1;
				}
				rooka = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
		});// if bishopBlack is pressed
		bishop2.setOnAction(event -> {
			if (bishop2a == 0) {
				System.out.println("bishop2 added");
				chessBoard.getChildren().remove(bishop2);
				chessBoard.add(bishop2White, xValues[3], yValues[3]);
				bishop2a = 1;
			}
			if (pawn1a == 1) {
				System.out.println("bishop2 removed, pawn1 added");
				chessBoard.getChildren().remove(pawn1White);
				chessBoard.add(pawn1, xValues[0], yValues[0]);
				if (checkPawn(xValues[0], yValues[0], xValues[3], yValues[3]) == true) {
					chessBoard.getChildren().remove(pawn1);
					xValues[0] = xValues[3];
					yValues[0] = yValues[3];
					chessBoard.add(pawn1, xValues[0], yValues[0]);
					chessBoard.getChildren().remove(bishop2);
					chessBoard.getChildren().remove(bishop2White);
					deadPiece[3] = bishop2;

					pawn1a = 0;
					bishop2a = 0;
					deadNum = deadNum + 1;
				}
				pawn1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (pawn2a == 1) {
				System.out.println("bishop2 removed, pawn2 added");
				chessBoard.getChildren().remove(pawn2White);
				chessBoard.add(pawn2, xValues[1], yValues[1]);
				if (checkPawn(xValues[1], yValues[1], xValues[3], yValues[3]) == true) {
					chessBoard.getChildren().remove(pawn2);
					xValues[1] = xValues[3];
					yValues[1] = yValues[3];
					chessBoard.add(pawn2, xValues[1], yValues[1]);
					chessBoard.getChildren().remove(bishop2);
					chessBoard.getChildren().remove(bishop2White);
					deadPiece[3] = bishop2;
					pawn2a = 0;
					bishop2a = 0;
					deadNum = deadNum + 1;
				}
				pawn2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (bishop1a == 1) {
				System.out.println("bishop2 removed, bishop1 added");
				chessBoard.getChildren().remove(bishop1White);
				chessBoard.add(bishop1, xValues[2], yValues[2]);
				if (checkBishop(xValues[2], yValues[2], xValues[3], yValues[3], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishop1);
					xValues[2] = xValues[3];
					yValues[2] = yValues[3];
					chessBoard.add(bishop1, xValues[2], yValues[2]);
					chessBoard.getChildren().remove(bishop2);
					chessBoard.getChildren().remove(bishop2White);
					deadPiece[3] = bishop2;

					bishop1a = 0;
					bishop2a = 0;
					deadNum = deadNum + 1;
				}
				bishop1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (knighta == 1) {
				System.out.println("bishop2 removed, knight added");
				chessBoard.getChildren().remove(knightWhite);
				chessBoard.add(knight, xValues[4], yValues[4]);
				if (checkKnight(xValues[4], yValues[4], xValues[3], yValues[3]) == true) {// CHANEG THIS
					chessBoard.getChildren().remove(knight);
					xValues[4] = xValues[3];
					yValues[4] = yValues[3];
					chessBoard.add(knight, xValues[4], yValues[4]);
					chessBoard.getChildren().remove(bishop2);
					chessBoard.getChildren().remove(bishop2White);
					deadPiece[3] = bishop2;

					knighta = 0;
					bishop2a = 0;
					deadNum = deadNum + 1;
				}
				knighta = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}
			}
			if (rooka == 1) {
				System.out.println("bishop2 removed, rook added");
				chessBoard.getChildren().remove(rookWhite);
				chessBoard.add(rook, xValues[5], yValues[5]);
				if (checkRook(xValues[5], yValues[5], xValues[3], yValues[3]) == true) {
					chessBoard.getChildren().remove(rook);
					xValues[5] = xValues[3];
					yValues[5] = yValues[3];
					chessBoard.add(rook, xValues[5], yValues[5]);
					chessBoard.getChildren().remove(bishop2);
					chessBoard.getChildren().remove(bishop2White);
					deadPiece[3] = bishop2;

					rooka = 0;
					bishop2a = 0;
					deadNum = deadNum + 1;
				}
				rooka = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
		});// if bishopBlack is pressed
		knight.setOnAction(event -> {
			if (knighta == 0) {
				System.out.println("knight added");
				chessBoard.getChildren().remove(knight);
				chessBoard.add(knightWhite, xValues[4], yValues[4]);
				knighta = 1;
			}
			if (pawn1a == 1) {
				System.out.println("knight removed, pawn1 added");
				chessBoard.getChildren().remove(pawn1White);
				chessBoard.add(pawn1, xValues[0], yValues[0]);
				if (checkPawn(xValues[0], yValues[0], xValues[4], yValues[4]) == true) {
					chessBoard.getChildren().remove(pawn1);
					xValues[0] = xValues[4];
					yValues[0] = yValues[4];
					chessBoard.add(pawn1, xValues[0], yValues[0]);
					chessBoard.getChildren().remove(knight);
					chessBoard.getChildren().remove(knightWhite);
					deadPiece[4] = knight;

					pawn1a = 0;
					knighta = 0;
					deadNum = deadNum + 1;
				}
				pawn1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (pawn2a == 1) {
				System.out.println("knight removed, pawn2 added");
				chessBoard.getChildren().remove(pawn2White);
				chessBoard.add(pawn2, xValues[1], yValues[1]);
				if (checkPawn(xValues[1], yValues[1], xValues[4], yValues[4]) == true) {
					chessBoard.getChildren().remove(pawn2);
					xValues[1] = xValues[4];
					yValues[1] = yValues[4];
					chessBoard.add(pawn2, xValues[1], yValues[1]);
					chessBoard.getChildren().remove(knight);
					chessBoard.getChildren().remove(knightWhite);
					deadPiece[4] = knight;
					pawn2a = 0;
					knighta = 0;
					deadNum = deadNum + 1;
				}
				pawn2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}
				System.out.println(pawn2a);

			}
			if (bishop1a == 1) {
				System.out.println("knight removed, bishop1 added");
				chessBoard.getChildren().remove(bishop1White);
				chessBoard.add(bishop1, xValues[2], yValues[2]);
				if (checkBishop(xValues[2], yValues[2], xValues[4], yValues[4], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishop1);
					xValues[2] = xValues[4];
					yValues[2] = yValues[4];
					chessBoard.add(bishop1, xValues[2], yValues[2]);
					chessBoard.getChildren().remove(knight);
					chessBoard.getChildren().remove(knightWhite);
					deadPiece[4] = knight;

					bishop1a = 0;
					knighta = 0;
					deadNum = deadNum + 1;
				}
				bishop1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (bishop2a == 1) {
				System.out.println("knight removed, bishop2 added");
				chessBoard.getChildren().remove(bishop2White);
				chessBoard.add(bishop2, xValues[3], yValues[3]);
				if (checkBishop(xValues[3], yValues[3], xValues[4], yValues[4], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishop2);
					xValues[3] = xValues[4];
					yValues[3] = yValues[4];
					chessBoard.add(bishop2, xValues[3], yValues[3]);
					chessBoard.getChildren().remove(knight);
					chessBoard.getChildren().remove(knightWhite);
					deadPiece[4] = knight;

					bishop2a = 0;
					knighta = 0;
					deadNum = deadNum + 1;
				}
				bishop2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}
			}

			if (rooka == 1) {
				System.out.println("knight removed, rook added");
				chessBoard.getChildren().remove(rookWhite);
				chessBoard.add(rook, xValues[5], yValues[5]);
				if (checkRook(xValues[5], yValues[5], xValues[4], yValues[4]) == true) {
					chessBoard.getChildren().remove(rook);
					xValues[5] = xValues[4];
					yValues[5] = yValues[4];
					chessBoard.add(rook, xValues[5], yValues[5]);
					chessBoard.getChildren().remove(knight);
					chessBoard.getChildren().remove(knightWhite);
					deadPiece[4] = knight;

					rooka = 0;
					knighta = 0;
					deadNum = deadNum + 1;
				}
				rooka = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}

		});// if bishopBlack is pressed
		rook.setOnAction(event -> {
			if (rooka == 0) {
				System.out.println("rook added");
				chessBoard.getChildren().remove(rook);
				chessBoard.add(rookWhite, xValues[5], yValues[5]);
				rooka = 1;
			}
			if (pawn1a == 1) {
				System.out.println("rook removed, pawn1 added");
				chessBoard.getChildren().remove(pawn1White);
				chessBoard.add(pawn1, xValues[0], yValues[0]);
				if (checkPawn(xValues[0], yValues[0], xValues[5], yValues[5]) == true) {
					chessBoard.getChildren().remove(pawn1);
					xValues[0] = xValues[5];
					yValues[0] = yValues[5];
					chessBoard.add(pawn1, xValues[0], yValues[0]);
					chessBoard.getChildren().remove(rook);
					chessBoard.getChildren().remove(rookWhite);
					deadPiece[5] = rook;

					pawn1a = 0;
					rooka = 0;
					deadNum = deadNum + 1;
				}
				pawn1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (pawn2a == 1) {
				System.out.println("rook removed, pawn2 added");
				chessBoard.getChildren().remove(pawn2White);
				chessBoard.add(pawn2, xValues[1], yValues[1]);
				if (checkPawn(xValues[1], yValues[1], xValues[5], yValues[5]) == true) {
					chessBoard.getChildren().remove(pawn2);
					xValues[1] = xValues[5];
					yValues[1] = yValues[5];
					chessBoard.add(pawn2, xValues[1], yValues[1]);
					chessBoard.getChildren().remove(rook);
					chessBoard.getChildren().remove(rookWhite);
					deadPiece[5] = rook;
					pawn2a = 0;
					rooka = 0;
					deadNum = deadNum + 1;
				}
				pawn2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (bishop1a == 1) {
				System.out.println("rook removed, bishop1 added");
				chessBoard.getChildren().remove(bishop1White);
				chessBoard.add(bishop1, xValues[2], yValues[2]);
				if (checkBishop(xValues[2], yValues[2], xValues[5], yValues[5], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishop1);
					xValues[2] = xValues[5];
					yValues[2] = yValues[5];
					chessBoard.add(bishop1, xValues[2], yValues[2]);
					chessBoard.getChildren().remove(rook);
					chessBoard.getChildren().remove(rookWhite);
					deadPiece[5] = rook;

					bishop1a = 0;
					rooka = 0;
					deadNum = deadNum + 1;
				}
				bishop1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (bishop2a == 1) {
				System.out.println("rook removed, bishop2 added");
				chessBoard.getChildren().remove(bishop2White);
				chessBoard.add(bishop2, xValues[3], yValues[3]);
				if (checkBishop(xValues[3], yValues[3], xValues[5], yValues[5], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishop2);
					xValues[3] = xValues[5];
					yValues[3] = yValues[5];
					chessBoard.add(bishop2, xValues[3], yValues[3]);
					chessBoard.getChildren().remove(rook);
					chessBoard.getChildren().remove(rookWhite);
					deadPiece[5] = rook;

					bishop2a = 0;
					rooka = 0;
					deadNum = deadNum + 1;
				}
				bishop2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}
			}
			if (knighta == 1) {
				System.out.println("rook removed, knight added");
				chessBoard.getChildren().remove(knightWhite);
				chessBoard.add(knight, xValues[4], yValues[4]);
				if (checkKnight(xValues[4], yValues[4], xValues[5], yValues[5]) == true) {// CHANEG THIS
					chessBoard.getChildren().remove(knight);
					xValues[4] = xValues[5];
					yValues[4] = yValues[5];
					chessBoard.add(knight, xValues[4], yValues[4]);
					chessBoard.getChildren().remove(rook);
					chessBoard.getChildren().remove(rookWhite);
					deadPiece[5] = rook;

					knighta = 0;
					rooka = 0;
					deadNum = deadNum + 1;
				}
				knighta = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}
			}
		});// if bishopBlack is pressed

		return chessBoard;

	}

	public static GridPane level3Chessboard(Stage stage, Button pawn1, Button pawn1White, Button pawn2,
			Button pawn2White, Button rook1, Button rook1White, Button rook2, Button rook2White, Button knight1,
			Button knight1White, Button knight2, Button knight2White) {

		// pawn1, pawn2, knight1, knight2, rook1, rook2
		int[] xValues = { 1, 4, 2, 3, 2, 3 };
		int[] yValues = { 1, 1, 3, 3, 0, 0 };
		// Creating a Grid Pane
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

		chessBoard.add(square1, 1, 0);
		chessBoard.add(square2, 2, 0);
		chessBoard.add(square3, 3, 0);
		chessBoard.add(square4, 4, 0);// first row of squares
		chessBoard.add(square5, 1, 1);
		chessBoard.add(square6, 2, 1);
		chessBoard.add(square7, 3, 1);
		chessBoard.add(square8, 4, 1);// second row of squares
		chessBoard.add(square9, 1, 2);
		chessBoard.add(square10, 2, 2);
		chessBoard.add(square11, 3, 2);
		chessBoard.add(square12, 4, 2);// first row of squares
		chessBoard.add(square13, 1, 3);
		chessBoard.add(square14, 2, 3);
		chessBoard.add(square15, 3, 3);
		chessBoard.add(square16, 4, 3);// first row of squares

		Button[][] tile = new Button[4][5];
		for (int row = 0; row < 4; row++) {
			for (int col = 1; col < 5; col++) {
				Button button = new Button();
				button.setMinSize(100, 100);
				tile[row][col] = button; // 2D array of buttons on the same grid as the chessboard
				button.setStyle("-fx-background-color: rgba(0, 0, 0, 0.0);"); // so it shows the button when i need
				// to(change final value 0.0 - 1.0)
				chessBoard.add(button, col, row); // Add the button to the grid pane
				final int currentRow = row;
				final int currentCol = col;
				button.setOnAction(event -> {
					if (xValues[0] != currentCol && yValues[0] != currentRow) {// if the boar dis pressed with no pieces
						// all of the pices turn black
						if (pawn1a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn1, xValues[0], yValues[0]);
							pawn1a = 0;
						}
						if (pawn2a == 1) {
							chessBoard.getChildren().remove(pawn2White);// if white pawn is already white, make it black
							chessBoard.add(pawn2, xValues[1], yValues[1]);
							pawn2a = 0;
						}
						if (knight1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(knight1White);
							chessBoard.add(knight1, xValues[2], yValues[2]);
							knight1a = 0;
						}
						if (knight2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(knight2White);
							chessBoard.add(knight2, xValues[3], yValues[3]);
							knight2a = 0;
						}
						if (rook1a == 1) {// ssame thing as pawn knight and queen
							chessBoard.getChildren().remove(rook1White);
							chessBoard.add(rook1, xValues[4], yValues[4]);
							rook1a = 0;

						}
						if (rook2a == 1) {// ssame thing as pawn knight and queen
							chessBoard.getChildren().remove(rook2White);
							chessBoard.add(rook2, xValues[5], yValues[5]);
							rook2a = 0;

						}

					}
					if (xValues[1] != currentCol && yValues[1] != currentRow) {// if the boar dis pressed with no pieces
						// all of the pices turn black
						if (pawn1a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn1, xValues[0], yValues[0]);
							pawn1a = 0;
						}
						if (pawn2a == 1) {
							chessBoard.getChildren().remove(pawn2White);// if white pawn is already white, make it black
							chessBoard.add(pawn2, xValues[1], yValues[1]);
							pawn2a = 0;
						}
						if (knight1a == 1) {// if knight is already white, make it black
							chessBoard.getChildren().remove(knight1White);
							chessBoard.add(knight1, xValues[2], yValues[2]);
							knight1a = 0;
						}
						if (knight2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(knight2White);
							chessBoard.add(knight2, xValues[3], yValues[3]);
							knight2a = 0;
						}
						if (rook1a == 1) {// ssame thing as pawn knight and queen
							chessBoard.getChildren().remove(rook1White);
							chessBoard.add(rook1, xValues[4], yValues[4]);
							knight1a = 0;

						}
						if (rook2a == 1) {// ssame thing as pawn bishop and queen
							chessBoard.getChildren().remove(rook2White);
							chessBoard.add(rook2, xValues[5], yValues[5]);
							rook2a = 0;

						}

					}
					if (xValues[2] != currentCol && yValues[2] != currentRow) {// if the boar dis pressed with no pieces
						// all of the pices turn black
						if (pawn1a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn1, xValues[0], yValues[0]);
							pawn1a = 0;
						}
						if (pawn2a == 1) {
							chessBoard.getChildren().remove(pawn2White);// if white pawn is already white, make it black
							chessBoard.add(pawn2, xValues[1], yValues[1]);
							pawn2a = 0;
						}
						if (knight1a == 1) {// if knight is already white, make it black
							chessBoard.getChildren().remove(knight1White);
							chessBoard.add(knight1, xValues[2], yValues[2]);
							knight1a = 0;
						}
						if (knight2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(knight2White);
							chessBoard.add(knight2, xValues[3], yValues[3]);
							knight2a = 0;
						}
						if (rook1a == 1) {// ssame thing as pawn bishop and queen
							chessBoard.getChildren().remove(rook1White);
							chessBoard.add(rook1, xValues[4], yValues[4]);
							knight1a = 0;

						}
						if (rook2a == 1) {// ssame thing as pawn bishop and queen
							chessBoard.getChildren().remove(rook2White);
							chessBoard.add(rook2, xValues[5], yValues[5]);
							rook2a = 0;

						}

					}
					if (xValues[3] != currentCol && yValues[3] != currentRow) {// if the boar dis pressed with no pieces
						// all of the pices turn black
						if (pawn1a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn1, xValues[0], yValues[0]);
							pawn1a = 0;
						}
						if (pawn2a == 1) {
							chessBoard.getChildren().remove(pawn2White);// if white pawn is already white, make it black
							chessBoard.add(pawn2, xValues[1], yValues[1]);
							pawn2a = 0;
						}
						if (knight1a == 1) {// if knight is already white, make it black
							chessBoard.getChildren().remove(knight1White);
							chessBoard.add(knight1, xValues[2], yValues[2]);
							knight1a = 0;
						}
						if (knight2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(knight2White);
							chessBoard.add(knight2, xValues[3], yValues[3]);
							knight2a = 0;
						}
						if (rook1a == 1) {// ssame thing as pawn bishop and queen
							chessBoard.getChildren().remove(rook1White);
							chessBoard.add(rook1, xValues[4], yValues[4]);
							rook1a = 0;

						}
						if (rook2a == 1) {// ssame thing as pawn bishop and queen
							chessBoard.getChildren().remove(rook2White);
							chessBoard.add(rook2, xValues[5], yValues[5]);
							rook2a = 0;

						}

					}
					if (xValues[4] != currentCol && yValues[4] != currentRow) {// if the boar dis pressed with no pieces
						// all of the pices turn black
						if (pawn1a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn1, xValues[0], yValues[0]);
							pawn1a = 0;
						}
						if (pawn2a == 1) {
							chessBoard.getChildren().remove(pawn2White);// if white pawn is already white, make it black
							chessBoard.add(pawn2, xValues[1], yValues[1]);
							pawn2a = 0;
						}
						if (knight1a == 1) {// if knight is already white, make it black
							chessBoard.getChildren().remove(knight1White);
							chessBoard.add(knight1, xValues[2], yValues[2]);
							knight1a = 0;
						}
						if (knight2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(knight2White);
							chessBoard.add(knight2, xValues[3], yValues[3]);
							knight2a = 0;
						}
						if (rook1a == 1) {// ssame thing as pawn bishop and queen
							chessBoard.getChildren().remove(rook1White);
							chessBoard.add(rook1, xValues[4], yValues[4]);
							rook1a = 0;

						}
						if (rook2a == 1) {// ssame thing as pawn bishop and queen
							chessBoard.getChildren().remove(rook2White);
							chessBoard.add(rook2, xValues[5], yValues[5]);
							rook2a = 0;

						}

					}
					if (xValues[5] != currentCol && yValues[5] != currentRow) {// if the boar dis pressed with no pieces
						// all of the pices turn black
						if (pawn1a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn1, xValues[0], yValues[0]);
							pawn1a = 0;
						}
						if (pawn2a == 1) {
							chessBoard.getChildren().remove(pawn2White);// if white pawn is already white, make it black
							chessBoard.add(pawn2, xValues[1], yValues[1]);
							pawn2a = 0;
						}
						if (knight1a == 1) {// if knight is already white, make it black
							chessBoard.getChildren().remove(knight1White);
							chessBoard.add(knight1, xValues[2], yValues[2]);
							knight1a = 0;
						}
						if (knight2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(knight2White);
							chessBoard.add(knight2, xValues[3], yValues[3]);
							knight2a = 0;
						}
						if (rook1a == 1) {// ssame thing as pawn bishop and queen
							chessBoard.getChildren().remove(rook1White);
							chessBoard.add(rook1, xValues[4], yValues[4]);
							rook1a = 0;

						}
						if (rook2a == 1) {// ssame thing as pawn bishop and queen
							chessBoard.getChildren().remove(rook2White);
							chessBoard.add(rook2, xValues[5], yValues[5]);
							rook2a = 0;

						}

					}

				});
			}
		}

		Button[] deadPiece = new Button[6];// might not need this but but an array for dead pieces on the board

		chessBoard.add(pawn1, xValues[0], yValues[0]);// adds the piecs to the board
		chessBoard.add(pawn2, xValues[1], yValues[1]);
		chessBoard.add(knight1, xValues[2], yValues[2]);
		chessBoard.add(knight2, xValues[3], yValues[3]);
		chessBoard.add(rook1, xValues[4], yValues[4]);
		chessBoard.add(rook2, xValues[5], yValues[5]);

		pawn1.setOnAction(event -> {

			System.out.println("pawn1");
			if (pawn1a == 0) {
				chessBoard.getChildren().remove(pawn1);
				chessBoard.add(pawn1White, xValues[0], yValues[0]);
				pawn1a = 1;
			}
			if (pawn2a == 1) {
				System.out.println("pawn1, pawn2");
				chessBoard.getChildren().remove(pawn2White);
				chessBoard.add(pawn2, xValues[1], yValues[1]);
				if (checkPawn(xValues[1], yValues[1], xValues[2], yValues[2]) == true) {
					chessBoard.getChildren().remove(pawn2);
					xValues[1] = xValues[2];
					yValues[1] = yValues[2];
					chessBoard.add(pawn2, xValues[1], yValues[1]);
					chessBoard.getChildren().remove(pawn1);
					chessBoard.getChildren().remove(pawn1White);
					deadPiece[0] = pawn1;
					pawn2a = 0;
					pawn1a = 0;
					deadNum = deadNum + 1;
				}
				pawn2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (knight1a == 1) {
				System.out.println("pawn1, knight1");
				System.out.println("pawn1 removed, bishop1 added");
				chessBoard.getChildren().remove(knight1White);
				chessBoard.add(knight1, xValues[2], yValues[2]);
				if (checkKnight(xValues[2], yValues[2], xValues[0], yValues[0]) == true) {
					chessBoard.getChildren().remove(knight1);
					xValues[2] = xValues[0];
					yValues[2] = yValues[0];
					chessBoard.add(knight1, xValues[2], yValues[2]);
					chessBoard.getChildren().remove(pawn1);
					chessBoard.getChildren().remove(pawn1White);
					deadPiece[0] = pawn1;

					knight1a = 0;
					pawn1a = 0;
					deadNum = deadNum + 1;
				}
				knight1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (knight2a == 1) {
				System.out.println("pawn1, knight2");
				chessBoard.getChildren().remove(knight2White);
				chessBoard.add(knight2, xValues[3], yValues[3]);
				if (checkKnight(xValues[3], yValues[3], xValues[0], yValues[0]) == true) {
					chessBoard.getChildren().remove(knight2);
					xValues[3] = xValues[0];
					yValues[3] = yValues[0];
					chessBoard.add(knight2, xValues[3], yValues[3]);
					chessBoard.getChildren().remove(pawn1);
					chessBoard.getChildren().remove(pawn1White);
					deadPiece[0] = pawn1;

					knight2a = 0;
					pawn1a = 0;
					deadNum = deadNum + 1;
				}
				knight2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}
			}
			if (rook1a == 1) {
				System.out.println("pawn1, rook1");
				chessBoard.getChildren().remove(rook1White);
				chessBoard.add(rook1, xValues[4], yValues[4]);
				if (checkRook(xValues[4], yValues[4], xValues[0], yValues[0]) == true) {
					chessBoard.getChildren().remove(rook1);
					xValues[4] = xValues[0];
					yValues[4] = yValues[0];
					chessBoard.add(rook1, xValues[4], yValues[4]);
					chessBoard.getChildren().remove(pawn1);
					chessBoard.getChildren().remove(pawn1White);
					deadPiece[0] = pawn1;

					rook1a = 0;
					pawn1a = 0;
					deadNum = deadNum + 1;
				}
				rook1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (rook2a == 1) {
				System.out.println("pawn1, rook2");
				chessBoard.getChildren().remove(rook2White);
				chessBoard.add(rook2, xValues[5], yValues[5]);
				if (checkRook(xValues[5], yValues[5], xValues[0], yValues[0]) == true) {
					chessBoard.getChildren().remove(rook2);
					xValues[5] = xValues[0];
					yValues[5] = yValues[0];
					chessBoard.add(rook2, xValues[5], yValues[5]);
					chessBoard.getChildren().remove(pawn1);
					chessBoard.getChildren().remove(pawn1White);
					deadPiece[0] = pawn1;

					rook2a = 0;
					pawn1a = 0;
					deadNum = deadNum + 1;
				}
				rook2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
		});// if bishopBlack is pressed
		pawn2.setOnAction(event -> {
			if (pawn2a == 0) {
				System.out.println(knight2a);
				System.out.println("pawn2 ");
				chessBoard.getChildren().remove(pawn2);
				chessBoard.add(pawn2White, xValues[1], yValues[1]);
				pawn2a = 1;
			}
			if (pawn1a == 1) {
				System.out.println("pawn2, pawn1");
				chessBoard.getChildren().remove(pawn1White);

				chessBoard.getChildren().remove(pawn1);
				chessBoard.add(pawn1White, xValues[0], yValues[0]);
				if (checkPawn(xValues[0], yValues[0], xValues[1], yValues[1]) == true) {
					chessBoard.getChildren().remove(pawn1);
					xValues[0] = xValues[1];
					yValues[0] = yValues[1];
					chessBoard.add(pawn1, xValues[0], yValues[0]);
					chessBoard.getChildren().remove(pawn2);
					chessBoard.getChildren().remove(pawn2White);
					deadPiece[1] = pawn2;

					pawn1a = 0;
					pawn2a = 0;
					deadNum = deadNum + 1;
				}
				pawn1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (knight1a == 1) {
				System.out.println("pawn2, knight1");
				chessBoard.getChildren().remove(knight1White);
				chessBoard.add(knight1, xValues[2], yValues[2]);
				if (checkKnight(xValues[2], yValues[2], xValues[1], yValues[1]) == true) {
					chessBoard.getChildren().remove(knight1);
					xValues[2] = xValues[1];
					yValues[2] = yValues[1];
					chessBoard.add(knight1, xValues[2], yValues[2]);
					chessBoard.getChildren().remove(pawn2);
					chessBoard.getChildren().remove(pawn2White);
					deadPiece[1] = pawn2;

					knight1a = 0;
					pawn2a = 0;
					deadNum = deadNum + 1;
				}
				knight1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}
			}
			if (knight2a == 1) {
				System.out.println("pawn2, knight2");
				chessBoard.getChildren().remove(knight2White);
				chessBoard.add(knight2, xValues[3], yValues[3]);
				if (checkKnight(xValues[3], yValues[3], xValues[1], yValues[1]) == true) {
					chessBoard.getChildren().remove(knight2);
					xValues[3] = xValues[1];
					yValues[3] = yValues[1];
					chessBoard.add(knight2, xValues[3], yValues[3]);
					chessBoard.getChildren().remove(pawn2);
					chessBoard.getChildren().remove(pawn2White);
					deadPiece[1] = pawn2;

					knight2a = 0;
					pawn2a = 0;
					deadNum = deadNum + 1;
				}
				knight2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}
			}

			if (rook1a == 1) {
				System.out.println("pawn2, rook1");
				chessBoard.getChildren().remove(rook1White);
				chessBoard.add(rook1, xValues[4], yValues[4]);
				if (checkRook(xValues[4], yValues[4], xValues[1], yValues[1]) == true) {// CHANEG THIS
					chessBoard.getChildren().remove(rook1);
					xValues[4] = xValues[1];
					yValues[4] = yValues[1];
					chessBoard.add(rook1, xValues[4], yValues[4]);
					chessBoard.getChildren().remove(pawn2);
					chessBoard.getChildren().remove(pawn2White);
					deadPiece[4] = rook1;

					rook1a = 0;
					pawn2a = 0;
					deadNum = deadNum + 1;
				}
				rook1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}
			}
			if (rook2a == 1) {
				System.out.println("pawn2, rook2");
				chessBoard.getChildren().remove(rook2White);
				chessBoard.add(rook2, xValues[5], yValues[5]);
				if (checkRook(xValues[5], yValues[5], xValues[1], yValues[1]) == true) {
					chessBoard.getChildren().remove(rook2);
					xValues[5] = xValues[1];
					yValues[5] = yValues[1];
					chessBoard.add(rook2, xValues[5], yValues[5]);
					chessBoard.getChildren().remove(pawn2);
					chessBoard.getChildren().remove(pawn2White);
					deadPiece[1] = pawn2;

					rook2a = 0;
					pawn2a = 0;
					deadNum = deadNum + 1;
				}
				rook2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}
			}
		});// if bishopBlack is pressed
		knight1.setOnAction(event -> {
			if (knight1a == 0) {
				System.out.println("knight1 added");
				chessBoard.getChildren().remove(knight1);
				chessBoard.add(knight1White, xValues[2], yValues[2]);
				knight1a = 1;
			}
			if (pawn1a == 1) {
				System.out.println("knight1, pawn1");
				chessBoard.getChildren().remove(pawn1White);
				chessBoard.add(pawn1, xValues[0], yValues[0]);
				if (checkPawn(xValues[0], yValues[0], xValues[2], yValues[2]) == true) {
					chessBoard.getChildren().remove(pawn1);
					xValues[0] = xValues[2];
					yValues[0] = yValues[2];
					chessBoard.add(pawn1, xValues[0], yValues[0]);
					chessBoard.getChildren().remove(knight1);
					chessBoard.getChildren().remove(knight1White);
					deadPiece[2] = knight1;

					pawn1a = 0;
					knight1a = 0;
					deadNum = deadNum + 1;
				}
				pawn1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (pawn2a == 1) {
				System.out.println("knight1, pawn2");
				chessBoard.getChildren().remove(pawn2White);
				chessBoard.add(pawn2, xValues[1], yValues[1]);
				if (checkPawn(xValues[1], yValues[1], xValues[2], yValues[2]) == true) {
					chessBoard.getChildren().remove(pawn2);
					xValues[1] = xValues[2];
					yValues[1] = yValues[2];
					chessBoard.add(pawn2, xValues[1], yValues[1]);
					chessBoard.getChildren().remove(knight1);
					chessBoard.getChildren().remove(knight1White);
					deadPiece[2] = knight1;
					pawn2a = 0;
					knight1a = 0;
					deadNum = deadNum + 1;
				}
				pawn2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (knight2a == 1) {
				System.out.println("knight1, knight2");
				chessBoard.getChildren().remove(knight2White);
				chessBoard.add(knight2, xValues[3], yValues[3]);
				if (checkKnight(xValues[3], yValues[3], xValues[2], yValues[2]) == true) {
					chessBoard.getChildren().remove(knight2);
					xValues[3] = xValues[2];
					yValues[3] = yValues[2];
					chessBoard.add(knight2, xValues[3], yValues[3]);
					chessBoard.getChildren().remove(knight1);
					chessBoard.getChildren().remove(knight1White);
					deadPiece[2] = knight1;

					knight2a = 0;
					knight1a = 0;
					deadNum = deadNum + 1;
				}
				knight2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (rook1a == 1) {
				System.out.println("knight1, rook1");
				chessBoard.getChildren().remove(rook1White);
				chessBoard.add(rook1, xValues[4], yValues[4]);
				if (checkRook(xValues[4], yValues[4], xValues[2], yValues[2]) == true) {// CHANEG THIS
					chessBoard.getChildren().remove(rook1);
					xValues[4] = xValues[2];
					yValues[4] = yValues[2];
					chessBoard.add(rook1, xValues[4], yValues[4]);
					chessBoard.getChildren().remove(knight1);
					chessBoard.getChildren().remove(knight1White);
					deadPiece[2] = knight1;

					rook1a = 0;
					knight1a = 0;
					deadNum = deadNum + 1;
				}
				rook1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}
			}
			if (rook2a == 1) {
				System.out.println("knight1, rook2");
				chessBoard.getChildren().remove(rook2White);
				chessBoard.add(rook2, xValues[5], yValues[5]);
				if (checkRook(xValues[5], yValues[5], xValues[2], yValues[2]) == true) {
					chessBoard.getChildren().remove(rook2);
					xValues[5] = xValues[2];
					yValues[5] = yValues[2];
					chessBoard.add(rook2, xValues[5], yValues[5]);
					chessBoard.getChildren().remove(knight1);
					chessBoard.getChildren().remove(knight1White);
					deadPiece[2] = rook2;

					rook2a = 0;
					knight1a = 0;
					deadNum = deadNum + 1;
				}
				rook2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}
			}
		});// if bishopBlack is pressed
		knight2.setOnAction(event -> {
			if (knight2a == 0) {
				System.out.println("knight2 added");
				chessBoard.getChildren().remove(knight2);
				chessBoard.add(knight2White, xValues[3], yValues[3]);
				knight2a = 1;
			}
			if (pawn1a == 1) {
				System.out.println("knight2, pawn1");
				chessBoard.getChildren().remove(pawn1White);
				chessBoard.add(pawn1, xValues[0], yValues[0]);
				if (checkPawn(xValues[0], yValues[0], xValues[3], yValues[3]) == true) {
					chessBoard.getChildren().remove(pawn1);
					xValues[0] = xValues[3];
					yValues[0] = yValues[3];
					chessBoard.add(pawn1, xValues[0], yValues[0]);
					chessBoard.getChildren().remove(knight2);
					chessBoard.getChildren().remove(knight2White);
					deadPiece[3] = knight2;

					pawn1a = 0;
					knight2a = 0;
					deadNum = deadNum + 1;
				}
				pawn1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (pawn2a == 1) {
				System.out.println("knight2, pawn2");
				chessBoard.getChildren().remove(pawn2White);
				chessBoard.add(pawn2, xValues[1], yValues[1]);
				if (checkPawn(xValues[1], yValues[1], xValues[3], yValues[3]) == true) {
					chessBoard.getChildren().remove(pawn2);
					xValues[1] = xValues[3];
					yValues[1] = yValues[3];
					chessBoard.add(pawn2, xValues[1], yValues[1]);
					chessBoard.getChildren().remove(knight2);
					chessBoard.getChildren().remove(knight2White);
					deadPiece[3] = knight2;
					pawn2a = 0;
					knight2a = 0;
					deadNum = deadNum + 1;
				}
				pawn2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (knight1a == 1) {
				System.out.println("knight2, knight1");
				chessBoard.getChildren().remove(knight1White);
				chessBoard.add(knight1, xValues[2], yValues[2]);
				if (checkKnight(xValues[2], yValues[2], xValues[3], yValues[3]) == true) {
					chessBoard.getChildren().remove(knight1);
					xValues[2] = xValues[3];
					yValues[2] = yValues[3];
					chessBoard.add(knight1, xValues[2], yValues[2]);
					chessBoard.getChildren().remove(knight2);
					chessBoard.getChildren().remove(knight2White);
					deadPiece[3] = knight2;

					knight1a = 0;
					knight2a = 0;
					deadNum = deadNum + 1;
				}
				knight1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (rook1a == 1) {
				System.out.println("knight2, rook1");
				chessBoard.getChildren().remove(rook1White);
				chessBoard.add(rook1, xValues[5], yValues[5]);
				if (checkRook(xValues[5], yValues[5], xValues[3], yValues[3]) == true) {
					chessBoard.getChildren().remove(rook1);
					xValues[5] = xValues[3];
					yValues[5] = yValues[3];
					chessBoard.add(rook1, xValues[5], yValues[5]);
					chessBoard.getChildren().remove(knight2);
					chessBoard.getChildren().remove(knight2White);
					deadPiece[3] = knight2;

					rook1a = 0;
					knight2a = 0;
					deadNum = deadNum + 1;
				}
				rook1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (rook2a == 1) {
				System.out.println("knight2, rook2");
				chessBoard.getChildren().remove(rook2White);
				chessBoard.add(rook2, xValues[5], yValues[5]);
				if (checkRook(xValues[5], yValues[5], xValues[3], yValues[3]) == true) {
					chessBoard.getChildren().remove(rook2);
					xValues[5] = xValues[3];
					yValues[5] = yValues[3];
					chessBoard.add(rook2, xValues[5], yValues[5]);
					chessBoard.getChildren().remove(knight2);
					chessBoard.getChildren().remove(knight2White);
					deadPiece[3] = knight2;

					rook2a = 0;
					knight2a = 0;
					deadNum = deadNum + 1;
				}
				rook2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
		});// if bishopBlack is pressed
		rook1.setOnAction(event -> {
			if (rook1a == 0) {
				System.out.println("rook1 added");
				chessBoard.getChildren().remove(rook1);
				chessBoard.add(rook1White, xValues[4], yValues[4]);
				rook1a = 1;
			}
			if (pawn1a == 1) {
				System.out.println("rook1, pawn1");
				chessBoard.getChildren().remove(pawn1White);
				chessBoard.add(pawn1, xValues[0], yValues[0]);
				if (checkPawn(xValues[0], yValues[0], xValues[4], yValues[4]) == true) {
					chessBoard.getChildren().remove(pawn1);
					xValues[0] = xValues[4];
					yValues[0] = yValues[4];
					chessBoard.add(pawn1, xValues[0], yValues[0]);
					chessBoard.getChildren().remove(rook1);
					chessBoard.getChildren().remove(rook1White);
					deadPiece[4] = rook1;
					pawn1a = 0;
					rook1a = 0;
					deadNum = deadNum + 1;
				}
				pawn1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (pawn2a == 1) {
				System.out.println("rook1, pawn2");
				chessBoard.getChildren().remove(pawn2White);
				chessBoard.add(pawn2, xValues[1], yValues[1]);
				if (checkPawn(xValues[1], yValues[1], xValues[4], yValues[4]) == true) {
					chessBoard.getChildren().remove(pawn2);
					xValues[1] = xValues[4];
					yValues[1] = yValues[4];
					chessBoard.add(pawn2, xValues[1], yValues[1]);
					chessBoard.getChildren().remove(rook1);
					chessBoard.getChildren().remove(rook1White);
					deadPiece[4] = rook1;
					pawn2a = 0;
					rook1a = 0;
					deadNum = deadNum + 1;
				}
				pawn2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}
				System.out.println(pawn2a);

			}
			if (knight1a == 1) {
				System.out.println("rook1, knight1");
				chessBoard.getChildren().remove(knight1White);
				chessBoard.add(knight1White, xValues[2], yValues[2]);
				if (checkKnight(xValues[2], yValues[2], xValues[4], yValues[4]) == true) {
					chessBoard.getChildren().remove(knight1);
					xValues[2] = xValues[4];
					yValues[2] = yValues[4];
					chessBoard.add(knight1, xValues[2], yValues[2]);
					chessBoard.getChildren().remove(rook1);
					chessBoard.getChildren().remove(rook1White);
					deadPiece[4] = rook1;

					knight1a = 0;
					rook1a = 0;
					deadNum = deadNum + 1;
				}
				knight1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (knight2a == 1) {
				System.out.println("rook1, knight2");
				chessBoard.getChildren().remove(knight2White);
				chessBoard.add(knight2White, xValues[3], yValues[3]);
				if (checkKnight(xValues[3], yValues[3], xValues[4], yValues[4]) == true) {
					chessBoard.getChildren().remove(knight2White);
					xValues[3] = xValues[4];
					yValues[3] = yValues[4];
					chessBoard.add(knight2, xValues[3], yValues[3]);
					chessBoard.getChildren().remove(rook1);
					chessBoard.getChildren().remove(rook1White);
					deadPiece[4] = rook1;
					knight2a = 0;
					rook1a = 0;
					deadNum = deadNum + 1;
				}
				knight2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (rook2a == 1) {
				System.out.println("rook1, rook2");
				chessBoard.getChildren().remove(rook2White);
				chessBoard.add(rook2, xValues[5], yValues[5]);
				if (checkRook(xValues[5], yValues[5], xValues[4], yValues[4]) == true) {
					chessBoard.getChildren().remove(rook2);
					xValues[5] = xValues[4];
					yValues[5] = yValues[4];
					chessBoard.add(rook2, xValues[5], yValues[5]);
					chessBoard.getChildren().remove(rook1);
					chessBoard.getChildren().remove(rook1White);
					deadPiece[4] = rook1;

					rook2a = 0;
					rook1a = 0;
					deadNum = deadNum + 1;
				}
				rook2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}

		});// if bishopBlack is pressed
		rook2.setOnAction(event -> {
			if (rook2a == 0) {
				System.out.println("rook2 added");
				chessBoard.getChildren().remove(rook2);
				chessBoard.add(rook2White, xValues[5], yValues[5]);
				rook2a = 1;
			}
			if (pawn1a == 1) {
				System.out.println("rook2, pawn1");
				chessBoard.getChildren().remove(pawn1White);
				chessBoard.add(pawn1, xValues[0], yValues[0]);
				if (checkPawn(xValues[0], yValues[0], xValues[5], yValues[5]) == true) {
					chessBoard.getChildren().remove(pawn1);
					xValues[0] = xValues[5];
					yValues[0] = yValues[5];
					chessBoard.add(pawn1, xValues[0], yValues[0]);
					chessBoard.getChildren().remove(rook2);
					chessBoard.getChildren().remove(rook2White);
					deadPiece[5] = rook2;

					pawn1a = 0;
					rook2a = 0;
					deadNum = deadNum + 1;
				}
				pawn1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (pawn2a == 1) {
				System.out.println("rook2, pawn2");
				chessBoard.getChildren().remove(pawn2White);
				chessBoard.add(pawn2, xValues[1], yValues[1]);
				if (checkPawn(xValues[1], yValues[1], xValues[5], yValues[5]) == true) {
					chessBoard.getChildren().remove(pawn2);
					xValues[1] = xValues[5];
					yValues[1] = yValues[5];
					chessBoard.add(pawn2, xValues[1], yValues[1]);
					chessBoard.getChildren().remove(rook2);
					chessBoard.getChildren().remove(rook2White);
					deadPiece[5] = rook2;
					pawn2a = 0;
					rook2a = 0;
					deadNum = deadNum + 1;
				}
				pawn2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (knight1a == 1) {
				System.out.println("rook2, knight1");
				chessBoard.getChildren().remove(knight1White);
				chessBoard.add(knight1, xValues[2], yValues[2]);
				if (checkKnight(xValues[2], yValues[2], xValues[5], yValues[5]) == true) {
					chessBoard.getChildren().remove(knight1);
					xValues[2] = xValues[5];
					yValues[2] = yValues[5];
					chessBoard.add(knight1, xValues[2], yValues[2]);
					chessBoard.getChildren().remove(rook2);
					chessBoard.getChildren().remove(rook2White);
					deadPiece[5] = rook2;

					knight1a = 0;
					rook2a = 0;
					deadNum = deadNum + 1;
				}
				knight1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}
			if (knight2a == 1) {
				System.out.println("rook2, knight2");
				chessBoard.getChildren().remove(knight2White);
				chessBoard.add(knight2, xValues[3], yValues[3]);
				if (checkKnight(xValues[3], yValues[3], xValues[5], yValues[5]) == true) {
					chessBoard.getChildren().remove(knight2);
					xValues[3] = xValues[5];
					yValues[3] = yValues[5];
					chessBoard.add(knight2, xValues[3], yValues[3]);
					chessBoard.getChildren().remove(rook2);
					chessBoard.getChildren().remove(rook2White);
					deadPiece[5] = rook2;

					knight2a = 0;
					rook2a = 0;
					deadNum = deadNum + 1;
				}
				knight2a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}
			}
			if (rook1a == 1) {
				System.out.println("rook2, rook1");
				chessBoard.getChildren().remove(rook1White);
				chessBoard.add(rook1, xValues[5], yValues[5]);
				if (checkRook(xValues[5], yValues[5], xValues[4], yValues[4]) == true) {
					chessBoard.getChildren().remove(rook1);
					xValues[5] = xValues[4];
					yValues[5] = yValues[4];
					chessBoard.add(rook1, xValues[5], yValues[5]);
					chessBoard.getChildren().remove(rook2);
					chessBoard.getChildren().remove(rook2);
					deadPiece[4] = rook2;

					rook1a = 0;
					rook2a = 0;
					deadNum = deadNum + 1;
				}
				rook1a = 0;
				if (deadNum == 5) {
					winScreen(stage);
				}

			}

		});// if bishopBlack is pressed
		return chessBoard;

	}

	public static GridPane level4Chessboard(Stage stage, Button pawn1, Button pawn1White, Button pawn2,
			Button pawn2White, Button rook1, Button rook1White, Button rook2, Button rook2White, Button knight1,
			Button knight1White, Button knight2, Button knight2White, Button bishop1, Button bishop1White,
			Button bishop2, Button bishop2White) {
		// POS of pawn1, pawn2, , knight1, knight2,bishop1, bishop2, rook1, rook2
		int[] xValues = { 2, 2, 3, 3, 1, 4, 1, 4 };
		int[] yValues = { 0, 1, 0, 1, 2, 2, 3, 3 };
		// Creating a Grid Pane
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

		chessBoard.add(square1, 1, 0);
		chessBoard.add(square2, 2, 0);
		chessBoard.add(square3, 3, 0);
		chessBoard.add(square4, 4, 0);// first row of squares
		chessBoard.add(square5, 1, 1);
		chessBoard.add(square6, 2, 1);
		chessBoard.add(square7, 3, 1);
		chessBoard.add(square8, 4, 1);// second row of squares
		chessBoard.add(square9, 1, 2);
		chessBoard.add(square10, 2, 2);
		chessBoard.add(square11, 3, 2);
		chessBoard.add(square12, 4, 2);// first row of squares
		chessBoard.add(square13, 1, 3);
		chessBoard.add(square14, 2, 3);
		chessBoard.add(square15, 3, 3);
		chessBoard.add(square16, 4, 3);// first row of squares

		Button[][] tile = new Button[4][5];
		for (int row = 0; row < 4; row++) {
			for (int col = 1; col < 5; col++) {
				Button button = new Button();
				button.setMinSize(100, 100);
				tile[row][col] = button; // 2D array of buttons on the same grid as the chessboard
				button.setStyle("-fx-background-color: rgba(0, 0, 0, 0.0);"); // so it shows the button when i need
				// to(change final value 0.0 - 1.0)
				chessBoard.add(button, col, row); // Add the button to the grid pane
				final int currentRow = row;
				final int currentCol = col;
				button.setOnAction(event -> {
					if (xValues[0] != currentCol && yValues[0] != currentRow) {// if the boar dis pressed with no pieces
						// all of the pices turn black
						if (pawn1a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn1, xValues[0], yValues[0]);
							pawn1a = 0;
						}
						if (pawn2a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn2, xValues[1], yValues[1]);
							pawn2a = 0;
						}
						if (knight1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(knight1White);
							chessBoard.add(knight1, xValues[2], yValues[2]);
							knight1a = 0;
						}
						if (knight2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(knight2White);
							chessBoard.add(knight2, xValues[3], yValues[3]);
							knight2a = 0;
						}
						if (bishop1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(bishop1White);
							chessBoard.add(bishop1, xValues[4], yValues[4]);
							bishop1a = 0;
						}
						if (bishop2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(bishop2White);
							chessBoard.add(bishop2, xValues[5], yValues[5]);
							bishop2a = 0;
						}
						if (rook1a == 1) {// ssame thing as pawn knight and queen
							chessBoard.getChildren().remove(rook1White);
							chessBoard.add(rook1, xValues[6], yValues[6]);
							rook1a = 0;

						}
						if (rook2a == 1) {// ssame thing as pawn knight and queen
							chessBoard.getChildren().remove(rook2White);
							chessBoard.add(rook2, xValues[7], yValues[7]);
							rook2a = 0;

						}

					}
					if (xValues[1] != currentCol && yValues[1] != currentRow) {// if the boar dis pressed with no pieces
						// all of the pices turn black
						if (pawn1a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn1, xValues[0], yValues[0]);
							pawn1a = 0;
						}
						if (pawn2a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn2, xValues[1], yValues[1]);
							pawn2a = 0;
						}
						if (knight1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(knight1White);
							chessBoard.add(knight1, xValues[2], yValues[2]);
							knight1a = 0;
						}
						if (knight2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(knight2White);
							chessBoard.add(knight2, xValues[3], yValues[3]);
							knight2a = 0;
						}
						if (bishop1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(bishop1White);
							chessBoard.add(bishop1, xValues[4], yValues[4]);
							bishop1a = 0;
						}
						if (bishop2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(bishop2White);
							chessBoard.add(bishop2, xValues[5], yValues[5]);
							bishop2a = 0;
						}
						if (rook1a == 1) {// ssame thing as pawn knight and queen
							chessBoard.getChildren().remove(rook1White);
							chessBoard.add(rook1, xValues[6], yValues[6]);
							rook1a = 0;

						}
						if (rook2a == 1) {// ssame thing as pawn knight and queen
							chessBoard.getChildren().remove(rook2White);
							chessBoard.add(rook2, xValues[7], yValues[7]);
							rook2a = 0;

						}

					}
					if (xValues[2] != currentCol && yValues[2] != currentRow) {// if the boar dis pressed with no pieces
						// all of the pices turn black
						if (pawn1a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn1, xValues[0], yValues[0]);
							pawn1a = 0;
						}
						if (pawn2a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn2, xValues[1], yValues[1]);
							pawn2a = 0;
						}
						if (knight1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(knight1White);
							chessBoard.add(knight1, xValues[2], yValues[2]);
							knight1a = 0;
						}
						if (knight2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(knight2White);
							chessBoard.add(knight2, xValues[3], yValues[3]);
							knight2a = 0;
						}
						if (bishop1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(bishop1White);
							chessBoard.add(bishop1, xValues[4], yValues[4]);
							bishop1a = 0;
						}
						if (bishop2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(bishop2White);
							chessBoard.add(bishop2, xValues[5], yValues[5]);
							bishop2a = 0;
						}
						if (rook1a == 1) {// ssame thing as pawn knight and queen
							chessBoard.getChildren().remove(rook1White);
							chessBoard.add(rook1, xValues[6], yValues[6]);
							rook1a = 0;

						}
						if (rook2a == 1) {// ssame thing as pawn knight and queen
							chessBoard.getChildren().remove(rook2White);
							chessBoard.add(rook2, xValues[7], yValues[7]);
							rook2a = 0;

						}

					}
					if (xValues[3] != currentCol && yValues[3] != currentRow) {// if the boar dis pressed with no pieces
						// all of the pices turn black
						if (pawn1a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn1, xValues[0], yValues[0]);
							pawn1a = 0;
						}
						if (pawn2a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn2, xValues[1], yValues[1]);
							pawn2a = 0;
						}
						if (knight1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(knight1White);
							chessBoard.add(knight1, xValues[2], yValues[2]);
							knight1a = 0;
						}
						if (knight2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(knight2White);
							chessBoard.add(knight2, xValues[3], yValues[3]);
							knight2a = 0;
						}
						if (bishop1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(bishop1White);
							chessBoard.add(bishop1, xValues[4], yValues[4]);
							bishop1a = 0;
						}
						if (bishop2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(bishop2White);
							chessBoard.add(bishop2, xValues[5], yValues[5]);
							bishop2a = 0;
						}
						if (rook1a == 1) {// ssame thing as pawn knight and queen
							chessBoard.getChildren().remove(rook1White);
							chessBoard.add(rook1, xValues[6], yValues[6]);
							rook1a = 0;

						}
						if (rook2a == 1) {// ssame thing as pawn knight and queen
							chessBoard.getChildren().remove(rook2White);
							chessBoard.add(rook2, xValues[7], yValues[7]);
							rook2a = 0;

						}

					}
					if (xValues[4] != currentCol && yValues[4] != currentRow) {// if the boar dis pressed with no pieces
						// all of the pices turn black
						if (pawn1a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn1, xValues[0], yValues[0]);
							pawn1a = 0;
						}
						if (pawn2a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn2, xValues[1], yValues[1]);
							pawn2a = 0;
						}
						if (knight1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(knight1White);
							chessBoard.add(knight1, xValues[2], yValues[2]);
							knight1a = 0;
						}
						if (knight2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(knight2White);
							chessBoard.add(knight2, xValues[3], yValues[3]);
							knight2a = 0;
						}
						if (bishop1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(bishop1White);
							chessBoard.add(bishop1, xValues[4], yValues[4]);
							bishop1a = 0;
						}
						if (bishop2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(bishop2White);
							chessBoard.add(bishop2, xValues[5], yValues[5]);
							bishop2a = 0;
						}
						if (rook1a == 1) {// ssame thing as pawn knight and queen
							chessBoard.getChildren().remove(rook1White);
							chessBoard.add(rook1, xValues[6], yValues[6]);
							rook1a = 0;

						}
						if (rook2a == 1) {// ssame thing as pawn knight and queen
							chessBoard.getChildren().remove(rook2White);
							chessBoard.add(rook2, xValues[7], yValues[7]);
							rook2a = 0;

						}

					}
					if (xValues[5] != currentCol && yValues[5] != currentRow) {// if the boar dis pressed with no pieces
						// all of the pices turn black
						if (pawn1a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn1, xValues[0], yValues[0]);
							pawn1a = 0;
						}
						if (pawn2a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn2, xValues[1], yValues[1]);
							pawn2a = 0;
						}
						if (knight1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(knight1White);
							chessBoard.add(knight1, xValues[2], yValues[2]);
							knight1a = 0;
						}
						if (knight2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(knight2White);
							chessBoard.add(knight2, xValues[3], yValues[3]);
							knight2a = 0;
						}
						if (bishop1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(bishop1White);
							chessBoard.add(bishop1, xValues[4], yValues[4]);
							bishop1a = 0;
						}
						if (bishop2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(bishop2White);
							chessBoard.add(bishop2, xValues[5], yValues[5]);
							bishop2a = 0;
						}
						if (rook1a == 1) {// ssame thing as pawn knight and queen
							chessBoard.getChildren().remove(rook1White);
							chessBoard.add(rook1, xValues[6], yValues[6]);
							rook1a = 0;

						}
						if (rook2a == 1) {// ssame thing as pawn knight and queen
							chessBoard.getChildren().remove(rook2White);
							chessBoard.add(rook2, xValues[7], yValues[7]);
							rook2a = 0;

						}

					}
					if (xValues[6] != currentCol && yValues[6] != currentRow) {// if the boar dis pressed with no pieces
						// all of the pices turn black
						if (pawn1a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn1, xValues[0], yValues[0]);
							pawn1a = 0;
						}
						if (pawn2a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn2, xValues[1], yValues[1]);
							pawn2a = 0;
						}
						if (knight1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(knight1White);
							chessBoard.add(knight1, xValues[2], yValues[2]);
							knight1a = 0;
						}
						if (knight2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(knight2White);
							chessBoard.add(knight2, xValues[3], yValues[3]);
							knight2a = 0;
						}
						if (bishop1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(bishop1White);
							chessBoard.add(bishop1, xValues[4], yValues[4]);
							bishop1a = 0;
						}
						if (bishop2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(bishop2White);
							chessBoard.add(bishop2, xValues[5], yValues[5]);
							bishop2a = 0;
						}
						if (rook1a == 1) {// ssame thing as pawn knight and queen
							chessBoard.getChildren().remove(rook1White);
							chessBoard.add(rook1, xValues[6], yValues[6]);
							rook1a = 0;

						}
						if (rook2a == 1) {// ssame thing as pawn knight and queen
							chessBoard.getChildren().remove(rook2White);
							chessBoard.add(rook2, xValues[7], yValues[7]);
							rook2a = 0;

						}

					}
					if (xValues[7] != currentCol && yValues[7] != currentRow) {// if the boar dis pressed with no pieces
						// all of the pices turn black
						if (pawn1a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn1, xValues[0], yValues[0]);
							pawn1a = 0;
						}
						if (pawn2a == 1) {
							chessBoard.getChildren().remove(pawn1White);// if white pawn is already white, make it black
							chessBoard.add(pawn2, xValues[1], yValues[1]);
							pawn2a = 0;
						}
						if (knight1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(knight1White);
							chessBoard.add(knight1, xValues[2], yValues[2]);
							knight1a = 0;
						}
						if (knight2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(knight2White);
							chessBoard.add(knight2, xValues[3], yValues[3]);
							knight2a = 0;
						}
						if (bishop1a == 1) {// if bishop is already white, make it black
							chessBoard.getChildren().remove(bishop1White);
							chessBoard.add(bishop1, xValues[4], yValues[4]);
							bishop1a = 0;
						}
						if (bishop2a == 1) {// if queen is already white, make it black
							chessBoard.getChildren().remove(bishop2White);
							chessBoard.add(bishop2, xValues[5], yValues[5]);
							bishop2a = 0;
						}
						if (rook1a == 1) {// ssame thing as pawn knight and queen
							chessBoard.getChildren().remove(rook1White);
							chessBoard.add(rook1, xValues[6], yValues[6]);
							rook1a = 0;

						}
						if (rook2a == 1) {// ssame thing as pawn knight and queen
							chessBoard.getChildren().remove(rook2White);
							chessBoard.add(rook2, xValues[7], yValues[7]);
							rook2a = 0;

						}

					}

				});
			}
		}

		chessBoard.add(pawn1, xValues[0], yValues[0]);// adds the piecs to the board
		chessBoard.add(pawn2, xValues[1], yValues[1]);
		chessBoard.add(knight1, xValues[2], yValues[2]);
		chessBoard.add(knight2, xValues[3], yValues[3]);
		chessBoard.add(bishop1, xValues[4], yValues[4]);
		chessBoard.add(bishop2, xValues[5], yValues[5]);
		chessBoard.add(rook1, xValues[6], yValues[6]);
		chessBoard.add(rook2, xValues[7], yValues[7]);

		Button[] deadPiece = new Button[8];// might not need this but but an array for dead pieces on the board

		pawn1.setOnAction(event -> {

			System.out.println("pawn1");
			if (pawn1a == 0) {
				chessBoard.getChildren().remove(pawn1);
				chessBoard.add(pawn1White, xValues[0], yValues[0]);
				pawn1a = 1;
			}
			if (pawn2a == 1) {
				System.out.println("pawn1, pawn2");
				chessBoard.getChildren().remove(pawn2White);
				chessBoard.add(pawn2, xValues[1], yValues[1]);
				if (checkPawn(xValues[1], yValues[1], xValues[0], yValues[0]) == true) {
					chessBoard.getChildren().remove(pawn2);
					xValues[1] = xValues[0];
					yValues[1] = yValues[0];
					chessBoard.add(pawn2, xValues[1], yValues[1]);
					chessBoard.getChildren().remove(pawn1);
					chessBoard.getChildren().remove(pawn1White);
					deadPiece[0] = pawn1;
					pawn2a = 0;
					pawn1a = 0;
					deadNum = deadNum + 1;
				}
				pawn2a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
			if (knight1a == 1) {
				System.out.println("pawn1, knight1");
				System.out.println("pawn1 removed, bishop1 added");
				chessBoard.getChildren().remove(knight1White);
				chessBoard.add(knight1, xValues[2], yValues[2]);
				if (checkKnight(xValues[2], yValues[2], xValues[0], yValues[0]) == true) {
					chessBoard.getChildren().remove(knight1);
					xValues[2] = xValues[0];
					yValues[2] = yValues[0];
					chessBoard.add(knight1, xValues[2], yValues[2]);
					chessBoard.getChildren().remove(pawn1);
					chessBoard.getChildren().remove(pawn1White);
					deadPiece[0] = pawn1;

					knight1a = 0;
					pawn1a = 0;
					deadNum = deadNum + 1;
				}
				knight1a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
			if (knight2a == 1) {
				System.out.println("pawn1, knight2");
				chessBoard.getChildren().remove(knight2White);
				chessBoard.add(knight2, xValues[3], yValues[3]);
				if (checkKnight(xValues[3], yValues[3], xValues[0], yValues[0]) == true) {
					chessBoard.getChildren().remove(knight2);
					xValues[3] = xValues[0];
					yValues[3] = yValues[0];
					chessBoard.add(knight2, xValues[3], yValues[3]);
					chessBoard.getChildren().remove(pawn1);
					chessBoard.getChildren().remove(pawn1White);
					deadPiece[0] = pawn1;

					knight2a = 0;
					pawn1a = 0;
					deadNum = deadNum + 1;
				}
				knight2a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}
			}
			if (bishop1a == 1) {
				System.out.println("pawn1 removed, bishop1 added");
				chessBoard.getChildren().remove(bishop1White);
				chessBoard.add(bishop1, xValues[4], yValues[4]);
				if (checkBishop(xValues[4], yValues[4], xValues[0], yValues[0], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishop1);
					xValues[4] = xValues[0];
					yValues[4] = yValues[0];
					chessBoard.add(bishop1, xValues[4], yValues[4]);
					chessBoard.getChildren().remove(pawn1);
					chessBoard.getChildren().remove(pawn1White);
					deadPiece[0] = pawn1;

					bishop1a = 0;
					pawn1a = 0;
					deadNum = deadNum + 1;
				}
				bishop1a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
			if (bishop2a == 1) {
				System.out.println("pawn1 removed, bishop2 added");
				chessBoard.getChildren().remove(bishop2White);
				chessBoard.add(bishop2, xValues[5], yValues[5]);
				if (checkBishop(xValues[5], yValues[5], xValues[0], yValues[0], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishop2);
					xValues[5] = xValues[0];
					yValues[5] = yValues[0];
					chessBoard.add(bishop2, xValues[5], yValues[5]);
					chessBoard.getChildren().remove(pawn1);
					chessBoard.getChildren().remove(pawn1White);
					deadPiece[0] = pawn1;

					bishop2a = 0;
					pawn1a = 0;
					deadNum = deadNum + 1;
				}
				bishop2a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}
			}
			if (rook1a == 1) {
				System.out.println("pawn1, rook1");
				chessBoard.getChildren().remove(rook1White);
				chessBoard.add(rook1, xValues[6], yValues[6]);
				if (checkRook(xValues[6], yValues[6], xValues[0], yValues[0]) == true) {
					chessBoard.getChildren().remove(rook1);
					xValues[6] = xValues[0];
					yValues[6] = yValues[0];
					chessBoard.add(rook1, xValues[6], yValues[6]);
					chessBoard.getChildren().remove(pawn1);
					chessBoard.getChildren().remove(pawn1White);
					deadPiece[0] = pawn1;

					rook1a = 0;
					pawn1a = 0;
					deadNum = deadNum + 1;
				}
				rook1a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
			if (rook2a == 1) {
				System.out.println("pawn1, rook2");
				chessBoard.getChildren().remove(rook2White);
				chessBoard.add(rook2, xValues[7], yValues[7]);
				if (checkRook(xValues[7], yValues[7], xValues[0], yValues[0]) == true) {
					chessBoard.getChildren().remove(rook2);
					xValues[7] = xValues[0];
					yValues[7] = yValues[0];
					chessBoard.add(rook2, xValues[7], yValues[7]);
					chessBoard.getChildren().remove(pawn1);
					chessBoard.getChildren().remove(pawn1White);
					deadPiece[0] = pawn1;

					rook2a = 0;
					pawn1a = 0;
					deadNum = deadNum + 1;
				}
				rook2a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
		});// if bishopBlack is pressed
		pawn2.setOnAction(event -> {
			System.out.println("pawn2");
			if (pawn2a == 0) {
				chessBoard.getChildren().remove(pawn2);
				chessBoard.add(pawn2White, xValues[1], yValues[1]);
				pawn2a = 1;
			}
			if (pawn1a == 1) {
				System.out.println("pawn1, pawn2");
				chessBoard.getChildren().remove(pawn1White);
				chessBoard.add(pawn1, xValues[0], yValues[0]);
				if (checkPawn(xValues[0], yValues[0], xValues[1], yValues[1]) == true) {
					chessBoard.getChildren().remove(pawn1);
					xValues[0] = xValues[1];
					yValues[0] = yValues[1];
					chessBoard.add(pawn1, xValues[0], yValues[0]);
					chessBoard.getChildren().remove(pawn2);
					chessBoard.getChildren().remove(pawn2White);
					deadPiece[0] = pawn2;
					pawn1a = 0;
					pawn2a = 0;
					deadNum = deadNum + 1;
				}
				pawn1a = 0;
				if (deadNum == 8) {
					winScreen(stage);
				}

			}
			if (knight1a == 1) {
				System.out.println("pawn2, knight1");
				System.out.println("pawn2 removed, knight1 added");
				chessBoard.getChildren().remove(knight1White);
				chessBoard.add(knight1, xValues[2], yValues[2]);
				if (checkKnight(xValues[2], yValues[2], xValues[1], yValues[1]) == true) {
					chessBoard.getChildren().remove(knight1);
					xValues[2] = xValues[1];
					yValues[2] = yValues[1];
					chessBoard.add(knight1, xValues[2], yValues[2]);
					chessBoard.getChildren().remove(pawn2);
					chessBoard.getChildren().remove(pawn2White);
					deadPiece[0] = pawn2;

					knight1a = 0;
					pawn2a = 0;
					deadNum = deadNum + 1;
				}
				knight1a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
			if (knight2a == 1) {
				System.out.println("pawn2, knight2");
				chessBoard.getChildren().remove(knight2White);
				chessBoard.add(knight2, xValues[3], yValues[3]);
				if (checkKnight(xValues[3], yValues[3], xValues[1], yValues[1]) == true) {
					chessBoard.getChildren().remove(knight2);
					xValues[3] = xValues[1];
					yValues[3] = yValues[1];
					chessBoard.add(knight2, xValues[3], yValues[3]);
					chessBoard.getChildren().remove(pawn2);
					chessBoard.getChildren().remove(pawn2White);
					deadPiece[3] = pawn2;

					knight2a = 0;
					pawn2a = 0;
					deadNum = deadNum + 1;
				}
				knight2a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}
			}
			if (bishop1a == 1) {
				System.out.println("pawn2 removed, bishop1 added");
				chessBoard.getChildren().remove(bishop1White);
				chessBoard.add(bishop1, xValues[4], yValues[4]);
				if (checkBishop(xValues[4], yValues[4], xValues[1], yValues[1], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishop1);
					xValues[4] = xValues[1];
					yValues[4] = yValues[1];
					chessBoard.add(bishop1, xValues[4], yValues[4]);
					chessBoard.getChildren().remove(pawn2);
					chessBoard.getChildren().remove(pawn2White);
					deadPiece[0] = pawn2;

					bishop1a = 0;
					pawn2a = 0;
					deadNum = deadNum + 1;
				}
				bishop1a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
			if (bishop2a == 1) {
				System.out.println("pawn2 removed, bishop2 added");
				chessBoard.getChildren().remove(bishop2White);
				chessBoard.add(bishop2, xValues[5], yValues[5]);
				if (checkBishop(xValues[5], yValues[5], xValues[1], yValues[1], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishop2);
					xValues[5] = xValues[1];
					yValues[5] = yValues[1];
					chessBoard.add(bishop2, xValues[5], yValues[5]);
					chessBoard.getChildren().remove(pawn1);
					chessBoard.getChildren().remove(pawn1White);
					deadPiece[0] = pawn1;

					bishop2a = 0;
					pawn2a = 0;
					deadNum = deadNum + 1;
				}
				bishop2a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}
			}
			if (rook1a == 1) {
				System.out.println("pawn1, rook1");
				chessBoard.getChildren().remove(rook1White);
				chessBoard.add(rook1, xValues[6], yValues[6]);
				if (checkRook(xValues[6], yValues[6], xValues[1], yValues[1]) == true) {
					chessBoard.getChildren().remove(rook1);
					xValues[6] = xValues[1];
					yValues[6] = yValues[1];
					chessBoard.add(rook1, xValues[6], yValues[6]);
					chessBoard.getChildren().remove(pawn2);
					chessBoard.getChildren().remove(pawn2White);
					deadPiece[6] = pawn2;

					rook1a = 0;
					pawn2a = 0;
					deadNum = deadNum + 1;
				}
				rook1a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
			if (rook2a == 1) {
				System.out.println("pawn2, rook2");
				chessBoard.getChildren().remove(rook2White);
				chessBoard.add(rook2, xValues[7], yValues[7]);
				if (checkRook(xValues[7], yValues[7], xValues[1], yValues[1]) == true) {
					chessBoard.getChildren().remove(rook2);
					xValues[7] = xValues[1];
					yValues[7] = yValues[1];
					chessBoard.add(rook2, xValues[7], yValues[7]);
					chessBoard.getChildren().remove(pawn2);
					chessBoard.getChildren().remove(pawn2White);
					deadPiece[7] = pawn2;

					rook2a = 0;
					pawn2a = 0;
					deadNum = deadNum + 1;
				}
				rook2a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
		});// if bishopBlack is pressed
		knight1.setOnAction(event -> {
			System.out.println("knight1");
			if (knight1a == 0) {
				chessBoard.getChildren().remove(knight1);
				chessBoard.add(knight1White, xValues[2], yValues[2]);
				knight1a = 1;
			}
			if (pawn1a == 1) {
				System.out.println("knight1, pawn2");
				chessBoard.getChildren().remove(pawn1White);
				chessBoard.add(pawn1, xValues[0], yValues[0]);
				if (checkPawn(xValues[0], yValues[0], xValues[2], yValues[2]) == true) {
					chessBoard.getChildren().remove(pawn1);
					xValues[0] = xValues[2];
					yValues[0] = yValues[2];
					chessBoard.add(pawn1, xValues[0], yValues[0]);
					chessBoard.getChildren().remove(knight1);
					chessBoard.getChildren().remove(knight1White);
					deadPiece[0] = pawn2;
					pawn1a = 0;
					knight1a = 0;
					deadNum = deadNum + 1;
				}
				pawn1a = 0;
				if (deadNum == 8) {
					winScreen(stage);
				}

			}
			if (pawn2a == 1) {
				System.out.println("knight1, pawn2");
				chessBoard.getChildren().remove(pawn2White);
				chessBoard.add(pawn2, xValues[1], yValues[1]);
				if (checkPawn(xValues[1], yValues[1], xValues[2], yValues[2]) == true) {
					chessBoard.getChildren().remove(pawn2);
					xValues[1] = xValues[2];
					yValues[1] = yValues[2];
					chessBoard.add(pawn2, xValues[1], yValues[1]);
					chessBoard.getChildren().remove(knight1);
					chessBoard.getChildren().remove(knight1White);
					deadPiece[0] = pawn2;
					pawn2a = 0;
					knight1a = 0;
					deadNum = deadNum + 1;
				}
				pawn2a = 0;
				if (deadNum == 8) {
					winScreen(stage);
				}

			}
			if (knight2a == 1) {
				System.out.println("knight1, knight2");
				System.out.println("knight1 removed, knight2 added");
				chessBoard.getChildren().remove(knight2White);
				chessBoard.add(knight2, xValues[3], yValues[3]);
				if (checkKnight(xValues[3], yValues[3], xValues[2], yValues[2]) == true) {
					chessBoard.getChildren().remove(knight2);
					xValues[3] = xValues[2];
					yValues[3] = yValues[2];
					chessBoard.add(knight2, xValues[3], yValues[3]);
					chessBoard.getChildren().remove(knight1);
					chessBoard.getChildren().remove(knight1White);
					deadPiece[2] = knight1;

					knight2a = 0;
					knight1a = 0;
					deadNum = deadNum + 1;
				}
				knight2a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}

			if (bishop1a == 1) {
				System.out.println("knight1 removed, bishop1 added");
				chessBoard.getChildren().remove(bishop1White);
				chessBoard.add(bishop1, xValues[4], yValues[4]);
				if (checkBishop(xValues[4], yValues[4], xValues[2], yValues[2], xValues, yValues) == true) {
					System.out.println("Hello");
					chessBoard.getChildren().remove(bishop1);
					xValues[4] = xValues[2];
					yValues[4] = yValues[2];
					chessBoard.add(bishop1, xValues[4], yValues[4]);
					chessBoard.getChildren().remove(knight1);
					chessBoard.getChildren().remove(knight1White);
					deadPiece[4] = knight1;

					bishop1a = 0;
					knight1a = 0;
					deadNum = deadNum + 1;
				}
				bishop1a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
			if (bishop2a == 1) {
				System.out.println("pawn2 removed, bishop2 added");
				chessBoard.getChildren().remove(bishop2White);
				chessBoard.add(bishop2, xValues[5], yValues[5]);
				if (checkBishop(xValues[5], yValues[5], xValues[2], yValues[2], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishop2);
					xValues[5] = xValues[2];
					yValues[5] = yValues[2];
					chessBoard.add(bishop2, xValues[5], yValues[5]);
					chessBoard.getChildren().remove(knight1);
					chessBoard.getChildren().remove(knight1White);
					deadPiece[5] = pawn1;

					bishop2a = 0;
					knight1a = 0;
					deadNum = deadNum + 1;
				}
				bishop2a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}
			}
			if (rook1a == 1) {
				System.out.println("pawn1, rook1");
				chessBoard.getChildren().remove(rook1White);
				chessBoard.add(rook1, xValues[6], yValues[6]);
				if (checkRook(xValues[6], yValues[6], xValues[2], yValues[2]) == true) {
					chessBoard.getChildren().remove(rook1);
					xValues[6] = xValues[2];
					yValues[6] = yValues[2];
					chessBoard.add(rook1, xValues[6], yValues[6]);
					chessBoard.getChildren().remove(knight1);
					chessBoard.getChildren().remove(knight1White);
					deadPiece[6] = pawn2;

					rook1a = 0;
					knight1a = 0;
					deadNum = deadNum + 1;
				}
				rook1a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
			if (rook2a == 1) {
				System.out.println("pawn2, rook2");
				chessBoard.getChildren().remove(rook2White);
				chessBoard.add(rook2, xValues[7], yValues[7]);
				if (checkRook(xValues[7], yValues[7], xValues[2], yValues[2]) == true) {
					chessBoard.getChildren().remove(rook2);
					xValues[7] = xValues[2];
					yValues[7] = yValues[2];
					chessBoard.add(rook2, xValues[7], yValues[7]);
					chessBoard.getChildren().remove(knight1);
					chessBoard.getChildren().remove(knight1White);
					deadPiece[7] = pawn2;

					rook2a = 0;
					knight1a = 0;
					deadNum = deadNum + 1;
				}
				rook2a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
		});// if bishopBlack is pressed
		knight2.setOnAction(event -> {
			if (knight2a == 0) {
				System.out.println("knight2 added");
				chessBoard.getChildren().remove(knight2);
				chessBoard.add(knight2White, xValues[3], yValues[3]);
				knight2a = 1;
			}
			if (pawn1a == 1) {
				System.out.println("knight2, pawn1");
				chessBoard.getChildren().remove(pawn1White);
				chessBoard.add(pawn1, xValues[0], yValues[0]);
				if (checkPawn(xValues[0], yValues[0], xValues[3], yValues[3]) == true) {
					chessBoard.getChildren().remove(pawn1);
					xValues[0] = xValues[3];
					yValues[0] = yValues[3];
					chessBoard.add(pawn1, xValues[0], yValues[0]);
					chessBoard.getChildren().remove(knight2);
					chessBoard.getChildren().remove(knight2White);
					deadPiece[0] = pawn2;
					pawn1a = 0;
					knight2a = 0;
					deadNum = deadNum + 1;
				}
				pawn1a = 0;
				if (deadNum == 8) {
					winScreen(stage);
				}

			}
			if (pawn2a == 1) {
				System.out.println("knight1, pawn2");
				chessBoard.getChildren().remove(pawn2White);
				chessBoard.add(pawn2, xValues[1], yValues[1]);
				if (checkPawn(xValues[1], yValues[1], xValues[3], yValues[3]) == true) {
					chessBoard.getChildren().remove(pawn2);
					xValues[1] = xValues[3];
					yValues[1] = yValues[3];
					chessBoard.add(pawn2, xValues[1], yValues[1]);
					chessBoard.getChildren().remove(knight2);
					chessBoard.getChildren().remove(knight2White);
					deadPiece[0] = pawn2;
					pawn2a = 0;
					knight2a = 0;
					deadNum = deadNum + 1;
				}
				pawn2a = 0;
				if (deadNum == 8) {
					winScreen(stage);
				}

			}
			if (knight1a == 1) {
				System.out.println("knight2, knight2");
				System.out.println("knight1 removed, knight2 added");
				chessBoard.getChildren().remove(knight1White);
				chessBoard.add(knight1, xValues[2], yValues[2]);
				if (checkKnight(xValues[2], yValues[2], xValues[3], yValues[3]) == true) {
					chessBoard.getChildren().remove(knight1);
					xValues[2] = xValues[3];
					yValues[2] = yValues[3];
					chessBoard.add(knight1, xValues[2], yValues[2]);
					chessBoard.getChildren().remove(knight2);
					chessBoard.getChildren().remove(knight2White);
					deadPiece[2] = knight2;

					knight1a = 0;
					knight2a = 0;
					deadNum = deadNum + 1;
				}
				knight1a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}

			if (bishop1a == 1) {
				System.out.println("knight2 removed, bishop1 added");
				chessBoard.getChildren().remove(bishop1White);
				chessBoard.add(bishop1, xValues[4], yValues[4]);
				if (checkBishop(xValues[4], yValues[4], xValues[3], yValues[3], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishop1);
					xValues[4] = xValues[3];
					yValues[4] = yValues[3];
					chessBoard.add(bishop1, xValues[4], yValues[4]);
					chessBoard.getChildren().remove(knight2);
					chessBoard.getChildren().remove(knight2White);
					deadPiece[4] = knight2;

					bishop1a = 0;
					knight2a = 0;
					deadNum = deadNum + 1;
				}
				bishop1a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
			if (bishop2a == 1) {
				System.out.println("knight2 removed, bishop2 added");
				chessBoard.getChildren().remove(bishop2White);
				chessBoard.add(bishop2, xValues[5], yValues[5]);
				if (checkBishop(xValues[5], yValues[5], xValues[3], yValues[3], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishop2);
					xValues[5] = xValues[3];
					yValues[5] = yValues[3];
					chessBoard.add(bishop2, xValues[5], yValues[5]);
					chessBoard.getChildren().remove(knight2White);
					chessBoard.getChildren().remove(knight2);
					deadPiece[5] = pawn1;

					bishop2a = 0;
					knight2a = 0;
					deadNum = deadNum + 1;
				}
				bishop2a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}
			}
			if (rook1a == 1) {
				System.out.println("pawn1, rook1");
				chessBoard.getChildren().remove(rook1White);
				chessBoard.add(rook1, xValues[6], yValues[6]);
				if (checkRook(xValues[6], yValues[6], xValues[3], yValues[3]) == true) {
					chessBoard.getChildren().remove(rook1);
					xValues[6] = xValues[3];
					yValues[6] = yValues[3];
					chessBoard.add(rook1, xValues[6], yValues[6]);
					chessBoard.getChildren().remove(knight2);
					chessBoard.getChildren().remove(knight2White);
					deadPiece[6] = pawn2;

					rook1a = 0;
					knight2a = 0;
					deadNum = deadNum + 1;
				}
				rook1a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
			if (rook2a == 1) {
				System.out.println("pawn2, rook2");
				chessBoard.getChildren().remove(rook2White);
				chessBoard.add(rook2, xValues[7], yValues[7]);
				if (checkRook(xValues[7], yValues[7], xValues[3], yValues[3]) == true) {
					chessBoard.getChildren().remove(rook2);
					xValues[7] = xValues[3];
					yValues[7] = yValues[3];
					chessBoard.add(rook2, xValues[7], yValues[7]);
					chessBoard.getChildren().remove(knight2);
					chessBoard.getChildren().remove(knight2White);
					deadPiece[7] = pawn2;

					rook2a = 0;
					knight2a = 0;
					deadNum = deadNum + 1;
				}
				rook2a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
		});// if bishopBlack is pressed
		bishop1.setOnAction(event -> {// START FIXING HERE
			System.out.println("There is a bishop here");
			if (bishop1a == 0) {
				System.out.println("bishop1 added");
				chessBoard.getChildren().remove(bishop1);
				chessBoard.add(bishop1White, xValues[4], yValues[4]);
				bishop1a = 1;
			}

			if (pawn1a == 1) {
				System.out.println("bishop2, pawn1");
				chessBoard.getChildren().remove(pawn1White);
				chessBoard.add(pawn1, xValues[0], yValues[0]);
				if (checkPawn(xValues[0], yValues[0], xValues[4], yValues[4]) == true) {
					chessBoard.getChildren().remove(pawn1);
					xValues[0] = xValues[4];
					yValues[0] = yValues[4];
					chessBoard.add(pawn1, xValues[0], yValues[0]);
					chessBoard.getChildren().remove(bishop1);
					chessBoard.getChildren().remove(bishop1White);
					deadPiece[0] = bishop1;
					pawn1a = 0;
					bishop1a = 0;
					deadNum = deadNum + 1;
				}
				pawn1a = 0;
				if (deadNum == 8) {
					winScreen(stage);
				}

			}
			if (pawn2a == 1) {
				System.out.println("bishop1, pawn2");
				chessBoard.getChildren().remove(pawn2White);
				chessBoard.add(pawn2, xValues[1], yValues[1]);
				if (checkPawn(xValues[1], yValues[1], xValues[4], yValues[4]) == true) {
					chessBoard.getChildren().remove(pawn2);
					xValues[1] = xValues[4];
					yValues[1] = yValues[4];
					chessBoard.add(pawn2, xValues[1], yValues[1]);
					chessBoard.getChildren().remove(bishop1);
					chessBoard.getChildren().remove(bishop1White);
					deadPiece[0] = pawn2;
					pawn2a = 0;
					bishop1a = 0;
					deadNum = deadNum + 1;
				}
				pawn2a = 0;
				if (deadNum == 8) {
					winScreen(stage);
				}

			}
			if (knight1a == 1) {
				System.out.println("bishop1 removed, knight2 added");
				chessBoard.getChildren().remove(knight1White);
				chessBoard.add(knight1, xValues[2], yValues[2]);
				if (checkKnight(xValues[2], yValues[2], xValues[4], yValues[4]) == true) {
					chessBoard.getChildren().remove(knight1);
					xValues[2] = xValues[4];
					yValues[2] = yValues[4];
					chessBoard.add(knight1, xValues[2], yValues[2]);
					chessBoard.getChildren().remove(bishop1);
					chessBoard.getChildren().remove(bishop1White);
					deadPiece[2] = bishop1;

					knight1a = 0;
					bishop1a = 0;
					deadNum = deadNum + 1;
				}
				knight1a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
			if (knight2a == 1) {
				System.out.println("bishop1 removed, knight2 added");
				chessBoard.getChildren().remove(knight2White);
				chessBoard.add(knight2, xValues[3], yValues[3]);
				if (checkKnight(xValues[3], yValues[3], xValues[4], yValues[4]) == true) {
					chessBoard.getChildren().remove(knight2);
					xValues[3] = xValues[4];
					yValues[3] = yValues[4];
					chessBoard.add(knight2, xValues[3], yValues[3]);
					chessBoard.getChildren().remove(bishop1);
					chessBoard.getChildren().remove(bishop1White);
					deadPiece[2] = bishop1;

					knight2a = 0;
					bishop1a = 0;
					deadNum = deadNum + 1;
				}
				knight2a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}

			if (bishop2a == 1) {
				System.out.println("bishop1 removed, bishop2 added");
				chessBoard.getChildren().remove(bishop2White);
				chessBoard.add(bishop2, xValues[5], yValues[5]);
				if (checkBishop(xValues[5], yValues[5], xValues[4], yValues[4], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishop1);
					xValues[5] = xValues[4];
					yValues[5] = yValues[4];
					chessBoard.add(bishop2, xValues[5], yValues[5]);
					chessBoard.getChildren().remove(bishop1White);
					chessBoard.getChildren().remove(bishop1);
					deadPiece[5] = bishop1;

					bishop2a = 0;
					bishop1a = 0;
					deadNum = deadNum + 1;
				}
				bishop2a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}
			}
			if (rook1a == 1) {
				System.out.println("bishop1, rook1");
				chessBoard.getChildren().remove(rook1White);
				chessBoard.add(rook1, xValues[6], yValues[6]);
				if (checkRook(xValues[6], yValues[6], xValues[4], yValues[4]) == true) {
					chessBoard.getChildren().remove(rook1);
					xValues[6] = xValues[4];
					yValues[6] = yValues[4];
					chessBoard.add(rook1, xValues[6], yValues[6]);
					chessBoard.getChildren().remove(bishop1);
					chessBoard.getChildren().remove(bishop1White);
					deadPiece[6] = pawn2;

					rook1a = 0;
					bishop1a = 0;
					deadNum = deadNum + 1;
				}
				rook1a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
			if (rook2a == 1) {
				System.out.println("pawn2, rook2");
				chessBoard.getChildren().remove(rook2White);
				chessBoard.add(rook2, xValues[7], yValues[7]);
				if (checkRook(xValues[7], yValues[7], xValues[4], yValues[4]) == true) {
					chessBoard.getChildren().remove(rook2);
					xValues[7] = xValues[4];
					yValues[7] = yValues[4];
					chessBoard.add(rook2, xValues[7], yValues[7]);
					chessBoard.getChildren().remove(bishop1);
					chessBoard.getChildren().remove(bishop1White);
					deadPiece[7] = pawn2;

					rook2a = 0;
					bishop1a = 0;
					deadNum = deadNum + 1;
				}
				rook2a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
		});// if bishopBlack is pressed
		bishop2.setOnAction(event -> {
			if (bishop2a == 0) {
				System.out.println("bishop2 added");
				chessBoard.getChildren().remove(bishop2);
				chessBoard.add(bishop2White, xValues[5], yValues[5]);
				bishop2a = 1;
			}
			if (pawn1a == 1) {
				System.out.println("bishop2, pawn1");
				chessBoard.getChildren().remove(pawn1White);
				chessBoard.add(pawn1, xValues[0], yValues[0]);
				if (checkPawn(xValues[0], yValues[0], xValues[5], yValues[5]) == true) {
					chessBoard.getChildren().remove(pawn1);
					xValues[0] = xValues[5];
					yValues[0] = yValues[5];
					chessBoard.add(pawn1, xValues[0], yValues[0]);
					chessBoard.getChildren().remove(bishop2);
					chessBoard.getChildren().remove(bishop2White);
					deadPiece[0] = bishop2;
					pawn1a = 0;
					bishop2a = 0;
					deadNum = deadNum + 1;
				}
				pawn1a = 0;
				if (deadNum == 8) {
					winScreen(stage);
				}

			}
			if (pawn2a == 1) {
				System.out.println("bishop2, pawn2");
				chessBoard.getChildren().remove(pawn2White);
				chessBoard.add(pawn2, xValues[1], yValues[1]);
				if (checkPawn(xValues[1], yValues[1], xValues[5], yValues[5]) == true) {
					chessBoard.getChildren().remove(pawn2);
					xValues[1] = xValues[5];
					yValues[1] = yValues[5];
					chessBoard.add(pawn2, xValues[1], yValues[1]);
					chessBoard.getChildren().remove(bishop2);
					chessBoard.getChildren().remove(bishop2White);
					deadPiece[0] = pawn2;
					pawn2a = 0;
					bishop2a = 0;
					deadNum = deadNum + 1;
				}
				pawn2a = 0;
				if (deadNum == 8) {
					winScreen(stage);
				}

			}
			if (knight1a == 1) {
				System.out.println("knight1 removed, knight2 added");
				chessBoard.getChildren().remove(knight1White);
				chessBoard.add(knight1, xValues[2], yValues[2]);
				if (checkKnight(xValues[2], yValues[2], xValues[5], yValues[5]) == true) {
					chessBoard.getChildren().remove(knight1);
					xValues[2] = xValues[5];
					yValues[2] = yValues[5];
					chessBoard.add(knight1, xValues[2], yValues[2]);
					chessBoard.getChildren().remove(bishop2);
					chessBoard.getChildren().remove(bishop2White);
					deadPiece[2] = bishop2;

					knight1a = 0;
					bishop2a = 0;
					deadNum = deadNum + 1;
				}
				knight1a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
			if (knight2a == 1) {
				System.out.println("bishop2 removed, knight2 added");
				chessBoard.getChildren().remove(knight2White);
				chessBoard.add(knight2, xValues[3], yValues[3]);
				if (checkKnight(xValues[3], yValues[3], xValues[5], yValues[5]) == true) {
					chessBoard.getChildren().remove(knight2);
					xValues[3] = xValues[5];
					yValues[3] = yValues[5];
					chessBoard.add(knight2, xValues[3], yValues[3]);
					chessBoard.getChildren().remove(bishop2);
					chessBoard.getChildren().remove(bishop2White);
					deadPiece[2] = bishop2;

					knight2a = 0;
					bishop2a = 0;
					deadNum = deadNum + 1;
				}
				knight2a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}

			if (bishop1a == 1) {
				System.out.println("bishop1 removed, bishop2 added");
				chessBoard.getChildren().remove(bishop1White);
				chessBoard.add(bishop1, xValues[4], yValues[4]);
				if (checkBishop(xValues[4], yValues[4], xValues[5], yValues[5], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishop2);
					xValues[4] = xValues[5];
					yValues[4] = yValues[5];
					chessBoard.add(bishop1, xValues[4], yValues[4]);
					chessBoard.getChildren().remove(bishop2White);
					chessBoard.getChildren().remove(bishop2);
					deadPiece[5] = bishop2;

					bishop1a = 0;
					bishop2a = 0;
					deadNum = deadNum + 1;
				}
				bishop1a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}
			}
			if (rook1a == 1) {
				System.out.println("pawn1, rook1");
				chessBoard.getChildren().remove(rook1White);
				chessBoard.add(rook1, xValues[6], yValues[6]);
				if (checkRook(xValues[6], yValues[6], xValues[5], yValues[5]) == true) {
					chessBoard.getChildren().remove(rook1);
					xValues[6] = xValues[5];
					yValues[6] = yValues[5];
					chessBoard.add(rook1, xValues[6], yValues[6]);
					chessBoard.getChildren().remove(bishop2);
					chessBoard.getChildren().remove(bishop2White);
					deadPiece[6] = pawn2;

					rook1a = 0;
					bishop2a = 0;
					deadNum = deadNum + 1;
				}
				rook1a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
			if (rook2a == 1) {
				System.out.println("pawn2, rook2");
				chessBoard.getChildren().remove(rook2White);
				chessBoard.add(rook2, xValues[7], yValues[7]);
				if (checkRook(xValues[7], yValues[7], xValues[5], yValues[5]) == true) {
					chessBoard.getChildren().remove(rook2);
					xValues[7] = xValues[5];
					yValues[7] = yValues[5];
					chessBoard.add(rook2, xValues[7], yValues[7]);
					chessBoard.getChildren().remove(bishop2);
					chessBoard.getChildren().remove(bishop2White);
					deadPiece[7] = pawn2;

					rook2a = 0;
					bishop2a = 0;
					deadNum = deadNum + 1;
				}
				rook2a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
		});// if bishopBlack is pressed
		rook1.setOnAction(event -> {
			if (rook1a == 0) {
				System.out.println("rook1 added");
				chessBoard.getChildren().remove(rook1);
				chessBoard.add(rook1White, xValues[6], yValues[6]);
				rook1a = 1;
			}
			if (pawn1a == 1) {
				System.out.println("bishop2, pawn1");
				chessBoard.getChildren().remove(pawn1White);
				chessBoard.add(pawn1, xValues[0], yValues[0]);
				if (checkPawn(xValues[0], yValues[0], xValues[6], yValues[6]) == true) {
					chessBoard.getChildren().remove(pawn1);
					xValues[0] = xValues[6];
					yValues[0] = yValues[6];
					chessBoard.add(pawn1, xValues[0], yValues[0]);
					chessBoard.getChildren().remove(rook1);
					chessBoard.getChildren().remove(rook1White);
					deadPiece[0] = rook1;
					pawn1a = 0;
					rook1a = 0;
					deadNum = deadNum + 1;
				}
				pawn1a = 0;
				if (deadNum == 8) {
					winScreen(stage);
				}

			}
			if (pawn2a == 1) {
				System.out.println("rook1, pawn2");
				chessBoard.getChildren().remove(pawn2White);
				chessBoard.add(pawn2, xValues[1], yValues[1]);
				if (checkPawn(xValues[1], yValues[1], xValues[6], yValues[6]) == true) {
					chessBoard.getChildren().remove(pawn2);
					xValues[1] = xValues[6];
					yValues[1] = yValues[6];
					chessBoard.add(pawn2, xValues[1], yValues[1]);
					chessBoard.getChildren().remove(rook1);
					chessBoard.getChildren().remove(rook1White);
					deadPiece[0] = pawn2;
					pawn2a = 0;
					rook1a = 0;
					deadNum = deadNum + 1;
				}
				pawn2a = 0;
				if (deadNum == 8) {
					winScreen(stage);
				}

			}
			if (knight1a == 1) {
				System.out.println("knight1 removed, knight2 added");
				chessBoard.getChildren().remove(knight1White);
				chessBoard.add(knight1, xValues[2], yValues[2]);
				if (checkKnight(xValues[2], yValues[2], xValues[6], yValues[6]) == true) {
					chessBoard.getChildren().remove(knight1);
					xValues[2] = xValues[6];
					yValues[2] = yValues[6];
					chessBoard.add(knight1, xValues[2], yValues[2]);
					chessBoard.getChildren().remove(rook1);
					chessBoard.getChildren().remove(rook1White);
					deadPiece[2] = rook1;

					knight1a = 0;
					rook1a = 0;
					deadNum = deadNum + 1;
				}
				knight1a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
			if (knight2a == 1) {
				System.out.println("rook1 removed, knight2 added");
				chessBoard.getChildren().remove(knight2White);
				chessBoard.add(knight2, xValues[3], yValues[3]);
				if (checkKnight(xValues[3], yValues[3], xValues[6], yValues[6]) == true) {
					chessBoard.getChildren().remove(knight2);
					xValues[3] = xValues[6];
					yValues[3] = yValues[6];
					chessBoard.add(knight2, xValues[3], yValues[3]);
					chessBoard.getChildren().remove(rook1);
					chessBoard.getChildren().remove(rook1White);
					deadPiece[2] = rook1;

					knight2a = 0;
					rook1a = 0;
					deadNum = deadNum + 1;
				}
				knight2a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}

			if (bishop1a == 1) {
				System.out.println("bishop1 removed, rook1 added");
				chessBoard.getChildren().remove(bishop1White);
				chessBoard.add(bishop1, xValues[4], yValues[4]);
				if (checkBishop(xValues[4], yValues[4], xValues[6], yValues[6], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishop1);
					xValues[4] = xValues[6];
					yValues[4] = yValues[6];
					chessBoard.add(bishop1, xValues[4], yValues[4]);
					chessBoard.getChildren().remove(rook1White);
					chessBoard.getChildren().remove(rook1);
					deadPiece[6] = rook1;

					bishop1a = 0;
					rook1a = 0;
					deadNum = deadNum + 1;
				}
				bishop1a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}
			}
			if (bishop2a == 1) {
				System.out.println("bishop2 removed, rook1 added");
				chessBoard.getChildren().remove(bishop2White);
				chessBoard.add(bishop2, xValues[5], yValues[5]);
				if (checkBishop(xValues[5], yValues[5], xValues[6], yValues[6], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishop2);
					xValues[5] = xValues[6];
					yValues[5] = yValues[6];
					chessBoard.add(bishop1, xValues[5], yValues[5]);
					chessBoard.getChildren().remove(rook1White);
					chessBoard.getChildren().remove(rook1);
					deadPiece[6] = rook1;

					bishop2a = 0;
					rook1a = 0;
					deadNum = deadNum + 1;
				}
				bishop2a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}
			}
			if (rook2a == 1) {
				System.out.println("pawn2, rook2");
				chessBoard.getChildren().remove(rook2White);
				chessBoard.add(rook2, xValues[7], yValues[7]);
				if (checkRook(xValues[7], yValues[7], xValues[6], yValues[6]) == true) {
					chessBoard.getChildren().remove(rook2);
					xValues[7] = xValues[6];
					yValues[7] = yValues[6];
					chessBoard.add(rook2, xValues[7], yValues[7]);
					chessBoard.getChildren().remove(rook1);
					chessBoard.getChildren().remove(rook1White);
					deadPiece[7] = pawn2;

					rook2a = 0;
					rook1a = 0;
					deadNum = deadNum + 1;
				}
				rook2a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
		});// if bishopBlack is pressed
		rook2.setOnAction(event -> {
			if (rook2a == 0) {
				System.out.println("rook2 added");
				chessBoard.getChildren().remove(rook2);
				chessBoard.add(rook2White, xValues[7], yValues[7]);
				rook2a = 1;
			}
			if (pawn1a == 1) {
				System.out.println("bishop2, pawn1");
				chessBoard.getChildren().remove(pawn1White);
				chessBoard.add(pawn1, xValues[0], yValues[0]);
				if (checkPawn(xValues[0], yValues[0], xValues[7], yValues[7]) == true) {
					chessBoard.getChildren().remove(pawn1);
					xValues[0] = xValues[7];
					yValues[0] = yValues[7];
					chessBoard.add(pawn1, xValues[0], yValues[0]);
					chessBoard.getChildren().remove(rook2);
					chessBoard.getChildren().remove(rook2White);
					deadPiece[0] = rook2;
					pawn1a = 0;
					rook2a = 0;
					deadNum = deadNum + 1;
				}
				pawn1a = 0;
				if (deadNum == 8) {
					winScreen(stage);
				}

			}
			if (pawn2a == 1) {
				System.out.println("rook2, pawn2");
				chessBoard.getChildren().remove(pawn2White);
				chessBoard.add(pawn1, xValues[1], yValues[1]);
				if (checkPawn(xValues[1], yValues[1], xValues[7], yValues[7]) == true) {
					chessBoard.getChildren().remove(pawn2);
					xValues[1] = xValues[7];
					yValues[1] = yValues[7];
					chessBoard.add(pawn2, xValues[1], yValues[1]);
					chessBoard.getChildren().remove(rook2);
					chessBoard.getChildren().remove(rook2White);
					deadPiece[0] = pawn2;
					pawn2a = 0;
					rook2a = 0;
					deadNum = deadNum + 1;
				}
				pawn2a = 0;
				if (deadNum == 8) {
					winScreen(stage);
				}

			}
			if (knight1a == 1) {
				System.out.println("knight1 removed, knight2 added");
				chessBoard.getChildren().remove(knight1White);
				chessBoard.add(knight1, xValues[2], yValues[2]);
				if (checkKnight(xValues[2], yValues[2], xValues[7], yValues[7]) == true) {
					chessBoard.getChildren().remove(knight1);
					xValues[2] = xValues[7];
					yValues[2] = yValues[7];
					chessBoard.add(knight1, xValues[2], yValues[2]);
					chessBoard.getChildren().remove(rook2);
					chessBoard.getChildren().remove(rook2White);
					deadPiece[2] = rook2;

					knight1a = 0;
					rook2a = 0;
					deadNum = deadNum + 1;
				}
				knight1a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}
			if (knight2a == 1) {
				System.out.println("rook2 removed, knight2 added");
				chessBoard.getChildren().remove(knight2White);
				chessBoard.add(knight2, xValues[3], yValues[3]);
				if (checkKnight(xValues[3], yValues[3], xValues[7], yValues[7]) == true) {
					chessBoard.getChildren().remove(knight2);
					xValues[3] = xValues[7];
					yValues[3] = yValues[7];
					chessBoard.add(knight2, xValues[3], yValues[3]);
					chessBoard.getChildren().remove(rook2);
					chessBoard.getChildren().remove(rook2White);
					deadPiece[2] = rook2;

					knight2a = 0;
					rook2a = 0;
					deadNum = deadNum + 1;
				}
				knight2a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}

			if (bishop1a == 1) {
				System.out.println("bishop1 removed, rook2 added");
				chessBoard.getChildren().remove(bishop1White);
				chessBoard.add(bishop1, xValues[4], yValues[4]);
				if (checkBishop(xValues[4], yValues[4], xValues[7], yValues[7], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishop1);
					xValues[4] = xValues[7];
					yValues[4] = yValues[7];
					chessBoard.add(bishop1, xValues[4], yValues[4]);
					chessBoard.getChildren().remove(rook2White);
					chessBoard.getChildren().remove(rook2);
					deadPiece[7] = rook2;

					bishop1a = 0;
					rook2a = 0;
					deadNum = deadNum + 1;
				}
				bishop1a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}
			}
			if (bishop2a == 1) {
				System.out.println("bishop2 removed, rook2 added");
				chessBoard.getChildren().remove(bishop2White);
				chessBoard.add(bishop2, xValues[5], yValues[5]);
				if (checkBishop(xValues[5], yValues[5], xValues[7], yValues[7], xValues, yValues) == true) {
					chessBoard.getChildren().remove(bishop1);
					xValues[5] = xValues[7];
					yValues[5] = yValues[7];
					chessBoard.add(bishop1, xValues[5], yValues[5]);
					chessBoard.getChildren().remove(rook2White);
					chessBoard.getChildren().remove(rook2);
					deadPiece[7] = rook2;

					bishop2a = 0;
					rook2a = 0;
					deadNum = deadNum + 1;
				}
				bishop2a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}
			}
			if (rook1a == 1) {
				System.out.println("pawn2, rook2");
				chessBoard.getChildren().remove(rook1White);
				chessBoard.add(rook1, xValues[6], yValues[6]);
				if (checkRook(xValues[6], yValues[6], xValues[7], yValues[7]) == true) {
					chessBoard.getChildren().remove(rook1);
					xValues[6] = xValues[7];
					yValues[6] = yValues[7];
					chessBoard.add(rook1, xValues[6], yValues[6]);
					chessBoard.getChildren().remove(rook2);
					chessBoard.getChildren().remove(rook2White);
					deadPiece[7] = pawn2;

					rook1a = 0;
					rook2a = 0;
					deadNum = deadNum + 1;
				}
				rook1a = 0;
				if (deadNum == 7) {
					winScreen(stage);
				}

			}

		});// if bishopBlack is pressed

		return chessBoard;
	}

	public static void levelOne(Stage stage) {

		ChessPiece blackPawn = new ChessPiece("pawn", 'b');// black pawn
		Button pawnWhite = ChessPieceButton.createPiece(blackPawn);
		ChessPiece pawn = new ChessPiece("pawn", 'W');// white pawn
		Button pawnW = ChessPieceButton.createPiece(pawn);
		ChessPiece blackQueen = new ChessPiece("queen", 'b');// black queen
		Button queenWhite = ChessPieceButton.createPiece(blackQueen);
		ChessPiece queen = new ChessPiece("queen", 'W');// white queen
		Button queenW = ChessPieceButton.createPiece(queen);
		ChessPiece blackKnight = new ChessPiece("knight", 'b');// black knight
		Button knightWhite = ChessPieceButton.createPiece(blackKnight);
		ChessPiece knight = new ChessPiece("knight", 'W');// white knight
		Button knightW = ChessPieceButton.createPiece(knight);
		ChessPiece blackBishop = new ChessPiece("bishop", 'b');// black bishop
		Button bishopWhite = ChessPieceButton.createPiece(blackBishop);
		ChessPiece bishop = new ChessPiece("bishop", 'W');// white bishop
		Button bishopW = ChessPieceButton.createPiece(bishop);
		GridPane chessBoard = level1ChessBoard(stage, pawnWhite, queenWhite, bishopWhite, knightWhite, pawnW, queenW,
				knightW, bishopW);
		HBox root = new HBox(chessBoard);
		Scene game = new Scene(root, 500, 500);
		game.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.R) {
				pawn1a = 0;
				pawn2a = 0;
				bishop1a = 0;
				bishop2a = 0;
				knight1a = 0;
				rook1a = 0;
				knight2a = 0;
				rook2a = 0;
				knighta = 0;
				rooka = 0;
				whitePawn = 0;
				whiteQueen = 0;
				whiteBishop = 0;
				whiteKnight = 0;
				deadNum = 0;
				levelOne(stage);
			}
		});
		stage.setScene(game);
		stage.show();

	}

	public static void levelTwo(Stage stage) {
		ChessPiece Pawn1 = new ChessPiece("pawn", 'b');// black pawn
		Button pawn1 = ChessPieceButton.createPiece(Pawn1);

		ChessPiece Pawn2 = new ChessPiece("pawn", 'b');// black pawn
		Button pawn2 = ChessPieceButton.createPiece(Pawn2);

		ChessPiece wPawn1 = new ChessPiece("pawn", 'W');// white pawn
		Button pawn1White = ChessPieceButton.createPiece(wPawn1);

		ChessPiece wPawn2 = new ChessPiece("pawn", 'W');// white pawn
		Button pawn2White = ChessPieceButton.createPiece(wPawn1);

		ChessPiece Bishop1 = new ChessPiece("bishop", 'b');// black bishop
		Button bishop1 = ChessPieceButton.createPiece(Bishop1);

		ChessPiece Bishop2 = new ChessPiece("bishop", 'b');// black bishop
		Button bishop2 = ChessPieceButton.createPiece(Bishop2);

		ChessPiece wBishop1 = new ChessPiece("bishop", 'W');// white bishop
		Button bishop1White = ChessPieceButton.createPiece(wBishop1);

		ChessPiece wBishop2 = new ChessPiece("bishop", 'W');// white bishop
		Button bishop2White = ChessPieceButton.createPiece(wBishop2);

		ChessPiece Rook = new ChessPiece("rook", 'b');// white bishop
		Button rook = ChessPieceButton.createPiece(Rook);

		ChessPiece wRook = new ChessPiece("rook", 'W');// white bishop
		Button rookWhite = ChessPieceButton.createPiece(wRook);

		ChessPiece Knight = new ChessPiece("knight", 'b');// white bishop
		Button knight = ChessPieceButton.createPiece(Knight);

		ChessPiece wKnight = new ChessPiece("knight", 'W');// white bishop
		Button knightWhite = ChessPieceButton.createPiece(wKnight);

		GridPane chessBoard = level2Chessboard(stage, pawn1, pawn1White, pawn2, pawn2White, bishop1, bishop1White,
				bishop2, bishop2White, rook, rookWhite, knight, knightWhite);

		HBox root = new HBox(chessBoard);
		Scene game = new Scene(root, 500, 500);
		game.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.R) {
				pawn1a = 0;
				pawn2a = 0;
				bishop1a = 0;
				bishop2a = 0;
				knight1a = 0;
				rook1a = 0;
				knight2a = 0;
				rook2a = 0;
				knighta = 0;
				rooka = 0;
				whitePawn = 0;
				whiteQueen = 0;
				whiteBishop = 0;
				whiteKnight = 0;
				deadNum = 0;
				levelTwo(stage);
			}
		});
		stage.setScene(game);
		stage.show();

	}

	public static void levelThree(Stage stage) {// https://mango-6116.github.io/una-sola/ level 195
		ChessPiece Pawn1 = new ChessPiece("pawn", 'b');// black pawn
		Button pawn1 = ChessPieceButton.createPiece(Pawn1);

		ChessPiece Pawn2 = new ChessPiece("pawn", 'b');// black pawn
		Button pawn2 = ChessPieceButton.createPiece(Pawn2);

		ChessPiece wPawn1 = new ChessPiece("pawn", 'W');// white pawn
		Button pawn1White = ChessPieceButton.createPiece(wPawn1);

		ChessPiece wPawn2 = new ChessPiece("pawn", 'W');// white pawn
		Button pawn2White = ChessPieceButton.createPiece(wPawn1);

		ChessPiece Rook1 = new ChessPiece("rook", 'b');// white bishop
		Button rook1 = ChessPieceButton.createPiece(Rook1);

		ChessPiece wRook1 = new ChessPiece("rook", 'W');// white bishop
		Button rook1White = ChessPieceButton.createPiece(wRook1);

		ChessPiece Rook2 = new ChessPiece("rook", 'b');// white bishop
		Button rook2 = ChessPieceButton.createPiece(Rook2);

		ChessPiece wRook2 = new ChessPiece("rook", 'W');// white bishop
		Button rook2White = ChessPieceButton.createPiece(wRook2);

		ChessPiece Knight1 = new ChessPiece("knight", 'b');// white bishop
		Button knight1 = ChessPieceButton.createPiece(Knight1);

		ChessPiece wKnight1 = new ChessPiece("knight", 'W');// white bishop
		Button knight1White = ChessPieceButton.createPiece(wKnight1);

		ChessPiece Knight2 = new ChessPiece("knight", 'b');// white bishop
		Button knight2 = ChessPieceButton.createPiece(Knight2);

		ChessPiece wKnight2 = new ChessPiece("knight", 'W');// white bishop
		Button knight2White = ChessPieceButton.createPiece(wKnight2);

		GridPane chessBoard = level3Chessboard(stage, pawn1, pawn1White, pawn2, pawn2White, rook1, rook1White, rook2,
				rook2White, knight1, knight1White, knight2, knight2White);
		HBox root = new HBox(chessBoard);
		Scene game = new Scene(root, 500, 500);
		game.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.R) {
				pawn1a = 0;
				pawn2a = 0;
				bishop1a = 0;
				bishop2a = 0;
				knight1a = 0;
				rook1a = 0;
				knight2a = 0;
				rook2a = 0;
				knighta = 0;
				rooka = 0;
				whitePawn = 0;
				whiteQueen = 0;
				whiteBishop = 0;
				whiteKnight = 0;
				deadNum = 0;
				levelThree(stage);
			}
		});
		stage.setScene(game);
		stage.show();
	}
	public static void levelFour(Stage stage) {// https://mango-6116.github.io/una-sola/ level 344
		ChessPiece Pawn1 = new ChessPiece("pawn", 'b');// black pawn
		Button pawn1 = ChessPieceButton.createPiece(Pawn1);

		ChessPiece Pawn2 = new ChessPiece("pawn", 'b');// black pawn
		Button pawn2 = ChessPieceButton.createPiece(Pawn2);

		ChessPiece wPawn1 = new ChessPiece("pawn", 'W');// white pawn
		Button pawn1White = ChessPieceButton.createPiece(wPawn1);

		ChessPiece wPawn2 = new ChessPiece("pawn", 'W');// white pawn
		Button pawn2White = ChessPieceButton.createPiece(wPawn1);

		ChessPiece Rook1 = new ChessPiece("rook", 'b');// white bishop
		Button rook1 = ChessPieceButton.createPiece(Rook1);

		ChessPiece wRook1 = new ChessPiece("rook", 'W');// white bishop
		Button rook1White = ChessPieceButton.createPiece(wRook1);

		ChessPiece Rook2 = new ChessPiece("rook", 'b');// white bishop
		Button rook2 = ChessPieceButton.createPiece(Rook2);

		ChessPiece wRook2 = new ChessPiece("rook", 'W');// white bishop
		Button rook2White = ChessPieceButton.createPiece(wRook2);

		ChessPiece Knight1 = new ChessPiece("knight", 'b');// white bishop
		Button knight1 = ChessPieceButton.createPiece(Knight1);

		ChessPiece wKnight1 = new ChessPiece("knight", 'W');// white bishop
		Button knight1White = ChessPieceButton.createPiece(wKnight1);

		ChessPiece Knight2 = new ChessPiece("knight", 'b');// white bishop
		Button knight2 = ChessPieceButton.createPiece(Knight2);

		ChessPiece wKnight2 = new ChessPiece("knight", 'W');// white bishop
		Button knight2White = ChessPieceButton.createPiece(wKnight2);

		ChessPiece Bishop1 = new ChessPiece("bishop", 'b');// black bishop
		Button bishop1 = ChessPieceButton.createPiece(Bishop1);

		ChessPiece Bishop2 = new ChessPiece("bishop", 'b');// black bishop
		Button bishop2 = ChessPieceButton.createPiece(Bishop2);

		ChessPiece wBishop1 = new ChessPiece("bishop", 'W');// white bishop
		Button bishop1White = ChessPieceButton.createPiece(wBishop1);

		ChessPiece wBishop2 = new ChessPiece("bishop", 'W');// white bishop
		Button bishop2White = ChessPieceButton.createPiece(wBishop2);

		GridPane chessBoard = level4Chessboard(stage, pawn1, pawn1White, pawn2, pawn2White, rook1, rook1White, rook2,
				rook2White, knight1, knight1White, knight2, knight2White, bishop1, bishop1White, bishop2, bishop2White);

		HBox root = new HBox(chessBoard);
		Scene game = new Scene(root, 500, 500);
		game.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.R) {
				pawn1a = 0;//resets all of the numbers of white pieces
				pawn2a = 0;
				bishop1a = 0;
				bishop2a = 0;
				knight1a = 0;
				rook1a = 0;
				knight2a = 0;
				rook2a = 0;
				knighta = 0;
				rooka = 0;
				whitePawn = 0;
				whiteQueen = 0;
				whiteBishop = 0;
				whiteKnight = 0;
				deadNum = 0;
				levelFour(stage);
			}
		});
		stage.setScene(game);
		stage.show();

	}

}