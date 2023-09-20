package finalProject;

import javafx.scene.Group;
import javafx.scene.paint.Color; 
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ChessPiece {
	private String typePiece;
	private char colour;
	public ChessPiece(){}

	public ChessPiece(String typePiece, char colour) {
		this.setPiece(typePiece);
		this.setColour(colour);
	}

	public void setPiece(String typePiece) {
		this.typePiece = typePiece;   
	}
	public void setColour(char colour) {
		this.colour = colour;   
	}
	public String getPiece() {
		return this.typePiece;   
	}
	public char getColour() {
		return this.colour;   
	}


	public static Group createPiece(ChessPiece ChessPiece) {
		Group root = new Group();
		System.out.println(ChessPiece.getPiece());
		switch (ChessPiece.getPiece()) {//a switch case so I can know which type of piece is wanted and what colour it is supposed to be
		
			case "pawn":{//in the case the wanted piece is a pawn 
	           //if the piece wanted is white
	            if (ChessPiece.getColour()=='W') { 
	            Text chessPiece = new Text("\u2659");
	            chessPiece.setFont(Font.font("Arial", 80));
	                chessPiece.setFill(Color.WHITE);
	                root.getChildren().add(chessPiece);
	                break;
	            }
		           //if the piece wanted is black
	            else {
	            	Text chessPiece = new Text("\u265F");
		            chessPiece.setFont(Font.font("Arial", 80));
		                chessPiece.setFill(Color.BLACK);
		                root.getChildren().add(chessPiece);
		                break;
	            }
			}
			
			
			case "rook":{//in the case the wanted piece is a rook 
				//if the piece wanted is white
	            if (ChessPiece.getColour()=='W') { 
	            Text chessPiece = new Text("\u2656");
	            chessPiece.setFont(Font.font("Arial", 80));
	                chessPiece.setFill(Color.WHITE);
	                root.getChildren().add(chessPiece);
	                break;
	            }
		           //if the piece wanted is black
	            else {
	            	Text chessPiece = new Text("\u265E");
		            chessPiece.setFont(Font.font("Arial", 80));
		                chessPiece.setFill(Color.BLACK);
		                root.getChildren().add(chessPiece);
		                break;
	            }
			}
			case "bishop":{//in the case the wanted piece is a bishop 
				//if the piece wanted is white
	            if (ChessPiece.getColour()=='W') { 
	            Text chessPiece = new Text("\u2657");
	            chessPiece.setFont(Font.font("Arial", 80));
	                chessPiece.setFill(Color.WHITE);
	                root.getChildren().add(chessPiece);
	                break;
	            }
		           //if the piece wanted is black
	            else {
	            	Text chessPiece = new Text("\u265D");
		            chessPiece.setFont(Font.font("Arial", 80));
		                chessPiece.setFill(Color.BLACK);
		                root.getChildren().add(chessPiece);
		                break;
	            }
			}
			case "knight":{//in the case the wanted piece is a knight 
				//if the piece wanted is white
	            if (ChessPiece.getColour()=='W') { 
	            Text chessPiece = new Text("\u2658");
	            chessPiece.setFont(Font.font("Arial", 80));
	                chessPiece.setFill(Color.WHITE);
	                root.getChildren().add(chessPiece);
	                break;
	            }
		           //if the piece wanted is black
	            else {
	            	Text chessPiece = new Text("\u265E");
		            chessPiece.setFont(Font.font("Arial", 80));
		                chessPiece.setFill(Color.BLACK);
		                root.getChildren().add(chessPiece);
		                break;
	            }
			}
			case "king":{//in the case the wanted piece is a king 
				//if the piece wanted is white
	            if (ChessPiece.getColour()=='W') { 
	            Text chessPiece = new Text("\u2654");
	            chessPiece.setFont(Font.font("Arial", 80));
	                chessPiece.setFill(Color.WHITE);
	                root.getChildren().add(chessPiece);
	                break;
	            }
		           //if the piece wanted is black
	            else {
	            	Text chessPiece = new Text("\u265A");
		            chessPiece.setFont(Font.font("Arial", 80));
		                chessPiece.setFill(Color.BLACK);
		                root.getChildren().add(chessPiece);
		                break;
	            }
			}
			case "queen":{//in the case the wanted piece is a queen 
				//if the piece wanted is white
	            if (ChessPiece.getColour()=='W') { 
	            Text chessPiece = new Text("\u2655");
	            chessPiece.setFont(Font.font("Arial", 80));
	                chessPiece.setFill(Color.WHITE);
	                root.getChildren().add(chessPiece);
	            }
		           //if the piece wanted is black
	            else {
	            	Text chessPiece = new Text("\u265B");
		            chessPiece.setFont(Font.font("Arial", 80));
		                chessPiece.setFill(Color.BLACK);
		                root.getChildren().add(chessPiece);
	            }
			}
			default:
                System.out.println("This is not implemented!");
                break;
		}
		return root;
	}
}

